/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedungeonv2;

/**
 *
 * @author Usuario
 */
public class Mazmorra {
    public static int DIM_X_MAPA = 60;
    public static int DIM_Y_MAPA = 35;   
    private static Mazmorra m;
    
    
    private int posprota[];  
    private String mapamazmorra =
"###########################################################\n"
                + "#                                                         #\n"
                + "#                                                         #\n"
                + "#       #########################################         #\n"
                + "#       #E......#...E...#.......#......P#.......#         #\n"
                + "#       #$E....E............E...........%...S...#         #\n"
                + "#       #E......#...E...#.......#......P#.......#         #\n"
                + "#       ####################.####################         #\n"
                + "#                       #.....EP#                         #\n"
                + "#                       #......E#                         #\n"
                + "#                       #.......#                         #\n"
                + "#                       ####.####                         #\n"
                + "#                       #PE.....#                         #\n"
                + "#                       #E......#                         #\n"
                + "#                       #.......#                         #\n"
                + "#                       ####.####                         #\n"
                + "#                       #..E....#                         #\n"
                + "#                       #.......#                         #\n"
                + "#                       #...E.. #                         #\n"
                + "#       #########       ####.####                         #\n"
                + "#       #..E$E..#       #.......#                         #\n"
                + "#       #...E...#       #.......#                         #\n"
                + "#       #.......#       #.......#                         #\n"
                + "#       ####.###############%####                         #\n"
                + "#       #...E...#.......#.......#                         #\n"
                + "#       #........E.............E#                         #\n"
                + "#       #..E....#.....E.#.......#                         #\n"
                + "#       ####################.####                         #\n"
                + "#                          #.#                            #\n"
                + "#                         #...#                           #\n"
                + "#                         #...#                           #\n"
                + "#                         #...#                           #\n"
                + "#                         #####                           #\n"
                + "#                                                         #\n"
                + "###########################################################";
    
    public Mazmorra(){
    posprota = new int[2];
    posprota[0] = 28; //posicion x
    posprota[1] = 30; //posicion y
    spawnProta(posprota[0],posprota[1]);
    
    }    
    
    
    public void spawnProta(int coordx, int coordy){
    char tiles[][] = stringToTilemap(mapamazmorra);
    tiles[coordy][coordx] = '@';
    mapamazmorra = tilemapToString(tiles);
    }
    /*
    Convierte el string que representa el mapa 
    a una cuadrícula para poder tratar mejor los movimientos en el mapa
    */
    public char[][] stringToTilemap(String mapa){
        
    char tilemap[][] = new char[DIM_Y_MAPA][DIM_X_MAPA];
    int c = 0;
    
        for (char[] tilemap1 : tilemap) {
            for (int j = 0; j < tilemap1.length && c<mapa.length(); j++, c++) {
                if (mapa.charAt(c)=='\n') {
                    j++;
                } else {
                    tilemap1[j] = mapa.charAt(c);
                }
            }
        }
    
    return tilemap;
    }
    /*
    Convierte el tilemap de nuevo a un string para facilitar la impresión
    */
    public String tilemapToString(char tilemap[][]){
    String mapa = "";
        for (char[] tilemap1 : tilemap) {
            for (int j = 0; j < tilemap1.length; j++) {
                if (j == tilemap1.length - 1) {
                    mapa+="\n";
                } else {
                    mapa += tilemap1[j];
                }
            }
        }
    return mapa;
    }
    
    public void printmatriz(char matriz[][]) {
        
        for (char[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                System.out.print(matriz1[j]);
            }
            System.out.println();
        }
    }
    /*
    Controles usados para moverse por la mazmorra
    */
    public void analogicControl() throws Exception{
        
        String movemsg;
        char dir = MenuManager.controlador();
        switch(dir){
            case 'w':
                movemsg = moveUp();     
                MenuManager.pantalla(movemsg+"\n"+ getEstadomazmorra());
                break;
            case 's':
                MenuManager.pantalla(moveDown() +"\n"+ getEstadomazmorra()); 
                break;
            case 'a':
                MenuManager.pantalla(moveLeft() +"\n"+ getEstadomazmorra()); 
                break;
            case 'd':
                MenuManager.pantalla(moveRight() +"\n"+ getEstadomazmorra()); 
                break;
            case 'q':
                throw new Exception();
            default:
                break;
        }
    }
    
    public static String getEstadomazmorra(){
    return  "Llaves:"+Protagonista.getInstance().getNumllaves()+"                             Segundero:"+ 
                Personaje.getRng()+ "\n"+Mazmorra.getInstance().mapamazmorra+"\n"+Protagonista.getInstance().toString2();
    }
    /*
    Movimientos arriba abajo izd y derecha
    mueven al prota en la direccion indicada si puede hacerlo
    devuelven el mensaje correspondiente de tileDict
    */
    public String moveUp(){ //y-1
        int x = posprota[0];
        int y = posprota[1];
        char tiles[][] = stringToTilemap(mapamazmorra);
        
        char nextLocation = tiles[y-1][x];
        if (canMove(nextLocation)){
            tiles[y-1][x] = tiles[y][x];
            tiles[y][x] = '.';
            posprota[1] = y-1;
        }
        mapamazmorra = tilemapToString(tiles);
        return tileDict(nextLocation);
    }
        
    public String moveDown(){//y+1
        int x = posprota[0];
        int y = posprota[1];
        char tiles[][] = stringToTilemap(mapamazmorra);
        
        char nextLocation = tiles[y+1][x];
        if (canMove(nextLocation)){
            tiles[y+1][x] = tiles[y][x];
            tiles[y][x] = '.';
            posprota[1] = y+1;
        }
        mapamazmorra = tilemapToString(tiles);
        return tileDict(nextLocation);
    }
    
    public String moveLeft(){//x-1
        int x = posprota[0];
        int y = posprota[1];
        char tiles[][] = stringToTilemap(mapamazmorra);
        
        char nextLocation = tiles[y][x-1];
        if (canMove(nextLocation)){
            tiles[y][x-1] = tiles[y][x];
            tiles[y][x] = '.';
            posprota[0] = x-1;
        }
        mapamazmorra = tilemapToString(tiles);
        return tileDict(nextLocation);   
    }
        
    public String moveRight(){//x+1
        int x = posprota[0];
        int y = posprota[1];
        char tiles[][] = stringToTilemap(mapamazmorra);
        
        char nextLocation = tiles[y][x+1];
        if (canMove(nextLocation)){
            tiles[y][x+1] = tiles[y][x];
            tiles[y][x] = '.';
            posprota[0] = x+1;
        }
        mapamazmorra = tilemapToString(tiles);
        return tileDict(nextLocation);      
    }
    
    public String tileDict(char tile){//Evalua el tile e informa
        String movemsg = "";
        switch(tile){
            case '#':
                movemsg = "Te chocas contra la pared";
                break;
            case 'S':
            case 'E':
                movemsg = (!CombatManager.initAnalogicBattle())?"Ese combate fue duro, el tiempo no perdona ":"HAS MUERTO";
                break;
            case 'P':
                movemsg = "Has recogido una pocion. Que bien!";
                break;
            case '$':
                movemsg = "Has recogido una llave. Usala para avanzar en la mazmorra";
                break;
            case '%':
                movemsg = (canMove('%'))? "Usas una llave para abrir la puerta" : "Te chocas contra la puerta";
                break;
            default:
                movemsg = "Avanzando por la mazmorra del tiempo";
                
        }
        return movemsg;
    }
    
    public boolean canMove(char tile){
        boolean canwalk = true;
        switch(tile){
            case '#':
                canwalk = false;
                break;
            case 'S':
                CombatManager.finalbattle = true;
            case 'E':
                canwalk = true;
                break;
            case 'P':
                canwalk = true;
                Protagonista.getInstance().recogerPocion();
                break;
            case '$':
                canwalk = true;
                Protagonista.getInstance().recogerLlaves();
                break;
            case '%':
                canwalk = (Protagonista.getInstance().hasLlaves());
                if (canwalk == true)
                    Protagonista.getInstance().usarLLave();
                break;      
        }
        return canwalk;
    }
    
    public static Mazmorra getInstance(){
    if (m == null)
        m = new Mazmorra();
    return m;
    }
    
    public static void setInstance(Mazmorra maz){
    m = maz;
    }


}

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
public class CombatManager{
    
    public static boolean finalbattle = false;
    public static boolean gameOver = false;
    /*LLeva a cabo UN (1) combate
    Devuelve true si el protagonista ha sobrevivido
    hay que hacer algo para que no se imprima por pantalla en esta funcion
    */
    public static boolean initAnalogicBattle(){
    String protainfo, eneminfo = "", turninfo, enemData, protaData;    
    
    Enemigo.setInstance(SimpleEnemyFactory.createEnemy(Personaje.getRng(), finalbattle));
    
    enemData = Enemigo.getInstance().toString();
    protaData = Protagonista.getInstance().toString();
    
    MenuManager.pantalla("Ha aparecido "+ Enemigo.getInstance().getNombre()+"\n"+enemData+"\n"+protaData);
    
    boolean muerto = true;
    //Dos instancias de personajes van a seguir luchando mientras estén vivos
    while(Enemigo.getInstance().isAlive() && Protagonista.getInstance().isAlive()){
        turninfo ="";
    
        System.out.println("Que vas a hacer");
        protainfo = Protagonista.getInstance().combatOption();
        
        if (!Enemigo.getInstance().isAlive()){
            eneminfo = "Has vencido a "+ Enemigo.getInstance().getNombre();
            if (Protagonista.getInstance().getNivel() != 3)
                   eneminfo+="\nganas "+Enemigo.getInstance().getExpdeenemigo()+" puntos de experiencia";
        }else
            eneminfo = Enemigo.getInstance().combatOption();
    
    
        enemData = Enemigo.getInstance().toString();
        protaData = Protagonista.getInstance().toString();
        
        turninfo+=protainfo+"\n"+eneminfo;
        String general = turninfo+"\n"+enemData+"\n"+protaData;
    
        if (!Enemigo.getInstance().isAlive())
            general = turninfo;
        
        MenuManager.pantalla(general);
    }
    
    if (!Enemigo.getInstance().isAlive()){
        muerto = false;
        Protagonista.getInstance().ganarExp();
        Enemigo.setInstance(null);
    }
    if (!Protagonista.getInstance().isAlive() || (Protagonista.getInstance().isAlive() && finalbattle)){
        gameOver=true;
    }
    
    
    return muerto;
    }

    public void seguirAndando(){
        String continuar = "";
        String msg = (Protagonista.getInstance().isAlive())?"Pulsa enter para continuar tu camino":"Pulsa enter para acabar la aventura";
        do{
            MenuManager.pantalla(msg);
            continuar = MenuManager.escribeTexto();
        }while(!continuar.equals(""));
    }
    

    
    
    }

  
    
    


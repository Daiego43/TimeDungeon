/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedungeonv2;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
class MenuManager{
    public static final String TITULOJUEGO = "\n\n\n\n\n\n\n\n\n\n\n\n\n"+
"                                          ___                       ___           ___                                        \n" +
"                                         /\\  \\          ___        /\\__\\         /\\  \\                                       \n" +
"                                         \\:\\  \\        /\\  \\      /::|  |       /::\\  \\                                      \n" +
"                                          \\:\\  \\       \\:\\  \\    /:|:|  |      /:/\\:\\  \\                                     \n" +
"                                          /::\\  \\      /::\\__\\  /:/|:|__|__   /::\\~\\:\\  \\                                    \n" +
"                                         /:/\\:\\__\\  __/:/\\/__/ /:/ |::::\\__\\ /:/\\:\\ \\:\\__\\                                   \n" +
"                                        /:/  \\/__/ /\\/:/  /    \\/__/~~/:/  / \\:\\~\\:\\ \\/__/                                   \n" +
"                                       /:/  /      \\::/__/           /:/  /   \\:\\ \\:\\__\\                                     \n" +
"                                       \\/__/        \\:\\__\\          /:/  /     \\:\\ \\/__/                                     \n" +
"                                                     \\/__/         /:/  /       \\:\\__\\                                       \n" +
"                                                                   \\/__/         \\/__/                                       \n" +
"                        ___           ___           ___           ___           ___           ___           ___              \n" +
"                       /\\  \\         /\\__\\         /\\__\\         /\\  \\         /\\  \\         /\\  \\         /\\__\\             \n" +
"                      /::\\  \\       /:/  /        /::|  |       /::\\  \\       /::\\  \\       /::\\  \\       /::|  |            \n" +
"                     /:/\\:\\  \\     /:/  /        /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\     /:|:|  |            \n" +
"                    /:/  \\:\\__\\   /:/  /  ___   /:/|:|  |__   /:/  \\:\\  \\   /::\\~\\:\\  \\   /:/  \\:\\  \\   /:/|:|  |__          \n" +
"                   /:/__/ \\:|__| /:/__/  /\\__\\ /:/ |:| /\\__\\ /:/__/_\\:\\__\\ /:/\\:\\ \\:\\__\\ /:/__/ \\:\\__\\ /:/ |:| /\\__\\         \n" +
"                   \\:\\  \\ /:/  / \\:\\  \\ /:/  / \\/__|:|/:/  / \\:\\  /\\ \\/__/ \\:\\~\\:\\ \\/__/ \\:\\  \\ /:/  / \\/__|:|/:/  /         \n" +
"                    \\:\\  /:/  /   \\:\\  /:/  /      |:/:/  /   \\:\\ \\:\\__\\    \\:\\ \\:\\__\\    \\:\\  /:/  /      |:/:/  /          \n" +
"                     \\:\\/:/  /     \\:\\/:/  /       |::/  /     \\:\\/:/  /     \\:\\ \\/__/     \\:\\/:/  /       |::/  /           \n" +
"                      \\::/__/       \\::/  /        /:/  /       \\::/  /       \\:\\__\\        \\::/  /        /:/  /            \n" +
"                       ~~            \\/__/         \\/__/         \\/__/         \\/__/         \\/__/         \\/__/             \n\n"+
"                                             A minigame by Diego Delgado Chaves\n"+
"                                                           Luna De Torres Espejo\n"+
"                                                           Mario Gomez Fernandez\n\n\n\n\n\n\n\n\n\n\n";
    
    public static final String INSTRODUCCION = "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
"@                                      INTRODUCCIÓN                                              @\n" +
"@                                                                                                @\n" +
"@  Oíste hablar de ella hace mucho y por fín te atreves a adentrarte en la MAZMORRA DEL TIEMPO   @\n" +
"@  un misterioso lugar repleto de extrañas y violentas criaturas, en el cual dicen que habita    @\n" +
"@  un ser maligno que controla las vidas de todos.                                               @\n" +
"@  Como no podía ser de otra manera tu mision es acabar con el mal que habita en la mazmorra.    @\n" +
"@  Recuerda siempre que la victoria aguarda a las personas pacientes.				 @\n" +
"@                                                                                                @\n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
"@                                      INSTRUCCIONES                                             @\n" +
"@                                                                                                @\n" +
"@  Time Dungeon es un juego de combates en el que CADA segundo importa, por ello dispones de     @\n" +
"@  un segundero que se actualiza tras cada acción.                                               @\n" +
"@												 @\n" +
"@  Para moverte por la mazmorra debes usar las teclas de direccion W,A,S,D y pulsar intro:       @\n" +
"@  W-Arriba											 @\n" +
"@  S-Abajo											 @\n" +
"@  A-Izquierda										         @\n" +
"@  D-Derecha											 @\n" +
"@  Q-Menu de pausa										 @\n" +
"@												 @\n" +
"@  En el juego tienes 4 opciones de combate:                                                     @\n" +
"@  1-Atacar                                                                                      @\n" +
"@  2-Defender                                                                                    @\n" +
"@  3-Usar una pocion                                                                             @\n" +
"@  4-Ignorar                                                                                     @\n" +
"@  												 @\n" +
"@  Para ganar debes derrotar al jefe final, que se encuentra en la sala tras la última puerta.   @\n" +
"@  Esta leyenda puede servirte de ayuda a la hora de moverte por el mapa:			 @\n" +
"@  '@'--> Protagonista										 @\n" +
"@  '#'--> Pared											 @\n" +
"@  '%'--> Puerta										 @\n" +
"@  '$'--> Llave											 @\n" +
"@  'P'--> Poción										 @\n" +
"@  'E'--> Enemigo										 @\n" +
"@  'S'--> Jefe final										 @\n" +
"@  											         @\n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@";
    
    public static final String MENUPAUSA ="@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
"@          MENÚ DE PAUSA            @\n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
"@                                   @\n" +
"@      1 - Continuar partida	    @\n" +
"@      2 - Salir al menu principal  @\n" +
"@				    @\n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@";
    public static final String MENUPRINCIPAL = 
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
"@           TIME DUNGEON            @\n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
"@				    @\n" +
"@      1 - Nueva partida            @\n" +
"@      2 - Continuar partida	    @\n" +
"@      3 - Introducción e           @\n" +
"@            instrucciones	    @\n" +
"@      4 - Salir del juego          @\n" +
"@                                   @\n" +
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@";
    public static final String GAMEOVER = "      ___           ___           ___           ___                    ___           ___           ___           ___     \n" +
"     /\\  \\         /\\  \\         /\\__\\         /\\  \\                  /\\  \\         /\\__\\         /\\  \\         /\\  \\    \n" +
"    /::\\  \\       /::\\  \\       /::|  |       /::\\  \\                /::\\  \\       /:/  /        /::\\  \\       /::\\  \\   \n" +
"   /:/\\:\\  \\     /:/\\:\\  \\     /:|:|  |      /:/\\:\\  \\              /:/\\:\\  \\     /:/  /        /:/\\:\\  \\     /:/\\:\\  \\  \n" +
"  /:/  \\:\\  \\   /::\\~\\:\\  \\   /:/|:|__|__   /::\\~\\:\\  \\            /:/  \\:\\  \\   /:/__/  ___   /::\\~\\:\\  \\   /::\\~\\:\\  \\ \n" +
" /:/__/_\\:\\__\\ /:/\\:\\ \\:\\__\\ /:/ |::::\\__\\ /:/\\:\\ \\:\\__\\          /:/__/ \\:\\__\\  |:|  | /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\\n" +
" \\:\\  /\\ \\/__/ \\/__\\:\\/:/  / \\/__/~~/:/  / \\:\\~\\:\\ \\/__/          \\:\\  \\ /:/  /  |:|  |/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /\n" +
"  \\:\\ \\:\\__\\        \\::/  /        /:/  /   \\:\\ \\:\\__\\             \\:\\  /:/  /   |:|__/:/  /   \\:\\ \\:\\__\\      |:|::/  / \n" +
"   \\:\\/:/  /        /:/  /        /:/  /     \\:\\ \\/__/              \\:\\/:/  /     \\::::/__/     \\:\\ \\/__/      |:|\\/__/  \n" +
"    \\::/  /        /:/  /        /:/  /       \\:\\__\\                 \\::/  /       ~~~~          \\:\\__\\        |:|  |    \n" +
"     \\/__/         \\/__/         \\/__/         \\/__/                  \\/__/                       \\/__/         \\|__|    ";

   public static final String YOUWIN = "                  ___           ___                    ___                       ___              \n" +
"                 /\\  \\         /\\  \\                  /\\  \\                     /\\  \\             \n" +
"      ___       /::\\  \\        \\:\\  \\                _\\:\\  \\       ___          \\:\\  \\            \n" +
"     /|  |     /:/\\:\\  \\        \\:\\  \\              /\\ \\:\\  \\     /\\__\\          \\:\\  \\           \n" +
"    |:|  |    /:/  \\:\\  \\   ___  \\:\\  \\            _\\:\\ \\:\\  \\   /:/__/      _____\\:\\  \\          \n" +
"    |:|  |   /:/__/ \\:\\__\\ /\\  \\  \\:\\__\\          /\\ \\:\\ \\:\\__\\ /::\\  \\     /::::::::\\__\\         \n" +
"  __|:|__|   \\:\\  \\ /:/  / \\:\\  \\ /:/  /          \\:\\ \\:\\/:/  / \\/\\:\\  \\__  \\:\\~~\\~~\\/__/         \n" +
" /::::\\  \\    \\:\\  /:/  /   \\:\\  /:/  /            \\:\\ \\::/  /   ~~\\:\\/\\__\\  \\:\\  \\               \n" +
" ~~~~\\:\\  \\    \\:\\/:/  /     \\:\\/:/  /              \\:\\/:/  /       \\::/  /   \\:\\  \\              \n" +
"      \\:\\__\\    \\::/  /       \\::/  /                \\::/  /        /:/  /     \\:\\__\\             \n" +
"       \\/__/     \\/__/         \\/__/                  \\/__/         \\/__/       \\/__/             ";
            
  boolean partidacreada=false;      
            
            
            
            
public void pantallaInicio(){
String entrada ="";
do{
    System.out.println(TITULOJUEGO);
    System.out.println("Pulsa enter para comenzar");
    entrada = escribeTexto();
}while(!entrada.equals(""));
}

public void menuInicial(){
do{
    pantalla(MENUPRINCIPAL);
}while(!inicioAction());
}

public void menuPausa(){
do{
    pantalla(MENUPAUSA);
}while(!pausaAction());

}
private boolean pausaAction() {
    char opt = controlador();
    boolean chs;
    switch (opt){
        case '1':    
            jugar();
        case '2':
            chs = false;
        default: 
            chs = true;
    }
    return chs;
}


private boolean inicioAction() {
char opt = controlador();
boolean chs;
switch (opt){
    case '1':
        chs = false;
        nuevaPartida();
        break;
    case '2':
        chs = partidacreada;
        if (chs)
            jugar();
        else
            pantalla("¡NINGUNA PARTIDA CREADA!");
        chs = false;
        break;
    case '3':
        chs = false;
        instroduccion();
        break;
    case '4':
        chs =true;
        break;
    default:
        chs = false;
}
return chs;
}

private void instroduccion() {
        pantalla(INSTRODUCCION+"\n\n\n\n\nPulsa enter para volver al menu principal");
        pulsaEnter();    
}


public void nuevoJugador(){
    System.out.println("Introduzca el nombre del jugador");
    String nombrej = escribeTexto();
    Protagonista p = new Protagonista(nombrej);
    Protagonista.setInstance(p);
}

public void nuevaPartida(){
    CombatManager.finalbattle=false;
    CombatManager.gameOver=false;
    Mazmorra.setInstance(new Mazmorra());
    partidacreada=true;
    nuevoJugador();
    pantalla(Protagonista.getInstance().getNombre()+" se adentra en la mazmorra del tiempo...       (pulsa enter)");
    pulsaEnter();
    jugar();
}

private void jugar() {
    try{
    MenuManager.pantalla(Mazmorra.getEstadomazmorra());
    while(!CombatManager.gameOver){
        Mazmorra.getInstance().analogicControl();
    }
    winLose();
    }catch (Exception e){
        menuPausa();
    }
}

public void winLose(){
    String msg;
    
    if (Protagonista.getInstance().isAlive()){
        msg = "\n\n\n ENhoraBUENA, has sabido adueñarte del tiempo y has superado el desafio de la mazmorra del Tiempo\n"+
               "has derrotado a Satan y salvado las vidas de los futuros aventureros. (has sido habil o solo has tenido suerte?)";
        pantalla(YOUWIN + msg);
    }else{
        msg ="\n\n\n La mazmorra del tiempo se ha cobrado otra victima, pero no te rindas!";
        pantalla(GAMEOVER + msg);
    }
    partidacreada = false;
    pantalla("\nPulsa enter para volver al menu principal");
    pulsaEnter();
}



public static void pantalla(String contenidopantalla){
System.out.println(contenidopantalla);
}

static char controlador() {
    Scanner s = new Scanner(System.in);
    char opt = s.next().charAt(0);
    return opt;
}

static String escribeTexto(){
    Scanner s = new Scanner(System.in);
    String opt = s.nextLine();
    return opt;
}

static void pulsaEnter(){
String entrada = "";
do{
    entrada = escribeTexto();
}while(!entrada.equals(""));
}



 
    
    
    
    
}

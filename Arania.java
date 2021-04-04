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
public class Arania extends Enemigo{
    private static final int VIDARANIA=14;
    private static final String SPRITEARANIA="\n\n\n\n\n\n\n\n\n\n\n\n"+
"          ^^         |         ^^\n" +
"          ::         |         ::\n" +
"   ^^     ::         |         ::     ^^\n" +
"   ::     ::         |         ::     ::\n" +
"    ::     ::        |        ::     ::\n" +
"      ::    ::       |       ::    ::\n" +
"        ::    ::   _/~\\_   ::    ::\n" +
"          ::   :::/     \\:::   ::\n" +
"            :::::(       ):::::\n" +
"                  \\ ___ /\n" +
"             :::::/`   `\\:::::\n" +
"           ::    ::\\o o/::    ::\n" +
"         ::     ::  :\":  ::     ::\n" +
"       ::      ::   ` `   ::      ::\n" +
"      ::      ::           ::      ::\n" +
"     ::      ::             ::      ::\n" +
"     ^^      ::             ::      ^^\n" +
"             ::             ::\n" +
"             ^^             ^^";
    
    
    public Arania(){
     setSprite(SPRITEARANIA);
     setVidamaxima(VIDARANIA);
     setPuntosvida(getVidamaxima());
     setPuntosataque(4);
     setExpdeenemigo(5);
     setEscudo(false);
     setNombre("La Aranya");
     setCombatStyle(new CombateArania());
    }
    

}

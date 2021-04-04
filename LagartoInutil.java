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
public class LagartoInutil extends Enemigo {
private static final int VIDALAGARTO=8;
private static final String SPRITELAGARTO="\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
"        _,\\,\\,\\|\\|\\|\\|\\|\\|\\|\\/-\\___.._\n" +
"     __,-'                           () .\\\n" +
"    /  __/---\\___                __   ---/\n" +
"   |  /          \\ \\___________/\\\\  \\___/\n" +
"   | |            \\ \\            \\\\\n" +
"   | |            / |             \\\\__/_\n" +
"   | |            | \\/_              /\\\n" +
"    ||             \\--\\\n" +
"     ||\n" +
"      \\\\_______\n" +
"       \\-------\\\\____\n";
    
    public LagartoInutil(){
        setSprite(SPRITELAGARTO);
        setVidamaxima(VIDALAGARTO);
        setPuntosvida(getVidamaxima());
        setPuntosataque(1);
        setExpdeenemigo(3);
        setEscudo(false);
        setNombre("Lagarto Inutil");
        setCombatStyle(new CombateLagarto());
    }
}

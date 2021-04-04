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
public class Esqueleto extends Enemigo {
    private static final int VIDAESQUELETO=10;
    private static final String SPRITEESQUELETOBASICO=
"              .7\n" +
"            .'/\n" +
"           / /\n" +
"          / /\n" +
"         / /\n" +
"        / /\n" +
"       / /\n" +
"      / /\n" +
"     / /         \n" +
"    / /          \n" +
"  __|/\n" +
",-\\__\\\n" +
"|f-\"Y\\|\n" +
"\\()7L/\n" +
" cgD                            __ _\n" +
" |\\(                          .'  Y '>,\n" +
"  \\ \\                        / _   _   \\\n" +
"   \\\\\\                       )(_) (_)(|}\n" +
"    \\\\\\                      {  4A   } /\n" +
"     \\\\\\                      \\uLuJJ/\\l\n" +
"      \\\\\\                     |3    p)/\n" +
"       \\\\\\___ __________      /nnm_n//\n" +
"       c7___-__,__-)\\,__)(\".  \\_>-<_/D\n" +
"                  //V     \\_\"-._.__G G_c__.-__<\"/ ( \\\n" +
"                         <\"-._>__-,G_.___)\\   \\7\\\n" +
"                        (\"-.__.| \\\"<.__.-\" )   \\ \\\n" +
"                        |\"-.__\"\\  |\"-.__.-\".\\   \\ \\\n" +
"                        (\"-.__\"\". \\\"-.__.-\".|    \\_\\\n" +
"                        \\\"-.__\"\"|!|\"-.__.-\".)     \\ \\\n" +
"                         \"-.__\"\"\\_|\"-.__.-\"./      \\ l\n" +
"                          \".__\"\"\">G>-.__.-\">       .--,_\n" +
"                              \"\"  G";
    
    
    
    public Esqueleto(){
        setSprite(SPRITEESQUELETOBASICO);
        setVidamaxima(VIDAESQUELETO);
        setPuntosvida(getVidamaxima());
        setPuntosataque(2);
        setExpdeenemigo(4);
        setEscudo(false);
        setNombre("Esqueleto");
        setCombatStyle(new CombateEsqueleto());
    }
    

}

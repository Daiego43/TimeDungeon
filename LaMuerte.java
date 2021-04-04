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
public class LaMuerte extends Enemigo{
    private static final int VIDAMUERTE=9999;
    private static final String SPRITEMUERTE=
"                                           .\"\"--.._\n" +
"                                           []      `'--.._\n" +
"                                           ||__           `'-,\n" +
"                                         `)||_ ```'--..       \\\n" +
"                     _                    /|//}        ``--._  |\n" +
"                  .'` `'.                /////}              `\\/\n" +
"                 /  .\"\"\".\\              //{///    \n" +
"                /  /_  _`\\\\            // `||\n" +
"                | |(_)(_)||          _//   ||\n" +
"                | |  /\\  )|        _///\\   ||\n" +
"                | |L====J |       / |/ |   ||\n" +
"               /  /'-..-' /    .'`  \\  |   ||\n" +
"              /   |  :: | |_.-`      |  \\  ||\n" +
"             /|   `\\-::.| |          \\   | ||\n" +
"           /` `|   /    | |          |   / ||\n" +
"         |`    \\   |    / /          \\  |  ||\n" +
"        |       `\\_|    |/      ,.__. \\ |  ||\n" +
"        /                     /`    `\\ ||  ||\n" +
"       |           .         /        \\||  ||\n" +
"       |                     |         |/  ||\n" +
"       /         /           |         (   ||\n" +
"      /          .           /          )  ||\n" +
"     |            \\          |             ||\n" +
"    /             |          /             ||\n" +
"   |\\            /          |              ||\n" +
"   \\ `-._       |           /              ||\n" +
"    \\ ,//`\\    /`           |              ||\n" +
"     ///\\  \\  |             \\              ||\n" +
"    |||| ) |__/             |              ||\n" +
"    |||| `.(                |              ||\n" +
"    `\\\\` /`                 /              ||\n" +
"       /`                   /              ||\n";
    
    
    
    
    
     public LaMuerte(){
        setSprite(SPRITEMUERTE);
        setVidamaxima(VIDAMUERTE);
        setPuntosvida(VIDAMUERTE);
        setPuntosataque(9999);
        setExpdeenemigo(9999);
        setEscudo(false);
        setNombre("LA MUERTE");
        setCombatStyle(new CombateMuerte());
    }
     

}

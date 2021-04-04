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
public class EsqueletoDeCombate extends Enemigo{
private static final int VIDAESQCOMBATE=18;
private static final String SPRITEESQCOMBATE=
"                              _.--\"\"-._\n" +
"  .                         .\"         \".\n" +
" / \\    ,^.         /(     Y             |      )\\\n" +
"/   `---. |--'\\    (  \\__..'--   -   -- -'\"\"-.-'  )\n" +
"|        :|    `>   '.     l_..-------.._l      .'\n" +
"|      __l;__ .'      \"-.__.||_.-'v'-._||`\"----\"\n" +
" \\  .-' | |  `              l._       _.'\n" +
"  \\/    | |                   l`^^'^^'j\n" +
"        | |                _   \\_____/     _\n" +
"        j |               l `--__)-'(__.--' |\n" +
"        | |               | /`---``-----'\"1 |  ,-----.\n" +
"        | |               )/  `--' '---'   \\'-'  ___  `-.\n" +
"        | |              //  `-'  '`----'  /  ,-'   I`.  \\\n" +
"      _ L |_            //  `-.-.'`-----' /  /  |   |  `. \\\n" +
"     '._' / \\         _/(   `/   )- ---' ;  /__.J   L.__.\\ :\n" +
"      `._;/7(-.......'  /        ) (     |  |            | |\n" +
"      `._;l _'--------_/        )-'/     :  |___.    _._./ ;\n" +
"        | |                 .__ )-'\\  __  \\  \\  I   1   / /\n" +
"        `-'                /   `-\\-(-'   \\ \\  `.|   | ,' /\n" +
"                           \\__  `-'    __/  `-. `---'',-'\n" +
"                              )-._.-- (        `-----'\n" +
"                             )(  l\\ o ('..-.\n" +
"                       _..--' _'-' '--'.-. |\n" +
"                __,,-'' _,,-''            \\ \\\n" +
"               f'. _,,-'                   \\ \\\n" +
"              ()--  |                       \\ \\\n" +
"                \\.  |                       /  \\\n" +
"                  \\ \\                      |._  |\n" +
"                   \\ \\                     |  ()|\n" +
"                    \\ \\                     \\  /\n" +
"                     ) `-.                   | |";
    
    public EsqueletoDeCombate(){
        setSprite(SPRITEESQCOMBATE);
        setVidamaxima(VIDAESQCOMBATE);
        setPuntosvida(getVidamaxima());
        setPuntosataque(15);
        setExpdeenemigo(10);
        setEscudo(true);
        setNombre("Esqueleto de Combate");
        setCombatStyle(new CombateEsqueletocombate());
    }
    

}

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
public class Satan extends Enemigo{
private static final int VIDASATAN=666;
private static final String SPRITESATAN="\n\n\n\n\n\n\n"+
"#########################################################################\n"+
"######################~~..'|.##############.|`..~~#######################\n" +
"##############~./`.~~./' ./ ################ \\. `\\. ~~.`\\.~##############\n" +
"############~.' `.`-'   /   ~#############~ .  \\   `-'.'  `.~############\n" +
"##########~.'    |     |  .'\\ ~##########~ /`.  |     |     `.~##########\n" +
"########~.'      |     |  |`.`._ ~####~ _.'.'|  |     |       `.~########\n" +
"######~.'        `.    |  `..`._|\\.--./|_.'..'  |    .'         `.~######\n" +
"####~.'            \\   | #.`.`._`.'--`.'_.'.'.# |   /             `.~####\n" +
"##~.'       ......  \\  | ###.`~'(o\\||/o)`~'.### |  /  ......        `.~##\n" +
"~.`.......'~      `. \\  \\~####  |\\_  _/|  ####~/  / .'      ~`........'.~\n" +
";.'                 \\ .----.__.'`(n||n)'`.__.----. /                  `;\n" +
"`.                  .'    .'   `. \\`'/ .'   `.    `.                  .'\n" +
"#:               ..':      :    '. ~~ .`    :      :`..               :#\n" +
"#:             .'   :     .'     .'  `.     `.     :   `.             :#\n" +
"#:           .'    .`   .'       . || .       `.   '.    `.           :#\n" +
"#:         .'    .' :       ....'      `....       : `.    `.         :#\n" +
"#:       .'    .' ) )        (      )     (      (    )`.    `.       :#\n" +
"#:     ..'    .  ( ((   )  ) )) (  ((  (  ))  )  ))  ((  `.   `..     :#\n" +
"#:  ..'      .'# ) ) ) (( ( ( (  ) ) ) ))( ( (( ( (  ) ) #`.     `..  :#\n" +
"#;.'        .'##|((  ( ) ) ) ) )( (  (( ( ) )) ) ) )( (||##`.       `.:#\n" +
"#`.        .'###|\\__  )( (( ( ( )  )  )) )  (  (( ( )_)/|###`.       .'#\n" +
"##.`       '#####\\__~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~__/#####`      '.##\n" +
"###        #######  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  #######       ###\n"+
"########################################################################\n";
    
    public int contadorignorancia;
    
    /**
     * El constructor de Satan no hace uso de las funciones setPuntosvida o 
     * setPuntosataque pues los valores de estos dos parámetros son fijos para 
     * este enemigo concreto.
     * Tiene ademas un atributo extra que cuenta las veces que le hemos ignorado
     */
    public Satan(){
    setVidamaxima(VIDASATAN / getNivel());
    setPuntosvida(VIDASATAN);
    setSprite(SPRITESATAN);
    setPuntosataque(2);
    setNombre("Satan");
    setContadorignorancia(0);
    setCombatStyle(new CombateSatan());
    }
    
    public void setContadorignorancia(int c){
    contadorignorancia = c;
    }
    

    
}

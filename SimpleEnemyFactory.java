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
public class SimpleEnemyFactory {
    
    static Enemigo createEnemy(int rng, boolean finalb){
    Enemigo e;
    if(finalb)
        e = new Satan();
    else if(rng%13==0  &&  rng!=0)
        e = new LaMuerte();
    else if(rng%10>=1 && rng%10<=3)
        e = new Esqueleto();
    else if(rng%10>3 && rng%10<=6)
        e = new Arania();
    else if( rng%10>6 && rng%10<=8)
        e = new EsqueletoDeCombate();
    else 
        e = new LagartoInutil();
    return e;
    }
    
}

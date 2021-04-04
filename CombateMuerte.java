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
public class CombateMuerte implements ICombate {

    public CombateMuerte() {
    }

    @Override
    public String accionCombate() {
        return atacar();
    }

    @Override
    public String atacar() {
        int puntosataque = Enemigo.getInstance().getPuntosataque();
        String actionmsg ="E - La Muerte ejecuta un golpe mortal segando tu alma";
        if(Protagonista.getInstance().isDefendiendo())
            actionmsg+="\n    tu escudo no sirve de nada!";
        Protagonista.getInstance().recibirDanio(puntosataque);
        actionmsg+="\n    recibes "+puntosataque+" de daño";
        
        return actionmsg;
    }

    @Override
    public String defender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String objeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

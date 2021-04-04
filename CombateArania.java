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
public class CombateArania implements ICombate {

    public CombateArania() {
        
    }

    @Override
    public String accionCombate() {
        String actionmsg;
        if (Personaje.getRng()%8 == 0)
            actionmsg = objeto();
        else if(Personaje.getRng()%6 == 0)
            actionmsg = "E - La aranya se pone a hacer croche de su tela";
        else 
            actionmsg = atacar();
        return actionmsg;  
    }

    @Override
    public String atacar() {
        String actionmsg = "E - La aranya te da un picotazo";
        int puntosataque = Enemigo.getInstance().getPuntosataque();
        if (Protagonista.getInstance().isDefendiendo()){
            actionmsg+="\n    pero te estabas defendiendo";
            Protagonista.getInstance().protegerDmg(puntosataque);
        }
        else{
            actionmsg+="\n    recibes "+ puntosataque+" de danio";
            Protagonista.getInstance().recibirDanio(puntosataque);
        }
            
        return actionmsg;
    }

    @Override
    public String defender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String objeto() {
        Enemigo.getInstance().curarPs(6);
        return "E - La aranya se hace un ovillo y recupera "+6+" PS\n";
    }
    
    
}

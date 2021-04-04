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
public class CombateLagarto implements ICombate {
    /*
    En los segundos pares ataca
    En los segundos impares suelta una frase chorra
    */
    public CombateLagarto() {
    }

    @Override
    public String accionCombate() {
        String actioninfo;
        if (Personaje.getRng()%2 == 0)
            actioninfo = atacar();
        else
            actioninfo = objeto();
        return actioninfo;
    }

    @Override
    public String atacar() {
        int puntosataque = Enemigo.getInstance().getPuntosataque();
        
        String actionmsg = "E - El lagarto se acerca y te toca";
        if (Protagonista.getInstance().isDefendiendo())
            actionmsg +="\n    pero te estabas defendiendo, tu escudo no ha sufrido daños";
        else{
            actionmsg +="\n    te da tanto asco que recibes "+ puntosataque+" de daño";
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
        String actionmsg ="";
        switch(Personaje.getRng()%10){
        case 1:
            actionmsg+="E - El lagarto recita a Hobbes:\n    'Homo homini lupus'";
            break;
        case 3:
            actionmsg+="E - El lagarto te argumenta que el horóscopo es una ciencia exacta\n";
            break;
        case 5:
            actionmsg+="E - Se ha quedado quieto para ver si así dejas de atacar\n";
            break;
        case 7:
            actionmsg+="E - El lagarto se toma medicina homeópata para sanar sus heridas\n    Se ha curado 0 PS";
            break;
        case 9:
            actionmsg+="E - El secreto para la victoria está en la no accion\n    practicarla hará que comprendamos los motivos de nuestra existencia";
            break;
        }
        
        return actionmsg;
    }

    
}

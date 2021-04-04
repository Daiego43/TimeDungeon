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
public class CombateEsqueleto implements ICombate {

    public CombateEsqueleto() {
    }

    @Override
    public String accionCombate() {
        String actionmsg = "";
        
        if (Personaje.getRng()%5 == 0)
            actionmsg+="E - El esqueleto falla el ataque";
        else if (Personaje.getRng()%10 < 6)
            actionmsg += atacar();
        else
            actionmsg += objeto();
        
        return actionmsg;
    }

    @Override
    public String atacar() {
    String actionmsg ="E - El esqueleto te da un espadazo";
    int puntosataque = Enemigo.getInstance().getPuntosataque();
    
    if(Protagonista.getInstance().isDefendiendo()){
        actionmsg+="\n    pero te estabas defendiendo";
        Protagonista.getInstance().protegerDmg(puntosataque);
    } else {
        actionmsg+="\n    te inflinge "+puntosataque+" de daño";
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
    String actionmsg;
    
    if(Personaje.getRng()%2==0)
        actionmsg="E - El esqueleto te habla: Me pareces un magnífico luchador pero mi compañero, El esqueleto de combate es muchisimo mas duro que yo, puede que lo hayas comprobado.\n"
                + "    pues déjame que te diga que el solamente es vulnerable durante los primeros 10 segundos, asi que no malgastes tu escudo conmigo";
    else
        actionmsg="E - El esqueleto te lanza un hueso creyendo que los humanos funcionan como perros\n"; 
    
    return actionmsg;
    }

    
}

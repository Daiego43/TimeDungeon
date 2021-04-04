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
public class CombateEsqueletocombate implements ICombate {

    public CombateEsqueletocombate() {
        
    }

    @Override
    public String accionCombate() {
    String actioninfo;
    Enemigo.getInstance().setDefendiendo(false);
    if(Personaje.getRng()<=10)
        actioninfo = objeto();
    else if(Personaje.getRng()>10&& Personaje.getRng()<=35)
        actioninfo = defender();
    else 
        actioninfo = atacar();
    
    return actioninfo;    
    }

    @Override
    public String atacar() {
    String actionmsg = "";
    actionmsg +="E - El esqueleto de combate arremente con un poderoso hachazo";
    if (Protagonista.getInstance().isDefendiendo()){
        actionmsg +="\n    pero te estabas defendiendo";
        Protagonista.getInstance().protegerDmg(Enemigo.getInstance().getPuntosataque());
    }else{
        actionmsg+="\n    recibes "+ Enemigo.getInstance().getPuntosataque()+" de daño";
        Protagonista.getInstance().recibirDanio(Enemigo.getInstance().getPuntosataque());
    }
    
    return actionmsg;
    }

    @Override
    public String defender() {
        String actionmsg = "";
        Enemigo.getInstance().setDefendiendo(true);
        if(!Enemigo.getInstance().isEscudo())
            actionmsg = "E - "+Enemigo.getInstance().getNombre()+" mira su mano donde solia tener su fiel escudo y comienza a lloriquear";
        else
            actionmsg = "E - "+Enemigo.getInstance().getNombre()+ "se esta defendiendo";
            
        return actionmsg;
    }

    @Override
    public String objeto() {
    String actionmsg = "";
    actionmsg += "E - El esqueleto de combate se ha puesto a mirar el movil...";
    switch(Personaje.getRng()){
        case 1:
            actionmsg +="\n    'vaya tengo "+(Personaje.getRng()*4)+" nuevos followers!'";
            break;
        case 2:
            actionmsg+="\n    esta jugando al Brawl Stars";
            break;
        case 3:
            actionmsg+="\n   esta jugando al Clash of Clans";
            break;
        case 4:
            actionmsg+="\n    esta jugando al Clash Royale";
            break;
        case 5:
            actionmsg+="\n    se ha puesto a twittear : 'Que tal mi gente de la mazmorra, aqui peleando'";
            break;
        case 6:
            actionmsg+="\n    esta mirando un videotutorial en Youtube sobre programar en java";
            break;
        case 7:
            actionmsg+="\n    se ha puesto a hacerse selfies";
            break;
        case 8:
            actionmsg+="\n    whatsappea con sus colegas esqueletos: 'Chavales alta paliza le estoy dando al tonto este'";
            break;
        case 9:
            actionmsg+="\n    mira el correo electronico a ver si le ha llegado algo de groupon";
            break;
        default:
            actionmsg+="\n    esta seleccionando canciones para su playlist 'A mover el esqueleto!'";
    }
    return actionmsg;
    }
    
}

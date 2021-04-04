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
public class CombateSatan implements ICombate {
    private int contadorignorando;
    public CombateSatan() {
        contadorignorando=0;
    }

    @Override
    public String accionCombate() {
        String actionmsg;
        int rng = Personaje.getRng();
        
        if(Protagonista.getInstance().isIgnorando())
            actionmsg = objeto();
        
        else if (rng<=10 || (rng>20 && rng<=30)||(rng>40 && rng<50))
            actionmsg = atacar();
        else if ((rng > 10 && rng<=20) || (rng >30 && rng<=40))
            actionmsg = defender();
        else
            actionmsg = "E - Satan esta recuperando fuerzas, es vulnerable!!!";
        
        return actionmsg;
    }

    @Override
    public String atacar() {
        String actionmsg="";
        contadorignorando=0;
        int rng = Personaje.getRng();
        int puntosataque = Enemigo.getInstance().getPuntosataque();
        
        if (rng%10 <=3){
            actionmsg+="E - Satan arremete con su crisol maligno";
            if (Protagonista.getInstance().isDefendiendo()){
                actionmsg+="\n    pero te estabas defendiendo";
                Protagonista.getInstance().protegerDmg(puntosataque*2);
            }else{
                actionmsg+="\n    te inflinge "+puntosataque*2+" de daño";
                Protagonista.getInstance().recibirDanio(puntosataque*2);
            }
            
        }else if (rng%10 >3 && rng%10 <=6){
            actionmsg+="E - Satan crea un latigo de fuego y te azota vilmente";
            if (Protagonista.getInstance().isDefendiendo()){
                actionmsg+="\n    pero te estabas defendiendo";
                Protagonista.getInstance().protegerDmg(puntosataque*2);
            }else{
                actionmsg+="\n    te inflinge "+puntosataque*2+" de daño";
                Protagonista.getInstance().recibirDanio(puntosataque*2);
            }
        }else{
            actionmsg+="E - Satan absorbe parte de tu alma";
            if (Protagonista.getInstance().isDefendiendo())
                actionmsg+="\n    tu escudo no sirve de nada!";
            actionmsg+="\n    Recibes "+ puntosataque*3+" de daño y Satan recupera "+ puntosataque*2+" PS";
            Protagonista.getInstance().recibirDanio(puntosataque*3);
            Enemigo.getInstance().curarPs(puntosataque*2);
        }
        
        
        return actionmsg;
    }

    @Override
    public String defender() {
        contadorignorando=0;
        Enemigo.getInstance().setEscudo(true);
        Enemigo.getInstance().setDefendiendo(true);
        return "E - Satan se ha cubierto con sus alas para defenderse";
    }

    @Override
    public String objeto() {
        String actionmsg="";
        contadorignorando ++;
        switch(contadorignorando){
            case 1:
                actionmsg="E - Satan te mira fijamente";
                break;
            case 2:
                actionmsg="E - Satan va a lanzar un ataque devastador";
                break;
            case 3:
                actionmsg="E - Satan comienza a crear una bola de fuego enorme, será mejor que te protejas";
                break;
            case 4:
                actionmsg="E - O sea tu como jugador no estas viendo esta bola de fuego\n    pero es realmente amenazante";
                break;
            case 5:
                actionmsg="E - no me puedo creer que sigas sin hacer nada";
                break;
            case 6:
                actionmsg="E - Este combate iba a ser el mas dificil de todo este juego, el que \n    te pondria una prueba de paciencia y pretendes quedarte ahi sin hacer nada";
                break;
            case 7:
                actionmsg="E - (Satan intenta llamar tu atencion haciendo malabares con las bolas de fuego)";
                break;
            case 8:
                actionmsg="E - SATAN VA A LANZAR UN ATAQUE MORTAL";
                break;
            case 9:
                actionmsg="E - no? Me estas haciendo sentir realmente mal\n    En serio soy tan mal jefe final?";
                break;
            case 10:
                actionmsg="E - (Satan esta visiblemente triste)";
                break;
            case 11:
                actionmsg="E - (Satan hace como que te está ignorando tambien)";
                break;
            case 12:
                actionmsg="E -  Mira me llamare Satan y todo eso pero tu eres peor que yo, eres un aguafiestas";
                break;
            case 13:
                actionmsg="E - (Satan ha abandonado el combate, pero ha dejado una nota)\n    'Me caes mal'\n      -Fdo.Satan"  ;
                break;
        }    
        if (contadorignorando == 13)
            Enemigo.getInstance().setAlive(false);
        
        
        
        return actionmsg;
        }
}

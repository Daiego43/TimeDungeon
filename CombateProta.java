/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedungeonv2;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class CombateProta implements ICombate {
    Scanner s = new Scanner(System.in);
    public CombateProta() {
       
    }

    @Override
    public String accionCombate() { // Esta función se va a utilizar para el combate analogico
        return combateAnalogico();
    }
    public String combateAnalogico(){
        Protagonista.getInstance().setDefendiendo(false);
        String actionmsg;
        char opt = MenuManager.controlador();
        switch (opt){
            case '1':
                actionmsg = atacar();
                break;
            case '2':
                actionmsg = defender();
                break;
            case '3':
                actionmsg = objeto();
                break;
            case '4':
                actionmsg = ignorar();
                break;
            default:
                actionmsg = ignorar();
        
        }
        return actionmsg; 
    }
    
    
    @Override
    public String atacar() {
    String actionmsg = "P - Atacas a "+ Enemigo.getInstance().getNombre();
    
    if (Enemigo.getInstance().isDefendiendo()){
        Enemigo.getInstance().protegerDmg(Protagonista.getInstance().getPuntosataque());
        if ( Enemigo.getInstance().getDurabilidadescudo() == 0)
           actionmsg += "\n    has roto su defensa!";
    }
    else{
        if (Personaje.getRng() >= 55){
            actionmsg += "\n    GOLPE CRITICO!! Le causas el cuadruple de daño";
            Enemigo.getInstance().recibirDanio(Protagonista.getInstance().getPuntosataque() * 4);
        }
        else{
            actionmsg += "\n    le causas "+ Protagonista.getInstance().getPuntosataque()+" de daño";
            Enemigo.getInstance().recibirDanio(Protagonista.getInstance().getPuntosataque());
        }
    }
    return actionmsg;
    }

    @Override
    public String defender() {
        String actionmsg = "P - Usas tu escudo ante el posible ataque";
        Protagonista.getInstance().setDefendiendo(true);
        return actionmsg;  
    }

    @Override
    public String objeto() {
        String actionmsg = "";
        if (Protagonista.getInstance().usarPocion())
            actionmsg = "P - Has usado una pocion, recuperas 15 ps";
        else
            actionmsg = "P - No te quedan pociones!!!";
        return actionmsg;
    }
    
    public String ignorar(){
        Protagonista.getInstance().setIgnorando(true);
        return "P - Decides ignorar a "+ Enemigo.getInstance().getNombre();
    }
}

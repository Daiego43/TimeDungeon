/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedungeonv2;

import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class Personaje {
    
    private static final int ESCUDOBASE=20;
    private static int NIVELINICIAL = 1;
    public static boolean MALO=false;
    public static boolean BUENO=true;
    public static boolean MUERTO=false;
    public static boolean VIVO=true;
    
    private int     rng;
    private int     puntosvida;
    private int     puntosataque;
    private int     nivel;
    private boolean escudo;
    private int     durabilidadescudo;
    private boolean alive;
    private boolean alineamiento;
    private boolean defendiendo;
    private int vidamaxima;
    private String  nombre;
    private ICombate combatStyle;

    /**
     * @return the rng
     */
    public static int getRng() {
        LocalDateTime t = LocalDateTime.now();
        return t.getSecond();
    }

    /**
     * @return the puntosvida
     */
    public int getPuntosvida() {
        if(puntosvida<0)
            puntosvida=0;
        return puntosvida;
    }

    /**
     * @param puntos the puntosvida to set
     */
    public void setPuntosvida(int puntos) {
        if(puntos > vidamaxima)
            this.puntosvida = vidamaxima;
        else
            this.puntosvida = puntos;  
    }
    /**
     * @return the puntosataque
     */
    public int getPuntosataque() {
        return puntosataque;
    }

    /**
     * @param puntosataque the puntosataque to set
     */
    public void setPuntosataque(int puntosataque) {
        if(this.alineamiento==MALO)
            if(this.nivel==1)
                this.puntosataque=puntosataque;
        else
            this.puntosataque=puntosataque+ nivel;
        if(this.alineamiento==BUENO)
            this.puntosataque=puntosataque*nivel;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    public void setNivel() {
        this.nivel = NIVELINICIAL;
    }

    /**
     * @return the escudo
     */
    public boolean isEscudo() {
        return escudo;
    }

    /**
     * @param escudo the escudo to set
     * Si eres bueno y el día de hoy es par -> Tienes escudo
     * Si eres malo, depende del parametro introducido
     */
    public void setEscudo(boolean escudo) {
        LocalDateTime t = LocalDateTime.now();
        if(this.alineamiento==BUENO && t.getDayOfMonth()%2==0){
            this.escudo=true;
            setDurabilidadescudo();
        }else{
            this.escudo=escudo;
            if(this.escudo)
            	setDurabilidadescudo();
        }
    }

    /**
     * @return the durabilidadescudo
     */
    public int getDurabilidadescudo() {
        if(durabilidadescudo<0)
            return 0;
        else
        return durabilidadescudo;
    }

    /**
     */
    public void setDurabilidadescudo() {
        if(this.isAlineamiento()==BUENO && isEscudo())
             durabilidadescudo = ESCUDOBASE;   
        else
            durabilidadescudo = ESCUDOBASE;
    }
    
    public void protegerDmg(int dmg){
        int dmgrestante = dmg/2 - durabilidadescudo;
        durabilidadescudo -= dmg/2;
        if (durabilidadescudo <= 0){
            setEscudo(false);
            recibirDanio(dmgrestante);
        }
            
    
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the alineamiento
     */
    public boolean isAlineamiento() {
        return alineamiento;
    }

    /**
     * @param alineamiento the alineamiento to set
     */
    public void setAlineamiento(boolean alineamiento) {
        this.alineamiento = alineamiento;
    }

    /**
     * @return the defendiendo
     */
    public boolean isDefendiendo() {
        return defendiendo;
    }

    /**
     * @param defendiendo the defendiendo to set
     */
    public void setDefendiendo(boolean defendiendo) {
        if(escudo)
            this.defendiendo = defendiendo;
        else
            defendiendo = false;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param aNIVELINICIAL the NIVELINICIAL to set
     */
    public static void setNIVELINICIAL(int aNIVELINICIAL) {
        NIVELINICIAL = aNIVELINICIAL;
    }
    
    
    public void curarPs(int cura){
        this.setPuntosvida(this.getPuntosvida() + cura);
    }
    
    public void recibirDanio(int dmg){
        this.setPuntosvida(this.puntosvida - dmg);
        if(this.getPuntosvida() == 0)
            this.setAlive(MUERTO);
    }

    /**
     * @return the vidamaxima
     */
    public int getVidamaxima() {
        return vidamaxima;
    }

    /**
     * @param vidamaxima the vidamaxima to set
     */
    public void setVidamaxima(int vidamaxima) {
            this.vidamaxima = vidamaxima * nivel;
    }

    /**
     * @return the combatStyle
     */
    public ICombate getCombatStyle() {
        return combatStyle;
    }

    /**
     * @param combatStyle the combatStyle to set
     */
    public void setCombatStyle(ICombate combatStyle) {
        this.combatStyle = combatStyle;
    }
    
    public String combatOption(){
    return this.getCombatStyle().accionCombate();
    }
    
    @Override
    public String toString(){
    return getNombre() +" | PS:"+getPuntosvida()+" / "+ getVidamaxima() +" | PE:"+ getDurabilidadescudo()+" | Nv: "+getNivel();
    }
    
    
}

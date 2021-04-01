/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epdfinal;

/**
 * Personaje simboliza la entidad básica en el juego
 * En el juego nunca se crea directamente un objeto de esta clase pues sirve como
 * molde de las caracteristicas que van a poseer o no sus hijas.
 * 
 * Personaje no implementa ICombate pues un personaje es un objeto mas abstracto,
 * en una version más avanzada habria añadido un personaje que no implementa la ICombate
 * y que implementaria una IComercio, esta habría sido la clase tendero.
 * 
 * @author Daiego
 */
public abstract class Personaje implements Comparable{
    
    public static final int ESCUDOBASE=20;
    public static final int DEBIL=1;
    public static final int MEDIO=2;
    public static final int FUERTE=3;
    public static boolean MALO=false;
    public static boolean BUENO=true;
    public static boolean MUERTO=false;
    public static boolean VIVO=true;
    /**
     * stataleatorio es la piedra angular del juego, en base a al estado del 
     * mismo se toman multitud de decisiones como el nivel de los enemigos,
     * acertar los ataques o decidir que opcion de ataque va a lanzar nuestro
     * oponente
     */
    public String exceptionvector[]={"No existe dicho control","Intentaste chocar contra una pared","Evento desconocido","Chocas contra la puerta"};
    public Fecha2  stataleatorio;
    public int     puntosvida;
    public int     puntosataque;
    public int     nivel;
    public boolean escudo;
    public int     durabilidadescudo;
    /**
     * Establece si el personaje es bueno o malo
     */
    public boolean alineamiento;
    /**
     * Establece si el personaje está vivo o muerto
     * el estado se modifica cuando, al recibir daños, los PS del personaje son 
     * menores o iguales a cero, en cuyo caso el estado cambia a MUERTO
     */
    public boolean estado;
    private String nombre;
    /**
     * Establece cuando el personaje se defiende o no de un ataque
     */
    public boolean defendiendo;
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    /**
     * @return the stataleatorio
     */
    public Fecha2 getStataleatorio() {
        return stataleatorio;
    }
    /**
     * stataleatorio se setea y depende de en qué momento se crea
     */
    public void setStataleatorio() {
        Fecha2 f = Fecha2.ahora();
        this.stataleatorio = f;
    }
    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }
    /**
     * El nivel del personaje se setea segun el valor aleatorio,
     * si el personaje es bueno, siempre empieza con nivel 1
     */
    public void setNivel(){
    if(this.alineamiento==MALO){
        if(this.stataleatorio.getSegundos()<=30)
            this.nivel=DEBIL;
        else if(this.stataleatorio.getSegundos()>30 && this.stataleatorio.getSegundos()<=50)
            this.nivel=MEDIO;
        else if(this.stataleatorio.getSegundos()>50 && this.stataleatorio.getSegundos()<=60)
            this.nivel=FUERTE;
      }  
    else if(this.alineamiento==BUENO){
          this.nivel=DEBIL;
      }        
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
     * Recibe un entero que representa los puntos de vida, se evalúa cual es el
     * alineamiento del personaje y luego se setean dichos puntos de vida.
     * Para los personajes malos sus puntos de vida se ven multiplicados por el
     * nivel que tengan.
     * @param puntos 
     */
    public void setPuntosvida(int puntos) {
        if(this.alineamiento==MALO)
          this.puntosvida=puntos*this.nivel;
        
        else if(this.alineamiento==BUENO)
          this.puntosvida=puntos;    
    }
    /**
     * @return the escudo
     */
    public boolean isEscudo() {
        return escudo;
    }
    /**
     * @param escudo decide si el personaje tiene escudo
     */
    public void setEscudo(boolean escudo){
        if(this.alineamiento==BUENO){
            if(this.stataleatorio.getDia()%2==0){
                this.escudo=true;
                setDurabilidadescudo();
            }
            else{
                this.escudo=escudo;
                setDurabilidadescudo();
            }
              
        }
        
        else if(this.alineamiento==MALO){
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
     *  setea la capacidad del escudo
     *  Para los personajes buenos es constante, para los malos varía segun el 
     * dia en el que nos encontremos
     */
    public void setDurabilidadescudo(){
        if(this.isAlineamiento()==BUENO&& isEscudo())
             durabilidadescudo = ESCUDOBASE;   
        else if(this.isAlineamiento()==MALO){
             durabilidadescudo=this.stataleatorio.getDia();
        }
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
    public void setPuntosataque(int atac){
        if(this.alineamiento==MALO)
            if(this.nivel==DEBIL)
                this.puntosataque=atac;
        else
            this.puntosataque=atac+this.nivel;
        if(this.alineamiento==BUENO)
            this.puntosataque=atac;
    }
    public int getPuntosataque(){
        return puntosataque;
    }
    public boolean isEstado(){
        return estado;
    }
    /**
    * Establece si el peronaje esta VIVO o MUERTO
     * @param estado
    */
    public void setEstado(boolean estado){
        this.estado=estado;
    }  
    public void recibirDanos(int dano){
        this.puntosvida-=dano;
        if(this.puntosvida<=0)
            setEstado(MUERTO);
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
        this.defendiendo = defendiendo;
    }

    @Override
    public int compareTo(Object t) {
        int cmp;
        Enemigo p =(Enemigo)t;
        if(this.getPuntosataque()== p.getPuntosataque())
            cmp=0; 
        else if(this.getPuntosataque()<p.getPuntosataque())
            cmp=1;
        else
            cmp=-1;
        
        return cmp;
    }
}

    
    
  


   
    


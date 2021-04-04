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
public class Protagonista extends Personaje{
    private static Protagonista p;
    
    private static final int ATAQUEBASE=4;
    public static final int VIDABASE=20;
    public static final int EXPNV=20;
    
    private int nivelexp;
    private int numpociones;
    private boolean ignorando;
    private int numllaves;
    
    public Protagonista(String nombre){
    setNombre(nombre);
    setAlive(VIVO);
    setAlineamiento(BUENO);
    setNivel();
    setEscudo(true);
    setVidamaxima(VIDABASE);
    setPuntosvida(getVidamaxima());
    setPuntosataque(ATAQUEBASE);
    setNivel();
    setCombatStyle(new CombateProta());
    setNivelexp(0);
    setNumpociones(3);
    setNumllaves(0);
    }

    /**
     * @return the nivelexp
     */
    public int getNivelexp() {
        return nivelexp;
    }

    /**
     * @param nivelexp the nivelexp to set
     */
    public void setNivelexp(int nivelexp) {
        if(nivelexp<0)
            this.nivelexp = 0;
        else 
            this.nivelexp = nivelexp;
    }

    /**
     * @return the numpociones
     */
    public int getNumpociones() {
        return numpociones;
    }

    /**
     * @param numpociones the numpociones to set
     */
    public void setNumpociones(int numpociones) {
        if (numpociones <= 0)
            this.numpociones = 0;
        else
            this.numpociones = numpociones;
    }

    /**
     * @return the ignorando
     */
    public boolean isIgnorando() {
        return ignorando;
    }

    /**
     * @param ignorando the ignorando to set
     */
    public void setIgnorando(boolean ignorando) {
        this.ignorando = ignorando;
    }
    
    
    
    public boolean hasLlaves(){
    return numllaves > 0;
    }
    /**
     * @return the numllaves
     */
    public int getNumllaves() {
        return numllaves;
    }
    
    
    
    /**
     * @param numllaves the numllaves to set
     */
    public void setNumllaves(int numllaves) {
        if (numllaves <= 0)
            this.numllaves = 0;
        else
            this.numllaves = numllaves;
    }
    
    public void ganarExp(){
        int exp = Enemigo.getInstance().getExpdeenemigo();
        nivelexp += exp;
        if(nivelexp >= EXPNV)
            subirNivel();
        
        
    }
    /*
    Cuando subes de nivel suben de nivel todos 
    los enemigos que se creen.
    Cuando subes de nivel aumenta tu salud maxima y tus puntos de ataque
    */
    public void subirNivel(){
        Personaje.setNIVELINICIAL(2);
        setNivel();
        setNivelexp(0);
        setVidamaxima(VIDABASE*getNivel());
        setPuntosvida(VIDABASE*getNivel());
        setPuntosataque(ATAQUEBASE);
        
    }
    
    public boolean usarPocion(){
        boolean b;
        if (getNumpociones() != 0){
            curarPs(15);
            setNumpociones(getNumpociones() - 1);
            b=true;
        }else
            b=false;
        return b;
    }
    
    public void recogerPocion(){
        numpociones++;
    }
    
    public void usarLLave(){
        setNumllaves(getNumllaves() - 1 );
    }
    public void recogerLlaves(){
        numllaves++;
    }
    public static Protagonista getInstance(){
    if (p == null)
        p = new Protagonista("Player");
    return p;
    }
    
    
    public static void setInstance(Protagonista p){
    Protagonista.p = p;
    }
    
    
    @Override
    public String toString(){
        String s;
        
        s=getNombre()+" Lvl "+getNivel()+"                    Segundero: "+Personaje.getRng()+"\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
        
        switch(getNivel()){
            case 1: 
                if(getPuntosvida()<10)
                    s+="% PV: 0"+getPuntosvida()+"/"+VIDABASE+"     ";
                else{
                s+="% PV: "+getPuntosvida()+"/"+VIDABASE+"     ";
                }
                break;
            case 2: 
                if(getPuntosvida()<10)
                    s+="% PV: 0"+getPuntosvida()+"/"+VIDABASE*2+"     ";
                else{
                s+="% PV: "+getPuntosvida()+"/"+VIDABASE*2+"     ";
                }
                break;
            case 3: 
                if(getPuntosvida()<10)
                    s+="% PV: 0"+getPuntosvida()+"/"+VIDABASE*2+"     ";
                else{
                s+="% PV: "+getPuntosvida()+"/"+VIDABASE*3+"     ";
                }
                break;
        }   
        switch(getNivel()){
            case 1:
                s+=" EXP: "+nivelexp+"/"+EXPNV;
                break;
            case 2:
                s+=" EXP: "+nivelexp+"/"+EXPNV*2;
                break; 
            case 3:
                s+=" EXP: MAX";
                break;
        }
        
       if(this.isEscudo()==true){
           if(getDurabilidadescudo()<10)
               s+="        PE 0"+getDurabilidadescudo()+"    %\n";
           else
               s+="        PE "+getDurabilidadescudo()+"     %\n";
       }
       else
            s+="                  %\n";
                    
                    
        s+="%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n"
         + "% 1-Atacar           |   2-Defender         %\n"
         + "% *Inflinges "+getPuntosataque()+" ptos  |   *Te defiendes de   %\n"
         + "%  de daño           |    un posible ataque %\n"
         + "%  ------------------+----------------------%\n"
         + "% 3-Pociones x "+getNumpociones()+"     |   4-Ignorar          %\n"
         + "% *Restaura 15 PS    |    *No haces nada    %\n"
         + "%                    |                      %\n"
         + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";  
         
      
        return s;       
    }
    
    public String toString2(){
         String s;
        
        s=getNombre()+" Lvl "+getNivel()+"\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
        
        switch(getNivel()){
            case 1: 
                if(getPuntosvida()<10)
                    s+="% PV: 0"+getPuntosvida()+"/"+VIDABASE+"     ";
                else{
                s+="% PV: "+getPuntosvida()+"/"+VIDABASE+"     ";
                }
                break;
            case 2: 
                if(getPuntosvida()<10)
                    s+="% PV: 0"+getPuntosvida()+"/"+VIDABASE*2+"     ";
                else{
                s+="% PV: "+getPuntosvida()+"/"+VIDABASE*2+"     ";
                }
                break;
            case 3: 
                if(getPuntosvida()<10)
                    s+="% PV: 0"+getPuntosvida()+"/"+VIDABASE*3+"     ";
                else{
                s+="% PV: "+getPuntosvida()+"/"+VIDABASE*4+"     ";
                }
                break;
        }   
        switch(getNivel()){
            case 1:
                s+=" EXP: "+nivelexp+"/"+EXPNV;
                break;
            case 2:
                s+=" EXP: "+nivelexp+"/"+EXPNV*2;
                break; 
            case 3:
                s+=" EXP: MAX";
                break;
        }
        
       if(this.isEscudo()==true){
           if(getDurabilidadescudo()<10)
               s+="        PE 0"+getDurabilidadescudo()+"    %\n";
           else
               s+="        PE "+getDurabilidadescudo()+"     %\n";
       }
       else
            s+="                  %\n";
                    
                    
        s+="%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
        
        return s;
    
    }
}

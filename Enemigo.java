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
public class Enemigo extends Personaje{
    public static Enemigo e;
    
    private int expdeenemigo;
    private String sprite;
    
    public Enemigo(){
    setAlineamiento(MALO);
    setAlive(VIVO);
    setNivel();
    }

    /**
     * @return the expdeenemigo
     */
    public int getExpdeenemigo() {
        return expdeenemigo;
    }

    /**
     * @param expdeenemigo the expdeenemigo to set
     */
    public void setExpdeenemigo(int expdeenemigo) {
        this.expdeenemigo = expdeenemigo * getNivel();
    }

    /**
     * @return the sprite
     */
    public String getSprite() {
        return sprite;
    }

    /**
     * @param sprite the sprite to set
     */
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
    //Para definir el objeto
    public static void setInstance(Enemigo e){
        Enemigo.e = e;
    }
    @Override
    public String toString(){
        String enemData="";
        enemData += getSprite();
        enemData+="\n"+getNombre()+" Lvl:"+getNivel()+" PS:"+getPuntosvida()+"/"+getVidamaxima();
        if(isEscudo())
            enemData+="   PE:"+getDurabilidadescudo();
        return enemData;
    }
    public static Enemigo getInstance(){
    if(e == null)
        e = SimpleEnemyFactory.createEnemy(Personaje.getRng(), false);
    return e;
    }
}

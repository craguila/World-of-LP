/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

public class Sprite {
    private final int lado;
    
    private int x;
    private int y;
    
    public int[] pixeles;
    private HojaSprites hoja;
    
    //sprites del personaje
    public static final Sprite ABAJO0 = new Sprite(32,0,1,HojaSprites.nivel1);
    public static final Sprite ABAJO1 = new Sprite(32,1,1,HojaSprites.nivel1);
    public static final Sprite ABAJO2 = new Sprite(32,2,1,HojaSprites.nivel1);
    
    public static final Sprite IZQUIERDA0 = new Sprite(32,0,2,HojaSprites.nivel1);
    public static final Sprite IZQUIERDA1 = new Sprite(32,1,2,HojaSprites.nivel1);
    public static final Sprite IZQUIERDA2 = new Sprite(32,2,2,HojaSprites.nivel1);
    
    public static final Sprite DERECHA0 = new Sprite(32,0,3,HojaSprites.nivel1);
    public static final Sprite DERECHA1 = new Sprite(32,1,3,HojaSprites.nivel1);
    public static final Sprite DERECHA2 = new Sprite(32,2,3,HojaSprites.nivel1);
    
    public static final Sprite ARRIBA0 = new Sprite(32,0,4,HojaSprites.nivel1);
    public static final Sprite ARRIBA1 = new Sprite(32,1,4,HojaSprites.nivel1);
    public static final Sprite ARRIBA2 = new Sprite(32,2,4,HojaSprites.nivel1);
    //fin de la coleccion
    
    //coleccion de sprites
    public static Sprite VACIO = new Sprite(32,0);
    public static Sprite PASTO = new Sprite(32,0,0,HojaSprites.nivel1);
    public static Sprite ARENA = new Sprite(32,1,0,HojaSprites.nivel1);
    public static Sprite AGUA = new Sprite(32,2,0,HojaSprites.nivel1);
    public static Sprite MURO = new Sprite(32,3,0,HojaSprites.nivel1);
    
    //fin de la coleccion
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
        this.lado = lado;
        pixeles = new int[lado * lado];
        this.x = columna * lado;
        this.y = fila*lado;
        this.hoja = hoja;
        for (int y = 0; y<lado;y++){
            for (int x=0;x<lado;x++){
                pixeles[x+y*lado]=hoja.pixeles[(x + this.x) +(y+this.y)*hoja.getAncho()];
            }
        }
    }
    
    public Sprite(final int lado, final int color){
        this.lado = lado;
        pixeles = new int[lado*lado];
        for (int i=0; i < pixeles.length; i++){
            pixeles[i]=color;
        }
    }
    
    public int getLado(){
        return lado;
    }
}

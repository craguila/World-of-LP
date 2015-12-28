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
    
    //sprites del guerrero
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
    //sprites del arquero
    public static final Sprite AABAJO0 = new Sprite(32,3,1,HojaSprites.nivel1);
    public static final Sprite AABAJO1 = new Sprite(32,4,1,HojaSprites.nivel1);
    public static final Sprite AABAJO2 = new Sprite(32,5,1,HojaSprites.nivel1);
    
    public static final Sprite AIZQUIERDA0 = new Sprite(32,3,2,HojaSprites.nivel1);
    public static final Sprite AIZQUIERDA1 = new Sprite(32,4,2,HojaSprites.nivel1);
    public static final Sprite AIZQUIERDA2 = new Sprite(32,5,2,HojaSprites.nivel1);
    
    public static final Sprite ADERECHA0 = new Sprite(32,3,3,HojaSprites.nivel1);
    public static final Sprite ADERECHA1 = new Sprite(32,4,3,HojaSprites.nivel1);
    public static final Sprite ADERECHA2 = new Sprite(32,5,3,HojaSprites.nivel1);
    
    public static final Sprite AARRIBA0 = new Sprite(32,3,4,HojaSprites.nivel1);
    public static final Sprite AARRIBA1 = new Sprite(32,4,4,HojaSprites.nivel1);
    public static final Sprite AARRIBA2 = new Sprite(32,5,4,HojaSprites.nivel1);
    //fin de la coleccion    
    //sprites del mago
    public static final Sprite MABAJO0 = new Sprite(32,0,5,HojaSprites.nivel1);
    public static final Sprite MABAJO1 = new Sprite(32,1,5,HojaSprites.nivel1);
    public static final Sprite MABAJO2 = new Sprite(32,2,5,HojaSprites.nivel1);
    
    public static final Sprite MIZQUIERDA0 = new Sprite(32,0,6,HojaSprites.nivel1);
    public static final Sprite MIZQUIERDA1 = new Sprite(32,1,6,HojaSprites.nivel1);
    public static final Sprite MIZQUIERDA2 = new Sprite(32,2,6,HojaSprites.nivel1);
    
    public static final Sprite MDERECHA0 = new Sprite(32,0,7,HojaSprites.nivel1);
    public static final Sprite MDERECHA1 = new Sprite(32,1,7,HojaSprites.nivel1);
    public static final Sprite MDERECHA2 = new Sprite(32,2,7,HojaSprites.nivel1);
    
    public static final Sprite MARRIBA0 = new Sprite(32,0,8,HojaSprites.nivel1);
    public static final Sprite MARRIBA1 = new Sprite(32,1,8,HojaSprites.nivel1);
    public static final Sprite MARRIBA2 = new Sprite(32,2,8,HojaSprites.nivel1);
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

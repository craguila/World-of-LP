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
    //sprites del murcielago
    public static final Sprite MUABAJO0 = new Sprite(32,3,5,HojaSprites.nivel1);
    public static final Sprite MUABAJO1 = new Sprite(32,4,5,HojaSprites.nivel1);
    public static final Sprite MUABAJO2 = new Sprite(32,5,5,HojaSprites.nivel1);
    
    public static final Sprite MUIZQUIERDA0 = new Sprite(32,3,6,HojaSprites.nivel1);
    public static final Sprite MUIZQUIERDA1 = new Sprite(32,4,6,HojaSprites.nivel1);
    public static final Sprite MUIZQUIERDA2 = new Sprite(32,5,6,HojaSprites.nivel1);
    
    public static final Sprite MUDERECHA0 = new Sprite(32,3,7,HojaSprites.nivel1);
    public static final Sprite MUDERECHA1 = new Sprite(32,4,7,HojaSprites.nivel1);
    public static final Sprite MUDERECHA2 = new Sprite(32,5,7,HojaSprites.nivel1);
    
    public static final Sprite MUARRIBA0 = new Sprite(32,3,8,HojaSprites.nivel1);
    public static final Sprite MUARRIBA1 = new Sprite(32,4,8,HojaSprites.nivel1);
    public static final Sprite MUARRIBA2 = new Sprite(32,5,8,HojaSprites.nivel1);
    //fin de la coleccion 
    //sprites del tigre
    public static final Sprite TABAJO0 = new Sprite(32,6,1,HojaSprites.nivel1);
    public static final Sprite TABAJO1 = new Sprite(32,7,1,HojaSprites.nivel1);
    public static final Sprite TABAJO2 = new Sprite(32,8,1,HojaSprites.nivel1);
    
    public static final Sprite TIZQUIERDA0 = new Sprite(32,6,2,HojaSprites.nivel1);
    public static final Sprite TIZQUIERDA1 = new Sprite(32,7,2,HojaSprites.nivel1);
    public static final Sprite TIZQUIERDA2 = new Sprite(32,8,2,HojaSprites.nivel1);
    
    public static final Sprite TDERECHA0 = new Sprite(32,6,3,HojaSprites.nivel1);
    public static final Sprite TDERECHA1 = new Sprite(32,7,3,HojaSprites.nivel1);
    public static final Sprite TDERECHA2 = new Sprite(32,8,3,HojaSprites.nivel1);
    
    public static final Sprite TARRIBA0 = new Sprite(32,6,4,HojaSprites.nivel1);
    public static final Sprite TARRIBA1 = new Sprite(32,7,4,HojaSprites.nivel1);
    public static final Sprite TARRIBA2 = new Sprite(32,8,4,HojaSprites.nivel1);
    //fin de la coleccion 
        //sprites del Lobo
    public static final Sprite LABAJO0 = new Sprite(32,6,5,HojaSprites.nivel1);
    public static final Sprite LABAJO1 = new Sprite(32,7,5,HojaSprites.nivel1);
    public static final Sprite LABAJO2 = new Sprite(32,8,5,HojaSprites.nivel1);
    
    public static final Sprite LIZQUIERDA0 = new Sprite(32,6,6,HojaSprites.nivel1);
    public static final Sprite LIZQUIERDA1 = new Sprite(32,7,6,HojaSprites.nivel1);
    public static final Sprite LIZQUIERDA2 = new Sprite(32,8,6,HojaSprites.nivel1);
    
    public static final Sprite LDERECHA0 = new Sprite(32,6,7,HojaSprites.nivel1);
    public static final Sprite LDERECHA1 = new Sprite(32,7,7,HojaSprites.nivel1);
    public static final Sprite LDERECHA2 = new Sprite(32,8,7,HojaSprites.nivel1);
    
    public static final Sprite LARRIBA0 = new Sprite(32,6,8,HojaSprites.nivel1);
    public static final Sprite LARRIBA1 = new Sprite(32,7,8,HojaSprites.nivel1);
    public static final Sprite LARRIBA2 = new Sprite(32,8,8,HojaSprites.nivel1);
    //fin de la coleccion 
    //sprites del gato
    public static final Sprite GABAJO0 = new Sprite(32,9,1,HojaSprites.nivel1);
    public static final Sprite GABAJO1 = new Sprite(32,10,1,HojaSprites.nivel1);
    public static final Sprite GABAJO2 = new Sprite(32,11,1,HojaSprites.nivel1);
    
    public static final Sprite GIZQUIERDA0 = new Sprite(32,9,2,HojaSprites.nivel1);
    public static final Sprite GIZQUIERDA1 = new Sprite(32,10,2,HojaSprites.nivel1);
    public static final Sprite GIZQUIERDA2 = new Sprite(32,11,2,HojaSprites.nivel1);
    
    public static final Sprite GDERECHA0 = new Sprite(32,9,3,HojaSprites.nivel1);
    public static final Sprite GDERECHA1 = new Sprite(32,10,3,HojaSprites.nivel1);
    public static final Sprite GDERECHA2 = new Sprite(32,11,3,HojaSprites.nivel1);
    
    public static final Sprite GARRIBA0 = new Sprite(32,9,4,HojaSprites.nivel1);
    public static final Sprite GARRIBA1 = new Sprite(32,10,4,HojaSprites.nivel1);
    public static final Sprite GARRIBA2 = new Sprite(32,11,4,HojaSprites.nivel1);
    //fin de la coleccion
        //sprites del Esqueleto
    public static final Sprite EABAJO0 = new Sprite(32,9,5,HojaSprites.nivel1);
    public static final Sprite EABAJO1 = new Sprite(32,10,5,HojaSprites.nivel1);
    public static final Sprite EABAJO2 = new Sprite(32,11,5,HojaSprites.nivel1);
    
    public static final Sprite EIZQUIERDA0 = new Sprite(32,9,6,HojaSprites.nivel1);
    public static final Sprite EIZQUIERDA1 = new Sprite(32,10,6,HojaSprites.nivel1);
    public static final Sprite EIZQUIERDA2 = new Sprite(32,11,6,HojaSprites.nivel1);
    
    public static final Sprite EDERECHA0 = new Sprite(32,9,7,HojaSprites.nivel1);
    public static final Sprite EDERECHA1 = new Sprite(32,10,7,HojaSprites.nivel1);
    public static final Sprite EDERECHA2 = new Sprite(32,11,7,HojaSprites.nivel1);
    
    public static final Sprite EARRIBA0 = new Sprite(32,9,8,HojaSprites.nivel1);
    public static final Sprite EARRIBA1 = new Sprite(32,10,8,HojaSprites.nivel1);
    public static final Sprite EARRIBA2 = new Sprite(32,11,8,HojaSprites.nivel1);
    //fin de la coleccion
    //sprites del del NPC1
    public static final Sprite NPC1ABAJO = new Sprite(32,12,1,HojaSprites.nivel1);
    public static final Sprite NPC1IZQUIERDA = new Sprite(32,12,2,HojaSprites.nivel1);
    public static final Sprite NPC1DERECHA = new Sprite(32,12,3,HojaSprites.nivel1);
    public static final Sprite NPC1ARRIBA = new Sprite(32,12,4,HojaSprites.nivel1);
    //fin de la coleccion
    //sprites del del NPC2
    public static final Sprite NPC2ABAJO = new Sprite(32,12,5,HojaSprites.nivel1);
    public static final Sprite NPC2IZQUIERDA = new Sprite(32,12,6,HojaSprites.nivel1);
    public static final Sprite NPC2DERECHA = new Sprite(32,12,7,HojaSprites.nivel1);
    public static final Sprite NPC2ARRIBA = new Sprite(32,12,8,HojaSprites.nivel1);
    //fin de la coleccion
    //sprites del del NPC3
    public static final Sprite NPC3ABAJO = new Sprite(32,15,5,HojaSprites.nivel1);
    public static final Sprite NPC3IZQUIERDA = new Sprite(32,15,6,HojaSprites.nivel1);
    public static final Sprite NPC3DERECHA = new Sprite(32,15,7,HojaSprites.nivel1);
    public static final Sprite NPC3ARRIBA = new Sprite(32,15,8,HojaSprites.nivel1);
    //fin de la coleccion
    //coleccion de sprites
    
    public static Sprite VACIO = new Sprite(32,0);
    public static Sprite TRANSPARENTE = new Sprite(32,12,0,HojaSprites.nivel1);
    public static Sprite COFRE = new Sprite(32,0,9,HojaSprites.nivel1);
    public static Sprite COFREA = new Sprite(32,1,9,HojaSprites.nivel1);
    
    public static Sprite PASTO = new Sprite(32,13,0,HojaSprites.texturas);
    public static Sprite PASTO_SI = new Sprite(32,12,1,HojaSprites.texturas);
    public static Sprite PASTO_SD = new Sprite(32,13,1,HojaSprites.texturas);
    public static Sprite PASTO_SSI = new Sprite(32,16,0,HojaSprites.texturas);
    public static Sprite PASTO_SSM = new Sprite(32,17,0,HojaSprites.texturas);
    public static Sprite PASTO_SSD = new Sprite(32,18,0,HojaSprites.texturas);
    public static Sprite PASTO_I = new Sprite(32,12,2,HojaSprites.texturas);
    public static Sprite PASTO_D = new Sprite(32,13,2,HojaSprites.texturas);
    public static Sprite PASTO_ARENA = new Sprite(32,16,1,HojaSprites.texturas);
    public static Sprite PASTOT_ARENAB = new Sprite(32,18,1,HojaSprites.texturas);
    public static Sprite ARENA_PASTO = new Sprite(32,17,1,HojaSprites.texturas);
    
    public static Sprite ARENA = new Sprite(32,1,10,HojaSprites.texturas);
    public static Sprite AGUA = new Sprite(32,2,0,HojaSprites.nivel1);
    
    public static Sprite MURO = new Sprite(32,10,0,HojaSprites.texturas);
    public static Sprite MURO_T = new Sprite(32,10,3,HojaSprites.texturas);
    public static Sprite MURO_B = new Sprite(32,10,4,HojaSprites.texturas);
    
    
    public static Sprite CARPA_1 = new Sprite(32,16,2,HojaSprites.texturas);
    public static Sprite CARPA_2 = new Sprite(32,17,2,HojaSprites.texturas);
    public static Sprite CARPA_3 = new Sprite(32,18,2,HojaSprites.texturas);
    public static Sprite CARPA_4 = new Sprite(32,16,3,HojaSprites.texturas);
    public static Sprite CARPA_5 = new Sprite(32,17,3,HojaSprites.texturas);
    public static Sprite CARPA_6 = new Sprite(32,18,3,HojaSprites.texturas);
    public static Sprite CARPA_7 = new Sprite(32,16,4,HojaSprites.texturas);
    public static Sprite CARPA_8 = new Sprite(32,17,4,HojaSprites.texturas);
    public static Sprite CARPA_9 = new Sprite(32,18,4,HojaSprites.texturas);
    
    public static Sprite TENT_1 = new Sprite(32,0,1,HojaSprites.objetos);
    public static Sprite TENT_2 = new Sprite(32,1,1,HojaSprites.objetos);
    public static Sprite TENT_3 = new Sprite(32,2,1,HojaSprites.objetos);
    public static Sprite TENT_4 = new Sprite(32,3,1,HojaSprites.objetos);
    public static Sprite TENT_5 = new Sprite(32,4,1,HojaSprites.objetos);
    public static Sprite TENT_6 = new Sprite(32,0,2,HojaSprites.objetos);
    public static Sprite TENT_7 = new Sprite(32,1,2,HojaSprites.objetos);
    public static Sprite TENT_8 = new Sprite(32,2,2,HojaSprites.objetos);
    public static Sprite TENT_9 = new Sprite(32,3,2,HojaSprites.objetos);
    public static Sprite TENT_10 = new Sprite(32,4,2,HojaSprites.objetos);
    public static Sprite TENT_11 = new Sprite(32,0,3,HojaSprites.objetos);
    public static Sprite TENT_12 = new Sprite(32,1,3,HojaSprites.objetos);
    public static Sprite TENT_13 = new Sprite(32,2,3,HojaSprites.objetos);
    public static Sprite TENT_14 = new Sprite(32,3,3,HojaSprites.objetos);
    public static Sprite TENT_15 = new Sprite(32,4,3,HojaSprites.objetos);
    public static Sprite TENT_16 = new Sprite(32,0,4,HojaSprites.objetos);
    public static Sprite TENT_17 = new Sprite(32,1,4,HojaSprites.objetos);
    public static Sprite TENT_18 = new Sprite(32,2,4,HojaSprites.objetos);
    public static Sprite TENT_19 = new Sprite(32,3,4,HojaSprites.objetos);
    public static Sprite TENT_20 = new Sprite(32,4,4,HojaSprites.objetos);
    public static Sprite TENT_21 = new Sprite(32,0,5,HojaSprites.objetos);
    public static Sprite TENT_22 = new Sprite(32,5,1,HojaSprites.objetos);
    public static Sprite TENT_23 = new Sprite(32,6,1,HojaSprites.objetos);
    public static Sprite TENT_24 = new Sprite(32,7,1,HojaSprites.objetos);
    public static Sprite TENT_25 = new Sprite(32,4,5,HojaSprites.objetos);
    public static Sprite TENT_26 = new Sprite(32,0,6,HojaSprites.objetos);
    public static Sprite TENT_27 = new Sprite(32,5,2,HojaSprites.objetos);
    public static Sprite TENT_28 = new Sprite(32,6,2,HojaSprites.objetos);
    public static Sprite TENT_29 = new Sprite(32,7,2,HojaSprites.objetos);
    public static Sprite TENT_30 = new Sprite(32,4,6,HojaSprites.objetos);
    
    public static Sprite BARRIL = new Sprite(32,0,15,HojaSprites.objetos);
    public static Sprite NIGHTTABLE1 = new Sprite(32,5,20,HojaSprites.objetos);
    public static Sprite NIGHTTABLE2 = new Sprite(32,5,21,HojaSprites.objetos);
    public static Sprite CANDLE = new Sprite(32,6,20,HojaSprites.objetos);
    public static Sprite CAMA1 = new Sprite(32,4,20,HojaSprites.objetos);
    public static Sprite CAMA2 = new Sprite(32,4,21,HojaSprites.objetos);
    public static Sprite CAMA3 = new Sprite(32,4,22,HojaSprites.objetos);
    public static Sprite HALFBARREL = new Sprite(32,2,16,HojaSprites.objetos);
    public static Sprite HALFBARRELPLANTS = new Sprite(32,1,16,HojaSprites.objetos);
    
    
    
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

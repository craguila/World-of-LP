/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cuadro;

import Graficos.Pantalla;
import Graficos.Sprite;



public class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;
    public static final int LADO = 32;
    
    public boolean solido;
    
    //coleccion de cuadros
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO, true);
    public static final Cuadro PASTO = new Cuadro(Sprite.PASTO);
    public static final Cuadro PASTO_I = new Cuadro(Sprite.PASTO_I);
    public static final Cuadro PASTO_D = new Cuadro(Sprite.PASTO_D);
    public static final Cuadro PASTO_SSM = new Cuadro(Sprite.PASTO_SSM);
    public static final Cuadro PASTO_SSD = new Cuadro(Sprite.PASTO_SSD);
    public static final Cuadro PASTO_SSI = new Cuadro(Sprite.PASTO_SSI);
    public static final Cuadro PASTO_SI = new Cuadro(Sprite.PASTO_SI);
    public static final Cuadro PASTO_SD = new Cuadro(Sprite.PASTO_SD);
    
    public static final Cuadro PASTO_ARENA = new Cuadro(Sprite.PASTO_ARENA);
    public static final Cuadro ARENA_PASTO = new Cuadro(Sprite.ARENA_PASTO);
    public static final Cuadro PASTOT_ARENAB = new Cuadro(Sprite.PASTOT_ARENAB);
    
    public static final Cuadro ARENA = new Cuadro(Sprite.ARENA);
    public static final Cuadro AGUA = new Cuadro(Sprite.AGUA, true);
    public static final Cuadro MURO = new Cuadro(Sprite.MURO, true);
    public static final Cuadro MURO_T = new Cuadro(Sprite.MURO_T, true);
    public static final Cuadro MURO_B = new Cuadro(Sprite.MURO_B, true);
    
    
    public static final Cuadro CARPA_1 = new Cuadro(Sprite.CARPA_1, true);
    public static final Cuadro CARPA_2 = new Cuadro(Sprite.CARPA_2, true);
    public static final Cuadro CARPA_3 = new Cuadro(Sprite.CARPA_3, true);
    public static final Cuadro CARPA_4 = new Cuadro(Sprite.CARPA_4, true);
    public static final Cuadro CARPA_5 = new Cuadro(Sprite.CARPA_5, true);
    public static final Cuadro CARPA_6 = new Cuadro(Sprite.CARPA_6, true);
    public static final Cuadro CARPA_7 = new Cuadro(Sprite.CARPA_7, true);
    public static final Cuadro CARPA_8 = new Cuadro(Sprite.CARPA_8);
    public static final Cuadro CARPA_9 = new Cuadro(Sprite.CARPA_9, true);
    
    public static final Cuadro TENT_1 = new Cuadro(Sprite.TENT_1, true);
    public static final Cuadro TENT_2 = new Cuadro(Sprite.TENT_2, true);
    public static final Cuadro TENT_3 = new Cuadro(Sprite.TENT_3, true);
    public static final Cuadro TENT_4 = new Cuadro(Sprite.TENT_4, true);
    public static final Cuadro TENT_5 = new Cuadro(Sprite.TENT_5, true);
    public static final Cuadro TENT_6 = new Cuadro(Sprite.TENT_6, true);
    public static final Cuadro TENT_7 = new Cuadro(Sprite.TENT_7, true);
    public static final Cuadro TENT_8 = new Cuadro(Sprite.TENT_8, true);
    public static final Cuadro TENT_9 = new Cuadro(Sprite.TENT_9, true);
    public static final Cuadro TENT_10 = new Cuadro(Sprite.TENT_10, true);
    public static final Cuadro TENT_11 = new Cuadro(Sprite.TENT_11, true);
    public static final Cuadro TENT_12 = new Cuadro(Sprite.TENT_12);
    public static final Cuadro TENT_13 = new Cuadro(Sprite.TENT_13);
    public static final Cuadro TENT_14 = new Cuadro(Sprite.TENT_14);
    public static final Cuadro TENT_15 = new Cuadro(Sprite.TENT_15, true);
    public static final Cuadro TENT_16 = new Cuadro(Sprite.TENT_16, true);
    public static final Cuadro TENT_17 = new Cuadro(Sprite.TENT_17);
    public static final Cuadro TENT_18 = new Cuadro(Sprite.TENT_18);
    public static final Cuadro TENT_19 = new Cuadro(Sprite.TENT_19);
    public static final Cuadro TENT_20 = new Cuadro(Sprite.TENT_20, true);
    public static final Cuadro TENT_21 = new Cuadro(Sprite.TENT_21, true);
    public static final Cuadro TENT_22 = new Cuadro(Sprite.TENT_22);
    public static final Cuadro TENT_23 = new Cuadro(Sprite.TENT_23);
    public static final Cuadro TENT_24 = new Cuadro(Sprite.TENT_24);
    public static final Cuadro TENT_25 = new Cuadro(Sprite.TENT_25, true);
    public static final Cuadro TENT_26 = new Cuadro(Sprite.TENT_26, true);
    public static final Cuadro TENT_27 = new Cuadro(Sprite.TENT_27, true);
    public static final Cuadro TENT_28 = new Cuadro(Sprite.TENT_28);
    public static final Cuadro TENT_29 = new Cuadro(Sprite.TENT_29, true);
    public static final Cuadro TENT_30 = new Cuadro(Sprite.TENT_30, true);
    
    
    //fin de la coleccion
    
    public Cuadro(Sprite sprite){
        this(sprite,false);
    }
    public Cuadro(Sprite sprite, boolean solido){
        this.sprite = sprite;
        this.solido = solido;
    }
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x<<5, y<<5, this);
    }
    
    public boolean esSolido(){
        return solido;
    }
}

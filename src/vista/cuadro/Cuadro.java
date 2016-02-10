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
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
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
    public static final Cuadro AGUA = new Cuadro(Sprite.AGUA);
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

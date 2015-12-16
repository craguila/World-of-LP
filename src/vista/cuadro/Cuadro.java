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
    //coleccion de cuadros
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
    public static final Cuadro PASTO = new Cuadro(Sprite.PASTO);
    public static final Cuadro ARENA = new Cuadro(Sprite.ARENA);
    public static final Cuadro AGUA = new Cuadro(Sprite.AGUA);
    public static final Cuadro MURO = new Cuadro(Sprite.MURO);
    
    //fin de la coleccion
    
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x<<5, y<<5, this);
    }
    
    public boolean solido(){
        return false;
    }
}

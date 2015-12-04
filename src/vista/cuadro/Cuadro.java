/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cuadro;

import Graficos.Pantalla;
import Graficos.Sprite;


public abstract class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;
    
    //coleccion de cuadros
    public static final Cuadro VACIO = new CuadroVacio(Sprite.VACIO);
    public static final Cuadro pasto = new CuadroPasto(Sprite.pasto);
    
    
    //fin de la coleccion
    
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
    
    }
    
    public boolean solido(){
        return false;
    }
}

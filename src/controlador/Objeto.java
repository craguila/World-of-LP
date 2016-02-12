/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Pantalla;
import Graficos.Sprite;
import vista.Mapa;

/**
 *
 * @author CristobalIsidroMatia
 */
public class Objeto {
    protected Sprite sprite;
    String nombre;
    int[] posicion=new int[2];
    protected Mapa mapa;
    public Objeto(Mapa mapa, String nombre, int[] posicion, Sprite sprite) {
        this.mapa = mapa;
        this.nombre = nombre;
        this.posicion = posicion;
        this.sprite = sprite;
    }
    
       public boolean actualizar(){

        return false;

    }

    public Sprite getSprite(){
        return sprite;
    }
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarObjeto(posicion[0], posicion[1], this);
        
        
    }
     
}

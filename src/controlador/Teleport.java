/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Pantalla;
import Graficos.Sprite;
import vista.Juego;
import vista.Mapa;


public class Teleport {
    protected Sprite sprite;
    String Nombre;
    int[] posicion=new int[2];
    protected Mapa mapa;
    private int toX;
    private int toY;
    public Teleport(Mapa mapa, String Nombre, int[] posicion, Sprite sprite,int toX, int toY) {
        this.mapa = mapa;
        this.Nombre = Nombre;
        this.posicion = posicion;
        this.sprite = sprite;
        this.toX = toX;
        this.toY = toY;
    }
    


    public boolean actualizar(){

        return false;

    }

    public Sprite getSprite(){
        return sprite;
    }
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarTeleport(posicion[0], posicion[1], this);
        
        
    }
     
    public int gettoX(){
        return toX;
    }
    public int gettoY(){
        return toY;
    }
}

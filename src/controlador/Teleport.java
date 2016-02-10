/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import java.util.ArrayList;
import java.util.Random;
import vista.Juego;
import vista.Mapa;


public class Teleport extends Monstruo{
    private boolean enMovimiento = false;
    private int toX;
    private int toY;
    public Teleport(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion, Sprite sprite,int toX, int toY) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        this.sprite = sprite;
        this.toX = toX;
        this.toY = toY;
    }
    


    
    @Override
    public boolean actualizar(){

        return false;

    }

    @Override
    public Sprite getSprite(){
        return sprite;
    }
    public void mostrar(){

    }
    
    public int gettoX(){
        return toX;
    }
    public int gettoY(){
        return toY;
    }
}

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


public class Cofre extends Monstruo{
    private boolean enMovimiento = false;
    private int animacion;
   
    public Cofre(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion, Sprite sprite) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        this.sprite = sprite;
    }
    
    public void sacarItem(){
        this.sprite = Sprite.COFREA;
        if (!inventario.items.isEmpty()){
            for (Item i: inventario.items){
                Juego.jugador.inventario.items.add(i);
            }
            inventario.items.clear();
            return;
        }
        System.out.println("El cofre está vacio");
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
}

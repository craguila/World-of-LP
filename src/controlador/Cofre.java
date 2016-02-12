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


public class Cofre extends Objeto{//deberia extends Objeto y agregar inventario
    private boolean enMovimiento = false;
    private int animacion;
    private Inventario inventario;
    public Cofre(Mapa mapa, String nombre, int[] posicion, Sprite sprite, Inventario inventario) {
        super (mapa, nombre, posicion, sprite);
        this.sprite = sprite;
        this.inventario = inventario;
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    public String getNombre(){
        return nombre;
    }
    public void sacarItem(Cofre c){
        c.sprite = Sprite.COFREA;
        if (c.getInventario().getSize()>0){
            for (EquipoItem i: c.getInventario().getItems()){
                Juego.setConsole("Obtuviste "+i.nombre);
                Juego.jugador.getInventario().addItem(i);
            }
            c.getInventario().clear();
            Juego.cofresobjetivo.remove(c);
        }
        Juego.ventanaInventario.setEstado();
    }
    public boolean isOpen(){
        return (sprite==Sprite.COFREA);
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

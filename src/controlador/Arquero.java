/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import control.Teclado;


public class Arquero extends Personaje {
    protected boolean enMovimiento = false;
    private Teclado teclado;   
    private int ira;
    private int Flechas;
    private Habilidad[] spell_Ar; //requiere utilizar flechas y ira para atacar
    public Arquero(String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario,Teclado teclado, int[] posicion, Sprite sprite) {
        super(Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        this.teclado = teclado;
        this.sprite = sprite;
    }
    
    @Override
    public void actualizar(){
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        if (teclado.arriba){
            desplazamientoY--;
        }
        if (teclado.abajo){
            desplazamientoY++;
        }
        if(teclado.izquierda){
            desplazamientoX--;
        }
        if(teclado.derecha){
            desplazamientoX++;
        }
        
        if (desplazamientoX != 0 || desplazamientoY != 0){
            if (direccion == 'n'){
                sprite = Sprite.ARRIBA0;
            }
            if (direccion == 's'){
                sprite = Sprite.ABAJO0;
            } 
            if (direccion == 'o'){
                sprite = Sprite.IZQUIERDA0;
            }
            if (direccion == 'e'){
                sprite = Sprite.DERECHA0;
            }
            mover(desplazamientoX, desplazamientoY);
        }
    }
    
    @Override
    public Sprite getSprite(){
        return sprite;
    }
    public void mostrar(){
        
    }

    
    

}

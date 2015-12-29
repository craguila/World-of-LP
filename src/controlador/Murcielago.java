/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import control.Teclado;
import vista.Mapa;

/**
 *
 * @author CristobalIsidroMatia
 */
public class Murcielago extends Monstruo{
    protected boolean enMovimiento = false;
    private int animacion;
    public Murcielago(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion, Sprite sprite) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        exp_entregada = 10;
        this.sprite = sprite;
    }
    
    @Override
    public void actualizar(){
        int desplazamientoX = 0;
        int desplazamientoY = 0;

        if (animacion<32767){
            animacion++;
        }else{
            animacion =0;
        }
//crear IA para mover el monstruo
//random si no ve al jugador, hacia el jugador si ve al jugador
//        if (teclado.arriba){
//            desplazamientoY--;
//        }
//        if (teclado.abajo){
//            desplazamientoY++;
//        }
//        if(teclado.izquierda){
//            desplazamientoX--;
//        }
//        if(teclado.derecha){
//            desplazamientoX++;
//        }

        int resto = animacion%40;
        if (direccion == 'n'){
            sprite = Sprite.MUARRIBA0;
            if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MUARRIBA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MUARRIBA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MUARRIBA2;
                } else{
                    sprite= Sprite.MUARRIBA0;
                }
            }
        }
        if (direccion == 's'){
            sprite = Sprite.MUABAJO0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MUABAJO1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MUABAJO0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MUABAJO2;
                } else{
                    sprite= Sprite.MUABAJO0;
                }
            }
        } 
        if (direccion == 'o'){
            sprite = Sprite.MUIZQUIERDA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MUIZQUIERDA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MUIZQUIERDA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MUIZQUIERDA2;
                } else{
                    sprite= Sprite.MUIZQUIERDA0;
                }
            }

        }
        if (direccion == 'e'){
            sprite = Sprite.MUDERECHA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MUDERECHA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MUDERECHA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MUDERECHA2;
                } else{
                    sprite= Sprite.MUDERECHA0;
                }
            }

        }
        if (desplazamientoX != 0 || desplazamientoY != 0){
            mover(desplazamientoX, desplazamientoY);
            enMovimiento= true;
        } else{
            enMovimiento = false;
        }

    }

    @Override
    public Sprite getSprite(){
        return sprite;
    }
    public void mostrar(){

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import control.Teclado;
import java.util.ArrayList;
import vista.Mapa;


public class Arquero extends Personaje {
    protected boolean enMovimiento = false;
    private int animacion;
    private Teclado teclado;   
    private int ira;
    private int Flechas;
    ArrayList<Habilidad> habilidades = new ArrayList<>(); //requiere utilizar flechas y ira para atacar
    public Arquero(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario,Teclado teclado, int[] posicion, Sprite sprite) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        this.teclado = teclado;
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
        
        int resto = animacion%40;
        if (direccion == 'n'){
            sprite = Sprite.AARRIBA0;
            if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.AARRIBA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.AARRIBA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.AARRIBA2;
                } else{
                    sprite= Sprite.AARRIBA0;
                }
            }
        }
        if (direccion == 's'){
            sprite = Sprite.AABAJO0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.AABAJO1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.AABAJO0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.AABAJO2;
                } else{
                    sprite= Sprite.AABAJO0;
                }
            }
        } 
        if (direccion == 'o'){
            sprite = Sprite.AIZQUIERDA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.AIZQUIERDA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.AIZQUIERDA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.AIZQUIERDA2;
                } else{
                    sprite= Sprite.AIZQUIERDA0;
                }
            }
            
        }
        if (direccion == 'e'){
            sprite = Sprite.ADERECHA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.ADERECHA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.ADERECHA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.ADERECHA2;
                } else{
                    sprite= Sprite.ADERECHA0;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import control.Teclado;
import vista.Mapa;


public class Mago extends Personaje {
    private Teclado teclado; 
    protected boolean enMovimiento = false;
    private int animacion;
    private int piedras;
    public Mago(Mapa mapa,String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario,Teclado teclado, int[] posicion, Sprite sprite) {
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
            desplazamientoY=-stats.rapidez;
        }
        if (teclado.abajo){
            desplazamientoY=+stats.rapidez;
        }
        if(teclado.izquierda){
            desplazamientoX=-stats.rapidez;
        }
        if(teclado.derecha){
            desplazamientoX=+stats.rapidez;
        }
        
        int resto = animacion%40;
        if (direccion == 'n'){
            sprite = Sprite.MARRIBA0;
            if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MARRIBA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MARRIBA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MARRIBA2;
                } else{
                    sprite= Sprite.MARRIBA0;
                }
            }
        }
        if (direccion == 's'){
            sprite = Sprite.MABAJO0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MABAJO1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MABAJO0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MABAJO2;
                } else{
                    sprite= Sprite.MABAJO0;
                }
            }
        } 
        if (direccion == 'o'){
            sprite = Sprite.MIZQUIERDA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MIZQUIERDA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MIZQUIERDA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MIZQUIERDA2;
                } else{
                    sprite= Sprite.MIZQUIERDA0;
                }
            }
            
        }
        if (direccion == 'e'){
            sprite = Sprite.MDERECHA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.MDERECHA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.MDERECHA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.MDERECHA2;
                } else{
                    sprite= Sprite.MDERECHA0;
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

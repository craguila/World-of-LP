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


public class Murcielago extends Monstruo{
    private boolean enMovimiento = false;
    private int animacion;
   
    public Murcielago(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion, Sprite sprite) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        exp_entregada = 10;
        this.sprite = sprite;
        habilidades = new ArrayList<>();
        habilidades.add(Habilidad.INFLINGIR_ENFERMEDAD);
    }
    
    
    Random  rnd = new Random();
    @Override
    public boolean actualizar(){
        int playerx = Juego.jugador.posicion[0];
        int playery = Juego.jugador.posicion[1];
        int monsterx = posicion[0];
        int monstery = posicion[1];
        
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        if (animacion<32767){
            animacion++;
        }else{
            animacion =0;
        }
            if (jugadorvisible()){
                int distx = playerx - monsterx;
                int disty = playery - monstery;
                if (distx > disty && distx!=0){
                    desplazamientoX += (distx/Math.abs(distx))*stats.rapidez;
                } else if(distx <= disty && disty!=0){
                    desplazamientoY += (disty/Math.abs(disty))*stats.rapidez;
                }
                
                if (Juego.jugador.sienteelchoque(-desplazamientoX, -desplazamientoY)){
                    Random  rand = new Random();
                    int i = rand.nextInt(4);
                    if (i==1){
                        if(!usarHabilidad()){
                            Juego.jugador.danar(stats.fuerza);
                        }
                    }else{
                        Juego.setConsole((Nombre+" te atacó."));
                        Juego.jugador.danar(stats.fuerza);
                    }
                }
            } else {
                int x=rnd.nextInt(2);
                int y=rnd.nextInt(2);
                if (x==1){
                        desplazamientoX-= stats.rapidez;
                } else if(x==2){
                        desplazamientoX+= stats.rapidez;
                }
                if (y==1){
                        desplazamientoY-= stats.rapidez;
                } else if(y==2){
                        desplazamientoY+= stats.rapidez;
                }
            }

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
        if (!vivo()){
            Juego.jugador.aumentarExp(exp_entregada);
            Juego.jugador.ganarDinero(dinero);
            this.mover(10000, 10000);
        }
        if (desplazamientoX != 0 || desplazamientoY != 0){
            try{
            mover(desplazamientoX*10, desplazamientoY*10);
            enMovimiento= true;
            return true;
            }
            catch(Exception e){
                    enMovimiento = false;
                    return false;
                    }
            
        } else{
            enMovimiento = false;
            return false;
        }

    }

    @Override
    public Sprite getSprite(){
        return sprite;
    }
    public void mostrar(){

    }
}

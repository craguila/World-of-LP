/*
 * Lo change this license header, choose License Headers in Project Properties.
 * Lo change this template file, choose Lools | Lemplates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import java.util.ArrayList;
import java.util.Random;
import vista.Juego;
import vista.Mapa;

public class Lobo extends Monstruo{
    private boolean enMovimiento = false;
    private int animacion;
   
    public Lobo(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion, Sprite sprite) {
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
                if (distx < disty && distx!=0){
                    desplazamientoX += (distx/Math.abs(distx))*stats.rapidez;
                } else if(distx > disty && disty!=0){
                    desplazamientoY -= (disty/Math.abs(disty))*stats.rapidez;
                }
                
                if (Juego.jugador.sienteelchoque(-desplazamientoX, -desplazamientoY)){
                    Random  rand = new Random();
                    Double dmg = (rand.nextDouble()*3);
                    int i = dmg.intValue();
                    if (i==1){
                        usarHabilidad();
                    }else{
                        Juego.jugador.danar(stats.fuerza);
                    }
                }
            } else {
                int x=(int)(rnd.nextDouble() *100);
                int y=(int)(rnd.nextDouble() *100);
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
            sprite = Sprite.LARRIBA0;
            if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.LARRIBA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.LARRIBA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.LARRIBA2;
                } else{
                    sprite= Sprite.LARRIBA0;
                }
            }
        }
        if (direccion == 's'){
            sprite = Sprite.LABAJO0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.LABAJO1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.LABAJO0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.LABAJO2;
                } else{
                    sprite= Sprite.LABAJO0;
                }
            }
        } 
        if (direccion == 'o'){
            sprite = Sprite.LIZQUIERDA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.LIZQUIERDA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.LIZQUIERDA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.LIZQUIERDA2;
                } else{
                    sprite= Sprite.LIZQUIERDA0;
                }
            }

        }
        if (direccion == 'e'){
            sprite = Sprite.LDERECHA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.LDERECHA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.LDERECHA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.LDERECHA2;
                } else{
                    sprite= Sprite.LDERECHA0;
                }
            }

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
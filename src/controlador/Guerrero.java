/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import control.Teclado;
import java.util.Calendar;
import java.util.Date;
import vista.Mapa;


public class Guerrero extends Personaje {
    protected boolean enMovimiento = false;
    private int animacion;
    private Teclado teclado;   
    private boolean abierto_inventario;
    private Date fechaActual = new Date();
    private Calendar fecha = Calendar.getInstance();
    private boolean abierto_habilidad;
    private int segundos = fecha.get(Calendar.SECOND);
    private int segundos2 = fecha.get(Calendar.SECOND);
    public Guerrero(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario,Teclado teclado, int[] posicion, Sprite sprite) {
        super(mapa,Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        this.teclado = teclado;
        this.sprite = sprite;
    }
    @Override
    public boolean actualizar(){
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
        if(teclado.inventario ){
            if (segundos2 > segundos ){
                if (abierto_inventario){
                    System.out.println("Cerrar inventario");
                    abierto_inventario = false;
                    fecha = Calendar.getInstance();
                    segundos = fecha.get(Calendar.SECOND);
                } else {
                    abierto_inventario = true;
                    System.out.println("Abrir inventario");
                    fecha = Calendar.getInstance();
                    segundos = fecha.get(Calendar.SECOND);
                }
            }
            fecha = Calendar.getInstance();
            segundos2 = fecha.get(Calendar.SECOND);
        }
        if(teclado.atacar){
            
            System.out.println("Atacar!");
        }
        if(teclado.usarhabilidad){
            if (segundos2 > segundos ){
                if (abierto_habilidad){
                    System.out.println("Cerrar Habilidades");
                    abierto_habilidad = false;
                    fecha = Calendar.getInstance();
                    segundos = fecha.get(Calendar.SECOND);
                } else {
                    abierto_habilidad = true;
                    System.out.println("Abrir Habilidades");
                    fecha = Calendar.getInstance();
                    segundos = fecha.get(Calendar.SECOND);
                }
            }
            fecha = Calendar.getInstance();
            segundos2 = fecha.get(Calendar.SECOND);
        }
        if(teclado.abrircofre){
            System.out.println("Abrir cofre");
        }

        int resto = animacion%40;
        if (direccion == 'n'){
            sprite = Sprite.ARRIBA0;
            if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.ARRIBA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.ARRIBA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.ARRIBA2;
                } else{
                    sprite= Sprite.ARRIBA0;
                }
            }
        }
        if (direccion == 's'){
            sprite = Sprite.ABAJO0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.ABAJO1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.ABAJO0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.ABAJO2;
                } else{
                    sprite= Sprite.ABAJO0;
                }
            }
        } 
        if (direccion == 'o'){
            sprite = Sprite.IZQUIERDA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.IZQUIERDA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.IZQUIERDA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.IZQUIERDA2;
                } else{
                    sprite= Sprite.IZQUIERDA0;
                }
            }

        }
        if (direccion == 'e'){
            sprite = Sprite.DERECHA0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = Sprite.DERECHA1;
                } else if (resto>20 && resto<=30){
                    sprite= Sprite.DERECHA0;
                } else if (resto>30 && resto<=40){
                    sprite= Sprite.DERECHA2;
                } else{
                    sprite= Sprite.DERECHA0;
                }
            }

        }
        if (desplazamientoX != 0 || desplazamientoY != 0){
            mover(desplazamientoX, desplazamientoY);
            enMovimiento= true;
            return true;
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

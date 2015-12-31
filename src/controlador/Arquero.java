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


public class Arquero extends Personaje {
    protected boolean enMovimiento = false;
    private int animacion;
    private Teclado teclado;   
    private int ira;
    private int Flechas; //requiere utilizar flechas y ira para atacar
    private boolean abierto_inventario;
    private Date fechaActual = new Date();
    private Calendar fecha = Calendar.getInstance();
    private boolean abierto_habilidad;
    private int segundos = fecha.get(Calendar.SECOND);
    private int segundos2 = fecha.get(Calendar.SECOND);
    public Arquero(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario,Teclado teclado, int[] posicion, Sprite sprite) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
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

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
import vista.Juego;
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
        
        if(teclado.inventario && !Juego.ventanaInventario.isVisible()){
            Juego.ventanaInventario.setVisible(true);
            Juego.ventana.setVisible(true);
        }
        if (!teclado.inventario && Juego.ventanaInventario.isVisible()){
            Juego.ventanaInventario.setVisible(false);
        } 
        
        if(teclado.abrirstats && !Juego.ventanaStats.isVisible()){
            Juego.ventanaStats.setVisible(true);
            Juego.ventana.setVisible(true);
        }
        if (!teclado.abrirstats && Juego.ventanaStats.isVisible()){
            Juego.ventanaStats.setVisible(false);
        } 
        
        if(teclado.usarhabilidad && !Juego.ventanaHabilidades.isVisible()){
            Juego.ventanaHabilidades.setVisible(true);
            Juego.ventana.setVisible(true);
        }
        if (!teclado.usarhabilidad && Juego.ventanaHabilidades.isVisible()){
            Juego.ventanaHabilidades.setVisible(false);
        } 
        
        if(teclado.atacar && !Juego.ventanaMonstruos.isVisible()){
            Juego.ventanaMonstruos.setVisible(true);
            Juego.ventana.setVisible(true);
            
        }
        if (!teclado.atacar && Juego.ventanaMonstruos.isVisible()){
            Juego.ventanaMonstruos.setVisible(false);
        } 
        
        if(teclado.abrircofre){
            
            int posicionX = posicion[0] + desplazamientoX;
            int posicionY = posicion[1] + desplazamientoY;
            int margenIzquierdo = -23; //cambiar despues
            int margenDerecho = 26;
            int margenSuperior = -20;
            int margenInferior = 29;
            
            //busca los cofres
            for(Cofre c: Juego.cofres){
                int lado_monstruo =c.getSprite().getLado();
                //esquinas del monstruo
                int monstruoX = c.posicion[0]-lado_monstruo+5;
                int monstruoY = c.posicion[1]-lado_monstruo;
                int monstruoX2 = c.posicion[0];
                int monstruoY2 = c.posicion[1];
                //esquinas del jugador
                int playerX = posicionX + margenIzquierdo+18;
                int playerX2 = posicionX - margenIzquierdo- margenDerecho - sprite.getLado()+18;
                int playerY = posicionY + margenSuperior;
                int playerY2 = posicionY + margenSuperior + margenInferior + sprite.getLado();

                if (playerX>monstruoX && playerX<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                    c.sacarItem();
                }
                if (playerX2>monstruoX && playerX2<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                    c.sacarItem();
                }
            }
            
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

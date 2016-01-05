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
import vista.Juego;


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
        super.recuperarse();
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
                    c.sacarItem(c);
                }
                if (playerX2>monstruoX && playerX2<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                    c.sacarItem(c);
                }
            }
            //busca los npc
            for(Npc npc: Juego.npcs){
                int lado_monstruo =npc.getSprite().getLado();
                //esquinas del monstruo
                int monstruoX = npc.posicion[0]-lado_monstruo+5;
                int monstruoY = npc.posicion[1]-lado_monstruo;
                int monstruoX2 = npc.posicion[0];
                int monstruoY2 = npc.posicion[1];
                //esquinas del jugador
                int playerX = posicionX + margenIzquierdo+18;
                int playerX2 = posicionX - margenIzquierdo- margenDerecho - sprite.getLado()+18;
                int playerY = posicionY + margenSuperior;
                int playerY2 = posicionY + margenSuperior + margenInferior + sprite.getLado();

                if (playerX>monstruoX && playerX<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                    npc.interactuar(npc);
                }
                if (playerX2>monstruoX && playerX2<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                    npc.interactuar(npc);
                }
            }
            
        
            
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

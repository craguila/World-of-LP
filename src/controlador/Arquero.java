/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import control.Teclado;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import vista.Juego;
import static vista.Juego.ventanaMonstruos;
import vista.Mapa;
import vista.frmMonstruos;


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
        return super.actualizar(enMovimiento, animacion, teclado, "Arquero");
    }
    
    @Override
    public Sprite getSprite(){
        return sprite;
    }
    
    
    public void mostrar(){
        
    }

    
    

}

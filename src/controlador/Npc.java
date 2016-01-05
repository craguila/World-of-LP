/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import java.util.ArrayList;
import vista.Juego;
import vista.Mapa;
import vista.frmTrafico;

/**
 *
 * @author Administrador
 */
public class Npc extends Monstruo{
    private String tipo;
    public String texto;
    public boolean interactuando = false;
    public Npc(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion, Sprite sprite,String tipo) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        this.sprite = sprite;
        this.tipo = tipo;
        this.texto = "";
    }
    
    public void interactuar(Npc npc){
        switch (npc.tipo) {
            case "Comerciante":
                Juego.setConsole("Comerciante");
                Juego.setConsole(texto);
                Juego.setConsole("");
                if (!interactuando){
                    Juego.jugador.releaseTeclado();
                    interactuando = true;
                    new frmTrafico(Juego.jugador, npc).setVisible(true);
                }
                break;
            case "Enfermero":
                Juego.setConsole("Enfermero");
                Juego.jugador.releaseTeclado();
                Juego.jugador.Vida = Juego.jugador.VidaMAX;
                break;
            case "Persona": 
                Juego.setConsole("Persona");
                Juego.jugador.releaseTeclado();
                break;
        }
        Juego.setConsole(texto);
        Juego.setConsole("");
    }
    

    @Override
    public boolean actualizar(){
        return false;
    }
    
    @Override
    public void ganarDinero(int d){
        dinero += d;        
    }
    @Override
    public Sprite getSprite(){
        return sprite;
    }
    
    public void mostrar(){

    }
    
}

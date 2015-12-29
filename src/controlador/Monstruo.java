/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import vista.Mapa;



public class Monstruo extends Personaje {
    int exp_entregada; // experiencia que entrega al usuario.
    
    ArrayList<Habilidad> habilidades = new ArrayList<>();

    public Monstruo(Mapa mapa,String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        
    }
    

}

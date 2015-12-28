/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;



public class Monstruo extends Personaje {
    int exp_entregada; // experiencia que entrega al usuario.
    Habilidad[] spell_mo;

    public Monstruo(String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion) {
        super(Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        
    }
    

}

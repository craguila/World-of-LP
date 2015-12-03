/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


public class Arquero extends Personaje {

    public Arquero(String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario) {
        super(Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario);
    }
    int ira;
    int Flechas;
    Habilidad[] spell_Ar; //requiere utilizar flechas y ira para atacar
}

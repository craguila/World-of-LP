/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;


public class Guerreros extends Personaje {
    List<Habilidad> habilidades = new ArrayList<>();
    public Guerreros(String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario) {
        super(Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario);
        habilidades.add(new Habilidad("Golpe Fuerte",10,"Paralisis",5));
        

    }

    
    
}

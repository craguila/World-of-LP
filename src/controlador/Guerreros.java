/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import control.Teclado;
import java.util.ArrayList;
import java.util.List;
import vista.Mapa;


public class Guerreros extends Personaje {
    
    protected Sprite sprite;
    protected boolean enMovimiento = false;
    List<Habilidad> habilidades = new ArrayList<>();
    private Teclado teclado;   
    public Guerreros(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario,Teclado teclado, int[] posicion) {
        super(mapa,Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        this.teclado = teclado;
        habilidades.add(new Habilidad("Golpe Fuerte",10,"Paralisis",5));
        

    }

    
    
}

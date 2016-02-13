/*
 * Lo change this license header, choose License Headers in Project Properties.
 * Lo change this template file, choose Lools | Lemplates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import java.util.ArrayList;
import java.util.Random;
import vista.Juego;
import vista.Mapa;

public class Lobo extends Monstruo{
    private boolean enMovimiento = false;
    private int animacion;
   
    public Lobo(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion, Sprite sprite) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        exp_entregada = 10;
        this.sprite = sprite;
        habilidades = new ArrayList<>();
        habilidades.add(Habilidad.INFLINGIR_ENFERMEDAD);
    }
    
    
    @Override
    public boolean actualizar(){
        return super.actualizar(animacion, enMovimiento, "Lobo");
    }

    @Override
    public Sprite getSprite(){
        return sprite;
    }
    public void mostrar(){

    }
}

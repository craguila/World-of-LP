/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Random;
import vista.Juego;
import vista.Mapa;



public class Monstruo extends Personaje {
    int exp_entregada; // experiencia que entrega al usuario.
    
    public ArrayList<Habilidad> habilidades;

    public Monstruo(Mapa mapa,String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        dinero += 10;
    }
    
    public boolean jugadorvisible(){
        int playerx = Juego.jugador.posicion[0];
        int playery = Juego.jugador.posicion[1];
        int monsterx = posicion[0];
        int monstery = posicion[1];
        int vision = stats.radio_vision*32;
        if (((monsterx - vision)<playerx) && ((monsterx + vision) > playerx)){
            if (((monstery -vision) < playery )&& ((monstery + vision) > playery) ){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean usarHabilidad(){
        Random  rnd = new Random();
        int habilidad_rnd = (int) rnd.nextDouble()*habilidades.size();
        Habilidad habilidad = habilidades.get(habilidad_rnd);
        if(Mana>habilidad.costo){
            Juego.setConsole((Nombre+" usó " + habilidad.nombre));
            for (Status s:Juego.jugador.getEquipo().getArmadura().status_list){
                if (s.getNombre().equals(habilidad.estado.getNombre())){
                    Juego.setConsole(("Fuiste protegido por " + Juego.jugador.getEquipo().getArmadura().getNombre()));
                    Mana -= habilidad.costo;
                    return true;
                } 
            }
            Juego.jugador.danar(habilidad.dano);
            Juego.jugador.addStatus(habilidad.estado);
            Mana -= habilidad.costo;
            return true;
            }
            
        return false;
                
    }
}

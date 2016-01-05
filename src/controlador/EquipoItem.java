/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import vista.Juego;


public class EquipoItem extends Item {
    int physical_level; //nivel de ataque o defensa, dependiendo de TipoItem
    int magic_level; //nivel de ataque o defensa, dependiendo de TipoItem
    int range; //Alcance para arcos de flechas o baculos de magos (o tal vez la magia
    //misma deba traer alcance).
    ArrayList<Status> status_list; //Lista de estados de los que protege (ARMADURA) o que puede
    
    public static EquipoItem ARMA_GUERRERO=new EquipoItem(1, 0, 2, 0, "Sable", TipoItem.ARMA, "sable debil",10);
    public static EquipoItem ARMA_ARQUERO=new EquipoItem(1, 0, 6, 1, "Arco Compuesto", TipoItem.ARMA, "arco compuesto",10);
    public static EquipoItem ARMA_MAGO=new EquipoItem(1, 1, 10, 1, "Cayado", TipoItem.ARMA, "cayado de mago",10);
    public static EquipoItem ARMADURA_GUERRERO=new EquipoItem(1, 1, 10, 10, "Coraza de Caparazon", TipoItem.ARMADURA, "cayado de mago",10);
    public static EquipoItem ARMADURA_ARQUERO=new EquipoItem(1, 1, 10, 10, "Coraza de Cuero", TipoItem.ARMADURA, "cayado de mago",10);
    public static EquipoItem ARMADURA_MAGO=new EquipoItem(1, 1, 10, 10, "Coraza de Fuego Magico", TipoItem.ARMADURA, "cayado de mago",10);
    public static EquipoItem FLECHA_ARQUERO=new EquipoItem(1, 1, 10, 1, "Flecha Envenenada", TipoItem.ARMADURA, "cayado de mago",10);
    

    public EquipoItem(int physical_level, int magic_level, int range, int number, String nombre, TipoItem tipo, String descripcion, int precio) {
        super(number, nombre, tipo, descripcion,precio);
        this.physical_level = physical_level;
        this.magic_level = magic_level;
        this.range = range;
        this.status_list=new ArrayList<>();
    }
    public void Equipar(){
        if (tipo == TipoItem.ARMADURA){
            Juego.jugador.stats.resistencia_magica += magic_level;
            Juego.jugador.stats.statsnum.set(5,Juego.jugador.stats.statsnum.get(5)+ magic_level) ;
            Juego.jugador.stats.resistencia += physical_level;
            Juego.jugador.stats.statsnum.set(4,Juego.jugador.stats.statsnum.get(4)+ physical_level) ;
        } else if(tipo == TipoItem.ARMA){
            Juego.jugador.stats.fuerza += physical_level;
            Juego.jugador.stats.statsnum.set(2,Juego.jugador.stats.statsnum.get(2)+ physical_level) ;
            Juego.jugador.stats.inteligencia += magic_level;
            Juego.jugador.stats.statsnum.set(6,Juego.jugador.stats.statsnum.get(6)+ magic_level) ;
        }
        
    }
}

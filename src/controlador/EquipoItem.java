/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static EquipoItem NADA= new EquipoItem(0,0,0,0,"",TipoItem.NADA,"",0);
    public static ArrayList<EquipoItem> todoslositems = new ArrayList<>(
    Arrays.asList(ARMA_GUERRERO,ARMA_ARQUERO,ARMA_MAGO,ARMADURA_GUERRERO,ARMADURA_ARQUERO,ARMADURA_MAGO,FLECHA_ARQUERO,NADA)
    );

    public EquipoItem(int physical_level, int magic_level, int range, int number, String nombre, TipoItem tipo, String descripcion, int precio) {
        super(number, nombre, tipo, descripcion,precio);
        this.physical_level = physical_level;
        this.magic_level = magic_level;
        this.range = range;
        this.status_list=new ArrayList<>();
    }
    public void Equipar(){
        //sacamos el item anterior
        for (EquipoItem e:todoslositems){
            if (tipo == TipoItem.ARMA){
                if (Juego.jugador.getEquipo().getArma().getNombre().equals(e.getNombre())){
                    Juego.jugador.getInventario().addItem(e);
                    Juego.jugador.stats.fuerza -= e.physical_level;
                    Juego.jugador.stats.statsnum.set(2,Juego.jugador.stats.statsnum.get(2)- e.physical_level) ;
                    Juego.jugador.stats.inteligencia -= e.magic_level;
                    Juego.jugador.stats.statsnum.set(6,Juego.jugador.stats.statsnum.get(6)- e.magic_level) ;
                }
            }
            if (tipo == TipoItem.ARMADURA){
                if (Juego.jugador.getEquipo().getArmadura().getNombre().equals(e.getNombre())){
                    Juego.jugador.getInventario().addItem(e);
                    Juego.jugador.stats.resistencia_magica -= e.magic_level;
                    Juego.jugador.stats.statsnum.set(5,Juego.jugador.stats.statsnum.get(5)- e.magic_level) ;
                    Juego.jugador.stats.resistencia -= e.physical_level;
                    Juego.jugador.stats.statsnum.set(4,Juego.jugador.stats.statsnum.get(4)- e.physical_level) ;
                }
            }
        }
        
        if (tipo == TipoItem.ARMADURA){
            Juego.jugador.stats.resistencia_magica += magic_level;
            Juego.jugador.stats.statsnum.set(5,Juego.jugador.stats.statsnum.get(5)+ magic_level) ;
            Juego.jugador.stats.resistencia += physical_level;
            Juego.jugador.stats.statsnum.set(4,Juego.jugador.stats.statsnum.get(4)+ physical_level) ;
            Juego.jugador.getEquipo().setArmadura(this);
        } else if(tipo == TipoItem.ARMA){
            Juego.jugador.stats.fuerza += physical_level;
            Juego.jugador.stats.statsnum.set(2,Juego.jugador.stats.statsnum.get(2)+ physical_level) ;
            Juego.jugador.stats.inteligencia += magic_level;
            Juego.jugador.stats.statsnum.set(6,Juego.jugador.stats.statsnum.get(6)+ magic_level) ;
            Juego.jugador.getEquipo().setArma(this);
        }
        Juego.ventanaStats.setEstado();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;


public class EquipoItem extends Item {
    int physical_level; //nivel de ataque o defensa, dependiendo de TipoItem
    int magic_level; //nivel de ataque o defensa, dependiendo de TipoItem
    int range; //Alcance para arcos de flechas o baculos de magos (o tal vez la magia
    //misma deba traer alcance).
    ArrayList<Status> status_list; //Lista de estados de los que protege (ARMADURA) o que puede
    //inflingir el equipo (ARMA, FLECHAS).
    public EquipoItem(){
        physical_level = magic_level = range = 10;
        Status veneno = new Status();
        status_list=new ArrayList<>();
        status_list.add(veneno); 
    }
}

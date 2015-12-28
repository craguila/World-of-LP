/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


public class Equipo {
    EquipoItem ARMADURA;
    EquipoItem ARMA;
    EquipoItem FLECHAS;
    public Equipo(){
        ARMADURA = new EquipoItem(); //hacer un constructor para cada cosa
        ARMA = new EquipoItem();
        FLECHAS = new EquipoItem();
    }
}

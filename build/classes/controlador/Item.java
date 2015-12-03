/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


enum TipoItem {
ARMADURA,
ARMA,
FLECHAS,
DINERO,
POCION_VIDA,
POCION_MANA,
POCION_STAMINA,
}

public class Item {
    int number;          // Para las flechas, requiere el numero.
    String nombre;
    TipoItem tipo;
    String descripcion; //Descripcion de habilidad que posee
    //el item al ser utilizado. Por ejemplo, recuperar la vida del Personaje
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Nicolas olivos
 */
enum TipoStatus{
    VENENO,
    PARALISIS,
    DORMIR,
    PIEDRA
}
public class Status {//Ejemplo: veneno, paralisis, dormir, piedra, ...
    String nombre;
    TipoStatus tipo;/*Preguntar para que sirve"!!!!!!!!*/
    float value; /*Fuerza porcentual del estatus (si es ataque, porcentaje de exito en traspasarlo;
    si es defensa, porcentaje de exito en proteger.)*/
    int duration; //Duracion en turnos.
}

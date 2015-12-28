/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


//enum TipoStatus{
//    "VENENO",
//    "PARALISIS",
//    "DORMIR",
//    "PIEDRA"
//}

public class Status {//Ejemplo: veneno, paralisis, dormir, piedra, ...
    private String nombre;
    private String tipo;/*Preguntar para que sirve"!!!!!!!!*/
    private float value; /*Fuerza porcentual del estatus (si es ataque, porcentaje de exito en traspasarlo;
    si es defensa, porcentaje de exito en proteger.)*/
    public int duration; //Duracion en turnos.
    public Status(){
        nombre = "Veneno";
        tipo = "veneno";
        value= (float) 0.1;
        duration = 10;
        
    }
}

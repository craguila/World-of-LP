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
    private float value; /*Fuerza porcentual del estatus (si es ataque, porcentaje de exito en traspasarlo;
    si es defensa, porcentaje de exito en proteger.)*/
    public int duration; //Duracion en turnos.
    
    public static Status ENVENENADO = new Status("Envenenado",0.5f,5);
    public static Status PARALIZADO = new Status("Paralizado",0.5f,5);
    public static Status CONGELADO = new Status("Congelado",0.5f,5);

    
    public Status(String nombre, float value, int duracion){
        this.nombre = nombre;
        this.value=value;
        this.duration = duracion;
        
    }
}

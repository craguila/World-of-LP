/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;




public class Item {
    public static enum TipoItem {
        ARMADURA,
        ARMA,
        FLECHAS,
        DINERO,
        POCION_VIDA,
        POCION_MANA,
        POCION_STAMINA,
        NADA,
    }
    int number;          // Para las flechas, requiere el numero.
    String nombre;
    TipoItem tipo;
    int precio;
    String descripcion; //Descripcion de habilidad que posee
    //el item al ser utilizado. Por ejemplo, recuperar la vida del Personaje

    public Item(int number, String nombre, TipoItem tipo, String descripcion, int precio) {
        this.number = number;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public int getPrecio(){
        return precio;
    }
    public String getNombre() {
        return nombre;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

public class Inventario {
    int capacidad; //Capacidad del inventario
    int total_actual;
    ArrayList<Item> items;
    public Inventario(){
        capacidad = 10;
        total_actual = 0;
        items=new ArrayList<>();
    }
    
}

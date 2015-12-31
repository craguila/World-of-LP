/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

public class Inventario {
    int capacidad; //Capacidad del inventario
    int total_actual;
    public ArrayList<EquipoItem> items;
    public Inventario(){
        capacidad = 10;
        total_actual = 0;
        items=new ArrayList<>();
    }
    public int getSize(){
        return items.size();
    }
    public void addItem(EquipoItem i){
        
        if (items.size() < capacidad){
            items.add(i);
        }
    }
    public void removeItem(EquipoItem i){
        items.remove(i);
    }
    public void clear(){
        items.clear();
    }
    public ArrayList<EquipoItem> getItems() {
        return items;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cuadro;

import Graficos.Pantalla;
import Graficos.Sprite;

public class CuadroPasto extends Cuadro {
    
    public CuadroPasto(Sprite sprite) {
        super(sprite);
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x, y, this);
    }
    
    public boolean solido(){
        return false; //esta definido antes pero lo dejo como planilla
    }
    
}

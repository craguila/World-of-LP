/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Graficos.Pantalla;
import vista.cuadro.Cuadro;

public abstract class Mapa {
    protected int ancho;
    protected int alto;
    
    protected int[] cuadros;
    
    public Mapa(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        cuadros = new int[ancho*alto];
    }
    
    public Mapa(String ruta){
        cargarMapa(ruta);
    }
    
    protected void generarMapa(){
        
    }
    
    private void cargarMapa(String ruta){
        
    }
    
    public void actualizar(){
        
    }
    
    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla){
        int o = compensacionX >> 5; //si no lo dividimos se mueve un tile y no un pixel
        int e = (compensacionX + pantalla.getAncho()) >> 5; ;
        int n = compensacionY >> 5;
        int s = (compensacionY + pantalla.getLargo()) >> 5;
        
    }
    
    public Cuadro getCuadro(){
        switch(cuadros[x+y*ancho]){
            case 0:
                return Cuadro.pasto;
            default:
                return null;
        }
    }
}

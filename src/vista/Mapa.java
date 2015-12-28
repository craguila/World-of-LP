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
    protected Cuadro[] cuadrosCatalogo;
    
    public Mapa(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        cuadros = new int[ancho*alto];
        generarMapa();
    }
    
    public Mapa(String ruta){
        cargarMapa(ruta);
        generarMapa();
    }
    
    public Cuadro getCuadro(int posicion){
        return cuadrosCatalogo[posicion];
    }
    
    protected void generarMapa(){
        
    }
    
    protected void cargarMapa(String ruta){
        
    }
    
    public void actualizar(){
        
    }
    
    public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla){
        
        pantalla.setDiferencia(compensacionX, compensacionY);
        int o = compensacionX>>5 ; //si no lo dividimos se mueve un tile y no un pixel
        int e = (compensacionX + pantalla.getAncho() + Cuadro.LADO)>>5; 
        int n = compensacionY >>5;
        int s = (compensacionY + pantalla.getLargo()  + Cuadro.LADO)>>5 ;
        
        for (int y=n; y<s; y++){
            for (int x = o; x < e ;x++){
		if (x < 0 || y < 0 || x >= ancho || y >= alto) {
		    Cuadro.AGUA.mostrar(x, y, pantalla);
		} else {
                    cuadrosCatalogo[x+y*ancho].mostrar(x, y, pantalla);
		}
            }
        }
        
    }
    
    public Cuadro getCuadro(final int x, final int y){
        if (x < 0 || y < 0 || x >= ancho || y >= alto) {
	    return Cuadro.VACIO;
	}
        switch(cuadros[x+y*ancho]){
            case 0:
                return Cuadro.PASTO;
            case 1:
                return Cuadro.ARENA;
            case 2:
                return Cuadro.AGUA;
            case 3:
                return Cuadro.MURO;
            default:
                return Cuadro.VACIO;
        }
    }

    public int getAncho() {
        return ancho; 
    }
}

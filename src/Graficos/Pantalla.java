/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import vista.cuadro.Cuadro;


public class Pantalla {
    private final int ancho;
    private final int alto;
    
    private int diferenciaX;
    private int diferenciaY;
    
    public final int[] pixeles;
    

    
    public Pantalla(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        pixeles = new int[ancho*alto];
    }
    
    public void limpiar() {
        for(int i = 0; i<pixeles.length; i++){
            pixeles[i] = 0;
        }
    }
    

    
    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro){
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;
        
        for (int y=0 ; y< cuadro.sprite.getLado();y++){
            int posicionY = y + compensacionY;
            for (int x=0; x<cuadro.sprite.getLado();x++){
                int posicionX = x + compensacionX;
                if(posicionX < 0 || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                pixeles[posicionX + posicionY*ancho] = cuadro.sprite.pixeles[x + y*cuadro.sprite.getLado()];
            }
        }
    }
    
    public void setDiferencia(final int diferenciaX ,final  int diferenciaY){
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }
    public int getAncho(){
        return ancho;
    }
    public int getLargo(){
        return alto;
    }
}

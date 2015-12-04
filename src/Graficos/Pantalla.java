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
    
    public final int[] pixeles;
    
    //temporal
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE -1;
    //fin temporal
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
    
    //temporal
    public void mostrar(final int compensacionX, final int compensacionY){
        for(int y=0; y < alto ;y++){
            int posicionY = y + compensacionY;
            if (posicionY < 0 || posicionY >= alto){
                continue;
            }
            for (int x=0; x<ancho; x++){
                int posicionX = x + compensacionX;
                if (posicionX < 0 || posicionX >= ancho){
                    continue;
                }
                
            //temporal
            pixeles[posicionX + posicionY * ancho] = Sprite.pasto.pixeles[(x & MASCARA_SPRITE)+(y & MASCARA_SPRITE) * LADO_SPRITE];
            }
        }
    }
    //temporal
    
    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro){
        for (int y=0 ; y< cuadro.sprite.getLado();y++){
            int posicionY = y + compensacionY;
            for (int x=0; x<cuadro.sprite.getLado();x++){
                int posicionX = x + compensacionX;
                if(posicionX < 0 || posicionX > ancho || posicionY <0 || posicionY > alto){
                    break;
                }
                pixeles[posicionX + posicionY*ancho] = cuadro.sprite.pixeles[x + y*cuadro.sprite.getLado()];
            }
        }
    }
    
    public int getAncho(){
        return ancho;
    }
    public int getLargo(){
        return alto;
    }
}

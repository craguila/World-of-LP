/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

public class Sprite {
    private final int lado;
    
    private int x;
    private int y;
    
    public int[] pixeles;
    private final HojaSprites hoja;
    
    //coleccion de sprites
    public static Sprite pasto = new Sprite(32,0,0,HojaSprites.nivel1);
    
    //fin de la coleccion
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
        this.lado = lado;
        
        pixeles = new int[this.lado * this.lado];
        this.x = columna * lado;
        this.y = fila*lado;
        this.hoja = hoja;
        
        for (int y = 0; y<lado;y++){
            for (int x=0;y<lado;x++){
                pixeles[(x+y)*lado]=hoja.pixeles[(x + this.x) +(y+this.y)*hoja.getAncho()];
            }
        }
        
        
    
    }
}

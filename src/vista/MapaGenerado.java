/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Random;

public class MapaGenerado extends Mapa{
    private static final Random aleatorio = new Random();
    
    public MapaGenerado(int ancho, int alto) {
        super(ancho, alto);
    }
    
    protected void GenerarMapa(){
        for(int y=0; y<alto; y++){
            for (int x=0; x<ancho; x++){
                int num_ran = aleatorio.nextInt(3);
                System.out.println(num_ran);
                cuadros[x+y*ancho] = num_ran;
            }
        }
    }
}

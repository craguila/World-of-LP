/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import vista.cuadro.Cuadro;

/**
 *
 * @author Administrador
 */
public class MapaCargado extends Mapa{
    
    private int[] pixeles;
    
    public MapaCargado(String ruta) {
        super(ruta);
    }
    
    @Override
    protected void cargarMapa(String ruta){
        try {
            BufferedImage imagen =ImageIO.read(MapaCargado.class.getResource((ruta)));
            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            
            cuadrosCatalogo = new Cuadro[ancho*alto];
            pixeles = new int[ancho*alto];
            
            imagen.getRGB(0,0,ancho, alto,pixeles,0,ancho);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @Override
    protected void generarMapa(){
        for (int i = 0; i<pixeles.length; i++){
            switch(pixeles[i]){
                case 0xff00ff00:
                    cuadrosCatalogo[i]=Cuadro.PASTO;
                    continue;
                case 0xfffee0af:
                    cuadrosCatalogo[i]=Cuadro.ARENA;
                    continue;
                case 0xff31649b:
                    cuadrosCatalogo[i]=Cuadro.AGUA;
                    continue;
                case 0xff696a6a:
                    cuadrosCatalogo[i]=Cuadro.MURO;
                    continue;
                default:
                    cuadrosCatalogo[i]=Cuadro.AGUA;
            }
            
        }
    }
}

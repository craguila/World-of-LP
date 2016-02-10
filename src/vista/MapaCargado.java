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
                case 0xff00dc00:
                    cuadrosCatalogo[i]=Cuadro.PASTO_I;
                    continue;
                case 0xff009800:
                    cuadrosCatalogo[i]=Cuadro.PASTO_SI;
                    continue;
                case 0xff00B500:
                    cuadrosCatalogo[i]=Cuadro.PASTO_SSM;
                    continue;
                case 0xff8DFF8D:
                    cuadrosCatalogo[i]=Cuadro.PASTO_SSD;
                    continue;
                case 0xffC6FFC6:
                    cuadrosCatalogo[i]=Cuadro.PASTO_SSI;
                    continue;
                    
                    
                case 0xffB8DC00:
                    cuadrosCatalogo[i]=Cuadro.PASTO_ARENA;
                    continue;
                case 0xffF3F900:
                    cuadrosCatalogo[i]=Cuadro.ARENA_PASTO;
                    continue;
                case 0xff7BBE00:
                    cuadrosCatalogo[i]=Cuadro.PASTOT_ARENAB;
                    continue;
                case 0xfffee0af:
                    cuadrosCatalogo[i]=Cuadro.ARENA;
                    continue;
                case 0xffA10000:
                    cuadrosCatalogo[i]=Cuadro.CARPA_1;
                    continue;
                case 0xff840000:
                    cuadrosCatalogo[i]=Cuadro.CARPA_2;
                    continue;
                case 0xffE60000:
                    cuadrosCatalogo[i]=Cuadro.CARPA_3;
                    continue;
                case 0xffFF1212:
                    cuadrosCatalogo[i]=Cuadro.CARPA_4;
                    continue;
                case 0xffFF2525:
                    cuadrosCatalogo[i]=Cuadro.CARPA_5;
                    continue;
                case 0xffFF3838:
                    cuadrosCatalogo[i]=Cuadro.CARPA_6;
                    continue;
                case 0xffFF8D8D:
                    cuadrosCatalogo[i]=Cuadro.CARPA_7;
                    continue;
                case 0xffFFAAAA:
                    cuadrosCatalogo[i]=Cuadro.CARPA_8;
                    continue;
                case 0xffFFA0A0:
                    cuadrosCatalogo[i]=Cuadro.CARPA_9;
                    continue;
                case 0xff31649b:
                    cuadrosCatalogo[i]=Cuadro.AGUA;
                    continue;
                case 0xff696a6a:
                    cuadrosCatalogo[i]=Cuadro.MURO;
                    continue;
                case 0xff515151:
                    cuadrosCatalogo[i]=Cuadro.MURO_T;
                    continue;
                case 0xff8E8E8E:
                    cuadrosCatalogo[i]=Cuadro.MURO_B;
                    continue;
                default:
                    cuadrosCatalogo[i]=Cuadro.AGUA;
            }
            
        }
    }
}

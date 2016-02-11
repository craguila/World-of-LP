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
                case 0xff424242:
                    cuadrosCatalogo[i]=Cuadro.VACIO;
                    continue;
                case 0xffFF8500:
                    cuadrosCatalogo[i]=Cuadro.TENT_1;
                    continue;
                case 0xffFF8501:
                    cuadrosCatalogo[i]=Cuadro.TENT_2;
                    continue;
                case 0xffFF8502:
                    cuadrosCatalogo[i]=Cuadro.TENT_3;
                    continue;
                case 0xffFF8503:
                    cuadrosCatalogo[i]=Cuadro.TENT_4;
                    continue;
                case 0xffFF8504:
                    cuadrosCatalogo[i]=Cuadro.TENT_5;
                    continue;
                case 0xffFF8505:
                    cuadrosCatalogo[i]=Cuadro.TENT_6;
                    continue;
                case 0xffFF8506:
                    cuadrosCatalogo[i]=Cuadro.TENT_7;
                    continue;
                case 0xffFF8507:
                    cuadrosCatalogo[i]=Cuadro.TENT_8;
                    continue;
                case 0xffFF8508:
                    cuadrosCatalogo[i]=Cuadro.TENT_9;
                    continue;
                case 0xffFF8509:
                    cuadrosCatalogo[i]=Cuadro.TENT_10;
                    continue;
                case 0xffFF850A:
                    cuadrosCatalogo[i]=Cuadro.TENT_11;
                    continue;
                case 0xffFF850B:
                    cuadrosCatalogo[i]=Cuadro.TENT_12;
                    continue;
                case 0xffFF850C:
                    cuadrosCatalogo[i]=Cuadro.TENT_13;
                    continue;
                case 0xffFF850D:
                    cuadrosCatalogo[i]=Cuadro.TENT_14;
                    continue;
                case 0xffFF850E:
                    cuadrosCatalogo[i]=Cuadro.TENT_15;
                    continue;
                case 0xffFF850F:
                    cuadrosCatalogo[i]=Cuadro.TENT_16;
                    continue;
                case 0xffFF8510:
                    cuadrosCatalogo[i]=Cuadro.TENT_17;
                    continue;
                case 0xffFF8511:
                    cuadrosCatalogo[i]=Cuadro.TENT_18;
                    continue;
                case 0xffFF8512:
                    cuadrosCatalogo[i]=Cuadro.TENT_19;
                    continue;
                case 0xffFF8513:
                    cuadrosCatalogo[i]=Cuadro.TENT_20;
                    continue;
                case 0xffFF8514:
                    cuadrosCatalogo[i]=Cuadro.TENT_21;
                    continue;
                case 0xffFF8515:
                    cuadrosCatalogo[i]=Cuadro.TENT_22;
                    continue;
                case 0xffFF8516:
                    cuadrosCatalogo[i]=Cuadro.TENT_23;
                    continue;
                case 0xffFF8517:
                    cuadrosCatalogo[i]=Cuadro.TENT_24;
                    continue;
                case 0xffFF8518:
                    cuadrosCatalogo[i]=Cuadro.TENT_25;
                    continue;
                case 0xffFF8519:
                    cuadrosCatalogo[i]=Cuadro.TENT_26;
                    continue;
                case 0xffFF851A:
                    cuadrosCatalogo[i]=Cuadro.TENT_27;
                    continue;
                case 0xffFF851B:
                    cuadrosCatalogo[i]=Cuadro.TENT_28;
                    continue;
                case 0xffFF851C:
                    cuadrosCatalogo[i]=Cuadro.TENT_29;
                    continue;
                case 0xffFF851D:
                    cuadrosCatalogo[i]=Cuadro.TENT_30;
                    continue;
                    
                case 0xff31641F:
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

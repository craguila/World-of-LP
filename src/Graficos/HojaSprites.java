/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HojaSprites {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    
    //coleccion de hojas de sprites
    public static HojaSprites nivel1 = new HojaSprites("/texturas/pasto.png",576,320);
    public static HojaSprites texturas = new HojaSprites("/texturas/texturas.png",608,480);
    public static HojaSprites tent = new HojaSprites("/texturas/tent1.png",523,287);
    //fin de la coleccion
    public HojaSprites(final String ruta, final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho*alto];
        
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0,0, ancho, alto, pixeles, 0, ancho);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getAncho(){
        return ancho;
    }
}

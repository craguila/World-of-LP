/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Graficos.Pantalla;
import Graficos.Sprite;
import control.Teclado;
import controlador.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Juego extends Canvas implements Runnable{
    private static final int ANCHO = 500;
    private static final int ALTO = 500;
    private static final String NOMBRE = "World of LP";
    
    private static int aps = 0;
    private static int fps = 0;
    
    private static JFrame ventana;
    private static volatile boolean jugando = false;
    private static Thread thread;
   
    private static Teclado teclado;
    private static Pantalla pantalla;
    
    private static BufferedImage imagen = new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    
    private static Mapa mapa;
    private static Personaje jugador;
    public static ArrayList<Monstruo> monstruos = new ArrayList<>();
    
    
    public Juego(String nombre,int clase){
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        pantalla = new Pantalla(ANCHO,ALTO);
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        mapa = new MapaCargado("/texturas/mapa1.png"); //Aqui se define el ancho del juego en cuadritos
        String tipo = "";
        Stats stats = new Stats();
        Equipo equipo = new Equipo();
        Inventario inventario = new Inventario();
        int[] pos = {445,277};
        switch (clase) {
            case 1: 
                jugador = new Guerrero(mapa,nombre,1,1,stats,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);
                tipo = "Guerrero";
                break;
            case 2:
                jugador = new Arquero(mapa,nombre,1,1,stats,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);
                tipo = "Arquero";
                break;
            default:
                jugador = new Mago(mapa,nombre,1,1,stats,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);
                tipo = "Mago";
                break;
                
        }
        JOptionPane.showMessageDialog(this, "Es un placer conocer por fin a tan renombrado "+ tipo, NOMBRE, 1);
        JOptionPane.showMessageDialog(this,jugador.getNombre()+", tu mision en este mundo mágico consiste en: \n chapalapachala", NOMBRE, 1);  
        //cargamos enemigos
        //creamos los monstruos
        int num_murcielagos = 0;
        int i = 0;
        Random  rnd = new Random();
        while (i < num_murcielagos){
            i++;
            int[] m_pos = {0,0};
            m_pos[0]=(int)(rnd.nextDouble() * 1000);
            m_pos[1]=(int)(rnd.nextDouble() * 1000);
            monstruos.add(new Murcielago(mapa,"Murcielago"+i,1,1,stats,10,10,10,equipo,inventario,m_pos,Sprite.MUABAJO0));
            
        }
        //cargamos items
        
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
    public synchronized void iniciar(){
        jugando = true;
        thread = new Thread(this, "Graficos");
        thread.start();
    }
    
    private synchronized void detener(){
        jugando = false;
        
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    private void actualizar(){
        teclado.actualizar();
        jugador.actualizar();
        for(Monstruo m: monstruos){
            m.actualizar();
        }
        aps++;
    }
    private void mostrar(){
        BufferStrategy estrategia = getBufferStrategy();
        
        if (estrategia == null){
            createBufferStrategy(3);
            return;
        }
        
//        pantalla.limpiar();
        mapa.mostrar(jugador.getX()- pantalla.getAncho()/2 + jugador.getSprite().getLado()/2 , jugador.getY()-pantalla.getLargo()/2 + jugador.getSprite().getLado()/2, pantalla);
        jugador.mostrar(pantalla);
        for (Monstruo m: monstruos){
            m.mostrar(pantalla);
        }
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        
        Graphics g = estrategia.getDrawGraphics();
        
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),null);
        g.setColor(Color.red);
        
        
        g.drawString("x:"+jugador.getX()+" y:"+jugador.getY(), 10, 10);
        
        g.dispose();
        
        estrategia.show();
        fps++;
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte FPS_OBJETIVO = 120;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO/FPS_OBJETIVO;
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempotranscurrido;
        double delta = 0;
        
        requestFocus();
        
        while (jugando){
            final long inicioBucle = System.nanoTime();
            tiempotranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempotranscurrido / NS_POR_ACTUALIZACION;
            while (delta >= 1){
                actualizar();
                delta--;
            }
            mostrar();
            
            if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
                ventana.setTitle(NOMBRE + "|| APS: "+aps+" || FPS: "+fps);
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}

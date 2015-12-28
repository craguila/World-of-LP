/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Graficos.Pantalla;
import Graficos.Sprite;
import control.Teclado;
import controlador.Equipo;
import controlador.Guerreros;
import controlador.Inventario;
import controlador.Personaje;
import controlador.Stats;
import controlador.Arquero;
import controlador.Mago;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;



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
    
    private Juego(){
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        pantalla = new Pantalla(ANCHO,ALTO);
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        mapa = new MapaCargado("/texturas/mapa1.png"); //Aqui se define el ancho del juego en cuadritos
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido a World of LP");
        System.out.println("Ingrese su nombre: ");
        //String nombre = scan.next();
        String nombre = "Pepito";
        Stats stats = new Stats();
        Equipo equipo = new Equipo();
        Inventario inventario = new Inventario();
        int[] pos = {445,277};
        
        jugador = new Arquero(nombre,1,1,stats,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);
        
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
    public static void main(String args[]){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Bienvenido a World of LP");
//        System.out.println("Ingrese su nombre: ");
//        String nombre = scan.next();
//        System.out.println("Indique su clase: (1: Guerrero, 2: Arquero, 3: Mago) ");
//        int clase = 0;
//        while (clase == 0){
//            try {
//                clase = scan.nextInt();
//                while (clase<1 || clase > 3){
//                    System.out.println("La clase debe ser un numero entre 1 y 3");
//                    clase = scan.nextInt();
//                }
//            } catch (Exception e){
//                System.out.println("A partir de ahora será un guerrero, por gil");
//                clase = 1;
//            }
//        }
//        Personaje Heroe;
//        String tipo = "";
//        Stats stats = new Stats();
//        Equipo equipo = new Equipo();
//        Inventario inventario = new Inventario();
//        switch (clase) {
//            case 1: 
//                Heroe = new Guerreros(nombre, 1, 0, stats, 10, 10, 10, equipo, inventario);
//                tipo = "Guerrero";
//                break;
//            case 2:
//                Heroe = new Arquero(nombre, 1, 0, stats, 10, 10, 10, equipo, inventario);
//                tipo = "Arquero";
//                break;
//            default:
//                Heroe = new Mago(nombre, 1, 0, stats, 10, 10, 10, equipo, inventario);
//                tipo = "Mago";
//                break;
//                
//        }
//        System.out.println("Es un placer conocer por fin a tan renombrado "+ tipo);
//        System.out.println(Heroe.getNombre()+", tu mision en este mundo mágico consiste en:");
//        System.out.println("-----------");
        
        
        Juego juego = new Juego();
        
        juego.iniciar();
    }
    
    private synchronized void iniciar(){
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
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        
        Graphics g = estrategia.getDrawGraphics();
        
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),null);
        g.setColor(Color.red);
        
        
        g.drawString("x:"+jugador.getX()+" y:"+jugador.getY(), 10, 10);
        
        g.dispose();
        
        estrategia.show();
        fps++;
    }

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

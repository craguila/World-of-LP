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
    
    public static JFrame ventana;
    private static volatile boolean jugando = false;
    private static Thread thread;
   
    private static Teclado teclado;
    private static Pantalla pantalla;
    
    private static BufferedImage imagen = new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    
    private static Mapa mapa;
    public static Personaje jugador;
    public static ArrayList<Monstruo> monstruos = new ArrayList<>();
    public static ArrayList<Cofre> cofres = new ArrayList<>();
    public static frmStats ventanaStats;
    public static frmHabilidades ventanaHabilidades;
    public static frmMonstruos ventanaMonstruos;
    public static frmInventario ventanaInventario;
    
    public Juego(String nombre,int clase){
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        pantalla = new Pantalla(ANCHO,ALTO);
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        mapa = new MapaCargado("/texturas/mapa1.png"); 
        String tipo;
        Equipo equipo;
        Inventario inventario = new Inventario();
        Random  rndpos = new Random();
        int[] pos = {445,277};
        pos[0]=(int)(rndpos.nextDouble() * 1540);
        pos[1]=(int)(rndpos.nextDouble() * 1537);
        
        equipo=new Equipo(EquipoItem.ARMADURA_GUERRERO, EquipoItem.ARMA_GUERRERO,null);
        jugador = new Guerrero(mapa,nombre,1,0,Stats.STATS_GUERRERO,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);

        while (jugador.hayunmuro(pos[0],pos[1])){
            pos[0]=(int)(rndpos.nextDouble() * 1540);
            pos[1]=(int)(rndpos.nextDouble() * 1537);
        }
        switch (clase) {
            case 1:
                equipo=new Equipo(EquipoItem.ARMADURA_GUERRERO, EquipoItem.ARMA_GUERRERO,null);
                jugador = new Guerrero(mapa,nombre,1,0,Stats.STATS_GUERRERO,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);
                jugador.getHabilidades().add(Habilidad.CORAJE_DIVINO);
                jugador.getHabilidades().add(Habilidad.FURIA_CAOTICA);
                jugador.getHabilidades().add(Habilidad.VELOCIDAD);
                tipo = "Guerrero";
                break;
            case 2:
                equipo=new Equipo(EquipoItem.ARMADURA_ARQUERO, EquipoItem.ARMA_ARQUERO,EquipoItem.FLECHA_ARQUERO);
                jugador = new Arquero(mapa,nombre,1,0, Stats.STATS_ARQUERO,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);
                jugador.getHabilidades().add(Habilidad.INFLINGIR_ENFERMEDAD);
                jugador.getHabilidades().add(Habilidad.LLAMADA_A_LA_NATURALEZA);
                jugador.getHabilidades().add(Habilidad.PRESENTIR);
                tipo = "Arquero";
                break;
            default:
                equipo=new Equipo(EquipoItem.ARMADURA_MAGO, EquipoItem.ARMA_MAGO,null);
                jugador = new Mago(mapa,nombre,1,0, Stats.STATS_MAGO,10,10,10,equipo,inventario,teclado,pos,Sprite.ABAJO0);
                jugador.getHabilidades().add(Habilidad.DESORDEN_DE_LA_REALIDAD);
                jugador.getHabilidades().add(Habilidad.CONGELAR_ALMA);
                jugador.getHabilidades().add(Habilidad.PARADOJA_TEMPORAL);
                tipo = "Mago";
                break;
                
        }
        ventanaStats=new frmStats(jugador);
        ventanaStats.setResizable(false);
        ventanaHabilidades=new frmHabilidades(jugador);
        ventanaHabilidades.setResizable(false);
        ventanaMonstruos=new frmMonstruos(jugador);
        ventanaMonstruos.setResizable(false);
        ventanaInventario=new frmInventario(jugador);
        ventanaInventario.setResizable(false);
        JOptionPane.showMessageDialog(this, "Es un placer conocer por fin a tan renombrado "+ tipo, NOMBRE, 1);
        JOptionPane.showMessageDialog(this,jugador.getNombre()+", tu mision en este mundo mágico consiste en: \n ", NOMBRE, 1);
        //agregamos los cofres;
        Random  rnd = new Random();
        int num_cofres = 10;
        int i = 0;
        while (i < num_cofres){
            i++;
            int[] m_pos = {0,0};
            m_pos[0]=(int)(rnd.nextDouble() * 1540);
            m_pos[1]=(int)(rnd.nextDouble() * 1537);
            if (!jugador.hayunmuro(m_pos[0],m_pos[1])){
                //poner todo en 0
                cofres.add(new Cofre(mapa,"Cofre"+i,1,0, Stats.STATS_MONSTRUO,10,10,10,equipo,inventario,m_pos,Sprite.COFRE));
            }
        }
        //cargamos enemigos
        //creamos los monstruos
        int num_murcielagos = 10;
        int num_tigres = 10;
        int num_lobos = 10;
        int num_gatos = 10;
        int num_esq = 10;
        i=0;
        rnd = new Random();
        while (i < num_murcielagos){
            i++;
            int[] m_pos = {0,0};
            m_pos[0]=(int)(rnd.nextDouble() * 1540);
            m_pos[1]=(int)(rnd.nextDouble() * 1537);
            if (!jugador.hayunmuro(m_pos[0],m_pos[1])){
                monstruos.add(new Murcielago(mapa,"Murcielago"+i,1,0, Stats.STATS_MONSTRUO,10,10,10,equipo,inventario,m_pos,Sprite.MUABAJO0));
            }
        }
        i = 0;
        rnd = new Random();
        while (i < num_tigres){
            i++;
            int[] m_pos = {0,0};
            m_pos[0]=(int)(rnd.nextDouble() * 1540);
            m_pos[1]=(int)(rnd.nextDouble() * 1537);
            if (!jugador.hayunmuro(m_pos[0],m_pos[1])){
                monstruos.add(new Tigre(mapa,"Tigre"+i,1,0, Stats.STATS_MONSTRUO,10,10,10,equipo,inventario,m_pos,Sprite.TABAJO0));
            }
        }
        i = 0;
        rnd = new Random();
        while (i < num_lobos){
            i++;
            int[] m_pos = {0,0};
            m_pos[0]=(int)(rnd.nextDouble() * 1540);
            m_pos[1]=(int)(rnd.nextDouble() * 1537);
            if (!jugador.hayunmuro(m_pos[0],m_pos[1])){
                monstruos.add(new Lobo(mapa,"Lobo"+i,1,0, Stats.STATS_MONSTRUO,10,10,10,equipo,inventario,m_pos,Sprite.LABAJO0));
            }
        }
        i = 0;
        rnd = new Random();
        while (i < num_gatos){
            i++;
            int[] m_pos = {0,0};
            m_pos[0]=(int)(rnd.nextDouble() * 1540);
            m_pos[1]=(int)(rnd.nextDouble() * 1537);
            if (!jugador.hayunmuro(m_pos[0],m_pos[1])){
                monstruos.add(new Gato(mapa,"Gato"+i,1,0, Stats.STATS_MONSTRUO,10,10,10,equipo,inventario,m_pos,Sprite.GABAJO0));
            }
        }
        i = 0;
        rnd = new Random();
        while (i < num_esq){
            i++;
            int[] m_pos = {0,0};
            m_pos[0]=(int)(rnd.nextDouble() * 1540);
            m_pos[1]=(int)(rnd.nextDouble() * 1537);
            if (!jugador.hayunmuro(m_pos[0],m_pos[1])){
                monstruos.add(new Esqueleto(mapa,"Esqueleto"+i,1,0, Stats.STATS_MONSTRUO,10,10,10,equipo,inventario,m_pos,Sprite.EABAJO0));
            }
        }
        
        //cargamos items
        
        
        ventana = new JFrame(NOMBRE);
        ventana.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                ventanaStats.setLocation(ventana.getLocation().x-ventanaStats.getWidth(), ventana.getLocation().y);
                ventanaHabilidades.setLocation(ventana.getLocation().x+ventana.getWidth()-ventanaHabilidades.getWidth(),
                        ventana.getLocation().y+ventana.getHeight());
                ventanaMonstruos.setLocation(ventana.getLocation().x,ventana.getLocation().y+ventana.getHeight());
                ventanaInventario.setLocation(ventana.getLocation().x+ventana.getWidth(), ventana.getLocation().y);
                ventanaInventario.setVisible(true);
            }
        });
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
        if (jugador.actualizar()){
            
        ventanaStats.setEstado();
        ventanaHabilidades.setEstado();
        ventanaMonstruos.setEstado();
        ventanaInventario.setEstado();
        for(Monstruo m: monstruos){
            m.actualizar(); 
        }}
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
        for (Cofre c: cofres){
            c.mostrar(pantalla);
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

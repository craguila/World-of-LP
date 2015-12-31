/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{

    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean inventario;
    public boolean atacar;
    public boolean usarhabilidad;
    public boolean abrircofre;
    public boolean abrirstats;
    
    public void actualizar(){
        arriba = teclas[KeyEvent.VK_UP];
        abajo = teclas[KeyEvent.VK_DOWN];
        izquierda = teclas[KeyEvent.VK_LEFT];
        derecha = teclas[KeyEvent.VK_RIGHT];
        inventario = teclas[KeyEvent.VK_Z];
        atacar = teclas[KeyEvent.VK_X];
        usarhabilidad = teclas[KeyEvent.VK_C];
        abrircofre = teclas[KeyEvent.VK_SPACE];
        abrirstats = teclas[KeyEvent.VK_S];
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()]= true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()]= false;
    }
    
}

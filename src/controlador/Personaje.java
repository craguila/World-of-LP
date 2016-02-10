
package controlador;

import Graficos.Pantalla;
import Graficos.Sprite;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JOptionPane;
import vista.Juego;
import vista.Mapa;
import vista.frmStats;


public class Personaje {
    protected Sprite sprite;
    String Nombre;
    int Nivel; //Aumenta en base a la experiencia y aumenta atributos segun
    //esquema definido por usted.
    int EXP; // Deben generar esquema de obtencion de nivel por logro de valor
    // de experiencia.
    Stats stats;//Todos los stats del personaje
    int Vida; //Muere si llega a 0.
    int VidaMAX;
    int ManaMAX;
    int Stamina; //No puede golpear si no le alcanza el valor.
    int Mana; 
    int[] posicion=new int[2];
    int dinero;
    Equipo equipo;
    
    protected Mapa mapa;
    
    private Inventario inventario;
    private ArrayList<Status> status;    
    private ArrayList<Habilidad> habilidades;
    private ArrayList<String> monstruosVisibles;
    protected char direccion = 'n';

    public Personaje(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion) {
        this.mapa = mapa;
        this.Nombre = Nombre;
        this.Nivel = Nivel;
        this.EXP = EXP;
        this.stats = stats;
        this.Vida = Vida;
        this.VidaMAX = Vida;
        this.ManaMAX = Mana;
        this.Stamina = Stamina;
        this.Mana = Mana;
        this.equipo = equipo;
        this.inventario = inventario;
        this.posicion = posicion;
        habilidades = new ArrayList<>();
        status = new ArrayList<>();
        monstruosVisibles = new ArrayList<>();
        this.dinero = 0;
        
    }
    
    public void releaseTeclado(){
        Robot rob = null;
        try{
            rob=new Robot();
        }
        catch(Exception e){   
        }
        rob.keyRelease(KeyEvent.VK_SPACE);
        rob.keyRelease(KeyEvent.VK_UP);
        rob.keyRelease(KeyEvent.VK_DOWN);
        rob.keyRelease(KeyEvent.VK_LEFT);
        rob.keyRelease(KeyEvent.VK_RIGHT);
        rob.keyRelease(KeyEvent.VK_S);
        rob.keyRelease(KeyEvent.VK_Z);
        rob.keyRelease(KeyEvent.VK_X);
        rob.keyRelease(KeyEvent.VK_C);
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public void addHabilidad(Habilidad h){
        habilidades.add(h);
    }
    public void addStatus(Status s){
        status.add(s);
    }
    public void aumentarExp(int exp){
        if((this.EXP+exp)>=expSiguienteLvl(this.Nivel)){
            exp=this.EXP+exp-expSiguienteLvl(this.Nivel);
            subirLvl();
            this.EXP=0;
            JOptionPane.showMessageDialog(null, getNombre()+" ,haz subido al Nivel: "+getNivel(), "World of LP", 1);
            frmStats.puntosStats+=3;
            aumentarExp(exp);
            return;
        }
        this.EXP+=exp;
    }
    
    public ArrayList<Status> getStatus(){
        return status;
    }
    public void quitarStatus(Status s){
        status.remove(s);
    }
    public void ganarDinero(int d){
        dinero += d;
        Juego.setConsole("Ganaste " +d+" monedas.");
        
    }
    
    public boolean gastarDinero(int d){
        if (this.dinero >= d){
            this.dinero-=d;
            return true;
        }
        return false;
    }
    
    public int getDinero(){
        return dinero;
    }
    public int expSiguienteLvl(int lvl){
        double exp=0;
        double NA=(1+Math.pow(5, 0.5))/2;
        exp=(Math.pow(NA, lvl+7)-Math.pow(1-NA, lvl+7))/Math.pow(5, 0.5);
        return (int) exp;
    }
    
    public void subirLvl(){
        this.Nivel +=1;
        this.VidaMAX+=10;
        this.ManaMAX+=7;
        this.Vida=VidaMAX;
        this.Mana=ManaMAX;
    }
    
    public void mejorar(){
        Random ran =new Random(new Date().getTime());
        stats.radio_vision+=ran.nextInt(1);
        stats.rapidez+=ran.nextInt(1);
        stats.fuerza+=ran.nextInt(1);
        stats.destreza+=ran.nextInt(1);
        stats.resistencia+=ran.nextInt(1);
        stats.resistencia_magica+=ran.nextInt(1);
        stats.inteligencia+=ran.nextInt(1);
        stats.stamina+=ran.nextInt(1);
        stats.constitucion+=ran.nextInt(1);
    }
    
    public int getNivel(){
        return this.Nivel;
    }
    public int getMana(){
        return this.Mana;
    }
    public void gastarMana(int m){
        this.Mana -= m;
    }
    public int getEXP(){
        return this.EXP;
    }
    
    
    public String getNombre(){
        return Nombre;
    }
    
    public int getX(){
        return posicion[0];
    }
    public int getY(){
        return posicion[1];
    }
    public void changeX(int desplazamientoX){
        posicion[0] += desplazamientoX;
    }
    public void changeY(int desplazamientoY){
        posicion[1]+= desplazamientoY;
    }
    public boolean vivo(){
        return Vida>0;
    }
    public Equipo getEquipo(){
        return equipo;
    }
    
    public void mover(int desplazamientoX, int desplazamientoY){
        if (desplazamientoX > 0){
            direccion = 'e';
        }
        if (desplazamientoX<0){
            direccion = 'o';
        }
        if (desplazamientoY>0){
            direccion = 's';
        }
        if (desplazamientoY<0){
            direccion = 'n';
        }
        if (vivo()){
            if (!sienteelchoque(desplazamientoX,0)){
                changeX(desplazamientoX);
            }
            if (!sienteelchoque(0,desplazamientoY)){
                changeY(desplazamientoY);
            }
        }
    }   
    
    public synchronized boolean sienteelchoque(int desplazamientoX, int desplazamientoY){
        boolean colision = false;
        int posicionX = posicion[0] + desplazamientoX;
        int posicionY = posicion[1] + desplazamientoY;
        
        int margenIzquierdo = -23; 
        int margenDerecho = 26;
        
        int margenSuperior = -20;
        int margenInferior = 29;
        
        int bordeIzquierdo = (posicionX + margenDerecho)/sprite.getLado();
        int bordeDerecho = (posicionX+ margenDerecho + margenIzquierdo)/sprite.getLado();
        int bordeSuperior = (posicionY+ margenInferior)/sprite.getLado();
        int bordeInferior = (posicionY+ margenInferior + margenSuperior)/sprite.getLado();
        //si hay un enemigo,
        //siente el choque!
                
        for(Monstruo m: Juego.monstruos){
            int lado_monstruo =m.getSprite().getLado();
            //esquinas del monstruo
            int monstruoX = m.posicion[0]-lado_monstruo+5;
            int monstruoY = m.posicion[1]-lado_monstruo;
            int monstruoX2 = m.posicion[0];
            int monstruoY2 = m.posicion[1];
            //esquinas del jugador
            int playerX = posicionX + margenIzquierdo+18;
            int playerX2 = posicionX - margenIzquierdo- margenDerecho - sprite.getLado()+18;
            int playerY = posicionY + margenSuperior;
            int playerY2 = posicionY + margenSuperior + margenInferior + sprite.getLado();

            if (playerX>monstruoX && playerX<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                colision = true;
            }
            if (playerX2>monstruoX && playerX2<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                colision = true;
            }
               
            
        }
        //busca los cofres
        for(Cofre c: Juego.cofres){
            int lado_monstruo =c.getSprite().getLado();
            //esquinas del monstruo
            int monstruoX = c.posicion[0]-lado_monstruo+5;
            int monstruoY = c.posicion[1]-lado_monstruo;
            int monstruoX2 = c.posicion[0];
            int monstruoY2 = c.posicion[1];
            //esquinas del jugador
            int playerX = posicionX + margenIzquierdo+18;
            int playerX2 = posicionX - margenIzquierdo- margenDerecho - sprite.getLado()+18;
            int playerY = posicionY + margenSuperior;
            int playerY2 = posicionY + margenSuperior + margenInferior + sprite.getLado();

            if (playerX>monstruoX && playerX<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                colision = true;
            }
            if (playerX2>monstruoX && playerX2<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                colision = true;
            }
               
            
        }
        //busca los teleports
        for(Teleport c: Juego.teleports){
            int lado_monstruo =c.getSprite().getLado();
            //esquinas del monstruo
            int monstruoX = c.posicion[0]-lado_monstruo+5;
            int monstruoY = c.posicion[1]-lado_monstruo;
            int monstruoX2 = c.posicion[0];
            int monstruoY2 = c.posicion[1];
            //esquinas del jugador
            int playerX = posicionX + margenIzquierdo+18;
            int playerX2 = posicionX - margenIzquierdo- margenDerecho - sprite.getLado()+18;
            int playerY = posicionY + margenSuperior;
            int playerY2 = posicionY + margenSuperior + margenInferior + sprite.getLado();

            if (playerX>monstruoX && playerX<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                this.mover(c.gettoX()-posicion[0] , c.gettoY()-posicion[1]);
            }
            if (playerX2>monstruoX && playerX2<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                this.mover(c.gettoX()-posicion[0] , c.gettoY()-posicion[1]);
            }
               
            
        }
        //busca los npc
        for(Npc c: Juego.npcs){
            int lado_monstruo =c.getSprite().getLado();
            //esquinas del monstruo
            int monstruoX = c.posicion[0]-lado_monstruo+5;
            int monstruoY = c.posicion[1]-lado_monstruo;
            int monstruoX2 = c.posicion[0];
            int monstruoY2 = c.posicion[1];
            //esquinas del jugador
            int playerX = posicionX + margenIzquierdo+18;
            int playerX2 = posicionX - margenIzquierdo- margenDerecho - sprite.getLado()+18;
            int playerY = posicionY + margenSuperior;
            int playerY2 = posicionY + margenSuperior + margenInferior + sprite.getLado();

            if (playerX>monstruoX && playerX<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                colision = true;
            }
            if (playerX2>monstruoX && playerX2<monstruoX2 && playerY>monstruoY && playerY<monstruoY2){
                colision = true;
            }
               
            
        }
        
        if(mapa.getCuadro(bordeIzquierdo + bordeSuperior * mapa.getAncho()).esSolido()){
            colision = true;
        }
        if(mapa.getCuadro(bordeDerecho + bordeSuperior * mapa.getAncho()).esSolido()){
            colision = true;
        } 
        if(mapa.getCuadro(bordeIzquierdo + bordeInferior * mapa.getAncho()).esSolido()){
            colision = true;
        } 
        if(mapa.getCuadro(bordeDerecho + bordeInferior * mapa.getAncho()).esSolido()){
            colision = true;
        }
        return colision;
    }

    public boolean hayunmuro(int x, int y){
        boolean colision = false;
        int posicionX = x;
        int posicionY = y;
        
        int margenIzquierdo = -23; //cambiar despues
        int margenDerecho = 26;
        
        int margenSuperior = -20;
        int margenInferior = 29;
        
        int bordeIzquierdo = (posicionX + margenDerecho)/sprite.getLado();
        int bordeDerecho = (posicionX+ margenDerecho + margenIzquierdo)/sprite.getLado();
        int bordeSuperior = (posicionY+ margenInferior)/sprite.getLado();
        int bordeInferior = (posicionY+ margenInferior + margenSuperior)/sprite.getLado();
 
        if(mapa.getCuadro(bordeIzquierdo + bordeSuperior * mapa.getAncho()).esSolido()){
            colision = true;
        }
        if(mapa.getCuadro(bordeDerecho + bordeSuperior * mapa.getAncho()).esSolido()){
            colision = true;
        } 
        if(mapa.getCuadro(bordeIzquierdo + bordeInferior * mapa.getAncho()).esSolido()){
            colision = true;
        } 
        if(mapa.getCuadro(bordeDerecho + bordeInferior * mapa.getAncho()).esSolido()){
            colision = true;
        }
        return colision;
    }
    
    public ArrayList<String> getMonsruosVisibles(){
        return this.monstruosVisibles;
    }
    
    public void buscarmonstruos(){
        monstruosVisibles.clear();
        int playerx = posicion[0];
        int playery = posicion[1];
        int vision = stats.radio_vision*32;
        for (Monstruo m:Juego.monstruos){
            int monsterx = m.posicion[0];
            int monstery = m.posicion[1];
            if (((playerx - vision)<monsterx) && ((playerx + vision) > monsterx)){
                if (((playery -vision) < monstery )&& ((playery + vision) > monstery) ){
                    monstruosVisibles.add(m.Nombre);
                }
            }
        }
    }
        
        
    public boolean actualizar() {
        return false;
    }
    public Sprite getSprite(){
        return sprite;
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarJugador(posicion[0], posicion[1], this);
        
    }

    public Stats getStats() {
        return this.stats;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return this.habilidades;
    }
    
    public void danar(int dano){
        int resistencia = this.stats.resistencia;
        
        if (vivo()){
            if (dano >= resistencia){
                Vida -= (dano-resistencia);
            } else{
                Vida --;
            }
            if (Vida<=0){
                Vida = 0;
            }
        }
    }

    public int getVida() {
        return this.Vida;
    }
    private static int rec = 0;
    void recuperarse() {
        if (rec>500){
            Vida+=this.stats.getConstitucion();
            Mana+=this.stats.getInteligencia();
            if (Mana>ManaMAX){
                Mana = ManaMAX;
            }
            if(Vida>VidaMAX){
                Vida=VidaMAX;
            }
            rec = 0;
        } else {
            rec ++;
        }
    }
}

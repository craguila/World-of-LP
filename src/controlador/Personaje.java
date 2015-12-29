
package controlador;

import Graficos.Pantalla;
import Graficos.Sprite;
import java.util.Random;
import javax.swing.JOptionPane;
import vista.Juego;
import vista.Mapa;


public class Personaje {
    protected Sprite sprite;
    String Nombre;
    int Nivel; //Aumenta en base a la experiencia y aumenta atributos segun
    //esquema definido por usted.
    int EXP; // Deben generar esquema de obtencion de nivel por logro de valor
    // de experiencia.
    Stats stats;//Todos los stats del personaje
    int Vida; //Muere si llega a 0.
    int Stamina; //No puede golpear si no le alcanza el valor.
    int Mana; //Muere si llega a 0.
    int[] posicion=new int[2];
    Equipo equipo;
    Inventario inventario;
    protected Mapa mapa;
    
    protected char direccion = 'n';

    public Personaje(Mapa mapa, String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion) {
        this.mapa = mapa;
        this.Nombre = Nombre;
        this.Nivel = Nivel;
        this.EXP = EXP;
        this.stats = stats;
        this.Vida = Vida;
        this.Stamina = Stamina;
        this.Mana = Mana;
        this.equipo = equipo;
        this.inventario = inventario;
        this.posicion = posicion;
    }
    
    public void aumentarExp(int exp){
        if((this.EXP+exp)>=expSiguienteLvl(this.Nivel)){
            exp=this.EXP+exp-expSiguienteLvl(this.Nivel);
            subirLvl();
            this.EXP=0;
            JOptionPane.showMessageDialog(null, getNombre()+" ,haz subido al Nivel: "+getNivel(), "World of LP", 1);
            aumentarExp(exp);
            return;
        }
        this.EXP+=exp;
    }
    
    public int expSiguienteLvl(int lvl){
        double exp=0;
        double NA=(1+Math.pow(5, 0.5))/2;
        exp=(Math.pow(NA, lvl+7)-Math.pow(1-NA, lvl+7))/Math.pow(5, 0.5);
        return (int) exp;
    }
    
    public void subirLvl(){
        mejorar();
        this.Nivel +=1;
    }
    
    public void mejorar(){
        Random ran =new Random();
        stats.radio_vision+=ran.nextInt(Nivel);
        stats.rapidez+=ran.nextInt(Nivel);
        stats.fuerza+=ran.nextInt(Nivel);
        stats.destreza+=ran.nextInt(Nivel);
        stats.resistencia+=ran.nextInt(Nivel);
        stats.resistencia_magica+=ran.nextInt(Nivel);
        stats.inteligencia+=ran.nextInt(Nivel);
        stats.stamina+=ran.nextInt(Nivel);
        stats.constitucion+=ran.nextInt(Nivel);
    }
    
    public int getNivel(){
        return this.Nivel;
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
    
    private boolean sienteelchoque(int desplazamientoX, int desplazamientoY){
        boolean colision = false;
        int posicionX = posicion[0] + desplazamientoX;
        int posicionY = posicion[1] + desplazamientoY;
        
        int margenIzquierdo = -23; //cambiar despues
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
//            if (posicionX + margenDerecho > monstruoX && posicionX + margenDerecho < monstruoX + lado_monstruo){
//                if (posicionY + margenInferior > monstruoY && posicionY + margenInferior < monstruoX + lado_monstruo){
//monstruoX > bordeDerecho && monstruoY< bordeSuperior && monstruoY > bordeInferior ){
               
            
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

    public void actualizar() {
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
}

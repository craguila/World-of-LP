
package controlador;

import Graficos.Pantalla;
import Graficos.Sprite;
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

    public Personaje(String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion) {
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
            changeX(desplazamientoX);
            changeY(desplazamientoY);
        }
    }   
    
    private boolean sienteelchoque(){
        return false;
    }

    public void actualizar() {
    }
    public Sprite getSprite(){
        return sprite;
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarJugador(posicion[0], posicion[1], this);
        
    }
}

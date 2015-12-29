/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Nicolas olivos
 */
public class Stats {
   // Atributos: Debe especificar esquema de uso de atributos en batalla y durante los desplazamientos.
    int radio_vision; //radio de vision usando distancia d, con rango de puntos (x,y) visibles:
    //|posxy[0] { x| <= d y |posxy[1] { y| <= d
    int rapidez; //Cuanto puede desplazarse el personaje o monstruo, por turno.
    int fuerza;    //Golpes fisicos
    int destreza; //Esquivar ataques y precision ataque distancia.
    int resistencia;  //Mas resistencia disminuye da~nos fsicos.
    int resistencia_magica; //Mas resistencia disminuye da~nos magicos.
    int inteligencia; //Cantidad de mana disponible y velocidad de recuperacion de la misma.
    int stamina;   //Cantidad de energa para uso de golpes especiales y aumenta potencial de \% de golpes crticos. Mas stamina aumenta energa y velocidad de           // recuperacion.
    int constitucion; //Afecta cantidad maxima de vida y recuperacion de vida por turno (cuando no
    //esta en batal 
    
    public static Stats STATS_GUERRERO=new Stats(5, 10, 10, 8, 15, 10, 10, 13, 15);
    public static Stats STATS_ARQUERO=new Stats(8, 7, 6, 10, 12, 8, 12, 15, 10);
    public static Stats STATS_MAGO=new Stats(10, 5, 4, 3, 10, 15, 15, 10, 15);
    public static Stats STATS_MONSTRUO=new Stats(1, 1, 1, 1, 1, 1, 1, 1, 1);

    public Stats(int radio_vision, int rapidez, int fuerza, int destreza, int resistencia, int resistencia_magica, int inteligencia, int stamina, int constitucion) {
        this.radio_vision = radio_vision;
        this.rapidez = rapidez;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.resistencia = resistencia;
        this.resistencia_magica = resistencia_magica;
        this.inteligencia = inteligencia;
        this.stamina = stamina;
        this.constitucion = constitucion;
    }
    
    
    public Stats(){
        this(10,10,10,10,10,10,10,10,10);
    }

    public int getDestreza() {
        return destreza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getRadio_vision() {
        return radio_vision;
    }

    public int getRapidez() {
        return rapidez;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getResistencia_magica() {
        return resistencia_magica;
    }

    public int getStamina() {
        return stamina;
    }

    public int getConstitucion() {
        return this.constitucion;
    }
}
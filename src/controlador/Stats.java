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
    public Stats(){
        radio_vision = rapidez = fuerza = destreza = resistencia = resistencia_magica = 
                inteligencia = stamina = constitucion = 10;
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
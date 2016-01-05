/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

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
    ArrayList<Integer> statsnum;
    
    public static Stats STATS_GUERRERO=new Stats(2, 5, 5, 4, 7, 5, 5, 6, 7);
    public static Stats STATS_ARQUERO=new Stats(4, 3, 3, 5, 6, 4, 6, 7, 5);
    public static Stats STATS_MAGO=new Stats(5, 2, 2, 1, 5, 7, 7, 5, 7);
    public static Stats STATS_MONSTRUO=new Stats(5, 5, 1, 1, 1, 1, 1, 1, 1);

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
        this.statsnum = new ArrayList<>();
        this.statsnum.add(radio_vision);//0
        this.statsnum.add(rapidez);//1
        this.statsnum.add(fuerza);//2
        this.statsnum.add(destreza);//3
        this.statsnum.add(resistencia);//4
        this.statsnum.add(resistencia_magica);//5
        this.statsnum.add(inteligencia);//6
        this.statsnum.add(stamina);//7
        this.statsnum.add(constitucion);//8
        
    }
    
    @Override
    public String toString(){
        return "<html> STATS<br> "
                + "Radio Vision: "+this.radio_vision+".<br> "
                + "Rapidez: "+this.rapidez+".<br> "
                + "Fuerza: "+this.fuerza+".<br> "
                + "Destreza: "+this.destreza+".<br> "
                + "Resistencia: "+this.resistencia+".<br> "
                + "Resistencia Magica: "+this.resistencia_magica+".<br> "
                + "Inteligencia: "+this.inteligencia+".<br> "
                + "Stamina: "+this.stamina+".<br> "
                + "Constitucion: "+this.constitucion+".<br> </html>";
    }
    
    public Stats(){
        this(10,10,10,10,10,10,10,10,10);
    }

    public void reestablecerStats(){
        
        this.radio_vision = statsnum.get(0);
        this.rapidez = statsnum.get(1);
        this.fuerza = statsnum.get(2);
        this.destreza = statsnum.get(3);
        this.resistencia = statsnum.get(4);
        this.resistencia_magica = statsnum.get(5);
        this.inteligencia = statsnum.get(6);
        this.stamina = statsnum.get(7);
        this.constitucion = statsnum.get(8);        
    }
    public void statusStats(float f){
        this.radio_vision = (int) (statsnum.get(0)*f);
        this.rapidez = (int) (statsnum.get(1)*f);
        this.fuerza = (int) (statsnum.get(2)*f);
        this.destreza = (int) (statsnum.get(3)*f);
        this.resistencia = (int) (statsnum.get(4)*f);
        this.resistencia_magica = (int) (statsnum.get(5)*f);
        this.inteligencia = (int) (statsnum.get(6)*f);
        this.stamina = (int) (statsnum.get(7)*f);
        this.constitucion = (int) (statsnum.get(8)*f);
    }
    
    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
        this.statsnum.set(8, constitucion);
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
        this.statsnum.set(3, destreza);
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
        this.statsnum.set(2, fuerza);
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
        this.statsnum.set(6, inteligencia);
    }

    public void setRadio_vision(int radio_vision) {
        this.radio_vision = radio_vision;
        this.statsnum.set(0, radio_vision);
    }

    public void setRapidez(int rapidez) {
        this.rapidez = rapidez;
        this.statsnum.set(1, rapidez);
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
        this.statsnum.set(4, resistencia);
    }

    public void setResistencia_magica(int resistencia_magica) {
        this.resistencia_magica = resistencia_magica;
        this.statsnum.set(5, resistencia_magica);
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
        this.statsnum.set(7, stamina);
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
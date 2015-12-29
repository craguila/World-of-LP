/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


public class Habilidad {
    public String nombre; //nombre de la habilidad
    public int dano; //daño que produce
    public String estado; //estado que genera en el enemigo (quemado, paralizado, ...)
    private int costo;
    
    public static Habilidad FURIA_CAOTICA=new Habilidad("Furia Caotica", 26, "paralizado", 9);
    public static Habilidad CORAJE_DIVINO=new Habilidad("Coraje Divino", 24, "paralizado", 8);
    public static Habilidad VELOCIDAD=new Habilidad("Velocidad", 9, "paralizado", 2);
    public static Habilidad INFLINGIR_ENFERMEDAD=new Habilidad("Inflingir enfermedad", 15, "envenenado", 4);
    public static Habilidad LLAMADA_A_LA_NATURALEZA=new Habilidad("Llamada a la naturaleza", 9, "envenenado", 3);
    public static Habilidad PRESENTIR=new Habilidad("Presentir", 7, "envenenado", 2);
    public static Habilidad DESORDEN_DE_LA_REALIDAD=new Habilidad("Desorden de la realidad", 20, "congelado", 10);
    public static Habilidad CONGELAR_ALMA=new Habilidad("Congelar alma", 16, "congelado", 8);
    public static Habilidad PARADOJA_TEMPORAL=new Habilidad("Paradoja temporal", 13, "paralizado", 2);
                
    
    public Habilidad(String nombre, int dano, String estado, int costo){
        this.nombre = nombre;
        this.dano = dano;
        this.estado = estado;
        this.costo = costo;
       
    }
    
    
}

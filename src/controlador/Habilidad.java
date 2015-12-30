/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


public class Habilidad {
    public String nombre; //nombre de la habilidad
    public int dano; //daño que produce
    public Status estado; //estado que genera en el enemigo (quemado, paralizado, ...)
    public int costo;
    
    public static Habilidad FURIA_CAOTICA=new Habilidad("Furia Caotica", 26, Status.PARALIZADO, 9);
    public static Habilidad CORAJE_DIVINO=new Habilidad("Coraje Divino", 24, Status.PARALIZADO, 8);
    public static Habilidad VELOCIDAD=new Habilidad("Velocidad", 9, Status.PARALIZADO, 2);
    public static Habilidad INFLINGIR_ENFERMEDAD=new Habilidad("Inflingir enfermedad", 15, Status.ENVENENADO, 4);
    public static Habilidad LLAMADA_A_LA_NATURALEZA=new Habilidad("Llamada a la naturaleza", 9, Status.ENVENENADO, 3);
    public static Habilidad PRESENTIR=new Habilidad("Presentir", 7, Status.ENVENENADO, 2);
    public static Habilidad DESORDEN_DE_LA_REALIDAD=new Habilidad("Desorden de la realidad", 20, Status.CONGELADO, 10);
    public static Habilidad CONGELAR_ALMA=new Habilidad("Congelar alma", 16, Status.CONGELADO, 8);
    public static Habilidad PARADOJA_TEMPORAL=new Habilidad("Paradoja temporal", 13, Status.PARALIZADO, 2);
                
    
    public Habilidad(String nombre, int dano, Status estado, int costo){
        this.nombre = nombre;
        this.dano = dano;
        this.estado = estado;
        this.costo = costo;
       
    }
    
    
}

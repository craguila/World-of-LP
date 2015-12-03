/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


class Habilidad {
    public String nombre; //nombre de la habilidad
    public int dano; //daño que produce
    public String estado; //estado que genera en el enemigo (quemado, paralizado, ...)
    private int costo;
    
    public Habilidad(String nombre, int dano, String estado, int costo){
        this.nombre = nombre;
        this.dano = dano;
        this.estado = estado;
        this.costo = costo;
       
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


public class Equipo {
    EquipoItem ARMADURA;
    EquipoItem ARMA;
    EquipoItem FLECHAS;

    public Equipo(EquipoItem ARMADURA, EquipoItem ARMA, EquipoItem FLECHAS) {
        this.ARMADURA = ARMADURA;
        this.ARMA = ARMA;
        this.FLECHAS = FLECHAS;
    }
    public EquipoItem getArmadura(){
        return ARMADURA;
    }
    public EquipoItem getArma(){
        return ARMA;
    }
    public EquipoItem getFlechas(){
        return FLECHAS;
    }
        
    public void setArmadura(EquipoItem ARMADURA){
        this.ARMADURA = ARMADURA;
    }
    public void setArma(EquipoItem ARMA){
        this.ARMA = ARMA;
    }
    public void setFlechas(EquipoItem FLECHAS){
        this.FLECHAS= FLECHAS;
    }
}

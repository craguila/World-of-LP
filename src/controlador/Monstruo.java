/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Graficos.Sprite;
import java.util.ArrayList;
import java.util.Random;
import vista.Juego;
import vista.Mapa;



public class Monstruo extends Personaje {
    int exp_entregada; // experiencia que entrega al usuario.
    
    public ArrayList<Habilidad> habilidades;

    public Monstruo(Mapa mapa,String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario, int[] posicion) {
        super(mapa, Nombre, Nivel, EXP, stats, Vida, Stamina, Mana, equipo, inventario, posicion);
        dinero += 10;
    }
    
    public boolean jugadorvisible(){
        int playerx = Juego.jugador.posicion[0];
        int playery = Juego.jugador.posicion[1];
        int monsterx = posicion[0];
        int monstery = posicion[1];
        int vision = stats.radio_vision*32;
        if (((monsterx - vision)<playerx) && ((monsterx + vision) > playerx)){
            if (((monstery -vision) < playery )&& ((monstery + vision) > playery) ){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean actualizar(int animacion, boolean enMovimiento, String tipo){
        Random  rnd = new Random();
        int playerx = Juego.jugador.posicion[0];
        int playery = Juego.jugador.posicion[1];
        int monsterx = posicion[0];
        int monstery = posicion[1];
        
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        if (animacion<32767){
            animacion++;
        }else{
            animacion =0;
        }
            if (jugadorvisible()){
                int distx = playerx - monsterx;
                int disty = playery - monstery;
                if (distx > disty && distx!=0){
                    desplazamientoX += (distx/Math.abs(distx))*stats.rapidez;
                } else if(distx <= disty && disty!=0){
                    desplazamientoY += (disty/Math.abs(disty))*stats.rapidez;
                }
                
                if (Juego.jugador.sienteelchoque(-desplazamientoX, -desplazamientoY)){
                    Random  rand = new Random();
                    int i = rand.nextInt(4);
                    if (i==1){
                        if(!usarHabilidad()){
                            Juego.jugador.danar(stats.fuerza);
                        }
                    }else{
                        Juego.setConsole((Nombre+" te atacó."));
                        Juego.jugador.danar(stats.fuerza);
                    }
                }
            } else {
                int x=rnd.nextInt(2);
                int y=rnd.nextInt(2);;
                if (x==1){
                        desplazamientoX-= stats.rapidez;
                } else if(x==2){
                        desplazamientoX+= stats.rapidez;
                }
                if (y==1){
                        desplazamientoY-= stats.rapidez;
                } else if(y==2){
                        desplazamientoY+= stats.rapidez;
                }
            }

            
            
        //animacion y sprites
        Sprite sn0;
        Sprite sn1;
        Sprite sn2;
        Sprite ss0;
        Sprite ss1;
        Sprite ss2;
        Sprite se0;
        Sprite se1;
        Sprite se2;
        Sprite so0;
        Sprite so1;
        Sprite so2;
        switch (tipo){
            case "Lobo":
                sn0 = Sprite.LARRIBA0;
                sn1 = Sprite.LARRIBA1;
                sn2 = Sprite.LARRIBA2;
                ss0 = Sprite.LABAJO0;
                ss1 = Sprite.LABAJO1;
                ss2 = Sprite.LABAJO2;
                se0 = Sprite.LDERECHA0;
                se1 = Sprite.LDERECHA1;
                se2 = Sprite.LDERECHA2;
                so0 = Sprite.LIZQUIERDA0;
                so1 = Sprite.LIZQUIERDA1;
                so2 = Sprite.LIZQUIERDA2;
                break;
            case "Esqueleto":
                sn0 = Sprite.EARRIBA0;
                sn1 = Sprite.EARRIBA1;
                sn2 = Sprite.EARRIBA2;
                ss0 = Sprite.EABAJO0;
                ss1 = Sprite.EABAJO1;
                ss2 = Sprite.EABAJO2;
                se0 = Sprite.EDERECHA0;
                se1 = Sprite.EDERECHA1;
                se2 = Sprite.EDERECHA2;
                so0 = Sprite.EIZQUIERDA0;
                so1 = Sprite.EIZQUIERDA1;
                so2 = Sprite.EIZQUIERDA2;
                break;
            case "Gato":
                sn0 = Sprite.GARRIBA0;
                sn1 = Sprite.GARRIBA1;
                sn2 = Sprite.GARRIBA2;
                ss0 = Sprite.GABAJO0;
                ss1 = Sprite.GABAJO1;
                ss2 = Sprite.GABAJO2;
                se0 = Sprite.GDERECHA0;
                se1 = Sprite.GDERECHA1;
                se2 = Sprite.GDERECHA2;
                so0 = Sprite.GIZQUIERDA0;
                so1 = Sprite.GIZQUIERDA1;
                so2 = Sprite.GIZQUIERDA2;
                break;
            case "Murcielago":
                sn0 = Sprite.MUARRIBA0;
                sn1 = Sprite.MUARRIBA1;
                sn2 = Sprite.MUARRIBA2;
                ss0 = Sprite.MUABAJO0;
                ss1 = Sprite.MUABAJO1;
                ss2 = Sprite.MUABAJO2;
                se0 = Sprite.MUDERECHA0;
                se1 = Sprite.MUDERECHA1;
                se2 = Sprite.MUDERECHA2;
                so0 = Sprite.MUIZQUIERDA0;
                so1 = Sprite.MUIZQUIERDA1;
                so2 = Sprite.MUIZQUIERDA2;
                break;
            default: //guerrero
                sn0 = Sprite.TARRIBA0;
                sn1 = Sprite.TARRIBA1;
                sn2 = Sprite.TARRIBA2;
                ss0 = Sprite.TABAJO0;
                ss1 = Sprite.TABAJO1;
                ss2 = Sprite.TABAJO2;
                se0 = Sprite.TDERECHA0;
                se1 = Sprite.TDERECHA1;
                se2 = Sprite.TDERECHA2;
                so0 = Sprite.TIZQUIERDA0;
                so1 = Sprite.TIZQUIERDA1;
                so2 = Sprite.TIZQUIERDA2;
                break;
                
        }
        int resto = animacion%40;
        if (direccion == 'n'){
            sprite = sn0;
            if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = sn1;
                } else if (resto>20 && resto<=30){
                    sprite= sn0;
                } else if (resto>30 && resto<=40){
                    sprite= sn2;
                } else{
                    sprite= sn0;
                }
            }
        }
        if (direccion == 's'){
            sprite = ss0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = ss1;
                } else if (resto>20 && resto<=30){
                    sprite= ss0;
                } else if (resto>30 && resto<=40){
                    sprite= ss2;
                } else{
                    sprite= ss0;
                }
            }
        } 
        if (direccion == 'o'){
            sprite = so0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = so1;
                } else if (resto>20 && resto<=30){
                    sprite= so0;
                } else if (resto>30 && resto<=40){
                    sprite= so2;
                } else{
                    sprite= so0;
                }
            }
            
        }
        if (direccion == 'e'){
            sprite = se0;
             if (enMovimiento){
                if (resto>10 && resto <= 20){
                    sprite = se1;
                } else if (resto>20 && resto<=30){
                    sprite= se0;
                } else if (resto>30 && resto<=40){
                    sprite= se2;
                } else{
                    sprite= se0;
                }
            }
            
        }
        if (!vivo()){
            Juego.jugador.aumentarExp(exp_entregada);
            Juego.jugador.ganarDinero(dinero);
            this.mover(10000, 10000);
        }
        if (desplazamientoX != 0 || desplazamientoY != 0){
            try{
            mover(desplazamientoX*10, desplazamientoY*10);
            enMovimiento= true;
            return true;
            }
            catch(Exception e){
                    enMovimiento = false;
                    return false;
                    }
            
        } else{
            enMovimiento = false;
            return false;
        }

    }
    
    public boolean usarHabilidad(){
        Random  rnd = new Random();
        int habilidad_rnd = (int) rnd.nextDouble()*habilidades.size();
        Habilidad habilidad = habilidades.get(habilidad_rnd);
        if(Mana>habilidad.costo){
            Juego.setConsole((Nombre+" usó " + habilidad.nombre));
            for (Status s:Juego.jugador.getEquipo().getArmadura().status_list){
                if (s.getNombre().equals(habilidad.estado.getNombre())){
                    Juego.setConsole(("Fuiste protegido por " + Juego.jugador.getEquipo().getArmadura().getNombre()));
                    Mana -= habilidad.costo;
                    return true;
                } 
            }
            Juego.jugador.danar(habilidad.dano);
            Juego.jugador.addStatus(habilidad.estado);
            Mana -= habilidad.costo;
            return true;
            }
            
        return false;
                
    }
}

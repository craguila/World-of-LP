
package controlador;


public class Personaje {
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

    public Personaje(String Nombre, int Nivel, int EXP, Stats stats, int Vida, int Stamina, int Mana, Equipo equipo, Inventario inventario) {
        this.Nombre = Nombre;
        this.Nivel = Nivel;
        this.EXP = EXP;
        this.stats = stats;
        this.Vida = Vida;
        this.Stamina = Stamina;
        this.Mana = Mana;
        this.equipo = equipo;
        this.inventario = inventario;
    }   
    
}

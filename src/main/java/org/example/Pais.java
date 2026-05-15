package org.example;

import java.util.ArrayList;
import java.util.List;

//Definición clase jugador -> atributos: nombre (String), bandera (String)
public class Pais {
    private String nombre;
    private String bandera;
    private List<Sede> sedes;
    private List<Arbitro> arbitros;


    //Constructor con parámetros
    public Pais (String nombre, String bandera, List<Sede> sedes, List<Arbitro> arbitros){
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = sedes;
        this.arbitros = arbitros;
    }

    //Constructor por defecto
    public Pais (){
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
    }
    //Get
    public String getNombre() {return nombre;}
    public List<Sede> getSedes (){return sedes;}
    public String getBandera() {
        return bandera;
    }
    public List<Arbitro> getArbitros() {return arbitros;}
    //Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    //Métodos
    public void agregarArbitro (Arbitro a){this.arbitros.add (a);}
    public void agregarSede (Sede s){this.sedes.add (s);}

    @Override
    public String toString() {
        return "------Pais------- " + 
                "\nNombre: " + this.nombre + 
                "\nBandera: " + this.bandera;
    }
    
}

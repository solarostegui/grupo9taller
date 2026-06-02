package org.example;

import java.util.ArrayList;
import java.util.List;

//Definición clase jugador -> atributos: nombre (String), bandera (String)
public class Pais {
    private String nombre;
    private String bandera;
    //bidireccional con sede
    private List<Sede> sedes;
    //bidireccional con arbitro
    private List<Arbitro> arbitros;
    private Seleccion seleccion;


    //Constructor con parámetros
    public Pais (String nombre, String bandera){ //Sin seleccion para poder inicializar desde país, dos clases no pueden depender entre sí
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
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
    public Seleccion getSeleccion() {
        return seleccion;
    }
    public List<Arbitro> getArbitros() {return arbitros;}

    //Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    } 
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }
    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
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

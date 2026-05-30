
package org.example;
import java.util.List;
import java.util.ArrayList;

public class Estadio {
    private String nombre;
    private int capacidad;
    //Bidireccional con sede
    private Sede sede;
    //bidireccional con partido
    private List<Partido> partidos;
    
    public Estadio(){
        this.partidos=new ArrayList<Partido>();
    }
    
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos=new ArrayList<Partido>();
    }
    
    //Get
    public String getNombre() {
        return nombre;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public Sede getSede() {
        return sede;
    }
    public List<Partido> getPartidos() {
        return partidos;
    }
    
    //Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
    public void agregarPartido(Partido p){
        this.partidos.add(p);
    }
    
    //Método
    @Override
    public String toString() {
        return "----Estadio------ "+
                "Nombre: " + this.nombre + 
                "\nCapacidad: " + this.capacidad;

    }
    
}

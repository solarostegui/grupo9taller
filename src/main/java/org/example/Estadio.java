
package org.example;
import java.util.List;
import java.util.ArrayList;

public class Estadio {
    private String nombre;
    private Integer capacidad;
    private Sede sede;
    //bidireccional con partido
    private List<Partido> partidos;
    
    public Estadio(){
        this.partidos=new ArrayList<Partido>();
    }
    
    public Estadio(String nombre, Integer capacidad, Sede sede,List<Partido> partidos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos=partidos;
    }
    
    //Get
    public String getNombre() {
        return nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Sede getSede() {return sede;}
    //Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
    
    //Método
    @Override
    public String toString() {
        return "----Estadio------ "+
                "Nombre: " + this.nombre + 
                "\nCapacidad: " + this.capacidad;

    }
    
    
    
}


package org.example;

public class Estadio {
    private String nombre;
    private Integer capacidad;
    private Sede sede;

    public Estadio(String nombre, Integer capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
    }
    
    public Estadio(){
        this.nombre = "";
        this.capacidad = 0;
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
    //Método
    @Override
    public String toString() {
        return "----Estadio------ "+
                "Nombre: " + this.nombre + 
                "\nCapacidad: " + this.capacidad;

    }
    
    
    
}

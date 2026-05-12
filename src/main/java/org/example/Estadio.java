
package org.example;

public class Estadio {
    private String nombre;
    private Integer capacidad;

    public Estadio(String nombre, Integer capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    
    public Estadio(){
        this.nombre = "";
        this.capacidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "----Estadio------ "+
                "Nombre: " + this.nombre + 
                "\nCapacidad: " + this.capacidad;
    }
    
    
    
}

package org.example;
//Definición clase jugador -> atributos: nombre (String), bandera (String)
public class Pais {
    private String nombre;
    private String bandera;

    //Constructor con parámetros
    public Pais (String nombre, String bandera){
        this.nombre = nombre;
        this.bandera = bandera;
    }

    //Constructor por defecto
    public Pais (){
    }
    //Get y setter
    public String getNombre() {
        return nombre;
    }

    public String getBandera() {
        return bandera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    @Override
    public String toString() {
        return "------Pais------- " + 
                "\nNombre: " + this.nombre + 
                "\nBandera: " + this.bandera;
    }
    
}

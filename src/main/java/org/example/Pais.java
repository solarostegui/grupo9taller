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
    //Get
    public String getNombre() {
        return nombre;
    }

    public String getBandera() {
        return bandera;
    }
}

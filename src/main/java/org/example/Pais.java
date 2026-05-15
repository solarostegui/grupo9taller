package org.example;
//Definición clase jugador -> atributos: nombre (String), bandera (String)
public class Pais {
    private String nombre;
    private String bandera;
    private Pais pais;

    //Constructor con parámetros
    public Pais (String nombre, String bandera, Pais pais){
        this.nombre = nombre;
        this.bandera = bandera;
        this.pais = pais;
    }

    //Constructor por defecto
    public Pais (){}
    //Get
    public String getNombre() {return nombre;}
    public Pais getPais (){return pais;}
    public String getBandera() {
        return bandera;
    }
}

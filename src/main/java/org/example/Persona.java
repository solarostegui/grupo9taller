package org.example;

//Definición clase persona -> atributos: nombre(str), fecnacimiento (int)
public class Persona {
    private String nombre;
    private int fecNacimiento;

    //Constructor con parámetros
    public Persona (String nombre, int fecNacimiento){
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    //Constructor por defecto
    public Persona(){
    }

    //Get

    public String getNombre() {
        return nombre;
    }

    public int getFecNacimiento() {
        return fecNacimiento;
    }
}

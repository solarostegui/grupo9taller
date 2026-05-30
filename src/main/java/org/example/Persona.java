package org.example;

//Definición clase persona -> atributos: nombre(str), fecnacimiento (int)
public abstract class Persona {
    protected String nombre;
    protected int fecNacimiento;

    //Constructor con parámetros
    public Persona (String nombre, int fecNacimiento){
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    //Constructor por defecto
    public Persona(){
    }
    //Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }


    //Get
    public String getNombre() {
        return nombre;
    }
    public int getFecNacimiento() {
        return fecNacimiento;
    }

    @Override
    public String toString() {
        return "\nNombre: " + this.nombre +
                "fecha de nacimiento: " + this.fecNacimiento;
    }
    
}

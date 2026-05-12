package org.example;

public class Arbitro extends Persona {
    private int aniosExperiencia;

    //Constructor con parámetros
    public Arbitro (String nombre, int fecNacimiento, int aniosExperiencia){
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
    }

    //Constructor por defecto
    public Arbitro (){}

    // getter y setter
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
}

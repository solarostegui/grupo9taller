package org.example;

public class Arbitro extends Persona {
    private int aniosExperiencia;
    private Pais pais;

    //Constructor con parámetros
    public Arbitro (String nombre, int fecNacimiento, int aniosExperiencia, Pais pais){
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
    }

    //Constructor por defecto
    public Arbitro (){}

    // getter y setter
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    public Pais getPais(){return pais;}

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    public void setPais(Pais pais){this.pais = pais;}
}

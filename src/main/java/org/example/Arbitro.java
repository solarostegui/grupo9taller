package org.example;

import java.util.ArrayList;
import java.util.List;

public class Arbitro extends Persona {
    private int aniosExperiencia;
    //Bidireccional con pais
    private Pais pais;
    //Clase asociacion arbitraje
    private List<Arbitraje> arbitrajes;

    //Constructor con parámetros
    public Arbitro (String nombre, int fecNacimiento, int aniosExperiencia, Pais pais){
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitrajes=new ArrayList<Arbitraje>();
    }
    //agregar lista
    public void agregarArbitraje(Arbitraje a){
        this.arbitrajes.add(a);
    }
    
    //Constructor por defecto
    public Arbitro (){
      this.arbitrajes=new ArrayList<Arbitraje>();
    }

    // getter y setter
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    public Pais getPais(){return pais;}

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    public void setPais(Pais pais){this.pais = pais;}

    public List<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    public void setArbitrajes(List<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @Override
    public String toString() {
        return "-----Arbitro----" +"\nNombre: "+super.nombre+
                "\n Fecha de naciemiento: "+super.fecNacimiento+
                "\nAños de experiencia: "+this.aniosExperiencia+
                "\nPais: "+(this.pais!=null ? this.pais.getNombre(): "Sin pais");
    }
    
}

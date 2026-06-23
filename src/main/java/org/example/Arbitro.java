package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa a un árbitro que participa en el torneo.
 * Esta clase hereda de Persona y tiene una relacion bidireccional con la clase País y con la clase Partido.
 * @author Antonella Monti, María del Mar Dalorso, María Sol Arostegui
 * @version 1.0
 */
public class Arbitro extends Persona {
    /**Años de experiencia del árbitro. */
    private int aniosExperiencia;
    /**Relación bidireccional que establece de que País es el árbitro. */
    private Pais pais;
    /** Colección de las asignaciones arbitrales vinculadas a la persona. */
    private List<Arbitraje> arbitrajes;
    /**
     * Constructor con parametros para crear un arbitro.
     * @param nombre Nombre del árbitro.
     * @param fecNacimiento Fecha de nacimiento.
     * @param aniosExperiencia Años de experiencia profesional del arbitro.
     * @param pais país al que pertenece.
     */
    
    public Arbitro (String nombre, int fecNacimiento, int aniosExperiencia, Pais pais){
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitrajes=new ArrayList<Arbitraje>();
    }
    /** Constructor por defecto que inicializa  la estructura de datos para la coleccion de asignaciones.
    */
    public Arbitro (){
      this.arbitrajes=new ArrayList<Arbitraje>();
    }

    // getter y setter
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    
    public Pais getPais(){
        return pais;
    }

    public void setAniosExperiencia(int aniosExperiencia){
        this.aniosExperiencia = aniosExperiencia;
    }
    public void setPais(Pais pais){this.pais = pais;}

    public List<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    public void setArbitrajes(List<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }
    /** 
     * Agrega un nuevo arbitraje a la lista de arbitrajes del arbitro.
     * @param a agrega el arbitraje.
     */
    public void agregarArbitraje(Arbitraje a){
        this.arbitrajes.add(a);
    }
    /**
     * Imprime los datos del árbitro.
     * @return String presenta los datos con la información personal y profesional del árbitro.
     */

    @Override
    public String toString() {
        return "-----Arbitro----" +
                "\nNombre: "+super.nombre+
                "\n Fecha de naciemiento: "+super.fecNacimiento+
                "\nAños de experiencia: "+this.aniosExperiencia+
                "\nPais: "+(this.pais!=null ? this.pais.getNombre(): "Sin pais");
    }
    
}

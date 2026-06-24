package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Representa a un árbitro que participa en el torneo.
 * Esta clase hereda de Persona y tiene una relacion bidireccional con la clase País y con la clase Partido.
 * @author Antonella Monti, María del Mar Dalorso.
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
        this.arbitrajes=new ArrayList<>();
    }
    /** Constructor por defecto que inicializa  la estructura de datos para la coleccion de asignaciones.
    */
    public Arbitro (){
      this.arbitrajes=new ArrayList<>();
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
     * Compara este árbitro con otro objeto para determinar su igualdad.
     * Dos árbitros se consideran idénticos si poseen el mismo nombre, 
     * sin hacer distinción entre mayúsculas y minúsculas (Case-Insensitive).
     * @param o Objeto de referencia con el cual se va a comparar.
     * @return true si el objeto es un Árbitro y tiene el mismo nombre; false en caso contrario.
     */
    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Arbitro otro=(Arbitro) o;
        
        boolean nombresIguales = this.getNombre().equalsIgnoreCase(otro.getNombre());
        
        return nombresIguales;
    }
    /**
     * Genera el código hash numérico (ID de dispersión) para el objeto Árbitro.
     * Se sincroniza con el método equals convirtiendo el nombre a minúsculas,
     * garantizando que dos objetos con el mismo nombre compartan idéntico hash.
     * @return Un entero que representa el valor hash calculado para este árbitro.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getNombre() != null ? this.getNombre().toLowerCase() : 0);
    }
    /**
     * Imprime los datos del árbitro.
     * @return String presenta los datos con la información personal y profesional del árbitro.
     */
    @Override
    public String toString() {
        return """
               -----Arbitro----
               Nombre: """+super.nombre+
                "\n Fecha de naciemiento: "+super.fecNacimiento+
                "\nAños de experiencia: "+this.aniosExperiencia+
                "\nPais: "+(this.pais!=null ? this.pais.getNombre(): "Sin pais");
    }
    
}

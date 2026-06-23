package org.example;

import java.util.Objects;

/**
 * Representa el director técnico de una selección. Esta clase hereda de persona. Incluye un atributo sobre la fecha de nombramiento del director técnico. 
 * @author María del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */

public class DirectorTecnico extends Persona{
    /**fecha de nombramiento del director tecnico. */
    private int fechaNombramiento;

    /** 
     * Constructor con parametros para crear un director técnico.
     * @param nombre nombre del director técnico.
     * @param fecNacimiento fecha de nacimiento del director técnico.
     * @param fechaNombramiento fecha de nombramiento del director técnico.
     */
    public DirectorTecnico (String nombre, int fecNacimiento, int fechaNombramiento){
        super (nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    /**
     * Constructor sin parametros que crear un director tecnico sin inicializar los atributos. 
     */
    public DirectorTecnico (){
    }
    
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }
    
    /**
     * Compara un director técnico con otro objeto para determinar si son iguales. 
     * Se concideran iguales si sus nombres son iguales.
     * @param o objeto a comparar.
     * @return true si los nombres son iguales; false en caso contrario.
     */
    
    @Override
    public boolean equals(Object o) {
       if (o == null) {
          return false;
        }
        if (this.getClass() != o.getClass()) {
           return false;
        }
        DirectorTecnico otroDT = (DirectorTecnico) o;
        boolean nombresIguales = this.getNombre().equalsIgnoreCase(otroDT.getNombre());
        return nombresIguales;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getNombre() != null ? this.getNombre().toLowerCase() : 0);
    }
    
    /**
     * Imprime los datos del Director Técnico.
     * @return String presenta los datos personales del Director Técnico.
     */

    @Override
    public String toString() {
        return "-----DirectorTecnico-----" +
                "\nNombre: "+ super.nombre +
                "\nFecha de nacimiento: "+ super.fecNacimiento+
                "\nFecha de nombramiento: " + this.fechaNombramiento;
    }
}

package org.example;
/**
 * Clase que representa a una persona.
 * @author Antonella Monti, María del Mar Dalorso
 * @version 1.0
 */

public abstract class Persona {
    /**
     * Nombre de la persona.
     */
    protected String nombre;
    /**
     * Fecha de nacimiento de la persona.
     */
    protected int fecNacimiento;
     /**
      * Constructor con parametros para crear una persona.
      * @param nombre nombre de la persona
      * @param fecNacimiento  fecha de nacimiento de la persona
      */
    
    public Persona (String nombre, int fecNacimiento){
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }
    /**
     * Contructor por defecto, se crea una persona sin asignar valores todavía.
     */
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
    /**
     * Junta los datos de la persona en un texto ordenado para poder mostrarlo fácilmente.
     * @return Un texto con el nombre y la fecha de nacimiento.
     */
    @Override
    public String toString() {
        return "\n Nombre: " + this.nombre +
               "\n Fecha de nacimiento: " + this.fecNacimiento;
    }
    
}

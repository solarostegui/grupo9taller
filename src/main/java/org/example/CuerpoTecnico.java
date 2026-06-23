/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.Objects;

/**
 * Representa el cuerpo técnico de una selección. Esta clase hereda de persona. Incluye un atributo sobre el rol dentro de la selección.    
 * @author Maria del Mar Dalorso, Antonella Monti, Maria Sol Arostegui
 * @version 1.0
 */
public class CuerpoTecnico extends Persona{
    /**
     * Rol específico que cumple una persona del cuerpo técnico.
     */
    private TipoRol rol;
    /** 
     * Constructor por defecto que crea una instancia de cuerpo técnico sin inicializar sus atributos.
     */
    public CuerpoTecnico(){
    }
    
    /**
     * Constructor con parámetros que crea un cuerpo técnico.
     * @param nombre nombre de la persona que forma parte del cuerpo técnico.
     * @param fecNacimiento fecha de nacimiento de la persona.
     * @param rol rol que cumple la persona dentro del cuerpo técnico.
     */
      
    public CuerpoTecnico(String nombre,int fecNacimiento,TipoRol rol) {
        super(nombre,fecNacimiento);
        this.rol = rol;
    }
    /**
    * Obtiene el rol del integrante del cuerpo técnico.
    * @return rol del integrante
    */
    public TipoRol getRol() {
        return rol;
    }
    
    /**
    * Establece el rol del integrante del cuerpo técnico.
    * @param rol nuevo rol a asignar
    */
    public void setRol(TipoRol rol) {
        this.rol = rol;
    }
    
    /**
     * Compara una persona del cuerpo técnico con otro objeto para determinar si son iguales.
     * Se consideran iguales si sus nombres coinciden.
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
        CuerpoTecnico otroCT = (CuerpoTecnico) o;
        
        boolean nombresIguales = this.getNombre().equalsIgnoreCase(otroCT.getNombre());
        
        return nombresIguales;
}
    @Override
    public int hashCode() {
        return Objects.hash(this.getNombre() != null ? this.getNombre().toLowerCase() : 0);
    }

    /**
     * Imprime los datos de la persona que forma parte del Cuerpo Técnico.
     * @return String presenta los datos personales de la persona y el rol que cumple dentro del cuerpo técnico.
     */
    @Override
    public String toString() {
        return "------CuerpoTecnico----" + 
                "\nNombre: "+super.nombre+
                "\nFecha de nacimiento: "+super.fecNacimiento+
                "\nRol: " + this.rol;
    }
}

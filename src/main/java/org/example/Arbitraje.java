package org.example;
/**
 * Representa la clase de asociacion encargada de vincular a un Árbitro específico
 * con un Partido determinado, asignandole un rol particular.
 * @author Antonella Monti, María del Mar Dalorso, María Sol Arostegui
 * @version 1.0
 */
public class Arbitraje {
    
    /** El rol asignado al árbitro para el encuentro. */
    private TipoCategoriaArbitro rol;
    
    /** Relación de asociación con árbitro. */
    private Arbitro arbitro;
    
    /** Relación de asociación donde a un Partido se le asocia un equipo Arbitral. */
    private Partido partido;

   /** Constructor para inicializar la calse de asociación con todos sus componentes. 
    * @param rol Funcion que cumplirá el juez en el partido.
    * @param arbitro El objeto Arbitro que tendrá un rol específico.
    * @param partido El objeto Partido al que se le asigna el equipo arbitral.
    */
    public Arbitraje(TipoCategoriaArbitro rol, Arbitro arbitro, Partido partido){
        this.rol = rol;
        this.arbitro = arbitro;
        this.partido = partido;
    }

    public TipoCategoriaArbitro getRol() {
        return rol;
    }

    public void setRol(TipoCategoriaArbitro rol) {
        this.rol = rol;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    /**
     * Genera una cadena de texto con los detalles de la asignación arbitral.
     * @return String compuesto con el rol del arbitraje y el nombre del árbitro asociado.
     */
    @Override
    public String toString() {
       return "----Arbitraje------" +
              "\nRol: " + this.rol + 
              "\nÁrbitro: " + (this.arbitro != null ? this.arbitro.getNombre() : "sin asignar");
    }
    

}


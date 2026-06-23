
package org.example;
import java.util.List;
import java.util.ArrayList;
/**
 * Representa las fases del mundial. Esta clase posee un atributo con el nombre de la fase,una relación bidireccional con la clase partido y con la clase grupo.
 * @author Maria del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public class Fase {
    /** El tipo de fase del mundial. */
    private TipoNombreFase nombreFase;
    /** Colección de los partidos de la fase. */
    private List<Partido> partidos;
    /** Colección de los grupos de la fase. */
    private List<Grupo> grupos;
    
    /** 
     * Constructor con parametros para crear una fase.
     * @param nombreFase tipo de la fase.
     */
    public Fase(TipoNombreFase nombreFase) {
        this.nombreFase = nombreFase;
        this.partidos=new ArrayList<Partido>();
        this.grupos=new ArrayList<Grupo>();
    }
    /** Constructor por defecto que inicializa  las estructuras de datos para la colección de partidos y de grupos.
    */
    public Fase(){
        this.partidos=new ArrayList<Partido>();
        this.grupos=new ArrayList<Grupo>();
    }

    
    public TipoNombreFase getNombreFase() {
        return nombreFase;
    }
    public void setNombreFase(TipoNombreFase nombreFase) {
        this.nombreFase = nombreFase;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public List<Grupo> getGrupos() {return grupos;}
    public void setGrupos(List<Grupo> grupos) {this.grupos = grupos;}
    /** 
     * Agrega un nuevo partido a la lista de partidos de la fase.
     * @param p objeto que se agrega a la lista.
     * @return true si se agrega correctamente a la lista, false si ya fue agregado o es null.
     */
    public boolean agregarPartido(Partido p){
        if(p == null){
            return false;
        }
        // Validamos si el partido ya fue agregado a esta fase
        if(!this.partidos.contains(p)){
            this.partidos.add(p);
            return true;
        }
        return false; //no se agrega porque ya existe
    }
    /** 
     * Agrega un nuevo grupo a la lista de grupos de la fase.
     * @param g objeto que se agrega a la lista.
     * @return true si se agrega correctamente a la lista, false si ya existe o es null.
     */
    public boolean agregarGrupos(Grupo g){
        if(g == null){
            return false;
        }
        if(!this.grupos.contains(g)){
            this.grupos.add(g);
            return true;
        }
        return false;
    }
    
    /**
     * Imprime los datos de la fase.
     * @return String presenta los datos de la fase.
     */
    @Override
    public String toString() {
        return "\nFase: "  + this.nombreFase;
    }
    
    
    
}


package org.example;
import java.util.List;
import java.util.ArrayList;
/**
 * Representa el estadio de una sede. Esta clase posee un atributo nombre y capacidad, una relacion didireccional con sede y con partido
 * @author Maria del Mar Dalorso, Antonella Monti, Maria Sol Arostegui
 * @version 1.0
 */
public class Estadio {
    /**Nombre del estadio. */
    private String nombre;
    /**Capacidad del estadio. */
    private int capacidad;
    /**Relación bidireccional que establece de que sede, es el estadio. */
    private Sede sede;
    /** Colección de los partidos vinculados al estadio. */
    private List<Partido> partidos;
    
    /** Constructor por defecto que inicializa  la estructura de datos para la coleccion de partidos.
    */
    public Estadio(){
        this.partidos=new ArrayList<Partido>();
    }
    /** 
     * Constructor con parametros para crear un estadio.
     * @param nombre nombre del estadio.
     * @param capacidad capacidad maxima del estadio.
     * @param sede sede a la que pertenece el estadio.
     */
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos=new ArrayList<Partido>();
    }
    
    
    public String getNombre() {
        return nombre;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public Sede getSede() {
        return sede;
    }
    public List<Partido> getPartidos() {
        return partidos;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    /** 
     * Agrega un nuevo partido a la lista de partidos del estadio.
     * @param p agrega a los partidos.
     */
    public boolean agregarPartido(Partido p){
        if(p == null){
            return false;
        }
        if(!this.partidos.contains(p)){
            this.partidos.add(p);
            return true;
        }
        return false;
    }
    
    /**
     * Imprime los datos del estadio.
     * @return String presenta los datos del estadio.
     */
    @Override
    public String toString() {
        return "----Estadio------ "+
                "Nombre: " + this.nombre + 
                "\nCapacidad: " + this.capacidad;

    }
    
}

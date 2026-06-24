package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa cada país que participa en el torneo. Hay tres relaciones bidireccionales
 * un país cuenta con más de un árbitro, un país representa a una selección y un país pertenece a 
 * a más de una sede. Tiene atributos de su nombre y su bandera.
 * @author Antonella Monti, María del Mar Dalorso.
 * @version 1.0
 */

public class Pais {
    /**
     * Nombre del país.
     */
    private String nombre;
    /**
     * Bandera del país.
     */
    private String bandera;
    /**
     * Colección de sedes asignadas a este país.
     */
    private List<Sede> sedes;
    /**
     * Colección de arbitros que provienen de este pais .
     */
    private List<Arbitro> arbitros;
    /**
     * Relación bidiraccional de la selección que representa a este país.  
     */
    private Seleccion seleccion;

    /**
     * Constructos parametrizado que crea un país. Inicializa la estructura de datos
     * para la lista de Sedes y Arbitros.
     * El constructor omite intencionalmente el objeto {@link Seleccion}. 
     * El constructor omite intencionalmente el objeto {@link Seleccion}. Esto resuelve el conflicto de acoplamiento bidireccional fuerte, permitiendo instanciar el país 
     * en primer término sin que ambas clases queden bloqueadas por depender mutuamente en simultáneo.
     * @param nombre nombre del pais.
     * @param bandera  bandera que representa al pais
     */
    
    public Pais (String nombre, String bandera){ //Sin seleccion para poder inicializar desde país, dos clases no pueden depender entre sí
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
    }
    /**
     * Constructor por defecto que inicializa las colecciones de sedes y arbitros 
     * como listas vacias.
     */
    
    public Pais (){
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
    }
    
    public String getNombre() {
        return nombre;
    }
    public List<Sede> getSedes (){
        return sedes;
    }
    public String getBandera() {
        return bandera;
    }
    public Seleccion getSeleccion() {
        return seleccion;
    }
    public List<Arbitro> getArbitros() {
        return arbitros;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Vincula la seleccion que representará a este pais durante el torneo. 
     * Valida que un jugador solo pueda estar vinculado a una selección nacional. 
     * @param s El objeto {@link Seleccion} a vincular.
     * @return false si el objeto es nulo o la seleccion ya esta vinculada a otra seleeción,
     * true si se vinculó correctamente.
     */
    public boolean setSeleccion(Seleccion s) {
        if (s == null) {
        return false;
        }
        // Si el país ya tiene una selección asignada, no permitimos pisarla
        if(this.seleccion != null){
            return false;
        }
        this.seleccion = s;
        return true;
    } 
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }
    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }
    
    /**
     * Agrega un árbitro a la lista de arbitros para este país.
     * Se comprueba mediante el {@code contains} que el árbitro no se haya agregado antes.
     * @param a El objeto {@link Arbitro} que se añade a la lista.
     * @return false si es nulo o ya esta agregado, true si se agrega correctamente.
     */
    public boolean agregarArbitro (Arbitro a){
        if (a == null) {
        return false;
    }
        if(!this.arbitros.contains(a)){
            this.arbitros.add (a);
            return true;
        }
        return false;
    }
    /**
     * Agrega la sede en la que jugará este país.
     * Verifica que la sede sea válida y que no exista previamente.
     * @param s El objeto {@link Sede} a asociar administrativamente.
     * @return true si se agrega correctamente, false si es nulo o si ya se encontraba registrada anteriormente.
     */
    public boolean agregarSede (Sede s){
        if(s==null){
            return false; 
        }
        if(!this.sedes.contains(s)){
            this.sedes.add (s);
            return true;
        }
        return false;
    }
        
    /**
     * Devuelve una representación en texto de la información general dela pais.
     * @return Una cadena de caracteres formateada con los datos del partido.
     */
    @Override
    public String toString() {
        return "------Pais------- " + 
                "\nNombre: " + this.nombre + 
                "\nBandera: " + this.bandera;
    }
    
}

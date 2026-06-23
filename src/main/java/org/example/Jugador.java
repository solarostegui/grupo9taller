package org.example;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Representa a cada jugador de una selección. Esta clase hereda de persona.
 * Incluye los atributos dorsal, posición, peso y altura.
 * @author Antonella Monti, María del Mar Dalorso.
 * @version 1.0
 */

public class Jugador extends Persona{
    /**
     * Numero de camiseta del jugador.
     */
    private int dorsal;
    /**
     * Posición en que juega el jugador.
     */
    private TipoPosicion posicion;
    /**
     * Peso del jugador.
     */
    private float peso;
    /**
     * Altura del jugador.
     */
    private float altura;
    /**
     * Colección de los eventos que haga el jugador.
     */
    private ArrayList<Evento> evento;
    
    /**
     * Constructor con parámetros para crear a un jugador.
     * @param nombre nombre del jugador.
     * @param fecNacimiento fecha de nacimiento de un jugador.
     * @param dorsal numero de camiseta del jugador.
     * @param posicion posicion que juega el jugador.
     * @param peso peso del jugador.
     * @param altura altura del jugador.
     */
    public Jugador (String nombre, int fecNacimiento, int dorsal, TipoPosicion posicion, float peso, float altura){
        super (nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.evento = new ArrayList<Evento>();
    }
    /** 
     * Cosntructor por defecto que inicializa  la estructura de datos para la coleccion de eventos.
     */
    public Jugador (){
        this.evento = new ArrayList<Evento>();
    }

    
    public int getDorsal() {
        return dorsal;
    }

    public TipoPosicion getPosicion() {
        return posicion;
    }
    public float getPeso() {
        return peso;
    }
    public float getAltura() {
        return altura;
    }
    public ArrayList<Evento> getEvento() {
        return evento;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public void setPosicion(TipoPosicion posicion) {
        this.posicion = posicion;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public void setEvento(ArrayList<Evento> evento) {
        this.evento = evento;
    }
    /**
     * Agrega un evento a la lista de eventos del jugador si el evento no es nulo y no está registrado previamente.
     * @param e evento a agregar.
     * @return true si se agrego correctamente, false si era nulo o ya existía.
     */
    
    public boolean agregarEvento(Evento e){
        if(e!=null && !this.evento.contains(e)){
            this.evento.add(e);
            return true;
        }
        return false;
    }
    /**
     * Imprime la información de un jugador.
     * @return presenta los datos de un jugador.
     */

    @Override
    public String toString() {
        return "-------Jugador-------"
                +"\nNombre: "+ super.nombre+
                "\nFecha nacimiento: "+super.fecNacimiento+
                "\nDorsal: "+this.dorsal+
                "\nPosicion: " + this.posicion + "\nPeso: " + this.peso + 
                "\nAltura: " + this.altura;
    }
    
    /**
     * Compara un jugador con otro objeto para determianar si son iguales. 
     * Se concideran iguales si tienen el mismo nombre, peso y altura.
     * @param o objeto a comparar.
     * @return true si el nombre, peso y altura es igual, false si es lo contrario.
     */
    
    @Override
    public boolean equals(Object o) {
       if(this==o) return true;
       
       if (o == null || this.getClass() != o.getClass()) {
           return false;
        }
  
       Jugador j = (Jugador) o;
       boolean nombresIgual = this.getNombre().equalsIgnoreCase(j.getNombre());
       boolean pesoIgual=this.getPeso()==j.getPeso();
       boolean alturaIgual=this.getAltura()==j.getAltura();
       
       return nombresIgual && pesoIgual && alturaIgual;
    }
    //para no tener problemas con contains ni hasmap
    @Override
    /*Objects.hash(...) es un método estático de la clase java.util.Objects que te genera 
    un hashCode combinando varios valores. Te ahorra hacerlo a mano.*/
    public int hashCode() {
        return Objects.hash(getNombre().toLowerCase(), getPeso(), getAltura());
    }
}

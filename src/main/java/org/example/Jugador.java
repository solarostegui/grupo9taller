package org.example;

import java.util.ArrayList;

//Definición clase jugador -> atributos: dorsal (int), posicion (de TipoPosicion -enum), peso (float), altura (float)
public class Jugador extends Persona{

    private int dorsal;
    private TipoPosicion posicion;
    private float peso;
    private float altura;
    //bidireccional con evento
    private ArrayList<Evento> evento;
   

    //Constructor con parámetros
    public Jugador (String nombre, int fecNacimiento, int dorsal, TipoPosicion posicion, float peso, float altura){
        super (nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.evento = new ArrayList<Evento>();
    }

    //Constructor por defecto
    public Jugador (){
    }

    //Get
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

    //Método para agregar eventos(solo administra la lista del jugador)
    public void agregarEvento(Evento e){
        if(e!=null && !this.evento.contains(e)){
            this.evento.add(e);
        }
    }

    @Override
    public String toString() {
        return "-------Jugador-------"
                +"\nNombre: "+ super.nombre+
                "\nFecha nacimiento: "+super.fecNacimiento+
                "\nDorsal: "+this.dorsal+
                "\nPosicion: " + this.posicion + "\nPeso: " + this.peso + 
                "\nAltura: " + this.altura;
    }
    
    @Override
    public boolean equals(Object o) {
    if (o == null) {
        return false;
    }
    if (this.getClass() != o.getClass()) {
        return false;
    }
    Jugador j = (Jugador) o;
    boolean nombresIguales = this.getNombre().equalsIgnoreCase(j.getNombre());
    return nombresIguales;
}
}

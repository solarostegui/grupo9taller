package org.example;
//Definición clase jugador -> atributos: dorsal (int), posicion (de TipoPosicion -enum), peso (float), altura (float)
public class Jugador extends Persona{

    private int dorsal;
    private TipoPosicion posicion;
    private float peso;
    private float altura;
    //bidireccional con evento
    private Evento evento;

    //Constructor con parámetros
    public Jugador (String nombre, int fecNacimiento, int dorsal, TipoPosicion posicion, float peso, float altura,Evento evento){
        super (nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.evento = evento;
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

    @Override
    public String toString() {
        return "-------Jugador-------"
                + "\nDorsal: " + this.dorsal +  
                "\nPosicion: " + this.posicion + "\nPeso: " + this.peso + 
                "\nAltura: " + this.altura;
    }
    
    
}

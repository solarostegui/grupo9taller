package org.example;
//Definición clase jugador -> atributos: dorsal (int), posicion (de TipoPosicion -enum), peso (float), altura (float)
public class Jugador extends Persona{

    private int dorsal;
    private TipoPosicion posicion;
    private float peso;
    private float altura;

    //Constructor con parámetros
    public Jugador (String nombre, int fecNacimiento, int dorsal, TipoPosicion posicion, float peso, float altura){
        super (nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author mardalorso
 */
public class Evento {
    //variables miembro de objeto
    private TipoEvento evento;
    private int minuto;
    //bidireccional con jugador
    private Jugador jugador;


    
    //constructor por defecto
    public Evento(){}
    //constructor parametrizado
    public Evento(TipoEvento evento, int minuto, Jugador jugador) {            //ARREGLAR
        this.evento = evento;
        this.minuto = minuto;
        this.jugador = jugador;
    }
    //getter y setter
    public TipoEvento getEvento() {
        return evento;
    }
    public void setEvento(TipoEvento evento) {
        this.evento = evento;
    }

    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }


    @Override
    public String toString() {
        return "------Evento-----" + ""
                + "\nEvento: " + this.evento
                + "\nMinuto: " + this.minuto ;
    }
    
}

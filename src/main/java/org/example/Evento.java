/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 * Representa el evento de un jugador. Esta clase posee un atributo evento,minuto y una relacion bidireccional con jugador
 * @author Maria del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public class Evento {
    /** El tipo de evento asignado al jugador. */
    private TipoEvento evento;
    /**Minuto del evento. */
    private int minuto;
    /**Relación bidireccional que establece a que jugador le corresponde el evento. */
    private Jugador jugador;

    /** 
     * Constructor por defecto que crea una instancia de evento sin inicializar sus atributos.
     */
    public Evento(){
    }
    /** 
     * Constructor con parametros para crear un evento.
     * @param evento tipo del evento.
     * @param minuto minuto del evento.
     * @param jugador jugador involucrado en el evento.
     */
    public Evento(TipoEvento evento, int minuto, Jugador jugador) {
        this.evento = evento;
        this.minuto = minuto;
        this.jugador = jugador;
    }
    
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

    /**
     * Imprime los datos del evento.
     * @return String presenta los datos del evento.
     */
    @Override
    public String toString() {
        return "------Evento-----" + ""
                + "\nEvento: " + this.evento
                + "\nMinuto: " + this.minuto ;
    }
    
}

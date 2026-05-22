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
    //variables miembro de onjeto
    private TipoEvento evento;
    private int minuto;
    
    //constructor por defecto
    public Evento(){}
    //constructor parametrizado
    public Evento(TipoEvento evento, int minuto) {
        this.evento = evento;
        this.minuto = minuto;
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

    @Override
    public String toString() {
        return "------Evento-----" + ""
                + "\nEvento: " + this.evento
                + "\nMinuto: " + this.minuto ;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
/**
 * Clase que representa un partido dentro del mundial. 
 * Coordina la fecha, el horario, el estadio donde se juega,
 * las selecciones que participan y todos los eventos que ocurren en el partido.
 * @author María del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public class Partido {
    /**
     * Fecha en que realiza el partido.
     */
    private LocalDate fecha;
    /**
     * Horario en que se realiza el partido.
     */
    private LocalTime horario;
    /**
     * Duracion del partido en minutos.
     */
    private int duracion;
    /**
     * Tiempo adicional agregado al partido.
     */
    private int tiempoadicional;
    /**
     * Relacion bidireccional, estadio donde se juega el partido
     */
    private Estadio estadio;
    /**
     * Relacion dibireccional, fase del torneo en la que esta jugando el partido
     */
    private Fase fase;
    /**
     * Información de la primera selección que participa.
     */
    private Participacion seleccion1;
    /**
     * Información de la segunda selección que participa.
     */
    private Participacion seleccion2;
    /**
     * Lista de los eventos ocurridos en el partido.
     */
    private List<Evento> eventos;
    /**
     * Lista del equipo arbitral asignado para dirigir el partido.
     */
    private List<Arbitraje> Arbitrajes;
    
    /**
     * Constructor por defecto que inicializa las listas de evento y arbitraje vacías. 
     */
    public Partido(){
    this.eventos=new ArrayList<>();
    this.Arbitrajes=new ArrayList<>();
    }
    /**
     * Constructor con parámetros para crear un partido.
     * @param fecha fecha del encuentro.
     * @param horario horario de inicio del partido.
     * @param duracion minutos de duración del partido.
     * @param tiempoadicional minutos adicionales agregador al partido
     * @param estadio el {@link Estadio} donde se jugará el encuentro.
     * @param fase la {@link Fase} del mundial a la que corresponde el partido.
     * @param seleccion1 la {@link Participacion} del primer equipo participante 
     * @param seleccion2 la {@link Participacion} del segundo equipo participante.
     */
    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoadicional,Estadio estadio,Fase fase,Participacion seleccion1,Participacion seleccion2) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoadicional = tiempoadicional;
        this.estadio=estadio;
        this.fase=fase;
        this.seleccion1=seleccion1;
        this.seleccion2=seleccion2;
        this.eventos=new ArrayList<>();
        this.Arbitrajes=new ArrayList<>();
    }
    /**
     * Crea y agrega un nuevo evento en el partido.
     * @param evento tipo de evento ocurrido.
     * @param minuto minuto que ocurrió el evento.
     * @param jugador jugador involucrado en el evento
     */
    
    public void agregarEvento(TipoEvento evento,int minuto, Jugador jugador){
            Evento e=new Evento(evento,minuto,jugador);
            this.eventos.add(e);
            if(jugador!=null){
                jugador.agregarEvento(e); //Mantiene sincronizada la lista del jugador
            }
    }
    /**
     * Agrega un equipo de arbitraje que dirije el parido. 
     * @param a objeto que se va a agregar.
     */
    
    public void agregarArbitraje(Arbitraje a){
        if(a != null){
            this.Arbitrajes.add(a);
            a.setPartido(this);
        }
    }
    //getter y setter
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTiempoadicional() {
        return tiempoadicional;
    }
    public void setTiempoadicional(int tiempoadicional) {
        this.tiempoadicional = tiempoadicional;
    }

    public Estadio getEstadio() {
        return estadio;
    }
    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Fase getFase() {
        return fase;
    }
    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Participacion getSeleccion1() {
        return seleccion1;
    }
    public void setSeleccion1(Participacion seleccion1) {
        this.seleccion1 = seleccion1;
    }

    public Participacion getSeleccion2() {
        return seleccion2;
    }
    public void setSeleccion2(Participacion seleccion2) {
        this.seleccion2 = seleccion2;
    }

    public List<Evento> getEventos() {
        return eventos;
    }
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Arbitraje> getArbitraje() {
        return Arbitrajes;
    }
    public void setArbitraje(List<Arbitraje> Arbitrajes) {
        this.Arbitrajes = Arbitrajes;
    }
  
    @Override
    public String toString() {
        return """
               
               -------Partido------
               Fecha: """ + this.fecha + ""
                + "\nHorario: " + this.horario + ""
                + "\nDuracion: " + this.duracion + ""
                + "\nTiempo adicional: " + this.tiempoadicional + ""
                + "\nLocal: " + (seleccion1 != null ? seleccion1.getSeleccion().getNombreFederacion() + " " + seleccion1.getCantidadGoles() : "Sin asignar")+ ""
                + "\nVisitante: " + (seleccion2 != null ? seleccion2.getSeleccion().getNombreFederacion() + " " + seleccion2.getCantidadGoles(): "Sin Asignar");
    }
}

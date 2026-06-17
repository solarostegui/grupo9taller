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
 *
 * @author mardalorso
 */
public class Partido {
    //variables miembro de objeto
    private LocalDate fecha;
    private LocalTime horario;
    private int duracion;
    private int tiempoadicional;
    //bidireccional con estadio
    private Estadio estadio;
    //bidireccional con fase
    private Fase fase;
    //clase asocicion con Participacion
    private Participacion seleccion1;
    private Participacion seleccion2;
    //composicion con evento
    private List<Evento> eventos;
    //Clase asociacion arbitraje
    private List<Arbitraje> Arbitrajes;
    
    //contructor por defecto
    public Partido(){
    this.eventos=new ArrayList<Evento>();
    this.Arbitrajes=new ArrayList<Arbitraje>();
    }
    
    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoadicional,Estadio estadio,Fase fase,Participacion seleccion1,Participacion seleccion2) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoadicional = tiempoadicional;
        this.estadio=estadio;
        this.fase=fase;
        this.seleccion1=seleccion1;
        this.seleccion2=seleccion2;
        this.eventos=new ArrayList<Evento>();
        this.Arbitrajes=new ArrayList<Arbitraje>();
    }
    //agregar para las listas
    //this indica que es para ese patido que esta jugando
    public void agregarEvento(TipoEvento evento,int minuto, Jugador jugador){
            Evento e=new Evento(evento,minuto,jugador);
            this.eventos.add(e);
            if(jugador!=null){
                jugador.agregarEvento(e); //Mantiene sincronizada la lista del jugador
            }
    }
    
    //Agrega un arbitraje al partido y sincroniza la referencia bidireccional
    public void agregarArbitraje(Arbitraje a){
        if(a!=null){
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
        return "\n-------Partido------" + ""
                + "\nFecha: " + this.fecha + ""
                + "\nHorario: " + this.horario + ""
                + "\nDuracion: " + this.duracion + ""
                + "\nTiempo adicional: " + this.tiempoadicional + ""
                + "\nLocal: " + (seleccion1 != null ? seleccion1.getSeleccion().getNombreFederacion() + " " + seleccion1.getCantidadGoles() : "Sin asignar")+ ""
                + "\nVisitante: " + (seleccion2 != null ? seleccion2.getSeleccion().getNombreFederacion() + " " + seleccion2.getCantidadGoles(): "Sin Asignar");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;
import java.time.Clock;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author mardalorso
 */
public class Partido {
    //variables miembro de objeto
    private Date fecha;
    private Clock horario;
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
    
    public Partido(Date fecha, Clock horario, int duracion, int tiempoadicional,Estadio estadio,Fase fase,Participacion seleccion1,Participacion seleccion2) {
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
    public void agregarEvento(TipoEvento evento,int minuto, Jugador jugador){
        this.eventos.add (new Evento(evento,minuto, jugador));
    }
    
    //Validamos que no este vacio arbitraje
    public void agregarArbitraje(Arbitraje a){
        if(a.getPartido() != null) {
        this.Arbitrajes.add(a);
        a.setPartido(this);   
        }
    }
    //getter y setter
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Clock getHorario() {
        return horario;
    }
    public void setHorario(Clock horario) {
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
    
    //metodo para actualizar los resultados de partido y el grupo
    public static int cargarResultados(){
        return 0;
    }
    
    

    @Override
    public String toString() {
        return "\n-------Partido------" + ""
                + "\nFecha: " + this.fecha + ""
                + "\nHorario: " + this.horario + ""
                + "\nDuracion: " + this.duracion + ""
                + "\nTiempo adicional: " + this.tiempoadicional;
    }
    
    
    
}

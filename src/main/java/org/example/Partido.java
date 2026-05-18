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
    //bidireccional con seleccion
    private Seleccion seleccion1;
    private Seleccion seleccion2;
    //composicion con evento
    private List<Evento> eventos;
    
    //contructor por defecto
    public Partido(){
    this.eventos=new ArrayList<Evento>();
    }

    public Partido(Date fecha, Clock horario, int duracion, int tiempoadicional,Estadio estadio,Fase fase,Seleccion seleccion1,Seleccion seleccion2) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoadicional = tiempoadicional;
        this.estadio=estadio;
        this.fase=fase;
        this.seleccion1=seleccion1;
        this.seleccion2=seleccion2;
        this.eventos=new ArrayList<Evento>();
    }
    public void agregarEvento(TipoEvento evento,int minuto){
        this.eventos.add (new Evento(evento,minuto));
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

    @Override
    public String toString() {
        return "\n-------Partido------" + ""
                + "\nFecha: " + this.fecha + ""
                + "\nHorario: " + this.horario + ""
                + "\nDuracion: " + this.duracion + ""
                + "\nTiempo adicional: " + this.tiempoadicional;
    }
    
    
    
}

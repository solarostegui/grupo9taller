/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;
import java.time.Clock;
import java.util.Date;
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
    
    //contructor por defecto
    public Partido(){}

    public Partido(Date fecha, Clock horario, int duracion, int tiempoadicional) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoadicional = tiempoadicional;
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

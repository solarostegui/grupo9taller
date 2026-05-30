package org.example;

public class Participacion {
    private boolean eslocal;
    private int cantidadGoles;
    private int cantidadTarjAmarillas;
    private int cantidadTarjRojas;
    //clase asociacion con seleccion
    private Seleccion seleccion;
    //clase asociacion con partido
    private Partido partido;

    //constructor con parametros
    public Participacion(boolean eslocal,int cantidadGoles,int cantidadTarjAmarillas,int cantidadTarjRojas,Partido partido,Seleccion seleccion) {
        this.cantidadGoles = cantidadGoles;
        this.cantidadTarjAmarillas = cantidadTarjAmarillas;
        this.cantidadTarjRojas = cantidadTarjRojas;
        this.eslocal = eslocal;
        this.partido=partido;
        this.seleccion=seleccion;
    }

    //Getters y setters
    public boolean getEslocal() {
        return eslocal;
    }
    public void setEslocal(boolean eslocal) {
        this.eslocal = eslocal;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }
    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    public int getCantidadTarjAmarillas() {
        return cantidadTarjAmarillas;
    }
    public void setCantidadTarjAmarillas(int cantidadTarjAmarillas) {
        this.cantidadTarjAmarillas = cantidadTarjAmarillas;
    }

    public int getCantidadTarjRojas() {
        return cantidadTarjRojas;
    }
    public void setCantidadTarjRojas(int cantidadTarjRojas) {
        this.cantidadTarjRojas = cantidadTarjRojas;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public Partido getPartido() {
        return partido;
    }
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
}
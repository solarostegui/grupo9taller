package org.example;

public class Participacion {
    private boolean eslocal;
    public int cantidadGoles;
    public int cantidadTarjAmarillas;
    public int cantidadTarjRojas;

    //constructor con parametros
    public Participacion(boolean eslocal,int cantidadGoles,int cantidadTarjAmarillas,int cantidadTarjRojas) {
        this.cantidadGoles = cantidadGoles;
        this.cantidadTarjAmarillas = cantidadTarjAmarillas;
        this.cantidadTarjRojas = cantidadTarjRojas;
        this.eslocal = eslocal;
    }

    public boolean isEslocal() {
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
}
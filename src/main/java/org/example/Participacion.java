package org.example;

public class Participacion {
    private boolean eslocal;
    //clase asociacion con seleccion
    private Seleccion seleccion;
    //clase asociacion con partido
    private Partido partido;

    //constructor con parametros
    public Participacion(boolean eslocal,Partido partido,Seleccion seleccion) {
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
    
    public int cantidadGoles(){
        return 0;
    }
    
    public int cantidadTarjAmarilla(){
        return 0;
    }
    
    public int cantidadTarjRojas(){
        return 0;
    }
}
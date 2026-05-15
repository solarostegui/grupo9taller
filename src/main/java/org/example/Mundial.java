package org.example;

public class Mundial {

    private int anio;
    private String mascota;
    private int fechadesde;
    private int fechahasta;

    //constructor con parametros
    public Mundial (int anio, String mascota, int fechadesde, int fechahasta){
        this.anio = anio;
        this.mascota = mascota;
        this.fechadesde = fechadesde;
        this.fechahasta = fechahasta;
    }

    //getter y setters

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public int getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(int fechadesde) {
        this.fechadesde = fechadesde;
    }

    public int getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(int fechahasta) {
        this.fechahasta = fechahasta;
    }

}

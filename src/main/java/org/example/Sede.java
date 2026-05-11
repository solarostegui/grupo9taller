package org.example;

public class Sede {
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
    }
    
    public Sede(){
        this.ciudad = "";
        this.alturaNivelMar = 0.0F;
        this.clima = "";
        this.zonaHoraria = "";
    }

    public String getCiudad() {
        return ciudad;
    }

    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public String getClima() {
        return clima;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
    
    
}


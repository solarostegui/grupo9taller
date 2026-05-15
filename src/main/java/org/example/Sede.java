package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sede {
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private List<Estadio> estadios;
    private List<Pais> paises;

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, List<Estadio> estadios, List<Pais> paises) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios = estadios;
        this.paises = paises;
    }
    
    public Sede(){
        this.ciudad = "";
        this.alturaNivelMar = 0.0F;
        this.clima = "";
        this.zonaHoraria = "";
        this.estadios = new ArrayList<Estadio>();
        this.paises = new ArrayList<Pais>();
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

    public void setEstadios (List<Estadio> estadios) {this.estadios = estadios;}

    public void setPaises (List<Pais> paises) {this.paises = paises;}

    public void agregarEstadio (Estadio e) {this.estadios.add (e); }
    public void agregarPais (Pais p){this.paises.add (p);}
}


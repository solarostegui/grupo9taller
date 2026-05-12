package org.example;

public class Arbitraje {
    private TipoCategoriaArbitro rol;

    private Arbitro arbitro;
    private Partido partido;

    public Arbitraje(TipoCategoriaArbitro rol, Arbitro arbitro, Partido partido){
        this.rol = rol;
        this.arbitro = arbitro;
        this.partido = partido;
    }

}


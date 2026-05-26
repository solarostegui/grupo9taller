package org.example;

public class Arbitraje {
    private TipoCategoriaArbitro rol;
    //clase asociacion con arbitro
    private Arbitro arbitro;
    //clase asociacion con partido
    private Partido partido;

    public Arbitraje(TipoCategoriaArbitro rol, Arbitro arbitro, Partido partido){
        this.rol = rol;
        this.arbitro = arbitro;
        this.partido = partido;
    }
    
    

}


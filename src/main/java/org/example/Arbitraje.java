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

    public TipoCategoriaArbitro getRol() {
        return rol;
    }

    public void setRol(TipoCategoriaArbitro rol) {
        this.rol = rol;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    

}


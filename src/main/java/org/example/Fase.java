
package org.example;

public class Fase {
    private TipoNombreFase nombreFase;

    public Fase(TipoNombreFase nombreFase) {
        this.nombreFase = nombreFase;
    }
    
    public Fase(){
    }

    public TipoNombreFase getNombreFase() {
        return nombreFase;
    }

    public void setNombreFase(TipoNombreFase nombreFase) {
        this.nombreFase = nombreFase;
    }

    @Override
    public String toString() {
        return "\nFase: "  + this.nombreFase;
    }
    
    
    
}

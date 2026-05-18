
package org.example;
import java.util.List;
import java.util.ArrayList;

public class Fase {
    private TipoNombreFase nombreFase;
    //bidireccional con partido
    private List<Partido> partidos;
    

    public Fase(TipoNombreFase nombreFase,List<Partido> partidos) {
        this.nombreFase = nombreFase;
        this.partidos=partidos;
    }
    
    public Fase(){
        this.partidos=new ArrayList<Partido>();
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

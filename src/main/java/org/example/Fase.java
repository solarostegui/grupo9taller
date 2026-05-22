
package org.example;
import java.util.List;
import java.util.ArrayList;

public class Fase {
    private TipoNombreFase nombreFase;
    //bidireccional con partido
    private List<Partido> partidos;
    

    public Fase(TipoNombreFase nombreFase) {
        this.nombreFase = nombreFase;
        this.partidos=new ArrayList<Partido>();
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

    public List<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    public void agregarPartido(Partido p){
        this.partidos.add(p);
    }
    

    @Override
    public String toString() {
        return "\nFase: "  + this.nombreFase;
    }
    
    
    
}

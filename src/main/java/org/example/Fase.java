
package org.example;
import java.util.List;
import java.util.ArrayList;

public class Fase {
    private TipoNombreFase nombreFase;
    //bidireccional con partido
    private List<Partido> partidos;
    //bidireccional con grupo
    private List<Grupo> grupos;
    

    public Fase(TipoNombreFase nombreFase) {
        this.nombreFase = nombreFase;
        this.partidos=new ArrayList<Partido>();
        this.grupos=new ArrayList<Grupo>();
    }
    
    public Fase(){
        this.partidos=new ArrayList<Partido>();
    }

    //Getters y setters
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

    public List<Grupo> getGrupos() {return grupos;}
    public void setGrupos(List<Grupo> grupos) {this.grupos = grupos;}

    public void agregarPartido(Partido p){
        this.partidos.add(p);
    }
    public void agregarGrupos(Grupo g){
        this.grupos.add(g);
    }
    

    @Override
    public String toString() {
        return "\nFase: "  + this.nombreFase;
    }
    
    
    
}

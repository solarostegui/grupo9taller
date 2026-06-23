
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

    public boolean agregarPartido(Partido p){
        if(p == null){
            return false;
        }
        // Validamos si el partido ya fue agregado a esta fase
        if(!this.partidos.contains(p)){
            this.partidos.add(p);
            return true;
        }
        return false; //no se agrega porque ya existe
    }
    
    public boolean agregarGrupos(Grupo g){
        if(g == null){
            return false;
        }
        if(!this.grupos.contains(g)){
            this.grupos.add(g);
            return true;
        }
        return false;
    }
    

    @Override
    public String toString() {
        return "\nFase: "  + this.nombreFase;
    }
    
    
    
}

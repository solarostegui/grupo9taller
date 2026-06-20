
package org.example;
import java.util.List;
import java.util.ArrayList;

public class Seleccion {
    //variable miembro de objeto
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    //clase asociacion con participacion
    private List<Participacion> participaciones;
    //bidireccional con pais
    private Pais pais;
    //bidireccional con grupo
    private Grupo grupo;
    //Agregacion de jugador
    private List<Jugador> jugador;
    //Agregacion Director Tecnico
    private List<DirectorTecnico> directoresTecnicos;
    //Agregacion con Cuerpo Tecnico
    private List<CuerpoTecnico> cuerposTecnicos;


    //constructor parametrizado
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo, int rankingFIFA,Pais pais, Grupo grupo) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.participaciones=new ArrayList<Participacion>();
        this.pais = pais;
        this.grupo = grupo;
        this.jugador = new ArrayList<Jugador>();
        this.directoresTecnicos = new ArrayList<DirectorTecnico>();
        this.cuerposTecnicos = new ArrayList<CuerpoTecnico>();
    }
    //constructor por defecto
    public Seleccion(){
        this.jugador = new ArrayList<Jugador>();
        this.directoresTecnicos = new ArrayList<DirectorTecnico>();
        this.cuerposTecnicos = new ArrayList<CuerpoTecnico>();
        this.participaciones=new ArrayList<Participacion>();
    }
    //Setter y getter
    public String getNombreFederacion() {
        return nombreFederacion;
    }
    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }
    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }
    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    public boolean getCabezaGrupo() {
        return cabezaGrupo;
    }
    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }
    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Grupo getGrupo() {
        return grupo;
    }
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Jugador> getJugador() {
        return jugador;
    }
    public void setJugador(List<Jugador> jugador) {
        this.jugador = jugador;
    }

    public List<DirectorTecnico> getDirectoresTecnicos() {
        return directoresTecnicos;
    }
    public void setDirectoresTecnicos(List<DirectorTecnico> directoresTecnicos) {
        this.directoresTecnicos = directoresTecnicos;
    }

    public List<CuerpoTecnico> getCuerposTecnicos() {
        return cuerposTecnicos;
    }
    public void setCuerposTecnicos(List<CuerpoTecnico> cuerposTecnicos) {
        this.cuerposTecnicos = cuerposTecnicos;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }
    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
    
    //Metodos para las listas
    public boolean agregarCuerposTecnicos(CuerpoTecnico ct){
        if(ct == null){
            return false;
        }
        if(!this.cuerposTecnicos.contains(ct)) {
            this.cuerposTecnicos.add(ct);
            return true;
        }
        return false;
    }
    
    public boolean agregarDirectoresTecnicos(DirectorTecnico dt){
        if(dt == null){
            return false;
        }
        if(!this.directoresTecnicos.contains(dt)){
           this.directoresTecnicos.add(dt);
           return true;
        }
        return false;   
    }
    
    public void agregarParticipacion(Participacion p){
       this.participaciones.add(p);
   }

    /*Chequeamos que un jugador no se repita 
    en una seleccion*/
    public boolean agregarJugador(Jugador j){
        if(j==null){
            return false;
        }
        if(!this.jugador.contains(j)){
            this.jugador.add(j);
            return true;
        } else{
            return false;

        }
    }
    @Override
    public String toString() {
        return "--------Seleccion----------" +
               "\nNombreFederacion: " + this.nombreFederacion + ""
                + "\nCamisetaPrincipal: " + this.camisetaPrincipal + ""
                + "\nCamisetaSecundaria:" + this.camisetaSecundaria + ""
                + "\nCabezagrupo: " + this.cabezaGrupo
                + "\nRankingFIFA: " + this.rankingFIFA;
    }
    
    
    
}

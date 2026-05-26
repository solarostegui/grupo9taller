/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author mardalorso
 */
public class Seleccion {
    //variables miembro de objeto
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezagrupo;
    private int rankingFIFA;
    //clase asociacion con participacion
    private List<Participacion> participaciones;
    //bidireccional con pais
    private Pais pais;
    //bidireccional con grupo
    private Grupo grupo;
    //Agregacion de jugador
    private List<Jugador> jugadores;
    //Agregacion Director Tecnico
    private List<DirectorTecnico> directoresTecnicos;
    //Agregacion con Cuerpo Tecnico
    private List<CuerpoTecnico> cuerposTecnicos;
    
    public void Partido(){
        this.participaciones=new ArrayList<Participacion>();
    }
    //constructor parametrizado
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezagrupo, int rankingFIFA,Pais pais, Grupo grupo) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezagrupo = cabezagrupo;
        this.rankingFIFA = rankingFIFA;
        this.participaciones=new ArrayList<Participacion>();
        this.pais = pais;
        this.grupo = grupo;
        this.jugadores = new ArrayList<Jugador>();
        this.directoresTecnicos = new ArrayList<DirectorTecnico>();
        this.cuerposTecnicos = new ArrayList<CuerpoTecnico>();
    }
    //constructor por defecto
    public Seleccion(){
        this.jugadores = new ArrayList<Jugador>();
        this.directoresTecnicos = new ArrayList<DirectorTecnico>();
        this.cuerposTecnicos = new ArrayList<CuerpoTecnico>();
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

    public boolean isCabezagrupo() {
        return cabezagrupo;
    }

    public void setCabezagrupo(boolean cabezagrupo) {
        this.cabezagrupo = cabezagrupo;
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

    public void setDirectoresTecnicos(List<DirectorTecnico> directoresTecnicos) {
        this.directoresTecnicos = directoresTecnicos;
    }
    

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setCuerposTecnicos(List<CuerpoTecnico> cuerposTecnicos) {
        this.cuerposTecnicos = cuerposTecnicos;
    }
    
    //Metodos para las listas
    public void agregarcuerposTecnicos(CuerpoTecnico ct){
        this.cuerposTecnicos.add(ct);
    }
    public void agregardirectoresTecnicos(DirectorTecnico dt){
        this.directoresTecnicos.add(dt);
    }
    public void agregarParticipacion(Participacion p){
       this.participaciones.add(p);
   }
    public void agregarjugadores(Jugador j){
        this.jugadores.add(j);
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
    
   
    
    @Override
    public String toString() {
        return "--------Seleccion----------" +
               "\nNombreFederacion: " + this.nombreFederacion + ""
                + "\nCamisetaPrincipal: " + this.camisetaPrincipal + ""
                + "\nCamisetaSecundaria:" + this.camisetaSecundaria + ""
                + "\nCabezagrupo: " + this.cabezagrupo 
                + "\nRankingFIFA: " + this.rankingFIFA;
    }
    
    
    
}

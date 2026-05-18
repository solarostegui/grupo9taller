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
    //biddireccional con partido
    private List<Partido> partidos;
    
    //constructor parametrizado
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezagrupo, int rankingFIFA,List<Partido> partidos) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezagrupo = cabezagrupo;
        this.rankingFIFA = rankingFIFA;
        this.partidos=partidos;
    }
    //constructor por defecto
    public Seleccion(){
        this.partidos= new ArrayList<Partido>();
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

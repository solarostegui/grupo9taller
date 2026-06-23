
package org.example;
import java.util.List;
import java.util.ArrayList;
/**
 * Clase que representa una seleccion que participa en el torneo.
 * Se encarga de guardar los datos de la federación, la camiseta y 
 * de administrar las listas de sus jugadores, el cuerpo técnico y los directores técnicos.
 * @author Antonella Monti, María del Mar Dalorso, María Sol Arostegui
 * @version 1.0
 */

public class Seleccion {
    /**
     * Nombre de la federación.
     */ 
    private String nombreFederacion;
    /**
     * Camiseta principal
     */
    private String camisetaPrincipal;
    /**
     * Camiseta Secundaria
     */
    private String camisetaSecundaria;
    /**
     * Puntero del grupo
     */
    private boolean cabezaGrupo;
    /**
     * Posición en el ranking Fifa
     */
    private int rankingFIFA;
    /**
     * Relación de asociación, colección de las participaciones de la seleccion
     */
    private List<Participacion> participaciones;
    /**
     * Relación bidireccional, una seleccion representa a un pais.
     */ 
    private Pais pais;
    /**
     * Relación bidireccional, las selecciones se agrupan en un grupo. 
     */
    private Grupo grupo;
    /**
     * Relación de agregación, Coleccion de jugadores que integra una seleccion.
     */
    private List<Jugador> jugador;
    /**
     * Relacion de agregación, Colección de director tecnico que dirige una seleccion.
     */
    
    private List<DirectorTecnico> directoresTecnicos;
    /**
     * Relacion de agregación, Colección de cuerpo técnico que tiene una selección.
     */
    
    private List<CuerpoTecnico> cuerposTecnicos;

    /**
     * Constructor con parámetros que crea una seleccion e inicializa las colecciones 
     * de jugador, director tecnico y cuerpo tecnico.
     * @param nombreFederacion nombre de la seleccion
     * @param camisetaPrincipal nombre de la camiseta pricipal
     * @param camisetaSecundaria nombre de la camiseta secundaria
     * @param cabezaGrupo puntero del grupo
     * @param rankingFIFA poscion de la seleccion en el ranking
     * @param pais pais que representa la seleccion
     * @param grupo grupo que pertenece de la selección
     */
    
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo, int rankingFIFA,Pais pais, Grupo grupo) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.participaciones=new ArrayList<>();
        this.pais = pais;
        this.grupo = grupo;
        this.jugador = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
    }
    /**
     * Contructor por defecto que inicializa las colecciones para evitar errores.
     */
    public Seleccion(){
        this.jugador = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
        this.participaciones=new ArrayList<>();
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
    
    /**
     * Agrega un nuevo miembro al cuerpo técnico de esta selección.
     * Verifica que el objeto no sea nulo y que no esté ya registrado en la lista.
     * @param ct El {@link CuerpoTecnico} que se quiere agregar.
     * @return {@code true} si se agregó con éxito, o {@code false} si ya existía o era nulo.
     */
     
    
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
    
    /**
     * Incorpora un director técnico a la selección.
     * Chequea que el dato sea válido y que no se repita.
     * @param dt El {@link DirectorTecnico} que se desea sumar.
     * @return {@code true} si se agregó correctamente, o {@code false} si ya estaba en la lista o es nulo.
     */
    
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
    
    /**
     * Registra un nuevo partido de la selección.
     * @param p La {@link Participacion} que vincula a este equipo con el encuentro jugado.
     */
    
    public void agregarParticipacion(Participacion p){
       this.participaciones.add(p);
   }

    /**
     * Añade un jugador a la selección.
     * Verifica que el jugador no se repita en la lista de este equipo.
     * @param j El {@link Jugador} que se intenta agregar.
     * @return {@code true} si el jugador fue sumado con éxito, o {@code false} si ya estaba anotado o es nulo.
     */
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
        return """
               --------Seleccion----------
               NombreFederacion: """ + this.nombreFederacion + ""
                + "\nCamisetaPrincipal: " + this.camisetaPrincipal + ""
                + "\nCamisetaSecundaria:" + this.camisetaSecundaria + ""
                + "\nCabezagrupo: " + this.cabezaGrupo
                + "\nRankingFIFA: " + this.rankingFIFA;
    }
    
    
    
}

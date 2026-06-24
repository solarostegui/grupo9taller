
package org.example;
import java.util.*;
/**
 * Clase que representa una relación bidireccional donde un grupo se incluye dentro de una fase y
 * se encarga de agrupar selecciones. Cada grupo tiene una identificación y descripción correspondiente. Además,
 * calcula los puntos de una seleccion en base al partido jugado.
 * @author María del Mar Dalroso, Monti Antonella.
 * @version 1.0
 */
public class Grupo {
    /**
     * Letra de identificación para cada grupo.
     */
    private String identificacion;
    /**
     * Descripción del grupo.
     */
    private String descripcion;
    /**
     * Colección de selecciones que conforman un grupo específico
     */
    private List<Seleccion> selecciones;
    /**
     * Fase del torneo en la que se enceuntra un grupo.
     */
    private Fase fase;
    
    /**
     * Constructor parametrizado para instanciar un nuevo grupo.
     * @param identificacion letra que se le asigna a un grupo.
     * @param descripcion nombre descriptivo del grupo.
     * @param fase La {@link Fase} a la que se asocia este grupo.
     */

    public Grupo(String identificacion, String descripcion,Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.selecciones = new ArrayList<>();
        this.fase = fase;
        
    }
    /**
     * Constructor por defecto.
     * Inicializa atributos con valores vacíos y la lista de selecciones.
     */
    public Grupo(){
        this.identificacion = "";
        this.descripcion = "";
        this.selecciones = new ArrayList<>();
        
        
    }
    //Getters y setters
    public String getIdentificacion() {
        return identificacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public List<Seleccion> getSelecciones() {
        return selecciones;
    }
    public Fase getFase() {
        return fase;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setSelecciones(List<Seleccion> seleccion) {
        this.selecciones = seleccion;
    }
    public void setFase(Fase fase) {
        this.fase = fase;
    }
    
    /**
     * Agrega una nueva selección a este grupo, asegurando que no pertenezca a otra.
     *
     * @param s El objeto {@link Seleccion} a agregar.
     * @return {@code true} si la selección se agregó correctamente, {@code false} si ya pertenecía a un grupo.
     */
    public boolean agregarSeleccion(Seleccion s){
        if (s != null && !this.selecciones.contains(s)){
            this.selecciones.add(s);
            s.setGrupo(this);
            return true;
        } 
        return false;
    }
    /**
     * Calcula y devuelve los puntos de una selección dentro de este grupo.
     * Cumple con el requerimiento del sistema procesando los resultados de los partidos:
     * victoria = 3 puntos, empate = 1 punto, derrota = 0 puntos.
     *
     * @param s La {@link Seleccion} de la cual se quiere obtener los puntos.
     * @return El puntaje total acumulado por la selección pasada por parámetro.
     */
    // Devuelve los puntos de una selección, calculados directo de los partidos
    // (sin instanciar Estadistica - eso queda para las clases gestoras)
    public int obtenerPuntos(Seleccion s){
        int puntos = 0;
        if (this.fase == null || this.fase.getPartidos() == null) return puntos;

        for (Partido partido : this.fase.getPartidos()){
            if (partido == null) continue;
            Participacion part1 = partido.getSeleccion1();
            Participacion part2 = partido.getSeleccion2();
            if (part1 == null || part2 == null) 
                continue;

            Seleccion s1 = part1.getSeleccion();
            Seleccion s2 = part2.getSeleccion();
            if (s1 == null || s2 == null) 
                continue;
            if (!this.selecciones.contains(s1) || !this.selecciones.contains(s2)) 
                continue;

            int golesS1 = part1.getCantidadGoles();
            int golesS2 = part2.getCantidadGoles();

            if (s1.equals(s)){
                if (golesS1 > golesS2) 
                    puntos += 3;
                else if (golesS1 == golesS2) 
                    puntos += 1;
            } else if (s2.equals(s)){
                if (golesS2 > golesS1) puntos += 3;
                else if (golesS1 == golesS2) puntos += 1;
            }
        }
        return puntos;
    }
    
    @Override
    public String toString(){
        return "Grupo: " + this.identificacion + " - " + this.descripcion;
    }
}

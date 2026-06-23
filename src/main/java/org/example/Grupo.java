
package org.example;
import java.util.*;
/**
 *
 * @author mardalorso
 */
public class Grupo {
    private String identificacion;
    private String descripcion;
    //bidireccional con seleccion
    private List<Seleccion> selecciones;
    //bidireccional con fase
    private Fase fase;
    
    

    public Grupo(String identificacion, String descripcion,Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.selecciones = new ArrayList<Seleccion>();
        this.fase = fase;
        
    }
    
    public Grupo(){
        this.identificacion = "";
        this.descripcion = "";
        this.selecciones = new ArrayList<Seleccion>();
        
        
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

    public boolean agregarSeleccion(Seleccion s){
        if (s != null && !this.selecciones.contains(s)){
            this.selecciones.add(s);
            s.setGrupo(this);
            return true;
        } 
        return false;
    }
    // Devuelve los puntos de una selección, calculados directo de los partidos
    // (sin instanciar Estadistica - eso queda para las clases gestoras)
    public int obtenerPuntos(Seleccion s){
        int puntos = 0;
        if (this.fase == null || this.fase.getPartidos() == null) return puntos;

        for (Partido partido : this.fase.getPartidos()){
            if (partido == null) continue;
            Participacion part1 = partido.getSeleccion1();
            Participacion part2 = partido.getSeleccion2();
            if (part1 == null || part2 == null) continue;

        Seleccion s1 = part1.getSeleccion();
            Seleccion s2 = part2.getSeleccion();
            if (s1 == null || s2 == null) continue;
            if (!this.selecciones.contains(s1) || !this.selecciones.contains(s2)) continue;

            int golesS1 = part1.getCantidadGoles();
            int golesS2 = part2.getCantidadGoles();

            if (s1.equals(s)){
                if (golesS1 > golesS2) puntos += 3;
                else if (golesS1 == golesS2) puntos += 1;
            } else if (s2.equals(s)){
                if (golesS2 > golesS1) puntos += 3;
                else if (golesS1 == golesS2) puntos += 1;
            }
        }
        return puntos;
    }
}

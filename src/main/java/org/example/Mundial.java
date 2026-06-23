package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa el Mundial, clase central que almacena 
 * y coordina toda la información general del torneo y sus sedes.
 * @author Antonella Monti, María del Mar Dalorso.
 * @version 1.0
 */
public class Mundial {
    /**
     * Año en que se realiza el mundial.
     */
    private int anio;
    /**
     * Nombre de la mascota oficial del mundial.
     */
    private String mascota;
    /**
     * Fecha de inicio del mundial
     */
    private int fechadesde;
    /**
     * Fecha de finalización del mundial
     */
    private int fechahasta;
    /**
     * Relación de agregación, colección de sedes asignadas para disputar el torneo.
     */
    private List<Sede> sedes;
    
    /**
     * Constructor con parámetros para crear un mundial e inicializa
     * la estructura de datos para la colección de sedes.
     * @param anio año del mundial.
     * @param mascota nombre de la mascota representativa del mundial.
     * @param fechadesde fecha de inicio del torneo.
     * @param fechahasta  fecha de finalización del torneo.
     */
    
    public Mundial (int anio, String mascota, int fechadesde, int fechahasta){
        this.anio = anio;
        this.mascota = mascota;
        this.fechadesde = fechadesde;
        this.fechahasta = fechahasta;
        this.sedes = new ArrayList<Sede>();
    }
    
    /**
     * Constructor por defecto que inicializa la lista de sedes vacía.
     */
    public Mundial (){
        this.sedes = new ArrayList<Sede>();
    }
    
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMascota() {
        return mascota;
    }
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public int getFechadesde() {
        return fechadesde;
    }
    public void setFechadesde(int fechadesde) {
        this.fechadesde = fechadesde;
    }

    public int getFechahasta() {
        return fechahasta;
    }
    public void setFechahasta(int fechahasta) {
        this.fechahasta = fechahasta;
    }

    public List<Sede> getSedes() {
        return sedes;
    }
    public void setSedes (List<Sede> sedes){
        this.sedes=sedes;
    }
    /**
     * Agrega una nueva sede a la lista de sedes. 
     * Valida si ya existe la sede.
     * @param s objeto que se agrega a la lista
     * @return true si se añade correctamente a la lista, false si ya existe la sede o es null.
     */
    public boolean agregarSede (Sede s){
        if (s == null) {
        return false;
    }
        if(!this.sedes.contains(s)){
            this.sedes.add(s);
            return true;
        }
        return false;
    }
    

}


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

    //metodo para agregar a la lista las selecciones
    public void agregarSeleccion(Seleccion s){
        this.selecciones.add(s);
    }
   //Completar método de ObtenerPuntos 
    public int obtenerPuntos(Seleccion s){
        return 0;
    }
    
  
}

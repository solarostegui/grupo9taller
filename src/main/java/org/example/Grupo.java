
package org.example;
import java.util.*;

public class Grupo {
    private String identificacion;
    private String descripcion;
    private int num;
    //bidireccional con seleccion
    private List<Seleccion> selecciones;
    

    public Grupo(String identificacion, String descripcion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.selecciones = new ArrayList<Seleccion>();
        
    }
    
    public Grupo(){
        this.identificacion = "";
        this.descripcion = "";
        this.selecciones = new ArrayList<Seleccion>();
        
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSeleccion(List<Seleccion> seleccion) {
        this.selecciones = seleccion;
    }
    
    //metodo para agregar a la lista las selecciones 
    public void agregarSelecciones(Seleccion s){
        this.selecciones.add(s);
    }
   //Completar método de ObtenerPuntos 
    public int obtenerPuntos(Seleccion s){
        return 0;
    }
    
  
}


package org.example;
import java.util.*;

public class Grupo {
    private String identificacion;
    private String descripcion;
    private int num;
    //bidireccional con seleccion
    private List<Seleccion> seleccion;

    public Grupo(String identificacion, String descripcion, List<Seleccion> seleccion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.seleccion = seleccion;
    }
    
    public Grupo(){
        this.identificacion = "";
        this.descripcion = "";
        this.seleccion = new ArrayList<Seleccion>();
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
    
   //Completar método de ObtenerPuntos 
    public int obtenerPuntos(Seleccion s){
        return 0;
    }
    
  
}

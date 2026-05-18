
package org.example;

public class Grupo {
    private String identificacion;
    private String descripcion;
    private int num;

    public Grupo(String identificacion, String descripcion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
    }
    
    public Grupo(){
        this.identificacion = "";
        this.descripcion = "";
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
        return 3;
    }
}

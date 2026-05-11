package org.example;
//Definición clase jugador -> atributos: fechaNombramiento (int)
public class DirectorTecnico extends Persona{
    private int fechaNombramiento;

    //Constructor con parámetros
    public DirectorTecnico (String nombre, int fecNacimiento, int fechaNombramiento){
        super (nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    //Constructor por defecto
    public DirectorTecnico (){
    }

    //Get
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }
}

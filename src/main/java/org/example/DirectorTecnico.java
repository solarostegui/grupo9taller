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

    //Get y setter
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFecNacimiento() {
        return fecNacimiento;
    }
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    @Override
    public String toString() {
        return "-----DirectorTecnico-----"+
                "\nNombre: "+super.nombre+
                "\nFecha de nacimiento: "+super.fecNacimiento+
                "\nFecha de nombramiento: " + this.fechaNombramiento;
    }
    
}

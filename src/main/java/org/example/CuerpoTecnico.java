/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author mardalorso
 */
public class CuerpoTecnico extends Persona{
    //variable miembro de objeto
    private TipoRol rol;
    //constructor por defecto
    public CuerpoTecnico(){}
    //contructor parametrizado
    public CuerpoTecnico(String nombre,int fecNacimiento,TipoRol rol) {
        super(nombre,fecNacimiento);
        this.rol = rol;
    }
    //setter y getter
    public TipoRol getRol() {
        return rol;
    }
    public void setRol(TipoRol rol) {
        this.rol = rol;
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
    
    public String toString() {
        return "------CuerpoTecnico----" + 
                "\nRol: " + this.rol;
    }
    
    
    
}

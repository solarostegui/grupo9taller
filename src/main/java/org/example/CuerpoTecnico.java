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
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
    }
        if (this.getClass() != o.getClass()) {
            return false;
    }
        CuerpoTecnico otroCT = (CuerpoTecnico) o;
        
        boolean nombresIguales = this.getNombre().equalsIgnoreCase(otroCT.getNombre());
        
        return nombresIguales;
}

    
    @Override
    public String toString() {
        return "------CuerpoTecnico----" + 
                "\nNombre: "+super.nombre+
                "\nFecha de nacimiento: "+super.fecNacimiento+
                "\nRol: " + this.rol;
    }
    
    
    
}

package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa una sede dentro de la organización del mundial.
 * Una sede se define por su ubicación geográfica, sus condiciones ambientales y
 * contiene un conjunto de estadios asociados donde se disputan los partidos.
 * @author Antonella Monti, María del Mar Dalorso.
 * @version 1.0
 */
public class Sede {
    /**
     * Ciudad donde se ubica la sede.
     */
    private String ciudad;
    /**
     * Altura de la ciudad sobre el nivel del mar.
     */
    private float alturaNivelMar;
    /**
     * Clima que predomina en la ciudad de la sede.
     */
    private String clima;
    /**
     * Zona horaria de la región donde se ubica la sede.
     */
    private String zonaHoraria;
    /**
     * Colección de estadios que forman parte y se ubican en la sede.
     */
    private List<Estadio> estadios;
    /**
     * Relación bidireccioanl, país al cual pertenece la sede.
     */
    //Bidireccional con pais
    private Pais pais;

    /**
     * Constructor con parametros que crea una sede e inicializa la lista para recibir estadios.
     * @param ciudad nombre de la ciudad de la sede
     * @param alturaNivelMar altura que se encuentra la sede sobre el nivel del mar
     * @param clima clima de la zona
     * @param zonaHoraria huso horario de la región
     * @param pais Objeto {@link Pais} al que pertenece la sede.
     */
    
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios = new ArrayList<>();
        this.pais = pais;
    }
    
    /**
     * Constructor por defecto que inicializa los atributos con valores vacíos o en ceros
     * e inicializa la lista.
     */
    public Sede(){
        this.ciudad = "";
        this.alturaNivelMar = 0.0F;
        this.clima = "";
        this.zonaHoraria = "";
        this.estadios = new ArrayList<>();

    }
    
    public String getCiudad() {
        return ciudad;
    }
    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }
    public String getClima() {
        return clima;
    }
    public String getZonaHoraria() {
        return zonaHoraria;
    }
    public Pais getPais() {
        return pais;
    }
    public List<Estadio> getEstadios() {
        return estadios;
    }

    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
    public void setEstadios (List<Estadio> estadios) {
        this.estadios = estadios;
    }
    public void setPaises (Pais pais) {
        this.pais = pais;
    }
    
    /**
     * Agrega un nuevo estadio a la sede. Verifíca si no fue agregado anteriormente.
     * Se establece de forma automática este objeto estadio dentro de sede.
     * @param estadio El objeto {@link Estadio} que se desea incorporar a la sede.
     * @return true si el estadio se agregó correctamente, false si ya se agregó anteriormente o es nulo.
     */
    
    public boolean agregarEstadio (Estadio estadio) {
        if(estadio == null){
            return false;
        }
        //usamos una bandera
        boolean existe = false;
        for (Estadio e: this.estadios){
            //Comparamos por el nombre si ya existe el estadio
            if(e.getNombre().equalsIgnoreCase(estadio.getNombre())){
                existe = true;
                break;
            }
        }
        if (!existe){ //Agrega si no existe estadio
            this.estadios.add(estadio);
            //agregamos estadio a su sede
            estadio.setSede(this);
            return true;
        }else {
            return false;
        }
    }
    /**
     * Devuelve una representación en texto de la información general de la sede.
     * @return Una cadena de caracteres formateada con los datos de la sede.
     */
    
    @Override
    public String toString() {
        return """
               ------Sede------
               Ciudad: """ + this.ciudad + 
                "\nAlturanivel del mar: " + this.alturaNivelMar + 
                "\nClima: " + this.clima + 
                "\nZona Horaria: " + this.zonaHoraria;
    }
    
    

}


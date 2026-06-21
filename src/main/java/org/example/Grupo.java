
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
    private List<Estadistica> tablaEstadisticas;
    

    public Grupo(String identificacion, String descripcion,Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.selecciones = new ArrayList<Seleccion>();
        this.fase = fase;
        this.tablaEstadisticas = new ArrayList<Estadistica>();
    }
    
    public Grupo(){
        this.identificacion = "";
        this.descripcion = "";
        this.selecciones = new ArrayList<Seleccion>();
        this.tablaEstadisticas = new ArrayList<Estadistica>();
        
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
    public List<Estadistica> getTablaEstadisticas() {
        return tablaEstadisticas;
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
    public void setTablaEstadisticas(List<Estadistica> tablaEstadisticas) {
        this.tablaEstadisticas = tablaEstadisticas;
    }

    //metodo para agregar cada sleeccion al grupo A, B, C, etc.
    public boolean agregarSeleccion(Seleccion s){
       if (s.getGrupo() == null){
          this.selecciones.add(s);
          s.setGrupo(this);
          this.tablaEstadisticas.add(new Estadistica(s)); 
          return true;
       } 
       return false;
    }
   //Completar método de ObtenerPuntos 
    public int obtenerPuntos(Seleccion s){
        for(Estadistica est : this.tablaEstadisticas){
            if(est.getSeleccion() == s){
                return est.getPuntos();
            }
        }
        return 0;
    }
    //Método para actualiza tabla de posiciones
    public void actualizarTablaPosiciones(){
        //1. Usamos el metodo restablecer para llevar todo a cero y que no quede nada de lo anterior
        for (Estadistica est : this.tablaEstadisticas){
            est.restablecer();
        }
        //2. el grupo debe tener partidos asignados a su fase, sino no hay nada que calcular
        if (this.fase == null || this.fase.getPartidos()==null || this.fase.getPartidos().isEmpty()){
            return;
        }
        //3. recorre los partidos que se juegan en esa fase
        for (Partido partido : this.fase.getPartidos()){
            if(partido == null){
                continue;
            }
            Participacion part1 = partido.getSeleccion1();
            Participacion part2 = partido.getSeleccion2();
            if (part1 == null || part2 == null){
                continue;
            }

            Seleccion s1 = part1.getSeleccion();
            Seleccion s2 = part2.getSeleccion();
            if (s1 == null || s2 == null){
                continue;
            }

            //4. Ambas selecciones deben pertenecer a ese grupo
            if(this.selecciones.contains(s1)&&this.selecciones.contains(s2)){
                int golesS1 = part1.getCantidadGoles();
                int golesS2 = part2.getCantidadGoles();

                //busca en estadisticas la fila de s1 y le suma los goles
                Estadistica estS1 = buscarEstadistica(s1);
                if (estS1 != null){
                    estS1.computarPartido(golesS1,golesS2);
                }
                //busca en estadisticas la fila de s2 y le suma los goles
                Estadistica estS2 = buscarEstadistica(s2);
                if (estS2 != null){
                    estS2.computarPartido(golesS2, golesS1);
                }
            }

        }
    }
    //Método para que agarre la Seleccion, vaya a tablaEstadisticas, busque que fila le corresponde a esa
    //Seleccion y se la devuelva a actualizarTablaPosiciones() -el de arriba- para que ejecute el computo
    //del partido
    private Estadistica buscarEstadistica(Seleccion s){
        for (Estadistica est : this.tablaEstadisticas){
            if (est.getSeleccion().equals(s)){
                return est;
            }
        }
        return null;
    }
    
  
}

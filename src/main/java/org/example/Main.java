package org.example;
import java.util.*;

/**
 *
 * @author mardalorso
 */

public class Main {
    List<Pais> paises = new ArrayList<>();
    List<Sede> sedes = new ArrayList<>();
    List<Estadio> estadios = new ArrayList<>();
    List<Arbitro> arbitros = new ArrayList<>();
    List<DirectorTecnico> dts = new ArrayList<>();
    List<CuerpoTecnico> cts = new ArrayList<>();
    List<Jugador> jugadores = new ArrayList<>();
    List<Fase> fases = new ArrayList<>();
    List<Grupo> grupos = new ArrayList<>();
    List<Seleccion> selecciones = new ArrayList<>();
    List<Partido> partidos = new ArrayList<>();

    public static void main(String[] args) {
      Main app = new Main();
      app.ejecutar(); 
    }  
    
    public void ejecutar(){
        
        /*creamos una instancia de Ingresomundial 
        para poder usar los metodos de esa clase*/
        IngresoMundial ingreso=new IngresoMundial();
        Mundial mundial = ingreso.ingresarMundial();
        
       /*creamos una instancia de menu pasando por parametros las listas
        para comenzar a crear los objetos y agregarlos a cada lista
        */
        Menu menu = new Menu(mundial,paises, sedes, estadios, arbitros, dts, cts, jugadores, fases, grupos, selecciones, partidos);
        
        /*llamamos al metodo para dar las opciones de menu
        pasando por parametro mundial creado si o si antes que todo
        */
        menu.Menu(mundial);
    }  
}      


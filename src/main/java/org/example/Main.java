package org.example;
import java.util.*;

/**
 * Clase ejecutable del programa.
 * Se encarga de guardar todas las listas del mundial 
 * y arrancar el sistema con el menú.
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
    Mundial mundial;
    
    /**
     * Punto de entrada obligatorio para que Java sepa dónde inicia la aplicación.
     * @param args Argumentos del sistema (no se usan en este proyecto).
     */
    public static void main(String[] args) {
      Main app = new Main();
      app.ejecutar(); 
    }  
    /**
     * Coordina el inicio de la aplicación, crea la configuración del mundial 
     * y despliega el menú interactivo para el usuario.
     */
    public void ejecutar(){
        //Programa prueba
        Mundial mundialPrueba = new Mundial(2026, "Mascota de prueba", 20260611, 20260719);
        PruebaSistemaMundial prueba = new PruebaSistemaMundial();
        prueba.ejecutarPruebas(mundialPrueba,paises, sedes, estadios, arbitros, dts, cts, jugadores, fases, grupos, selecciones, partidos);
        
        /*creamos una instancia de Ingresomundial 
        para poder usar los metodos de esa clase*/
        IngresoMundial ingreso=new IngresoMundial();
        mundial= ingreso.ingresarMundial();
        
       /*creamos una instancia de menu pasando por parametros las listas
        para comenzar a crear los objetos y agregarlos a cada lista
        */
        Menu menu = new Menu(mundial,paises, sedes, estadios, arbitros, dts, cts, jugadores, fases, grupos, selecciones, partidos);
        
        /*llamamos al metodo para dar las opciones de menu
        pasando por parametro mundial creado si o si antes que todo
        */
        menu.MostrarMenu();
    }  
}      


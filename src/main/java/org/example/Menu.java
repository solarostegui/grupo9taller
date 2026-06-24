/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.*;

/**
 * Clase encargada de gestionar la interfaz de usuario por consola
 * para el sistema de gestion del Mundial.
 * Coordina el flujo completo de la aplicación, interactua con el  ingreso
 * de datos, permite registrar eventos en tiempo real y emitir reportes e informes solicitados.
 * @author Antonella Monti, María del Mar Dalorso.
 * @version 1.0
 */

public class Menu{
    /**
     * Objeto central que guarda los datos generales del torneo.
     */
    private Mundial mundial;
    /**
     * Colección global de los paises registrados en el sistema.
     */
    private List<Pais> paises;
    /**
     * Colección global de sedes asignadas para los encuentros.
     */
    private List<Sede> sedes;
    /**
     * Colección global de estadios donde se jugaran los partidos.
     */
    private List<Estadio> estadios;
    /**
     * Colección de arbitros habilitados para dirigir los partidos.
     */
    private List<Arbitro> arbitros;
    /**
     * Colección de directores técnicos a cargo de las selecciones.
     */
    private List<DirectorTecnico> dts;
    /**
     * Colección de integrantes del cuerpo técnico y medicos de los equipos. 
     */
    private List<CuerpoTecnico> cts;
    /**
     * Colección global de jugadores inscriptos en el torneo.
     */
    private List<Jugador> jugadores;
    /**
     * Colección de las fases del torneo.
     */
    private List<Fase> fases;
    /**
     * Colección de los grupos que componen la primera instancia del tornoe.
     */
    private List<Grupo> grupos;
    /**
     * Colección de selecciones que compiten en el torneo.
     */
    private List<Seleccion> selecciones;
    /**
     * Colección de partidos programados del torneo.
     */
    private List<Partido> partidos;
    
    /**
     * Constructor parametrizado para crear el menú cargando el objeto principal Mundial y todas las listas de datos requeridas para permitir
     * consultarlas, modificarlas y asegurar que los cambios se mantengan guardados en memoria. 
     * @param mundial objeto centtral {@link Mundial}.
     * @param paises Lista de objetos de tipo {@link Pais}.
     * @param sedes Lista de objetos de tipo {@link Sede}.
     * @param estadios Lista de objetos de tipo {@link Estadio}.
     * @param arbitros Lista de árbitros de tipo {@link Arbitro}.
     * @param dts Lista de directores técnicos de tipo {@link DirectorTecnico}.
     * @param cts Lista de integrantes del cuerpo técnico de tipo {@link CuerpoTecnico}.
     * @param jugadores Lista de futbolistas de tipo {@link Jugador}.
     * @param fases Lista de las instancias del torneo de tipo {@link Fase}.
     * @param grupos Lista de zonas de tipo {@link Grupo}.
     * @param selecciones Lista de combinados nacionales de tipo {@link Seleccion}.
     * @param partidos Lista de los encuentros pautados de tipo {@link Partido}.
     */

    public Menu(Mundial mundial,List<Pais> paises, List<Sede> sedes, List<Estadio> estadios, List<Arbitro> arbitros, List<DirectorTecnico> dts, List<CuerpoTecnico> cts, List<Jugador> jugadores, List<Fase> fases, List<Grupo> grupos, List<Seleccion> selecciones, List<Partido> partidos) {
        this.mundial = mundial;
        this.paises = paises;
        this.sedes = sedes;
        this.estadios = estadios;
        this.arbitros = arbitros;
        this.dts = dts;
        this.cts = cts;
        this.jugadores = jugadores;
        this.fases = fases;
        this.grupos = grupos;
        this.selecciones = selecciones;
        this.partidos = partidos;
    }
    
    /**
     * Ejecuta el bucle principal de control por consola de la interfaz de usuario.
     * Muestra las opciones en pantalla y divide el flujo lógico mediante un bloque {@code switch}
     * para coordinar las operaciones de carga de datos y muestra de informes.
     * Finaliza la ejecución cuando el usuario ingresa la opción {@code 0}.
     */
    
    public void MostrarMenu(){
        Reporte reporte=new Reporte();
        IngresoMundial Ingreso=new IngresoMundial();
        int opcion;
        do {
            System.out.println("\n========== MENÚ MUNDIAL ==========");
            System.out.println("1. Ingresar País");
            System.out.println("2. Ingresar Sede y Estadio");
            System.out.println("3. Ingresar Arbitro");
            System.out.println("4. Ingresar Direcor Tecnico");
            System.out.println("5. Ingresar Cuerpo Tecnico");
            System.out.println("6. Crear Fases");
            System.out.println("7. Ingresar Grupos");
            System.out.println("8. Ingresar Jugador");
            System.out.println("9. Ingresar Selección");
            System.out.println("10. Ingresar Partido");
            System.out.println("11. Ficha Técnica del Partido");
            System.out.println("12. Tabla de posiciones");
            System.out.println("13. Resultados de una Selección");
            System.out.println("14. Ranking de Goleadores");
            System.out.println("15. Informe Disciplinario");
            System.out.println("16. Estadísticas por Sede ");
            System.out.println("17. Registrar eventos de un partido");
            System.out.println("0. Salir");
            opcion = IngresoMundial.pedirEnteroRango("Seleccione una opción: ",0,17);
            
            switch (opcion){
                case 1:
                   Ingreso.crearPais(paises);
                   break;
                case 2:
                    Ingreso.crearSede(paises, sedes, estadios,mundial);
                    break;
                case 3:
                    Ingreso.crearArbitro(paises, arbitros);
                    break;
                case 4:
                    Ingreso.crearDT(dts);
                    break;
                case 5:
                    Ingreso.crearCT(cts);
                    break;
                case 6:
                    Ingreso.crearFase(fases);
                    break;
                case 7:
                    Ingreso.crearGrupo(fases, grupos);
                    break;
                case 8:
                    Ingreso.crearJugador(jugadores);
                    break;
                case 9:
                    Ingreso.crearSeleccion(grupos, paises, dts, cts, jugadores, selecciones);
                    break;
                case 10:
                    Ingreso.crearPartido(selecciones, estadios, fases, arbitros, partidos, jugadores);
                    break;
                case 11:
                    System.out.println("Seleccione el partido para mostrar la ficha: ");
                    Partido p=Ingreso.seleccionarPartido(partidos);
                    reporte.mostrarFichaTecnica(p);
                    break;
                case 12:
                    System.out.println("Seleccione el grupo para mostrar la tabla: ");
                    Grupo g=Ingreso.seleccionarGrupo(grupos);
                    reporte.mostrarTablaPosiciones(g,partidos);
                    break;
                case 13:
                   System.out.println("Seleccione la seleccion para mostrar los resultados: ");
                   Seleccion s=Ingreso.seleccionarSeleccion(selecciones);
                   reporte.mostrarResultadosSeleccion(s,partidos);
                    break;
                case 14:
                    reporte.mostrarRankingGoleadores(partidos);
                    break;
                case 15:
                    reporte.mostrarInformeDisciplinario(partidos);
                    break;
                case 16:
                    System.out.println("Que desea consultar?");
                    System.out.println("1. Sede");
                    System.out.println("2. Estadio");
                    int opcionSede = IngresoMundial.pedirEnteroRango("Seleccione: ",1,2);
                    if(opcionSede == 1){
                        Sede sede = Ingreso.seleccionarSede(sedes);
                        reporte.mostrarEstadisticasSedes(sede);
                    } else {
                        Estadio estadio = Ingreso.seleccionarEstadio(estadios);
                        reporte.mostrarEstadisticasEstadio(estadio);
                    }
                    break;
                case 17:
                    Ingreso.registrarEventosPartido(partidos, jugadores);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción Invalida.");
            }
        } while (opcion != 0);
    }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.*;

/**
 *
 * @author mardalorso
 */

public class Menu{
    private Mundial mundial;
    private List<Pais> paises;
    private List<Sede> sedes;
    private List<Estadio> estadios;
    private List<Arbitro> arbitros;
    private List<DirectorTecnico> dts;
    private List<CuerpoTecnico> cts;
    private List<Jugador> jugadores;
    private List<Fase> fases;
    private List<Grupo> grupos;
    private List<Seleccion> selecciones;
    private List<Partido> partidos;

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
            System.out.println("0. Salir");
            opcion = IngresoMundial.pedirEnteroRango("Seleccione una opción: ",0,16);
            
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
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción Invalida.");
            }
        } while (opcion != 0);
    }    
}

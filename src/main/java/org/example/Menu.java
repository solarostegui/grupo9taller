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

    public Menu(List<Pais> paises, List<Sede> sedes, List<Estadio> estadios, List<Arbitro> arbitros, List<DirectorTecnico> dts, List<CuerpoTecnico> cts, List<Jugador> jugadores, List<Fase> fases, List<Grupo> grupos, List<Seleccion> selecciones, List<Partido> partidos) {
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
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void Menu(Mundial mundial){
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
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                   IngresoMundial.crearPais(List <paises>);
                   System.out.println("País ingresado.");
                   break;
                case 2:
                    IngresoMundial.crearSede();
                    System.out.println("Sede ingresada.");
                    break;
                case 3:
                    IngresoMundial.crearArbitro();
                    System.out.println("Arbitro ingresado.");
                    break;
                case 4:
                    IngresoMundial.crearDT();
                    System.out.println("Director Tecnico ingresado.");
                    break;
                case 5:
                    IngresoMundial.crearCT();
                    System.out.println("Cuerpo tecnico ingresado.");
                    break;
                case 6:
                    IngresoMundial.crearFase();
                    System.out.println("Fase creada.");
                    break;
                case 7:
                    IngresoMundial.crearGrupo();
                    System.out.println("Grupo creado.");
                case 8:
                    IngresoMundial.crearJugador();
                    System.out.println("Jugador ingresado.");
                    break;
                case 9:
                    IngresoMundial.crearSeleccion();
                    System.out.println("Seleccion ingresado.");
                    break;
                case 10:
                    IngresoMundial.crearPartido();
                    System.out.println("Partido creado.");
                    break;
                case 11:
                    //Reportes.
                    break;
                case 12:
                    //Reportes.mostrarTablaPosiciones(grupo);
                    break;
                case 13:
                    //Reportes
                    break;
                case 14:
                    //Reportes
                    break;
                case 15:
                    //Reportes
                    break;
                case 16:
                    //Reportes
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                default:
                    System.out.println("Opción Invalida.");
            }
        } while (opcion != 0);
    }    
}

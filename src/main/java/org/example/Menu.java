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
 
    private static Scanner sc = new Scanner(System.in);
 
    public static void Menu(){
        int opcion;
        do {
            System.out.println("\n========== MENÚ MUNDIAL ==========");
            System.out.println("1. Ingresar País");
            System.out.println("2. Ingresar Sede");
            System.out.println("3. Ingresar Estadio");
            System.out.println("4. Ingresar Partido");
            System.out.println("5. Ingresar Grupo");
            System.out.println("6. Ingresar Selección");
            System.out.println("7. Ingresar Director Técnico y Cuerpo Técnico");
            System.out.println("8. Ingresar Arbitro para el Partido");
            System.out.println("9. Ingresar Arbitraje");
            System.out.println("10. Ingresar Fase");
            System.out.println("11. Ingresar Participación");
            System.out.println("12. Ingresar Jugador");
            System.out.println("13. Ingresar Evento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                    IngresoMundial.ingresarPais();
                    System.out.println("País ingresado.");
                    break;
                case 2:
                    IngresoMundial.ingresarSede();
                    System.out.println("Sede ingresada.");
                    break;
                case 3:
                    IngresoMundial.ingresarEstadio(sede);
                    System.out.println("Sede ingresada.");
                    break;
                case 4:
                    IngresoMundial.ingresarPartido(estadio, fase);
                    System.out.println("Estadio ingresado.");
                    break;
                case 5:
                    IngresoMundial.ingresarGrupo(fase);
                    System.out.println("Partido ingresado.");
                    break;
                case 6:
                    IngresoMundial.ingresarSeleccion(grupo, pais);
                    System.out.println("Grupo ingresado.");
                    break;
                case 7:
                    IngresoMundial.ingresarDirectorTecnico();
                    System.out.println("Director Técnico ingresado.");
                    IngresoMundial.ingresarCuerpoTecnico();
                    System.out.println("Cuepo Técnico ingresado.");
                    break;
                case 8:
                    IngresoMundial.ingresarArbitro(pais, partido);
                    System.out.println("Arbritro del partido ingresado.");
                    break;
                case 9:
                    IngresoMundial.ingresarArbitraje(arbitro, partido);
                    System.out.println("Arbitraje ingresado.");
                    break;
                case 10:
                    IngresoMundial.ingresarParticipacion(partido, seleccion);
                    System.out.println("Participación ingresado.");
                    break;
                case 11:
                    IngresoMundial.ingresarJugador();
                    System.out.println("Jugador ingresado.");
                    break;
                case 12:
                    IngresoMundial.ingresarEvento(j);
                    System.out.println("Evento ingresado.");
                case 0:
                    System.out.println("Saliendo del programa...");
                default:
                    System.out.println("Opción Invalida.");
            }
        } while (opcion != 0);
    }    
}
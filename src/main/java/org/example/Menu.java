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
        int opcion=-1;
        while (opcion != 0) {
            System.out.println("\n========== MENÚ MUNDIAL ==========");
            System.out.println("1. Ingresar Mundial");
            System.out.println("2. Ingresar País y Sedes");
            System.out.println("3. Ingresar Fase y Grupos");
            System.out.println("4. Ingresar Selecciones (jugadores, DT, cuerpo técnico)");
            System.out.println("5. Ingresar Árbitros");
            System.out.println("6. Ingresar Partidos");
            System.out.println("7. Ingresar Eventos de un Partido");
            System.out.println("8. Ingresar Arbitrajes de un Partido");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
           //excepcion si no se ingresa el numero esperado
           try {
               opcion = sc.nextInt();
               sc.nextLine();
               if (opcion < 0 || opcion > 8) {
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException e) {
                System.out.println("La opción debe ser un número entero ");
                sc.nextLine();
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("La opción debe estar entre 0 y 8 ");
                continue;
            }
        }
        switch (opcion){
            case 1:
                Mundial mundial=IngresoMundial.ingresarMundial();
                System.out.println("Mundial ingresado.");
                break;
            case 2:
                 Sede sedes=ingresarSede();
                for(Sede sede:sedes){
                     ingresarPais();
                }
                break;
            case 3:
                 ingresarFase();
                 for()
                 break;
        }
    }
    
    
}
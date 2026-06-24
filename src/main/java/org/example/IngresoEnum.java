/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 * Clase que gestiona el ingreso de valores enum por teclado.
 * @author María del Mar Dalroso, Monti Antonella.
 * @version 1.0
 */
public class IngresoEnum {
    /**
     * Muestra por consola las posiciones de juego del equipo y solicita al usuario que seleccione
     * una dentro del rango permitido.
     * @return El valor de {@link TipoPosicion} que corresponde a la opción seleccionada.
     */
    public static TipoPosicion elegirTipoPosicion() {
        
        System.out.println("\n-- Posiciones disponibles --");
        System.out.println("0 - Arquero");
        System.out.println("1 - Defensor");
        System.out.println("2 - Mediocampista");
        System.out.println("3 - Delantero");
        int opcion = IngresoMundial.pedirEnteroRango("Elija la posicion: ",0,3);
        /*TipoPosicion.values() devuelve :
        [ARQUERO, DEFENSOR, MEDIOCAMPISTA, DELANTERO]
        [opcion] elije segun el numero ingresado en ese array*/
        return TipoPosicion.values()[opcion];
    }
    /**
     * Muestra en consola los roles para el cuerpo técnico y médico,
     * y solicita al usuario que seleccione uno dentro del rango permitido.
     * @return El valor de {@link TipoRol} que corresponde a la opción seleccionada. 
     */
    public static TipoRol elegirTipoRol() {
        
        System.out.println("\n-- Roles disponibles --");
        System.out.println("0 - AyudanteCampo");
        System.out.println("1 - PreparadorFisico");
        System.out.println("2 - Medico");
        System.out.println("3 - Kinesiologo");
        System.out.println("4 - EntrenadorArqueros");
        System.out.println("5 - AnalistaVideos");
        System.out.println("6 - Nutricionista");
        System.out.println("7 - Psicologo");
        int opcion = IngresoMundial.pedirEnteroRango("Seleccione rol: ", 0, 7);
        return TipoRol.values()[opcion];
    }
    
    /**
     * Muestra en consola los tipos de eventos que pueden ocurrir durante un partido
     * y solicita al usuario que seleccione uno dentro del rango permitido.
     * @return El valor de {@link TipoEvento} que corresponde a la opción seleccionada.
     */ 
    public static TipoEvento elegirTipoEvento() {
        
        System.out.println("\n-- Tipos de evento disponibles --");
        System.out.println("0 - Gol");
        System.out.println("1 - TarjetaAmarilla");
        System.out.println("2 - TarjetaRoja");
        System.out.println("3 - PenalCometido");
        System.out.println("4 - PenalConvertido");
        System.out.println("5 - PenalErrado");
        System.out.println("6 - DobleAmarilla");
        System.out.println("7 - Sustitucion");
        System.out.println("8 - Lesion");
        int opcion = IngresoMundial.pedirEnteroRango("Elija el evento: ",0,8);
        return TipoEvento.values()[opcion];
    }
    /**
     * Muestra en consola las fases del torneo mundial disponibles
     * y solicita al usuario que seleccione una dentro del rango permitido.
     * @return El valor de {@link TipoNombreFase} que corresponde a la opción seleccionada.
     */
    public static TipoNombreFase elegirTipoNombreFase() {
        
        System.out.println("\n-- Fases disponibles --");
        System.out.println("0 - Grupos");
        System.out.println("1 - Dieciseisavos");
        System.out.println("2 - Octavos");
        System.out.println("3 - Cuartos");
        System.out.println("4 - Semifinal");
        System.out.println("5 - Final");
        int opcion = IngresoMundial.pedirEnteroRango("Elija la fase: ",0,5);
        return TipoNombreFase.values()[opcion];
    }
    
    /**
     * Muestra en consola los roles arbitrales disponibles para un partido
     * y solicita al usuario que seleccione una dentro del rango permitido.
     * @return El valor de {@link TipoCategoriaArbitro} que corresponde a la opción seleccionada.
     */
    
    public static TipoCategoriaArbitro elegirTipoCategoriaArbitro() {
        
        System.out.println("\n-- Categorías de árbitro disponibles --");
        System.out.println("0 - Principal");
        System.out.println("1 - Asistente1");
        System.out.println("2 - Asistente2");
        System.out.println("3 - CuartoArbitro");
        System.out.println("4 - VarPrincipal");
        System.out.println("5 - VarAsistente");
        int opcion = IngresoMundial.pedirEnteroRango("Elija la categoria: ",0,5);
        return TipoCategoriaArbitro.values()[opcion];
    }
}

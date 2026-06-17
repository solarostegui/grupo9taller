/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author mardalorso
 */
public class IngresoEnum {
    public static TipoPosicion elegirTipoPosicion() {
        System.out.println("\n-- Posiciones disponibles --");
        System.out.println("0 - Arquero");
        System.out.println("1 - Defensor");
        System.out.println("2 - Mediocampista");
        System.out.println("3 - Delantero");
        System.out.println("Seleccione posicion: ");
        int opcion = IngresoMundial.pedirEnteroRango("Elija la posicion: ",0,3);
        return TipoPosicion.values()[opcion];
    }
 
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
        System.out.println("Seleccione rol: ");
        int opcion = IngresoMundial.pedirEnteroRango("Seleccione rol: ", 0, 7);
        return TipoRol.values()[opcion];
    }
 
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
        System.out.println("Seleccione evento: ");
        int opcion = IngresoMundial.pedirEnteroRango("Elija el evento: ",0,8);
        return TipoEvento.values()[opcion];
    }
 
    public static TipoNombreFase elegirTipoNombreFase() {
        System.out.println("\n-- Fases disponibles --");
        System.out.println("0 - Grupos");
        System.out.println("1 - Dieciseisavos");
        System.out.println("2 - Octavos");
        System.out.println("3 - Cuartos");
        System.out.println("4 - Semifinal");
        System.out.println("5 - Final");
        System.out.println("Seleccione fase: ");
        int opcion = IngresoMundial.pedirEnteroRango("Elija la fase: ",0,5);
        return TipoNombreFase.values()[opcion];
    }
 
    public static TipoCategoriaArbitro elegirTipoCategoriaArbitro() {
        System.out.println("\n-- Categorías de árbitro disponibles --");
        System.out.println("0 - Principal");
        System.out.println("1 - Asistente1");
        System.out.println("2 - Asistente2");
        System.out.println("3 - CuartoArbitro");
        System.out.println("4 - VarPrincipal");
        System.out.println("5 - VarAsistente");
        System.out.println("Seleccione categoría: ");
        int opcion = IngresoMundial.pedirEnteroRango("Elija la categoria: ",0,5);
        return TipoCategoriaArbitro.values()[opcion];
    }
}

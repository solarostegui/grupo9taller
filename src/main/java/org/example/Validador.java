package org.example;
import java.util.*;
/**
 * Clase para controlar las validaciones solicitadas en el trabajo.
 * @author Antonella Monti, María del Mar Dalorso, María Sol Arostegui
 * @version 1.0
 */
public class Validador {
    /**
     * Revisa que la lista de árbitros asignada a un partido esté completa con todos 
     * los roles obligatorios.
     * También verifica que la lista no esté vacía ni tenga datos nulos.
     * @param arbitrajes La lista de objetos {@link Arbitraje} que se desea controlar.
     * @return {@code true} si el equipo está completo y es válido, o {@code false} si falta algún rol o la lista está vacía.
     */
    public static boolean validarArbitraje(List <Arbitraje> arbitrajes){
        //La lista tiene que tener algo para que sea válida. Empty es lo mismo que arbitraje.size() == 0 (lista vacia)
        if (arbitrajes == null || arbitrajes.isEmpty()){ //Si usamos una excepcion tipo NullPointerException corremos el riesgo de que se craashee el código
            return false;
        }
        boolean tienePrincipal = false;
        boolean tieneAsistente1 = false;
        boolean tieneAsistente2 = false;
        boolean tieneCuartoArbitro = false;
        boolean tieneVarPrincipal = false;
        boolean tieneVarAsistente = false;

        
        for (Arbitraje arb : arbitrajes){
            //Esto es para que un elemento nulo no nos complique
            if (arb == null || arb.getRol()==null){
                return false;
            }
            switch (arb.getRol()) {
                case Principal:
                    tienePrincipal = true;
                    break;
                case Asistente1:
                    tieneAsistente1 = true;
                    break;
                case Asistente2:
                    tieneAsistente2 = true;
                    break;
                case CuartoArbitro:
                    tieneCuartoArbitro = true;
                    break;
                case VarPrincipal:
                    tieneVarPrincipal = true;
                    break;
                case VarAsistente:
                    tieneVarAsistente = true;
                    break;
                default:
                    break;
            }
        }
        //Si se cumplen las condiciones es verdadero
        return tienePrincipal && tieneAsistente1 && tieneAsistente2 && tieneCuartoArbitro && tieneVarPrincipal && tieneVarAsistente;
    }

    /**
     * Verifica si un jugador realmente pertenece a alguna de las dos selecciones que están disputando el encuentro.
     * Se llama antes de registrar eventos (como goles o tarjetas) en un partido.
     * @param p El {@link Partido} donde ocurre la jugada a registrar.
     * @param j El {@link Jugador} que se busca validar.
     * @return {@code true} si el jugador está jugando para alguna de las dos selecciones, o {@code false} si es nulo o pertenece a un equipo ajeno.
     */
    
    public static boolean validarEvento(Partido p, Jugador j){
        if (p == null || j == null){
            return false;
        }
        /*Obtenemos la participacion de cada seleccion 
        desde el partido*/
        Participacion part1 = p.getSeleccion1();
        Participacion part2 = p.getSeleccion2();
        if (part1 == null || part2 == null){
            return false;
        }
        //Obtenemos cual es la Seleccion de cada participacion
        Seleccion seleccion1 = part1.getSeleccion();
        Seleccion seleccion2 = part2.getSeleccion();
        
        //Uso el get de mi lista "jugador" en Seleccion
        if(seleccion1 != null && seleccion1.getJugador()!=null){
            if(seleccion1.getJugador().contains(j)) {
                return true; //Evita anidar bucles o que se repitan datos
            }
        }
        if(seleccion2!=null&& seleccion2.getJugador()!=null){
            if (seleccion2.getJugador().contains(j)) {
                return true;
            }
        }
        return false;
    }
    
    
}
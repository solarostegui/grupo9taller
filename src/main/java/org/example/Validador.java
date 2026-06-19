package org.example;
import java.util.*;
/**
 Clase para controlar las validaciones solicitadas en el trabajo
 */
public class Validador {
    //Valida si el equipo de arbitraje está completo y es válido
  
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

        //Recorre lista
        for (Arbitraje arb : arbitrajes){
            //Esto es para que un elemento nulo no nos complique
            if (arb == null || arb.getRol()==null){
                return false;
            }
            //Validamos usando nombres del enum TipoCategoriaArbitro
            if (arb.getRol() == TipoCategoriaArbitro.Principal){
                tienePrincipal = true;
            }else if(arb.getRol()== TipoCategoriaArbitro.Asistente1){
                tieneAsistente1 = true;
            }else if (arb.getRol() == TipoCategoriaArbitro.Asistente2){
                tieneAsistente2 = true;
            }else if (arb.getRol() == TipoCategoriaArbitro.CuartoArbitro){
                tieneCuartoArbitro = true;
            }else if (arb.getRol() == TipoCategoriaArbitro.VarPrincipal){
                tieneVarPrincipal = true;
            }else if (arb.getRol() == TipoCategoriaArbitro.VarAsistente){
                tieneVarAsistente = true;
            }
        }
        //Si se cumplen las condiciones es verdadero
        return tienePrincipal && tieneAsistente1 && tieneAsistente2 && tieneCuartoArbitro && tieneVarPrincipal && tieneVarAsistente;
    }

    /*Valida si un jugador pertenece a cualquiera de las dos selecciones 
    que están jugando (es algo más exterior al helper de participacion)
    necesitamos partido, jugadores de participacion (usamos get y set de participacion)*/
    public static boolean validarEvento(Partido p, Jugador j){
        if (p == null || j == null){
            return false;
        }
        /*Obtenemos la participacion de cada seleccion 
        desde el partido pasado por parametro*/
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
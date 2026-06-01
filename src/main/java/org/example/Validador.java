
package org.example;
import java.util.*;
/**
 Clase para controlar las validaciones solicitadas en el trabajo
 */
public class Validador {
    //Valida si el equipo de arbitraje está completo y es válido
    //necesitamos get y set de partido para entrar a la lista de arbitros de ese partido
    public static boolean validarArbitraje(List <Arbitraje> arbitrajes){
        //La lista tiene que tener algo para que sea válida. Empty es lo mismo que arbitraje.size() == 0 (lista vacia)
        if (arbitrajes == null || arbitrajes.isEmpty()){
            return false;
        }
        boolean tienePrincipal = false;
        boolean tieneAsistente1 = false;
        boolean tieneAsistente2 = false;

        //Recorre lista
        for (Arbitraje arb : arbitrajes){
            //Esto es para que un elemento nulo no nos complique
            if (arb == null || arb.getRol()==null){
                continue;
            }
            //Validamos usando nombres del enum TipoCategoriaArbitro
            if (arb.getRol() == TipoCategoriaArbitro.Principal){
                tienePrincipal = true;
            }else if(arb.getRol()== TipoCategoriaArbitro.Asistente1){
                tieneAsistente1 = true;
            }else if (arb.getRol() == TipoCategoriaArbitro.Asistente2){
                tieneAsistente2 = true;
            }
        }
        //Si se cumplen las condiciones es verdadero
        return tienePrincipal && tieneAsistente1 && tieneAsistente2;
    }

    //Valida si un jugador pertenece a cualquiera de las dos selecciones que están jugando
    //necesitamos partido, jugadores de participacion (usamos get y ses de participacion)
    public static boolean validarEvento(Partido p, Jugador j){
        if (p == null || j == null){
            return false;
        }
        //Obtenemos clases asociación "Participación" desde partido
        Participacion part1 = p.getSeleccion1();
        Participacion part2 = p.getSeleccion2();
        if (part1 == null || part2 == null){
            return false;
        }
        //Obtenemos la Seleccion de cada participacion
        Seleccion local = part1.getSeleccion();
        Seleccion visitante = part2.getSeleccion();
        boolean estaEnLocal = false;
        //Uso el get de mi lista "jugador" en Seleccion
        if(local != null && local.getJugador()!=null){
            estaEnLocal = local.getJugador().contains(j);
        }
        boolean estaEnVisitante = false;
        if(visitante!=null&&visitante.getJugador()!=null){
            estaEnVisitante=visitante.getJugador().contains(j);
        }
        return estaEnLocal || estaEnVisitante;
    }
    
}

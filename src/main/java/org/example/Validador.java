
package org.example;
import java.util.*;
/**
 Clase para controlas las validaciones solicitadas en el trabajo
 */
public class Validador {
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
    
    //necesitamos partido, jugadores de participacion (usamos get y ses de participacion)
    public static void validarEvento(Partido p, Jugador j){
        
    }
    
}

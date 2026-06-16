package org.example;
//todos los métodos van a ser estáticos y recibir los datos que necesiten
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Objects;

public class Reportes {
    //TABLA DE POSICIONES POR GRUPO
    public static void mostrarTablaPosiciones(Grupo grupo){
        //Impresion de los encabezados
        grupo.actualizarTablaPosiciones();
        System.out.println("===== TABLA DE POSICIONES - Grupo "+grupo.getIdentificacion()+" =====");
        System.out.printf("%-20s %3s %3s %3s %3s %3s %3s %4s %4s%n","Seleccion", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "PTS"); //printf para imprimir 10 argumentos
        System.out.println("-".repeat(55));

        //Creamos una lista local para ordenar de forma segura
        List<Estadisticas> listaEstadisticas = new ArrayList<>(grupo.getTablaEstadisticas());

        //La ordenamos usando los criterios FIFA
        listaEstadisticas.sort((est1,est2) ->{
            //si las estadisticas son nulas las mandamos al final
            if(est1 == null){return 1;}
            if(est2 == null){return -1;}

            //Criterio 1: puntos de mayor a menor
            int comparacionPuntos = Integer.compare(est2.getPuntos(), est1.getPuntos());
            if(comparacionPuntos != 0){
                return comparacionPuntos;
            }
            //Criterio 2: dif goles de mayor a menor
            int comparacionDiferencia = Integer.compare(est2.getDiferenciaGoles(), est1.getDiferenciaGoles());
            if(comparacionDiferencia!=0){
                return comparacionDiferencia;
            }
            //Criterio 3: goles a favor de mayor a menor
            return Integer.compare(est2.getGolesAFavor(), est1.getGolesAFavor());

        });
        //Bucle para imprimir la lista fila x fila
        for(Estadisticas est: listaEstadisticas){
            if(est!=null){
                System.out.printf("%-20s %3d %3d %3d %3d %3d %3d %4d %4d%n",
                        est.getSeleccion().getNombreFederacion(),
                        est.getPartidosJugados(),
                        est.getPartidosGanados(),
                        est.getPartidosEmpatados(),
                        est.getPartidosPerdidos(),
                        est.getGolesAFavor(),
                        est.getGolesEnContra(),
                        est.getDiferenciaGoles(),
                        est.getPuntos());
            }
        }

    }
}

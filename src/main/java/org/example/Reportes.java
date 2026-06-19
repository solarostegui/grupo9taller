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
    //PUNTOS POR SELECCIÓN (VER SI ESTÁ BIEN)
    public static int obtenerPuntosSeleccion(Grupo grupo, Seleccion seleccionBuscada) {
        // guardar el resultado del Stream en una variable local para poder imprimirla
        int puntos = grupo.getTablaEstadisticas().stream()
                .filter(Objects::nonNull)
                .filter(est -> est.getSeleccion().equals(seleccionBuscada))
                .mapToInt(Estadisticas::getPuntos)
                .findFirst()
                .orElse(0);

        System.out.println("La selección tiene " + puntos + " puntos.");
        return puntos;
    }
    //RANKING GOLEADORES
    public static void mostrarRankingGoleadores(List<Partido>partidos){
        //RANKING DE GOLEADORES
        System.out.println("===== RANKING DE GOLEADORES =====");
        System.out.printf("%-20s %6s %6s%n", "Jugador", "Dorsal", "Goles");
        System.out.println("-".repeat(35));
        //Control inicial
        if (partidos == null || partidos.isEmpty()){
            System.out.println("No hay goles registrados.");
            return;
        }
        //Clase auxiliar para unir un jugador con su contador de goles
        class GoleadorAux{
            Jugador jugador;
            int goles;
            GoleadorAux(Jugador jugador, int goles){
                this.jugador=jugador;
                this.goles=goles;
            }
        }
        //Lista para los auxiliares
        List<GoleadorAux>listaGoleadores = new ArrayList<>();
        //Bucle para recorrer los partidos
        for(Partido p : partidos){
            if (p!=null && p.getEventos() != null){
                for (Evento e : p.getEventos()){
                    if (e!=null && e.getEvento()==TipoEvento.Gol && e.getJugador()!= null){ //Verifica que sea gol y que esté asignado a un jugador
                        Jugador jugadorActual = e.getJugador();
                        if(Validador.validarEvento(p, jugadorActual)){ //Buscamos si el jugador está en la lista
                            //Si no está
                            GoleadorAux encontrado = null;
                            for (GoleadorAux g : listaGoleadores){
                                if(g.jugador.getDorsal() == jugadorActual.getDorsal()&& g.jugador.getNombre().equalsIgnoreCase(jugadorActual.getNombre())){
                                    encontrado = g;
                                    break;
                                }
                            }
                            //Si está
                            if (encontrado != null){
                                encontrado.goles++;
                            }else{
                                listaGoleadores.add(new GoleadorAux(jugadorActual,1));
                            }

                        }
                    }
                }
            }
        }
        //Si no hay goles válidos
        if (listaGoleadores.isEmpty()){
            System.out.println("No hay goles registrados.");
            return;
        }
        //Ordenamiento mayor a menor FIFA
        listaGoleadores.sort((g1,g2)-> {
            if (g1 == null) {
                return 1;
            }
            if (g2 == null) {
                return -1;
            }
            return Integer.compare(g2.goles, g1.goles);
        });
        //Impresion en pantalla
        for (GoleadorAux g : listaGoleadores) {
            if (g != null && g.jugador != null) {
                System.out.printf("%-20s %6d %6d%n",
                        g.jugador.getNombre(),
                        g.jugador.getDorsal(),
                        g.goles);
            }
        }
    }
    //INFORME DISCIPLINARIO POR SELECCIÓN O JUGADOR
    public static void mostrarInformeDisciplinario(List<Partido>partidos){
        System.out.println("===== INFORME DISCIPLINARIO =====");
        System.out.printf("%-20s %6s %10s %6s%n", "Jugador", "Dorsal", "Amarillas", "Rojas");
        System.out.println("-".repeat(45));
        //Control inicial para ver que la lista no esté vacía o nula
        if(partidos == null || partidos.isEmpty()){
            System.out.println("No hay eventos disciplinarios registrados.");
            return;
        }
        //Auxiliar local
        class Sancionado{
            Jugador jugador;
            int amarillas;
            int rojas;
            Sancionado(Jugador jugador){
                this.jugador=jugador;
                this.amarillas=0;
                this.rojas=0;
            }
        }
        //Lista registros disciplinarios
        List<Sancionado>listaSancionados = new ArrayList<>();
        //Recorremos los partidos uno x uno
        for(Partido p:partidos){
            if(p!= null && p.getEventos() != null){
                for(Evento e : p.getEventos()){
                    if(e != null && e.getEvento()!=null){
                        TipoEvento tipo = e.getEvento();
                        //Si el evento es tarjeta
                        if(tipo==TipoEvento.TarjetaAmarilla || tipo == TipoEvento.TarjetaRoja || tipo == TipoEvento.DobleAmarilla){
                            Jugador jugadorActual = e.getJugador();
                            if(Validador.validarEvento(p, jugadorActual)){
                                Sancionado encontrado = null;
                                for(Sancionado s: listaSancionados){
                                    if(s.jugador.getDorsal() == jugadorActual.getDorsal()&& s.jugador.getNombre().equalsIgnoreCase((jugadorActual.getNombre()))){
                                        encontrado=s;
                                        break;
                                    }
                                }
                                //Si lista de sancionados no existe la creamos
                                if(encontrado == null){
                                    encontrado = new Sancionado(jugadorActual);
                                    listaSancionados.add(encontrado);
                                }
                                //Evaluamos el tipo de tarjeta para incrementar el contador correspondiente
                                if(tipo==TipoEvento.TarjetaAmarilla){
                                    encontrado.amarillas++;
                                }else if(tipo==TipoEvento.TarjetaRoja){
                                    encontrado.rojas++;
                                }else if(tipo==TipoEvento.DobleAmarilla){
                                    encontrado.rojas++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(listaSancionados.isEmpty()){
            System.out.println("No hay eventos disciplinarios registrados.");
            return;
        }
        //Ordenar alfabéticamente los nombres de los jugadores
        listaSancionados.sort((s1,s2)->{
            if(s1 == null || s1.jugador == null){
                return 1;
            }
            if(s2 == null || s2.jugador==null){
                return -1;
            }
            //Comparamos strings
            return s1.jugador.getNombre().compareToIgnoreCase(s2.jugador.getNombre());
        });
        for (Sancionado s : listaSancionados) {
            if (s != null && s.jugador != null) {
                System.out.printf("%-20s %6d %10d %6d%n",
                        s.jugador.getNombre(),
                        s.jugador.getDorsal(),
                        s.amarillas,
                        s.rojas);
            }
        }
    }
    //FICHA TÉCNICA
    public static void mostrarFichaTecnica(Partido p) {
        System.out.println("===== FICHA TÉCNICA DEL PARTIDO =====");
        if (p == null) {
            System.out.println("Partido no válido.");
            return;
        }

        // Datos grales. del encuentro
        System.out.println("Fecha: " + p.getFecha() + " | Horario: " + p.getHorario());
        System.out.println("Estadio: " + (p.getEstadio() != null ? p.getEstadio().getNombre() : "N/A"));
        System.out.println("Fase: " + (p.getFase() != null ? p.getFase().getNombreFase() : "N/A"));
        System.out.println("Duración: " + p.getDuracion() + " min | Tiempo adicional: " + p.getTiempoadicional() + " min");

        Participacion p1 = p.getSeleccion1();
        Participacion p2 = p.getSeleccion2();

        //resultado final
        if (p1 != null && p2 != null) {
            System.out.println("--- Resultado Final ---");
            System.out.println("RESULTADO: " + p1.getSeleccion().getNombreFederacion() +
                    " " + p1.getCantidadGoles() +
                    " - " + p2.getCantidadGoles() + " " +
                    p2.getSeleccion().getNombreFederacion());
        }

        //Alineaciones (revisar)
        System.out.println("--- Alineaciones ---");
        if (p1 != null && p1.getSeleccion() != null && p1.getSeleccion().getJugador() != null) {
            System.out.println(">> " + p1.getSeleccion().getNombreFederacion() + ":");
            p1.getSeleccion().getJugador().forEach(j ->
                    System.out.printf("   N° %-3d | %-15s | %s%n",
                            j.getDorsal(), j.getPosicion(), j.getNombre())
            );
        } else {
            System.out.println(" Sin jugadores registrados para el equipo 1.");
        }

        if (p2 != null && p2.getSeleccion() != null && p2.getSeleccion().getJugador() != null) {
            System.out.println(">> " + p2.getSeleccion().getNombreFederacion() + ":");
            p2.getSeleccion().getJugador().forEach(j ->
                    System.out.printf("   N° %-3d | %-15s | %s%n",
                            j.getDorsal(), j.getPosicion(), j.getNombre())
            );
        } else {
            System.out.println(" Sin jugadores registrados para el equipo 2.");
        }

        //EVENTOS (Ordenados por minuto)
        System.out.println("--- Eventos ---");
        if (p.getEventos() != null && !p.getEventos().isEmpty()) {
            p.getEventos().stream()
                    .filter(Objects::nonNull)
                    .sorted(Comparator.comparingInt(Evento::getMinuto))
                    .forEach(e -> System.out.printf(" Min %3d: %-20s %s%n",
                            e.getMinuto(),
                            e.getEvento(),
                            e.getJugador() != null ? e.getJugador().getNombre() : ""));
        } else {
            System.out.println(" Sin eventos registrados.");
        }

        // ÁRBITROS (opcional, podemos sacarlo pero queda prolijo dejarlo)
        System.out.println("\n--- Árbitros ---");
        if (p.getArbitraje() != null && !p.getArbitraje().isEmpty()) {
            p.getArbitraje().stream()
                    .filter(Objects::nonNull)
                    .forEach(a -> System.out.printf(" %-15s: %s%n",
                            a.getRol(),
                            a.getArbitro() != null ? a.getArbitro().getNombre() : ""));
        } else {
            System.out.println(" Sin árbitros asignados.");
        }
    }
    //ESTADISTICAS DE SEDES
    public static void mostrarEstadisticasSedes(List<Sede> sedes) {
        System.out.println("===== ESTADÍSTICAS DE SEDES =====");
        System.out.printf("%-20s %-15s %10s %12s%n", "Ciudad", "País", "Partidos", "Estadios");
        System.out.println("-".repeat(60));
        //Acá estoy usando .stream, es más corto pero quiero ver si está bien usarlo. Supuestamente lo dimos en U2 xd
        sedes.stream()
                .filter(Objects::nonNull)
                .forEach(s -> {
                    int cantPartidos = s.getEstadios().stream()
                            .filter(Objects::nonNull)
                            .mapToInt(e -> e.getPartidos() != null ? e.getPartidos().size() : 0)
                            .sum();
                    System.out.printf("%-20s %-15s %10d %12d%n",
                            s.getCiudad(),
                            s.getPais() != null ? s.getPais().getNombre() : "N/A",
                            cantPartidos,
                            s.getEstadios().size());
                });
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
/**
 * Clase responsable de generar todos los informes y reportes estadísticos del mundial
 * Procesa la información de partidos, selecciones y eventos para mostrar los resultados
 * ingresados por consola.
 * @author Antoenlla Monti, María del Mar Dalorso.
 */
public class Reporte {
    
    /**
     * Calcula las estadísticas completas de un grupo específico según la lista de partidos jugados.
     * @param grupo El {@link Grupo} del cual se quieren calcular las estadísticas.
     * @param partidos La lista total de {@link Partido} registrados en el sistema.
     * @return Una lista de objetos {@link Estadistica} con los datos acumulados de cada selección.
     */
    public List<Estadistica> calcularTablaEstadisticas(Grupo grupo, List<Partido> partidos) {
        
        List<Estadistica> tabla = new ArrayList<>();
        
        if (grupo == null || grupo.getSelecciones() == null) return tabla;
       
        //Una ficha en blanco por cada selección del grupo
        for (Seleccion s : grupo.getSelecciones()) {
            if (s != null) {
                tabla.add(new Estadistica(s));
            }
        }

        //Recorremos los partidos y sumamos a la ficha que corresponda
        if (partidos != null) {
    for (Partido p : partidos) {
       if (p == null || p.getFase() == null) continue;
       
       if (!p.getFase().getNombreFase().equals(TipoNombreFase.Grupos)) continue;
       
       if (p.getSeleccion1() == null || p.getSeleccion2() == null) continue;

               Seleccion s1 = p.getSeleccion1().getSeleccion();
               Seleccion s2 = p.getSeleccion2().getSeleccion();
               
               if (s1 == null || s2 == null) continue;
               if (!grupo.getSelecciones().contains(s1) || !grupo.getSelecciones().contains(s2)) continue;

               Estadistica estS1 = null;
               Estadistica estS2 = null;
               for (Estadistica est : tabla) {
                    if (est != null) {
                       if (est.getSeleccion() == s1) estS1 = est;
                       if (est.getSeleccion() == s2) estS2 = est;
                    }
                }
                if (estS1 != null && estS2 != null) {
                // Contamos los goles reales que tiene registrados este partido
                int golesS1 = p.getSeleccion1().getCantidadGoles(); // O la lógica/método que tengas en Partido para contar sus goles
                int golesS2 = p.getSeleccion2().getCantidadGoles(); 
                
                // Llamamos a tu método real de Estadistica.java para que sume los puntos
                estS1.computarPartido(golesS1, golesS2);
                estS2.computarPartido(golesS2, golesS1);
            }
        }
        }
        return tabla;
    }
    
    /**
     * Informe: Tabla de Posiciones por Grupo
     * Muestra en pantalla la Tabla de Posiciones de un grupo determinado.
     * Imprime de forma alineada los partidos jugados, ganados, empatados, perdidos,
     * goles a favor, en contra, diferencia de gol y el puntaje final ordenado de mayor a menor.
     * @param grupo El {@link Grupo} que se desea visualizar.
     * @param partidos La lista completa de {@link Partido} para extraer los resultados.
     */
    
    public void mostrarTablaPosiciones(Grupo grupo,List<Partido> partidos) {
        if (grupo == null) {
            System.out.println("Grupo no válido.");
            return;
        }
        System.out.println("===== TABLA DE POSICIONES - Grupo " + grupo.getIdentificacion() + " =====");
        System.out.printf("%-20s %3s %3s %3s %3s %3s %3s %4s %4s%n", "Seleccion", "PJ", "PG", "PE", "PP", "GF", "GC", "DG", "PTS"); //printf para imprimir 10 argumentos
        System.out.println("-".repeat(55));

        //Creamos una lista local para ordenar de forma segura
        List<Estadistica> listaEstadisticas = calcularTablaEstadisticas(grupo, partidos);

       //La ordenamos usando la clase comparadora
       listaEstadisticas.sort(new OrdenarEstadisticasPorPuntos());
    
        //Bucle para imprimir la lista fila x fila
        for (Estadistica est : listaEstadisticas) {
            if (est != null) {
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
    
    /**
     * Informe: Tabla de Resultados por Selección.
     * Muestra los puntos acumulados y las fases alcanzadas por la seleccion buscada
     * @param seleccionBuscada La {@link Seleccion} de la cual se quiere generar el informe.
     * @param partidos La lista global de {@link Partido} del torneo.
     */
    
    public void mostrarResultadosSeleccion(Seleccion seleccionBuscada,List<Partido> partidos) {
        System.out.println("===== RESULTADOS DE LA SELECCIÓN =====");
        
        // Control de null en el parámetro
       if (seleccionBuscada == null) {
           System.out.println("Datos inválidos para generar el reporte.");
           return;
        }
        
        System.out.println("Selección: " + seleccionBuscada.getNombreFederacion());
        
        // Obtenemos el grupo directo desde la selección
        Grupo grupo = seleccionBuscada.getGrupo();
        if (grupo == null) {
            System.out.println("La selección no pertenece a ningún grupo.");
            return;
        }
        // Mostrar puntajes de la fase de grupos
        System.out.println("\n--- Estadísticas en Grupo " + grupo.getIdentificacion() + " ---");
        List<Estadistica> tabla = calcularTablaEstadisticas(grupo, partidos);
        boolean encontradaEnGrupo = false;
        
        // chequeo de null para controlar
        
            for (Estadistica est : tabla) {
                if (est != null && est.getSeleccion() != null && est.getSeleccion().equals(seleccionBuscada)) {
                    System.out.println("Puntos: " + est.getPuntos());
                    System.out.println("Partidos Jugados: " + est.getPartidosJugados());
                    System.out.println("Ganados: " + est.getPartidosGanados());
                    System.out.println("Empatados: " + est.getPartidosEmpatados());
                    System.out.println("Perdidos: " + est.getPartidosPerdidos());
                    encontradaEnGrupo = true;
                    break;
                }
            }
        
        if (!encontradaEnGrupo) {
            System.out.println("La selección no pertenece a este grupo o no tiene estadísticas calculadas.");
        }

        // Mostrar instancias alcanzadas
        System.out.println("\n--- Instancias Alcanzadas ---");

        // Usamos una lista auxiliar para ir guardando las fases y no repetirlas en consola
        List<TipoNombreFase> instanciasAlcanzadas = new ArrayList<>();

        // Recorremos todas las participaciones de la selección (lo que fue pasando en cancha digamos)
        if (seleccionBuscada.getParticipaciones() != null) {
            for (Participacion participacion : seleccionBuscada.getParticipaciones()) {
                // Verificamos que los objetos no sean nulos para evitar crasheos (NullPointerException)
                if (participacion != null && participacion.getPartido() != null && participacion.getPartido().getFase() != null) {
                    TipoNombreFase faseDelPartido = participacion.getPartido().getFase().getNombreFase();

                    // Si la fase no está en nuestra lista auxiliar, la agregamos
                    if (!instanciasAlcanzadas.contains(faseDelPartido)) {
                        instanciasAlcanzadas.add(faseDelPartido);
                    }
                }
            }
        }

        // Imprimimos las instancias encontradas
        if (instanciasAlcanzadas.isEmpty()) {
            System.out.println("La selección no ha registrado partidos jugados aún.");
        } else {
            for (TipoNombreFase fase : instanciasAlcanzadas) {
                System.out.println("- " + fase);
            }
        }
    }

    /**
     * Informe: Ranking de Goleadores.
     * Genera el ranking de goleadores de todo el torneo.
     * Recorre cada evento de tipo gol y los agrupa por jugador, ordenándolos
     * de mayor a menor cantidad de anotaciones.
     * @param partidos Lista de {@link Partido} de donde se extraerán los eventos de gol.
     */
    public void mostrarRankingGoleadores(List<Partido> partidos) {
        //RANKING DE GOLEADORES
        System.out.println("===== RANKING DE GOLEADORES =====");
        System.out.printf("%-20s %6s %6s%n", "Jugador", "Dorsal", "Goles");
        System.out.println("-".repeat(35));
        //Control inicial
        if (partidos == null || partidos.isEmpty()) {
            System.out.println("No hay goles registrados.");
            return;
        }
        //Clase auxiliar para unir un jugador con su contador de goles
       //Ya define su propio orden (de mayor a menor goles) con compareTo
       class GoleadorAux implements Comparable<GoleadorAux> {
           Jugador jugador;
           int goles;
           GoleadorAux(Jugador jugador, int goles) {
               this.jugador = jugador;
               this.goles = goles;
            }

            @Override
           public int compareTo(GoleadorAux otro) {
               if (otro == null) {
                   return -1;
                }
                //De mayor a menor goles
                return Integer.compare(otro.goles, this.goles);
            }
        }
        //Lista para los auxiliares
        List<GoleadorAux> listaGoleadores = new ArrayList<>();
        //Bucle para recorrer los partidos
        for (Partido p : partidos) {
            if (p != null && p.getEventos() != null) {
                for (Evento e : p.getEventos()) {
                    //Verifica que sea gol y que esté asignado a un jugador
                    if (e != null && e.getEvento() == TipoEvento.Gol && e.getJugador() != null) { 
                        /*chequea q el jugador pertenezca a alguna de las dos 
                        selecciones del partido*/
                        Jugador jugadorActual = e.getJugador();
                        if (Validador.validarEvento(p, jugadorActual)) { 
                            //debemos buscar si ya existe un jugadoraux para ese jugador en listagoleadores
                            GoleadorAux encontrado = null;
                            for (GoleadorAux g : listaGoleadores) {
                                if (g.jugador.getDorsal() == jugadorActual.getDorsal() && g.jugador.getNombre().equalsIgnoreCase(jugadorActual.getNombre())) {
                                    encontrado = g;
                                    break;
                                }
                            }
                            //Si está
                            if (encontrado != null) {
                                encontrado.goles++;
                            } else {
                                //si no esta crea un jugadoraux
                                listaGoleadores.add(new GoleadorAux(jugadorActual, 1));
                            }

                        }
                    }
                }
            }
        }
        //Si no hay goles válidos
        if (listaGoleadores.isEmpty()) {
            System.out.println("No hay goles registrados.");
            return;
        }
        //Ordenamiento mayor a menor FIFA 
        Collections.sort(listaGoleadores);
        
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

    /**
     * Informe: Informe Disciplinario
     * Muestra el informe completo de tarjetas acumuladas y los jugadores que tengan tarjetas amarillas, rojas o dobles amarillas registradas,
     * ordenados por su nombre.
     * @param partidos Lista de {@link Partido} de donde se analizan las amonestaciones y expulsiones.
     */
    
    public void mostrarInformeDisciplinario(List<Partido> partidos) {
        System.out.println("===== INFORME DISCIPLINARIO =====");
        System.out.printf("%-20s %6s %10s %6s%n", "Jugador", "Dorsal", "Amarillas", "Rojas");
        System.out.println("-".repeat(45));
        //Control inicial para ver que la lista no esté vacía o nula
        if (partidos == null || partidos.isEmpty()) {
            System.out.println("No hay eventos disciplinarios registrados.");
            return;
        }
        //Auxiliar local
        class Sancionado implements Comparable<Sancionado> {
            Jugador jugador;
            int amarillas;
            int rojas;

            Sancionado(Jugador jugador) {
               this.jugador = jugador;
               this.amarillas = 0;
               this.rojas = 0;
            }

           @Override
           public int compareTo(Sancionado otro) { //si es verdadero         | si es falso   
               String n1 = (this.jugador != null) ? this.jugador.getNombre() : "";
               String n2 = (otro != null && otro.jugador != null) ? otro.jugador.getNombre() : "";
               return n1.compareToIgnoreCase(n2);
            }
        }   
        //Lista registros disciplinarios
        List<Sancionado> listaSancionados = new ArrayList<>();
        //Recorremos los partidos uno x uno
        for (Partido p : partidos) {
            if (p != null && p.getEventos() != null) {
                for (Evento e : p.getEventos()) {
                    if (e != null && e.getEvento() != null) {
                        TipoEvento tipo = e.getEvento();
                        //Si el evento es tarjeta
                        if (tipo == TipoEvento.TarjetaAmarilla || tipo == TipoEvento.TarjetaRoja || tipo == TipoEvento.DobleAmarilla) {
                            /*obtenemos el jusgador del evento y confimamos si el juador
                            esta jugando en una de las selecciones de ese partido*/
                            Jugador jugadorActual = e.getJugador();
                            if (Validador.validarEvento(p, jugadorActual)) {
                                //buscamos si el jugador ya esta en la lista de sancionados
                                Sancionado encontrado = null;
                                for (Sancionado s : listaSancionados) {
                                    if (s.jugador.getDorsal() == jugadorActual.getDorsal() && s.jugador.getNombre().equalsIgnoreCase((jugadorActual.getNombre()))) {
                                        encontrado = s;
                                        break;
                                    }
                                }
                                //Si lista de sancionados no existe la creamos
                                if (encontrado == null) {
                                    encontrado = new Sancionado(jugadorActual);
                                    listaSancionados.add(encontrado);
                                }
                                //Evaluamos el tipo de tarjeta para incrementar el contador correspondiente
                                if (tipo == TipoEvento.TarjetaAmarilla) {
                                    encontrado.amarillas++;
                                } else if (tipo == TipoEvento.TarjetaRoja) {
                                    encontrado.rojas++;
                                } else if (tipo == TipoEvento.DobleAmarilla) {
                                    encontrado.rojas++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (listaSancionados.isEmpty()) {
            System.out.println("No hay eventos disciplinarios registrados.");
            return;
        }
        //ordena por nombre de los jugadores
        Collections.sort(listaSancionados);
        
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

    /**
     * Informe: Ficha Técnica de Partido.
     * Genera y muestra la ficha tecnica de un partido en particular.
     * Muestra datos generales del encuentro, el resultado final, 
     * las alineaciones completas de ambas selecciones, los eventos ordenados por minuto y 
     * el cuerpo arbitral asignado.
     * @param p El {@link Partido} del cual se desea desplegar el detalle completo.
     */
    public void mostrarFichaTecnica(Partido p) {
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
        if (p1 != null && p2 != null && p1.getSeleccion() != null && p2.getSeleccion() != null) {
            System.out.println("--- Resultado Final ---");
            System.out.println("RESULTADO: " + p1.getSeleccion().getNombreFederacion() +
                    " " + p1.getCantidadGoles() +
                    " - " + p2.getCantidadGoles() + " " +
                    p2.getSeleccion().getNombreFederacion());
        }

        //Alineaciones
        System.out.println("--- Alineaciones ---");
        if (p1 != null && p1.getSeleccion() != null && p1.getSeleccion().getJugador() != null) {
            System.out.println(">> " + p1.getSeleccion().getNombreFederacion() + ":");
            for (Jugador j : p1.getSeleccion().getJugador()) {
                if (j != null) {
                System.out.printf("   N° %-3d | %-15s | %s%n",
                j.getDorsal(), j.getPosicion(), j.getNombre());
            }
        }
        } else {
            System.out.println(" Sin jugadores registrados para el equipo 1.");
        }

        if (p2 != null && p2.getSeleccion() != null && p2.getSeleccion().getJugador() != null) {
            System.out.println(">> " + p2.getSeleccion().getNombreFederacion() + ":");
            for (Jugador j : p2.getSeleccion().getJugador()) {
                if (j != null) {
                System.out.printf("   N° %-3d | %-15s | %s%n",
                j.getDorsal(), j.getPosicion(), j.getNombre());
            }
        }
        } else {
            System.out.println(" Sin jugadores registrados para el equipo 2.");
        }

        //EVENTOS (Ordenados por minuto)
        System.out.println("--- Eventos ---");
        if (p.getEventos() != null && !p.getEventos().isEmpty()) {
            List<Evento> eventosOrdenados = new ArrayList<>(p.getEventos());
            Collections.sort(eventosOrdenados, new Comparator<Evento>() {
            @Override
            public int compare(Evento e1, Evento e2) {
                if (e1 == null) return 1;
                if (e2 == null) return -1;
                return Integer.compare(e1.getMinuto(), e2.getMinuto());
            }
        });
        for (Evento e : eventosOrdenados) {
            if (e != null) {
                System.out.printf(" Min %3d: %-20s %s%n",
                e.getMinuto(),
                e.getEvento(),
                e.getJugador() != null ? e.getJugador().getNombre() : "");
            }
        }
        } else {
            System.out.println(" Sin eventos registrados.");
        }

        // ÁRBITROS (opcional, podemos sacarlo pero queda prolijo dejarlo)
        System.out.println("\n--- Árbitros ---");
        if (p.getArbitraje() != null && !p.getArbitraje().isEmpty()) {
            for (Arbitraje a : p.getArbitraje()) {
                if (a != null) {
                    System.out.printf(" %-15s: %s%n",
                    a.getRol(),
                    a.getArbitro() != null ? a.getArbitro().getNombre() : "");
                }
            }
        } else {
            System.out.println(" Sin árbitros asignados.");
        }
    }

    /**
     * Informe: Estadísticas de Sedes.
     * Muestra las estadísticas generales de una Sede.
     * Recorre uno por uno todos los estadios asociados a la sede e imprime 
     * cuántos partidos tuvo cada uno, para sumar todos y mostrar el total de cada sede.
     * @param sede La {@link Sede} de la cual se quieren consultar sus datos y partidos.
     */
    public void mostrarEstadisticasSedes(Sede sede) {
        System.out.println("===== ESTADÍSTICAS DE LA SEDE =====");
        
        //Control para que no falle si no existe la sede
        if(sede == null){
            System.out.println("Sede no valida.");
            return;
        }
        
        int cantPartidosTotales = 0;
        
        //Recorremos los estadios de esa sede
       
        if (sede.getEstadios() != null) {
            for (Estadio estadio : sede.getEstadios()) {
                if (estadio != null) {
                    int partidos = (estadio.getPartidos() != null) ? estadio.getPartidos().size() : 0;
                    cantPartidosTotales += partidos;
                    System.out.println("Estadio: " + estadio.getNombre() + " | Partidos: " + partidos);
                }
            }
        }
        
        System.out.println("Total partidos de la sede: " + cantPartidosTotales);
    }
    
    /**
     * Informe: Estadísticas de Sedes.
     * Muestra la cantidad de partidos jugados en un estadio especifico.
     * @param estadio El {@link Estadio} del cual se quieren consultar sus datos.
     */
    public void mostrarEstadisticasEstadio(Estadio estadio){
        if (estadio == null){
            System.out.println("Estadio no valido");
            return;
        }
        
        if(estadio.getPartidos() == null || estadio.getPartidos().isEmpty()){
            System.out.println("No hay partidos registrados en el estadio " + estadio.getNombre());
            return;
        }
        System.out.println("Estadio: " + estadio.getNombre() + " - Total partidos jugados: " + estadio.getPartidos().size());
    }
}


    





package org.example;
import java.util.*;
/**
 *
 * @author mardalorso
 */

public class Main {
    public static void main(String[] args) {
 
        // 1. MUNDIAL
        Mundial mundial = Ingreso.ingresarMundial();
 
        // 2. PAIS sede + SEDE + ESTADIOS
        Pais paisSede = Ingreso.ingresarPais();
        List<Sede> sedes = Ingreso.ingresarSedes(paisSede, mundial);
 
        // Por cada sede se ingresan sus estadios
        for (Sede sede : sedes) {
            Ingreso.ingresarEstadios(sede);
        }
 
        // 3. FASE + GRUPOS + SELECCIONES
        Fase fase = Ingreso.ingresarFase();
        List<Grupo> grupos = Ingreso.ingresarGrupos(fase);
 
        for (Grupo grupo : grupos) {
            // Por cada grupo se ingresan sus selecciones
            List<Seleccion> selecciones = Ingreso.ingresarSelecciones(grupo);
 
            for (Seleccion seleccion : selecciones) {
                // Por cada selección: jugadores, DT y cuerpo técnico
                Ingreso.ingresarJugadores(seleccion);
                Ingreso.ingresarDirectoresTecnicos(seleccion);
                Ingreso.ingresarCuerposTecnicos(seleccion);
            }
        }
 
        // 4. ARBITROS (asociados a un país)
        Pais paisArbitros = Ingreso.ingresarPais();
        List<Arbitro> arbitros = Ingreso.ingresarArbitros(paisArbitros);
 
        // 5. PARTIDOS (usando primera sede y primer estadio como ejemplo)
        Sede primeraS  = sedes.get(0);
        Estadio primerE = primeraS.getEstadios() != null && !primeraS.getEstadios().isEmpty()
                ? primeraS.getEstadios().get(0) : Ingreso.ingresarEstadio(primeraS);
 
        List<Partido> partidos = Ingreso.ingresarPartidos(primerE, fase);
 
        for (Partido partido : partidos) {
            // Participaciones: se eligen 2 selecciones del primer grupo
            List<Seleccion> sel = grupos.get(0).getSelecciones();
            if (sel.size() >= 2) {
                Participacion p1 = Ingreso.ingresarParticipacion(sel.get(0), partido);
                Participacion p2 = Ingreso.ingresarParticipacion(sel.get(1), partido);
                partido.setSeleccion1(p1);
                partido.setSeleccion2(p2);
                sel.get(0).agregarParticipacion(p1);
                sel.get(1).agregarParticipacion(p2);
 
                // Lista combinada de jugadores de ambas selecciones para los eventos
                List<Jugador> jugadoresPartido = new ArrayList<>();
                jugadoresPartido.addAll(sel.get(0).getJugador());
                jugadoresPartido.addAll(sel.get(1).getJugador());
                Ingreso.ingresarEventos(partido, jugadoresPartido);
            } else {
                System.out.println("  [!] No hay suficientes selecciones para registrar eventos.");
            }
 
            // Árbitros del partido
            if (!arbitros.isEmpty()) {
                Ingreso.ingresarArbitrajes(arbitros, partido);
            }
        }
 
        // --- Resumen final ---
        System.out.println("\n========== RESUMEN MUNDIAL ==========");
        System.out.println("Sedes registradas   : " + sedes.size());
        System.out.println("Grupos registrados  : " + grupos.size());
        System.out.println("Partidos registrados: " + partidos.size());
        System.out.println("Árbitros registrados: " + arbitros.size());
    }
}

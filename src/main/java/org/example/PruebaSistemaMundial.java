/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.*;
import java.time.*;

public class PruebaSistemaMundial {
    
    public static void ejecutarPruebas(Mundial mundial,List<Pais> paises, List<Sede> sedes, List<Estadio> estadios, List<Arbitro> arbitros, List<DirectorTecnico> dts, List<CuerpoTecnico> cts, List<Jugador> jugadores, List<Fase> fases, List<Grupo> grupos, List<Seleccion> selecciones, List<Partido> partidos) {

        // 1. Carga básica de datos requeridos por las relaciones de tus clases
        Pais arg = new Pais("Argentina", "Celeste y blanca");
        Pais fra = new Pais("Francia", "Azul, blanca y roja");
        paises.add(arg);
        paises.add(fra);

        Sede sedeBsAs = new Sede("Buenos Aires", 25.0f, "Templado", "GMT-3", arg);
        sedes.add(sedeBsAs);
        Estadio monumental = new Estadio("Estadio Monumental", 85000, sedeBsAs);
        estadios.add(monumental);
        sedeBsAs.agregarEstadio(monumental);

        Fase faseGrupos = new Fase(TipoNombreFase.Grupos);
        fases.add(faseGrupos);
        Grupo grupoA = new Grupo("A", "Grupo A", faseGrupos);
        grupos.add(grupoA);

        // 2. Registro de Jugadores usando tus métodos nativos
        Jugador messi = new Jugador("Lionel Messi", 1987, 10, TipoPosicion.Delantero, 72.0f, 1.70f);
        Jugador alvarez = new Jugador("Julian Alvarez", 2000, 9, TipoPosicion.Delantero, 71.0f, 1.70f);
        Jugador mbappe = new Jugador("Kylian Mbappe", 1998, 10, TipoPosicion.Delantero, 75.0f, 1.78f);
        

        Seleccion seleccionArg = new Seleccion("AFA", "Celeste y Blanca", "Azul", true, 1, arg, grupoA);
        seleccionArg.agregarJugador(messi);
        seleccionArg.agregarJugador(alvarez);
        arg.setSeleccion(seleccionArg);
        grupoA.agregarSeleccion(seleccionArg);
        selecciones.add(seleccionArg);

        Seleccion seleccionFra = new Seleccion("FFF", "Azul", "Blanca", false, 2, fra, grupoA);
        seleccionFra.agregarJugador(mbappe);
        fra.setSeleccion(seleccionFra);
        grupoA.agregarSeleccion(seleccionFra);
        selecciones.add(seleccionFra);

        // 3. Registro del plantel de Árbitros (6 físicos necesarios para pasar tu Validador)
        Arbitro arb1 = new Arbitro("Néstor Pitana", 1975, 15, arg);
        Arbitro arb2 = new Arbitro("Hernán Maidana", 1977, 12, arg);
        Arbitro arb3 = new Arbitro("Juan Belatti", 1979, 11, arg);
        Arbitro arb4 = new Arbitro("Mauro Vigliano", 1975, 10, arg);
        Arbitro arb5 = new Arbitro("Clement Turpin", 1982, 14, fra);
        Arbitro arb6 = new Arbitro("Nicolas Danos", 1980, 9, fra);
        arbitros.addAll(Arrays.asList(arb1, arb2, arb3, arb4, arb5, arb6));

        // 4. Creación del Partido
        Partido partidoTest = new Partido();
        partidoTest.setFase(faseGrupos);
        partidoTest.setEstadio(monumental);
        partidoTest.setFecha(LocalDate.of(2026, 6, 23));
        partidoTest.setHorario(LocalTime.of(16, 0));
        partidoTest.setDuracion(90);

        // Asociamos las participaciones que tu lógica de Partido necesita leer
        Participacion local = new Participacion(true, partidoTest, seleccionArg);
        Participacion visitante = new Participacion(false, partidoTest, seleccionFra);
        partidoTest.setSeleccion1(local);
        partidoTest.setSeleccion2(visitante);
        seleccionArg.agregarParticipacion(local);
        seleccionFra.agregarParticipacion(visitante);

        // Asignamos las categorías arbitrales requeridas por tu iterador
        int idx = 0;
        for (TipoCategoriaArbitro rol : TipoCategoriaArbitro.values()) {
            Arbitraje arb = new Arbitraje(rol, arbitros.get(idx++), partidoTest);
            partidoTest.agregarArbitraje(arb);
        }

        // Cargamos los eventos de campo usando tus métodos reales
        partidoTest.agregarEvento(TipoEvento.Gol, 15, messi);
        partidoTest.agregarEvento(TipoEvento.Gol, 42, mbappe);
        partidoTest.agregarEvento(TipoEvento.Gol, 88, alvarez);
        partidoTest.agregarEvento(TipoEvento.TarjetaAmarilla, 60, messi);

        // Guardado en registros de infraestructura y generales
        monumental.agregarPartido(partidoTest);
        faseGrupos.agregarPartido(partidoTest);
        partidos.add(partidoTest);

        // ============================================================
        // LLAMADA EXCLUSIVA A TUS MÉTODOS DE REPORTE NATIVOS
        // ============================================================
        Reporte reporte = new Reporte();

        // 1. Muestra tu Ficha Técnica nativa
        reporte.mostrarFichaTecnica(partidoTest);

        //2. muestra las tablas d eposiciones del grupo
        reporte.mostrarTablaPosiciones(grupoA, partidos);

        // 3. Muestra tu Ranking de Goleadores nativo
        reporte.mostrarRankingGoleadores(partidos);

        // 4. Muestra tu Informe Disciplinario nativo
        reporte.mostrarInformeDisciplinario(partidos);

        // 5. Muestra tus Estadísticas de Sede nativas
        System.out.println();
        reporte.mostrarEstadisticasSedes(sedeBsAs);
    }
}
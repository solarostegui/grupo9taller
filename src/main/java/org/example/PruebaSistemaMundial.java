/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.*;
import java.time.*;

public class PruebaSistemaMundial {

    public void ejecutarPruebas(Mundial mundial, List<Pais> paises, List<Sede> sedes,
            List<Estadio> estadios, List<Arbitro> arbitros, List<DirectorTecnico> dts,
            List<CuerpoTecnico> cts, List<Jugador> jugadores, List<Fase> fases,
            List<Grupo> grupos, List<Seleccion> selecciones, List<Partido> partidos) {

        System.out.println("############ INICIO DE PRUEBAS DEL SISTEMA MUNDIAL ############\n");

        // ============================================================
        // 1. GESTIÓN DE INFRAESTRUCTURA: Sedes y Estadios
        // ============================================================
        System.out.println("--- 1. Cargando Infraestructura (Países, Sedes, Estadios) ---");

        Pais arg = new Pais("Argentina", "Celeste y blanca");
        Pais fra = new Pais("Francia", "Azul, blanca y roja");
        paises.add(arg);
        paises.add(fra);

        Sede sedeBsAs = new Sede("Buenos Aires", 25.0f, "Templado", "GMT-3", arg);
        Sede sedeParis = new Sede("Paris", 35.0f, "Templado", "GMT+1", fra);
        arg.agregarSede(sedeBsAs);
        fra.agregarSede(sedeParis);
        mundial.agregarSede(sedeBsAs);
        mundial.agregarSede(sedeParis);
        sedes.add(sedeBsAs);
        sedes.add(sedeParis);

        Estadio monumental = new Estadio("Estadio Monumental", 85000, sedeBsAs);
        Estadio parcDesPrinces = new Estadio("Parc des Princes", 48000, sedeParis);
        sedeBsAs.agregarEstadio(monumental);
        sedeParis.agregarEstadio(parcDesPrinces);
        estadios.add(monumental);
        estadios.add(parcDesPrinces);

        // ============================================================
        // 2. ORGANIZACIÓN DEPORTIVA: Fases y Grupos
        // ============================================================
        System.out.println("--- 2. Configurando Fase de Grupos y Grupo A ---");

        Fase faseGrupos = new Fase(TipoNombreFase.Grupos);
        fases.add(faseGrupos);
        Grupo grupoA = new Grupo("A", "Grupo A", faseGrupos);
        grupos.add(grupoA);

        // ============================================================
        // 3. ADMINISTRACIÓN DE DELEGACIONES: Selecciones, CT, DT, Jugadores
        // ============================================================
        System.out.println("--- 3. Cargando Delegaciones (Selecciones, DT, CT, Jugadores) ---");

        // NOTA: solo tengo confirmado el valor TipoPosicion.Delantero (usado en la
        // prueba original). Si tenés otros valores como Arquero/Defensor, avisame.
        Jugador messi = new Jugador("Lionel Messi", 1987, 10, TipoPosicion.Delantero, 72.0f, 1.70f);
        Jugador alvarez = new Jugador("Julian Alvarez", 2000, 9, TipoPosicion.Delantero, 71.0f, 1.70f);
        Jugador dibu = new Jugador("Emiliano Martinez", 1992, 23, TipoPosicion.Delantero, 88.0f, 1.95f);
        Jugador mbappe = new Jugador("Kylian Mbappe", 1998, 10, TipoPosicion.Delantero, 75.0f, 1.78f);
        Jugador griezmann = new Jugador("Antoine Griezmann", 1991, 7, TipoPosicion.Delantero, 73.0f, 1.76f);
        Jugador lloris = new Jugador("Hugo Lloris", 1986, 1, TipoPosicion.Delantero, 80.0f, 1.88f);
        // Jugador que NO pertenece a ninguna selección -> sirve para probar el
        // control de "eventos solo a jugadores que participan en el partido".
        Jugador intruso = new Jugador("Jugador Intruso", 1999, 99, TipoPosicion.Delantero, 70.0f, 1.75f);
        jugadores.add(messi);
        jugadores.add(alvarez);
        jugadores.add(dibu);
        jugadores.add(mbappe);
        jugadores.add(griezmann);
        jugadores.add(lloris);
        jugadores.add(intruso);

        DirectorTecnico scaloni = new DirectorTecnico("Lionel Scaloni", 1978, 2018);
        DirectorTecnico deschamps = new DirectorTecnico("Didier Deschamps", 1968, 2012);
        dts.add(scaloni);
        dts.add(deschamps);

        CuerpoTecnico kinesiologo = new CuerpoTecnico("Donato Villani", 1975, TipoRol.Kinesiologo);
        CuerpoTecnico medico = new CuerpoTecnico("Daniel Martinez", 1970, TipoRol.Medico);
        cts.add(kinesiologo);
        cts.add(medico);

        Seleccion seleccionArg = new Seleccion("AFA", "Celeste y Blanca", "Azul", true, 1, arg, grupoA);
        Seleccion seleccionFra = new Seleccion("FFF", "Azul", "Blanca", false, 2, fra, grupoA);

        arg.setSeleccion(seleccionArg);
        fra.setSeleccion(seleccionFra);
        grupoA.agregarSeleccion(seleccionArg);
        grupoA.agregarSeleccion(seleccionFra);
        selecciones.add(seleccionArg);
        selecciones.add(seleccionFra);

        seleccionArg.agregarDirectoresTecnicos(scaloni);
        seleccionFra.agregarDirectoresTecnicos(deschamps);
        seleccionArg.agregarCuerposTecnicos(kinesiologo);
        seleccionArg.agregarCuerposTecnicos(medico);

        seleccionArg.agregarJugador(messi, selecciones);
        seleccionArg.agregarJugador(alvarez, selecciones);
        seleccionArg.agregarJugador(dibu, selecciones);
        seleccionFra.agregarJugador(mbappe, selecciones);
        seleccionFra.agregarJugador(griezmann, selecciones);
        seleccionFra.agregarJugador(lloris, selecciones);

        // --- CONTROL: un jugador solo puede estar vinculado a una selección ---
        // Jugador NO conoce a Seleccion (sin bidireccionalidad según el UML), así que
        // el chequeo se hace recorriendo la lista global de selecciones, centralizado
        // en Validador.validarJugadorUnico() y llamado desde agregarJugador().
        System.out.println("\n>> CONTROL: intentando agregar a Messi (ya en AFA) también a Francia...");
        boolean seAgrego = seleccionFra.agregarJugador(messi, selecciones);
        System.out.println("   ¿Se pudo agregar? " + seAgrego + " (debería ser false, Messi ya está en AFA)");

        // ============================================================
        // 4. PLANTEL DE ÁRBITROS
        // ============================================================
        System.out.println("\n--- 4. Cargando plantel de Árbitros ---");
        Arbitro arb1 = new Arbitro("Néstor Pitana", 1975, 15, arg);
        Arbitro arb2 = new Arbitro("Hernán Maidana", 1977, 12, arg);
        Arbitro arb3 = new Arbitro("Juan Belatti", 1979, 11, arg);
        Arbitro arb4 = new Arbitro("Mauro Vigliano", 1975, 10, arg);
        Arbitro arb5 = new Arbitro("Clement Turpin", 1982, 14, fra);
        Arbitro arb6 = new Arbitro("Nicolas Danos", 1980, 9, fra);
        arbitros.addAll(Arrays.asList(arb1, arb2, arb3, arb4, arb5, arb6));

        // ============================================================
        // 5. PARTIDO 1: Argentina vs Francia (arbitraje completo y válido)
        // ============================================================
        System.out.println("\n--- 5. Cargando Partido 1: Argentina vs Francia ---");

        Partido partido1 = new Partido();
        partido1.setFase(faseGrupos);
        partido1.setEstadio(monumental);
        partido1.setFecha(LocalDate.of(2026, 6, 23));
        partido1.setHorario(LocalTime.of(16, 0));
        partido1.setDuracion(90);

        Participacion local1 = new Participacion(true, partido1, seleccionArg);
        Participacion visitante1 = new Participacion(false, partido1, seleccionFra);
        partido1.setSeleccion1(local1);
        partido1.setSeleccion2(visitante1);
        seleccionArg.agregarParticipacion(local1);
        seleccionFra.agregarParticipacion(visitante1);

        // Cargamos los 6 roles obligatorios del equipo de arbitraje
        // --- CONTROL: el partido debe tener un equipo de arbitraje válido ---
        // agregarArbitraje() ahora devuelve boolean: true cuando, después de esta
        // carga, el equipo de arbitraje queda completo y válido (llama internamente
        // a Validador.validarArbitraje()).
        int idx = 0;
        boolean equipoCompletoP1 = false;
        for (TipoCategoriaArbitro rol : TipoCategoriaArbitro.values()) {
            Arbitraje a = new Arbitraje(rol, arbitros.get(idx++), partido1);
            equipoCompletoP1 = partido1.agregarArbitraje(a);
        }
        System.out.println(">> CONTROL: arbitraje del Partido 1 (6 roles asignados) -> equipo completo y válido: "
                + equipoCompletoP1);

        // Goles y tarjetas "legítimos" (jugadores que sí participan en este partido)
        partido1.agregarEvento(TipoEvento.Gol, 15, messi);
        partido1.agregarEvento(TipoEvento.Gol, 42, mbappe);
        partido1.agregarEvento(TipoEvento.Gol, 88, alvarez);
        partido1.agregarEvento(TipoEvento.TarjetaAmarilla, 60, messi);
        partido1.agregarEvento(TipoEvento.TarjetaAmarilla, 75, griezmann);

        // --- CONTROL: los eventos solo pueden asignarse a jugadores que participan ---
        // agregarEvento() ahora valida internamente con Validador.validarEvento()
        // ANTES de cargar el dato, así que el evento del Intruso ni se llega a guardar.
        System.out.println("\n>> CONTROL: registrando un gol del jugador 'Intruso' (no juega este partido)...");
        boolean seCargoEvento = partido1.agregarEvento(TipoEvento.Gol, 30, intruso);
        System.out.println("   ¿Se pudo registrar el evento? " + seCargoEvento + " (debería ser false)");

        monumental.agregarPartido(partido1);
        faseGrupos.agregarPartido(partido1);
        partidos.add(partido1);

        // ============================================================
        // 6. PARTIDO 2: Francia vs Argentina (arbitraje incompleto -> control)
        // ============================================================
        System.out.println("\n--- 6. Cargando Partido 2: con arbitraje INCOMPLETO ---");

        Partido partido2 = new Partido();
        partido2.setFase(faseGrupos);
        partido2.setEstadio(monumental);
        partido2.setFecha(LocalDate.of(2026, 6, 27));
        partido2.setHorario(LocalTime.of(18, 0));
        partido2.setDuracion(90);

        Participacion local2 = new Participacion(true, partido2, seleccionFra);
        Participacion visitante2 = new Participacion(false, partido2, seleccionArg);
        partido2.setSeleccion1(local2);
        partido2.setSeleccion2(visitante2);
        seleccionFra.agregarParticipacion(local2);
        seleccionArg.agregarParticipacion(visitante2);

        // Cargamos solo 3 de los 6 roles obligatorios
        boolean equipoCompletoP2 = false;
        equipoCompletoP2 = partido2.agregarArbitraje(new Arbitraje(TipoCategoriaArbitro.Principal, arb1, partido2));
        equipoCompletoP2 = partido2.agregarArbitraje(new Arbitraje(TipoCategoriaArbitro.Asistente1, arb2, partido2));
        equipoCompletoP2 = partido2.agregarArbitraje(new Arbitraje(TipoCategoriaArbitro.Asistente2, arb3, partido2));

        System.out.println(">> CONTROL: arbitraje del Partido 2 (solo 3 de 6 roles) -> completo y válido: "
                + equipoCompletoP2 + " (debería ser false)");

        // Completamos el equipo de arbitraje para dejarlo en condiciones de jugarse
        equipoCompletoP2 = partido2.agregarArbitraje(new Arbitraje(TipoCategoriaArbitro.CuartoArbitro, arb4, partido2));
        equipoCompletoP2 = partido2.agregarArbitraje(new Arbitraje(TipoCategoriaArbitro.VarPrincipal, arb5, partido2));
        equipoCompletoP2 = partido2.agregarArbitraje(new Arbitraje(TipoCategoriaArbitro.VarAsistente, arb6, partido2));

        System.out.println(">> CONTROL: arbitraje del Partido 2 (ya completo, 6 roles) -> completo y válido: "
                + equipoCompletoP2 + " (debería ser true)");

        // Resultado: empate 1 a 1 (para ver el cálculo de puntos por empate en la tabla)
        partido2.agregarEvento(TipoEvento.Gol, 20, griezmann);
        partido2.agregarEvento(TipoEvento.Gol, 70, alvarez);
        partido2.agregarEvento(TipoEvento.TarjetaRoja, 85, mbappe);

        monumental.agregarPartido(partido2);
        faseGrupos.agregarPartido(partido2);
        partidos.add(partido2);

        // ============================================================
        // 7. INFORMES (los 6 pedidos por el enunciado)
        // ============================================================
        System.out.println("\n############ GENERANDO LOS 6 INFORMES SOLICITADOS ############");

        Reporte reporte = new Reporte();

        System.out.println("\n----- (1) Tabla de Posiciones por Grupo -----");
        reporte.mostrarTablaPosiciones(grupoA, partidos);

        System.out.println("\n----- (2) Tabla de Resultados por Selección (Argentina) -----");
        reporte.mostrarResultadosSeleccion(seleccionArg, partidos);

        System.out.println("\n----- (3) Ranking de Goleadores -----");
        reporte.mostrarRankingGoleadores(partidos);

        System.out.println("\n----- (4) Informe Disciplinario -----");
        reporte.mostrarInformeDisciplinario(partidos);

        System.out.println("\n----- (5) Ficha Técnica del Partido 1 -----");
        reporte.mostrarFichaTecnica(partido1);

        System.out.println("\n----- (6) Estadísticas de Sede (Buenos Aires) -----");
        reporte.mostrarEstadisticasSedes(sedeBsAs);

        // Esta tabla de posiciones se recalcula en cada llamada a partir de los
        // partidos cargados, así que el control de "las estadísticas de grupo se
        // actualizan automáticamente con los resultados" queda demostrado con que
        // el Partido 2 (empate) ya impactó en los puntos mostrados arriba sin que
        // hayamos tocado ninguna tabla "a mano".

        System.out.println("\n############ FIN DE PRUEBAS ############");
    }
}
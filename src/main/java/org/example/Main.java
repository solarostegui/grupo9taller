package org.example;

public class Main {
    public static void main(String[] args) {

        // 1. MUNDIAL
        Mundial mundial = Ingreso.ingresarMundial();

        // 2. PAIS (sede del mundial)
        Pais pais = Ingreso.ingresarPais();

        // 3. SEDE (depende de Pais)
        Sede sede = Ingreso.ingresarSede(pais);
        mundial.agregarSede(sede);

        // 4. ESTADIO (depende de Sede)
        Estadio estadio = Ingreso.ingresarEstadio(sede);
        sede.agregarEstadio(estadio);

        // 5. FASE
        Fase fase = Ingreso.ingresarFase();

        // 6. GRUPO (depende de Fase)
        Grupo grupo = Ingreso.ingresarGrupo(fase);

        // 7. SELECCION 1 (depende de Pais y Grupo)
        Pais paisSel1 = Ingreso.ingresarPais();
        Seleccion seleccion1 = Ingreso.ingresarSeleccion(paisSel1, grupo);
        grupo.agregarSelecciones(seleccion1);

        // 8. SELECCION 2
        Pais paisSel2 = Ingreso.ingresarPais();
        Seleccion seleccion2 = Ingreso.ingresarSeleccion(paisSel2, grupo);
        grupo.agregarSelecciones(seleccion2);

        // 9. JUGADOR (depende de Seleccion)
        Jugador jugador = Ingreso.ingresarJugador(seleccion1);
        seleccion1.agregarJugador(jugador);

        // 10. DIRECTOR TECNICO
        DirectorTecnico dt = Ingreso.ingresarDirectorTecnico();
        seleccion1.agregarDirectoresTecnicos(dt);

        // 11. CUERPO TECNICO
        CuerpoTecnico ct = Ingreso.ingresarCuerpoTecnico();
        seleccion1.agregarCuerposTecnicos(ct);

        // 12. ARBITRO (depende de Pais)
        Pais paisArbitro = Ingreso.ingresarPais();
        Arbitro arbitro = Ingreso.ingresarArbitro(paisArbitro);

        // 13. PARTIDO (depende de Estadio y Fase)
        //     Las participaciones se crean con null de partido primero,
        //     luego se asignan al partido creado
        Partido partido = Ingreso.ingresarPartido(estadio, fase);
        fase.agregarPartido(partido);
        estadio.agregarPartido(partido);

        // 14. PARTICIPACION (depende de Seleccion y Partido)
        Participacion part1 = Ingreso.ingresarParticipacion(seleccion1, partido);
        Participacion part2 = Ingreso.ingresarParticipacion(seleccion2, partido);
        partido.setSeleccion1(part1);
        partido.setSeleccion2(part2);

        // 15. EVENTO (se agrega al partido)
        Evento evento = Ingreso.ingresarEvento();
        partido.getEventos().add(evento);

        // 16. ARBITRAJE (depende de Arbitro y Partido)
        Arbitraje arbitraje = Ingreso.ingresarArbitraje(arbitro, partido);
        partido.agregarArbitraje(arbitraje);
        arbitro.agregarArbitraje(arbitraje);

        // --- Mostrar resultados ---
        System.out.println("\n========== RESUMEN ==========");
        System.out.println(partido);
        System.out.println(seleccion1);
        System.out.println(seleccion2);
        System.out.println(jugador);
        System.out.println(estadio);
        System.out.println(fase);
    }
}



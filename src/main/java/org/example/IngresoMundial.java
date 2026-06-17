/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.*;
import java.time.*;

/**
 *
 * @author mardalorso
 */
public class IngresoMundial{
    
    private static Scanner sc = new Scanner(System.in);
    
    // Este método se encarga de que el input sea SIEMPRE entero
    public static int pedirEntero(String mensaje){
        while(true){
            try{
                System.out.print(mensaje);
                //trim elimina espacion en blanco de inicio y final
                int num = Integer.parseInt(sc.nextLine().trim()); 
                return num;
            }catch(NumberFormatException e){
                System.out.print("Dato inválido. Ingresá un número entero: ");
                
            }
        }
    }
    // Pide un float y valida que lo sea
   public static float pedirFloat(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                float num = Float.parseFloat(sc.nextLine().trim().replace(",", "."));
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido (ej: 75.5).");
            }
        }
    }
    //Pide un String no vacío
    public static String pedirString(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            //para verificar que el texto no este vacio
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Error: el valor no puede estar vacío.");
        }
    }
    //pide un booleano (true/false, s/n, si/no)
    public static boolean pedirBooleano(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.equals("s") || entrada.equals("si") || entrada.equals("true")) {
                return true;
            }
            if (entrada.equals("n") || entrada.equals("no") || entrada.equals("false")) {
                return false;
            }
            System.out.println("Error: responda 's' o 'n' ");
        }
    }
    // Pide un entero dentro de un rango [min, max]
    public static int pedirEnteroRango(String mensaje, int min, int max) {
        while (true) {
            int num = pedirEntero(mensaje);
            if (num >= min && num <= max) {
                return num;
            }
            System.out.println("Error: el valor debe estar entre " + min + " y " + max + ".");
        }
    }
    //pausa y espera el enter
    public static void pausa() {
        System.out.println("\nPresione Enter para continuar...");
        sc.nextLine();
    }
   //Cierra el Scanner 
    public static void cerrar() {
        sc.close();
    }
    
    //Ingreso de la clase mundial
    public static void ingresarMundial(List<Sede> sedes){
        System.out.println("\n=== Ingreso de Mundial ===");
        
        
        int anio = pedirEntero("Ingrese el año: ");

        String mascota =pedirString("Ingrese la mascota: ");

        
        int fechaDesde = pedirEntero(" Fecha inicio (num/año) : ");

        
        int fechaHasta = pedirEntero(" Fecha fin (num/año) : ");
        Mundial mundial= new Mundial(anio, mascota, fechaDesde, fechaHasta);
        
    }
    // CREAR PAIS
    public static void crearPais(List<Pais> paises) {
        System.out.println("\n--- NUEVO PAÍS ---");
        String nombre = pedirString("Nombre del país: ");
        String bandera = pedirString("Descripción de la bandera: ");
        Pais p = new Pais(nombre, bandera);
        paises.add(p);
        System.out.println("País '" + nombre + "' creado con éxito.");
    }
    
    // CREAR SEDE + ESTADIOS
    public static void crearSede(List<Pais> paises, List<Sede> sedes, List<Estadio> estadios) {
        if (paises.isEmpty()) {
            System.out.println("Primero debe crear al menos un país.");
            return;
        }

        System.out.println("\n--- NUEVA SEDE ---");
        String ciudad =pedirString("Ciudad: ");
        float altura =pedirFloat("Altura sobre el nivel del mar: ");
        String clima =pedirString("Clima: ");
        String zona =pedirString("Zona horaria: ");

        System.out.println("Seleccione el país de la sede:");
        Pais pais = seleccionarPais(paises);

        Sede sede = new Sede(ciudad, altura, clima, zona, pais);
        pais.agregarSede(sede);
        sedes.add(sede);

        int cant = pedirEntero("¿Cuántos estadios tiene esta sede? ");
        for (int i = 0; i < cant; i++) {
            System.out.println("\nEstadio " + (i + 1) + " de " + cant);
            String nomEst =pedirString("Nombre del estadio: ");
            int cap =pedirEntero("Capacidad: ");
            Estadio e = new Estadio(nomEst, cap, sede);
            sede.agregarEstadio(e);
            estadios.add(e);
            System.out.println("Estadio '" + nomEst + "' creado.");
        }
        System.out.println("Sede '" + ciudad + "' creada con " + cant + " estadio(s).");
    }

    // CREAR ARBITRO
    public static void crearArbitro(List<Pais> paises, List<Arbitro> arbitros) {
        if (paises.isEmpty()) {
            System.out.println("Primero debe crear al menos un país.");
            return;
        }

        System.out.println("\n--- NUEVO ÁRBITRO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac =pedirEntero("Año de nacimiento (ej: 1985): ");
        int exp =pedirEntero("Años de experiencia: ");
        System.out.println("Seleccione el país del árbitro:");
        Pais pais = seleccionarPais(paises);

        Arbitro a = new Arbitro(nombre, fecNac, exp, pais);
        pais.agregarArbitro(a);
        arbitros.add(a);
        System.out.println("Árbitro '" + nombre + "' creado.");
    }
    
    
    // CREAR DIRECTOR TECNICO
    public static void crearDT(List<DirectorTecnico> dts) {
        System.out.println("\n--- NUEVO DIRECTOR TÉCNICO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac = pedirEntero("Año de nacimiento: ");
        int fecNomb = pedirEntero("Año de nombramiento: ");
        DirectorTecnico dt = new DirectorTecnico(nombre, fecNac, fecNomb);
        dts.add(dt);
        System.out.println("DT '" + nombre + "' creado.");
    }

    // CREAR CUERPO TECNICO
    public static void crearCT(List<CuerpoTecnico> cts) {
        System.out.println("\n--- NUEVO CUERPO TÉCNICO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac =pedirEntero("Año de nacimiento: ");
        TipoRol rol = IngresoEnum.elegirTipoRol();
        CuerpoTecnico ct = new CuerpoTecnico(nombre, fecNac, rol);
        cts.add(ct);
        System.out.println("Cuerpo técnico '" + nombre + "' creado.");
    }
    
    // CREAR FASE
    public static void crearFase(List<Fase> fases) {
        System.out.println("\n--- NUEVA FASE ---");
        TipoNombreFase nombre = IngresoEnum.elegirTipoNombreFase();
        Fase f = new Fase(nombre);
        fases.add(f);
        System.out.println("Fase '" + nombre + "' creada.");
    }

    
    // CREAR GRUPO
    public static void crearGrupo(List<Fase> fases, List<Grupo> grupos) {
        if (fases.isEmpty()) {
            System.out.println("Primero debe crear al menos una fase.");
            return;
        }
        System.out.println("\n--- NUEVO GRUPO ---");
        String id = pedirString("Identificación (ej: A): ");
        String desc = pedirString("Descripción (ej: Grupo A): ");
        System.out.println("Seleccione la fase:");
        Fase fase = seleccionarFase(fases);
        Grupo g = new Grupo(id, desc, fase);
        fase.agregarGrupos(g);
        grupos.add(g);
        System.out.println("Grupo '" + id + "' creado en fase " + fase.getNombreFase() + ".");
    }
    
    
    // CREAR JUGADOR
    public static void crearJugador(List<Jugador> jugadores) {
        System.out.println("\n--- NUEVO JUGADOR ---");
        String nombre = pedirString("Nombre: ");
        int fecNac = pedirEntero("Año de nacimiento: ");
        int dorsal = pedirEntero("Dorsal: ");
        TipoPosicion pos = IngresoEnum.elegirTipoPosicion();
        float peso = pedirFloat("Peso (kg, ej: 75.5): ");
        float altura = pedirFloat("Altura (m, ej: 1.80): ");

        Jugador j = new Jugador(nombre, fecNac, dorsal, pos, peso, altura);
        jugadores.add(j);
        System.out.println("Jugador '" + nombre + "' creado.");
    }

    
    // CREAR SELECCION COMPLETA
    public static void crearSeleccion(List<Grupo> grupos, List<Pais> paises,
                                       List<DirectorTecnico> dts, List<CuerpoTecnico> cts,
                                       List<Jugador> jugadores, List<Seleccion> selecciones) {
        if (paises.isEmpty() || grupos.isEmpty()) {
            System.out.println("Primero debe crear al menos un país y un grupo.");
            return;
        }

        System.out.println("\n--- NUEVA SELECCIÓN ---");
        String fed = pedirString("Nombre de la federación (ej: AFA): ");
        String camPpal = pedirString("Camiseta principal: ");
        String camSec = pedirString("Camiseta secundaria: ");
        int ranking =pedirEntero("Ranking FIFA: ");
        boolean cabeza = pedirBooleano("¿Es cabeza de grupo?");

        System.out.println("Seleccione el país:");
        Pais pais = seleccionarPais(paises);

        System.out.println("Seleccione el grupo:");
        Grupo grupo = seleccionarGrupo(grupos);

        DirectorTecnico dt = null;
        if (!dts.isEmpty()) {
            System.out.println("Seleccione el Director Técnico (0 para saltar):");
            dt = seleccionarDT(dts);
        }

        Seleccion s = new Seleccion(fed, camPpal, camSec, cabeza, ranking, pais, grupo);
        if (dt != null) s.agregarDirectoresTecnicos(dt);

        if (!cts.isEmpty()) {
            System.out.print("¿Agregar cuerpo técnico? ");
            if (pedirBooleano("")) {
                for (CuerpoTecnico ct : cts) {
                    System.out.print("¿Agregar a " + ct.getNombre() + " (" + ct.getRol() + ")? ");
                    if (pedirBooleano("")) {
                        s.agregarCuerposTecnicos(ct);
                    }
                }
            }
        }

        System.out.println("\nAgregando jugadores a la selección " + fed);
        boolean seguir;
        do {
            if (jugadores.isEmpty()) {
                System.out.println("No hay jugadores creados. Cree uno primero.");
                break;
            }
            Jugador j = seleccionarJugador(jugadores);
            s.agregarJugador(j);
            seguir = pedirBooleano("¿Agregar otro jugador?");
        } while (seguir);

        grupo.agregarSeleccion(s);
        selecciones.add(s);
        System.out.println("Selección '" + fed + "' creada con éxito.");
    }
     // CREAR PARTIDO CON EVENTOS
    public static void crearPartido(List<Seleccion> selecciones, List<Estadio> estadios,
                                     List<Fase> fases, List<Arbitro> arbitros,
                                     List<Partido> partidos, List<Jugador> jugadores) {
        if (selecciones.size() < 2 || estadios.isEmpty() ||fases.isEmpty() || arbitros.size() < 6) {
            System.out.println("Se necesitan: 2+ selecciones, 1+ estadio, 1+ fase, 6+ árbitros.");
            return;
        }

        System.out.println("\n--- NUEVO PARTIDO ---");

        int dia =pedirEntero("Día del partido (1-31): ");
        int mes = pedirEntero("Mes (1-12): ");
        int anio = pedirEntero("Año (ej: 2026): ");
        LocalDate fecha = LocalDate.of(anio, mes, dia);

        int hora = pedirEntero("Hora (0-23): ");
        int minuto = pedirEntero("Minuto (0-59): ");
        LocalTime horario = LocalTime.of(hora, minuto);

        int duracion = pedirEntero("Duración (minutos, ej: 90): ");

        System.out.println("Seleccione el estadio:");
        Estadio estadio = seleccionarEstadio(estadios);

        System.out.println("Seleccione la fase:");
        Fase fase = seleccionarFase(fases);

        Partido p = new Partido(fecha, horario, duracion, estadio, fase);

        System.out.println("\nSeleccione el Equipo A (designado local):");
        Seleccion s1 = seleccionarSeleccion(selecciones);
        Participacion par1 = new Participacion(true, p, s1);
        p.setSeleccion1(par1);
        s1.agregarParticipacion(par1);

        System.out.println("Seleccione el Equipo B (designado visitante):");
        Seleccion s2;
        do {
            s2 = seleccionarSeleccion(selecciones);
            if (s2 == s1) {
                System.out.println("Debe ser distinta al Equipo A.");
            }
        } while (s2 == s1);
        Participacion par2 = new Participacion(false, p, s2);
        p.setSeleccion2(par2);
        s2.agregarParticipacion(par2);

        System.out.println("\n--- Arbitraje del partido ---");
        for (TipoCategoriaArbitro rol : TipoCategoriaArbitro.values()) {
            System.out.println("Seleccione el " + rol + ":");
            Arbitro a = seleccionarArbitro(arbitros);
            Arbitraje arb = new Arbitraje(rol, a, p);
            p.agregarArbitraje(arb);
            a.agregarArbitraje(arb);
        }

        estadio.agregarPartido(p);
        fase.agregarPartido(p);
        partidos.add(p);

        boolean arbitrajeValido = Validador.validarArbitraje(p.getArbitraje());
        System.out.println("Equipo de arbitraje válido: " + (arbitrajeValido ? "SÍ" : "NO"));

        if (pedirBooleano("¿Desea registrar eventos ahora?")) {
            registrarEventos(p,jugadores);
        }

        System.out.println("Partido creado con éxito.");
    }
    
     
    // REGISTRAR EVENTOS A PARTIDO EXISTENTE
    public static void registrarEventosPartido(List<Partido> partidos, List<Jugador> jugadores) {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos creados.");
            return;
        }
        System.out.println("Seleccione el partido:");
        Partido p = seleccionarPartido(partidos);
        if (p == null) return;
        registrarEventos(p,jugadores);
    }

    //registra eventos en un partido ya creado
    public static void registrarEventos(Partido p, List<Jugador> jugadores) {
        System.out.println("\n--- Registro de eventos para el partido del " + p.getFecha() + " ---");
        boolean seguir;
        do {
            System.out.println("\nNuevo evento:");
            TipoEvento tipo = IngresoEnum.elegirTipoEvento();
            int min = pedirEntero("Minuto: ");

            Jugador j = null;
            if (tipo != TipoEvento.Sustitucion) {
                System.out.println("Jugador involucrado:");
                j = seleccionarJugador(jugadores);
                if (j != null && !Validador.validarEvento(p, j)) {
                    System.out.println("¡ADVERTENCIA! El jugador no pertenece a ninguna de las dos selecciones.");
                }
            }

            p.agregarEvento(tipo, min, j);
            seguir = pedirBooleano("¿Agregar otro evento?");
        } while (seguir);

        System.out.println("Eventos registrados correctamente.\n");
    }

    // ─── SELECTORES POR TIPO ──────────────────────────────────────────────────

    private static Pais seleccionarPais(List<Pais> paises) {
        if (paises.isEmpty()) { System.out.println("No hay países disponibles."); return null; }
        for (int i = 0; i < paises.size(); i++) System.out.println(" " + i + " - " + paises.get(i));
        return paises.get(pedirEnteroRango("Seleccione país: ", 0, paises.size() - 1));
    }

    private static Sede seleccionarSede(List<Sede> sedes) {
        if (sedes.isEmpty()) { System.out.println("No hay sedes disponibles."); return null; }
        for (int i = 0; i < sedes.size(); i++) System.out.println(" " + i + " - " + sedes.get(i));
        return sedes.get(pedirEnteroRango("Seleccione sede: ", 0, sedes.size() - 1));
    }

    private static Estadio seleccionarEstadio(List<Estadio> estadios) {
        if (estadios.isEmpty()) { System.out.println("No hay estadios disponibles."); return null; }
        for (int i = 0; i < estadios.size(); i++) System.out.println(" " + i + " - " + estadios.get(i));
        return estadios.get(pedirEnteroRango("Seleccione estadio: ", 0, estadios.size() - 1));
    }

    private static Fase seleccionarFase(List<Fase> fases) {
        if (fases.isEmpty()) { System.out.println("No hay fases disponibles."); return null; }
        for (int i = 0; i < fases.size(); i++) System.out.println(" " + i + " - " + fases.get(i));
        return fases.get(pedirEnteroRango("Seleccione fase: ", 0, fases.size() - 1));
    }

    private static Grupo seleccionarGrupo(List<Grupo> grupos) {
        if (grupos.isEmpty()) { System.out.println("No hay grupos disponibles."); return null; }
        for (int i = 0; i < grupos.size(); i++) System.out.println(" " + i + " - " + grupos.get(i));
        return grupos.get(pedirEnteroRango("Seleccione grupo: ", 0, grupos.size() - 1));
    }

    private static Seleccion seleccionarSeleccion(List<Seleccion> selecciones) {
        if (selecciones.isEmpty()) { System.out.println("No hay selecciones disponibles."); return null; }
        for (int i = 0; i < selecciones.size(); i++) System.out.println(" " + i + " - " + selecciones.get(i));
        return selecciones.get(pedirEnteroRango("Seleccione selección: ", 0, selecciones.size() - 1));
    }

    private static Arbitro seleccionarArbitro(List<Arbitro> arbitros) {
        if (arbitros.isEmpty()) { System.out.println("No hay árbitros disponibles."); return null; }
        for (int i = 0; i < arbitros.size(); i++) System.out.println(" " + i + " - " + arbitros.get(i));
        return arbitros.get(pedirEnteroRango("Seleccione árbitro: ", 0, arbitros.size() - 1));
    }

    private static Partido seleccionarPartido(List<Partido> partidos) {
        if (partidos.isEmpty()) { System.out.println("No hay partidos disponibles."); return null; }
        for (int i = 0; i < partidos.size(); i++) System.out.println(" " + i + " - " + partidos.get(i));
        return partidos.get(pedirEnteroRango("Seleccione partido: ", 0, partidos.size() - 1));
    }

    private static Jugador seleccionarJugador(List<Jugador> jugadores) {
        if (jugadores.isEmpty()) { System.out.println("No hay jugadores disponibles."); return null; }
        for (int i = 0; i < jugadores.size(); i++) System.out.println(" " + i + " - " + jugadores.get(i));
        return jugadores.get(pedirEnteroRango("Seleccione jugador: ", 0, jugadores.size() - 1));
    }

    private static DirectorTecnico seleccionarDT(List<DirectorTecnico> dts) {
        if (dts.isEmpty()) { System.out.println("No hay directores técnicos disponibles."); return null; }
        for (int i = 0; i < dts.size(); i++) System.out.println(" " + i + " - " + dts.get(i));
        return dts.get(pedirEnteroRango("Seleccione DT: ", 0, dts.size() - 1));
    }

    private static CuerpoTecnico seleccionarCT(List<CuerpoTecnico> cts) {
        if (cts.isEmpty()) { System.out.println("No hay cuerpo técnico disponible."); return null; }
        for (int i = 0; i < cts.size(); i++) System.out.println(" " + i + " - " + cts.get(i));
        return cts.get(pedirEnteroRango("Seleccione cuerpo técnico: ", 0, cts.size() - 1));
    }
}


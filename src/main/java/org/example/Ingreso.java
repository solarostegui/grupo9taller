/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.*;

/**
 *
 * @author mardalorso
 */
 
public class Ingreso {
 
    private static final Scanner sc = new Scanner(System.in);
 
    // -------------------------------------------------------
    //  Helpers privados
    // -------------------------------------------------------
 
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }
 
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Ingrese un número entero válido.");
            }
        }
    }
 
    private static float leerFloat(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Float.parseFloat(linea);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Ingrese un número decimal válido.");
            }
        }
    }
 
    private static boolean leerBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String linea = sc.nextLine().trim().toLowerCase();
            if (linea.equals("s") || linea.equals("si") || linea.equals("sí")) return true;
            if (linea.equals("n") || linea.equals("no"))                        return false;
            System.out.println("  [!] Ingrese 's' o 'n'.");
        }
    }
 
    private static int leerOpcionMenu(int min, int max) {
        while (true) {
            int opcion = leerEntero("  Opción: ");
            if (opcion >= min && opcion <= max) return opcion;
            System.out.println("  [!] Opción inválida. Ingrese entre " + min + " y " + max + ".");
        }
    }
 
    // -------------------------------------------------------
    //  Métodos de selección de Enum
    // -------------------------------------------------------
 
    public static TipoPosicion elegirTipoPosicion() {
        System.out.println("\n  -- Posiciones disponibles --");
        TipoPosicion[] valores = TipoPosicion.values();
        for (int i = 0; i < valores.length; i++)
            System.out.println("  " + i + " - " + valores[i].name());
        return valores[leerOpcionMenu(0, valores.length - 1)];
    }
 
    public static TipoRol elegirTipoRol() {
        System.out.println("\n  -- Roles disponibles --");
        TipoRol[] valores = TipoRol.values();
        for (int i = 0; i < valores.length; i++)
            System.out.println("  " + i + " - " + valores[i].name());
        return valores[leerOpcionMenu(0, valores.length - 1)];
    }
 
    public static TipoEvento elegirTipoEvento() {
        System.out.println("\n  -- Tipos de evento disponibles --");
        TipoEvento[] valores = TipoEvento.values();
        for (int i = 0; i < valores.length; i++)
            System.out.println("  " + i + " - " + valores[i].name());
        return valores[leerOpcionMenu(0, valores.length - 1)];
    }
 
    public static TipoNombreFase elegirTipoNombreFase() {
        System.out.println("\n  -- Fases disponibles --");
        TipoNombreFase[] valores = TipoNombreFase.values();
        for (int i = 0; i < valores.length; i++)
            System.out.println("  " + i + " - " + valores[i].name());
        return valores[leerOpcionMenu(0, valores.length - 1)];
    }
 
    public static TipoCategoriaArbitro elegirTipoCategoriaArbitro() {
        System.out.println("\n  -- Categorías de árbitro disponibles --");
        TipoCategoriaArbitro[] valores = TipoCategoriaArbitro.values();
        for (int i = 0; i < valores.length; i++)
            System.out.println("  " + i + " - " + valores[i].name());
        return valores[leerOpcionMenu(0, valores.length - 1)];
    }
 
    // -------------------------------------------------------
    //  Métodos individuales de ingreso (1 objeto)
    //  SOLO atributos propios — las relaciones se arman afuera
    // -------------------------------------------------------
 
    public static Mundial ingresarMundial() {
        System.out.println("\n=== Ingreso de Mundial ===");
        int    anio       = leerEntero("  Año del Mundial        : ");
        String mascota    = leerTexto ("  Mascota                : ");
        int    fechaDesde = leerEntero("  Fecha inicio (num/año) : ");
        int    fechaHasta = leerEntero("  Fecha fin   (num/año)  : ");
        return new Mundial(anio, mascota, fechaDesde, fechaHasta);
    }
 
    public static Pais ingresarPais() {
        System.out.println("\n=== Ingreso de País ===");
        String nombre  = leerTexto("  Nombre del país    : ");
        String bandera = leerTexto("  Bandera (emoji/url): ");
        return new Pais(nombre, bandera, null);
    }
 
    public static Sede ingresarSede(Pais pais) {
        System.out.println("\n=== Ingreso de Sede ===");
        String ciudad      = leerTexto("  Ciudad             : ");
        float  altura      = leerFloat("  Altura s/nivel mar : ");
        String clima       = leerTexto("  Clima              : ");
        String zonaHoraria = leerTexto("  Zona horaria       : ");
        Sede sede = new Sede();
        sede.setCiudad(ciudad);
        sede.setAlturaNivelMar(altura);
        sede.setClima(clima);
        sede.setZonaHoraria(zonaHoraria);
        sede.setPaises(pais);
        return sede;
    }
 
    public static Estadio ingresarEstadio(Sede sede) {
        System.out.println("\n=== Ingreso de Estadio ===");
        String nombre    = leerTexto ("  Nombre del estadio: ");
        int    capacidad = leerEntero("  Capacidad         : ");
        return new Estadio(nombre, capacidad, sede);
    }
 
    public static Fase ingresarFase() {
        System.out.println("\n=== Ingreso de Fase ===");
        return new Fase(elegirTipoNombreFase());
    }
 
    public static Grupo ingresarGrupo(Fase fase) {
        System.out.println("\n=== Ingreso de Grupo ===");
        String identificacion = leerTexto("  Identificación (ej: A): ");
        String descripcion    = leerTexto("  Descripción            : ");
        return new Grupo(identificacion, descripcion, fase);
    }
 
    public static Seleccion ingresarSeleccion(Pais pais, Grupo grupo) {
        System.out.println("\n=== Ingreso de Selección ===");
        String  nombreFederacion   = leerTexto  ("  Nombre federación   : ");
        String  camisetaPrincipal  = leerTexto  ("  Camiseta principal  : ");
        String  camisetaSecundaria = leerTexto  ("  Camiseta secundaria : ");
        boolean cabezaGrupo        = leerBoolean("  ¿Es cabeza de grupo?");
        int     rankingFIFA        = leerEntero ("  Ranking FIFA        : ");
        return new Seleccion(nombreFederacion, camisetaPrincipal,
                camisetaSecundaria, cabezaGrupo, rankingFIFA, pais, grupo);
    }
 
    public static Jugador ingresarJugador(Seleccion seleccion) {
        System.out.println("\n=== Ingreso de Jugador ===");
        String       nombre        = leerTexto ("  Nombre           : ");
        int          fecNacimiento = leerEntero("  Año de nacimiento: ");
        int          dorsal        = leerEntero("  Dorsal           : ");
        TipoPosicion posicion      = elegirTipoPosicion();
        float        peso          = leerFloat ("  Peso (kg)        : ");
        float        altura        = leerFloat ("  Altura (m)       : ");
        Jugador jugador = new Jugador(nombre, fecNacimiento, dorsal, posicion, peso, altura);
        seleccion.agregarJugador(jugador);
        return jugador;
    }
 
    public static DirectorTecnico ingresarDirectorTecnico() {
        System.out.println("\n=== Ingreso de Director Técnico ===");
        String nombre            = leerTexto ("  Nombre              : ");
        int    fecNacimiento     = leerEntero("  Año de nacimiento   : ");
        int    fechaNombramiento = leerEntero("  Año de nombramiento : ");
        return new DirectorTecnico(nombre, fecNacimiento, fechaNombramiento);
    }
 
    public static CuerpoTecnico ingresarCuerpoTecnico() {
        System.out.println("\n=== Ingreso de Cuerpo Técnico ===");
        String  nombre        = leerTexto ("  Nombre           : ");
        int     fecNacimiento = leerEntero("  Año de nacimiento: ");
        TipoRol rol           = elegirTipoRol();
        return new CuerpoTecnico(nombre, fecNacimiento, rol);
    }
 
    public static Arbitro ingresarArbitro(Pais pais) {
        System.out.println("\n=== Ingreso de Árbitro ===");
        String nombre           = leerTexto ("  Nombre             : ");
        int    fecNacimiento    = leerEntero("  Año de nacimiento  : ");
        int    aniosExperiencia = leerEntero("  Años de experiencia: ");
        return new Arbitro(nombre, fecNacimiento, aniosExperiencia, pais);
    }
 
    public static Partido ingresarPartido(Estadio estadio, Fase fase) {
        System.out.println("\n=== Ingreso de Partido ===");
        int duracion        = leerEntero("  Duración (minutos)    : ");
        int tiempoAdicional = leerEntero("  Tiempo adicional (min): ");
        Partido partido = new Partido();
        partido.setDuracion(duracion);
        partido.setTiempoadicional(tiempoAdicional);
        partido.setEstadio(estadio);
        partido.setFase(fase);
        return partido;
    }
 
    public static Participacion ingresarParticipacion(Seleccion seleccion, Partido partido) {
        System.out.println("\n=== Ingreso de Participación (" + seleccion.getNombreFederacion() + ") ===");
        boolean esLocal           = leerBoolean("  ¿Es local?");
        int     goles             = leerEntero ("  Goles                  : ");
        int     tarjetasAmarillas = leerEntero ("  Tarjetas amarillas     : ");
        int     tarjetasRojas     = leerEntero ("  Tarjetas rojas         : ");
        return new Participacion(esLocal, goles, tarjetasAmarillas, tarjetasRojas, partido, seleccion);
    }
 
    public static Evento ingresarEvento(List<Jugador> jugadores) {
        System.out.println("\n=== Ingreso de Evento ===");
        TipoEvento tipo   = elegirTipoEvento();
        int        minuto = leerEntero("  Minuto del evento: ");
        System.out.println("\n  -- Jugadores disponibles --");
        for (int i = 0; i < jugadores.size(); i++)
            System.out.println("  " + i + " - " + jugadores.get(i).getNombre()
                    + " (#" + jugadores.get(i).getDorsal() + ")");
        int idx     = leerOpcionMenu(0, jugadores.size() - 1);
        Jugador jugador = jugadores.get(idx);
        return new Evento(tipo, minuto, jugador);
    }
 
    public static Arbitraje ingresarArbitraje(Arbitro arbitro, Partido partido) {
        System.out.println("\n=== Ingreso de Arbitraje ===");
        TipoCategoriaArbitro rol = elegirTipoCategoriaArbitro();
        return new Arbitraje(rol, arbitro, partido);
    }
 
    // -------------------------------------------------------
    //  Métodos de ingreso MÚLTIPLE (loop con pregunta)
    //  Cada uno retorna una lista con N objetos ingresados
    // -------------------------------------------------------
 
    /** Ingresa N sedes y las agrega al Mundial */
    public static List<Sede> ingresarSedes(Pais pais, Mundial mundial) {
        int cantidad = leerEntero("\n¿Cuántas sedes desea ingresar? ");
        List<Sede> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Sede " + (i + 1) + " de " + cantidad + " ---");
            Sede sede = ingresarSede(pais);
            mundial.agregarSede(sede);
            lista.add(sede);
        }
        return lista;
    }
 
    /** Ingresa N estadios y los agrega a la sede */
    public static List<Estadio> ingresarEstadios(Sede sede) {
        int cantidad = leerEntero("\n¿Cuántos estadios desea ingresar para esta sede? ");
        List<Estadio> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Estadio " + (i + 1) + " de " + cantidad + " ---");
            Estadio estadio = ingresarEstadio(sede);
            sede.agregarEstadio(estadio);
            lista.add(estadio);
        }
        return lista;
    }
 
    /** Ingresa N grupos y los agrega a la fase */
    public static List<Grupo> ingresarGrupos(Fase fase) {
        int cantidad = leerEntero("\n¿Cuántos grupos desea ingresar para esta fase? ");
        List<Grupo> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Grupo " + (i + 1) + " de " + cantidad + " ---");
            Grupo grupo = ingresarGrupo(fase);
            lista.add(grupo);
        }
        return lista;
    }
 
    /** Ingresa N selecciones y las agrega al grupo */
    public static List<Seleccion> ingresarSelecciones(Grupo grupo) {
        int cantidad = leerEntero("\n¿Cuántas selecciones desea ingresar para este grupo? ");
        List<Seleccion> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Selección " + (i + 1) + " de " + cantidad + " ---");
            Pais pais = ingresarPais();
            Seleccion seleccion = ingresarSeleccion(pais, grupo);
            grupo.agregarSeleccion(seleccion);
            lista.add(seleccion);
        }
        return lista;
    }
 
    /** Ingresa N jugadores y los agrega a la selección */
    public static List<Jugador> ingresarJugadores(Seleccion seleccion) {
        int cantidad = leerEntero("\n¿Cuántos jugadores desea ingresar para " + seleccion.getNombreFederacion() + "? ");
        List<Jugador> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Jugador " + (i + 1) + " de " + cantidad + " ---");
            Jugador jugador = ingresarJugador(seleccion); // ya agrega a seleccion internamente
            lista.add(jugador);
        }
        return lista;
    }
 
    /** Ingresa N miembros del cuerpo técnico y los agrega a la selección */
    public static List<CuerpoTecnico> ingresarCuerposTecnicos(Seleccion seleccion) {
        int cantidad = leerEntero("\n¿Cuántos miembros del cuerpo técnico desea ingresar? ");
        List<CuerpoTecnico> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Cuerpo Técnico " + (i + 1) + " de " + cantidad + " ---");
            CuerpoTecnico ct = ingresarCuerpoTecnico();
            seleccion.agregarCuerposTecnicos(ct);
            lista.add(ct);
        }
        return lista;
    }
 
    /** Ingresa N directores técnicos y los agrega a la selección */
    public static List<DirectorTecnico> ingresarDirectoresTecnicos(Seleccion seleccion) {
        int cantidad = leerEntero("\n¿Cuántos directores técnicos desea ingresar? ");
        List<DirectorTecnico> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Director Técnico " + (i + 1) + " de " + cantidad + " ---");
            DirectorTecnico dt = ingresarDirectorTecnico();
            seleccion.agregarDirectoresTecnicos(dt);
            lista.add(dt);
        }
        return lista;
    }
 
    /** Ingresa N árbitros y los agrega al país */
    public static List<Arbitro> ingresarArbitros(Pais pais) {
        int cantidad = leerEntero("\n¿Cuántos árbitros desea ingresar para " + pais.getNombre() + "? ");
        List<Arbitro> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Árbitro " + (i + 1) + " de " + cantidad + " ---");
            Arbitro arbitro = ingresarArbitro(pais);
            pais.agregarArbitro(arbitro);
            lista.add(arbitro);
        }
        return lista;
    }
 
    /** Ingresa N partidos en una fase/estadio */
    public static List<Partido> ingresarPartidos(Estadio estadio, Fase fase) {
        int cantidad = leerEntero("\n¿Cuántos partidos desea ingresar para esta fase? ");
        List<Partido> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Partido " + (i + 1) + " de " + cantidad + " ---");
            Partido partido = ingresarPartido(estadio, fase);
            fase.agregarPartido(partido);
            estadio.agregarPartido(partido);
            lista.add(partido);
        }
        return lista;
    }
 
    /** Ingresa N eventos durante un partido y los agrega al partido.
     *  Recibe la lista combinada de jugadores de ambas selecciones. */
    public static List<Evento> ingresarEventos(Partido partido, List<Jugador> jugadores) {
        int cantidad = leerEntero("\n¿Cuántos eventos desea registrar para este partido? ");
        List<Evento> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Evento " + (i + 1) + " de " + cantidad + " ---");
            Evento evento = ingresarEvento(jugadores);
            partido.getEventos().add(evento);
            lista.add(evento);
        }
        return lista;
    }
 
    /** Ingresa N árbitros asignados a un partido */
    public static List<Arbitraje> ingresarArbitrajes(List<Arbitro> arbitrosDisponibles, Partido partido) {
        System.out.println("\n=== Asignación de Árbitros al Partido ===");
        System.out.println("  Árbitros disponibles:");
        for (int i = 0; i < arbitrosDisponibles.size(); i++)
            System.out.println("  " + i + " - " + arbitrosDisponibles.get(i).getNombre());
 
        int cantidad = leerEntero("¿Cuántos árbitros desea asignar? ");
        List<Arbitraje> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Arbitraje " + (i + 1) + " de " + cantidad + " ---");
            int idx = leerOpcionMenu(0, arbitrosDisponibles.size() - 1);
            Arbitro arbitro = arbitrosDisponibles.get(idx);
            Arbitraje arbitraje = ingresarArbitraje(arbitro, partido);
            partido.agregarArbitraje(arbitraje);
            arbitro.agregarArbitraje(arbitraje);
            lista.add(arbitraje);
        }
        return lista;
    }
}
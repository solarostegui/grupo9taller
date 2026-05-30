/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.Scanner;

/**
 *
 * @author mardalorso
 */

public class Ingreso {

    private static final Scanner sc = new Scanner(System.in);

    

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
            if (linea.equals("s") || linea.equals("si") || linea.equals("sí")){
                return true;
                
            }
            if (linea.equals("n") || linea.equals("no")){
                return false;
            }
            System.out.println("Ingrese 's' o 'n'.");
        }
    }

    private static int leerOpcionMenu(int min, int max) {
        while (true) {
            int opcion = leerEntero("  Opción: ");
            if (opcion >= min && opcion <= max) return opcion;
            System.out.println("  [!] Opción inválida. Ingrese un número entre " + min + " y " + max + ".");
        }
    }

    
    //  Métodos de selección de Enum (uno por cada enum)
    /*
     Menú para elegir un TipoPosicion.
     Usado en: ingresarJugador()
     */
    public static TipoPosicion elegirTipoPosicion() {
        System.out.println("\n  -- Posiciones disponibles --");
        TipoPosicion[] valores = TipoPosicion.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.println("  " + i + " - " + valores[i].name());
        }
        int opcion = leerOpcionMenu(0, valores.length - 1);
        return valores[opcion];
    }

    /*
     Menú para elegir un TipoRol.
     Usado en: ingresarCuerpoTecnico()
     */
    public static TipoRol elegirTipoRol() {
        System.out.println("\n  -- Roles disponibles --");
        TipoRol[] valores = TipoRol.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.println("  " + i + " - " + valores[i].name());
        }
        int opcion = leerOpcionMenu(0, valores.length - 1);
        return valores[opcion];
    }

    /*
     Menú para elegir un TipoEvento.
     Usado en: ingresarEvento()
     */
    public static TipoEvento elegirTipoEvento() {
        System.out.println("\n  -- Tipos de evento disponibles --");
        TipoEvento[] valores = TipoEvento.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.println("  " + i + " - " + valores[i].name());
        }
        int opcion = leerOpcionMenu(0, valores.length - 1);
        return valores[opcion];
    }

    /*
     Menú para elegir un TipoNombreFase.
     Usado en: ingresarFase()
     */
    public static TipoNombreFase elegirTipoNombreFase() {
        System.out.println("\n  -- Fases disponibles --");
        TipoNombreFase[] valores = TipoNombreFase.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.println("  " + i + " - " + valores[i].name());
        }
        int opcion = leerOpcionMenu(0, valores.length - 1);
        return valores[opcion];
    }

    /*
     Menú para elegir un TipoCategoriaArbitro.
     Usado en: ingresarArbitraje()
     */
    public static TipoCategoriaArbitro elegirTipoCategoriaArbitro() {
        System.out.println("\n  -- Categorías de árbitro disponibles --");
        TipoCategoriaArbitro[] valores = TipoCategoriaArbitro.values();
        for (int i = 0; i < valores.length; i++) {
            System.out.println("  " + i + " - " + valores[i].name());
        }
        int opcion = leerOpcionMenu(0, valores.length - 1);
        return valores[opcion];
    }

   
    //  Métodos de ingreso por clase
   
    /**
     * 1. PAIS
     */
    public static Pais ingresarPais() {
        System.out.println("\n=== Ingreso de País ===");
        String nombre  = leerTexto("  Nombre del país    : ");
        String bandera = leerTexto("  Bandera (emoji/url): ");
        return new Pais(nombre, bandera, null);
    }

    /**
     * 2. SEDE
     * Depende de: Pais
     */
    public static Sede ingresarSede(Pais pais) {
        System.out.println("\n=== Ingreso de Sede ===");
        String ciudad      = leerTexto("  Ciudad              : ");
        float  altura      = leerFloat("  Altura s/nivel mar  : ");
        String clima       = leerTexto("  Clima               : ");
        String zonaHoraria = leerTexto("  Zona horaria        : ");
        Sede sede = new Sede();
        sede.setCiudad(ciudad);
        sede.setAlturaNivelMar(altura);
        sede.setClima(clima);
        sede.setZonaHoraria(zonaHoraria);
        sede.setPaises(pais);
        return sede;
    }

    /**
     * 3. ESTADIO
     * Depende de: Sede
     */
    public static Estadio ingresarEstadio(Sede sede) {
        System.out.println("\n=== Ingreso de Estadio ===");
        String nombre    = leerTexto ("  Nombre del estadio: ");
        int    capacidad = leerEntero("  Capacidad         : ");
        return new Estadio(nombre, capacidad, sede);
    }

    /**
     * 4. FASE
     * Usa: elegirTipoNombreFase()
     */
    public static Fase ingresarFase() {
        System.out.println("\n=== Ingreso de Fase ===");
        TipoNombreFase tipo = elegirTipoNombreFase();
        return new Fase(tipo);
    }

    /**
     * 5. GRUPO
     * Depende de: Fase
     */
    public static Grupo ingresarGrupo(Fase fase) {
        System.out.println("\n=== Ingreso de Grupo ===");
        String identificacion = leerTexto("  Identificación (ej: A, B): ");
        String descripcion    = leerTexto("  Descripción              : ");
        return new Grupo(identificacion, descripcion, fase);
    }

    /**
     * 6. SELECCION
     * Depende de: Pais, Grupo
     */
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

    /**
     * 7. JUGADOR
     * Depende de: Seleccion
     * Usa: elegirTipoPosicion()
     */
    public static Jugador ingresarJugador(Seleccion seleccion) {
        System.out.println("\n=== Ingreso de Jugador ===");
        String      nombre        = leerTexto ("  Nombre           : ");
        int         fecNacimiento = leerEntero("  Año de nacimiento: ");
        int         dorsal        = leerEntero("  Dorsal           : ");
        TipoPosicion posicion     = elegirTipoPosicion();
        float       peso          = leerFloat ("  Peso (kg)        : ");
        float       altura        = leerFloat ("  Altura (m)       : ");
        return new Jugador(nombre, fecNacimiento, dorsal, posicion, peso, altura, null, seleccion);
    }

    /**
     * 8. DIRECTOR TECNICO
     * Hereda de Persona.
     */
    public static DirectorTecnico ingresarDirectorTecnico() {
        System.out.println("\n=== Ingreso de Director Técnico ===");
        String nombre            = leerTexto ("  Nombre              : ");
        int    fecNacimiento     = leerEntero("  Año de nacimiento   : ");
        int    fechaNombramiento = leerEntero("  Año de nombramiento : ");
        return new DirectorTecnico(nombre, fecNacimiento, fechaNombramiento);
    }

    /**
     * 9. CUERPO TECNICO
     * Hereda de Persona.
     * Usa: elegirTipoRol()
     */
    public static CuerpoTecnico ingresarCuerpoTecnico() {
        System.out.println("\n=== Ingreso de Cuerpo Técnico ===");
        String  nombre        = leerTexto ("  Nombre           : ");
        int     fecNacimiento = leerEntero("  Año de nacimiento: ");
        TipoRol rol           = elegirTipoRol();
        return new CuerpoTecnico(nombre, fecNacimiento, rol);
    }

    /**
     * 10. ARBITRO
     * Hereda de Persona. Depende de: Pais.
     */
    public static Arbitro ingresarArbitro(Pais pais) {
        System.out.println("\n=== Ingreso de Árbitro ===");
        String nombre           = leerTexto ("  Nombre             : ");
        int    fecNacimiento    = leerEntero("  Año de nacimiento  : ");
        int    aniosExperiencia = leerEntero("  Años de experiencia: ");
        return new Arbitro(nombre, fecNacimiento, aniosExperiencia, pais);
    }

    /**
     * 11. PARTICIPACION
     * Clase asociación. Depende de: Seleccion, Partido.
     */
    public static Participacion ingresarParticipacion(Seleccion seleccion, Partido partido) {
        System.out.println("\n=== Ingreso de Participación (" + seleccion.getNombreFederacion() + ") ===");
        boolean esLocal           = leerBoolean("  ¿Es local?");
        int     goles             = leerEntero ("  Cantidad de goles             : ");
        int     tarjetasAmarillas = leerEntero ("  Cantidad de tarjetas amarillas: ");
        int     tarjetasRojas     = leerEntero ("  Cantidad de tarjetas rojas    : ");
        return new Participacion(esLocal, goles, tarjetasAmarillas, tarjetasRojas, partido, seleccion);
    }

    /**
     * 12. EVENTO
     * Composición dentro de Partido.
     * Usa: elegirTipoEvento()
     */
    public static Evento ingresarEvento() {
        System.out.println("\n=== Ingreso de Evento ===");
        TipoEvento tipo   = elegirTipoEvento();
        int        minuto = leerEntero("  Minuto del evento: ");
        return new Evento(tipo, minuto);
    }

    /**
     * 13. ARBITRAJE
     * Clase asociación. Depende de: Arbitro, Partido.
     * Usa: elegirTipoCategoriaArbitro()
     */
    public static Arbitraje ingresarArbitraje(Arbitro arbitro, Partido partido) {
        System.out.println("\n=== Ingreso de Arbitraje ===");
        TipoCategoriaArbitro rol = elegirTipoCategoriaArbitro();
        return new Arbitraje(rol, arbitro, partido);
    }

    /**
     * 14. PARTIDO
     * Depende de: Estadio, Fase.
     * Participaciones y Arbitrajes se agregan después con sus métodos.
     */
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

    /**
     * 15. MUNDIAL
     * Sin dependencias al construir (Sedes se agregan aparte).
     */
    public static Mundial ingresarMundial() {
        System.out.println("\n=== Ingreso de Mundial ===");
        int    anio       = leerEntero("  Año del Mundial          : ");
        String mascota    = leerTexto ("  Mascota                  : ");
        int    fechaDesde = leerEntero("  Año inicio (fecha desde) : ");
        int    fechaHasta = leerEntero("  Año fin   (fecha hasta)  : ");
        return new Mundial(anio, mascota, fechaDesde, fechaHasta);
    }
}



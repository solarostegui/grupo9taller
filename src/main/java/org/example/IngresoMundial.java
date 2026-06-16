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
public class IngresoMundial {
    
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
     //ESTO HAY Q VER SI LO DEJAMOS
    // CARGA DE DATOS DE EJEMPLO
    private static void cargarDemo() {
        System.out.println("\nCargando datos de demostración...");
        Main.setupDemoData();
    }
    
   
    // CREAR PAIS
    public static void crearPais() {
        System.out.println("\n--- NUEVO PAÍS ---");
        String nombre = pedirString("Nombre del país: ");
        String bandera = pedirString("Descripción de la bandera: ");
        Pais p = new Pais(nombre, bandera);
        main.paises.add(p);
        System.out.println("País '" + nombre + "' creado con éxito.");
    }
    
    // CREAR SEDE + ESTADIOS
    public static void crearSede() {
        if (Main.paises.isEmpty()) {
            System.out.println("Primero debe crear al menos un país.");
            return;
        }

        System.out.println("\n--- NUEVA SEDE ---");
        String ciudad =pedirString("Ciudad: ");
        float altura =pedirFloat("Altura sobre el nivel del mar: ");
        String clima =pedirString("Clima: ");
        String zona =pedirString("Zona horaria: ");

        System.out.println("Seleccione el país de la sede:");
        Pais pais = seleccionarPais();

        Sede sede = new Sede(ciudad, altura, clima, zona, pais);
        pais.agregarSede(sede);
        Main.sedes.add(sede);

        int cant = pedirEntero("¿Cuántos estadios tiene esta sede? ");
        for (int i = 0; i < cant; i++) {
            System.out.println("\nEstadio " + (i + 1) + " de " + cant);
            String nomEst =pedirString("Nombre del estadio: ");
            int cap =pedirEntero("Capacidad: ");
            Estadio e = new Estadio(nomEst, cap, sede);
            sede.agregarEstadio(e);
            Main.estadios.add(e);
            System.out.println("Estadio '" + nomEst + "' creado.");
        }
        System.out.println("Sede '" + ciudad + "' creada con " + cant + " estadio(s).");
    }

    // CREAR ARBITRO
    public static void crearArbitro() {
        if (Main.paises.isEmpty()) {
            System.out.println("Primero debe crear al menos un país.");
            return;
        }

        System.out.println("\n--- NUEVO ÁRBITRO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac =pedirEntero("Año de nacimiento (ej: 1985): ");
        int exp =pedirEntero("Años de experiencia: ");
        System.out.println("Seleccione el país del árbitro:");
        Pais pais = seleccionarPais();

        Arbitro a = new Arbitro(nombre, fecNac, exp, pais);
        pais.agregarArbitro(a);
        Main.arbitros.add(a);
        System.out.println("Árbitro '" + nombre + "' creado.");
    }
    
    
    // CREAR DIRECTOR TECNICO
    public static void crearDT() {
        System.out.println("\n--- NUEVO DIRECTOR TÉCNICO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac = pedirEntero("Año de nacimiento: ");
        int fecNomb = pedirEntero("Año de nombramiento: ");
        DirectorTecnico dt = new DirectorTecnico(nombre, fecNac, fecNomb);
        Main.dts.add(dt);
        System.out.println("DT '" + nombre + "' creado.");
    }

    // CREAR CUERPO TECNICO
    public static void crearCT() {
        System.out.println("\n--- NUEVO CUERPO TÉCNICO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac =pedirEntero("Año de nacimiento: ");
        TipoRol rol = IngresoEnum.elegirTipoRol();
        CuerpoTecnico ct = new CuerpoTecnico(nombre, fecNac, rol);
        Main.cts.add(ct);
        System.out.println("Cuerpo técnico '" + nombre + "' creado.");
    }
    
    // CREAR FASE
    public static void crearFase() {
        System.out.println("\n--- NUEVA FASE ---");
        TipoNombreFase nombre = IngresoEnum.elegirTipoNombreFase();
        Fase f = new Fase(nombre);
        Main.fases.add(f);
        System.out.println("Fase '" + nombre + "' creada.");
    }

    
    // CREAR GRUPO
    public static void crearGrupo() {
        if (Main.fases.isEmpty()) {
            System.out.println("Primero debe crear al menos una fase.");
            return;
        }
        System.out.println("\n--- NUEVO GRUPO ---");
        String id = pedirString("Identificación (ej: A): ");
        String desc = pedirString("Descripción (ej: Grupo A): ");
        System.out.println("Seleccione la fase:");
        Fase fase = seleccionarFase();
        Grupo g = new Grupo(id, desc, fase);
        fase.agregarGrupos(g);
        Main.grupos.add(g);
        System.out.println("Grupo '" + id + "' creado en fase " + fase.getNombreFase() + ".");
    }
    
    
    // CREAR JUGADOR
    public static void crearJugador() {
        System.out.println("\n--- NUEVO JUGADOR ---");
        String nombre = pedirString("Nombre: ");
        int fecNac = pedirEntero("Año de nacimiento: ");
        int dorsal = pedirEntero("Dorsal: ");
        TipoPosicion pos = IngresoEnum.elegirTipoPosicion();
        float peso = pedirFloat("Peso (kg, ej: 75.5): ");
        float altura = pedirFloat("Altura (m, ej: 1.80): ");

        Jugador j = new Jugador(nombre, fecNac, dorsal, pos, peso, altura);
        Main.jugadores.add(j);
        System.out.println("Jugador '" + nombre + "' creado.");
    }

    
    // CREAR SELECCION COMPLETA
    public static void crearSeleccion() {
        if (Main.paises.isEmpty() || Main.grupos.isEmpty()) {
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
        Pais pais = seleccionarPais();

        System.out.println("Seleccione el grupo:");
        Grupo grupo = seleccionarGrupo();

        DirectorTecnico dt = null;
        if (!Main.dts.isEmpty()) {
            System.out.println("Seleccione el Director Técnico (0 para saltar):");
            dt = seleccionarOpcional(Main.dts);
        }

        Seleccion s = new Seleccion(fed, camPpal, camSec, cabeza, ranking, pais, grupo);
        if (dt != null) s.agregarDirectoresTecnicos(dt);

        if (!Main.cts.isEmpty()) {
            System.out.print("¿Agregar cuerpo técnico? ");
            if (pedirBooleano("")) {
                for (CuerpoTecnico ct : Main.cts) {
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
            if (Main.jugadores.isEmpty()) {
                System.out.println("No hay jugadores creados. Cree uno primero.");
                break;
            }
            Jugador j = seleccionarJugador();
            s.agregarJugador(j);
            seguir = pedirBooleano("¿Agregar otro jugador?");
        } while (seguir);

        grupo.agregarSeleccion(s);
        Main.selecciones.add(s);
        System.out.println("Selección '" + fed + "' creada con éxito.");
    }
     // CREAR PARTIDO CON EVENTOS
    public static void crearPartido() {
        if (Main.selecciones.size() < 2 || Main.estadios.isEmpty() || Main.fases.isEmpty() || Main.arbitros.size() < 6) {
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
        Estadio estadio = seleccionarEstadio();

        System.out.println("Seleccione la fase:");
        Fase fase = seleccionarFase();

        Partido p = new Partido(fecha, horario, duracion, estadio, fase);

        System.out.println("\nSeleccione el Equipo A (designado local):");
        Seleccion s1 = seleccionarSeleccion();
        Participacion par1 = new Participacion(true, p, s1);
        p.setSeleccion1(par1);
        s1.agregarParticipacion(par1);

        System.out.println("Seleccione el Equipo B (designado visitante):");
        Seleccion s2;
        do {
            s2 = seleccionarSeleccion();
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
            Arbitro a = seleccionarArbitro();
            Arbitraje arb = new Arbitraje(rol, a, p);
            p.agregarArbitraje(arb);
            a.agregarArbitraje(arb);
        }

        estadio.agregarPartido(p);
        fase.agregarPartido(p);
        Main.partidos.add(p);

        boolean arbitrajeValido = Validador.validarArbitraje(p.getArbitraje());
        System.out.println("Equipo de arbitraje válido: " + (arbitrajeValido ? "SÍ" : "NO"));

        if (pedirBooleano("¿Desea registrar eventos ahora?")) {
            registrarEventos(p);
        }

        System.out.println("Partido creado con éxito.");
    }
    
     
    // REGISTRAR EVENTOS A PARTIDO EXISTENTE
    public static void registrarEventosPartido() {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos creados.");
            return;
        }
        System.out.println("Seleccione el partido:");
        Partido p = seleccionarPartido();
        if (p == null) return;
        registrarEventos(p);
    }

    //registra eventos en un partido ya creado
    public static void registrarEventos(Partido p) {
        System.out.println("\n--- Registro de eventos para el partido del " + p.getFecha() + " ---");
        boolean seguir;
        do {
            System.out.println("\nNuevo evento:");
            TipoEvento tipo = IngresoEnum.elegirTipoEvento();
            int min = pedirEntero("Minuto: ");

            Jugador j = null;
            if (tipo != TipoEvento.Sustitucion) {
                System.out.println("Jugador involucrado:");
                j = seleccionarJugador();
                if (j != null && !Validador.validarEvento(p, j)) {
                    System.out.println("¡ADVERTENCIA! El jugador no pertenece a ninguna de las dos selecciones.");
                }
            }

            p.agregarEvento(tipo, min, j);
            seguir = pedirBooleano("¿Agregar otro evento?");
        } while (seguir);

        System.out.println("Eventos registrados correctamente.\n");
    }

    
    // MOSTRAR REPORTES
    public static void mostrarTablaGrupo() {
        if (Main.grupos.isEmpty()) {
            System.out.println("No hay grupos creados.");
            return;
        }
        for (Grupo g : Main.grupos) {
            Estadisticas.mostrarTablaPosiciones(g);
        }
    }

    public static void mostrarFichaPartido() {
        if (Main.partidos.isEmpty()) {
            System.out.println("No hay partidos creados.");
            return;
        }
        System.out.println("Seleccione un partido:");
        Partido p = seleccionarPartido();
        Estadisticas.mostrarFichaTecnica(p);
    }

    public static void mostrarResultadosSeleccion() {
        if (Main.selecciones.isEmpty()) {
            System.out.println("No hay selecciones creadas.");
            return;
        }
        System.out.println("Seleccione una selección:");
        Seleccion s = seleccionarSeleccion();
        Estadisticas.mostrarResultadosSeleccion(s);
    }
    
    
    // SELECTORES GENÉRICOS
    private static Pais seleccionarPais()  { 
        return seleccionarDeLista(Main.paises, "país"); 
    }
    private static Estadio seleccionarEstadio() { 
        return seleccionarDeLista(Main.estadios, "estadio"); 
    }
    private static Grupo seleccionarGrupo() { 
        return seleccionarDeLista(Main.grupos, "grupo"); 
    }
    private static Fase seleccionarFase() { 
        return seleccionarDeLista(Main.fases, "fase"); 
    }
    private static Seleccion seleccionarSeleccion() { 
        return seleccionarDeLista(Main.selecciones, "selección"); 
    }
    private static Arbitro seleccionarArbitro() { 
        return seleccionarDeLista(Main.arbitros, "árbitro"); 
    }
    private static Partido seleccionarPartido() { 
        return seleccionarDeLista(Main.partidos, "partido"); 
    }
    private static Jugador seleccionarJugador() { 
        return seleccionarDeLista(Main.jugadores, "jugador"); 
    }

    private static <T> T seleccionarDeLista(List<T> lista, String nombreTipo) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay " + nombreTipo + "s disponibles.");
            return null;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(" " + i + " - " + lista.get(i));
        }
        int idx = pedirEnteroRango("Seleccione " + nombreTipo + " (0-" + (lista.size() - 1) + "): ",
                0, lista.size() - 1);
        return lista.get(idx);
    }

    private static <T> T seleccionarOpcional(List<T> lista) {
        if (lista == null || lista.isEmpty()) return null;
        System.out.println(" 0 - Saltar");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(" " + (i + 1) + " - " + lista.get(i));
        }
        int idx = pedirEnteroRango("Seleccione (0-" + lista.size() + "): ", 0, lista.size());
        return idx == 0 ? null : lista.get(idx - 1);
    }
}


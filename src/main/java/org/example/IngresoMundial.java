/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.*;
import java.time.*;

/**
 * Clase que gestiona la consola de entrada de datos para el sistema del Mundial.
 * Permite la creación de entidades como países, sedes, estadios, árbitros,
 * directores técnicos, fases, grupos, jugadores, selecciones y partidos.
 * @author María del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public class IngresoMundial{
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Solicita al usuario un número entero por consola, asegurando mediante un bucle
     * y captura de excepciones que el dato ingresado sea estrictamente válido.
     * @param mensaje El texto que se le muestra al usuario para solicitar el dato.
     * @return El número entero ingresado por el usuario.
     */
    public static int pedirEntero(String mensaje){
        while(true){
            try{
                System.out.print(mensaje);
                //trim elimina espacios en blanco de inicio y final
                int num = Integer.parseInt(sc.nextLine().trim()); 
                return num;
            }catch(NumberFormatException e){
                System.out.print("Dato inválido. Ingresá un número entero: ");
                
            }
        }
    }
     /**
     * Solicita un número flotante validando que no ocurran fallos de conversión.
     * Reemplaza las comas por puntos de ser necesario.
     * @param mensaje Texto explicativo que se imprime por consola.
     * @return El valor numérico de tipo float obtenido.
     */
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
    /**
     * Solicita y retorna una cadena de texto asegurándose de que no se encuentre vacía.
     * @param mensaje Mensaje guía para el ingreso de datos del usuario.
     * @return La cadena de caracteres limpia y validada.
     */
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
     /**
     * Solicita una confirmación booleana al usuario por consola a través del ingreso de
     * cadenas afirmativas o negativas (s/n, si/no, true/false).
     * @param mensaje Texto indicativo del requerimiento.
     * @return Verdadero (true) o falso (false) según la opción interpretada.
     */
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
    /**
     * Solicita un número entero que debe estar obligatoriamente acotado dentro de un rango numérico.
     * @param mensaje El texto instructivo para la consola.
     * @param min El valor entero mínimo aceptable.
     * @param max El valor entero máximo aceptable.
     * @return El entero validado dentro de los límites establecidos.
     */
    public static int pedirEnteroRango(String mensaje, int min, int max) {
        while (true) {
            int num = pedirEntero(mensaje);
            /*para evitar la excepcion de indice fuera de rango
            en el caso de los enum*/
            if (num >= min && num <= max) {
                return num;
            }
            System.out.println("Error: el valor debe estar entre " + min + " y " + max + ".");
        }
    }
    /**
     * Método inicializador que obliga al registro de los datos de la entidad Mundial.
     * @return El objeto Mundial instanciado con los valores correspondientes.
     */
    public Mundial ingresarMundial(){
        System.out.println("=================================================");
        System.out.println("  BIENVENIDO AL SISTEMA DE GESTIÓN DEL MUNDIAL   ");
        System.out.println("=================================================");
        System.out.println("\nAntes de comenzar, es obligatorio registrar el Mundial.");
    
        int anio = pedirEntero("Ingrese el año (ej: 2026): ");
        String mascota = pedirString("Ingrese la mascota: ");
    
        
        int fechaDesde = 0;
        int fechaHasta = 0;
    
        do {
            System.out.println("\n[Importante: Ingrese las fechas como números corridos sin barras ni guiones]");
            fechaDesde = pedirEntero("Fecha de inicio del Mundial (AAAAMMDD): ");
            fechaHasta = pedirEntero("Fecha de finalizacion del Mundial (AAAAMMDD): ");
        
            // Validación numérica: corroboramos que tengan 8 dígitos (ej: 20260615 es >= 10000000)
            if (fechaDesde < 10000000 || fechaHasta < 10000000) {
                System.out.println("Error: Formato incorrecto. Debe ingresar 8 números seguidos (Año, Mes y Día).");
            } 
            // Validación lógica: que el mundial no termine antes de empezar numéricamente
            else if (fechaHasta < fechaDesde) {
                System.out.println("Error: La fecha de finalización no puede ser menor a la fecha de inicio.");
            }
          
        } while (fechaDesde < 10000000 || fechaHasta < 10000000 || fechaHasta < fechaDesde);
    
        
        Mundial mundial = new Mundial(anio, mascota, fechaDesde, fechaHasta);
        System.out.println("Mundial " + anio + " creado con éxito.");
        return mundial;
    }
    /**
     * Crea un nuevo País controlando de manera previa que su nombre de identificación
     * no se encuentre ya almacenado de forma duplicada en el sistema.
     * @param paises Lista general de países registrados.
     */
    public void crearPais(List<Pais> paises) {
        System.out.println("\n--- NUEVO PAÍS ---");
        String nombre = pedirString("Nombre del país: ");
        for(Pais p:paises){
           if(p!=null && p.getNombre()!=null){
               if(p.getNombre().equalsIgnoreCase(nombre)){
                   System.out.println("Ese país ya fue ingresado.");
                   return;
                }
            }
        }
        String bandera = pedirString("Descripción de la bandera: ");
        Pais p = new Pais(nombre, bandera);
        
        paises.add(p);
        System.out.println("País '" + nombre + "' creado con éxito.");
    }
    
    /**
     * Genera un objeto Sede asociado a un país y, subsecuentemente, permite el registro
     * en lote de los Estadios vinculados físicamente a dicha localización geográfica.
     * @param paises Lista con los países dados de alta.
     * @param sedes Lista acumulativa con las sedes mundiales.
     * @param estadios Lista acumulativa donde se indexan los estadios.
     * @param mundial Instancia global del campeonato actual.
     */
    public void crearSede(List<Pais> paises, List<Sede> sedes, List<Estadio> estadios,Mundial mundial) {
        if (paises.isEmpty()) {
            System.out.println("Primero debe crear al menos un país.");
            return;
        }
        System.out.println("Seleccione el país de la sede:");
        
        Pais pais = seleccionarPais(paises);
        if (pais == null) {
            System.out.println("Debe volver a menu y crear el pais que desee primero");
            return;
        }

        System.out.println("\n--- NUEVA SEDE ---");
        String ciudad =pedirString("Ciudad: ");
        for(Sede s:sedes){
          if(s!=null && s.getCiudad()!=null){
              if(s.getCiudad().equalsIgnoreCase(ciudad)){
                   System.out.println("La sede ya fue ingresada");
                   return;
                }
        }   }
        float altura =pedirFloat("Altura sobre el nivel del mar: ");
        String clima =pedirString("Clima: ");
        String zona =pedirString("Zona horaria: ");

        Sede sede = new Sede(ciudad, altura, clima, zona, pais);
        if(pais.agregarSede(sede)){
            System.out.println("Se asigno correctamente la sede del pais " + pais.getNombre());
            sedes.add(sede);
        } else {
            System.out.println("La sede ya esta registrada en este pais");
        }
        
        if(mundial.agregarSede(sede)){
            System.out.println("Agregada correctamente la sede al mundial");
        } else {
            System.out.println("Esta sede ya forma parte del mundial");
        }

        int cant = pedirEntero("¿Cuántos estadios tiene esta sede? ");
        for (int i = 0; i < cant; i++) {
            System.out.println("\nEstadio " + (i + 1) + " de " + cant);
            String nomEst =pedirString("Nombre del estadio: ");
            int cap =pedirEntero("Capacidad: ");
            Estadio e = new Estadio(nomEst, cap, sede);
            if(sede.agregarEstadio(e)){
                estadios.add(e);
                System.out.println("Estadio '" + nomEst + "' creado y vinculado a la sede correctamente");
            } else {
                System.out.println("Ya existe un estadio llamado " + nomEst + "en la sede " + ciudad + ". No se pudo agregar" );
            }
        }
        System.out.println("Sede '" + ciudad + "' creada con " + cant + " estadio(s).");
    }

     /**
     * Construye y registra una entidad de tipo Árbitro, asociándolo al país de origen
     * correspondiente si este no se encuentra duplicado en los registros globales.
     * @param paises Repositorio de países activos.
     * @param arbitros Lista colectiva donde se anexan los profesionales del arbitraje.
     */
    public void crearArbitro(List<Pais> paises, List<Arbitro> arbitros) {
        if (paises.isEmpty()) {
            System.out.println("Primero debe crear al menos un país.");
            return;
        }
        
        System.out.println("Seleccione el país del árbitro:");
        Pais pais = seleccionarPais(paises);
        
        if (pais == null) {
            System.out.println("Debe volver a menu y crear el pais que desee primero");
            return;
        }
        
        System.out.println("\n--- NUEVO ÁRBITRO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac =pedirEntero("Año de nacimiento (ej: 1985): ");
        int exp =pedirEntero("Años de experiencia: ");
        
        Arbitro a = new Arbitro(nombre, fecNac, exp, pais);
        if(arbitros.contains(a)){
            System.out.println("EL arbitro ya se encuentra en la lista");
            return;
        }
        
        if(pais.agregarArbitro(a)){
            System.out.println("Se guardo correctamente el arbitro en " + pais.getNombre());
            arbitros.add(a);
            System.out.println("Árbitro '" + nombre + "' creado.");
        } else {
            System.out.println("Error: el arbitro ya se encuentra registrado en el pais " + pais.getNombre());
        }
    }
    
    /**
     * Genera un objeto DirectorTecnico mediante entradas de consola. Evita la
     * inserción si la entidad ya existe en la lista provista.
     * @param dts Repositorio de Directores Técnicos habilitados.
     */
    public void crearDT(List<DirectorTecnico> dts) {
        System.out.println("\n--- NUEVO DIRECTOR TÉCNICO ---");
        String nombre = pedirString("Nombre y Apellido: ");
        int fecNac = pedirEntero("Año de nacimiento: ");
        int fecNomb = pedirEntero("Año de nombramiento: ");
        DirectorTecnico dt = new DirectorTecnico(nombre, fecNac, fecNomb);
        if(dts.contains(dt)){
            System.out.println("El director tecnico ya se encuentra en la lista.");
            return;
        }
        dts.add(dt);
        System.out.println("DT " + dt.getNombre() + " creado.");
    }

    /**
     * Crea un objeto CuerpoTecnico permitiendo la selección dinámica de un rol específico,
     * controlando la no redundancia de datos.
     * @param cts Lista general del Staff o cuerpo técnico del torneo.
     */
    public void crearCT(List<CuerpoTecnico> cts) {
        System.out.println("\n--- NUEVO CUERPO TÉCNICO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac =pedirEntero("Año de nacimiento: ");
        TipoRol rol = IngresoEnum.elegirTipoRol();
        CuerpoTecnico ct = new CuerpoTecnico(nombre, fecNac, rol);
        if(cts.contains(ct)){
            System.out.println("El cuerpo tecnico ya se encuentra en la lista.");
            return;
        }
        cts.add(ct);
    }
    
    /**
     * Instancia y cataloga una nueva Fase de competición dentro de las opciones finitas
     * establecidas en el enumerador correspondiente del programa.
     * @param fases Lista que agrupa las fases.
     */    
    public void crearFase(List<Fase> fases) {
        System.out.println("\n--- NUEVA FASE ---");
        TipoNombreFase nombre =IngresoEnum.elegirTipoNombreFase();
        Fase fase = new Fase(nombre);
        for(Fase f:fases){
            if(f!=null && f.getNombreFase()!=null){
               if(f.getNombreFase().equals(nombre)){
                   System.out.println("La fase ya esta la lista");
                   return;
                }   
            }
        }
        fases.add(fase);
        System.out.println("Fase '" + nombre + "' creada.");
    }

    /**
     * Permite la adición de un Grupo competitivo vinculándolo directamente a una
     * de las fases preexistentes del sistema.
     * @param fases Lista de fases creadas.
     * @param grupos Lista en donde se almacenará el nuevo grupo.
     */
    public void crearGrupo(List<Fase> fases, List<Grupo> grupos) {
        if (fases.isEmpty()) {
            System.out.println("Primero debe crear al menos una fase.");
            return;
        }
        System.out.println("Seleccione la fase:");
        Fase fase = seleccionarFase(fases);
        if (fase == null) {
            System.out.println("Debe volver a menu y crear la fase que desee primero");
            return;
        }
        
        System.out.println("\n--- NUEVO GRUPO ---");
        String id = pedirString("Identificación (ej: A): ");
        for(Grupo g:grupos){
            if(g!=null && g.getIdentificacion()!=null){
                if(g.getIdentificacion().equalsIgnoreCase(id)){
                    System.out.println("El id ya fue registrado en un grupo");
                    return;
                }
            }
        }
        String desc = pedirString("Descripción (ej: Grupo A): ");
        
        
        Grupo grupo = new Grupo(id, desc, fase);
        
        fase.agregarGrupos(grupo);
        grupos.add(grupo);
        System.out.println("Grupo '" + id + "' creado en fase " + fase.getNombreFase() + ".");
    }
    
    /**
     * Genera el registro de un Jugador de campo parametrizando su peso, altura, dorsal
     * y puesto táctico predefinido.
     * @param jugadores Lista maestra en donde se insertará el deportista.
     */
    public void crearJugador(List<Jugador> jugadores) {
        System.out.println("\n--- NUEVO JUGADOR ---");
        String nombre = pedirString("Nombre: ");
        int fecNac = pedirEntero("Año de nacimiento: ");
        int dorsal = pedirEntero("Dorsal: ");
        TipoPosicion pos = IngresoEnum.elegirTipoPosicion();
        float peso = pedirFloat("Peso (kg, ej: 75.5): ");
        float altura = pedirFloat("Altura (m, ej: 1.80): ");
       
        Jugador j = new Jugador(nombre, fecNac, dorsal, pos, peso, altura);
        if(jugadores.contains(j)){
            System.out.println("Este jugador ya fue ingresado");
            return;
        }
        jugadores.add(j);
        System.out.println("Jugador '" + nombre + "' creado.");
    }

    
    /**
     * Ensambla una Selección de fútbol completa acoplándole un país de representación,
     * un grupo asignado, cuerpo técnico, directores técnicos y su plantilla de jugadores convocados.
     * @param grupos Lista conteniendo los grupos disponibles.
     * @param paises Lista de países para la vinculación .
     * @param dts Lista de entrenadores disponibles.
     * @param cts Lista de asistentes o auxiliares técnicos.
     * @param jugadores Listado global de los deportistas.
     * @param selecciones Lista de almacenamiento global de los equipos nacionales configurados.
     */
    public void crearSeleccion(List<Grupo> grupos,List<Pais> paises,List<DirectorTecnico> dts,List<CuerpoTecnico> cts,
    List<Jugador> jugadores, List<Seleccion> selecciones) {
        if (paises.isEmpty() || grupos.isEmpty()) {
            System.out.println("Primero debe crear al menos un país y un grupo.");
            return;
        }
        
        System.out.println("Seleccione el país:");
        Pais pais = seleccionarPais(paises);
        if (pais == null) {
            System.out.println("Debe volver a menu y crear el pais que desee primero");
            return;
        }
        
        System.out.println("Seleccione el grupo:");
        Grupo grupo = seleccionarGrupo(grupos);
        if (grupo == null) {
            System.out.println("Debe volver a menu y crear el grupo que desee primero");
            return;
        }

        System.out.println("\n--- NUEVA SELECCIÓN ---");
        String fed = pedirString("Nombre de la federación (ej: AFA): ");
        // --- VALIDACIÓN 1: Evitar que se duplique la Selección en la lista general ---
        for (Seleccion sel : selecciones) {
            if (sel.getNombreFederacion().equalsIgnoreCase(fed)) { 
                System.out.println("Error: Ya existe una selección registrada con la federación: " + fed);
                return;
            }
        }
        String camPpal = pedirString("Camiseta principal: ");
        String camSec = pedirString("Camiseta secundaria: ");
        int ranking =pedirEntero("Ranking FIFA: ");
        boolean cabeza = pedirBooleano("¿Es cabeza de grupo?");


        DirectorTecnico dt = null;
        if (!dts.isEmpty()) {
            System.out.println("Seleccione el Director Técnico :");
            dt = seleccionarDT(dts);
        }

        Seleccion s = new Seleccion(fed, camPpal, camSec, cabeza, ranking, pais, grupo);
        //chequeamos que se agregue la seleccion al pais
        if(!pais.setSeleccion(s)){
           System.out.println("Error: el país " + pais.getNombre() + " ya tiene una selección asignada. No se puede crear otra.");
           return;
        }
        System.out.println("La seleccion se asocio correctamente al pais ");
        // --- ASIGNACIÓN DE DT ---
        // Delegamos el control de duplicados directamente a tu método nativo
        if (dt != null) {
            boolean asignado = s.agregarDirectoresTecnicos(dt);
            if (!asignado) {
                System.out.println("El Director Técnico ya está asignado a esta selección.");
            }
        }

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
            if (j == null) {
                System.out.println("Debe volver a menu y crear todos los jugadores que desee primero");
                break;
            }
            
            //Controlamos que no exista en otra seleccion
            if(s.agregarJugador(j, selecciones)){
               System.out.println("Jugador " + j.getNombre() + " agregado con éxito");
            }else {
                System.out.println("Error: " + j.getNombre() + " ya pertenece a una selección o no es válido.");
            }
            seguir = pedirBooleano("¿Agregar otro jugador?");
        } while (seguir);

        if(grupo.agregarSeleccion(s)){
            System.out.println("Seleccion " + fed + "agregada al grupo " + grupo.getIdentificacion());
            selecciones.add(s);
        } else {
            System.out.println("La seleccion ya pertenece a un grupo");
        }
        
    }
    
    /**
     * Configura y agenda un nuevo Partido, determinando los planteles competidores (Local/Visitante),
     * fecha, horario, la terna y el equipo completo de arbitraje, asociándolo finalmente a su estadio y fase.
     * @param selecciones Lista global de selecciones.
     * @param estadios Lista global de estadios.
     * @param fases Lista general de fases.
     * @param arbitros Lista de árbitros inscriptos.
     * @param partidos Repositorio global de partidos agendados en el torneo.
     * @param jugadores Lista conteniendo todos los jugadores de la base de datos.
     */
    public void crearPartido(List<Seleccion> selecciones,List<Estadio> estadios,List<Fase> fases,List<Arbitro> arbitros,
    List<Partido> partidos, List<Jugador> jugadores) {
        if (selecciones.size() < 2 || estadios.isEmpty() ||fases.isEmpty() || arbitros.size() < 6) {
            System.out.println("Se necesitan: 2+ selecciones, 1+ estadio, 1+ fase, 6+ árbitros.");
            return;
        }
        
        System.out.println("Seleccione la fase:");
        Fase fase = seleccionarFase(fases);
        if (fase == null){
            System.out.println("Debe volver a menu y cargar las fases que desee primero");
            return;
        }
        
        System.out.println("\nSeleccione el Equipo A (designado local):");
        Seleccion s1 = seleccionarSeleccion(selecciones);
        if (s1 == null){
            System.out.println("Debe volver a menu y registar las selecciones que desee primero");
            return;
        }
        
        System.out.println("Seleccione el estadio:");
        Estadio estadio = seleccionarEstadio(estadios);
        if (estadio == null){
            System.out.println("Debe volver a menu y cargar los estadios que desee primero");
            return;
        }
        System.out.println("\n--- NUEVO PARTIDO ---");

        int dia =pedirEnteroRango("Día del partido (1-31): ",1,31);
        int mes = pedirEnteroRango("Mes (1-12): ",1,12);
        int anio = pedirEntero("Año (ej: 2026): ");
        LocalDate fecha = LocalDate.of(anio, mes, dia);

        int hora = pedirEntero("Hora (0-23): ");
        int minuto = pedirEntero("Minuto (0-59): ");
        LocalTime horario = LocalTime.of(hora, minuto);

        int duracion = pedirEntero("Duración (minutos, ej: 90): ");


        Partido p = new Partido();
        p.setFecha(fecha);
        p.setDuracion(duracion);
        p.setEstadio(estadio);
        p.setHorario(horario);
        p.setFase(fase);
        
        
        
        Participacion par1 = new Participacion(true, p, s1);
        p.setSeleccion1(par1);//el partido conoce a esta participacion puntual
        s1.agregarParticipacion(par1);//la seleccion conoce todas sus participaciones

        System.out.println("Seleccione el Equipo B (designado visitante):");
        Seleccion s2;
        do {
            s2 = seleccionarSeleccion(selecciones);
            if (s2 == null){
                System.out.println("Debe volver a menu y registar las selecciones que desee primero");
                return;
            }
            // --- VALIDACIÓN DE SELECCIONES DIFERENTES ---
            // Compara las referencias en memoria, el nombre de la federación y el país para blindar el sistema
            if (s2 == s1 || 
                s2.getNombreFederacion().equalsIgnoreCase(s1.getNombreFederacion()) || 
                s2.getPais().getNombre().equalsIgnoreCase(s1.getPais().getNombre())) {
                
                System.out.println("Error: El Equipo B debe ser una selección distinta al Equipo A (" + s1.getNombreFederacion() + ").");
                s2 = s1; // Forzamos a mantener el bucle activo para que vuelva a pedir la selección
            }
        } while (s2 == s1);
        Participacion par2 = new Participacion(false, p, s2);
        p.setSeleccion2(par2);
        s2.agregarParticipacion(par2);

        System.out.println("\n--- Arbitraje del partido ---");
        // --- NUEVA LISTA TEMPORAL: Para rastrear que no se repita el mismo árbitro físicamente en este partido ---
        List<Arbitro> arbitrosAsignados = new ArrayList<>();
        for (TipoCategoriaArbitro rol : TipoCategoriaArbitro.values()) {
            Arbitro a;
            boolean arbitroRepetido;
            do {
                arbitroRepetido = false;
                System.out.println("Seleccione el " + rol + ":");
                a = seleccionarArbitro(arbitros);
                if (a == null){
                    System.out.println("Debe volver a menu y seleccionar todos los arbitros primero");
                    return;
                }
                
                // --- VALIDACIÓN 1: Comprobar si el árbitro ya fue asignado en otra categoría del partido ---
                if (arbitrosAsignados.contains(a)) {
                    System.out.println("El árbitro " + a.getNombre() + " ya tiene un rol asignado en este partido. Seleccione otro.");
                    arbitroRepetido = true;
                }
            } while (arbitroRepetido);
            arbitrosAsignados.add(a); // Se marca como ocupado para las siguientes iteraciones
            
            Arbitraje arb = new Arbitraje(rol, a, p);
            p.agregarArbitraje(arb);//el partido sabe quienes lo arbitran
            a.agregarArbitraje(arb);//el arbitro sabe en que partidos arbitro
        }
        //Validador de arbitraje si no esta completo 
        if(!Validador.validarArbitraje(p.getArbitraje())){
            System.out.println("El equipo de arbitraje no es valido o está incompleto");
            return;
        }
        System.out.println("Equipo de arbitraje válido: SÍ");

        if(estadio.agregarPartido(p)){//el estadio sabe que partidos se jugaron ahi
            System.out.println("Partido asociado al estadio " + estadio.getNombre() + " con éxito.");
        } else {
            System.out.println("Advertencia: El partido ya estaba registrado en este estadio.");
        }
        if(fase.agregarPartido(p)){//la fase sabe que partidos le pertenecen
            System.out.println("Partido agendado en la fase " + fase.getNombreFase() + " con éxito.");
        } else {
            System.out.println("Advertencia: El partido ya pertenecía a esta fase.");
        }
        
        // --- VALIDACIÓN 2: Evitar guardar un duplicado exacto del objeto partido en la lista general ---
        if (!partidos.contains(p)) {
            partidos.add(p);
        } else {
            System.out.println("El partido ya se encontraba en el registro global.");
        }

        if (pedirBooleano("¿Desea registrar eventos ahora?")) {
            registrarEventos(p, jugadores);
            } else {
                System.out.println("\nEl partido se guardó como 'Programado'.");
        }
        System.out.println("Partido creado con éxito.");
    }
    
    /**
     * Metodo intermedia que permite la búsqueda de un partido preexistente
     * para inicializar la carga manual de eventos (goles, tarjetas, etc.).
     * @param partidos Lista con los partidos guardados en el sistema.
     * @param jugadores Lista de jugadores aptos para vinculación en eventos.
     */
    public void registrarEventosPartido(List<Partido> partidos, List<Jugador> jugadores) {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos creados.");
            return;
        }
        System.out.println("Seleccione el partido:");
        Partido p = seleccionarPartido(partidos);
        if (p == null) return;
        registrarEventos(p,jugadores);
        
        if (p.getFase() != null && p.getFase().getNombreFase() == TipoNombreFase.Grupos) {
            System.out.println("Estadisticas del grupo actualizadas");
        } else {
            System.out.println("Partido de eliminación directa registrado");
        }
    }
    
    /**
     * Registra de manera iterativa los eventos ocurridos dentro de los 90 minutos reglamentarios.
     * Valida mediante lógica del negocio que los jugadores asociados pertenezcan efectivamente
     * a las selecciones implicadas en el cotejo.
     * @param p El partido activo sobre el cual se asientan las incidencias.
     * @param jugadores Lista total de futbolistas habilitados para ser seleccionados.
     */
    public void registrarEventos(Partido p, List<Jugador> jugadores) {
        System.out.println("\n--- Registro de eventos para el partido del " + p.getFecha() + " ---");
        
        while(true) {
            System.out.println("\nNuevo evento:");
            TipoEvento tipo = IngresoEnum.elegirTipoEvento();
            int min = pedirEntero("Minuto: ");
            System.out.println("Jugador involucrado: ");
            Jugador j = seleccionarJugador(jugadores);
            
            if(!p.agregarEvento(tipo, min, j)){
               System.out.println("El jugador no pertenece a ninguna de las dos selecciones. Evento no registrado.");
            }
            if(!pedirBooleano("¿Agregar otro evento?")){
               break;
            }  
        }
        System.out.println("Eventos registrados correctamente.\n");
    }
    
    /**
     * Despliega en consola el listado iterable de Países para la selección del usuario.
     * @param paises Lista de países.
     * @return El objeto Pais seleccionado, o null si decide volver al menú.
     */
    public Pais seleccionarPais(List<Pais> paises) {
       
        for (int i = 0; i < paises.size(); i++){
          System.out.println(" " + i + " - " + paises.get(i));
        }
       
        System.out.println(" " + paises.size() + " - [Volver al menú para crear nuevo país]");
       
        int opcion = pedirEnteroRango("Seleccione: ", 0, paises.size());
       
        if (opcion == paises.size()) {
          System.out.println("Volviendo al menú...");
          return null;
        }
        return paises.get(opcion);
    }
    /**
     * Despliega en consola el listado iterable de Sedes para la selección del usuario.
     * @param sedes Lista de sedes.
     * @return El objeto Sede seleccionado, o null si decide volver al menú.
     */
    public Sede seleccionarSede(List<Sede> sedes) {
        
        for (int i = 0; i < sedes.size(); i++){
          System.out.println(" " + i + " - " + sedes.get(i));
        }
        
        System.out.println(" " + sedes.size() + " - [Volver al menú para crear nueva sede]");
        int opcion = pedirEnteroRango("Seleccione: ", 0, sedes.size());
       
        if (opcion == sedes.size()) {
            System.out.println("Volviendo al menú...");
            return null;
        }
        return sedes.get(opcion);
    }
    /**
     * Despliega en consola el listado iterable de Estadios para la selección del usuario.
     * @param estadios Lista de estadios.
     * @return El objeto Estadio seleccionado, o null si decide volver al menú.
     */
    public Estadio seleccionarEstadio(List<Estadio> estadios) {
        for (int i = 0; i < estadios.size(); i++){
          System.out.println(" " + i + " - " + estadios.get(i));
        }
        
        System.out.println(" " + estadios.size() + " - [Volver al menú para crear nuevo estadio]");
        int opcion = pedirEnteroRango("Seleccione: ", 0, estadios.size());
        
        if (opcion == estadios.size()) {
           System.out.println("Volviendo al menú...");
           return null;
        }
       return estadios.get(opcion);
    }
    /**
     * Despliega en consola el listado iterable de Grupos para la selección del usuario.
     * @param grupos Lista de grupos competitivos.
     * @return El objeto Grupo seleccionado, o null si decide volver al menú.
     */
    public Grupo seleccionarGrupo(List<Grupo> grupos) {
    
        for (int i = 0; i < grupos.size(); i++){
          System.out.println(" " + i + " - " + grupos.get(i));
        }
     
        System.out.println(" " + grupos.size() + " - [Volver al menú para crear nuevo grupo]");
    
        int opcion = pedirEnteroRango("Seleccione: ", 0, grupos.size());
    
        if (opcion == grupos.size()) {
        
            System.out.println("Volviendo al menú...");
            return null;
        }
        return grupos.get(opcion);
    }
     /**
     * Despliega en consola el listado iterable de Fases para la selección del usuario.
     * @param fases Lista de fases.
     * @return El objeto Fase seleccionado, o null si decide volver al menú.
     */
    public Fase seleccionarFase(List<Fase> fases) {
    
        for (int i = 0; i < fases.size(); i++){
           System.out.println(" " + i + " - " + fases.get(i));
        }
        
        System.out.println(" " + fases.size() + " - [Volver al menú para crear nueva fase]");
        int opcion = pedirEnteroRango("Seleccione: ", 0, fases.size());
    
        if (opcion == fases.size()) {
            System.out.println("Volviendo al menú...");
            return null;
        }
        return fases.get(opcion);
    }
    /**
     * Despliega en consola el listado iterable de Selecciones para la selección del usuario.
     * @param selecciones Lista de combinados nacionales.
     * @return El objeto Seleccion elegido, o null si decide retornar al menú.
     */
    public Seleccion seleccionarSeleccion(List<Seleccion> selecciones) {
       
        for (int i = 0; i < selecciones.size(); i++){
            System.out.println(" " + i + " - " + selecciones.get(i));
        }
       
       System.out.println(" " + selecciones.size() + " - [Volver al menú para crear nueva selección]");
       
       int opcion = pedirEnteroRango("Seleccione: ", 0, selecciones.size());
       
       if (opcion == selecciones.size()) {
          System.out.println("Volviendo al menú...");
          return null;
        }
       return selecciones.get(opcion);
    }
     /**
     * Despliega en consola el listado iterable de Árbitros de la plantilla.
     * @param arbitros Lista de colegiados.
     * @return El objeto Arbitro seleccionado, o null si opta por volver al menú principal.
     */
    public Arbitro seleccionarArbitro(List<Arbitro> arbitros) {
        
        for (int i = 0; i < arbitros.size(); i++){
           System.out.println(" " + i + " - " + arbitros.get(i));
        }
        
        System.out.println(" " + arbitros.size() + " - [Volver al menú para crear nuevo árbitro]");
        
        int opcion = pedirEnteroRango("Seleccione: ", 0, arbitros.size());
        
        if (opcion == arbitros.size()) {
            System.out.println("Volviendo al menú...");
            return null;
        }
        return arbitros.get(opcion);
    }
     /**
     * Despliega en consola el listado de Partidos agendados.
     * @param partidos Lista de partidos.
     * @return El objeto Partido elegido, o null si se cancela la operación.
     */
    public Partido seleccionarPartido(List<Partido> partidos) {
    
        for (int i = 0; i < partidos.size(); i++){
           System.out.println(" " + i + " - " + partidos.get(i));
        }
        
        System.out.println(" " + partidos.size() + " - [Volver al menú para crear nuevo partido]");
        int opcion = pedirEnteroRango("Seleccione: ", 0, partidos.size());
    
        if (opcion == partidos.size()) {
           System.out.println("Volviendo al menú...");
           return null;
        }
        return partidos.get(opcion);
    }
     /**
     * Despliega en consola el listado completo de todos los Jugadores del torneo.
     * @param jugadores Lista general de futbolistas.
     * @return El objeto Jugador seleccionado, o null si se interrumpe la selección.
     */
    public Jugador seleccionarJugador(List<Jugador> jugadores) {
    
        for (int i = 0; i < jugadores.size(); i++){
           System.out.println(" " + i + " - " + jugadores.get(i).toString());
        }
    
        System.out.println(" " + jugadores.size() + " - [Volver al menú para crear nuevo jugador]");
    
        int opcion = pedirEnteroRango("Seleccione: ", 0, jugadores.size());
    
        if (opcion == jugadores.size()) {
           System.out.println("Volviendo al menú...");
            return null;
    
        }
        return jugadores.get(opcion);
    }
     /**
     * Despliega en consola los Directores Técnicos registrados.
     * @param dts Lista de DTs.
     * @return El objeto DirectorTecnico seleccionado, o null si vuelve atrás.
     */
    public DirectorTecnico seleccionarDT(List<DirectorTecnico> dts) {
    
        for (int i = 0; i < dts.size(); i++){
        
            System.out.println(" " + i + " - " + dts.get(i).toString());
        }
    
        System.out.println(" " + dts.size() + " - [Volver al menú para crear nuevo DT]");
    
        int opcion = pedirEnteroRango("Seleccione: ", 0, dts.size());
    
        if (opcion == dts.size()) {
            System.out.println("Volviendo al menú...");
            return null;
        }
        return dts.get(opcion);
    }
    /**
     * Despliega en consola los auxiliares técnicos o miembros del staff registrados.
     * @param cts Lista del Cuerpo Técnico global.
     * @return El objeto CuerpoTecnico seleccionado, o null si decide volver al menú.
     */
    public CuerpoTecnico seleccionarCT(List<CuerpoTecnico> cts) {
    
        for (int i = 0; i < cts.size(); i++){
            System.out.println(" " + i + " - " + cts.get(i).toString());
        }
    
        System.out.println(" " + cts.size() + " - [Volver al menú para crear nuevo cuerpo técnico]");
   
        int opcion = pedirEnteroRango("Seleccione: ", 0, cts.size());
    
        if (opcion == cts.size()) {
            System.out.println("Volviendo al menú...");
            return null;
        }
        return cts.get(opcion);
    }
}


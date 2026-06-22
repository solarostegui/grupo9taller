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
                //trim elimina espacios en blanco de inicio y final
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
            /*para evitar la excepcion de indice fuera de rango
            en el caso de los enum*/
            if (num >= min && num <= max) {
                return num;
            }
            System.out.println("Error: el valor debe estar entre " + min + " y " + max + ".");
        }
    }
    //Ingreso de la clase mundial
    public Mundial ingresarMundial(){
        System.out.println("=================================================");
        System.out.println("  BIENVENIDO AL SISTEMA DE GESTIÓN DEL MUNDIAL   ");
        System.out.println("=================================================");
        System.out.println("\nAntes de comenzar, es obligatorio registrar el Mundial.");
        
        int anio = pedirEntero("Ingrese el año: ");

        String mascota =pedirString("Ingrese la mascota: ");
        
        int fechaDesde = pedirEntero(" Año de inicio del Mundial: ");
        int fechaHasta = pedirEntero(" Año de finalizacion del Mundial: ");
        
        Mundial mundial= new Mundial(anio, mascota, fechaDesde, fechaHasta);
        System.out.println("Mundial " + anio + " creado con éxito.");
        return mundial;
        
    }
    // CREAR PAIS
    public void crearPais(List<Pais> paises) {
        System.out.println("\n--- NUEVO PAÍS ---");
        String nombre = pedirString("Nombre del país: ");
        String bandera = pedirString("Descripción de la bandera: ");
        Pais p = new Pais(nombre, bandera);
        paises.add(p);
        System.out.println("País '" + nombre + "' creado con éxito.");
    }
    
    // CREAR SEDE + ESTADIOS
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

    // CREAR ARBITRO
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
        
        if(pais.agregarArbitro(a)){
            System.out.println("Se guardo correctamente el arbitro en " + pais.getNombre());
            arbitros.add(a);
            System.out.println("Árbitro '" + nombre + "' creado.");
        } else {
            System.out.println("Error: el arbitro ya se encuentra registrado en el pais " + pais.getNombre());
        }
    }
    
    // CREAR DIRECTOR TECNICO
    public void crearDT(List<DirectorTecnico> dts) {
        System.out.println("\n--- NUEVO DIRECTOR TÉCNICO ---");
        String nombre = pedirString("Nombre y Apellido: ");
        int fecNac = pedirEntero("Año de nacimiento: ");
        int fecNomb = pedirEntero("Año de nombramiento: ");
        DirectorTecnico dt = new DirectorTecnico(nombre, fecNac, fecNomb);
        if (dts.add(dt)){
            System.out.println("DT " + dt.getNombre() + " creado.");
        } else {
            System.out.println("Error: no se pudo agregar el director tecnico");
        }
        
    }

    // CREAR CUERPO TECNICO
    public void crearCT(List<CuerpoTecnico> cts) {
        System.out.println("\n--- NUEVO CUERPO TÉCNICO ---");
        String nombre = pedirString("Nombre: ");
        int fecNac =pedirEntero("Año de nacimiento: ");
        TipoRol rol = IngresoEnum.elegirTipoRol();
        CuerpoTecnico ct = new CuerpoTecnico(nombre, fecNac, rol);
        if(cts.add(ct)){
            System.out.println("Cuerpo técnico '" + ct.getNombre() + "' creado.");
        } else {
            System.out.println("Error: no se pudo agregar el cuerpo tecnico");
        }   
    }
    
    // CREAR FASE
    public void crearFase(List<Fase> fases) {
        System.out.println("\n--- NUEVA FASE ---");
        TipoNombreFase nombre =IngresoEnum.elegirTipoNombreFase();
        Fase f = new Fase(nombre);
        fases.add(f);
        System.out.println("Fase '" + nombre + "' creada.");
    }

    
    // CREAR GRUPO
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
        String desc = pedirString("Descripción (ej: Grupo A): ");
        
        
        Grupo g = new Grupo(id, desc, fase);
        fase.agregarGrupos(g);
        grupos.add(g);
        System.out.println("Grupo '" + id + "' creado en fase " + fase.getNombreFase() + ".");
    }
    
    
    // CREAR JUGADOR
    public void crearJugador(List<Jugador> jugadores) {
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
        String camPpal = pedirString("Camiseta principal: ");
        String camSec = pedirString("Camiseta secundaria: ");
        int ranking =pedirEntero("Ranking FIFA: ");
        boolean cabeza = pedirBooleano("¿Es cabeza de grupo?");


        DirectorTecnico dt = null;
        if (!dts.isEmpty()) {
            System.out.println("Seleccione el Director Técnico (0 para saltar):");
            dt = seleccionarDT(dts);
        }

        Seleccion s = new Seleccion(fed, camPpal, camSec, cabeza, ranking, pais, grupo);
        //chequeamos que se agregue la seleccion al pais
        if(pais.setSeleccion(s)){
            System.out.println("La seleccion se asocio correctamente al pais ");
            
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
            boolean yaTieneSeleccion = false;
            for (Seleccion selExistente : selecciones){
                if(selExistente.getJugador() != null && selExistente.getJugador().contains(j)){
                    yaTieneSeleccion = true;
                    break;
                }
            }
            if(yaTieneSeleccion){
                System.out.println("El jugador " + j.getNombre() + " ya pertenece a una seleccion");
            } else {
                //Verificamos con el metodo agregarjugador si ya esta en la seleccion
                if(s.agregarJugador(j)){
                System.out.println("Jugador " + j.getNombre() + " agregado con éxito");
                } else {   //pusimos 2 veces null acomodar
                    System.out.println("Error: El jugador " + (j != null ? j.getNombre() : "") + " no es válido o ya pertenece a esta selección.");
                }
            }
            seguir = pedirBooleano("¿Agregar otro jugador?");
        } while (seguir);

        if(grupo.agregarSeleccion(s)){
            System.out.println("Seleccion " + fed + "agregada al grupo " + grupo.getIdentificacion());
        } else {
            System.out.println("La seleccion ya pertenece a un grupo");
        }
        selecciones.add(s);
    }
    
    // Método auxiliar que recalcula TODA la tabla del grupo desde cero,
   // leyendo el estado actual de los eventos. Así es seguro llamarlo
  // las veces que sea necesario, incluso si se agregan eventos después.
   public void actualizarEstadisticasPorPartido(Partido p, List<Partido> partidos) {
       if (p == null || p.getSeleccion1() == null || p.getSeleccion2() == null) return;
       Seleccion s1 = p.getSeleccion1().getSeleccion();
       Seleccion s2 = p.getSeleccion2().getSeleccion();
       if (s1 == null || s2 == null) return;

       Grupo grupoDelPartido = s1.getGrupo();
       if (grupoDelPartido == null || grupoDelPartido.getTablaEstadisticas() == null) return;

       // 1. Reseteamos TODAS las fichas del grupo (no solo las de este partido)
       for (Estadistica est : grupoDelPartido.getTablaEstadisticas()) {
           if (est != null) {
              est.restablecer();
            }
        } 

       // 2. Recorremos TODOS los partidos del Mundial.
       if (partidos != null) {
        for (Partido partidoDelGrupo : partidos) {
            if (partidoDelGrupo == null || partidoDelGrupo.getFase() == null) continue;
            if (partidoDelGrupo.getFase().getNombreFase() != TipoNombreFase.Grupos) continue;
            if (partidoDelGrupo.getSeleccion1() == null || partidoDelGrupo.getSeleccion2() == null) continue;

            Seleccion sa = partidoDelGrupo.getSeleccion1().getSeleccion();
            Seleccion sb = partidoDelGrupo.getSeleccion2().getSeleccion();
            if (sa == null || sb == null) continue;

            // Solo nos interesan los partidos cuyas dos selecciones son de ESTE grupo
            if (sa.getGrupo() != grupoDelPartido || sb.getGrupo() != grupoDelPartido) continue;

            Estadistica estA = null;
            Estadistica estB = null;
            for (Estadistica est : grupoDelPartido.getTablaEstadisticas()) {
                if (est != null) {
                    if (est.getSeleccion() == sa) estA = est;
                    if (est.getSeleccion() == sb) estB = est;
                }
            }
            if (estA == null || estB == null) continue;

            int golesA = 0;
            int golesB = 0;
            if (partidoDelGrupo.getEventos() != null) {
                for (Evento e : partidoDelGrupo.getEventos()) {
                    if (e != null && e.getEvento() == TipoEvento.Gol && e.getJugador() != null) {
                        if (sa.getJugador() != null && sa.getJugador().contains(e.getJugador())) {
                            golesA++;
                        } else if (sb.getJugador() != null && sb.getJugador().contains(e.getJugador())) {
                            golesB++;
                        }
                    }
                }
            }
            estA.computarPartido(golesA, golesB);
            estB.computarPartido(golesB, golesA);
        }
    }

      System.out.println("\nTabla del grupo " + grupoDelPartido.getIdentificacion() + " recalculada y actualizada.");
    }
     // CREAR PARTIDO CON EVENTOS
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

        int dia =pedirEntero("Día del partido (1-31): ");
        int mes = pedirEntero("Mes (1-12): ");
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
            if (a == null){
                System.out.println("Debe volver a menu y seleccionar todos los arbitros primero");
                return;
            }
            Arbitraje arb = new Arbitraje(rol, a, p);
            p.agregarArbitraje(arb);//el partido sabe quienes lo arbitran
            a.agregarArbitraje(arb);//el arbitro sabe en que partidos arbitro
        }
        //Validador de arbitraje si no esta completo 
        if(!Validador.validarArbitraje(p.getArbitraje())){
            System.out.println("El equipo de arbitraje no es valido o está incompleto");
            return;
        }

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
        
        partidos.add(p);
        System.out.println("Equipo de arbitraje válido: SÍ");

        if (pedirBooleano("¿Desea registrar eventos ahora?")) {
            registrarEventos(p, jugadores);
            //VALIDA SI LA FASE ES GRUPO PARA SUMAR LOS PUNTOS CCORRESPONDIENTES
            if(p.getFase().getNombreFase() == TipoNombreFase.Grupos){
               
              actualizarEstadisticasPorPartido(p, partidos); // <- ahora pasa "partidos" también
              System.out.println("Estadisticas del grupo actualizadas");

            } else {
                System.out.println("Partido de eliminación directa registrado");
            }
        } else {
            System.out.println("\nEl partido se guardó como 'Programado'. Las estadísticas se actualizarán cuando registres sus eventos.");
        }
        System.out.println("Partido creado con éxito.");
    }
    
     
    // REGISTRAR EVENTOS A PARTIDO EXISTENTE
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
            actualizarEstadisticasPorPartido(p, partidos);
            System.out.println("Estadisticas del grupo actualizadas");
        } else {
            System.out.println("Partido de eliminación directa registrado");
        }
    }

    //registra eventos en un partido ya creado
    //este es un metodo para crear los eventos llamado desde registar evento de un partido y crear partido
    public void registrarEventos(Partido p, List<Jugador> jugadores) {
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
    
    /*FLUJO: Main→ menú → crearPartido() → seleccionarEstadio() → devuelve Estadio → sigue crearPartido()
    // ─── SELECTORES POR TIPO ──────────────────────────────────────────────────
    /*estos metodos se usan para que el usuario elija lo que ya se cargo en la lista
    y no tener que volver a cargar todos los datos nuevamente o puede
    volver al menu y crear un objeto si no esta en lista todavia*/
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

    public Jugador seleccionarJugador(List<Jugador> jugadores) {
    
        for (int i = 0; i < jugadores.size(); i++){
           System.out.println(" " + i + " - " + jugadores.get(i));
        }
    
        System.out.println(" " + jugadores.size() + " - [Volver al menú para crear nuevo jugador]");
    
        int opcion = pedirEnteroRango("Seleccione: ", 0, jugadores.size());
    
        if (opcion == jugadores.size()) {
           System.out.println("Volviendo al menú...");
            return null;
    
        }
        return jugadores.get(opcion);
    }

    public DirectorTecnico seleccionarDT(List<DirectorTecnico> dts) {
    
        for (int i = 0; i < dts.size(); i++){
        
            System.out.println(" " + i + " - " + dts.get(i));
        }
    
        System.out.println(" " + dts.size() + " - [Volver al menú para crear nuevo DT]");
    
        int opcion = pedirEnteroRango("Seleccione: ", 0, dts.size());
    
        if (opcion == dts.size()) {
            System.out.println("Volviendo al menú...");
            return null;
        }
        return dts.get(opcion);
    }

    public CuerpoTecnico seleccionarCT(List<CuerpoTecnico> cts) {
    
        for (int i = 0; i < cts.size(); i++){
            System.out.println(" " + i + " - " + cts.get(i));
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


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
    
    //------------------------
    /**Metodos de validacion*
     */
    //-------------------------
    
    // Este método se encarga de que el input sea SIEMPRE entero
    public static int pedirEntero(){
        while(true){
            try{
                int num = sc.nextInt();
                sc.nextLine(); // limpia el Enter
                return num;
            }catch(Exception e){
                System.out.print("Dato inválido. Ingresá un número entero: ");
                sc.nextLine(); // limpia lo que escribió mal
            }
        }
    }
    //este metodo se encarga de que el input sea un numero
    public static float pedirFloat(){
        while(true){
            try{
                float num = sc.nextFloat();
                sc.nextLine(); // limpia el Enter
                return num;
            }catch(Exception e){
                System.out.print("Dato inválido. Ingresá un número: ");
                sc.nextLine(); // limpia lo que escribió mal
            }
        }
    }
    //este metodo se encarga de que el input de string no sea solo espacios
    public static String pedirStringsinespacios(){
      while(true){
             String texto = sc.nextLine().trim();//saca todos los espacios del principio y del final
             //valida que no se vacio -> cubre el caso de solo espacio
            if(!texto.isEmpty()){
              return texto;
            }else{
              System.out.print("Dato inválido. Ingresá algo que no sea solo espacios: ");
            }
        }
    }
    //este metodo se encarga de que el input de boolean sea correcto
    public static boolean pedirBooleano() {
    
    while (true) {
        System.out.print(" (true/false): ");
        String entrada = sc.nextLine().trim().toLowerCase();
        if (entrada.equals("true") || entrada.equals("false")) {
            return Boolean.parseBoolean(entrada);
        }
        System.out.println("Valor inválido. Ingrese true o false.");
    }
   }
    
    
     //(1) Ingreso de la clase mundial
    public static Mundial ingresarMundial(){
        System.out.println("\n=== Ingreso de Mundial ===");
        
        System.out.print(" Año del Mundial : ");
        int anio = pedirEntero();

        System.out.print(" Mascota : ");
        String mascota =pedirStringsinespacios();

        System.out.print(" Fecha inicio (num/año) : ");
        int fechaDesde = pedirEntero();

        System.out.print(" Fecha fin (num/año) : ");
        int fechaHasta = pedirEntero();
        Mundial mundial= new Mundial(anio, mascota, fechaDesde, fechaHasta);
        
        System.out.println("Cuantas sedes tiene este mundial? ");
        int n=pedirEntero();
        for(int i=0;i<n;i++){
           System.out.println("Sede "+(i+1)+"de "+n);
           Sede sede=ingresarSede();
           mundial.agregarSede(sede);
        }
        return mundial;
    }
    
    //(2)Ingreso de la clase sedes y estadios
    public static Sede ingresarSede(){
        System.out.println("\n=== Ingreso de Sede ===");
        
        System.out.print(" Ciudad : ");
        String ciudad = pedirStringsinespacios();

        System.out.print(" Altura nivel mar : ");
        float altura = pedirFloat();

        System.out.print(" Clima : ");
        String clima = pedirStringsinespacios();

        System.out.print(" Zona horaria : ");
        String zona = pedirStringsinespacios();

        System.out.println(" Seleccioná el país de esta sede:");
        Pais pais = ingresarPais();

        Sede s = new Sede(ciudad, altura, clima, zona, pais);

        System.out.print(" ¿Cuántos estadios tiene esta sede? : ");
        int cant = pedirEntero();
        
        for(int i = 0; i < cant; i++){
            System.out.println("\nEstadio " + i + " de " + cant);
            Estadio e = ingresarEstadio(s);
            s.agregarEstadio(e);
        }

        return s;
    }
    
    public static Estadio ingresarEstadio(Sede sede){
        System.out.println("\n=== Ingreso de Estadio ===");
        
        System.out.print(" Nombre del estadio : ");
        String nombre = pedirStringsinespacios();

        System.out.print(" Capacidad : ");
        int capacidad = pedirEntero();
        
        Estadio estadio=new Estadio(nombre, capacidad,sede);
        
        System.out.println("Cuantos partidos tiene este estadio? ");
        int n=pedirEntero();
        for(int i=0;i<n;i++){
           System.out.println("\nPartido " + (i+1) + " de " + n);
           Partido partido=ingresarPartido();
           estadio.agregarPartido(partido);
        }

        return estadio;
    }
    
    public static Pais ingresarPais(){
        System.out.println("\n=== Ingreso de País ===");
        
        System.out.print(" Nombre del país : ");
        String nombre = pedirStringsinespacios();

        System.out.print(" Bandera : ");
        String bandera = pedirStringsinespacios();
        
        Pais p = new Pais();
        p.setNombre(nombre);
        p.setBandera(bandera);

        System.out.println(" Ingresá la selección de este país:");
        Seleccion seleccion = ingresarSeleccion(p);

        p.setSeleccion(seleccion);
        

        // Ingreso de sedes del país
        System.out.print(" ¿Cuántas sedes tiene este país? : ");
        int cantSedes = pedirEntero();
        for(int i = 1; i <= cantSedes; i++){
            System.out.println("\nSede " + i + " de " + cantSedes);
            Sede s = ingresarSede();
            p.agregarSede(s);
        }
        System.out.print(" ¿Cuántos arbitros tiene este pais? :");
        int n=pedirEntero();
        for(int i = 1; i <=n; i++){
             System.out.println("\nArbitro " + i + " de " + n);
             Arbitro a=ingresarArbitro(p);
             p.agregarArbitro(a);
        }
        
        return p;
    }
    
    public static Partido ingresarPartido(){
        System.out.println("\n=== Ingreso de Partido ===");
        
        // Fecha: pedimos día mes año y armamos Date
        System.out.print(" Día del partido : ");
        int dia = pedirEntero();
        System.out.print(" Mes del partido : ");
        int mes = pedirEntero();
        System.out.print(" Año del partido : ");
        int anio =pedirEntero();
        
        Calendar cal = Calendar.getInstance();
        cal.set(anio, mes-1, dia, 0, 0, 0);
        Date fecha = cal.getTime();

        // Horario: pedimos hora y minuto y armamos Clock
        System.out.print(" Hora del partido : ");
        int hora = pedirEntero();
        System.out.print(" Minuto del partido : ");
        int minuto = pedirEntero();
        Clock horario = Clock.fixed(
            cal.toInstant().plusSeconds(hora*3600 + minuto*60), 
            ZoneId.systemDefault()
        );

        System.out.print(" Duración en minutos : ");
        int duracion = pedirEntero();

        System.out.print(" Tiempo adicional : ");
        int tiempoadicional = pedirEntero();

        System.out.println(" Seleccioná el estadio del partido:");
        Estadio estadio = ingresarEstadio(null);

        System.out.println(" Seleccioná la fase del partido:");
        Fase fase = ingresarFase();
        
        Partido p = new Partido();
        p.setDuracion(duracion);
        p.setFase(fase);
        p.setFecha(fecha);
        p.setEstadio(estadio);
        p.setTiempoadicional(tiempoadicional);
        

        System.out.println(" Ingresá la participación selección 1:");
        Participacion seleccion1 = ingresarParticipacion(p,null);

        System.out.println(" Ingresá la participación selección 2:");
        Participacion seleccion2 =ingresarParticipacion(p,null);

        p = new Partido(fecha, horario, duracion, tiempoadicional, estadio, fase, seleccion1, seleccion2);

        // Ingreso de eventos del partido
        System.out.print(" ¿Cuántos eventos tuvo el partido? : ");
        int cantEventos = pedirEntero();
        for(int i = 1; i <= cantEventos; i++){
            System.out.println("\nEvento " + i + " de " + cantEventos);
            System.out.println("\n=== Ingreso de Evento ===");

            TipoEvento evento = IngresoEnum.elegirTipoEvento();

            System.out.print(" Minuto del evento: ");
            int minuto = pedirEntero();
        
            Evento e=new Evento();
            e.setEvento(evento);
            e.setMinuto(minuto);
        
            Jugador j=ingresarJugador();
        
            e.setJugador(j);
            p.agregarEvento(e);
        }

        // Ingreso de arbitrajes del partido
        System.out.print(" ¿Cuántos arbitrajes tuvo el partido? : ");
        int cantArbitrajes = pedirEntero();
        for(int i = 1; i <= cantArbitrajes; i++){
            System.out.println("\nArbitraje " + i + " de " + cantArbitrajes);
            Arbitraje a = ingresarArbitraje();
            p.agregarArbitraje(a);
        }

        return p;
    }
    
    public static Seleccion ingresarSeleccion(Pais pais) {
       System.out.println("\n=== Ingreso de Selección ===");

       System.out.print(" Nombre de la federación: ");
       String nombreFederacion = pedirStringsinespacios();

       System.out.print(" Camiseta principal: ");
       String camisetaPrincipal = pedirStringsinespacios();

       System.out.print(" Camiseta secundaria: ");
       String camisetaSecundaria = pedirStringsinespacios();

       System.out.print(" Ranking FIFA: ");
       int rankingFIFA = pedirEntero();

       System.out.print(" ¿Es cabeza de grupo? s/n: ");
       boolean cabezaGrupo = pedirBooleano();

       Grupo grupo = ingresarGrupo();

       Seleccion s = new Seleccion(nombreFederacion, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, rankingFIFA, pais, grupo);

       // Ingreso de Jugadores
       System.out.println("\n--- Ingreso de Jugadores ---");
       String resp = "s";
       while (resp.equalsIgnoreCase("s")) {
        Jugador j = ingresarJugador();
        s.agregarJugador(j);
        System.out.print("¿Agregar otro jugador? (s/n): ");
        resp = pedirStringsinespacios();
       }

       // Ingreso de Directores Técnicos
       System.out.println("\n--- Ingreso de Directores Técnicos ---");
       resp = "s";
       while (resp.equalsIgnoreCase("s")) {
          DirectorTecnico dt = ingresarDirectorTecnico();
          s.agregarDirectoresTecnicos(dt);
          System.out.print("¿Agregar otro director técnico? (s/n): ");
          resp = pedirStringsinespacios();
       }

       // Ingreso de Cuerpo Técnico
       System.out.println("\n--- Ingreso de Cuerpo Técnico ---");
       resp = "s";
       while (resp.equalsIgnoreCase("s")) {
        CuerpoTecnico ct = ingresarCuerpoTecnico();
        s.agregarCuerposTecnicos(ct);
        System.out.print("¿Agregar otro integrante del cuerpo técnico? (s/n): ");
        resp = pedirStringsinespacios();
       }

      return s;
    }
    
    public static Arbitro ingresarArbitro(Pais pais) {
     System.out.println("\n=== Ingreso de Árbitro ===");

     System.out.print(" Nombre: ");
     String nombre = pedirStringsinespacios();

     System.out.print(" Año de nacimiento: ");
     int fecNacimiento = pedirEntero();

     System.out.print(" Años de experiencia: ");
     int aniosExperiencia = pedirEntero();

     Arbitro a = new Arbitro(nombre, fecNacimiento, aniosExperiencia, pais);

     // Ingreso de Arbitrajes
     System.out.println("\n--- Ingreso de Arbitrajes ---");
     String resp = "s";
     while (resp.equalsIgnoreCase("s")) {
        Arbitraje arb = ingresarArbitraje();
        a.agregarArbitraje(arb);
        System.out.print("¿Agregar otro arbitraje? (s/n): ");
        resp = pedirStringsinespacios();
     }

     return a;
    }
    
   public static Fase ingresarFase() {
    System.out.println("\n=== Ingreso de Fase ===");

    TipoNombreFase nombreFase = IngresoEnum.elegirTipoNombreFase();

    Fase f = new Fase(nombreFase);

    // Ingreso de Partidos
    System.out.println("\n--- Ingreso de Partidos ---");
    String resp = "s";
    while (resp.equalsIgnoreCase("s")) {
        Partido p = ingresarPartido();
        f.agregarPartido(p);
        System.out.print("¿Agregar otro partido? (s/n): ");
        resp = pedirStringsinespacios();
    }

    // Ingreso de Grupos
    System.out.println("\n--- Ingreso de Grupos ---");
    resp = "s";
    while (resp.equalsIgnoreCase("s")) {
        Grupo g = ingresarGrupo();
        f.agregarGrupos(g);
        System.out.print("¿Agregar otro grupo? (s/n): ");
        resp = pedirStringsinespacios();
    }

    return f;
   }
   
      public static Participacion ingresarParticipacion(Partido partido, Seleccion seleccion) {
        System.out.println("\n=== Ingreso de Participación ===");

        System.out.print(" ¿Es local? (s/n): ");
        boolean eslocal = pedirBooleano();

        System.out.print(" Cantidad de goles: ");
        int cantidadGoles = pedirEntero();

        System.out.print(" Cantidad de tarjetas amarillas: ");
        int cantidadTarjAmarillas = pedirEntero();

        System.out.print(" Cantidad de tarjetas rojas: ");
        int cantidadTarjRojas = pedirEntero();

        Participacion p = new Participacion(eslocal, cantidadGoles, cantidadTarjAmarillas, cantidadTarjRojas, partido, seleccion);

        return p;
      }
      
      public static Evento ingresarEvento() {
        System.out.println("\n=== Ingreso de Evento ===");

        TipoEvento evento = IngresoEnum.elegirTipoEvento();

        System.out.print(" Minuto del evento: ");
        int minuto = pedirEntero();
        
        Evento e=new Evento();
        e.setEvento(evento);
        e.setMinuto(minuto);
        
        Jugador j=ingresarJugador();
        
        e.setJugador(j);
        
        return e;
        
       }
      
      
   

}

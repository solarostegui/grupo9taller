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
           Partido partido=ingresarPartido(estadio,null);
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
    
    public static Partido ingresarPartido(Estadio estadio, Fase fase) {
    System.out.println("\n=== Ingreso de Partido ===");

    // Fecha
    System.out.print(" Fecha del partido (dd/mm/aaaa): ");
    String fecha = pedirStringsinespacios();

    System.out.print(" Horario del partido (hh:mm): ");
    String horario = pedirStringsinespacios();

    System.out.print(" Duración en minutos : ");
    int duracion = pedirEntero();

    System.out.print(" Tiempo adicional : ");
    int tiempoadicional = pedirEntero();

   
    // Ingreso de Participaciones
    System.out.println(" Ingresá la participación selección 1:");
    Participacion seleccion1 = ingresarParticipacion(p, null);
    p.setParticipacion1(seleccion1);

    System.out.println(" Ingresá la participación selección 2:");
    Participacion seleccion2 = ingresarParticipacion(p, null);
    p.setParticipacion2(seleccion2);
    
    Partido p = new Partido(fecha, horario, duracion, tiempoadicional, estadio,fase,seleccion1,seleccion2);

    // Ingreso de Eventos
    System.out.print(" ¿Cuántos eventos tuvo el partido? : ");
    int cantEventos = pedirEntero();
    for (int i = 1; i <= cantEventos; i++) {
        System.out.println("\nEvento " + i + " de " + cantEventos);
        Jugador j = ingresarJugador();
        Evento e = ingresarEvento(j);
        p.agregarEvento(e);
    }

    // Ingreso de Arbitrajes
    System.out.print(" ¿Cuántos árbitros tuvo el partido? : ");
    int cantArbitrajes = pedirEntero();
    for (int i = 1; i <= cantArbitrajes; i++) {
        System.out.println("\nÁrbitro " + i + " de " + cantArbitrajes);
        Arbitro arbitro = ingresarArbitro(null, p);
        Arbitraje a = ingresarArbitraje(arbitro, p);
        p.agregarArbitraje(a);
    }

    return p;
}

public static Grupo ingresarGrupo(Fase fase) {
    System.out.println("\n=== Ingreso de Grupo ===");

    System.out.print(" Identificación (ej: A, B, C): ");
    String identificacion = pedirStringsinespacios();

    System.out.print(" Descripción: ");
    String descripcion = pedirStringsinespacios();

    Grupo g = new Grupo(identificacion, descripcion, fase);

    // Ingreso de Selecciones
    System.out.println("\n--- Ingreso de Selecciones ---");
    String resp = "s";
    while (resp.equalsIgnoreCase("s")) {
        Seleccion s = ingresarSeleccion(g,null);
        g.agregarSeleccion(s);
        System.out.print("¿Agregar otra selección? (s/n): ");
        resp = pedirStringsinespacios();
    }

    return g;
}

public static Seleccion ingresarSeleccion(Grupo grupo,Pais pais) {
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
    
    

    Seleccion s = new Seleccion(nombreFederacion, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, rankingFIFA,pais,grupo);

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
     public static DirectorTecnico ingresarDirectorTecnico() {
    System.out.println("\n=== Ingreso de Director Técnico ===");

    System.out.print(" Nombre: ");
    String nombre = pedirStringsinespacios();

    System.out.print(" Año de nacimiento: ");
    int fecNacimiento = pedirEntero();

    System.out.print(" Año de nombramiento: ");
    int fechaNombramiento = pedirEntero();

    return new DirectorTecnico(nombre, fecNacimiento, fechaNombramiento);
   }

  public static CuerpoTecnico ingresarCuerpoTecnico() {
    System.out.println("\n=== Ingreso de Cuerpo Técnico ===");

    System.out.print(" Nombre: ");
    String nombre = pedirStringsinespacios();

    System.out.print(" Año de nacimiento: ");
    int fecNacimiento = pedirEntero();

    TipoRol rol = IngresoEnum.elegirTipoRol();

    return new CuerpoTecnico(nombre, fecNacimiento, rol);
  }
    
    
    public static Arbitro ingresarArbitro(Pais pais, Partido partido) {
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
        Arbitraje arb = ingresarArbitraje(a, partido); // se pasan ambos ya creados
        a.agregarArbitraje(arb);
        System.out.print("¿Agregar otro arbitraje? (s/n): ");
        resp = pedirStringsinespacios();
    }

    return a;
    }

    public static Arbitraje ingresarArbitraje(Arbitro arbitro, Partido partido) {
    System.out.println("\n=== Ingreso de Arbitraje ===");

    TipoCategoriaArbitro rol = IngresoEnum.elegirTipoCategoriaArbitro();

    return new Arbitraje(rol, arbitro, partido);
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
        Grupo g = ingresarGrupo(f);
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
      
      public static Jugador ingresarJugador() {
         System.out.println("\n=== Ingreso de Jugador ===");

          System.out.print(" Nombre: ");
          String nombre = pedirStringsinespacios();

          System.out.print(" Año de nacimiento: ");
          int fecNacimiento = pedirEntero();

          System.out.print(" Dorsal: ");
          int dorsal = pedirEntero();

          TipoPosicion posicion = IngresoEnum.elegirTipoPosicion();

          System.out.print(" Peso (ej: 75.5): ");
          float peso = pedirFloat();

          System.out.print(" Altura (ej: 1.80): ");
          float altura = pedirFloat();

          Jugador j = new Jugador(nombre, fecNacimiento, dorsal, posicion, peso, altura);

         // Ingreso de Eventos
         System.out.println("\n--- Ingreso de Eventos ---");
         String resp = "s";
         while (resp.equalsIgnoreCase("s")) {
         Evento e = ingresarEvento(j); // le pasamos el jugador ya creado
         j.agregarEvento(e);
         System.out.print("¿Agregar otro evento? (s/n): ");
         resp = pedirStringsinespacios();
        }

       return j;
      }

    public static Evento ingresarEvento(Jugador j) {
       System.out.println("\n=== Ingreso de Evento ===");

       TipoEvento evento = IngresoEnum.elegirTipoEvento();

       System.out.print(" Minuto del evento: ");
       int minuto = pedirEntero();

       Evento e = new Evento(evento,minuto,j);
    
       return e;
    }
    
    
      
}

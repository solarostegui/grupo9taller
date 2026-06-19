package org.example;

public class Participacion {
    private boolean eslocal;
    //clase asociacion con seleccion
    private Seleccion seleccion;
    //clase asociacion con partido
    private Partido partido;

    //constructor con parametros
    public Participacion(boolean eslocal,Partido partido,Seleccion seleccion) {
        this.eslocal = eslocal;
        this.partido=partido;
        this.seleccion=seleccion;
    }

    //Getters y setters
    public boolean getEslocal() {
        return eslocal;
    }
    public void setEslocal(boolean eslocal) {
        this.eslocal = eslocal;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public Partido getPartido() {
        return partido;
    }
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    public boolean perteneceASeleccion(Jugador j){
        if(seleccion == null){
            return false;
        }
        return seleccion.getJugador().contains(j);
    }
    
    public int getCantidadGoles() {
        
        if (partido == null || partido.getEventos() == null) return 0;
        int goles = 0;
        for (Evento e : partido.getEventos()) {
            if (e.getEvento() == TipoEvento.Gol && e.getJugador() != null && perteneceASeleccion(e.getJugador())) {
               goles++;
            }
        }
        return goles;
    }

    public int getCantidadTarjAmarillas() {
       
      if (partido == null || partido.getEventos() == null) return 0;
      int amarillas = 0;
      
      for (Evento e : partido.getEventos()) {
           if (e.getEvento() == TipoEvento.TarjetaAmarilla && e.getJugador() != null && perteneceASeleccion(e.getJugador())) {
              amarillas++;
            }
        }
      return amarillas;
    }

   public int getCantidadTarjRojas() {
       
       if (partido == null || partido.getEventos() == null) return 0;
       int rojas = 0;
       
       for (Evento e : partido.getEventos()) {
           if ((e.getEvento() == TipoEvento.TarjetaRoja || e.getEvento() == TipoEvento.DobleAmarilla) && e.getJugador() != null &&
                perteneceASeleccion(e.getJugador())) {
                rojas++;
            }
        }
        return rojas;
    }
}
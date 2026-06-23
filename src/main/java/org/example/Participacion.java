package org.example;
/**
 * Clase que une a una selección con un partido específico. Tiene como atributo 
 * si la selección es local. 
 * @author Antonella Monti, María del Mar Dalorso
 * @version 1.0
 */
public class Participacion {
    /**
     * Si la selección jufó como local o como visitante
     */
    private boolean eslocal;
    /**
     * La selección que esta jugando el partido. 
     */
    private Seleccion seleccion;
    /**
     * El partido en el que participa la selección
     */
    private Partido partido;
    
    /**
     * Constructor con parametros que crea una participación.
     * @param eslocal true si es local, false si es visitante.
     * @param partido El partido que se va a jugar.
     * @param seleccion La seleccion que va a jugar el partido.
     */

    public Participacion(boolean eslocal,Partido partido,Seleccion seleccion) {
        this.eslocal = eslocal;
        this.partido=partido;
        this.seleccion=seleccion;
    }
    
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
    /**
     * Revisa si un jugador pertenece a la selección de esta participación.
     * @param j El jugador que queremos comprobar.
     * @return true si el jugador forma parte de este equipo, false si no.
     */
    public boolean perteneceASeleccion(Jugador j){
        if(seleccion == null){
            return false;
        }
        return seleccion.getJugador().contains(j);
    }
    /**
     * Recorre todos los eventos del partido y suma cuántos goles metió 
     * únicamente esta selección.
     * @return El número total de goles anotados en el partido.
     */
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
    /**
     * Recorre los eventos del partido y cuenta cuántas tarjetas amarillas 
     * le sacaron a los jugadores de esta selección.
     * @return El número total de tarjetas amarillas que recibió el equipo.
     */
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
    /**
     * Recorre los eventos del partido y cuenta cuántas tarjetas rojas 
     * tuvo esta selección.
     * @return El número total de tarjetas rojas que recibió el equipo.
     */
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
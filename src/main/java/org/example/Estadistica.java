package org.example;
/**
 * Clase que gestiona la información y las estadísticas de una selección.
 * @author Antonella Monti, María Sol Arostegui, María del Mar Dalorso.
 * @version 1.0
 */
public class Estadistica {
    /**
     * Selección a la que pertenecen estas estadísticas.
     */
    private Seleccion seleccion;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;
    /**
     * Diferencia de goles (golesafavor - golesencontra) de la selección.
     */
    private int diferenciaGoles;
    /**
     * Puntaje que acumula en la fase de grupos.
     */
    private int puntos;
    /**
     * Constructor que vincula la estadística a una selección espefcífica y
     * establece todos los contadoes iniciales en 0.
     * @param seleccion objeto {@link Seleccion} que se lleverá las estadísticas.
     */
    public Estadistica(Seleccion seleccion){
        this.seleccion = seleccion;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.diferenciaGoles = 0;
        this.puntos = 0;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }
    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }
    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }
    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }
    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }
    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public int getDiferenciaGoles() {
        return diferenciaGoles;
    }
    public void setDiferenciaGoles(int diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }

    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    /**
     * Restablece todos los contadores de estadísticas y puntos a cero.
     * Se utiliza para recalcular desde cero y evitar que se dupliquen los números sumados.
     */
    
    public void restablecer(){
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.diferenciaGoles = 0;
        this.puntos = 0;
    }
    
    /**
     * Computa el resultado de un partido jugado, actualizando los acumuladores de goles,
     * recalculado  la diferencia y asignando los puntos correspondientes.
     * Cumple con el requerimiento del informe de Tabla de Posiciones: victoria = 3 puntos, empate = 1 punto, derrota = 0 puntos.
     * Cumpe con el requerimiento de actualizar automaticamente las estaadísticas de los grupos.
     * @param golesAFavor cantidad de goles convertidos por la selección.
     * @param golesEnContra cantidad de goles recibidos por la selección.
     */
    public void computarPartido(int golesAFavor, int golesEnContra){
        //suma partidos jugados (uno solo)
        this.partidosJugados++;
        //acumulador goles fisicos
        this.golesAFavor += golesAFavor;
        this.golesEnContra += golesEnContra;
        //recalcular dif. de goles
        this.diferenciaGoles = this.golesAFavor - this.golesEnContra;
        //determina resultado y asigna puntos
        if(golesAFavor > golesEnContra){
            this.partidosGanados++;
            this.puntos += 3; //suma 3 puntos de victoria
        }else if(golesAFavor < golesEnContra){
            this.partidosPerdidos++; //no suma puntos
        }else{
            this.partidosEmpatados++;
            this.puntos += 1; //suma 1 punto de empate
        }
    }
}

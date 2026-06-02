package org.example;

public class Estadisticas {
    private Seleccion seleccion;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;
    private int diferenciaGoles; //golesafavor - golesencontra
    private int puntos; //ganados x3 + empatados

    //Constructor que vincula la seleccion y arranca todo en 0
    public Estadisticas(Seleccion seleccion){
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

    //MÉTODOS
    //1. Para reestablecer el contador y que no se dupliquen los números sumados
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
    //2. Para computar un partido
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

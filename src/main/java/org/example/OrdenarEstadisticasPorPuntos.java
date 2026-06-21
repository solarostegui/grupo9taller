/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;
import java.util.Comparator;
/**
 *
 * @author mardalorso
 */
public class OrdenarEstadisticasPorPuntos implements Comparator<Estadisticas> {

    @Override
    public int compare(Estadisticas est1, Estadisticas est2) {
        if (est1 == null) {
            return 1;
        }
        if (est2 == null) {
            return -1;
        }
        //Único criterio: puntos de mayor a menor
        return Integer.compare(est2.getPuntos(), est1.getPuntos());
    }
}

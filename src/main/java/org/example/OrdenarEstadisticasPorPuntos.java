/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;
import java.util.Comparator;
/**
 * Clase encargada de comparar segun el criterio de ordenamiento
 * para objetos de tipo {@link Estadistica}.
 * @author Antonella Monti, María del Mar Dalorso.
 * @version 1.0
 */
public class OrdenarEstadisticasPorPuntos implements Comparator<Estadistica> {
    /**
     * Compara dos objetos de tipo Estadistíca segús los puntos acumulados.
     * {@code Integer.compare(est2.getPuntos(), est1.getPuntos())} ordena las colecciones de mayor a menor
     * El método maneja de forma segura los valores nulos para evitar excepciones en tiempo de ejecución
     * @param est1 primero objeto {@link Estadistica} a comparar
     * @param est2 segundo objeto {@link Estadistica} a comparar
     * @return Un valor entero negativo si {@code est1} tiene más puntos que {@code est2},
     * cero si tienen la misma cantidad de puntos y un valor entero positivo si {@code est1} tiene menos puntos que {@code est2}.
     */
    @Override
    public int compare(Estadistica est1, Estadistica est2) {
        if (est1 == null) {
            return 1;
        }
        if (est2 == null) {
            return -1;
        }
        return Integer.compare(est2.getPuntos(), est1.getPuntos());
    }
}

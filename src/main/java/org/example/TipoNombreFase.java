/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 * Define las fases que se juegan en el mundial.
 * @author María del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public enum TipoNombreFase {
    /**
     * Primera ronda del torneo donde los equipos juegan en zonas de 4.
     */
    Grupos,
    /**
     * Ronda de eliminación directa donde quedan 32 equipos.
     */
    Dieciseisavos,
    /**
     * Ronda de eliminación directa donde quedan 16 equipos.
     */
    Octavos,
    /**
     * Partidos de cuartos de final
     */
    Cuartos,
    /**
     * Partidos de semifinales
     */
    Semifinal,
    /**
     * El partido definitivo para consagrar al campeón del mundo.
     */
    Final;
}

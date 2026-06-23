/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 * Define las posiciones que ocupan los jugadores en la cancha.
 * @author María del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public enum TipoPosicion{
    /**
     * l encargado de defender el arco y el único que puede usar las manos.
     */
    Arquero,
    /**
     * Los encargados de frenar los ataques del rival en la zona baja.
     */
    Defensor,
    /**
     * Los que juegan en el centro de la cancha, arman el juego y conectan la defensa con el ataque.
     */
    Mediocampista,
    /**
     * Los atacantes del equipo, encargados principales de hacer los goles.
     */
    Delantero
}

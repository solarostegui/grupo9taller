/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 * Define los distintos eventos que puede tener un partido
 * @author María del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public enum TipoEvento {
    /**
     * Cuando un quipo mete un gol válido.
     */
    Gol,
    /**
     * Amonestación al jugador por una falta grave.
     */
    TarjetaAmarilla,
    /**
     * Expulsión directa del partido.
     */
    TarjetaRoja,
    /**
     * Cuando el árbitro cobra una falta adentro del área
     */
    PenalCometido,
    /**
     * Cuando el penal se patea y termina en gol.
     */
    PenalConvertido,
    /**
     * Cuando el penal es atajado, pega en el palo o va afuera.
     */
    PenalErrado,
    /**
     * Expulsión del partido por acumular dos tarjetas amarillas.
     */
    DobleAmarilla,
    /**
     * Cuando un jugador sale y entra un suplente.
     */
    Sustitucion,
    /**
     * Cuando un jugador se lastima durante el juego.
     */
    Lesion
}

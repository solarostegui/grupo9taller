package org.example;
/**
 * Define los roles que puede tener un árbitro dentro del mundial.
 * @author María del Mar Dalorso, Antonella Monti.
 * @version 1.0
 */
public enum TipoCategoriaArbitro {
    /**
     * Arbitro de campo principal.
     */
    Principal,
    /**
     * Primer juez de línea.
     */
    Asistente1,
    /**
     * Segundo juez de línea.
     */
    Asistente2,
    /**
     * Encargado de los cambios, de controlar los bancos de suplentes y de mostrar el tiempo extra.
     */
    CuartoArbitro,
    /**
     * Arbitro que se encuentra en la cabina del VAR.
     */
    VarPrincipal, 
    /**
     * Ayudante dentro de la cabina del VAR
     */
    VarAsistente
}

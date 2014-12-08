/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

/**
 *
 * @author Dominik
 */
public abstract class Geometry {
    
    /**
     * Farbe der Geometrie.
     */
    public final Color color;
    
    /**
     * Erzeugt eine neue Geometrie.
     * @param color Farbe der Geometrie.
     */
    public Geometry(final Color color){
        this.color = color;
    }
    
    public abstract Hit hit(final Ray ray);
    
}

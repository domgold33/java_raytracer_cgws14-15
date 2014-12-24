/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.geometry;

import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.material.Material;

/**
 *
 * @author Dominik
 */
public abstract class Geometry {
    
    /**
     * Material der Geometrie.
     */
    public final Material material;
    
    /**
     * Erzeugt eine neue Geometrie.
     * @param material Material der Geometrie.
     */
    public Geometry(final Material material){
        this.material = material;
    }
    
    public abstract Hit hit(final Ray ray);
    
}

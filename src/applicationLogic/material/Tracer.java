/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.material;

import applicationLogic.Color;
import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.World;

/**
 *
 * @author Dominik
 */
public class Tracer {
    
    /**
     * Benutzte Welt
     */
    public final World world;
    /**
     * Momentaner Refraktionsindex
     */
    public double refraction;
    
    public Tracer(final World world, double refraction){
        this.world = world;
        this.refraction = refraction;
    }
    
    /**
     * Ermittelt rekursiv die Farbe für den übergebenen Strahl.
     * @param ray 
     * @return Farbe für den übergebenen Strahl
     */
    public Color colorFor(final Ray ray){
        if (refraction <= 0) {
            return this.world.backgroundColor;
        } else {
            Hit hit = world.hit(ray);
            if (hit != null) {
                return hit.geo.material.colorFor(hit, world, new Tracer(world, refraction - 1));
            } else {
                return this.world.backgroundColor;
            }
        }
    }
    
}

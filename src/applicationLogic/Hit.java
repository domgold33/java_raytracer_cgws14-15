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
public class Hit {
    
    public final double t;
    public final Ray ray;
    public final Geometry geo;
    
    public Hit(final double t, final Ray ray, final Geometry geo){
        this.t = t;
        this.ray = ray;
        this.geo = geo;
    }
    
}

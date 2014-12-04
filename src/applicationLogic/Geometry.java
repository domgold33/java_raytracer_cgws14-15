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
    
    public final Color color;
    
    public Geometry(final Color color){
        this.color = color;
    }
    
    public abstract Hit hit(final Ray ray);
    
}

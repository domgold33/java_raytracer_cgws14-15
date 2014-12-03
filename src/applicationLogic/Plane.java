/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import matrizen.Normal3;
import matrizen.Point3;

/**
 *
 * @author Dominik
 */
public class Plane extends Geometry{
    
    public final Point3 a;
    public final Normal3 n;
    
    public Plane(final Point3 a, final Normal3 n, final Color color){
        super(color);
        this.a = a;
        this.n = n;
    }

    @Override
    public Hit hit(Ray ray) {
        return null;
    } 
    
}

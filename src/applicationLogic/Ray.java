/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class Ray {
    
    /**
     * Punkt, an dem der Strahl entspringt
     */
    public final Point3 o;
    /**
     * Richtungsvektor des Strahls
     */
    public final Vector3 d;
    
    /**
     * Erzeugt einen neuen Strahl.
     * @param o Urspungspunkt des Strahls.
     * @param d Richtungsvektor des Strahls.
     */
    public Ray(final Point3 o, final Vector3 d){
        this.o = o;
        this.d = d;
    }
    
    /**
     * Ermittelt einen Punkt auf dem Strahl anhand des Koeffizienten des Richtungsvektors.
     * @param t Koeffizient des Richtungsvektors.
     * @return Den Punkt, der für den übergebenen Koeffizienten entsteht.
     */
    public Point3 at(final double t){
        final Point3 result = o.add(d.mul(t));
        return result;
    }
    
    /**
     * ermittelt den Koeffizienten des Richtungsvektors anhand eines gegebenen Punktes.
     * @param p Der Punkt, für den der Koeffizient des Richtungsvektors ermittelt werden soll.
     * @return Den Koeffizienten des Richtungsvektors.
     */
    public double tOf(final Point3 p){
        if(p.equals(o)){
            return 0;
        }
        if(d.x != 0 && d.y != 0 && d.z != 0){
            final double tX = (p.x - o.x) / d.x;
            final double tY = (p.y - o.y) / d.y;
            final double tZ = (p.z - o.z) / d.z;
            if(tX == tY &&  tX == tZ){
                return tX;
            }
        }
        System.err.println("Punkt liegt nicht auf dem Strahl");
        return -1;
    }

    @Override
    public String toString() {
        return "Ray{" + "o=" + o + ", d=" + d + '}';
    }
    
}

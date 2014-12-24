/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import applicationLogic.geometry.Geometry;
import matrizen.Normal3;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class Hit {
    
    /**
     * Faktor, mit dem der Richtungsvektor des Strahls multipliziert werden muss, um zum Schnittpunkt
     * zu gelangen.
     */
    public final double t;
    /**
     * Strahl, der durch den Schnittpunkt verläuft.
     */
    public final Ray ray;
    /**
     * Normale des Schnittpunktes.
     */
    public final Normal3 normal;
    /**
     * Geometrie, auf der sich der Schnittpunkt befindet.
     */
    public final Geometry geo;
    
    /**
     * Erzeugt ein neues Hitobjekt, welches Daten für einen Schnittpunkt zwischen Strahl und Geometrie
     * beinhaltet.
     * @param t Faktor, mit dem der Richtungsvektor des Strahls multipliziert werden muss, um zum Schnittpunkt
     * zu gelangen.
     * @param ray Strahl, der durch den Schnittpunkt verläuft.
     * @param geo Geometrie, auf der sich der Schnittpunkt befindet.
     */
    public Hit(final double t, final Ray ray, final Geometry geo){
        this.t = t;
        this.ray = ray;
        this.geo = geo;
        final Point3 p = ray.o.add(ray.d.mul(t));
        final Vector3 v = new Vector3(p.x, p.y, p.z);
        this.normal = v.x(v).asNormal();
    }
    
}

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
    
     /**
     * Erzeugt eine neue Ebene.
     * @param a Ein Punkt auf der Ebene.
     * @param n Der Normalenvektor der Ebene.
     * @param color Die Farbe der Ebene.
     */
    
    public Plane(final Point3 a, final Normal3 n, final Color color){
        super(color);
        this.a = a;
        this.n = n;
    }
    
    
    /**
     * Prüft, ob der übergebene Strahl diese Ebene schneidet.
     * @param ray Strahl, für den überprüft werden soll, ob er die Ebene schneidet.
     * @return Ein Hitobjekt, welches Daten für den Schnittpunkt enthält.
     */
    
    @Override
    public Hit hit(Ray ray) {
         final double zaehler = this.a.sub(ray.o).dot(this.n);
        final double nenner = ray.d.dot(this.n);
        if(nenner != 0){
            final double resultT = zaehler / nenner;
            if(resultT > 0){
                final Hit resultHit = new Hit(resultT, ray, this);
                return resultHit;
            }else{
                return null;
            }
        }else{
            return null;
        }
    } 
    
}

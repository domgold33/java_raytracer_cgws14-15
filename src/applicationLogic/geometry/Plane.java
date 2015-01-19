/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.geometry;

import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.material.Material;
import java.util.Objects;
import matrizen.Normal3;
import matrizen.Point3;

/**
 *
 * @author Dominik
 */
public class Plane extends Geometry{
    
    /**
     * Ein Punkt auf der Ebene.
     */
    public final Point3 a;
    /**
     * Normalenvektor der Ebene.
     */
    public final Normal3 n;
    
    /**
     * Erzeugt eine neue Ebene.
     * @param a Ein Punkt auf der Ebene.
     * @param n Der Normalenvektor der Ebene.
     * @param material Material der Ebene.
     */
    public Plane(final Point3 a, final Normal3 n, final Material material){
        super(material);
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
            if(resultT >= 0.0001){
                final Hit resultHit = new Hit(resultT, ray, this, this.n);
                return resultHit;
            }else{
                return null;
            }
        }else{
            return null;
        }
    } 

    @Override
    public String toString() {
        return "Plane{" + "a=" + a + ", n=" + n + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.a);
        hash = 29 * hash + Objects.hashCode(this.n);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plane other = (Plane) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.n, other.n)) {
            return false;
        }
        return true;
    }
    
}

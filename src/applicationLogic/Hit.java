/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import applicationLogic.geometry.Geometry;
import java.util.Objects;
import matrizen.Normal3;

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
     * @param n Normale des Schnittpunkts
     */
    public Hit(final double t, final Ray ray, final Geometry geo, final Normal3 n){
        this.t = t;
        this.ray = ray;
        this.geo = geo;
        this.normal = n;
    }

    @Override
    public String toString() {
        return "Hit{" + "t=" + t + ", ray=" + ray + ", normal=" + normal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.t) ^ (Double.doubleToLongBits(this.t) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.ray);
        hash = 29 * hash + Objects.hashCode(this.normal);
        hash = 29 * hash + Objects.hashCode(this.geo);
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
        final Hit other = (Hit) obj;
        if (Double.doubleToLongBits(this.t) != Double.doubleToLongBits(other.t)) {
            return false;
        }
        if (!Objects.equals(this.ray, other.ray)) {
            return false;
        }
        if (!Objects.equals(this.normal, other.normal)) {
            return false;
        }
        if (!Objects.equals(this.geo, other.geo)) {
            return false;
        }
        return true;
    }
    
}

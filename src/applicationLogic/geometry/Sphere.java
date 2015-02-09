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
public class Sphere extends Geometry{

    /**
     * Mittelpunkt der Kugel.
     */
    public final Point3 c;
    /**
     * Radius der Kugel.
     */
    public final double r;
    
    /**
     * Erzeugt eine neue Kugel.
     * @param material Material der Kugel.
     */
    public Sphere(final Material material){
        super(material);
        this.c = new Point3(0, 0, 0);
        this.r = 0.5;
    }

    /**
     * Prüft, ob der übergebene Strahl diese Kugel schneidet.
     * @param ray Strahl, für den überprüft werden soll, ob er die Kugel schneidet.
     * @return Ein Hitobjekt, welches Daten für den Schnittpunkt enthält.
     */
    @Override
    public Hit hit(Ray ray) {
        final double resultA = ray.d.dot(ray.d);
        if(resultA == 0){
            return null;
        }
        final double resultB = ray.d.dot(ray.o.sub(this.c).mul(2));
        final double resultC = ray.o.sub(this.c).dot(ray.o.sub(this.c)) - this.r * this.r;
        final double zaehlerRoot = Math.sqrt(resultB * resultB  - 4 * resultA * resultC);
        if(zaehlerRoot < 0){
            return null;
        }
        final double resultZaehler1 = resultB * (-1) + zaehlerRoot;
        final double resultZaehler2 = resultB * (-1) - zaehlerRoot;
        final double resultNenner = 2 * resultA;
        final double resultT1 = resultZaehler1 / resultNenner;
        final double resultT2 = resultZaehler2 / resultNenner;
        if(resultT1 > 0.0001 || resultT2 > 0.0001){
            final double t = Math.min(resultT1, resultT2);
            final Normal3 normal = ray.at(t).sub(this.c).normalized().asNormal();
            return new Hit(t, ray, this, normal);
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        return "Sphere{" + "c=" + c + ", r=" + r + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.c);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.r) ^ (Double.doubleToLongBits(this.r) >>> 32));
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
        final Sphere other = (Sphere) obj;
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        if (Double.doubleToLongBits(this.r) != Double.doubleToLongBits(other.r)) {
            return false;
        }
        return true;
    }
    
}

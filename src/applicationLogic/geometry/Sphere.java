/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.geometry;

import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.material.Material;
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
     * @param c Mittelpunkt der Kugel.
     * @param r Radius der Kugel.
     * @param material Material der Kugel.
     */
    public Sphere(final Point3 c, final double r, final Material material){
        super(material);
        this.c = c;
        this.r = r;
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
        if(resultT1 <= resultT2 && resultT1 > 0){
            final Hit resultHit = new Hit(resultT1, ray, this);
            return resultHit;
        }else if(resultT2 < resultT1 && resultT2 > 0){
            final Hit resultHit = new Hit(resultT2, ray, this);
            return resultHit;
        }else{
            return null;
        }
        
    }
    
}

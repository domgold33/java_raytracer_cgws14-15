/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

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
     * @param color Farbe der Kugel.
     */
    public Sphere(final Point3 c, final double r, final Color color){
        super(color);
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
        return null;
    }
    
}

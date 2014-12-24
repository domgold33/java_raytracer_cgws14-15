/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.lighting;

import applicationLogic.Color;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public abstract class Light {
    
    /**
     * Die Farbe des Lichts.
     */
    public final Color color;
    
    /**
     * Erzeugt eine neue Lichtquelle.
     * @param color Farbe des Lichts.
     */
    public Light(final Color color){
        this.color = color;
    }
    
    /**
     * Prüft, ob diese Lichtquelle den übergebenen Punkt beleuchtet.
     * @param p Punkt, für den die Beleuchtung überprüft werden soll.
     * @return True falls der Punkt beleuchtet wird.
     */
    public abstract boolean illuminates(final Point3 p);
    
    /**
     * Ermittelt den Vektor zwischen dem übergebenen Punkt und der Lichtquelle.
     * @param p Punkt, von dem aus der Vektor zur Lichtquelle ermittelt werden soll.
     * @return Den Vektor zwischen der Lichtquelle und dem übergebenen Punkt.
     */
    public abstract Vector3 directionFrom(final Point3 p);
    
}

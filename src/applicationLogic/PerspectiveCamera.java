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
public class PerspectiveCamera extends Camera{
    
    /**
     * Der Winkel, in dem die Kamera ausgerichtet ist 
     */
    public final double angle;
    
    /**
     * Erzeugt eine neue perspektivische Kamera
     * @param e Position der perspektivischen Kamera
     * @param g Blickrichtung der perspektivischen Kamera
     * @param t Rotation der perspektivischen Kamera
     * @param angle Ausrichtungswinkel der perspektivischen Kamera
     */
    public PerspectiveCamera(final Point3 e, final Vector3 g, final Vector3 t, final double angle){
        super(e, g, t);
        this.angle = angle;
    }

    /**
     * Erzeugt einen Strahl für die übergebenen Pixelwerte mittels perspektivischer Projektion.
     * @param w Breite des Bildes
     * @param h Höhe des Bildes
     * @param x x - Wert des Pixels
     * @param y y - Wert des Pixels
     * @return Den erzeugten Strahl.
     */
    @Override
    public Ray rayFor(final int w, final int h, final int x, final int y) {
        final Point3 resultO = this.e;
        final double resultWFactor = h / 2 / Math.tan(angle / 2);
        final double resultUFactor = x - ((w - 1) / 2);   
        final double resultVFactor = y - ((h - 1) / 2);
        final Vector3 resultR = this.w.mul(-1).mul(resultWFactor).add(this.u.mul(resultUFactor).add(this.v.mul(resultVFactor)));
        final Vector3 resultD = resultR.normalized();
        return new Ray(resultO, resultD);
    }
    
}

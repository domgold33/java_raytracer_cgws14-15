/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.camera;

import applicationLogic.Ray;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class OrtographicCamera extends Camera{
    
    /**
     * Skalierungsfaktor
     */
    public final double s;
    
    /**
     * Erzeugt eine neue ortographische Kamera.
     * @param e Position der ortographischen Kamera
     * @param g Blickrichtung der ortographischen Kamera
     * @param t Rotation der ortographischen Kamera
     * @param s Skalierungsfaktor
     */
    public OrtographicCamera(final Point3 e, final Vector3 g, final Vector3 t, final double s){
        super(e, g, t);
        this.s = s;
    }

    /**
     * Ermittelt einen Strahl für die übergebenen Pixelwerte mittels ortographischer Projektion.
     * @param w Breite des Bildes
     * @param h Höhe des Bildes
     * @param x x - Koordinate des Pixels
     * @param y y - Koordinate des Pixels
     * @return Den zum Pixel zugehörigen Strahl.
     */
    @Override
    public Ray rayFor(final int w, final int h, final int x, final int y) {
        final Vector3 resultD = this.w.mul(-1);
        final double aspectRatio = (double) w / h;
        final double resultUFactor = (double) (x - (w - 1) / 2) / (w - 1) * aspectRatio * s;
        final double resultVFactor = (double) (y - (h - 1) / 2) / (h - 1) * s;        
        final Point3 resultO = this.e.add(this.u.mul(resultUFactor).add(this.v.mul(resultVFactor)));        
        return new Ray(resultO, resultD);
    }
    
}

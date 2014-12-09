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
public abstract class Camera {
    
    /**
     * Position der Kamera
     */
    public final Point3 e;
    /**
     * Blickrichtung
     */
    public final Vector3 g;
    /**
     * Rotation
     */
    public final Vector3 t;
    /**
     * u - Achse des neu aufgespannten Koordinatensystems
     */
    public final Vector3 u;
    /**
     * v - Achse des neu aufgespannten Koordinatensystems
     */
    public final Vector3 v;
    /**
     * w - Achse des neu aufgespannten Koordinatensystems
     */
    public final Vector3 w;
    
    /**
     * Erzeugt eine neue Kamera.
     * @param e Position der Kamera
     * @param g Blickrichtung der Kamera
     * @param t Rotation der Kamera
     */
    public Camera(final Point3 e, final Vector3 g, final Vector3 t){
        this.e = e;
        this.g = g;
        this.t = t;
        this.w = g.normalized().mul(-1);
        this.u = t.x(w).normalized();
        this.v = w.x(u);
    }
    
    /**
     * Erzeugt einen Strahl für die übergebenen Pixelwerte.
     * @param w Breite des Bildes
     * @param h Höhe des Bildes
     * @param x x - Koordinate des Pixels
     * @param y y - Koordinate des Pixels
     * @return Den zum Pixel zugehörigen Strahl.
     */
    public abstract Ray rayFor(final int w, final int h, final int x, final int y);
    
}

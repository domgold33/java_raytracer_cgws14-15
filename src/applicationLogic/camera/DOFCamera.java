/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.camera;

import applicationLogic.Ray;
import applicationLogic.SamplingPattern;
import java.util.ArrayList;
import java.util.List;
import matrizen.Point2;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class DOFCamera extends Camera{

    /**
     * Halber Öffnungswinkel der Kamera
     */
    public final double angle;
    /**
     * Entfernung des Brennpunkts
     */
    public final double focalLength;
    /**
     * Radius der Linse
     */
    public final double lensRadius;
    
    /**
     * Erzeugt eine neue Kamera.
     * @param e Position der Kamera
     * @param g Blickrichtung der Kamera
     * @param t Rotation der Kamera
     * @param sp SamplingPattern der Kamera
     * @param angle Halber Öffungswinkel der Kamera
     * @param fl Entfernung des Brennpunkts
     * @param lr Radius der Linse
     */    
    public DOFCamera(final Point3 e, final Vector3 g, final Vector3 t, final SamplingPattern sp, final double angle, final double fl, final double lr){
        super(e, g, t, sp);
        this.angle = angle;
        this.focalLength = fl;
        this.lensRadius = lr;
    }
    
    @Override
    public List<Ray> rayFor(final int w, final int h, final int x, final int y) {
        List<Ray> rays = new ArrayList<>();
        final Vector3 newW = this.w.mul(-1);
        final double one = h / 2 / Math.tan(this.angle / 2);
        final double two = (w - 1) / 2;
        final double three = (h - 1) / 2;
        for(final Point2 p : this.sp.points){
            final double px = x - two + p.x;
            final double py = y - three + p.y;
            final double fx = px * focalLength / one;
            final double fy = py * focalLength / one;
            final Point3 fp = this.e.add(newW.mul(focalLength)).add(this.u.mul(fx).add(this.v.mul(fy)));
            for(final Point2 p1 : this.sp.asDisc()){
                Point3 lo = this.e.add(this.u.mul(p1.x * lensRadius)).add(this.v.mul(p1.y * lensRadius));
                Vector3 d = fp.sub(lo).normalized();
                rays.add(new Ray(lo, d));
            }
        }
        return rays;
    }
    
}

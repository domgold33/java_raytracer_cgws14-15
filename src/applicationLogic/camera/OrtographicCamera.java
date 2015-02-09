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
     * @param sp SamplingPattern der Kamera
     * @param s Skalierungsfaktor
     */
    public OrtographicCamera(final Point3 e, final Vector3 g, final Vector3 t, final SamplingPattern sp, final double s){
        super(e, g, t, sp);
        this.s = s;
    }
    
    @Override
    public List<Ray> rayFor(final int w, final int h, final int x, final int y) {
        final List<Ray> rayList = new ArrayList<>();
        final Vector3 resultD = this.w.mul(-1);
        final double aspectRatio = (double) w / h;
        final double resultUFactor = (double) (x - (w - 1) / 2) / (w - 1) * aspectRatio * s;
        final double resultVFactor = (double) (y - (h - 1) / 2) / (h - 1) * s;   
        for(final Point2 p : this.sp.points){
            final Point3 resultO = this.e.add(this.u.mul(resultUFactor)).add(this.v.mul(resultVFactor))
                                   .add(this.u.mul(p.x * aspectRatio * s/w).add(this.v.mul(p.y * aspectRatio * s/w)));        
            rayList.add(new Ray(resultO, resultD));
        }
        return rayList;
    }
    
}

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
     * @param sp SamplingPattern der Kamera
     * @param angle Ausrichtungswinkel der perspektivischen Kamera
     */
    public PerspectiveCamera(final Point3 e, final Vector3 g, final Vector3 t, final SamplingPattern sp, final double angle){
        super(e, g, t, sp);
        this.angle = angle;
    }

    @Override
    public List<Ray> rayFor(final int w, final int h, final int x, final int y) {
        final List<Ray> rayList = new ArrayList<>();
        final Point3 resultO = this.e;
        final double resultWFactor = h / 2 / Math.tan(angle / 2);
        final double resultUFactor = x - ((w - 1) / 2);   
        final double resultVFactor = y - ((h - 1) / 2);
        for(final Point2 p : this.sp.points){
            final Vector3 resultR = this.w.mul(-1).mul(resultWFactor).add(this.u.mul(resultUFactor))
                                    .add(this.v.mul(resultVFactor)).add(this.u.mul(p.x).add(this.v.mul(p.y)));
            final Vector3 resultD = resultR.normalized();
            rayList.add(new Ray(resultO, resultD));
        }
        return rayList;
    }
    
}

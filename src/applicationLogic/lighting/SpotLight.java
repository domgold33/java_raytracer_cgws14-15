/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.lighting;

import applicationLogic.Color;
import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.World;
import applicationLogic.geometry.Geometry;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class SpotLight extends Light{
    
    /**
     * Position des Spotlights.
     */
    public final Point3 position;
    /**
     * Leuchtrichtung des Spotlights.
     */
    public final Vector3 direction;
    /**
     * Halbierter Ausrichtungswinkel des Spotlights.
     */
    public final double halfAngle;
    
    /**
     * Erzeugt ein neues Spotlight, welches in die gegebene Richtung in einem Lichtkegel, der durch den
     * übergebenen Winkel begrenzt wird.
     * @param color Farbe des Lichts.
     * @param p Position des Spotlights.
     * @param d Leuchtrichtung des Spotlights.
     * @param halfAngle Halbierter Begrenzungswinkel des Lichtkegels.
     */
    public SpotLight(final Color color, final Point3 p, final Vector3 d, final double halfAngle){
        super(color);
        this.position = p;
        this.direction = d;
        this.halfAngle = halfAngle;
    }
    
    @Override
    public boolean illuminates(final Point3 p, final World world){
        /*Vektor zu Punkt berechnen, überprüfen mittels Skalarprodukt, ob Winkel zwischen neuem Vektor und
        Richtungsvektor des Lichts kleiner halfAngle ist.
        */
        final Vector3 connection = p.sub(position);
        final double skalar = connection.dot(direction);
        final double newAngle = Math.acos(skalar / (connection.magnitude * direction.magnitude));
        boolean illuminates = newAngle <= halfAngle;
        if(!illuminates){
            return illuminates;
        }
        final Vector3 l = this.directionFrom(p);
        final double lightT = this.position.sub(p).magnitude / l.magnitude;
        final Ray ray = new Ray(p, l);
        for(Geometry geo : world.geoList){
            final Hit hit = geo.hit(ray);
            if(hit != null){
                illuminates = hit.t >= lightT;
                break;
            }
        }
        return illuminates;
    }
    
    @Override
    public Vector3 directionFrom(final Point3 p){
        return position.sub(p).normalized();
    }
    
}

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
public class PointLight extends Light{

    /**
     * Position des Puktlichts.
     */
    public final Point3 position;
    
    /**
     * Erzeugt eine neue Punktlichtquelle, die von einem Punkt aus in alle Richtungen strahlt.
     * @param color Farbe des Lichts.
     * @param p Position der Punktlichtquelle.
     */
    public PointLight(final Color color, final Point3 p){
        super(color);
        this.position = p;
    }
    
    @Override
    public boolean illuminates(final Point3 p, final World world) {
        boolean illuminates = true;
        final Vector3 l = this.directionFrom(p);
        final double lightT = this.position.sub(p).magnitude / l.magnitude;
        final Ray ray = new Ray(p, l);
        for(Geometry geo : world.geoList){
            final Hit hit = geo.hit(ray);
            if(hit != null){
                illuminates = hit.t >= lightT;
                if(illuminates){
                    break;
                }
            }
        }
        return illuminates;
    }

    @Override
    public Vector3 directionFrom(final Point3 p) {
        return position.sub(p).normalized();
    }
    
    
    
}

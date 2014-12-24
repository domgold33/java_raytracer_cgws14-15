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
    public boolean illuminates(Point3 p) {
        return true;
    }

    @Override
    public Vector3 directionFrom(Point3 p) {
        return p.sub(position);
    }
    
    
    
}

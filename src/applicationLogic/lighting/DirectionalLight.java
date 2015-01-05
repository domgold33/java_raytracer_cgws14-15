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
public class DirectionalLight extends Light{

    /**
     * Richtung der direktionalen Lichtquelle.
     */
    public final Vector3 direction;
    
    /**
     * Erzeugt eine neue direktionale Lichtquelle, welche an allen Stellen dieselbe Leuchtrichtung aufweist.
     * @param color Farbe des Lichts.
     * @param d Richtung, in die die Lichtquelle leuchtet.
     */
    public DirectionalLight(final Color color, final Vector3 d){
        super(color);
        this.direction = d;
    }
    
    @Override
    public boolean illuminates(Point3 p) {
        return true;
    }

    @Override
    public Vector3 directionFrom(Point3 p) {
        return direction.mul(-1).normalized();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import java.util.ArrayList;
import java.util.List;
import matrizen.Point2;

/**
 *
 * @author Dominik
 */
public class SamplingPattern {
    
    /**
     * Liste aus Punkten mit zufälligen Werten zwischen 0,5 und -0,5
     */
    public final List<Point2> points;
    
    /**
     * Erzeugt ein SamplingPattern. Füllt die points-Liste mit Point2-Objekten mit zufällig generierten Werten
     * zwischen 0,5 und -0,5.
     * @param points Anzahl an Punkten in der Liste.
     */
    public SamplingPattern(final int points){
        this.points = new ArrayList<>();
        for(int i = 0; i < points; i++){
            final double x = Math.random() - 0.5;
            final double y = Math.random() - 0.5;
            final Point2 point = new Point2(x, y);
            this.points.add(point);
        }
    }
    
}

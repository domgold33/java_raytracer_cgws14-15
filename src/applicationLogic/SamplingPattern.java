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
    
    public List<Point2> asDisc(){
        List<Point2> newPoints = new ArrayList<>();
        for(final Point2 p : this.points){
            double x = 2 * p.x;
            double y = 2 * p.y;
            double r = 0;
            double a = 0;
            if(x > -y){
                if(x > y){
                    r = x;
                    a = y/x;
                }else{
                    r = y;
                    a = 2 - x / y;
                }
            }else{
                if(x < y){
                    r = -x;
                    a = 4 + y/x;
                }else{
                    r = -y;
                    if(y != 0){
                        a = 6 - x / y;
                    }else{
                        a = 0;
                    }
                }
            }
            final double phi = a * Math.PI / 4;
            newPoints.add(new Point2(r * Math.cos(phi), r * Math.sin(phi)));
        }
        return newPoints;
    }
    
}

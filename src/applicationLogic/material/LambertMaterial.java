/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.material;

import applicationLogic.Color;
import applicationLogic.Hit;
import applicationLogic.World;
import applicationLogic.lighting.Light;
import matrizen.Point3;

/**
 *
 * @author Dominik
 */
public class LambertMaterial extends Material{
    
    /**
     * Diffusionsfarbe des Materials.
     */
    public final Color color;
    
    /**
     * Erzeugt ein neues Lambertmaterial, welches ein perfekt diffus reflektierendes Material darstellt.
     * @param color Diffusionsfarbe des Materials.
     */
    public LambertMaterial(final Color color){
        this.color = color;
    }
    
    @Override
    public Color colorFor(final Hit hit, final World world){
        Color temp = color.mul(world.ambientLight);
        final Point3 p = hit.ray.o.add(hit.ray.d.mul(hit.t));
        for (Light light : world.lightList) {
            if(light.illuminates(p)){
                temp = temp.add(color.mul(light.color)).mul(Math.max(0, hit.normal.dot(light.directionFrom(p))));
            }
        }
        return temp;
    }
    
}

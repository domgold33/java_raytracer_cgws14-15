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
import java.util.Objects;
import matrizen.Normal3;
import matrizen.Point3;
import matrizen.Vector3;

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
        Color colorFor = color.mul(world.ambientLight);
        final Point3 p = hit.ray.at(hit.t);
        final Normal3 n = hit.normal;
        for (Light light : world.lightList) {
            if(light.illuminates(p)){
                final Vector3 l = light.directionFrom(p);
                colorFor = colorFor.add(color.mul(light.color).mul(Math.max(0, n.dot(l))));
            }
        }
        return colorFor;
    }

    @Override
    public String toString() {
        return "LambertMaterial{" + "color=" + color + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LambertMaterial other = (LambertMaterial) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    } 
    
}

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
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class BlinnPhongMaterial extends Material{

    /**
     * Farbe der diffusen Reflektion
     */
    public final Color diffuse;
    /**
     * Farbe der spekularen Reflektion
     */
    public final Color specular;
    /**
     * Bestimmt die Größe des Glanzpunktes.
     */
    public final int exponent;
    
    /**
     * Erzeugt ein neues BlinnPhongMaterial.
     * @param diffuse Farbe der diffusen Reflektion
     * @param specular Farbe der spekularen Reflektion
     * @param exponent Bestimmt die Größe des Glanzpunktes.
     */
    public BlinnPhongMaterial(final Color diffuse, final Color specular, final int exponent){
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }
    
    @Override
    public Color colorFor(Hit hit, World world) {
        Color colorFor = diffuse.mul(world.ambientLight);
        final Point3 p = hit.ray.at(hit.t);
        for(Light light : world.lightList){
            if(light.illuminates(p)){
                final Vector3 l = light.directionFrom(p);
                final Vector3 h = l.add(hit.ray.d.mul(-1).normalized()).normalized();
                colorFor = colorFor.add(light.color.mul(this.diffuse).mul(Math.max(0, l.dot(hit.normal)))
                           .add(light.color.mul(this.specular).mul(Math.pow(Math.max(0, h.dot(hit.normal)), exponent))));
            }
        }
        return colorFor;
    }
    
}

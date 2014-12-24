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
public class PhongMaterial extends Material{
    
    /**
     * Diffusionsfarbe des Materials.
     */
    public final Color diffuse;
    /**
     * Farbe der spekularen Reflektion.
     */
    public final Color specular;
    /**
     * Exponent, welcher die Größe des Glanzpunktes beeinflusst.
     */
    public final int exponent;
    
    /**
     * Erstellt ein neues Phongmaterial, welches einen diffus und spekular reflektierenden Körper, der 
     * einen Glanzpunkt besitzt, darstellt.
     * @param diffuse Farbe der diffusen Reflektion.
     * @param specular Farbe der spekularen Reflektion.
     * @param exponent Beeinflusst die Größe des Glanzpunktes.
     */
    public PhongMaterial(final Color diffuse, final Color specular, final int exponent){
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(final Hit hit, final World world) {
        Color color = diffuse.add(world.ambientLight);
        final Point3 p = hit.ray.o.add(hit.ray.d.mul(hit.t));
        for(Light light : world.lightList){
            if(light.illuminates(p)){
                color = color.add(diffuse.mul(light.color).mul(Math.max(0, hit.normal.dot(light.directionFrom(p))))
                        .add(specular.mul(light.color).mul(Math.pow(Math.max(0, hit.normal.dot(light.directionFrom(p))), exponent))));
            }
        }
        return color;
    }
    
}

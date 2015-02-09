/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.material;

import applicationLogic.Color;
import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.World;
import applicationLogic.lighting.Light;
import matrizen.Normal3;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class ReflectiveMaterial extends Material{
    
    /**
     * Farbe der diffusen Reflexion.
     */
    public final Color diffuse;
    /**
     * Farbe der spekularen Reflexion.
     */
    public final Color specular;
    /**
     * Beeinflusst die Größe des Glanzpunktes.
     */
    public final int exponent;
    /**
     * Farbe der Spiegelung.
     */
    public final Color reflection;

    /**
     * Erzeugt ein reflektierendes Material, in dem sich andere Objekte spiegeln können.
     * @param diffuse Farbe der diffusen Reflexion.
     * @param specular Farbe der spekularen Reflexion.
     * @param exponent Bestimmt die Größe des Glanzpunktes.
     * @param reflection Farbe der Spiegelung.
     */
    public ReflectiveMaterial(final Color diffuse, final Color specular, final int exponent, final Color reflection) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
        this.reflection = reflection;
    }  

    @Override
    public Color colorFor(final Hit hit, final World world, final Tracer tracer) {
        Color colorFor = this.diffuse.mul(world.ambientLight);
        final Point3 p = hit.ray.at(hit.t);
        final Normal3 n = hit.normal;
        final Vector3 e = hit.ray.d.mul(-1).normalized();
        for(Light light : world.lightList){
            if(light.illuminates(p, world)){
                Vector3 l = light.directionFrom(p);
                Vector3 rl = l.reflectedOn(hit.normal);
                colorFor.add(light.color.mul(this.diffuse.mul(Math.max(0, n.dot(l)))).add(light.color
                             .mul(this.specular.mul(Math.pow(Math.max(0, rl.dot(e)), exponent)))));
            }
        }
        final Ray reflectedRay = new Ray(p, hit.ray.d.add(n.mul(n.dot(hit.ray.d.mul(-1)) * 2)));
        final Color reflectedColor = this.reflection.mul(tracer.colorFor(reflectedRay));
        return colorFor.add(reflectedColor);
    }
    
}

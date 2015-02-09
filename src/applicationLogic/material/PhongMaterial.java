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
public class PhongMaterial extends Material{
    
    /**
     * Diffusionsfarbe des Materials.
     */
    public final Color diffuse;
    /**
     * Farbe der spekularen Reflexion.
     */
    public final Color specular;
    /**
     * Exponent, welcher die Größe des Glanzpunktes beeinflusst.
     */
    public final int exponent;
    
    /**
     * Erstellt ein neues Phongmaterial, welches einen diffus und spekular reflektierenden Körper, der 
     * einen Glanzpunkt besitzt, darstellt.
     * @param diffuse Farbe der diffusen Reflexion.
     * @param specular Farbe der spekularen Reflexion.
     * @param exponent Beeinflusst die Größe des Glanzpunktes.
     */
    public PhongMaterial(final Color diffuse, final Color specular, final int exponent){
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(final Hit hit, final World world, final Tracer tracer) {
        Color color = diffuse.mul(world.ambientLight);
        final Point3 p = hit.ray.o.add(hit.ray.d.mul(hit.t));
        final Normal3 n = hit.normal;
        final Vector3 e = hit.ray.d;
        for(Light light : world.lightList){
            if(light.illuminates(p, world)){
                Vector3 rl = light.directionFrom(p).reflectedOn(hit.normal);
                Vector3 l = light.directionFrom(p);
                color = color.add(diffuse.mul(light.color).mul(Math.max(0, n.dot(l)))
                        .add(specular.mul(light.color).mul(Math.pow(Math.max(0, e.dot(rl)), exponent))));
            }
        }
        return color;
    }

    @Override
    public String toString() {
        return "PhongMaterial{" + "diffuse=" + diffuse + ", specular=" + specular + ", exponent=" + exponent + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.diffuse);
        hash = 73 * hash + Objects.hashCode(this.specular);
        hash = 73 * hash + this.exponent;
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
        final PhongMaterial other = (PhongMaterial) obj;
        if (!Objects.equals(this.diffuse, other.diffuse)) {
            return false;
        }
        if (!Objects.equals(this.specular, other.specular)) {
            return false;
        }
        if (this.exponent != other.exponent) {
            return false;
        }
        return true;
    }
    
}

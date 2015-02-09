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
import matrizen.Normal3;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class ReflectiveMaterial extends Material{
    
    public final Color diffuse;
    public final Color specular;
    public final int exponent;
    public final Color reflection;

    public ReflectiveMaterial(final Color diffuse, final Color specular, final int exponent, final Color reflection) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
        this.reflection = reflection;
    }  

    @Override
    public Color colorFor(Hit hit, World world) {
        Color colorFor = this.diffuse.mul(world.ambientLight);
        final Point3 p = hit.ray.at(hit.t);
        final Normal3 n = hit.normal;
        final Vector3 e = hit.ray.d;
        for(Light light : world.lightList){
            Vector3 rl = light.directionFrom(p).reflectedOn(hit.normal);
            Vector3 l = light.directionFrom(p);
        }
        return colorFor;
    }
    
}

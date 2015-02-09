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
import matrizen.Normal3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class TransparentMaterial extends Material{
    
    /**
     * Refraktionsfaktor des Materials
     */
    public double refraction;

    /**
     * Erzeugt ein transparentes Material mit dem übergebenen Refraktionsfaktor.
     * @param refraction Refraktionsfaktor des Materials.
     */
    public TransparentMaterial(final double refraction){
        this.refraction = refraction;
    }
    
    @Override
    public Color colorFor(final Hit hit, final World world, final Tracer tracer) {
        Normal3 n = hit.normal;
        final Vector3 rd = hit.ray.d.mul(-1).normalized().reflectedOn(n).normalized();
        double nq = 0;
        if(rd.dot(n) < 0){
            nq = refraction / world.refraction;
            n = n.mul(-1);
        }else{
            nq = world.refraction / refraction;
        }
        final double alpha = n.dot(rd);
        if((1 - (Math.pow(nq, 2.0) * (1 - Math.pow(alpha, 2.0)))) < 0){
            Ray ray = new Ray(hit.ray.at(hit.t - 0.0001), rd);
            return tracer.colorFor(ray);
        }else{
            final double beta = Math.sqrt(1 - (Math.pow(nq, 2.0) * (1 - Math.pow(alpha, 2.0))));
            final Vector3 v = hit.ray.d.mul(nq).sub(n.mul(beta - nq * alpha));
            final double ro = Math.pow((world.refraction - refraction) / (world.refraction + refraction), 2);
            final double r = ro + (1 - ro) * Math.pow(1 - alpha, 5);
            final double t = 1 - r;
            final Ray ray1 = new Ray(hit.ray.at(hit.t - 0.0001), rd);
            final Ray ray2 = new Ray(hit.ray.at(hit.t + 0.0001), v);
            final Color color1 = tracer.colorFor(ray1);
            final Color color2 = tracer.colorFor(ray2);
            return color1.mul(r).add(color2.mul(t));
        }
    }
    
}

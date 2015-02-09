/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.geometry;

import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.material.Material;
import matrizen.Mat3x3;
import matrizen.Normal3;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class Triangle extends Geometry{
    
    public final Point3 a;
    public final Point3 b;
    public final Point3 c;
    public final Normal3 na;
    public final Normal3 nb;
    public final Normal3 nc;

    public Triangle(final Point3 a, final Point3 b, final Point3 c, final Normal3 na, final Normal3 nb,
                    final Normal3 nc, final Material material) {
        super(material);
        this.a = a;
        this.b = b;
        this.c = c;
        this.na = na;
        this.nb = nb;
        this.nc = nc;
    }

    @Override
    public Hit hit(final Ray ray) {
        final Mat3x3 m = new Mat3x3( a.x - b.x, a.x - c.x, ray.d.x,
                a.y - b.y, a.y - c.y, ray.d.y,
                a.z - b.z, a.z - c.z, ray.d.z);
        if (m.determinant == 0){
            return null;
        }
        final Vector3 v = a.sub(ray.o);
        final double beta = m.changeCol1(v).determinant / m.determinant;
        final double gamma = m.changeCol2(v).determinant / m.determinant;
        final double alpha = 1.0 - beta - gamma;
        final double t = m.changeCol3(v).determinant / m.determinant;
        if (beta < 0.0 || gamma < 0.0 || beta + gamma > 1.0 || t < 0.0001) {
            return null;
        }
        else {
            final Normal3 n = na.mul(alpha).add(nb).mul(beta).add(nc).mul(gamma);
            return new Hit(t, ray, this, n);
        }
    } 
    
}

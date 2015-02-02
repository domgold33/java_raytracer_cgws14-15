/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.geometry;

import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.material.Material;
import java.util.List;
import java.util.Objects;
import matrizen.Transform;

/**
 *
 * @author Dominik
 */
public class Node extends Geometry{
    
    /**
     * Transformationsmatrix der Objekte
     */
    public final Transform t;
    /**
     * Geometrien des Nodeobjekts
     */
    public final List<Geometry> geoList;

    public Node(final Transform t, final List<Geometry> geoList, final Material material) {
        super(material);
        this.t = t;
        this.geoList = geoList;
    }

    @Override
    public Hit hit(Ray ray) {
        if(this.geoList.isEmpty()){
            return null;
        }
        final Ray transformedRay = this.t.mul(ray);
        Hit resultHit = geoList.get(0).hit(transformedRay);
        for(int i = 1; i < geoList.size(); i++){
            Hit hit = geoList.get(i).hit(transformedRay);
            if(resultHit == null){
                resultHit = hit;
                continue;
            }
            if(hit != null){
                if(hit.t < resultHit.t){
                    resultHit = hit;
                }
            }
        }
        if(resultHit != null){
            return new Hit(resultHit.t, ray, resultHit.geo, t.mul(resultHit.normal));
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.t);
        hash = 37 * hash + Objects.hashCode(this.geoList);
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
        final Node other = (Node) obj;
        if (!Objects.equals(this.t, other.t)) {
            return false;
        }
        if (!Objects.equals(this.geoList, other.geoList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Node{" + "t=" + t + ", geoList=" + geoList + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.geometry;

import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.material.Material;
import java.util.ArrayList;
import matrizen.Point3;
import matrizen.Transform;

/**
 *
 * @author Dominik
 */
public class AxisAlignedBox extends Geometry{
    
    /**
     * Punkt unten links
     */
    public final Point3 lbp;
    /**
     * Punkt oben rechts
     */
    public final Point3 rup;
    /**
     * Linke Seite der AAB
     */
    public final Node left;
    /**
     * Untere Seite der AAB
     */
    public final Node bottom;
    /**
     * Hinterseite der AAB
     */
    public final Node back;
    /**
     * Vorderseite der AAB
     */
    public final Node front;
    /**
     * Rechte Seite der AAB
     */
    public final Node right;
    /**
     * Obere Seite der AAB
     */
    public final Node top;
    
    /**
     * Erzeugt eine Axis-Aligned-Box mit dem übergebenen Material, welche standardmäßig im Ursprung liegt.
     * @param material Das Material der Axis-Aligned-Box.
     */
    public AxisAlignedBox(final Material material){
        super(material);
        this.lbp = new Point3(-0.5, -0.5, -0.5);
        this.rup = new Point3(0.5, 0.5, 0.5);
        ArrayList<Geometry> geos = new ArrayList<>();
        geos.add(new Plane(material));
        left = new Node(new Transform().translate(this.lbp.x, this.lbp.y, this.lbp.z).rotateZ(Math.PI/2), geos, this.material);
        bottom =  new Node(new Transform().translate(this.lbp.x, this.lbp.y, this.lbp.z).rotateX(Math.PI), geos, this.material);
        back = new Node(new Transform().translate(this.lbp.x, this.lbp.y, this.lbp.z).rotateZ(Math.PI).rotateX(-Math.PI/2), geos, this.material);
        right = new Node(new Transform().translate(this.rup.x, this.rup.y, this.rup.z).rotateZ(-Math.PI/2), geos, this.material);
        top =  new Node(new Transform().translate(this.rup.x, this.rup.y, this.rup.z), geos, this.material);
        front = new Node(new Transform().translate(this.rup.x, this.rup.y, this.rup.z).rotateZ(Math.PI).rotateX(Math.PI/2), geos, this.material);
    }
    
    @Override
    public Hit hit(Ray ray) {
        final ArrayList<Hit> hits = new ArrayList<>();
        final Hit[] planeHits1 = {left.hit(ray), right.hit(ray)};
        final Hit[] planeHits2 = {top.hit(ray), bottom.hit(ray)};
        final Hit[] planeHits3 = {front.hit(ray), back.hit(ray)};
        for (Hit hit : planeHits1) {
            if (hit != null) {
                Point3 p = ray.at(hit.t);
                if (p.y >= lbp.y && p.y <= rup.y && p.z >= lbp.z && p.z <= rup.z) {
                    hits.add(hit);
                }
            }
        }
        for (Hit hit : planeHits2) {
            if (hit != null) {
                Point3 p = ray.at(hit.t);
                if (p.x >= lbp.x && p.x <= rup.x && p.z >= lbp.z && p.z <= rup.z) {
                    hits.add(hit);
                }
            }
        }
        for (Hit hit : planeHits3) {
            if (hit != null) {
                Point3 p = ray.at(hit.t);
                if (p.x >= lbp.x && p.x <= rup.x && p.y >= lbp.y && p.y <= rup.y) {
                    hits.add(hit);
                }
            }
        }
        Hit hit = null;
        for (final Hit h : hits) {
            if (hit == null || h.t < hit.t) {
                hit = h;
            }
        }
        return hit;
    }
    
}

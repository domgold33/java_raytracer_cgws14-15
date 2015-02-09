/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizen;

import applicationLogic.Ray;

/**
 *
 * @author Dominik
 */
public class Transform {
    
    /**
     * Transformationsmatrix
     */
    public final Mat4x4 m;
    /**
     * Inverse der Transformationsmatrix
     */
    public final Mat4x4 mInverse;

    /**
     * Erzeugt eine neue Transformationsmatrix sowie ihre Inverse.
     * @param m Transformationsmatrix
     * @param mInverse Inverse
     */
    private Transform(final Mat4x4 m, final Mat4x4 mInverse) {
        this.m = m;
        this.mInverse = mInverse;
    }
    
    /**
     * Erzeugt eine Einheitsmatrix, welche später zu Transformationmatrizen umgewandelt werden kann.
     */
    public Transform(){
        this.m = new Mat4x4(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
        this.mInverse = new Mat4x4(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    }
    
    /**
     * Erzeugt eine Translationsmatrix anhand der übergebenen Werte und wendet sie auf diese
     * Transformationsmatrix an.
     * @param x Translation in x - Richtung
     * @param y Translation in y - Richtung
     * @param z Translation in z - Richtung
     * @return Ein neues Transformationsobjekt entstehend aus diesem und der erzeugten Translationsmatrix.
     */
    public Transform translate(final double x, final double y, final double z) {
        Transform t = new Transform(new Mat4x4(1, 0, 0, x,
                                               0, 1, 0, y,
                                               0, 0, 1, z,
                                               0, 0, 0, 1),
                                    new Mat4x4(1, 0, 0, -x,
                                               0, 1, 0, -y,
                                               0, 0, 1, -z,
                                               0, 0, 0, 1));
        return new Transform(m.mul(t.m), t.mInverse.mul(mInverse));
    }
    
    /**
     * Erzeugt eine Skalierungsmatrix anhand der übergebenen Werte und wendet sie auf diese
     * Transformationsmatrix an.
     * @param sx Skalierungsfaktor in x - Richtung
     * @param sy Skalierungsfaktor in y - Richtung
     * @param sz Skalierungsfaktor in z - Richtung
     * @return Ein neues Transformationsobjekt entstehend aus diesem und der erzeugten Skalierungsmatrix.
     */
    public Transform scale(final double sx, final double sy, final double sz){
        Transform t = new Transform(
                new Mat4x4(sx, 0, 0, 0,
                           0, sy, 0, 0,
                           0, 0, sz, 0,
                           0, 0, 0, 1),
                new Mat4x4(1/sx, 0, 0, 0,
                           0, 1/sy, 0, 0,
                           0, 0, 1/sz, 0,
                           0, 0, 0, 1));

        return new Transform(m.mul(t.m), t.mInverse.mul(mInverse));
    }
    
    /**
     * Erzeugt eine Rotationsmatrix für die x - Achsenrotation anhand des übergebenen Winkels und wendet
     * sie auf diese Transformationsmatrix an.
     * @param angle Der Rotationswinkel
     * @return Ein neues Transformationsobjekt entstehend aus diesem und der erzeugten Rotationsmatrix.
     */
    public Transform rotateX(final double angle){
        Transform t = new Transform(new Mat4x4(1, 0, 0, 0,
                                               0, Math.cos(angle), -Math.sin(angle), 0,
                                               0, Math.sin(angle), Math.cos(angle), 0,
                                               0, 0, 0, 1),
                                    new Mat4x4(1, 0, 0, 0,
                                               0, Math.cos(angle), Math.sin(angle), 0,
                                               0, -Math.sin(angle), Math.cos(angle), 0,
                                               0, 0, 0, 1));
        return new Transform(m.mul(t.m), t.mInverse.mul(mInverse));
    } 
    
    /**
     * Erzeugt eine Rotationsmatrix für die y - Achsenrotation anhand des übergebenen Winkels und wendet
     * sie auf diese Transformationsmatrix an.
     * @param angle Der Rotationswinkel
     * @return Ein neues Transformationsobjekt entstehend aus diesem und der erzeugten Rotationsmatrix.
     */
    public Transform rotateY(final double angle){
        Transform t = new Transform(new Mat4x4(Math.cos(angle), 0, Math.sin(angle), 0,
                                               0, 1, 0, 0,
                                               -Math.sin(angle), 0, Math.cos(angle), 0,
                                               0, 0, 0, 1),
                                    new Mat4x4(Math.cos(angle), 0, -Math.sin(angle), 0,
                                               0, 1, 0, 0,
                                               Math.sin(angle), 0, Math.cos(angle), 0,
                                               0, 0, 0, 1));
        return new Transform(m.mul(t.m), t.mInverse.mul(mInverse));
    } 
    
    /**
     * Erzeugt eine Rotationsmatrix für die z - Achsenrotation anhand des übergebenen Winkels und wendet
     * sie auf diese Transformationsmatrix an.
     * @param angle Der Rotationswinkel
     * @return Ein neues Transformationsobjekt entstehend aus diesem und der erzeugten Rotationsmatrix.
     */
    public Transform rotateZ(final double angle){
        Transform t = new Transform(new Mat4x4(Math.cos(angle), -Math.sin(angle), 0, 0, 
                                               Math.sin(angle), Math.cos(angle), 0, 0, 
                                               0, 0, 1, 0,
                                               0, 0, 0, 1),
                                    new Mat4x4(Math.cos(angle), Math.sin(angle), 0, 0,
                                               -Math.sin(angle), Math.cos(angle), 0, 0,
                                               0, 0, 1, 0,
                                               0, 0, 0, 1));
        return new Transform(m.mul(t.m), t.mInverse.mul(mInverse));
    } 
    
    /**
     * Transformiert den übergebenen mittels Multiplikation mit der Inversen.
     * @param ray Strahl, der transformiert werden soll.
     * @return Den transformierten Strahl.
     */
    public Ray mul(final Ray ray){
        return new Ray(mInverse.mul(ray.o), mInverse.mul(ray.d));
    }
    
    /**
     * Transformiert die übergebene Normale mittels Multiplikation mit der transponierten Inversen.
     * @param n Normale, die transformiert werden soll.
     * @return Die tranformierte Normale.
     */
    public Normal3 mul(final Normal3 n){
         return mInverse.transposed().mul(new Vector3(n.x, n.y, n.z)).normalized().asNormal();
    }
    
}

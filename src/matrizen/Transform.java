/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizen;

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
    public Transform(final Mat4x4 m, final Mat4x4 mInverse) {
        this.m = m;
        this.mInverse = mInverse;
    }
    
    /**
     * Erzeugt eine Einheitsmatrix, welche später zu Transformationmatrizen umgewandelt werden kann.
     */
//    public Transform(){
//        
//    }
    
}

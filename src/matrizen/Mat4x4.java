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
public class Mat4x4 {
    
    /**
     * 1. Zeile, 1. Spalte
     */
    public final double aa;
    /**
     * 1. Zeile, 2. Spalte
     */
    public final double ab;
    /**
     * 1. Zeile, 3. Spalte
     */
    public final double ac;
    /**
     * 1. Zeile, 4. Spalte
     */
    public final double ad;
    /**
     * 2. Zeile, 1. Spalte
     */
    public final double ba;
    /**
     * 2. Zeile, 2. Spalte
     */
    public final double bb;
    /**
     * 2. Zeile, 3. Spalte
     */
    public final double bc;
    /**
     * 2. Zeile, 4. Spalte
     */
    public final double bd;
    /**
     * 3. Zeile, 1. Spalte
     */
    public final double ca;
    /**
     * 3. Zeile, 2. Spalte
     */
    public final double cb;
    /**
     * 3. Zeile, 3. Spalte
     */
    public final double cc;
    /**
     * 3. Zeile, 4. Spalte
     */
    public final double cd;
    /**
     * 4. Zeile, 1. Spalte
     */
    public final double da;
    /**
     * 4. Zeile, 2. Spalte
     */
    public final double db;
    /**
     * 4. Zeile, 3. Spalte
     */
    public final double dc;
    /**
     * 4. Zeile, 4. Spalte
     */
    public final double dd;

    public Mat4x4(final double aa, final double ab, final double ac, final double ad, final double ba,
            final double bb, final double bc, final double bd, final double ca, final double cb, final double cc,
            final double cd, final double da, final double db, final double dc, final double dd) {
        this.aa = aa;
        this.ab = ab;
        this.ac = ac;
        this.ad = ad;
        this.ba = ba;
        this.bb = bb;
        this.bc = bc;
        this.bd = bd;
        this.ca = ca;
        this.cb = cb;
        this.cc = cc;
        this.cd = cd;
        this.da = da;
        this.db = db;
        this.dc = dc;
        this.dd = dd;
    }
    
    public final Vector3 mul(final Vector3 v){
        return null;
    }
    
    public final Point3 mul(final Point3 p){
        return null;
    }
    
    public final Mat4x4 mul(final Mat4x4 m){
        return null;
    }
    
}

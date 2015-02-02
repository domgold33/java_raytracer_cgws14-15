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
        final double x = v.x * aa + v.y * ab + v.z * ac;
        final double y = v.x * ba + v.y * bb + v.z * bc;
        final double z = v.x * ca + v.y * cb + v.z * cc;
        return new Vector3(x, y, z);
    }
    
    public final Point3 mul(final Point3 p){
        final double x = p.x * aa + p.y * ab + p.z * ac + ad;
        final double y = p.x * ba + p.y * bb + p.z * bc + bd;
        final double z = p.x * ca + p.y * cb + p.z * cc + cd;
        return new Point3(x, y, z);
    }
    
    public final Mat4x4 mul(final Mat4x4 m){
        final double newAa = aa * m.aa + ab * m.ba + ac * m.ca + ad * m.da;
        final double newAb = aa * m.ab + ab * m.bb + ac * m.cb + ad * m.db;
        final double newAc = aa * m.ac + ab * m.bc + ac * m.cc + ad * m.dc;
        final double newAd = aa * m.ad + ab * m.bd + ac * m.cd + ad * m.dd;
        final double newBa = ba * m.aa + bb * m.ba + bc * m.ca + bd * m.da;
        final double newBb = ba * m.ab + bb * m.bb + bc * m.cb + bd * m.db;
        final double newBc = ba * m.ac + bb * m.bc + bc * m.cc + bd * m.dc;
        final double newBd = ba * m.ad + bb * m.bd + bc * m.cd + bd * m.dd;
        final double newCa = ca * m.aa + cb * m.ba + cc * m.ca + cd * m.da;
        final double newCb = ca * m.ab + cb * m.bb + cc * m.cb + cd * m.db;
        final double newCc = ca * m.ac + cb * m.bc + cc * m.cc + cd * m.dc;
        final double newCd = ca * m.ad + cb * m.bd + cc * m.cd + cd * m.dd;
        final double newDa = da * m.aa + db * m.ba + dc * m.ca + dd * m.da;
        final double newDb = da * m.ab + db * m.bb + dc * m.cb + dd * m.db;
        final double newDc = da * m.ac + db * m.bc + dc * m.cc + dd * m.dc;
        final double newDd = da * m.ad + db * m.bd + dc * m.cd + dd * m.dd;
        return new Mat4x4( newAa, newAb, newAc, newAd,
                           newBa, newBb, newBc, newBd,
                           newCa, newCb, newCc, newCd,
                           newDa, newDb, newDc, newDd );
    }
    
    public Mat4x4 transposed(){
        final double newAa = aa;
        final double newAb = ba;
        final double newAc = ca;
        final double newAd = da;
        final double newBa = ab;
        final double newBb = bb;
        final double newBc = cb;
        final double newBd = db;
        final double newCa = ac;
        final double newCb = bc;
        final double newCc = cc;
        final double newCd = dc;
        final double newDa = ad;
        final double newDb = bd;
        final double newDc = cd;
        final double newDd = dd;
        return new Mat4x4( newAa, newAb, newAc, newAd,
                           newBa, newBb, newBc, newBd,
                           newCa, newCb, newCc, newCd,
                           newDa, newDb, newDc, newDd );
    }
    
}

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
public final class Mat3x3 {
    
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
     * Determinante der Matrix
     */
    public final double determinant;
    
    /**
     * Konstruktor zur Erstellung einer 3x3 Matrix
     * @param aa 1. Zeile, 1. Spalte
     * @param ab 1. Zeile, 2. Spalte
     * @param ac 1. Zeile, 3. Spalte
     * @param ba 2. Zeile, 1. Spalte
     * @param bb 2. Zeile, 2. Spalte
     * @param bc 2. Zeile, 3. Spalte
     * @param ca 3. Zeile, 1. Spalte
     * @param cb 3. Zeile, 2. Spalte
     * @param cc 3. Zeile, 3. Spalte
     */
    public Mat3x3(final double aa, final double ab, final double ac, final double ba, final double bb,
            final double bc, final double ca, final double cb, final double cc){
        this.aa = aa;
        this.ab = ab;
        this.ac = ac;
        this.ba = ba;
        this.bb = bb;
        this.bc = bc;
        this.ca = ca;
        this.cb = cb;
        this.cc = cc;
        this.determinant = aa * bb * cc + ab * bc * ca + ac * ba * cb - ca * bb * ac - cb * bc * aa - cc * ba * ab;
    }
    
    public Mat3x3 mul(Mat3x3 m){
        final double resultAa = aa * m.aa + ab * m.ba + ac * m.ca;
        final double resultBa = ba * m.aa + bb * m.ba + bc * m.ca;
        final double resultCa = ca * m.aa + cb * m.ba + cc * m.ca;
        final double resultAb = aa * m.ab + ab * m.bb + ac * m.bc;
        final double resultBb = ba * m.ab + bb * m.bb + bc * m.bc;
        final double resultCb = ca * m.ab + cb * m.bb + cc * m.bc;
        final double resultAc = aa * m.ac + ab * m.bc + ac * m.cc;
        final double resultBc = ba * m.ac + bb * m.bc + bc * m.cc;
        final double resultCc = ca * m.ac + cb * m.bc + cc * m.cc;
        Mat3x3 result = new Mat3x3(resultAa, resultAb, resultAc, resultBa, resultBb, resultBc, resultCa, resultCb, resultCc);
        return result;
    }
    
    public Vector3 mul(Vector3 v){
        final double resultX = aa * v.x + ab * v.y + ac * v.z;
        final double resultY = ba * v.x + bb * v.y + bc * v.z;
        final double resultZ = ca * v.x + cb * v.y + cc * v.z;
        Vector3 result = new Vector3(resultX, resultY, resultZ);
        return result;
    }
    
    public Point3 mul(Point3 p){
        final double resultX = aa * p.x + ab * p.y + ac * p.z;
        final double resultY = ba * p.x + bb * p.y + bc * p.z;
        final double resultZ = ca * p.x + cb * p.y + cc * p.z;
        Point3 result = new Point3(resultX, resultY, resultZ);
        return result;
    }
    
    public Mat3x3 changeCol1(Vector3 v){
        Mat3x3 newMat = new Mat3x3(v.x, ab, ac, v.y, bb, bc, v.z, cb, cc);
        return newMat;
    }
    
    public Mat3x3 changeCol2(Vector3 v){
        Mat3x3 newMat = new Mat3x3(aa, v.x, ac, ba, v.y, bc, ca, v.z, cc);
        return newMat;
    }
    
    public Mat3x3 changeCol3(Vector3 v){
        Mat3x3 newMat = new Mat3x3(aa, ab, v.x, ba, bb, v.y, ca, cb, v.z);
        return newMat;
    }
      
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.aa) ^ (Double.doubleToLongBits(this.aa) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.ab) ^ (Double.doubleToLongBits(this.ab) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.ac) ^ (Double.doubleToLongBits(this.ac) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.ba) ^ (Double.doubleToLongBits(this.ba) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.bb) ^ (Double.doubleToLongBits(this.bb) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.bc) ^ (Double.doubleToLongBits(this.bc) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.ca) ^ (Double.doubleToLongBits(this.ca) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.cb) ^ (Double.doubleToLongBits(this.cb) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.cc) ^ (Double.doubleToLongBits(this.cc) >>> 32));
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
        final Mat3x3 other = (Mat3x3) obj;
        if (Double.doubleToLongBits(this.aa) != Double.doubleToLongBits(other.aa)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ab) != Double.doubleToLongBits(other.ab)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ac) != Double.doubleToLongBits(other.ac)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ba) != Double.doubleToLongBits(other.ba)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bb) != Double.doubleToLongBits(other.bb)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bc) != Double.doubleToLongBits(other.bc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ca) != Double.doubleToLongBits(other.ca)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cb) != Double.doubleToLongBits(other.cb)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cc) != Double.doubleToLongBits(other.cc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mat3x3{" + "aa=" + aa + ", ab=" + ab + ", ac=" + ac + ", ba=" + ba + ", bb=" + bb + ", bc=" + bc + ", ca=" + ca + ", cb=" + cb + ", cc=" + cc + '}';
    }
    
}

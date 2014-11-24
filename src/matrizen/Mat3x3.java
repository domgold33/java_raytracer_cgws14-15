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
    
    public final double aa;
    public final double ab;
    public final double ac;
    public final double ba;
    public final double bb;
    public final double bc;
    public final double ca;
    public final double cb;
    public final double cc;
    public final double determinant;
    
    public Mat3x3(double aa, double ab, double ac, double ba, double bb, double bc, double ca, double cb, double cc){
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
        double resultAa = aa * m.aa + ab * m.ba + ac * m.ca;
        double resultBa = ba * m.aa + bb * m.ba + bc * m.ca;
        double resultCa = ca * m.aa + cb * m.ba + cc * m.ca;
        double resultAb = aa * m.ab + ab * m.bb + ac * m.bc;
        double resultBb = ba * m.ab + bb * m.bb + bc * m.bc;
        double resultCb = ca * m.ab + cb * m.bb + cc * m.bc;
        double resultAc = aa * m.ac + ab * m.bc + ac * m.cc;
        double resultBc = ba * m.ac + bb * m.bc + bc * m.cc;
        double resultCc = ca * m.ac + cb * m.bc + cc * m.cc;
        Mat3x3 result = new Mat3x3(resultAa, resultAb, resultAc, resultBa, resultBb, resultBc, resultCa, resultCb, resultCc);
        return result;
    }
    
    public Vector3 mul(Vector3 v){
        double resultX = aa * v.x + ab * v.y + ac * v.z;
        double resultY = ba * v.x + bb * v.y + bc * v.z;
        double resultZ = ca * v.x + cb * v.y + cc * v.z;
        Vector3 result = new Vector3(resultX, resultY, resultZ);
        return result;
    }
    
    public Point3 mul(Point3 p){
        double resultX = aa * p.x + ab * p.y + ac * p.z;
        double resultY = ba * p.x + bb * p.y + bc * p.z;
        double resultZ = ca * p.x + cb * p.y + cc * p.z;
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
    
    public boolean equals(Mat3x3 m){
        return m.aa == aa && m.ab == ab && m.ac == ac && m.ba == ba && m.bb == bb && m.bc == bc && 
                m.ca == ca && m.cb == cb && m.cc == cc;
    }
    
}

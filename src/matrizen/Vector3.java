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
public final class Vector3 {
    
    /**
     * x - Wert des Vektors
     */
    public final double x;
    /**
     * y - Wert des Vektors
     */
    public final double y;
    /**
     * z - Wert des Vektors
     */
    public final double z;
    /**
     * Länge des Vektors
     */
    public final double magnitude;
    
    /**
     * Konstruktor zur Erstellung eines Vektors im dreidimensionalen Raum
     * @param x x - Wert
     * @param y y - Wert
     * @param z z - Wert
     */
    public Vector3(final double x, final double y, final double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.magnitude = Math.sqrt(x*x + y*y + z*z);
    }
    
    public Vector3 add(Vector3 v){
        return new Vector3(x + v.x, y + v.y, z + v.z);
    }
    
    public Vector3 add(Normal3 n){
        return new Vector3(x + n.x, y + n.y, z + n.z);
    }
    
    public Vector3 sub(Normal3 n){
        return new Vector3(x - n.x, y - n.y, z - n.z);
    }
    
    public Vector3 mul(final double c){
        return new Vector3(x * c, y * c, z * c);
    }
    
    public double dot(Vector3 v){
        return x * v.x + y * v.y + z * v.z;
    }
    
    public double dot(Normal3 n){
        return x * n.x + y * n.y + z * n.z;
    }
    
    public Vector3 normalized(){
        return new Vector3(x / magnitude, y / magnitude, z / magnitude);
    }
    
    public Normal3 asNormal(){
        return new Normal3(x, y, z);
    }
    
    public Vector3 reflectedOn(Normal3 n){
        final double dot = n.dot(this) * -2;
        Normal3 normal = n.mul(dot);
        Vector3 result = this.add(normal);
        return result;
    }
    
    public Vector3 x(Vector3 v){
        return new Vector3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
        final Vector3 other = (Vector3) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vector3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
}

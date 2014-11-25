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
public final class Normal3 {
    
    /**
     * x - Wert des Normalenvektors
     */
    public final double x;
    /**
     * y - Wert des Normalenvektors
     */
    public final double y;
    /**
     * z - Wert des Normalenvektors
     */
    public final double z;
    
    /**
     * Konstruktor zur Erstellung eines Normalenvektors im dreidimensionalen Raum
     * @param x x - Wert
     * @param y y - Wert
     * @param z z - Wert
     */
    public Normal3(final double x, final double y, final double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Normal3 mul(final double c){
        return new Normal3(x * c, y * c, z * c);
    }
    
    public Normal3 add(Normal3 n){
        return new Normal3(x + n.x, y + n.y, z + n.z);
    }
    
    public double dot(Vector3 v){
        return x * v.x + y * v.y + z * v.z;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
        final Normal3 other = (Normal3) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Normal3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
}

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
public final class Point3 {
    
    /***
     * x - Koordinate des Punktes
     */
    public final double x;
    /***
     * y - Koordinate des Punktes
     */
    public final double y;
    /***
     * z - Koordinate des Punktes
     */
    public final double z;
    
    /***
     * Konstruktor fr die Erstellung eines Punktes im dreidimensionalen Raum
     * @param x x - Koordinate
     * @param y y - Koordinate
     * @param z z - Koordinate
     */
    public Point3(final double x, final double y, final double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3 sub(Point3 p){
        return new Vector3(x - p.x, y - p.y, z - p.z);
    }
    
    public Point3 sub(Vector3 v){
        return new Point3(x - v.x, y - v.y, z - v.z);
    }
    
    public Point3 add(Vector3 v){
        return new Point3(x + v.x, y + v.y, z + v.z);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
        final Point3 other = (Point3) obj;
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
        return "Point3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
}

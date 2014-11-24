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
    
    public final double x;
    public final double y;
    public final double z;
    
    public Point3(double x, double y, double z){
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
    
    public boolean equals(Point3 p){
        return p.x == x && p.y == y && p.z == z;
    }
    
}

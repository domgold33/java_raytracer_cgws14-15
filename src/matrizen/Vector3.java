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
    
    public final double x;
    public final double y;
    public final double z;
    public final double magnitude;
    
    public Vector3(double x, double y, double z){
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
    
    public Vector3 mul(double c){
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
        double dot = n.dot(this) * -2;
        Normal3 normal = n.mul(dot);
        Vector3 result = this.add(normal);
        return result;
    }
    
    public Vector3 x(Vector3 v){
        return new Vector3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }
    
    public boolean equals(Vector3 v){
        return v.x == x && v.y == y && v.z == z;
    }   
    
}

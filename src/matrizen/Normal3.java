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
    
    public final double x;
    public final double y;
    public final double z;
    
    public Normal3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Normal3 mul(double c){
        return new Normal3(x * c, y * c, z * c);
    }
    
    public Normal3 add(Normal3 n){
        return new Normal3(x + n.x, y + n.y, z + n.z);
    }
    
    public double dot(Vector3 v){
        return x * v.x + y * v.y + z * v.z;
    }
    
    public boolean equals(Normal3 n){
        return n.x == x && n.y == y && n.z == z;
    }
    
}

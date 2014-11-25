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
    
    /**
     * Addiert den gegebenen Vektor zu diesem Vektor.
     * @param v Der zu addierende Vektor
     * @return Das Ergebnis als neuer Vektor.
     */
    public Vector3 add(final Vector3 v){
        return new Vector3(x + v.x, y + v.y, z + v.z);
    }
    
    /**
     * Addiert den gegebenen Normalenvektor zu diesem Vektor.
     * @param n Der zu addierende Normalenvektor
     * @return Das Ergebnis als neuer Vektor.
     */
    public Vector3 add(final Normal3 n){
        return new Vector3(x + n.x, y + n.y, z + n.z);
    }
    
    /**
     * Subtrahiert den gegebenen Normalenvektor von diesem Vektor.
     * @param n Der zu subtrahierende Normalenvektor
     * @return Das Ergebnis als neuer Vektor.
     */
    public Vector3 sub(final Normal3 n){
        return new Vector3(x - n.x, y - n.y, z - n.z);
    }
    
    /**
     * Multipliziert diesen Vektor mit dem gegebenen Wert.
     * @param c Der Wert, mit dem multipliziert wird
     * @return Das Ergebnis als neuer Vektor.
     */
    public Vector3 mul(final double c){
        return new Vector3(x * c, y * c, z * c);
    }
    
    /**
     * Bildet das Skalarprodukt dieses Vektors mit dem übergebenen.
     * @param v Der 2. Faktor des Skalarpodukts.
     * @return Das Ergebnis.
     */
    public double dot(final Vector3 v){
        return x * v.x + y * v.y + z * v.z;
    }
    
    /**
     * Bildet das Skalarprodukt dieses Vektors mit dem übergebenen Normalenvektor.
     * @param n Der 2. Faktor des Skalarpodukts.
     * @return Das Ergebnis.
     */
    public double dot(final Normal3 n){
        return x * n.x + y * n.y + z * n.z;
    }
    
    /**
     * Bringt die Länge des Vektors auf 1.
     * @return Der normalisierte Vektor.
     */
    public Vector3 normalized(){
        return new Vector3(x / magnitude, y / magnitude, z / magnitude);
    }
    
    /**
     * Wandelt den Vektor in einen Normalenvektor um.
     * @return Der Vektor als neuer Normalenvektor
     */
    public Normal3 asNormal(){
        return new Normal3(x, y, z);
    }
    
    /**
     * Reflektiert den Vektor an dem gegebenen Normalenvektor.
     * @param n Der Normalenvektor, an dem reflektiert wird.
     * @return der entstandene Vektor
     */
    public Vector3 reflectedOn(final Normal3 n){
        final double dot = n.dot(this) * -2;
        final Normal3 normal = n.mul(dot);
        final Vector3 result = this.add(normal);
        return result;
    }
    
    /**
     * Bildet das Kreuzprodukt des Vektors mit dem Übergebenen.
     * @param v Der 2. Faktor des Kreuzprodukts
     * @return Das Ergebnis als neuer Vektor.
     */
    public Vector3 x(final Vector3 v){
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

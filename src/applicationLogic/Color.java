/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

/**
 *
 * @author Dominik
 */
public class Color {
    
    /**
     * Rotwert der Farbe, zwischen 0 und 1
     */
    public final double r;
    /**
     * Grünwert der Farbe, zwischen 0 und 1
     */
    public final double g;
    /**
     * Blauwert der Farbe, zwischen 0 und 1
     */
    public final double b;
    
    /**
     * Erzeugt eine neue Farbe mit den übergebenen RGB - Werten.
     * @param r Rotwert der Farbe, zwischen 0 und 1
     * @param g Grünwert der Farbe, zwischen 0 und 1
     * @param b Blauwert der Farbe, zwischen 0 und 1
     */
    public Color(final double r, final double g, final double b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    /**
     * Addiert diese Farbe mit der Übergebenen und gibt das Ergebnis als neues Farbobjekt zurück.
     * @param c Farbe, welche addiert werden soll
     * @return Das Ergebnis als neues Farbobjekt
     */
    public Color add(final Color c){
        double resultR = this.r + c.r;
        double resultG = this.g + c.g;
        double resultB = this.b + c.b;
        if(resultR > 1){
            resultR = 1;
        }
        if(resultG > 1){
            resultG = 1;
        }
        if(resultB > 1){
            resultB = 1;
        }
        return new Color(resultR, resultG, resultB);
    }
    
    /**
     * Subtrahiert die übergebene Farbe von dieser und gibt das Ergebnis als neues Farbobjekt zurück.
     * @param c Subtrahent
     * @return Das Ergebnis als neues Farbobjekt.
     */
    public Color sub(final Color c){
        double resultR = this.r - c.r;
        double resultG = this.g - c.g;
        double resultB = this.b - c.b;
        if(resultR < 0){
            resultR = 0;
        }
        if(resultG < 0){
            resultG = 0;
        }
        if(resultB < 0){
            resultB = 0;
        }
        return new Color(resultR, resultG, resultB);
    }
    
    /**
     * Multipliziert diese Farbe mit der Übergebenen und gibt das Ergebnis als neues Farbobjekt zurück.
     * @param c Farbe, mit welcher multipliziert werden soll
     * @return Das Ergebnis als neues Farbobjekt
     */
    public Color mul(final Color c){
        double resultR = this.r * c.r;
        double resultG = this.g * c.g;
        double resultB = this.b * c.b;
        if(resultR > 1){
            resultR = 1;
        }
        if(resultG > 1){
            resultG = 1;
        }
        if(resultB > 1){
            resultB = 1;
        }
        return new Color(resultR, resultG, resultB);
    }
    
    /**
     * Multipliziert diese Farbe mit dem übergebenen Wert und gibt das Ergebnis als neues Farbobjekt
     * zurück.
     * @param v Wert, mit dem multipliziert werden soll
     * @return Das Ergebnis als neues Farbobjekt
     */
    public Color mul(final double v){
        double resultR = this.r * v;
        double resultG = this.g * v;
        double resultB = this.b * v;
        if(resultR > 1){
            resultR = 1;
        }
        if(resultG > 1){
            resultG = 1;
        }
        if(resultB > 1){
            resultB = 1;
        }
        return new Color(resultR, resultG, resultB);
    }
    
}

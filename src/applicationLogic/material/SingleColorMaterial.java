/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.material;

import applicationLogic.Color;
import applicationLogic.Hit;
import applicationLogic.World;
import java.util.Objects;

/**
 *
 * @author Dominik
 */
public class SingleColorMaterial extends Material{
    
    /**
     * Farbe des Materials.
     */
    public final Color color;
    
    /**
     * Erzeugt ein neues Material, welches eine gleichmäßige Farbe auf seiner gesamten Fläche besitzt.
     * @param color Farbe des Materials.
     */
    public SingleColorMaterial(final Color color){
        this.color = color;
    }

    @Override
    public Color colorFor(final Hit hit, final World world) {
        return color;
    }

    @Override
    public String toString() {
        return "SingleColorMaterial{" + "color=" + color + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.color);
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
        final SingleColorMaterial other = (SingleColorMaterial) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }
   
}

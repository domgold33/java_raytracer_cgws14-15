/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.material;

import applicationLogic.Color;
import applicationLogic.Hit;
import applicationLogic.World;

/**
 *
 * @author Dominik
 */
public abstract class Material {

    /**
     * Ermittelt die Farbe des Materials an dem übergebenen Schnittpunkt auf einer Geometrie.
     * @param hit Schnittpunkt, für den die Farbe berechnet werden soll.
     * @param world Welt, in der sich die Geometrie, die mit diesem Material versehen ist, befindet.
     * @return Farbe an der Position des Schnittpunkts.
     */
    public abstract Color colorFor(final Hit hit, final World world);
    
}

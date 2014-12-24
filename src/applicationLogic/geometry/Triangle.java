/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic.geometry;

import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.material.Material;

/**
 *
 * @author Dominik
 */
public class Triangle extends Geometry{

    public Triangle(final Material material) {
        super(material);
    }

    @Override
    public Hit hit(final Ray ray) {
        return null;
    } 
    
}

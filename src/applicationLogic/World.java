/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dominik
 */
public class World {
    
    public final List<Geometry> geoList;
    
    public World(){
        this.geoList = new ArrayList<>();
    }
    
    public Hit hit(Ray ray){
        return null;
    }
    
}

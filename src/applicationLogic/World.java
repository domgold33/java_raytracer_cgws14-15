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
    
    /**
     * Enthält sämtliche Geometrien in dieser Welt.
     */
    public final List<Geometry> geoList;
    
    /**
     * Erzeugt eine neue Welt.
     */
    public World(){
        this.geoList = new ArrayList<>();
    }
    
    /**
     * Führt Schnittpunktberechnungen mit dem übergebenen Strahl für sämtliche Geometrien dieser Welt durch.
     * @param ray Der Strahl, mit dem die Schnittpunktberechnungen durchgeführt werden sollen
     * @return Ein Hitobjekt welches die Daten über den Schnittpunkt des Strahls und der Geometrie enthält,
     * bei dem der Faktor t des Richtugsvektors den kleinsten positiven Wert annimmt. Gibt null zurück wenn7
     * kein Schnittpunkt gefunden wird oder diese Welt keine Geometrien enthält.
     */
    public Hit hit(Ray ray){
        if(!geoList.isEmpty()){
            Hit resultHit = geoList.get(0).hit(ray);
            for(int i = 0; i < geoList.size(); i++){
                final Hit tempHit = geoList.get(i).hit(ray);
                if(resultHit == null){
                    resultHit = tempHit;
                }else{
                    if(tempHit.t < resultHit.t && tempHit.t > 0){
                        resultHit = tempHit;
                    }
                }
            }
            return resultHit;
        }else{
            return null;
        }
    }
    
}

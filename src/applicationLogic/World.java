/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationLogic;

import applicationLogic.geometry.Geometry;
import applicationLogic.lighting.Light;
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
    public final List<Light> lightList;
    public final Color backgroundColor;
    public final Color ambientLight;
    public final double refraction;
    
    /**
     * Erzeugt eine neue Welt.
     * @param backgroundColor Hintergrundfarbe der Welt.
     * @param ambient Ambientes Licht der Welt.
     */
    public World(final Color backgroundColor, final Color ambient){
        this.geoList = new ArrayList<>();
        this.lightList = new ArrayList<>();
        this.backgroundColor = backgroundColor;
        this.ambientLight = ambient;
        this.refraction = 2;
    }
    
    /**
     * Führt Schnittpunktberechnungen mit dem übergebenen Strahl für sämtliche Geometrien dieser Welt durch.
     * @param ray Der Strahl, mit dem die Schnittpunktberechnungen durchgeführt werden sollen
     * @return Ein Hitobjekt welches die Daten über den Schnittpunkt des Strahls und der Geometrie enthält,
     * bei dem der Faktor t des Richtugsvektors den kleinsten positiven Wert annimmt. Gibt null zurück wenn7
     * kein Schnittpunkt gefunden wird oder diese Welt keine Geometrien enthält.
     */
    public Hit hit(final Ray ray){
        if(!geoList.isEmpty()){
            Hit resultHit = geoList.get(0).hit(ray);
            for(int i = 1; i < geoList.size(); i++){
                final Hit tempHit = geoList.get(i).hit(ray);
                if(resultHit == null){
                    resultHit = tempHit;
                }else{
                    if(tempHit != null){
                        if(tempHit.t < resultHit.t){
                            resultHit = tempHit;
                        }
                    }
                }
            }
            return resultHit;
        }else{
            return null;
        }
    }
    
}

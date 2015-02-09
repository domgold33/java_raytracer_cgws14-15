/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createImage;

import applicationLogic.Color;
import applicationLogic.camera.Camera;
import applicationLogic.Hit;
import applicationLogic.Ray;
import applicationLogic.World;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.List;

/**
 *
 * @author Dominik
 */
public class CreateImageCanvas extends Canvas{
    
    public BufferedImage image; 
    
    private final World world;
    private Camera camera;
    
    public CreateImageCanvas(final World world, final Camera camera){
        this.world = world;
        this.camera = camera;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        image = new BufferedImage(CreateImageMain.frame.getWidth(), CreateImageMain.frame.getHeight() - 60, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = image.getRaster();
        ColorModel cm = image.getColorModel();
        for(int i = 0; i < image.getHeight(); i++){
            for(int j = 0; j < image.getWidth(); j++){
                List<Ray> rays = camera.rayFor(image.getWidth(), image.getHeight(), j, i);
                final Color[] colors = new Color[rays.size()];
                for(int x = 0; x < rays.size(); x++){
                    final Ray ray = rays.get(x);
                    Hit hit = world.hit(ray);
                    Color tempColor = null;
                    if(hit == null){
                        tempColor = world.backgroundColor;
                    }else{
                        tempColor = hit.geo.material.colorFor(hit, world);
                    }
                    colors[x] = tempColor;
                }
                double red = 0;
                double green = 0;
                double blue = 0;
                for(Color c : colors){
                    red += c.r;
                    green += c.g;
                    blue += c.b;
                }
                red = red / colors.length;
                green = green / colors.length;
                blue = blue / colors.length;
                float[] color = {(float) red, (float) green, (float) blue, 1.0f}; 
                raster.setDataElements(j, image.getHeight() - i - 1, cm.getDataElements(color, 0, null));
            }
        }
        g.drawImage(image, 0, 0, null);
    }
    
    public void setCamera(final Camera camera){
        this.camera = camera;
    }
    
}

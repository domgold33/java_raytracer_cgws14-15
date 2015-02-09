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
import applicationLogic.material.Tracer;
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
        Runnable run1 = () -> {
            for (int i = 0; i < image.getHeight() / 4; i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    List<Ray> rays = camera.rayFor(image.getWidth(), image.getHeight(), j, i);
                    final Color[] colors = new Color[rays.size()];
                    for (int x1 = 0; x1 < rays.size(); x1++) {
                        final Ray ray = rays.get(x1);
                        Hit hit = world.hit(ray);
                        Color tempColor = null;
                        if(hit == null){
                            tempColor = world.backgroundColor;
                        }else{
                            tempColor = hit.geo.material.colorFor(hit, world, new Tracer(world, world.refraction));
                        }
                        colors[x1] = tempColor;
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
                g.drawImage(image, 0, 0, null);
            }
        };
        Runnable run2 = () -> {
            for (int i = image.getHeight() / 4; i < image.getHeight() / 2; i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    List<Ray> rays = camera.rayFor(image.getWidth(), image.getHeight(), j, i);
                    final Color[] colors = new Color[rays.size()];
                    for (int x1 = 0; x1 < rays.size(); x1++) {
                        final Ray ray = rays.get(x1);
                        Hit hit = world.hit(ray);
                        Color tempColor = null;
                        if(hit == null){
                            tempColor = world.backgroundColor;
                        }else{
                            tempColor = hit.geo.material.colorFor(hit, world, new Tracer(world, world.refraction));
                        }
                        colors[x1] = tempColor;
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
                g.drawImage(image, 0, 0, null);
            }
        };
        Runnable run3 = () -> {
            for (int i = image.getHeight() / 2; i < (image.getHeight() / 4) * 3; i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    List<Ray> rays = camera.rayFor(image.getWidth(), image.getHeight(), j, i);
                    final Color[] colors = new Color[rays.size()];
                    for (int x1 = 0; x1 < rays.size(); x1++) {
                        final Ray ray = rays.get(x1);
                        Hit hit = world.hit(ray);
                        Color tempColor = null;
                        if(hit == null){
                            tempColor = world.backgroundColor;
                        }else{
                            tempColor = hit.geo.material.colorFor(hit, world, new Tracer(world, world.refraction));
                        }
                        colors[x1] = tempColor;
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
                g.drawImage(image, 0, 0, null);
            }
        };
        Runnable run4 = () -> {
            for (int i = (image.getHeight() / 4) * 3; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    List<Ray> rays = camera.rayFor(image.getWidth(), image.getHeight(), j, i);
                    final Color[] colors = new Color[rays.size()];
                    for (int x1 = 0; x1 < rays.size(); x1++) {
                        final Ray ray = rays.get(x1);
                        Hit hit = world.hit(ray);
                        Color tempColor = null;
                        if(hit == null){
                            tempColor = world.backgroundColor;
                        }else{
                            tempColor = hit.geo.material.colorFor(hit, world, new Tracer(world, world.refraction));
                        }
                        colors[x1] = tempColor;
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
                g.drawImage(image, 0, 0, null);
            }
        };
        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);
        Thread thread4 = new Thread(run4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch(InterruptedException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void setCamera(final Camera camera){
        this.camera = camera;
    }
    
}

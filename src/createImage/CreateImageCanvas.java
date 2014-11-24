/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createImage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 *
 * @author Dominik
 */
public class CreateImageCanvas extends Canvas{
    
    private BufferedImage image;
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        image = new BufferedImage(CreateImageMain.frame.getWidth(), CreateImageMain.frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = image.getRaster();
        ColorModel cm = image.getColorModel();
        for(int i = 0; i < image.getHeight(); i++){
            for(int j = 0; j < image.getWidth(); j++){
                raster.setDataElements(j, i, cm.getDataElements(Color.BLACK.getRGB(), null));
                if(i == j){
                    raster.setDataElements(j, i, cm.getDataElements(Color.RED.getRGB(), null));
                }
            }
        }
        g.drawImage(image, 0, 0, null);
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
}

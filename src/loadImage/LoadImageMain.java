/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Dominik
 */
public class LoadImageMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //hallo git
        createImageView();
    }
    
    public static void createImageView(){
        JFrame frame = new JFrame("ImageTest");
        JFileChooser fileShow = new JFileChooser("C:/Users/Dominik/Pictures/unistuff");
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File f) {
                int lastIndexOf = f.getName().lastIndexOf(".");
                String extension = f.getName().substring(lastIndexOf);
                return extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".jpeg") || extension.equalsIgnoreCase(".png");
            }

            @Override
            public String getDescription() {
                return "JPG and PNG files";
            }
        };
        fileShow.addChoosableFileFilter(filter);
        int returnVal = fileShow.showOpenDialog(frame);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            createImagePanel(fileShow.getSelectedFile());
            fileShow.setVisible(false);
        }
    }
    
    public static void createImagePanel(File file){
        try{
            JFrame imageFrame = new JFrame("Image");
            BufferedImage img = ImageIO.read(file);
            ImagePanel panel = new ImagePanel(img);
            imageFrame.add(panel);
            imageFrame.setSize(img.getWidth(panel), img.getHeight(panel));
            panel.setVisible(true);
            imageFrame.setVisible(true);
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
}

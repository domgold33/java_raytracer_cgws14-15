/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dominik
 */
public class MenuBarListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(e.getActionCommand().equals(ImageMenuBar.SAVE_MESSAGE)){
            saveImage();
        }
    }
    
    public void saveImage(){
        JFrame chooserFrame = new JFrame("Save image");
        FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter("jpg", "jpg");
        FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("png", "png");
        JFileChooser chooser = new JFileChooser("Save image");
        chooser.addChoosableFileFilter(jpgFilter);
        chooser.addChoosableFileFilter(pngFilter);
        int returnVal = chooser.showSaveDialog(chooserFrame);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            String filePath = chooser.getSelectedFile().getAbsolutePath();
            String extension = "." + chooser.getFileFilter().getDescription();
            if(extension.equalsIgnoreCase(".png")){
                try{
                    ImageIO.write(CreateImageMain.canvas.getImage(), "png", new File(filePath + extension));
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }else{
                try{
                    ImageIO.write(CreateImageMain.canvas.getImage(), "jpg", new File(filePath + extension));
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
}

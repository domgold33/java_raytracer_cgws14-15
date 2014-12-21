/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createImage;

import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JMenuBar;

/**
 *
 * @author Dominik
 */
public class ImageMenuBar extends JMenuBar{
    
    public static final String SAVE_MESSAGE = "Save image";
    
    public ImageMenuBar(final CreateImageCanvas image){
        final JButton saveButton = new JButton("Save");
        add(saveButton);
        saveButton.setActionCommand(SAVE_MESSAGE);
        saveButton.addActionListener(new MenuBarListener(image));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createImage;

import javax.swing.JFrame;

/**
 *
 * @author Dominik
 */
public class CreateImageMain {
    
    public static final JFrame frame = new JFrame("Draw an image");;
    public static final CreateImageCanvas canvas = new CreateImageCanvas();;
    
    public static void main(String[] args){
        frame.setSize(640, 480);
        frame.add(canvas);
        frame.setJMenuBar(new ImageMenuBar());
        frame.setVisible(true);
    }
    
}

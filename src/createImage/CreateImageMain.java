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
    
    public static JFrame frame;
    public static CreateImageCanvas canvas;
    
    public static void main(String[] args){
        canvas = new CreateImageCanvas();
        frame = new JFrame("Draw an image");
        frame.setSize(640, 480);
        frame.add(canvas);
        frame.setJMenuBar(new ImageMenuBar());
        frame.setVisible(true);
    }
    
}

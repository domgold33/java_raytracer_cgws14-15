/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createImage;

import applicationLogic.camera.Camera;
import applicationLogic.Color;
import applicationLogic.geometry.Geometry;
import applicationLogic.camera.OrtographicCamera;
import applicationLogic.camera.PerspectiveCamera;
import applicationLogic.geometry.Plane;
import applicationLogic.geometry.Sphere;
import applicationLogic.World;
import javax.swing.JFrame;
import matrizen.Normal3;
import matrizen.Point3;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class CreateImageMain {
    
    public static final JFrame frame = new JFrame("Draw an image");;
    
    public static void main(String[] args){
        frame.setSize(640, 520);
/*        final World world = new World(new Color(0, 0, 0));
        final Camera camera1 = new PerspectiveCamera(new Point3(0, 0, 0), new Vector3(0, 0, -1), new Vector3(0, 1, 0), Math.PI / 4);
        final Camera camera2 = new OrtographicCamera(new Point3(0, 0, 0), new Vector3(0, 0, -1), new Vector3(0, 1, 0), 3);
//        Kriterium 1
        final Geometry plane = new Plane(new Point3(0, -1, 0), new Normal3(0, 1, 0), new Color(0, 1, 0));
//        world.geoList.add(plane);
//        Kriterium 2
        final Geometry sphere = new Sphere(new Point3(-1, 0, -3), 0.5, new Color(1, 0, 0));
//        world.geoList.add(sphere);
//        Kriterium 3 & 4
        final Geometry sphere2 = new Sphere(new Point3(1, 0, -6), 0.5, new Color(1, 0, 0));
        world.geoList.add(sphere);
        world.geoList.add(sphere2);
        CreateImageCanvas canvas = new CreateImageCanvas(world, camera1);
        //Kriterium 4
        CreateImageCanvas canvas2 = new CreateImageCanvas(world, camera2);
        frame.add(canvas2);*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setJMenuBar(new ImageMenuBar(canvas2));
        frame.setVisible(true);
    }
    
}

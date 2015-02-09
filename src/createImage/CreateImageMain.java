/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createImage;

import applicationLogic.Color;
import applicationLogic.SamplingPattern;
import applicationLogic.World;
import applicationLogic.camera.Camera;
import applicationLogic.camera.PerspectiveCamera;
import applicationLogic.geometry.AxisAlignedBox;
import applicationLogic.geometry.Geometry;
import applicationLogic.geometry.Node;
import applicationLogic.lighting.PointLight;
import applicationLogic.material.PhongMaterial;
import applicationLogic.material.SingleColorMaterial;
import java.util.ArrayList;
import javax.swing.JFrame;
import matrizen.Point3;
import matrizen.Transform;
import matrizen.Vector3;

/**
 *
 * @author Dominik
 */
public class CreateImageMain {
    
    public static final JFrame frame = new JFrame("Draw an image");;
    
    public static void main(String[] args){
        frame.setSize(640, 540);
        //World ohne ambient light
//        final World world = new World(new Color(0, 0, 0), new Color(0, 0, 0));
        //World mit ambient light
        final World world = new World(new Color(0, 0, 0), new Color(0.25, 0.25, 0.25));
        final Camera camera = new PerspectiveCamera(new Point3(4, 4, 4), new Vector3(-1, -1, -1),
                              new Vector3(0, 1, 0), new SamplingPattern(1), Math.PI / 4);
        final ArrayList<Geometry> geoList = new ArrayList<>();
        //SingleColorMaterial
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new SingleColorMaterial(new Color(1, 0, 0))));
//        world.geoList.add(new Sphere(new Point3(1, 1, 1), 0.5, new SingleColorMaterial(new Color(0, 1, 0))));
        //LambertMaterial
//        world.geoList.add(new Sphere(new Point3(1, 1, 1), 1.0, new LambertMaterial(new Color(0, 1, 0))));
        //PhongMaterial
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new PhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
        geoList.add(new AxisAlignedBox(new PhongMaterial(new Color(1, 1, 0), new Color(1, 1, 1), 64)));
        final Transform transform = new Transform();
        world.geoList.add(new Node(transform.rotateZ(Math.PI/4).scale(0.25,1,3), geoList, new SingleColorMaterial(new Color(1, 0, 0))));
        //BlinnPhongMaterial
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new BlinnPhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
//        world.geoList.add(new Sphere(new Point3(1, 1, 1), 0.5, new BlinnPhongMaterial(new Color(0, 1, 0), new Color(1, 1, 1), 64)));
        //PointLight
        final PointLight light = new PointLight(new Color(0.75, 0.75, 0.75), new Point3(6, 6, 0));
        //DirectionalLight
//        final DirectionalLight light = new DirectionalLight(new Color(0.5, 0.5, 0.5), new Vector3(-1, -3, -1));
        //SpotLight
//        final SpotLight light = new SpotLight(new Color(0.5, 0.5, 0.5), new Point3(4, 4, 3), new Vector3(-1, -1, -1), Math.PI / 14);
        world.lightList.add(light);
        //Eigene Szene
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new LambertMaterial(new Color(0, 1, 0))));
//        world.geoList.add(new Sphere(new Point3(0.5, 1, 1), 0.5, new PhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
//        world.geoList.add(new Sphere(new Point3(2, 2, 0.5), 0.5, new PhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
//        final SpotLight light = new SpotLight(new Color(0.5, 0.5, 0.5), new Point3(4, 4, 4), new Vector3(-1, -1, -1), Math.PI / 14);
//        world.lightList.add(light);
//        world.lightList.add(new DirectionalLight(new Color(0.25, 0.25, 0.25), new Vector3(-1, 0, -1)));
//        world.lightList.add(new PointLight(new Color(0.25, 0.25, 0.25), new Point3(3, 8, 0)));
        final CreateImageCanvas canvas = new CreateImageCanvas(world, camera);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setJMenuBar(new ImageMenuBar(canvas));
        frame.setVisible(true);
    }
    
}

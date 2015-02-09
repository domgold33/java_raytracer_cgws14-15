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
import applicationLogic.camera.DOFCamera;
import applicationLogic.camera.PerspectiveCamera;
import applicationLogic.geometry.Geometry;
import applicationLogic.geometry.Plane;
import applicationLogic.geometry.Sphere;
import applicationLogic.lighting.PointLight;
import applicationLogic.material.PhongMaterial;
import applicationLogic.material.ReflectiveMaterial;
import java.util.ArrayList;
import javax.swing.JFrame;
import matrizen.Point3;
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
        final Camera camera = new PerspectiveCamera(new Point3(8, 8, 8), new Vector3(-1, -1, -1),
                              new Vector3(0, 1, 0), new SamplingPattern(1), Math.PI / 4);
        //Tiefenschärfe
        final Camera dofCamera = new DOFCamera(new Point3(8, 8, 8), new Vector3(-1, -1, -1),
                                 new Vector3(0, 1, 0), new SamplingPattern(10), Math.PI / 4, 10, 1);
        final ArrayList<Geometry> geoList = new ArrayList<>();
//        //SingleColorMaterial
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new SingleColorMaterial(new Color(1, 0, 0))));
//        world.geoList.add(new Sphere(new Point3(1, 1, 1), 0.5, new SingleColorMaterial(new Color(0, 1, 0))));
//        //LambertMaterial
//        world.geoList.add(new Sphere(new Point3(1, 1, 1), 1.0, new LambertMaterial(new Color(0, 1, 0))));
//        //PhongMaterial
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new PhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
//        geoList.add(new Sphere(new PhongMaterial(new Color(1, 1, 0), new Color(1, 1, 1), 64)));
//        final Transform transform = new Transform();
//        world.geoList.add(new Node(transform.translate(0.5, 0.5, 0.5), geoList, new SingleColorMaterial(new Color(1, 0, 0))));
//        world.geoList.add(new Plane(new ReflectiveMaterial(new Color(0, 0, 0), new Color(1, 1, 1), 64, new Color(0.5, 0.5, 0.5))));
//        //BlinnPhongMaterial
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new BlinnPhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
//        world.geoList.add(new Sphere(new Point3(1, 1, 1), 0.5, new BlinnPhongMaterial(new Color(0, 1, 0), new Color(1, 1, 1), 64)));
//        //PointLight
//        final PointLight light = new PointLight(new Color(0.75, 0.75, 0.75), new Point3(6, 6, 0));
//        //DirectionalLight
//        final DirectionalLight light = new DirectionalLight(new Color(0.5, 0.5, 0.5), new Vector3(-1, -3, -1));
//        //SpotLight
//        final SpotLight light = new SpotLight(new Color(0.5, 0.5, 0.5), new Point3(4, 4, 3), new Vector3(-1, -1, -1), Math.PI / 14);
//        world.lightList.add(light);
        //Eigene Szene
//        world.geoList.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), new LambertMaterial(new Color(0, 1, 0))));
//        world.geoList.add(new Sphere(new Point3(0.5, 1, 1), 0.5, new PhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
//        world.geoList.add(new Sphere(new Point3(2, 2, 0.5), 0.5, new PhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
//        final SpotLight light = new SpotLight(new Color(0.5, 0.5, 0.5), new Point3(4, 4, 4), new Vector3(-1, -1, -1), Math.PI / 14);
//        world.lightList.add(light);
//        world.lightList.add(new DirectionalLight(new Color(0.25, 0.25, 0.25), new Vector3(-1, 0, -1)));
//        world.lightList.add(new PointLight(new Color(0.25, 0.25, 0.25), new Point3(3, 8, 0)));
        reflexion(world);
        final CreateImageCanvas canvas = new CreateImageCanvas(world, dofCamera);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setJMenuBar(new ImageMenuBar(canvas));
        frame.setVisible(true);
    }
    
//    //Beispielszene Refraktion
//    public static void main(String[] args){
//        frame.setSize(640, 540);
//        final World world = new World(new Color(0, 0, 0), new Color(0.1, 0.1, 0.1));
//        world.lightList.add(new SpotLight(new Color(0.3, 0.3, 0.3), new Point3(0, 5, -10), new Vector3(0, -1, 0), Math.PI/8));
//        world.lightList.add(new PointLight(new Color(0.3, 0.3, 0.3), new Point3(5, 5, -10)));
//        world.lightList.add(new DirectionalLight(new Color(0.3, 0.3, 0.3), new Vector3(1, -1, 0).normalized()));
//        final Camera camera = new PerspectiveCamera(new Point3(8, 8, 8), new Vector3(-1, -1, -1), new Vector3(0, 1, 0), new SamplingPattern(1), Math.PI/4);
////        world.geoList.add(new Plane(new PhongMaterial(new Color(1, 1, 1), new Color(1, 1, 1), 10)));
//        world.geoList.add(new Plane(new ReflectiveMaterial(new Color(1, 1, 1), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5))));
//        //Versuch mit Szenengraph
////        final Sphere sphere1 = new Sphere(new ReflectiveMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
////        final Sphere sphere2 = new Sphere(new ReflectiveMaterial(new Color(0, 1, 0), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
////        final Sphere sphere3 = new Sphere(new ReflectiveMaterial(new Color(0, 0, 1), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
////        final Sphere sphere4 = new Sphere(new ReflectiveMaterial(new Color(0, 1, 1), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
////        final Sphere sphere5 = new Sphere(new ReflectiveMaterial(new Color(1, 0, 1), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
////        final Sphere sphere6 = new Sphere(new ReflectiveMaterial(new Color(1, 1, 0), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
////        List<Geometry> sphere1List = new ArrayList<>();
////        sphere1List.add(sphere1);
////        List<Geometry> sphere2List = new ArrayList<>();
////        sphere1List.add(sphere2);
////        List<Geometry> sphere3List = new ArrayList<>();
////        sphere1List.add(sphere3);
////        List<Geometry> sphere4List = new ArrayList<>();
////        sphere1List.add(sphere4);
////        List<Geometry> sphere5List = new ArrayList<>();
////        sphere1List.add(sphere5);
////        List<Geometry> sphere6List = new ArrayList<>();
////        sphere1List.add(sphere6);
////        world.geoList.add(new Node(new Transform().translate(0, 1, 0), sphere1List, new SingleColorMaterial(new Color(0, 0, 0))));
////        world.geoList.add(new Node(new Transform().translate(-1.5, 1, 0), sphere2List, new SingleColorMaterial(new Color(0, 0, 0))));
////        world.geoList.add(new Node(new Transform().translate(1.5, 1, 0), sphere3List, new SingleColorMaterial(new Color(0, 0, 0))));
////        world.geoList.add(new Node(new Transform().translate(0, 1, -1.5), sphere4List, new SingleColorMaterial(new Color(0, 0, 0))));
////        world.geoList.add(new Node(new Transform().translate(-1.5, 1, -1.5), sphere5List, new SingleColorMaterial(new Color(0, 0, 0))));
////        world.geoList.add(new Node(new Transform().translate(1.5, 1, -1.5), sphere6List, new SingleColorMaterial(new Color(0, 0, 0))));
//        final Sphere sphere1 = new Sphere(new Point3(0, 1, 0), 0.5, new ReflectiveMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
//        final Sphere sphere2 = new Sphere(new Point3(-1.5, 1, 0), 0.5, new ReflectiveMaterial(new Color(0, 1, 0), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
//        final Sphere sphere3 = new Sphere(new Point3(1.5, 1, 0), 0.5, new ReflectiveMaterial(new Color(0, 0, 1), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
//        final Sphere sphere4 = new Sphere(new Point3(0, 1, -1.5), 0.5, new ReflectiveMaterial(new Color(0, 1, 1), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
//        final Sphere sphere5 = new Sphere(new Point3(-1.5, 1, -1.5), 0.5, new ReflectiveMaterial(new Color(1, 0, 1), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
//        final Sphere sphere6 = new Sphere(new Point3(1.5, 1, -1.5), 0.5, new ReflectiveMaterial(new Color(1, 1, 0), new Color(1, 1, 1), 10, new Color(1, 0.5, 0.5)));
//        final Sphere sphere7 = new Sphere(new Point3(0, 2, 1.5), 0.5, new TransparentMaterial(1.33));
//        final Sphere sphere8 = new Sphere(new Point3(-1.5, 2, 1.5), 0.5, new TransparentMaterial(1.33));
//        final Sphere sphere9 = new Sphere(new Point3(1.5, 2, 1.5), 0.5, new TransparentMaterial(1.33));
//        world.geoList.add(sphere1);
//        world.geoList.add(sphere2);
//        world.geoList.add(sphere3);
//        world.geoList.add(sphere4);
//        world.geoList.add(sphere5);
//        world.geoList.add(sphere6);
//        world.geoList.add(sphere7);
//        world.geoList.add(sphere8);
//        world.geoList.add(sphere9);
//        final CreateImageCanvas canvas = new CreateImageCanvas(world, camera);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(canvas);
//        frame.setJMenuBar(new ImageMenuBar(canvas));
//        frame.setVisible(true);
//    }
    
    public static void reflexion(World world){
        world.geoList.add(new Plane(new ReflectiveMaterial(new Color(0.1, 0.1, 0.1), new Color(0, 0, 0), 64, new Color(0.5, 0.5, 0.5))));
        world.geoList.add(new Sphere(new Point3(-3, 1, 0), 1, new PhongMaterial(new Color(1, 0, 0), new Color(1, 1, 1), 64)));
        world.geoList.add(new Sphere(new Point3(0, 1, 0), 1, new PhongMaterial(new Color(0, 1, 0), new Color(1, 1, 1), 64)));
        world.geoList.add(new Sphere(new Point3(3, 1, 0), 1, new PhongMaterial(new Color(0, 0, 1), new Color(1, 1, 1), 64)));
        world.lightList.add(new PointLight(new Color(1, 1, 1), new Point3(8, 8, 8)));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizen;

/**
 *
 * @author Dominik
 */
public class Main {
    
    public static void main(String[] args){
        //1. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Normal3 normal1 = new Normal3(1, 2, 3);
        System.out.println(normal1.mul(0.5).equals(new Normal3(0.5, 1, 1.5)));
        //2.Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Normal3 normal2 = new Normal3(1, 2, 3);
        System.out.println(normal2.add(new Normal3(3, 2, 1)).equals(new Normal3(4, 4, 4)));
        //3. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Normal3 normal3 = new Normal3(1, 0, 0);
        Vector3 vector1 = new Vector3(1, 0, 0);
        System.out.println(normal3.dot(vector1) == 1);
        System.out.println(vector1.dot(normal3) == 1);
        System.out.println(vector1.dot(vector1) == 1);
        Normal3 normal4 = new Normal3(0, 1, 0);
        Vector3 vector2 = new Vector3(0, 1, 0);
        System.out.println(normal4.dot(vector2) == 1);
        System.out.println(vector2.dot(normal4) == 1);
        System.out.println(vector2.dot(vector2) == 1);
        //4. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Point3 point1 = new Point3(1, 1, 1);
        System.out.println(point1.sub(new Point3(2, 2, 0)).equals(new Vector3(-1, -1, 1)));
        //5. Überprüfung
        Vector3 vector3 = new Vector3(4, 3, 2);
        System.out.println("--------Nächste Überprüfung----------");
        System.out.println(point1.sub(vector3).equals(new Point3(-3, -2, -1)));
        //6. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        System.out.println(point1.add(vector3).equals(new Point3(5, 4, 3)));
        //7. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Vector3 vector4 = new Vector3(1, 1, 1);
        System.out.println(vector4.magnitude == Math.sqrt(3));
        //8. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        System.out.println(vector1.add(vector2).equals(new Vector3(1, 1, 0)));
        System.out.println(vector1.add(normal1).equals(new Vector3(2, 2, 3)));
        System.out.println(vector1.sub(normal1).equals(new Vector3(0, -2, -3)));
        System.out.println(vector1.mul(4).equals(new Vector3(4, 0, 0)));
        //9. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Vector3 vector5 = new Vector3(-0.707, 0.707, 0);
        Vector3 vector6 = new Vector3(0.707, 0.707, 0);
        System.out.println(vector5.reflectedOn(new Normal3(0, 1, 0)).equals(vector6));
        System.out.println("Kommentar: Ergebnis muss mit -1 multipliziert werden, um auf gegebenen Vektor"
                + "zu kommen, siehe nächste Zeile:");
        System.out.println(vector5.reflectedOn(new Normal3(0, 1, 0)).mul(-1).equals(vector6));
        //10. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        System.out.println(vector6.reflectedOn(new Normal3(1, 0, 0)).equals(new Vector3(0.707, -0.707, 0)));
        System.out.println("Kommentar: Ergebnis muss mit -1 multipliziert werden, um auf gegebenen Vektor"
                + "zu kommen, siehe nächste Zeile:");
        System.out.println(vector6.reflectedOn(new Normal3(1, 0, 0)).mul(-1).equals(new Vector3(0.707, -0.707, 0)));
        //11. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Mat3x3 mat1 = new Mat3x3(1, 0, 0, 0, 1, 0, 0, 0, 1);
        Point3 point2 = new Point3(3, 2, 1);
        System.out.println(mat1.mul(point2).equals(point2));
        Vector3 vector7 = new Vector3(3, 2, 1);
        System.out.println(mat1.mul(vector7).equals(vector7));
        //12. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Mat3x3 mat2 = new Mat3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(mat2.mul(mat1).equals(mat2));
        //13. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        System.out.println(mat2.mul(new Mat3x3(0, 0, 1, 0, 1, 0, 1, 0, 0)).equals(new Mat3x3(3, 2, 1, 6, 5, 4, 9, 8, 7)));
        //14. Überprüfung
        System.out.println("--------Nächste Überprüfung----------");
        Vector3 vector8 = new Vector3(8, 8, 8);
        System.out.println(mat2.changeCol1(vector8).equals(new Mat3x3(8, 2, 3, 8, 5, 6, 8, 8, 9)));
        System.out.println(mat2.changeCol2(vector8).equals(new Mat3x3(1, 8, 3, 4, 8, 6, 7, 8, 9)));
        System.out.println(mat2.changeCol3(vector8).equals(new Mat3x3(1, 2, 8, 4, 5, 8, 7, 8, 8)));
    }
    
}

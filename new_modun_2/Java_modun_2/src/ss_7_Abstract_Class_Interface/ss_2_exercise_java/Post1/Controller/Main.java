package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post1.Controller;

import ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post1.Mode.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(true, "red", 5);
        shape[1] = new Rectangle(5, 6);
        shape[2] = new Square(true, "red", 6, 9);
        System.out.println("Truoc khi thay doi:");
        System.out.print("Shape \n");
        for (Shape shops : shape) System.out.println(shops);
        double percent = Math.random() * 100;
        Resizeable.resize(percent);
        shape[0] = new Circle(percent);
        shape[1] = new Rectangle();
        shape[2] = new Square(percent);
        System.out.println("Sau khi thay doi :");
        System.out.print("Shape \n");
        for (Shape shops : shape
        ) {
            System.out.println(shops);
        }

    }

}




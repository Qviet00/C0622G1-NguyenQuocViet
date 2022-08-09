package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post2.Controller;

import ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post2.Mode.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(5, "blue", true);
        shape[1] = new Square(true, "white", 6, 8);
        shape[2] = new Rectangle(true, "rea", 3, 5);
        for (Shape shapes : shape) {
            if (shapes instanceof Colorable) {
                System.out.println(((Colorable) shapes).howToColor());
            }else {
                System.out.println(shapes.getArea());
            }
        }
    }
}

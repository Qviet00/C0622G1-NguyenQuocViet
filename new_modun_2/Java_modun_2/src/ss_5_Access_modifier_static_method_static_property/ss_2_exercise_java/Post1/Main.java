package ss_5_Access_modifier_static_method_static_property.ss_2_exercise_java.Post1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src= new Scanner(System.in);
        System.out.print("Nhập Radius (Meter): ");
        double radius= Integer.parseInt(src.nextLine());
        System.out.print("Nhập Color: ");
        String color= String.valueOf(src.nextLine());
        Circle circleOne= new Circle();
        Circle circleTwo= new Circle(radius,color);
        System.out.println("Mặc định ban đầu: "+"\n"+circleOne);
        System.out.println("Sau khi truyền tham số: "+"\n"+circleTwo);
        System.out.println("Radius: "+circleTwo.getRadiurs());
        System.out.println("Color: "+circleTwo.getC0lor());
        System.out.println("Area = "+ circleTwo.toSrings()+" (Meter)");

    }

}

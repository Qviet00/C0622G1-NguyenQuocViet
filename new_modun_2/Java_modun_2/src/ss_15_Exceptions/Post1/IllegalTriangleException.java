package ss_15_Exceptions.Post1;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) {
        System.out.println("Cho tam gíac ABC");
        double edgeA = 0;
        double edgeB = 0;
        double edgeC = 0;
        System.out.print("Nhập cạnh A: ");
        double edgeOne = checkEdge(edgeA);
        System.out.print("Nhập cạnh B: ");
        double edgeTwo = checkEdge(edgeB);
        System.out.print("Nhập cạnh C: ");
        double edgeThree = checkEdge(edgeC);
        System.out.println("{A: " + edgeOne + ", B: " + edgeTwo + " ,C: " + edgeThree + "}");
        boolean yes = (edgeOne + edgeTwo) >= edgeThree || (edgeOne + edgeThree) > edgeTwo || (edgeThree + edgeTwo) > edgeOne;
        if (yes) {
            System.out.println("Ba số này là cạnh của tam giác.");
        } else {
            System.out.println("Ba số này không phải là cạnh của tam giác.");
        }
    }

    public static double checkEdge(double i) {
        Scanner src = new Scanner(System.in);
        while (true) {
            i = Double.parseDouble(src.nextLine());

        }
    }
}
//}
//        while (true) {
//        try {
//            System.out.print("Mời bạn nhập điểm: ");
//            point = Double.parseDouble(scanner.nextLine());
//            if(point <0 || point >100) {
//                throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 hoặc lớn hơn 100");
//            }
//            break;
//        }catch (NumberFormatException e) {
//            System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
//        } catch (PointException p) {
//            System.err.println(p.getMessage());
//        } catch (Exception e) {
//​
//        }


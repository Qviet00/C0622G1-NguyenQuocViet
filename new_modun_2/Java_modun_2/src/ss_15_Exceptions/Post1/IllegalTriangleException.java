package ss_15_Exceptions.Post1;


import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) {
        System.out.println("Cho tam giác ABC");
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
            try {
                i = Double.parseDouble(src.nextLine());
                if (i < 0) {
                    throw new UntilException("Số nhập phải lớn hơn 0, nhập lại nge: ");
                }
                break;
            } catch (UntilException e) {
                System.out.print(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.print("Bạn nhập không phải là số, nhập lại nghe: ");
            }

        }
        return i;
    }
}

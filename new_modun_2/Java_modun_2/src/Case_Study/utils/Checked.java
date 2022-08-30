package Case_Study.utils;

import java.util.Scanner;

public class Checked {

    public static double checked(double i,int n, int m) {
        Scanner src = new Scanner(System.in);
        while (true) {
            try {
                i = Double.parseDouble(src.nextLine());
                if (i <= m || i > n) {
                    throw new UntilException("Số nhập phải lớn hơn 0 và nhỏ hơn " + n + ", nhập lại nge: ");
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

    public static int checkedOne(double i,int n) {
        Scanner src = new Scanner(System.in);
        while (true) {
            try {
                i = Double.parseDouble(src.nextLine());
                if (i <n) {
                    throw new UntilException("Số nhập phải lớn hơn 0 , nhập lại nge: ");
                }
                break;
            } catch (UntilException e) {
                System.out.print(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.print("Bạn nhập không phải là số, nhập lại nghe: ");
            }
        }
        return (int) i;
    }
}

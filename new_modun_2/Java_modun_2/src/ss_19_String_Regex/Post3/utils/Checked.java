package ss_19_String_Regex.Post3.utils;

import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.util.Scanner;

public  class Checked {

    public double Checked(double i, int n) {
        Scanner src = new Scanner(System.in);
        while (true) {
            try {
                i = Double.parseDouble(src.nextLine());
                if (i < 0 || i > n) {
                    throw new UntilException("Số nhập phải lớn hơn 0 và nhỏ hơn 3, nhập lại nge: ");
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
    public int CheckedOne(double i) {
        Scanner src = new Scanner(System.in);
        while (true) {
            try {
                i = Double.parseDouble(src.nextLine());
                if (i < 0) {
                    throw new UntilException("Số nhập phải lớn hơn 0 và nhỏ hơn 3, nhập lại nge: ");
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

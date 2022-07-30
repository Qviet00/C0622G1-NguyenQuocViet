package ss_1_introduction_to_java.ss_2_bai_tap_java;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số USD:");
        double usa = scanner.nextDouble();
        double vnd = usa * 23000;
        System.out.print("Số tiền được quy đổi:" + vnd);
    }
}

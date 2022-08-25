package ss_19_String_Regex.Post2;

import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.util.Scanner;

public class NumberPhone {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập số điện thoại: ");
                String nameClass = String.valueOf(src.nextLine());
                String regex = "[(][+]84[)]-0[0-9]{8}";
                if (!nameClass.matches((regex))) {
                    throw new UntilException("Số điện thoại không hợp lệ.");
                }
                System.out.println("Số  đúng rồi bạn, ahihi");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

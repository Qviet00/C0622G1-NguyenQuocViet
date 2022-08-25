package ss_19_String_Regex;

import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.util.Scanner;

public class ValidateNameClass {
    public static void main(String[] args) {
        Scanner src=new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập tên lớp: ");
                String nameClass = String.valueOf(src.nextLine());
                String regex="[A|C|P][0-9]{4}[G|H|I|K|L|M]";
                if (!nameClass.matches((regex))){
                    throw new UntilException("Tên lớp không hợp lệ.");
                }
                System.out.println("Tên nhập đúng rồi bạn, ahihi");
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

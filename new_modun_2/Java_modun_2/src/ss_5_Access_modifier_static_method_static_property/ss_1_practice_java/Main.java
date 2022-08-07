package ss_5_Access_modifier_static_method_static_property.ss_1_practice_java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập mã SV1:");
        int maSV= Integer.parseInt(src.nextLine());
        System.out.print("Nhập tên SV1:");
        String ten = String.valueOf((src.nextLine()));
        System.out.print("Nhập ngày, tháng, năm sinh SV1:");
        String ngayTN= String.valueOf(src.nextLine());
        System.out.print("Nhập điểm toán:");
        double t= Integer.parseInt(src.nextLine());
        System.out.print("Nhập điểm Lý:");
        double a= Integer.parseInt(src.nextLine());
        System.out.print("Nhập điểm Hóa:");
        double v= Integer.parseInt(src.nextLine());
        SinhVien sinhVien1= new SinhVien( maSV,"ten","ngayTN",t,a,v);
        System.out.print("Nhập mã SV2:");
        int maSV2= Integer.parseInt(src.nextLine());
        System.out.print("Nhập tên SV2:");
        String ten2 = String.valueOf((src.nextLine()));
        System.out.print("Nhập ngày, tháng, năm sinh SV2:");
        String ngayTN2= String.valueOf(src.nextLine());
        System.out.print("Nhập điểm toán:");
        double t2= Integer.parseInt(src.nextLine());
        System.out.print("Nhập điểm Lý:");
        double a2= Integer.parseInt(src.nextLine());
        System.out.print("Nhập điểm Hóa:");
        double v2= Integer.parseInt(src.nextLine());
        SinhVien sinhVien2= new SinhVien( maSV2,ten2,ngayTN2,t2,a2,v2);
        System.out.printf("%6s %10s %20s %10s \n",
                "Mã sinh viên","Họ tên","Ngày tháng năm sinh","Điểm TB");
        System.out.println(sinhVien1);
        System.out.println(sinhVien2);
    }
}
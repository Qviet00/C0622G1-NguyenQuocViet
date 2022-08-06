package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.post1;

public class Text {
    public static void main(String[] args) {
        HangSanXuat xeDap = new HangSanXuat("Hãng 1", "Viet Nam");
        HangSanXuat oTo = new HangSanXuat("Hãng 2", "Audi");
        HangSanXuat mayBay = new HangSanXuat("Hãng 3", "Boling");

        MayBay p3 = new MayBay(mayBay, "Dầu");
        PhuongTienDiChuyen p2 = new XeOTo(oTo, "Xăng");
        PhuongTienDiChuyen p1 = new XeDap(xeDap) ;

        System.out.println("-Lấy hãng sản xuất: ");
        System.out.println("Xe đạp: " + p1.layTenHangSanXuat());
        System.out.println("Ô tô: " + p2.layTenHangSanXuat());
        System.out.println("Máy Bay: " + p3.layTenHangSanXuat());



        System.out.println("-Lấy vận tốc:");
        System.out.println("Xe đạp: "+ p1.layVanToc()+" Km/h");
        System.out.println("Ô tô: "+ p2.layVanToc()+" Km/h");
        System.out.println("Máy Bay: "+ p3.layVanToc()+" Km/h");

        System.out.println("-Cất cánh:");
        p3.catCanh();
        p3.haCanh();

    }
}

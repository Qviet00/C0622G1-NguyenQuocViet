package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.post1;

public class XeDap extends PhuongTienDiChuyen {
    public XeDap(HangSanXuat hangSanXuat) {
        super("Xe Đạp",hangSanXuat);
    }
    @Override
    public double layVanToc() {
        return 20;
    }


}

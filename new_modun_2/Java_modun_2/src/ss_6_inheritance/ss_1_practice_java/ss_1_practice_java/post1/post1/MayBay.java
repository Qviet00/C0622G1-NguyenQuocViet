package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.post1;

public class MayBay extends PhuongTienDiChuyen{
    private String loaiNhienLieu;

    public MayBay(HangSanXuat hangSanXuat,String loaiNhienLieu) {
        super("Máy Bay",hangSanXuat);
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    @Override
    public double layVanToc() {
        return 500;
    }
    public void catCanh(){
        System.out.println("Cất Cánh.");
    }
    public void haCanh(){
        System.out.println("Hạ Cánh.");
    }
}
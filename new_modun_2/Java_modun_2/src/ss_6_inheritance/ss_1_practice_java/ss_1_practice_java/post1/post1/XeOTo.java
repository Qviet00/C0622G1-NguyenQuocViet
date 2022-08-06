package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.post1;

public class XeOTo extends PhuongTienDiChuyen {
    private String loaiNhienLieu;

    public XeOTo( HangSanXuat hangSanXuat,String loaiNhienLieu) {
        super("Xe Ô Tô",hangSanXuat);
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getTenLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setTenLoaiNhienLieu(String tenLoaiNhienLieu) {
        this.loaiNhienLieu = tenLoaiNhienLieu;
    }
    @Override
    public double layVanToc() {
        return 80;
    }
}

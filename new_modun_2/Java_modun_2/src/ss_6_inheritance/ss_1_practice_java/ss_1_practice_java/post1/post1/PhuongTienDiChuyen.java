package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.post1;

public abstract class PhuongTienDiChuyen {
    protected String tenLoaiPhuongTien;
    protected HangSanXuat layTenHangSanXuat;

    public PhuongTienDiChuyen(String tenLoaiPhuongTien, HangSanXuat hangSanXuat) {
        this.tenLoaiPhuongTien = tenLoaiPhuongTien;
        this.layTenHangSanXuat = hangSanXuat;
    }

    public PhuongTienDiChuyen(String tenLoaiPhuongTien) {
        this.tenLoaiPhuongTien = tenLoaiPhuongTien;
    }

    public String getTenLoaiPhuongTien() {
        return tenLoaiPhuongTien;
    }

    public void setTenLoaiPhuongTien(String tenLoaiPhuongTien) {
        this.tenLoaiPhuongTien = tenLoaiPhuongTien;
    }
    public String layTenHangSanXuat(){
        return this.layTenHangSanXuat.getTenHangSanXuat();
    }
    public void batDau(){
        System.out.println("Bắt Đầu");
    }
    public void tăngToc(){
        System.out.println("Tăng Tốc");
    }
    public void dungLai(){
        System.out.printf("Dừng Lại");
    }
    public abstract double layVanToc();
}

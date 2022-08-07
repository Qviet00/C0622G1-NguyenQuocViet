package ss_5_Access_modifier_static_method_static_property.ss_1_practice_java;

public class SinhVien {
    private int maSV;
    private String tenSV;
    private String ngayThangNamSinhSV;
    private double diemToan;
    private double diemVan;
    private double diemAnh;

    public SinhVien() {
    }

    public SinhVien(int maSV, String tenSV, String ngayThangNamSinhSV, double diemToan, double diemVan, double diemAnh) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.ngayThangNamSinhSV = ngayThangNamSinhSV;
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemAnh = diemAnh;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getNgayThangNamSinhSV() {
        return ngayThangNamSinhSV;
    }

    public void setNgayThangNamSinhSV(String ngayThangNamSinhSV) {
        this.ngayThangNamSinhSV = ngayThangNamSinhSV;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemVan() {
        return diemVan;
    }

    public void setDiemVan(double diemVan) {
        this.diemVan = diemVan;
    }

    public double getDiemAnh() {
        return diemAnh;
    }

    public void setDiemAnh(double diemAnh) {
        this.diemAnh = diemAnh;
    }

    public double diemTB() {
        return (this.diemAnh + this.diemToan + this.diemVan) / 3;
    }

    @Override
    public String toString() {
        return String.format("%6s %15s %20s %10.3s \n" ,this.maSV,this.tenSV,this.ngayThangNamSinhSV,diemTB());
    }
}

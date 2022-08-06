package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.post1;

public class HangSanXuat {
    private  String tenHangSanXuat, quocGiaSanXuat;

    public HangSanXuat(String tenHangSanXuat, String quocGiaSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
        this.quocGiaSanXuat = quocGiaSanXuat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public String getQuocGiaSanXuat() {
        return quocGiaSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public void setQuocGiaSanXuat(String quocGiaSanXuat) {
        this.quocGiaSanXuat = quocGiaSanXuat;
    }
}

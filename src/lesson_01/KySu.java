package lesson_01;

import java.util.Date;

public class KySu extends CanBo{
    private String nganhDaoTao;

    public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, Date ngayVaoLam, String nganhDaoTao) {
        super(hoTen, tuoi, gioiTinh, diaChi, ngayVaoLam);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public void hienThi() {
        super.hienThi();
        System.out.println("Ngành đào tạo: " + nganhDaoTao);
    }
}
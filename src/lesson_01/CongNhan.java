package lesson_01;

import java.util.Date;

public class CongNhan extends CanBo {
    private int bac;

    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, Date ngayVaoLam, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi, ngayVaoLam);
        while (true) {
            if (bac >= 1 && bac <= 10) {
                this.bac = bac;
                break;
            } else {
                System.out.println("Bậc không hợp lệ, vui lòng nhập lại!");
                bac = QuanLyCanBo.nhapSoNguyen("Nhập bậc (1-10): ");
            }
        }
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        while (true) {
            if (bac >= 1 && bac <= 10) {
                this.bac = bac;
                break;
            } else {
                System.out.println("Bậc không hợp lệ, vui lòng nhập lại!");
                bac = QuanLyCanBo.nhapSoNguyen("Nhập bậc (1-10): ");
            }
        }
    }

    public void hienThi(){
        super.hienThi();
        System.out.println("Bậc: " + bac);
    }
}

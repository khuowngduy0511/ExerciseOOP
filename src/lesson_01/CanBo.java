package lesson_01;

import java.util.Date;

public class CanBo {
    private String hoTen;
    private int tuoi;
    private String gioiTinh;
    private String diaChi;
    private Date ngayVaoLam;
    private int maDinhDanh;

    private static int m = 1;

    public static final String NAM = "nam";
    public static final String NU = "nữ";
    public static final String KHAC = "khác";

    public CanBo(String hoTen, int tuoi, String gioiTinh, String diaChi, Date ngayVaoLam) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        while (true) {
            if (gioiTinh.equals(NAM) || gioiTinh.equals(NU) || gioiTinh.equals(KHAC)) {
                this.gioiTinh = gioiTinh;
                break;
            } else {
                System.out.println("Giới tính không hợp lệ, vui lòng nhập lại!");
                gioiTinh = QuanLyCanBo.nhapChuoi("Nhập giới tính (nam | nữ | khác): ");
            }
        }
        this.diaChi = diaChi;
        this.ngayVaoLam = ngayVaoLam;
        this.maDinhDanh = m;
        m++;

    }
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        while (true) {
            if (gioiTinh.equals(NAM) || gioiTinh.equals(NU) || gioiTinh.equals(KHAC)) {
                this.gioiTinh = gioiTinh;
                break;
            } else {

                System.out.println("Giới tính không hợp lệ, vui lòng nhập lại!");
                gioiTinh = QuanLyCanBo.nhapChuoi("Nhập giới tính (nam | nữ | khác): ");
            }
        }
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date  getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public int getMaDinhDanh() {
        return maDinhDanh;
    }

    public void hienThi(){
        System.out.println("Họ Tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Giới Tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Ngày vào làm: " + ngayVaoLam);
        System.out.println("Mã Định Danh: " + maDinhDanh);
    }

}


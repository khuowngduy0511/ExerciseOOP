package lesson_01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class QuanLyCanBo {
    private List<CanBo> danhSach;

    public QuanLyCanBo(){
        danhSach = new ArrayList<>();
    }

    private void themCanBo(CanBo canBo) {
        danhSach.add(canBo);
    }
    private CanBo timKiemTheoHoTen(String hoTen) {
        for (CanBo canBo : danhSach) {
            if (canBo.getHoTen().equals(hoTen)) {
                return canBo;
            }
        }
        return null;
    }

    private void xoaCanBoTheoMa(int maDinhDanh){
        CanBo canBoXoa = null;
        for (CanBo canBo : danhSach) {
            if (canBoXoa.getMaDinhDanh() == maDinhDanh) {
                canBoXoa = canBo;
                break;
            }
        }
        if (canBoXoa != null) {
            danhSach.remove(canBoXoa);
            System.out.println("Đã xóa cán bộ có mã định danh: "+ maDinhDanh);
        } else {
            System.out.println("Không tìm thấy cán bộ có mã đinh danh: "+ maDinhDanh);
        }
    }

    private void xoaCanBoTheoLoai(String loaiCanBo){
        int soLuongXoa = 0;
        List<CanBo> canBoXoa = new ArrayList<>();
        for (CanBo canBo: danhSach){
            if ((loaiCanBo.equals("công nhân") && canBo instanceof CongNhan) ||
                    (loaiCanBo.equals("kỹ sư") && canBo instanceof KySu) ||
                    (loaiCanBo.equals("nhân viên") && canBo instanceof NhanVien)){
                canBoXoa.add(canBo);
                soLuongXoa++;
            }
        }
        danhSach.removeAll(canBoXoa);
        System.out.println("Đã xóa "+soLuongXoa+" thuộc loại cán bộ: "+loaiCanBo);
    }

    private void hienThiDanhSach() {
        System.out.println("Danh sách cán bộ:");
        for (CanBo canBo : danhSach) {
            canBo.hienThi();
            System.out.println("----------");
        }
    }

    public static int nhapSoNguyen(String thongBao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(thongBao);
        return scanner.nextInt();
    }

    public static String nhapChuoi(String thongBao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(thongBao);
        return scanner.nextLine();
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
    private Date nhapNgayVaoLam() {
        String ngayThang = nhapChuoi("Nhập ngày vào làm (dd/mm/yy): ");
        Date ngayVaoLam = null;
        try {
            ngayVaoLam = dateFormat.parse(ngayThang);
        } catch (ParseException e) {
            System.out.println("Chuỗi ngày tháng không hợp lệ");
        }
        return ngayVaoLam;
    }

    private CanBo nhapCanBo(){
        String hoTen = nhapChuoi("Nhập họ tên: ");
        int tuoi = nhapSoNguyen("Nhập tuổi: ");
        String gioiTinh = nhapChuoi("Nhập giới tính: ");
        String diaChi = nhapChuoi("Nhập địa chỉ: ");
        Date ngayVaoLam = nhapNgayVaoLam();
        String loaiCanBo = nhapChuoi("Nhập loại cán bộ: (công nhân|kỹ sư|nhân viên): ");
        CanBo canBo = null;
        if (loaiCanBo.equals("công nhân")){
            int bac = nhapSoNguyen("Nhập bậc (1-10): ");
            canBo = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, ngayVaoLam, bac);
        } else if (loaiCanBo.equals("kỹ sư")) {
            String nganhDaoTao = nhapChuoi("Nhập ngành đào tạo: ");
            canBo = new KySu(hoTen, tuoi, gioiTinh, diaChi, ngayVaoLam, nganhDaoTao);
        } else if (loaiCanBo.equals("nhân viên")) {
            String congViec = nhapChuoi("Nhập công việc: ");
            canBo = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, ngayVaoLam, congViec);
        } else {
            System.out.println("Loại cán bộ không hợp lệ!");
        } return canBo;

    }

    private void nhapDanhSach(){
        int soLuongCanBo = nhapSoNguyen("Nhập số lượng cán bộ: ");
        for (int i = 1; i <= soLuongCanBo; i++){
            System.out.println("Nhập cán bộ thứ " + i + ":");
            CanBo canBo = nhapCanBo();
            themCanBo(canBo);
        }
    }

    public void hienThiMenu(){
        System.out.println("Mời chọn chức năng:");
        System.out.println("1. Thêm mới cán bộ");
        System.out.println("2. Tìm kiếm theo họ tên");
        System.out.println("3. Xóa cán bộ theo mã định danh");
        System.out.println("4. Xóa cán bộ theo loại cán bộ");
        System.out.println("5. Hiển thị danh sách cán bộ");
        System.out.println("6. Thoát khỏi chương trình");
    }

    public void xuLyChucNang(int luaChon){
        switch (luaChon){
            case 1:
                nhapDanhSach();
                break;
            case 2:
                String hoTen = nhapChuoi("Họ tên cần tìm là: ");
                CanBo canBo = timKiemTheoHoTen(hoTen);
                if (canBo != null){
                    canBo.hienThi();
                } else {
                    System.out.println("Không tìm thấy can bộ có họ tên: "+hoTen);
                }
                break;
            case 3:
                int maDinhDanh = nhapSoNguyen("Nhập mã cán bộ cần xóa: ");
                xoaCanBoTheoMa(maDinhDanh);
                break;
            case 4:
                String loaiCanBo = nhapChuoi("Nhập loại cán bộ cân xóa: ");
                xoaCanBoTheoLoai(loaiCanBo);
                break;
            case 5:
                hienThiDanhSach();
                break;
            case 6:
                System.out.println("Đã thoát chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
        }
    }
}

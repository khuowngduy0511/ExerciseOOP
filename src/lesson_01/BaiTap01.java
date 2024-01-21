package lesson_01;

public class BaiTap01 {
    public static void run(){
        QuanLyCanBo qlcb = new QuanLyCanBo();
        int luachon;
        do{
            qlcb.hienThiMenu();
            luachon = qlcb.nhapSoNguyen("Nhập lựa chọn của bạn: ");
            qlcb.xuLyChucNang(luachon);
        } while (luachon != 6);
    }
}

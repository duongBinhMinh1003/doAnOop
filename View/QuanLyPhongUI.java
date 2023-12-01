package View;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Controller.QuanLiPhongThuong;
import Controller.QuanLyPhongVip;
public class QuanLyPhongUI {
    public static Scanner input = new Scanner(System.in);
    public static void listFunctionsView() {
        System.out.println("---------Quản lý phòng---------");
        System.out.println("1.Quản lý phòng vip");
        System.out.println("2.Quản lý phòng thường");      
        System.out.println("0.Thoát chương trình.");
        System.out.println("-------------------------------------");
    }
    public static void quanLyPhongUI() throws FileNotFoundException {
        QuanLyPhongVip qlnv = new QuanLyPhongVip();
        int subCheck = 0;
        do {
            System.out.println("Quản lý phòng vip:");
            System.out.println("1.Xem danh sách phòng");
            System.out.println("2.Thêm phòng");
            System.out.println("3.Sửa phòng");
            System.out.println("4.Xóa phòng");
            System.out.println("5.Tìm kiếm phòng");
            System.out.println("0.Thoát");
            System.out.println("Mời nhập: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> qlnv.Read();
                case 2 -> qlnv.Create();
                case 3 -> qlnv.Update();
                case 4 -> qlnv.Delete();
                case 5 -> qlnv.Search_byCategory();
                case 0 -> System.out.println("Thoát quản lý nhân viên");
                default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
            }
        } while (subCheck != 0);
    }
    public static void quanLyPhongThuongUI() throws FileNotFoundException {
        QuanLiPhongThuong qlnv = new QuanLiPhongThuong();
        int subCheck = 0;
        do {
            System.out.println("Quản lý phòng thường:");
            System.out.println("1.Xem danh sách phòng");
            System.out.println("2.Thêm phòng");
            System.out.println("3.Sửa phòng");
            System.out.println("4.Xóa phòng");
            System.out.println("5.Tìm kiếm phòng");
            System.out.println("0.Thoát");
            System.out.println("Mời nhập: ");
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> qlnv.Read();
                case 2 -> qlnv.Create();
                case 3 -> qlnv.Update();
                case 4 -> qlnv.Delete();
                case 5 -> qlnv.Search_byCategory();
                case 0 -> System.out.println("Thoát quản lý nhân viên");
                default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
            }
        } while (subCheck != 0);
    }
    public QuanLyPhongUI() throws FileNotFoundException {
        int function = 0;
        do {
            listFunctionsView();
            System.out.print("Chọn chức năng: ");
            function = input.nextInt();
            switch(function) {
                case 1 -> {
                    quanLyPhongUI();
                }
                case 2 -> {
                    quanLyPhongThuongUI();
                }
                default ->{
                    System.out.println("\nNhập sai chức năng, vui lòng nhập lại!\n");
                }
            }
        }
        while (function != 0);
    }
}

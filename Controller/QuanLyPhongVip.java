package Controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import Entity.Phong;
import Entity.PhongVip;

public class QuanLyPhongVip extends PhongVip implements ControllerInterface {
    public static Scanner input = new Scanner(System.in);
    public PhongVip[] p;
    
    public QuanLyPhongVip() throws FileNotFoundException {
        super();
        getListRoom();
    }
    public PhongVip[] getListRoom() throws FileNotFoundException {
        String[] result = new String[0];
        try {
            result = Stream.read("Database/PhongVip.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        p = new PhongVip[result.length];
        for(int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            p[i] = new PhongVip(row[0], row[1], row[2], row[3], row[4], row[5],row[6]);
        }
        return p;
    }
    public void waitConsole() {
        System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
        input.nextLine();
    }

    @Override
    public void Read() {
        System.out.println("\t\t\t\t\t +----DANH SACH PHONG VIP----+");
        String header = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |", "Ma Phong",
                "Gia Phong", "Noi That", "Dich Vu", "Uu tien", "quyen Loi","so nguoi");
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");

        try {
            getListRoom();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < p.length; i++) {
            String read = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |",
            p[i].getmaPhong(), p[i].getgia(),  p[i].getnoiThat(),p[i].getdichVu(), p[i].getuuTien(), p[i].getquyenLoi(),p[i].getsoLuongNguoi());
            System.out.println(read);
        }
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
        
        waitConsole();
      

    }
    @Override
    public void Create() {
        System.out.print("Nhập mã phòng: ");
        setmaPhong(input.nextLine());
        
        int check = 0;
        for (PhongVip HoaDon : p) {
            if (getmaPhong()==(HoaDon.getmaPhong())) {
                check = 1;
                break;
            }
        }
        
        if(check == 1) {
            System.out.println("id của phòng bị trùng");
            return;
        }

        System.out.print("Nhập giá phòng: ");
        setgia(input.nextLine());
        System.out.print("Nhập nội thất: ");
        setnoiThat(input.nextLine());
        
        
                System.out.print("Nhập dịch vụ: ");
                setdichVu(input.nextLine());
        
        System.out.print("Nhập ưu tiên: ");
        setuuTien(input.nextLine());
        
        System.out.print("Nhập quyền lợi: ");
        setquyenLoi(input.nextLine());
        System.out.print("Nhập số người ở: ");
        setsoLuongNguoi(input.nextLine());
        try {
            String inputString = getmaPhong() + ";" + getgia() + ";" + getnoiThat() + ";" + getdichVu() + ";" + getuuTien() + ";" + getquyenLoi()+";"+getsoLuongNguoi();
            Stream.addOneLine("Database/PhongVip.txt", inputString);
            System.out.println("Nhập hóa đơn thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
      

      
        waitConsole();
    }

    @Override
    public void Update() {
        try {
            System.out.println("\t\t\t\t\t +----CẬP NHẬT LẠI THÔNG TIN SẢN PHẨM----+");
            System.out.print("- Mời nhập ID sản phẩm cần chỉnh sửa: ");
            String ID_Product = input.nextLine();
            PhongVip s_pham = null;

            for (PhongVip sanpham : p) {
                if (sanpham.getmaPhong().equals(ID_Product)) {
                    s_pham = sanpham;
                    break;
                }
            }

            if (s_pham == null) {
                System.out.println("\t\t\t\t\t -MÃ SẢN PHẨM KHÔNG TỒN TẠI!");
                return;
            }

            // Nếu dòng dữ liệu có tồn tại thì xuất ra thông tin cũ
            // và tiếp tục nhập các thông tin còn lại (Update thì
            // phải nhập lại tất cả thông tin, bao gồm cả check
            // ID có trùng vs sản phẩm khác không)
            System.out.println("\t\t\t\t\t +----THÔNG TIN SẢN PHẨM TRƯỚC KHI CHỈNH SỬA----+");
            String header = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |", "Ma Phong",
                "Gia Phong", "Noi That", "Dich Vu", "Uu tien", "quyen Loi","so nguoi");
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");

        String read = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |",
        s_pham.getmaPhong(), s_pham.getgia(), s_pham.getnoiThat(),
        s_pham.getdichVu(), s_pham.getuuTien(), s_pham.getquyenLoi(), s_pham.getsoLuongNguoi());

            System.out.println(read);
            System.out.format(
                    "+-----------------+------------+---------------------------+-----------+------------------+--------------+------------+%n");
                   


            String[] data = new String[p.length];

            for (int i = 0; i < p.length; i++) {
                if (p[i].getmaPhong().equals(ID_Product)) {
                    System.out.println("Nhập thông tin sản phẩm:");
                    System.out.print("Nhập id : ");
                    setmaPhong(input.nextLine());
                    System.out.print("Nhập giá phòng: ");
                    setgia(input.nextLine());
                    System.out.print("Nhập nội thất: ");
                    setnoiThat(input.nextLine());
            
                    System.out.print("Nhập dịch vụ: ");
                    setdichVu(input.nextLine());
                   
                    System.out.print("Nhập ưu tiên: ");
                    setuuTien(input.nextLine());
                    
            
                    System.out.print("Nhập quyền lợi: ");
                    setquyenLoi(input.nextLine());
                   
                    System.out.print("Nhập số người ở: ");
                    setsoLuongNguoi(input.nextLine());

                    p[i].setmaPhong(getmaPhong());
                    p[i].setgia(getgia());
                   p[i].setnoiThat(getnoiThat());
                   p[i].setdichVu(getdichVu());
                   p[i].setuuTien(getuuTien());
                   p[i].setquyenLoi(getquyenLoi());
                   p[i].setsoLuongNguoi(getsoLuongNguoi());
                }
                data[i] = p[i].getmaPhong() + ";" + p[i].getgia() + ";" + p[i].getnoiThat() + ";"
                        + p[i].getdichVu() + ";" + p[i].getuuTien() + ";" + p[i].getquyenLoi() + ";"
                        + p[i].getsoLuongNguoi();
            }
         

            // Cập nhật lại cả danh sách vào file
            try {
                Stream.addAll("Database/PhongVip.txt", data);
                System.out.println("\t\t\t\t\t+----SỬA THÔNG TIN SẢN PHẨM THÀNH CÔNG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    @Override
    public void Delete() {
        try {
            // Nhập và kiểm tra ID sản phẩm có tồn tại không
            // Nếu có thì xóa luôn và thông báo thành công
            // Còn không thì thông báo ID không tồn tại
            System.out.println("\t\t\t\t\t +----XÓA THÔNG TIN SẢN PHẨM----+");
            System.out.print("-Nhập ID sản phẩm cần xóa: ");
            String ID_Product = input.nextLine();

           PhongVip cur_product = null;
            for (PhongVip sanpham : p) {
                if (sanpham.getmaPhong().equals(ID_Product)) {
                    cur_product = sanpham;
                    break;
                }
            }

            if (cur_product == null) {
                System.out.println("\t\t\t\t\t - MÃ PHONG KHÔNG TỒN TẠI!");
                return;
            }

            for (int i = 0; i < p.length; i++) {
                if (ID_Product.equals(p[i].getmaPhong())) {
                    p = deleteSanPham(p, i);
                    break;
                }
            }
            String[] data = new String[p.length];
            for (int i = 0; i < p.length; i++) {
                data[i] = p[i].getmaPhong() + ";" + p[i].getgia() + ";" + p[i].getnoiThat() + ";"
                + p[i].getdichVu() + ";" + p[i].getuuTien() + ";" + p[i].getquyenLoi() + ";"
                + p[i].getsoLuongNguoi();
            }

            // Add lại nguyên danh sách đã xóa dòng dữ liệu
            try {
                Stream.addAll("Database/PhongVip.txt", data);
                System.out.println("\t\t\t\t\t +----XÓA THÔNG TIN SẢN PHẨM THÀNH CÔNG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   // Xóa phần tử khỏi mảng
   public PhongVip[] deleteSanPham(PhongVip[] DSSP, int index) {
    PhongVip[] newCs = new PhongVip[DSSP.length - 1];
    for (int i = 0, j = 0; i < DSSP.length; i++) {
        if (i != index) {
            newCs[j++] = DSSP[i];
        }
    }
    return newCs;
}
 
   
    @Override
    public void Search_byCategory() {
        System.out.print("Nhập ID Phong : ");
        String ID_HoaDon = input.nextLine();
        PhongVip hdon = null;

        for (PhongVip HoaDon : p) {
            if (HoaDon.getmaPhong().equals(ID_HoaDon)) {
                hdon = HoaDon;
                break;
            }
        }

        if(hdon == null) {
            System.out.println("ID phong khong ton tai. Xin vui lòng nhập lại!");
            return;
        }

        System.out.println("Thông tin cũ của hóa đơn:");
        String header = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |", "Ma Phong",
                "Gia Phong", "Noi That", "Dich Vu", "Uu tien", "quyen Loi","so luong nguoi");
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n");

        String read = String.format("| %-10s | %-15s | %-15s | %-9s | %-15s | %-21s | %-15s |",
        hdon.getmaPhong(), hdon.getgia(), hdon.getnoiThat(),
        hdon.getdichVu(), hdon.getuuTien(), hdon.getquyenLoi(), hdon.getsoLuongNguoi());
System.out.println(read);
        System.out.format("+-------+-----------------+----------------------+---------------------------+-----------------+----------------------+%n"); 
                   
        String[] data = new String[p.length];

       
        
        waitConsole();
}
}

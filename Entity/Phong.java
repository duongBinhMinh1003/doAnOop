package Entity;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Phong {
    static Scanner input = new Scanner(System.in);
    public String gia ;
    public String maPhong;
    public String soLuongNguoi;
    public Phong(){
        
    }

    public Phong(String gia , String maPhong , String soLuongNguoi){
        this.gia =  gia;
        this.maPhong = maPhong;
        this.soLuongNguoi = soLuongNguoi;
    }
    public String getgia(){
        return gia ;
    }
    public void setgia(String gia){
        this.gia = gia;
    }
    public String getmaPhong(){
        return maPhong ;
    }
    public void setmaPhong(String maPhong){
        this.maPhong = maPhong ;
    }
    public String getsoLuongNguoi(){
        return soLuongNguoi ;
    }
    public void setsoLuongNguoi(String soLuongNguoi ){
        this.soLuongNguoi = soLuongNguoi ;
    }
    public void nhapThongTin(){
    //   System.out.println("nhap ma phong");
    //   setmaPhong(input.nextLine());
      System.out.println("nhap gia phong");
      setgia(input.nextLine());
      System.out.println("nhap so luong nguoi");
      setsoLuongNguoi(input.nextLine());
    }
}


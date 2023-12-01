package Entity;
import java.util.Scanner;
public class PhongVip extends Phong {
    public String dichVu;
    static Scanner input = new Scanner(System.in);
    public String noiThat;
    public String quyenLoi;
    public String uuTien;
   
    public PhongVip(String maPhong , String gia ,String noiThat  , String dichVu ,String uuTien ,String quyenLoi,String soLuongNguoi){
        super(gia,maPhong,soLuongNguoi);
        this.dichVu = dichVu;
        this.noiThat = noiThat;
        this.quyenLoi = quyenLoi;
        this.uuTien = uuTien;
    }
    
    public PhongVip() {
        super();
        this.dichVu = "";
        this.noiThat = "" ;
    }
   
    public String getuuTien(){
        return uuTien;
    }
    public void setuuTien(String uuTien){
        this.uuTien = uuTien;
    }
    
    public String getquyenLoi(){
        return quyenLoi;
    }
    public void setquyenLoi(String quyenLoi){
        this.quyenLoi = quyenLoi;
    }

  

    public String getdichVu(){
        return dichVu;
    }
    public void setdichVu(String dichVu){
        this.dichVu = dichVu;
    }
    public String getnoiThat(){
        return noiThat;
    }
    public void setnoiThat(String noiThat){
        this.noiThat = noiThat;
    }
    public void nhap(){
        // super.nhapThongTin();
        System.out.println("nhap noi that");
        setnoiThat(input.nextLine());
        System.out.println("nhap dich vu ");
        setdichVu(input.nextLine());
    }

}

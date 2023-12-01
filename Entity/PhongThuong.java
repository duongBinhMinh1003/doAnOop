package Entity;
import java.util.Scanner;
public class PhongThuong extends Phong {
    public String dichVu;
    static Scanner input = new Scanner(System.in);
    public String noiThat;
    public PhongThuong(){
        super();
        dichVu = "";
        noiThat = "";
    }
    public PhongThuong(String maPhong , String gia ,String noiThat , String dichVu ,String soLuongNguoi  ){
        super(gia,maPhong,soLuongNguoi);
        this.dichVu = dichVu;
        this.noiThat = noiThat;
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
        super.nhapThongTin();
        System.out.println("nhap noi that");
        setnoiThat(input.nextLine());
        System.out.println("nhap dich vu ");
        setdichVu(input.nextLine());
    }
}

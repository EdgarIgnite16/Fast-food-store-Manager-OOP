
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HoaDon {
    private String idHD;
    private String tenKH;
    private String tenNV;
    private Double thanhTien;
    private String NgayHoaDon;
    public HoaDon() {
        idHD=null;
        tenKH=null;
        tenNV=null;
        thanhTien=null;
        NgayHoaDon=null;
    }
    public String getIdHD() {
        return idHD;
    }
    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }
    public String getTenKH() {
        return tenKH;
    }
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getTenNV() {
        return tenNV;
    }
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    public Double getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getNgayHoaDon() {
        return NgayHoaDon;
    }
    public void setNgayHoaDon(String ngayHoaDon) {
        NgayHoaDon = ngayHoaDon;
    }
    public void nhapHD()
    {
        Scanner sc=new Scanner(System.in);
        Matcher c;
        do
        {
            System.out.println("Nhap id hoa don: ");
            idHD=sc.nextLine();
            String check="^HD[0-9]{2}$";
            Pattern a= Pattern.compile(check);
            c= a.matcher(idHD);
        }
        while(c.find()==false);
        
        do
        {
            System.out.println("Nhap ho ten khach hang: ");
            tenKH=sc.nextLine();
            String check="[^0-9]";
            Pattern a= Pattern.compile(check);
            c= a.matcher(tenKH);
        }
        while(c.find()==false);
        do
        {
            System.out.println("Nhap ho ten nhan vien: ");
            tenNV=sc.nextLine();
            String check="[^0-9]";
            Pattern b= Pattern.compile(check);
            c= b.matcher(tenNV);
        }
        while(c.find()==false);
        
    
        System.out.println("Thanh tien: ");
        thanhTien=Double.parseDouble(sc.nextLine());

          
        do
        {
            System.out.println("Nhap ngay lap hoa don: ");
            NgayHoaDon=sc.nextLine();
            String check="^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(NgayHoaDon);
        }
        while(c.find()==false);
    }
    
    @Override
    public String toString() {
        return String.format("| %-25s %-30s %-30s %-25.2f %-12s |",idHD,tenKH,tenNV,thanhTien,NgayHoaDon);
    }
    public void xuly(String a)
    {
        String []chrt= a.split(";");
        idHD=chrt[0];
        tenKH=chrt[1];
        tenNV=chrt[2];
        thanhTien=Double.parseDouble(chrt[3]);
        NgayHoaDon=chrt[4];
     
    }
    public void output() {
        System.out.println(toString());
    }
    public String xulyLuu() {
        return String.format("%s;%s;%s;%s;%s\n",idHD,tenKH,tenNV,thanhTien,NgayHoaDon);
    }
    public static void main(String[] args) {
        HoaDon a=new HoaDon();
        a.nhapHD();
        System.out.println(a.xulyLuu());
    }
    
}

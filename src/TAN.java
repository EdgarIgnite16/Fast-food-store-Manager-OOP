import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TAN extends Product {
    Scanner sc = new Scanner(System.in);
    private String IdTAN;
    private String Gia;
    private Product ThongtinSP = new Product();

    public TAN() {
        super();
        this.IdTAN = null;
        this.Gia = null;
    }

    public TAN(String IdTAN, String Ten, String ChiTietSP, String Gia) {
        super(Ten, ChiTietSP);
        this.IdTAN = IdTAN;
        this.Gia = Gia;
    }

    public String getIdTAN() {
        return IdTAN;
    }

    public void setIdTAN(String IdTAN) {
        this.IdTAN = IdTAN;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public void Nhap() {
        Matcher c;
        do {
            System.out.println("Nhap ma san pham: ");
            IdTAN = sc.nextLine();
            String check = "^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(IdTAN);
        } while (c.find() == false);

        ThongtinSP.Nhap();

        System.out.println("Nhap gia thuc an nhanh: ");
        Gia = sc.nextLine();

    }

    public void Xuat() {
        System.out.printf("%-10s %-15s %-25s %-10s %-10s", super.getStt(), IdTAN, super.getTen(), super.getChiTietSP(),
                Gia);
    }
    
    public void xuly(String a) {
        String[] chrt = a.split(";");
        IdTAN = chrt[0];
        ThongtinSP.setTen(chrt[1]);
        ThongtinSP.setChiTietSP(chrt[2]);
        Gia = chrt[3];
    }

    public String xylyLuu() {
        return IdTAN + ";" + ThongtinSP.getTen() + ";" + ThongtinSP.getChiTietSP() + ";" + Gia + "\n";
    }
}

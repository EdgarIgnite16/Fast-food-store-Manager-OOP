import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NU extends Product {
    Scanner sc = new Scanner(System.in);
    private String IdNU;
    private String Gia;
    private Product ThongtinSP = new Product();

    public NU() {
        super();
        this.IdNU = null;
        this.Gia = null;
    }

    public NU(String IdNU, String Ten, String ChiTietSP, String Gia) {
        super(Ten, ChiTietSP);
        this.IdNU = IdNU;
        this.Gia = Gia;
    }

    public String getIdNU() {
        return IdNU;
    }

    public void setIdNU(String IdNU) {
        this.IdNU = IdNU;
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
            System.out.println("Nhap ma nu: ");
            IdNU = sc.nextLine();
            String check = "^NU[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(IdNU);
        } while (c.find() == false);

        ThongtinSP.Nhap();

        System.out.println("Nhap gia nuoc uong: ");
        Gia = sc.nextLine();

    }

    public void Xuat() {
        System.out.printf("%-10s %-15s %-25s %-10s %-10s", super.getStt(), IdNU, super.getTen(), super.getChiTietSP(),
                Gia);
    }

    public void xuly(String a) {
        String[] chrt = a.split(";");
        IdNU = chrt[0];
        ThongtinSP.setTen(chrt[1]);
        ThongtinSP.setChiTietSP(chrt[2]);
        Gia = chrt[3];
    }

    public String xylyLuu() {
        return IdNU + ";" + ThongtinSP.getTen() + ";" + ThongtinSP.getChiTietSP() + ";" + Gia + "\n";
    }

}

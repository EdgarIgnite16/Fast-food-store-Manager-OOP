package HandleConstructor;

import MainCore.Product;

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

    public String getId() {
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
            System.out.print("Nhap ma san pham NU: ");
            IdNU = sc.nextLine();
            String check = "^D[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(IdNU);
        } while (!c.find());

        ThongtinSP.Nhap(); // ham nhap nay la ham nhap tu product
        System.out.print("Nhap gia nuoc uong: ");
        Gia = sc.nextLine();
    }

    public void Xuat() {
        System.out.printf("\n| %-20s %-25s %-50s %-28s |",
                IdNU, ThongtinSP.getTen(), ThongtinSP.getChiTietSP(), Gia);
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

    public String getTenNU(){
        return ThongtinSP.getTen();
    }
}

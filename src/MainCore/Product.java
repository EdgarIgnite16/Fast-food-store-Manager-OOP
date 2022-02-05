package MainCore;

import java.util.Scanner;

public class Product {
    private String Ten;
    private String ChiTietSP;
    Scanner sc = new Scanner(System.in);

    public Product() {
        this.Ten = null;
        this.ChiTietSP = null;
    }

    public String getId(){
        return "";
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getChiTietSP() {
        return ChiTietSP;
    }

    public void setChiTietSP(String ChiTietSP) {
        this.ChiTietSP = ChiTietSP;
    }

    public void Nhap() {
        System.out.print("Nhap ten san pham: "); Ten = sc.nextLine();
        System.out.print("Mo ta san pham (gia, co, toping,...): "); ChiTietSP = sc.nextLine();
    }

    public void Xuat() {
        System.out.printf("\n%-25s %-50\n", Ten, ChiTietSP);
    }
}

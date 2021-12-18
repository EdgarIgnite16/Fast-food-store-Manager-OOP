import java.util.Scanner;

public class Product {
    private String Ten;
    private String ChiTietSP;
    private int stt = 1;
    private static int count = 0;

    Scanner sc = new Scanner(System.in);

    public Product() {
        this.Ten = null;
        this.ChiTietSP = null;
        this.stt = count++;
    }

    public Product(String Ten, String ChiTietSP) {
        this.Ten = Ten;
        this.ChiTietSP = ChiTietSP;
        this.stt = count++;
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

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }



    public void Nhap() {

        System.out.println("Nhap ten san pham: ");
        Ten = sc.nextLine();

        System.out.println("Mo ta san pham (gia, co, toping,...): ");
        ChiTietSP = sc.nextLine();
    }


    public void Xuat() {
        System.out.printf("%-10s %-25s %-15s\n", stt, Ten, ChiTietSP);
    }

}

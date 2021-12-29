import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KhachHang extends Person{
    private String idKH;
    protected String LoaiKH;

    public KhachHang() {
        super();
        this.idKH = null;
        this.LoaiKH = null;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getLoaiKH() {
        return LoaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.LoaiKH = loaiKH;
    }

    public void insertKH() {
        Matcher check;
        // nhap id
        do {
            System.out.print("Nhap vao id khach hang: ");
            idKH = new Scanner(System.in).nextLine();
            // regex
            String c = "^KH[0-9]{2}$";
            Pattern a = Pattern.compile(c);
            check = a.matcher(idKH);
        }while(!check.find());

        // nhap ho ten
        do {
            System.out.print("Nhap vao ten khach hang: ");
            String name = new Scanner(System.in).nextLine();
            super.setTen(name);
            // regex
            String c = "[^0-9]";
            Pattern a = Pattern.compile(c);
            check = a.matcher(name);
        }while(!check.find());

        // nhap dia chi
        System.out.print("Nhap vao dia chi cua khach hang: ");
        String diachi = new Scanner(System.in).nextLine();
        super.setDiaChi(diachi);

        // nhap vao tuoi nhan vien
        do {
            System.out.print("Nhap vao tuoi khach hang: ");
            String tuoi = new Scanner(System.in).nextLine();
            super.setTuoi(tuoi);
            // regex
            String c = "^[0-9]{2}$";
            Pattern a = Pattern.compile(c);
            check = a.matcher(tuoi);
        }while(!check.find());

        // nhap vao so dien thoai
        do {
            System.out.print("Nhap vao SDT khach hang: ");
            String sdt = new Scanner(System.in).nextLine();
            super.setSDT(sdt);
            // regex
            String c = "^0[0-9]{9}$";
            Pattern b = Pattern.compile(c);
            check = b.matcher(sdt);
        }while(!check.find());
    }

    public void LoaiKH() {
        LoaiKH = "????";
    }

    public void KhachHangNor() {
        this.LoaiKH = "KH Normal";
    }

    public void KhachHangVIP() {
        this.LoaiKH = "KH VIP";
    }

    @Override
    public void xuly(String a) {
        String []chrt= a.split(";");
        idKH = chrt[0];
        String TenKH = chrt[1]; super.setTen(TenKH);
        String DiaChiKH = chrt[2]; super.setDiaChi(DiaChiKH);
        String tuoiKH = chrt[3]; super.setTuoi(tuoiKH);
        String SdtKH = chrt[4]; super.setSDT(SdtKH);
        LoaiKH = chrt[5];
    }

    @Override
    public String xulyLuu() {
        return String.format("%s;%s;%s;%s;%s;%s\n",
                idKH, super.getTen(), super.getDiaChi(), super.getTuoi(), super.getSDT(), LoaiKH);
    }

    @Override
    public String toString() {
        return String.format("| %-10s %-30s %-40s %-20s %-25s %-20s |",
                idKH, super.getTen(), super.getDiaChi(), super.getTuoi(), super.getSDT(), LoaiKH);
    }

    @Override
    public void output() {
        System.out.println(toString());
    }
}

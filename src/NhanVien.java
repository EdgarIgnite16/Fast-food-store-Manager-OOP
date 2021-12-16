import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NhanVien extends Person{
    private String idNV;
    private String ChucVu;
    private String Luong;

    public NhanVien() {
        super();
        this.idNV = null;
        this.ChucVu = null;
        this.Luong = null;
    }

    public String getIdNV() {
        return idNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getLuong() {
        return Luong;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public void setChucVu(String chucVu) {
        this.ChucVu = chucVu;
    }

    public void setLuong(String luong) {
        this.Luong = luong;
    }

    public void insertNV() {
        Matcher check;
        // nhap id
        do {
            System.out.print("Nhap vao id nhan vien: ");
            idNV = new Scanner(System.in).nextLine();
            // regex
            String c = "^NV[0-9]{2}$";
            Pattern a = Pattern.compile(c);
            check = a.matcher(idNV);
        }while(!check.find());

        // nhap ho ten
        do {
            System.out.print("Nhap vao ten nhan vien: ");
            String name = new Scanner(System.in).nextLine();
            super.setTen(name);
            // regex
            String c = "[^0-9]";
            Pattern a = Pattern.compile(c);
            check = a.matcher(name);
        }while(!check.find());

        // nhap dia chi
        System.out.print("Nhap vao dia chi cua nhan vien: ");
        String diachi = new Scanner(System.in).nextLine();
        super.setDiaChi(diachi);

        // nhap vao tuoi nhan vien
        do {
            System.out.print("Nhap vao tuoi nhan vien: ");
            String age = new Scanner(System.in).nextLine();
            super.setTuoi(age);
            // regex
            String c = "[^0-9]";
            Pattern a = Pattern.compile(c);
            check = a.matcher(age);
        }while(!check.find());

        // nhap vao so dien thoai
        do {
            System.out.print("Nhap vao SDT nhan vien: ");
            String sdt = new Scanner(System.in).nextLine();
            super.setTuoi(sdt);
            // regex
            String c = "[^0-9]";
            Pattern a = Pattern.compile(c);
            check = a.matcher(sdt);
        }while(!check.find());
    }

    public void ChucVu() {
        this.ChucVu = "????";
    }

    public void Luong() {
        this.Luong = "????";
    }

    public void xuly(String a) {
        String []chrt= a.split(";");
        idNV = chrt[0];
        String TenNV = chrt[1]; super.setTen(TenNV);
        String DiaChiNV = chrt[2]; super.setDiaChi(DiaChiNV);
        String SdtNV = chrt[3]; super.setSDT(SdtNV);
        String tuoiNV = chrt[4]; super.setTuoi(tuoiNV);
        ChucVu = chrt[5];
        Luong = chrt[6];
    }

    public String xylyLuu() {
        return String.format("%s;%s;%s%s;%s;%s;%s\n",
                idNV, super.getTen(), super.getDiaChi(), super.getSDT(), super.getTuoi(), ChucVu, Luong);
    }

    @Override
    public String toString() {
        return String.format("| %-10s %-20s %-30s %-15s %-10s %-15s %-20s |",
                idNV, super.getTen(), super.getDiaChi(), super.getSDT(), super.getTuoi(), ChucVu, Luong);
    }

    public void output() {
        System.out.println(toString());
    }
}

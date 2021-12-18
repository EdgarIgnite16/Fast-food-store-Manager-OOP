import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HoaDon {
    private String idHD;
    private String tenKH;
    private String tenNV;
    private Double thanhTien;
    private String NgayHoaDon;
    private Product[] dssp;
    private int SoLuong;


    public HoaDon() {
        idHD=null;
        tenKH=null;
        tenNV=null;
        thanhTien=0.0;
        NgayHoaDon=null;
        dssp=null;
        SoLuong=0;
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
    
    public Product[] getDssp() {
        return dssp;
    }

    public void setDssp(Product[] dssp) {
        this.dssp = dssp;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    static DS_TAN dstan=new DS_TAN();
    static DS_NU dsnu=new DS_NU();

    public void nhapHD()
    {
        Scanner sc = new Scanner(System.in);
        Matcher c;

        do {
            System.out.print("Nhap id hoa don: ");
            idHD = sc.nextLine();
            String check="^HD[0-9]{2}$";
            Pattern a = Pattern.compile(check);
            c = a.matcher(idHD);
        } while(!c.find());
        
        do {
            System.out.print("Nhap ho ten khach hang: ");
            tenKH = sc.nextLine();
            String check = "[^0-9]";
            Pattern a = Pattern.compile(check);
            c = a.matcher(tenKH);
        } while(!c.find());

        do {
            System.out.print("Nhap ho ten nhan vien: ");
            tenNV = sc.nextLine();
            String check = "[^0-9]";
            Pattern b = Pattern.compile(check);
            c = b.matcher(tenNV);
        } while(!c.find());

        System.out.print("So luong san pham: ");
        SoLuong=Integer.parseInt(sc.nextLine());

        
        dsnu.docDSNU();
        dstan.docDSTAN();
        dssp=new Product[SoLuong]; 
        
        for (int i=0;i<SoLuong;){ 
            NU[] SPN=dsnu.getDssp();
            TAN[] SPTAN=dstan.getDssp();
            String MASP;
            do {
                System.out.printf("Nhap ma san pham thu %d: ",i+1);
                MASP = sc.nextLine();
                String check = "^D[0-9]{2}|^F[0-9]{2}$";
                Pattern b = Pattern.compile(check);
                c = b.matcher(MASP);
            } while(!c.find());
            Boolean check=false;
            // Tim ma san pham trong database
            for (int j = 0; j < SPN.length; j++) {
                String key = SPN[j].getId();
                if (key.contentEquals(MASP)) {
                    dssp[i]=SPN[j];
                    thanhTien+=Double.parseDouble(SPN[j].getGia());
                    check=true;
                }
            }  
            for (int j = 0; j < SPTAN.length; j++) {
                String key = SPTAN[j].getId();
                if (key.contentEquals(MASP)) {
                    dssp[i]=SPTAN[j];
                    thanhTien+=Double.parseDouble(SPTAN[j].getGia());
                    check=true;
                }
            }   
            if (!check) System.out.printf("\u001B[41m| Khong tim thay ma san pham %s |\u001B[0m \n",MASP);
            else i++;   
        }   

        do {
            System.out.print("Nhap ngay lap hoa don: ");
            NgayHoaDon = sc.nextLine();
            String check = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(NgayHoaDon);



        } while(!c.find());
    }
    
    @Override
    public String toString() {
        return String.format("| %-25s %-30s %-30s %-25.2f %-12s |",
                idHD,tenKH,tenNV,thanhTien,NgayHoaDon);
    }

    public void xuly(String a) {
        String []chrt= a.split(";");
        idHD = chrt[0];
        tenKH = chrt[1];
        tenNV = chrt[2];
        thanhTien = Double.parseDouble(chrt[3]);
        NgayHoaDon = chrt[4];
        SoLuong=Integer.parseInt(chrt[5]);
        dssp=new Product[SoLuong];
        dsnu.docDSNU();
        dstan.docDSTAN();
        NU[] SPN=dsnu.getDssp();
        TAN[] SPTAN=dstan.getDssp();
        for (int i=0;i<SoLuong;i++) {
            for (int j = 0; j < SPN.length; j++) {
                String key = SPN[j].getId();
                if (key.contentEquals(chrt[6+i])) {
                    dssp[i]=SPN[j];
                }
            }
            for (int j = 0; j < SPTAN.length; j++) {
                String key = SPTAN[j].getId();
                if (key.contentEquals(chrt[6+i])) {
                    dssp[i]=SPTAN[j];
                }
            }
        }
    }
    public void output() {
        System.out.println(toString());
    }

    public String xulyLuu() {
        String s = String.format("%s;%s;%s;%s;%s;",
                idHD,tenKH,tenNV,thanhTien,NgayHoaDon);
        s+=SoLuong+";";
        for (int i=0;i<SoLuong;i++) s+=dssp[i].getId()+";";
        s+="\n";
        return s;
    }
    public void chitietSP() {
        System.out.printf("\u001B[44m| %-20s %-25s %-50s %-28s |\u001B[0m",
        "Ma san pham", "Ten san pham", "Chi tiet SP", "Gia");
        for (int i = 0; i < SoLuong; i++) {
           dssp[i].Xuat();
        }
    }


}

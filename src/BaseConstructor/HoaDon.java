package BaseConstructor;

import HandleList.DS_HoaDon;
import HandleList.DS_KhachHang;
import HandleList.DS_NU;
import HandleList.DS_TAN;
import MainCore.Product;

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
    private String hinhthuc;

    public static DS_TAN dstan = new DS_TAN();
    public static DS_NU dsnu = new DS_NU();

    public HoaDon() {
        idHD = null;
        tenKH = null;
        tenNV = null;
        thanhTien = 0.0;
        NgayHoaDon = null;
        dssp = null;
        SoLuong = 0;
        hinhthuc = null;
    }

    public void printLine() {
        System.out.println();
        for(int j=0;j<130;j++) {
            System.out.print("=");
        }
        System.out.println();
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

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public void nhapHD() {
        Scanner sc = new Scanner(System.in);
        Matcher c;
        String TempStr;
        Matcher checkX;

        DS_HoaDon dshd = new DS_HoaDon();
        dshd.readDSHD();

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

        int selectX;
        String selectTempX;
        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|           Chon hinh thuc van chuyen         |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Mua tai cho                              |");
            System.out.println("| 2. Giao hang tan noi                        |");
            System.out.println("+---------------------------------------------+");
            // Regex
            do {
                System.out.print("Nhap vao lua chon: ");
                selectTempX = new Scanner(System.in).nextLine();
                String f = "^[0-9]{1}";
                Pattern b= Pattern.compile(f);
                checkX = b.matcher(selectTempX);
            }
            while(!checkX.find());
            selectX = Integer.parseInt(selectTempX);

            switch (selectX) {
                case 1: hinhthuc = "ban hang"; break;
                case 2: hinhthuc = "giao hang"; break;
            }
        }while(selectX < 1 || selectX > 2);

        do {
            System.out.print("So luong san pham: ");
            TempStr = sc.nextLine();
            String check = "^[0-99]";
            Pattern b = Pattern.compile(check);
            c = b.matcher(TempStr);
        } while(!c.find());
        SoLuong = Integer.parseInt(TempStr);

        dsnu.docDSNU();
        dstan.docDSTAN();
        dssp = new Product[SoLuong];
        
        for (int i=0;i<SoLuong;){ 
            NU[] SPN = dsnu.getDssp();
            TAN[] SPTAN = dstan.getDssp();
            String MASP;

            do {
                System.out.printf("Nhap ma san pham thu %d: ",i+1);
                MASP = sc.nextLine();
                String check = "^D[0-9]{2}|^F[0-9]{2}$";
                Pattern b = Pattern.compile(check);
                c = b.matcher(MASP);
            } while(!c.find());

            Boolean check = false;
            // Tim ma san pham trong database
            for (int j = 0; j < SPN.length; j++) {
                String key = SPN[j].getId();
                if (key.contentEquals(MASP)) {
                    dssp[i] = SPN[j];
                    thanhTien += Double.parseDouble(SPN[j].getGia());
                    check = true;
                }
            }

            for (int j = 0; j < SPTAN.length; j++) {
                String key = SPTAN[j].getId();
                if (key.contentEquals(MASP)) {
                    dssp[i] = SPTAN[j];
                    thanhTien += Double.parseDouble(SPTAN[j].getGia());
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


        // xử lí trường hợp khách hàng là khách hàng vip thì được giảm 10% thành tiền trong hoá đơn
        DS_KhachHang dskh = new DS_KhachHang();
        dskh.readDSKH();
        for(int x=0;x<dskh.countKH();x++) {
            String name = dskh.getTenKH(x);
            String type = dskh.getloaiKH(x);
            String tempTenKH = tenKH.toLowerCase();
            if(tempTenKH.equals(name.toLowerCase()) && type.equals("KH VIP")) {
                System.out.println("Giam 10% tong hoa don vi khach hang la KH VIP");
                thanhTien = thanhTien - thanhTien * 0.1;
                break;
            }
        }

        // nếu là giao hàng tận nơi thì tăng 15k tiền ship
        if(hinhthuc.equals("giao hang")) {
            System.out.println("Khach hang su dung hinh thuc giao hang tan noi ! Hoa don tang them 15k");
            thanhTien = thanhTien + 15000;
        }
    }

    public void xuly(String a) {
        String []chrt = a.split(";");
        idHD = chrt[0];
        tenKH = chrt[1];
        tenNV = chrt[2];
        thanhTien = Double.parseDouble(chrt[3]);
        NgayHoaDon = chrt[4];
        hinhthuc = chrt[5];
        SoLuong = Integer.parseInt(chrt[6]);
        dssp = new Product[SoLuong];
        dsnu.docDSNU();
        dstan.docDSTAN();
        NU[] SPN = dsnu.getDssp();
        TAN[] SPTAN = dstan.getDssp();
        for (int i=0;i<SoLuong;i++) {
            for (int j = 0; j < SPN.length; j++) {
                String key = SPN[j].getId();
                if (key.contentEquals(chrt[7+i])) {
                    dssp[i]=SPN[j];
                }
            }

            for (int j = 0; j < SPTAN.length; j++) {
                String key = SPTAN[j].getId();
                if (key.contentEquals(chrt[7+i])) {
                    dssp[i]=SPTAN[j];
                }
            }
        }
    }

    public String xulyLuu() {
        String s = String.format("%s;%s;%s;%s;%s;%s;",
                idHD,tenKH,tenNV,thanhTien,NgayHoaDon,hinhthuc);
        s+=SoLuong+";";
        for (int i=0;i<SoLuong;i++) s+=dssp[i].getId()+";";
        s+="\n";
        return s;
    }

    @Override
    public String toString() {
        return String.format("| %-25s %-30s %-30s %-20.2f %-15s %-15s |",
                idHD,tenKH,tenNV,thanhTien,NgayHoaDon,hinhthuc);
    }

    public void output() {
        System.out.println(toString());
    }

    public void chitietSP() {
        printLine();
        System.out.printf("\u001B[44m| %-20s %-25s %-50s %-28s |\u001B[0m",
        "Ma san pham", "Ten san pham", "Chi tiet SP", "Gia");
        for (int i = 0; i < SoLuong; i++) {
           dssp[i].Xuat();
        }
        printLine();
    }
}

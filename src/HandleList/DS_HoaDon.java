package HandleList;

import BaseConstructor.HoaDon;
import AbstractCore.LoaiDanhSach;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DS_HoaDon implements LoaiDanhSach {
    private int n;
    private HoaDon[] dshd;
    Scanner sc = new Scanner(System.in);

    public DS_HoaDon() {
        n = 0;
        dshd = null;
    }

    public static void printLine() {
        for(int j=0;j<144;j++) {
            System.out.print("=");
        }
    }

    // ------------------------------------------------------------------------------------- //
    // dem so luong hoa don
    public int countHD() {
        int count = 0;
        try {
            FileInputStream file = new FileInputStream("./database/DSHD.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            try {
                while((line = buffer.readLine()) != null) {
                    count++;
                }
                n = count;

            }catch(IOException ex) {
                Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    // ------------------------------------------------------------------------------------- //
    // doc du lieu danh sach hoa don
    public void readDSHD() {
        try {
            FileInputStream file = new FileInputStream("./database/DSHD.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);

            String line = null;

            try {
                n = countHD();
                dshd = new HoaDon[n];
                int i = 0;
                while((line = buffer.readLine()) != null) {
                    dshd[i] = new HoaDon();
                    dshd[i].xuly(line);
                    i++;
                }

            }catch(IOException ex) {
                Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ------------------------------------------------------------------------------------- //
    // cap nhat danh sach hoa don
    public void updateDSHD() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./database/DSHD.txt");
            for(int i=0;i<n;i++) {
                String line = dshd[i].xulyLuu();
                try{
                    byte[] infor = line.getBytes("utf8");
                    try {
                        fos.write(infor);
                    } catch (IOException ex) {
                        Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DS_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // ------------------------------------------------------------------------------------- //
    // ham them hoa don vao danh sach hoa don
    public void addHD(HoaDon hd) {
        dshd = Arrays.copyOf(dshd, n+1);
        for(int i=0;i<n+1;i++) {
            if(i == n) dshd[i] = hd;
        }
        n++;
        updateDSHD();
    }

    // ------------------------------------------------------------------------------------- //
    // HienThi danh sach
    public void HienThi() {
        printLine();
        System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-20s %-15s %-15s |\u001B[0m\n",
                "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien(VND)","Ngay mua","Hinh Thuc");
        for(int i=0;i<n;i++) {
            dshd[i].output();
        }
        printLine();
        System.out.println();
    }

    // ------------------------------------------------------------------------------------- //
    // Tim kiem trong danh sach
    public void TimKiem() {
        Matcher check;
        String temp;
        String selectTemp;
        int select;

        do {
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.println("\u001B[44m|              Tim kiem trong DSHD            |\u001B[0m");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Tim kiem theo Id HD                      |");
            System.out.println("| 2. Tim kiem theo Ten KH                     |");
            System.out.println("| 3. Tim kiem theo Ten NV                     |");
            System.out.println("| 4. Tim kiem theo Ten Ngay                   |");
            System.out.println("| 5. Tim kiem theo Hinh thuc van chuyen       |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");

            // Regex
            do {
                System.out.print("Nhap vao lua chon: ");
                selectTemp = sc.nextLine();
                String c = "^[0-9]{1}";
                Pattern b= Pattern.compile(c);
                check = b.matcher(selectTemp);
            }
            while(!check.find());
            select = Integer.parseInt(selectTemp);

            switch(select) {
                case 1:
                    System.out.println("\nBan da chon tim kiem theo ID HD");
                    do {
                        System.out.print("Nhap ID can tim: ");
                        temp = sc.nextLine();
                        String c = "^HD[0-9]{2}$";
                        Pattern b= Pattern.compile(c);
                        check = b.matcher(temp);
                    }
                    while(!check.find());

                    printLine();
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n",
                            "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");
                    for(int i=0;i<n;i++) {
                        String key = dshd[i].getIdHD();
                        if(key.contentEquals(temp)) {
                            dshd[i].output();
                            break;
                        }
                    }
                    printLine();
                    break;

                case 2:
                    System.out.println("\nBan da chon tim kiem theo ten KH");
                    do {
                        System.out.print("Nhap ten nhan vien can tim: ");
                        temp = new Scanner(System.in).nextLine();
                        String c = "[^0-9]";
                        Pattern b= Pattern.compile(c);
                        check = b.matcher(temp);
                    }
                    while(!check.find());

                    printLine();
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n",
                            "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");

                    for(int i=0;i<n;i++) {
                        String key = dshd[i].getTenKH().toLowerCase();
                        if(key.contains(temp.toLowerCase())) {
                            dshd[i].output();
                        }
                    }
                    printLine();
                    break;

                case 3:
                    System.out.println("\nBan da chon tim kiem theo ten NV");
                    do {
                        System.out.print("Nhap ten nhan vien can tim: ");
                        temp = new Scanner(System.in).nextLine();
                        String c = "[^0-9]";
                        Pattern b= Pattern.compile(c);
                        check = b.matcher(temp);
                    }
                    while(!check.find());

                    printLine();
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n",
                            "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");

                    for(int i=0;i<n;i++) {
                        String key = dshd[i].getTenNV().toLowerCase();
                        if(key.contains(temp.toLowerCase())) {
                            dshd[i].output();
                        }
                    }
                    printLine();
                    break;

                case 4:
                    System.out.println("\nBan da chon tim kiem theo ngay");
                    do {
                        System.out.print("Nhap ngay can tim: ");
                        temp = sc.nextLine();
                        String c="^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
                        Pattern b= Pattern.compile(c);
                        check = b.matcher(temp);
                    }
                    while(!check.find());

                    printLine();
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n",
                            "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");

                    for(int i=0;i<n;i++) {
                        String key = dshd[i].getNgayHoaDon();
                        if(key.contentEquals(temp)) {
                            dshd[i].output();
                        }
                    }
                    printLine();
                    break;

                case 5:
                    System.out.println("\nBan da chon tim kiem theo hinh thuc van chuyen !");
                    int select2;
                    String selectTemp2;
                    String temp2 = null;

                    do {
                        System.out.println("");
                        System.out.println("+---------------------------------------------+");
                        System.out.println("|              Tim kiem trong DSHD            |");
                        System.out.println("| -------------------=====--------------------|");
                        System.out.println("| 1. Ban hang tai cho                         |");
                        System.out.println("| 2. Giao hang tan noi                        |");
                        System.out.println("| 0. Tro ve                                   |");
                        System.out.println("+---------------------------------------------+");
                        // Regex
                        do {
                            System.out.print("Nhap vao lua chon: ");
                            selectTemp2 = new Scanner(System.in).nextLine();
                            String c = "^[0-9]{1}";
                            Pattern b= Pattern.compile(c);
                            check = b.matcher(selectTemp2);
                        }
                        while(!check.find());
                        select2 = Integer.parseInt(selectTemp2);

                        switch (select2) {
                            case 1:
                                System.out.println("\nBan da chon tim kiem theo hinh thuc ban hang tai cho");
                                temp2 = "ban hang";
                                printLine();
                                System.out.printf("\n| %-25s %-30s %-30s %-20s %-15s %-15s |\n",
                                        "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien(VND)","Ngay mua","Hinh Thuc");
                                for(int i=0;i<n;i++) {
                                    String key = dshd[i].getHinhthuc().toLowerCase();
                                    if(key.contentEquals(temp2.toLowerCase())) {
                                        dshd[i].output();
                                    }
                                }
                                printLine();
                                break;

                            case 2:
                                System.out.println("\nBan da chon tim kiem theo hinh thuc giao hang tan noi");
                                temp2 = "giao hang";
                                printLine();
                                System.out.printf("\n| %-25s %-30s %-30s %-20s %-15s %-15s |\n",
                                        "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien(VND)","Ngay mua","Hinh Thuc");
                                for(int i=0;i<n;i++) {
                                    String key = dshd[i].getHinhthuc().toLowerCase();
                                    if(key.contentEquals(temp2.toLowerCase())) {
                                        dshd[i].output();
                                    }
                                }
                                printLine();
                                break;

                            case 0:
                                System.out.println("\nTro ve");
                                break;

                            default:
                                System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                                break;
                        }
                    }while (select2 != 0);
                    break;

                default:
                    if (select==0) break;
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
            }
        }while(select != 0);
    }

    // ------------------------------------------------------------------------------------- //
    // them du lieu vao danh sach
    public void Them() {
        System.out.println("\u001B[44m|              Them Hoa Don            |\u001B[0m");
        HoaDon hd = new HoaDon();
        hd.nhapHD();
        addHD(hd);
        System.out.println("\u001B[44m|      Them Hoa Don thanh cong         |\u001B[0m");
    }

    // ------------------------------------------------------------------------------------- //
    // sua thong tin hoa don
    public void Sua() {
        Matcher check;
        String temp;
        String c;
        do {
            System.out.print("Nhap ID hoa don thay doi: ");
            temp = sc.nextLine();
            c = "^HD[0-9]{2}$";
            Pattern b= Pattern.compile(c);
            check = b.matcher(temp);        
        } while(!check.find());

        boolean checking = false;
        for(int i=0;i<n;i++) {
            String key=dshd[i].getIdHD();
            if(key.contentEquals(temp)) {
                checking = true;
                HoaDon hd = new HoaDon();
                System.out.println("Nhap thong tin hoa don !");
                hd.nhapHD();
                dshd[i] = hd;
            }
        }

        if(checking) {
            updateDSHD();
        }else {
            System.out.println("Khong tim thay ma hoa don !");
        }
    }

    // ------------------------------------------------------------------------------------- //
    // xoa hoa don
    public void Xoa() {
        Matcher check;
        String temp;
        do {
            System.out.print("Nhap ID hoa don can xoa: ");
            temp = sc.nextLine();
            String c = "^HD[0-9]{2}$";
            Pattern b= Pattern.compile(c);
            check = b.matcher(temp);
        }
        while(!check.find());

        boolean checking = false;
        for(int i=0;i<n;i++) {
            String key = dshd[i].getIdHD();
            if(key.contentEquals(temp)) {
                checking = true;
                for(int j=i;j<n-1;j++) {
                    dshd[j] = dshd[j+1];
                }
                n--;
                dshd = Arrays.copyOf(dshd, n);
            }
        }
        if(checking) {
            updateDSHD();
        }else {
            System.out.println("Khong tim thay ma don hang !");
        }
    }

    // ------------------------------------------------------------------------------------- //
    // hien thi chi tiet hoa don
    public void chitietHD() {
        String temp;
        Matcher check;
        do {
            System.out.print("Nhap ID Hoa don can xem: ");
            temp = sc.nextLine();
            String c = "^HD[0-9]{2}$";
            Pattern b= Pattern.compile(c);
            check = b.matcher(temp);
        }
        while(!check.find());

        printLine();
        System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-20s %-15s %-15s |\u001B[0m\n",
                "ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua","Hinh Thuc");
        for(int i=0;i<n;i++) {
            String key = dshd[i].getIdHD();
            if(key.contentEquals(temp)) {
                dshd[i].output();
                printLine();
                dshd[i].chitietSP();
            }
        }
        System.out.println();
        System.out.println();
    }
}

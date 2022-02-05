package BaseConstructor;

import HandleConstructor.KhachHang;
import OverideCore.KHNormal;
import OverideCore.KHVIP;
import AbstractCore.LoaiDanhSach;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DS_KhachHang implements LoaiDanhSach {
    private int n;
    private KhachHang[] dskh;

    public DS_KhachHang() {
        n = 0;
        dskh = null;
    }

    public static void printLine() {
        for(int j=0;j<154;j++) {
            System.out.print("=");
        }
    }

    // ------------------------------------------------------------------------------------- //
    // dem so luong kh
    public int countKH() {
        int count = 0;
        try {
            FileInputStream file = new FileInputStream("./database/DSKH.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            try {
                while((line = buffer.readLine()) != null) {
                    count++;
                }
                n = count;

            }catch(IOException ex) {
                Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    // ------------------------------------------------------------------------------------- //
    // doc dskh
    public void readDSKH() {
        try {
            FileInputStream file = new FileInputStream("./database/DSKH.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);

            String line = null;

            try {
                n = countKH();
                dskh = new KhachHang[n];
                int i = 0;
                while((line = buffer.readLine()) != null) {
                    dskh[i] = new KhachHang();
                    dskh[i].xuly(line);
                    i++;
                }

            }catch(IOException ex) {
                Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ------------------------------------------------------------------------------------- //
    // cap nhat dsnv
    public void updateDSKH() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./database/DSKH.txt");
            for(int i=0;i<n;i++) {
                String line = dskh[i].xulyLuu();
                try{
                    byte[] infor = line.getBytes("utf8");
                    try {
                        fos.write(infor);
                    } catch (IOException ex) {
                        Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DS_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // ------------------------------------------------------------------------------------- //
    // ham them thong tin vao danh sach kh
    public void addKH(KhachHang kh) {
        dskh = Arrays.copyOf(dskh, n+1);
        for(int i=0;i<n+1;i++) {
            if(i == n) dskh[i] = kh;
        }
        n++;
        updateDSKH();
    }

    // ------------------------------------------------------------------------------------- //
    // tra ve kich thuoc cua danh sach khach hang tai vi tri thu i
    public String getTenKH(int i) {
        return dskh[i].getTen();
    }

    // ------------------------------------------------------------------------------------- //
    // tra ve kich thuoc cua danh sach khach hang tai vi tri thu i
    public String getloaiKH(int i) {
        return dskh[i].getLoaiKH();
    }

    // 5 chuc nang chinh co ban cua quan li danh sach
    // ------------------------------------------------------------------------------------- //
    // in ra dskh
    public void HienThi() {
        printLine();
        System.out.printf("\n| %-10s %-30s %-40s %-20s %-25s %-20s |\n",
                "Ma KH","Ho Ten","Dia Chi","Tuoi","So dien thoai", "Loai khach hang");
        for(int i=0;i<n;i++) {
            dskh[i].output();
        }
        printLine();
        System.out.println("");
    }

    // ------------------------------------------------------------------------------------- //
    // tim kiem trong dskh
    public void TimKiem() {
        Matcher check;
        String temp;
        int select;
        String selectTemp;

        do {
            System.out.println("");
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Tim kiem trong DSKH            |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Tim kiem theo Id KH                      |");
            System.out.println("| 2. Tim kiem theo Ten KH                     |");
            System.out.println("| 3. Tim kiem theo Loai Khach Hang            |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");

            // Regex
            do {
                System.out.print("Nhap vao lua chon: ");
                selectTemp = new Scanner(System.in).nextLine();
                String c = "^[0-9]{1}";
                Pattern b= Pattern.compile(c);
                check = b.matcher(selectTemp);
            }
            while(!check.find());
            select = Integer.parseInt(selectTemp);

            switch(select) {
                case 1:
                    System.out.println("\nBan da chon tim kiem theo id KH");
                    do {
                        System.out.print("Nhap ma nhan vien can tim: ");
                        temp = new Scanner(System.in).nextLine();
                        String c = "KH[0-9]{2}$";
                        Pattern b = Pattern.compile(c);
                        check = b.matcher(temp);
                    }
                    while(!check.find());

                    printLine();
                    System.out.printf("\n| %-10s %-30s %-40s %-20s %-25s %s-20 |\n",
                            "Ma KH","Ho Ten","Dia Chi","Tuoi","So dien thoai", "Loai khach hang");
                    for(int i=0;i<n;i++) {
                        String key = dskh[i].getIdKH();
                        if(key.contentEquals(temp)) {
                            dskh[i].output();
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
                    System.out.printf("\n| %-10s %-30s %-40s %-20s %-25s %s-20 |\n",
                            "Ma KH","Ho Ten","Dia Chi","Tuoi","So dien thoai", "Loai khach hang");
                    for(int i=0;i<n;i++) {
                        String key = dskh[i].getTen().toLowerCase();
                        if(key.contains(temp.toLowerCase())) {
                            dskh[i].output();
                        }
                    }
                    printLine();
                    break;

                case 3:
                    System.out.println("\nBan da chon tim kiem theo Loai KH");
                    int select2;
                    String selectTemp2;
                    String temp2 = null;

                    do {
                        System.out.println("");
                        System.out.println("+---------------------------------------------+");
                        System.out.println("|              Tim kiem trong DSKH            |");
                        System.out.println("| -------------------=====--------------------|");
                        System.out.println("| 1. Khach hang thong thuong                  |");
                        System.out.println("| 2. Khach hang VIP                           |");
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
                                System.out.println("\nBan da chon tim kiem theo danh sach khach hang Binh Thuong");
                                temp2 = "KH Normal";
                                printLine();
                                System.out.printf("\n| %-10s %-30s %-40s %-20s %-25s %-20s |\n",
                                        "Ma KH","Ho Ten","Dia Chi","Tuoi","So dien thoai", "Loai khach hang");
                                for(int i=0;i<n;i++) {
                                    String key = dskh[i].getLoaiKH().toLowerCase();
                                    if(key.contentEquals(temp2.toLowerCase())) {
                                        dskh[i].output();
                                    }
                                }
                                printLine();
                                break;

                            case 2:
                                System.out.println("\nBan da chon tim kiem theo danh sach khach hang VIP");
                                temp2 = "KH VIP";
                                printLine();
                                System.out.printf("\n| %-10s %-30s %-40s %-20s %-25s %-20s |\n",
                                        "Ma KH","Ho Ten","Dia Chi","Tuoi","So dien thoai", "Loai khach hang");
                                for(int i=0;i<n;i++) {
                                    String key = dskh[i].getLoaiKH().toLowerCase();
                                    if(key.contentEquals(temp2.toLowerCase())) {
                                        dskh[i].output();
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

                case 0:
                    System.out.println("\nTro ve");
                    break;

                default:
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    break;
            }
        }while(select != 0);
    }

    // ------------------------------------------------------------------------------------- //
    // them khach hang
    public void Them() {
        int select2;
        Matcher check;
        String selectTemp;

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|                Them nhan vien               |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Them khach hang Binh thuong              |");
            System.out.println("| 2. Them khach hang VIP                      |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");
            // Regex
            do {
                System.out.print("Nhap vao lua chon: ");
                selectTemp = new Scanner(System.in).nextLine();
                String c = "^[0-9]{1}";
                Pattern b= Pattern.compile(c);
                check = b.matcher(selectTemp);
            }
            while(!check.find());
            select2 = Integer.parseInt(selectTemp);

            switch (select2) {
                case 1:
                    KhachHang kh1 = new KHNormal();
                    kh1.insertKH();
                    kh1.LoaiKH();
                    addKH(kh1);
                    break;

                case 2:
                    KhachHang kh2 = new KHVIP();
                    kh2.insertKH();
                    kh2.LoaiKH();
                    addKH(kh2);
                    break;

                case 0:
                    System.out.println("\nTro ve");
                    break;

                default:
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    break;
            }
        }while (select2 != 0);
    }

    // ------------------------------------------------------------------------------------- //
    // sua thong tin khach hang
    public void Sua() {
        Matcher check;
        String temp;
        String selectTemp;

        do {
            System.out.print("Nhap ma khach hang can thay doi: ");
            temp = new Scanner(System.in).nextLine();
            String c = "^KH[0-9]{2}$";
            Pattern b= Pattern.compile(c);
            check = b.matcher(temp);
        }
        while(!check.find());

        boolean checking = false;
        for(int i=0;i<n;i++) {
            String key= dskh[i].getIdKH();
            if(key.contentEquals(temp)) {
                checking = true;
                System.out.println("Sua thong tin khach hang !");
                KhachHang kh = new KhachHang();
                kh.insertKH();

                int selectX;
                do {
                    System.out.println("+---------------------------------------------+");
                    System.out.println("|           Thay doi Loai Khach hang          |");
                    System.out.println("| -------------------=====--------------------|");
                    System.out.println("| 1. Thay doi thanh khach hang Normal         |");
                    System.out.println("| 2. Thay doi thanh khach hang VIP            |");
                    System.out.println("+---------------------------------------------+");
                    // Regex
                    do {
                        System.out.print("Nhap vao lua chon: ");
                        selectTemp = new Scanner(System.in).nextLine();
                        String c = "^[0-9]{1}";
                        Pattern b= Pattern.compile(c);
                        check = b.matcher(selectTemp);
                    }
                    while(!check.find());
                    selectX = Integer.parseInt(selectTemp);

                    switch (selectX) {
                        case 1: kh.KhachHangNor(); break;
                        case 2: kh.KhachHangVIP(); break;
                    }
                }while(selectX < 1 || selectX > 3);

                dskh[i] = kh;
                break;
            }
        }
        if(checking) {
            updateDSKH();
        }else {
            System.out.println("khong tim thay ma khach hang !");
        }
    }

    // ------------------------------------------------------------------------------------- //
    // xoa thong tin nhan vien
    public void Xoa() {
        Matcher check;
        String temp;
        do {
            System.out.print("Nhap ma khach hang can xoa: ");
            temp = new Scanner(System.in).nextLine();
            String c = "^KH[0-9]{2}$";
            Pattern b= Pattern.compile(c);
            check = b.matcher(temp);
        }
        while(!check.find());

        boolean checking = false;
        for(int i=0;i<n;i++) {
            String key = dskh[i].getIdKH();
            if(key.contentEquals(temp)) {
                checking = true;
                for(int j=i;j<n-1;j++) {
                    dskh[j] = dskh[j+1];
                }
                n--;
                dskh = Arrays.copyOf(dskh, n);
            }
        }

        if(checking) {
            updateDSKH();
        } else  {
            System.out.println("Khong tim thay ma khach hang vua nhap !");
        }
    }
}

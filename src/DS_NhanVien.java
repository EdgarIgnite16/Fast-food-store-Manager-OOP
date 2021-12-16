import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DS_NhanVien {
    private int n;
    private NhanVien[] dsnv;

    public DS_NhanVien() {
        n = 0;
        dsnv = null;
    }

    public void printLine() {
        for(int j=0;j<130;j++) {
            System.out.print("=");
        }
    }

    // dem so luong nv
    public int countNV() {
        int count = 0;
        try {
            FileInputStream file = new FileInputStream("./database/DSNV.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            try {
                while((line = buffer.readLine()) != null) {
                    count++;
                }
                n = count;

            }catch(IOException ex) {
                Logger.getLogger(DS_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    // doc dsnv
    public void readDSNV() {
        try {
            FileInputStream file = new FileInputStream("./database/DSNV.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);

            String line = null;
            int dem = 0;

            try {
                int i = 0;
                n = countNV();
                dsnv = new NhanVien[n];
                while((line = buffer.readLine()) != null) {
                    dsnv[i] = new NhanVien();
                    dsnv[i].xuly(line);
                    i++;
                }

            }catch(IOException ex) {
                Logger.getLogger(DS_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(DS_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // in ra dsnv
    public void printDSNV() {
        printLine();
        System.out.printf("\n| %-10s %-20s %-30s %-15s %-10s %-15s %-20s |\n",
                "Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
        for(int i=0;i<n;i++) {
            dsnv[i].output();
        }
        printLine();
        System.out.println("");
    }

    // tim kiem trong dsnv
    public void searchDSNV() {
        Matcher check;
        String temp;
        int select;

        do {
            System.out.println("");
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Tim kiem trong DSNV            |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Tim kiem theo Id NV                      |");
            System.out.println("| 2. Tim kiem theo Ten NV                     |");
            System.out.println("| 3. Tim kiem theo Chuc vu                    |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Nhap vao lua chon: ");
            select = Integer.parseInt(new Scanner(System.in).nextLine());

            switch(select) {
                case 1:
                    System.out.println("\nBan da chon tim kiem theo id NV");
                    do {
                        System.out.print("Nhap ma nhan vien can tim: ");
                        temp = new Scanner(System.in).nextLine();
                        String c = "^NV[0-9]{2}$";
                        Pattern b= Pattern.compile(c);
                        check = b.matcher(temp);
                    }
                    while(!check.find());

                    printLine();
                    System.out.printf("\n| %-10s %-20s %-30s %-15s %-10s %-15s %-20s |\n",
                            "Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
                    for(int i=0;i<n;i++) {
                        String key = dsnv[i].getIdNV();
                        if(key.contentEquals(temp)) {
                            dsnv[i].output();
                            break;
                        }
                    }
                    printLine();
                    break;

                case 2:
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
                    System.out.printf("\n| %-10s %-20s %-30s %-15s %-10s %-15s %-20s |\n",
                            "Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
                    for(int i=0;i<n;i++) {
                        String key = dsnv[i].getTen().toLowerCase();
                        if(key.contains(temp.toLowerCase())) {
                            dsnv[i].output();
                        }
                    }
                    printLine();
                    break;

                case 3:
                    System.out.println("\nBan da chon tim kiem theo Chuc vu NV");
                    String temp2 = null;
                    int select2;

                    do {
                        System.out.println("");
                        System.out.println("+---------------------------------------------+");
                        System.out.println("|              Tim kiem trong DSNV            |");
                        System.out.println("| -------------------=====--------------------|");
                        System.out.println("| 1. NV Quan Ly                               |");
                        System.out.println("| 2. NV Ban Hang                              |");
                        System.out.println("| 3. NV Giao Hang                             |");
                        System.out.println("| 0. Tro ve                                   |");
                        System.out.println("+---------------------------------------------+");
                        System.out.print("Nhap vao lua chon: ");
                        select2 = Integer.parseInt(new Scanner(System.in).nextLine());

                        switch (select2) {
                            case 1:
                                System.out.println("\nBan da chon tim kiem theo danh sach nv quan li");
                                temp2 = "NV quan ly";
                                printLine();
                                System.out.printf("\n| %-10s %-20s %-30s %-15s %-10s %-15s %-20s |\n",
                                        "Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
                                for(int i=0;i<n;i++) {
                                    String key = dsnv[i].getChucVu().toLowerCase();
                                    if(key.contentEquals(temp2.toLowerCase())) {
                                        dsnv[i].output();
                                    }
                                }
                                printLine();
                                break;

                            case 2:
                                System.out.println("\nBan da chon tim kiem theo danh sach nv ban hang");
                                temp2 = "NV ban hang";
                                printLine();
                                System.out.printf("\n| %-10s %-20s %-30s %-15s %-10s %-15s %-20s |\n",
                                        "Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
                                for(int i=0;i<n;i++) {
                                    String key = dsnv[i].getChucVu().toLowerCase();
                                    if(key.contentEquals(temp2.toLowerCase())) {
                                        dsnv[i].output();
                                    }
                                }
                                printLine();
                                break;

                            case 3:
                                System.out.println("\nBan da chon tim kiem theo danh sach nv giao hang");
                                temp2 = "NV giao hang";
                                printLine();
                                System.out.printf("\n| %-10s %-20s %-30s %-15s %-10s %-15s %-20s |\n",
                                        "Ma NV","Ho Ten","Dia Chi","So dien thoai","Tuoi","Chuc vu","Luong");
                                for(int i=0;i<n;i++) {
                                    String key = dsnv[i].getChucVu().toLowerCase();
                                    if(key.contentEquals(temp2.toLowerCase())) {
                                        dsnv[i].output();
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


}

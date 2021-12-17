import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DS_HoaDon {
    private int n;
    private HoaDon[] dshd;
    Scanner sc=new Scanner(System.in);
    public DS_HoaDon() {
        n = 0;
        dshd = null;
    }
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
    public void readDSHD() {
        try {
            FileInputStream file = new FileInputStream("./database/DSHD.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            int dem = 0;
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
    static void printLine() {
        for(int j=0;j<130;j++) {
            System.out.print("=");
        }
    }
    public void printDSHD() {
        printLine();
        System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n","ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");
        for(int i=0;i<n;i++) {
            dshd[i].output();
        }
        printLine();
        System.out.println();
    }
    public void searchDSHD() {
        Matcher check;
        String temp;
        int select;

        do {
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.println("\u001B[44m|              Tim kiem trong DSNV            |\u001B[0m");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Tim kiem theo Id HD                      |");
            System.out.println("| 2. Tim kiem theo Ten KH                     |");
            System.out.println("| 3. Tim kiem theo Ten NV                     |");
            System.out.println("| 4. Tim kiem theo Ten Ngay                   |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Nhap vao lua chon: ");
            select = Integer.parseInt(sc.nextLine());

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
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n","ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");
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
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n","ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");

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
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n","ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");

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
                    System.out.printf("\n\u001B[44m| %-25s %-30s %-30s %-25s %-12s |\u001B[0m\n","ID Hoa Don","Ten Khach Hang","Ten Nhan Vien","Thanh Tien","Ngay mua");

                    for(int i=0;i<n;i++) {
                        String key = dshd[i].getNgayHoaDon();
                        if(key.contentEquals(temp)) {
                            dshd[i].output();
                        }
                    }
                    printLine();
                    break;


                default:
                    if (select==0) break;
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    
            }
        }while(select != 0);
    }
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
    public void addHD(HoaDon hd) {
        dshd = Arrays.copyOf(dshd, n+1);
        for(int i=0;i<n+1;i++) {
            if(i == n) dshd[i] = hd;
        }
        n++;
        updateDSHD();
    }
    public void insertDSHD() {
        System.out.println("\u001B[44m|              Them Hoa Don            |\u001B[0m");
        HoaDon hd=new HoaDon();
        hd.nhapHD();
        addHD(hd);
        System.out.println("\u001B[44m|      Them Hoa Don thanh cong         |\u001B[0m");
    }
    public void changeDSHD() {
        Matcher check;
        String temp;
        String c;
        do {
            System.out.print("Nhap ID hoa don thay doi: ");
            temp = sc.nextLine();
            c = "^HD[0-9]{2}$";
            Pattern b= Pattern.compile(c);
            check = b.matcher(temp);        
        }
        while(check.find()==false);
        for(int i=0;i<n;i++)
        {
            String key=dshd[i].getIdHD();
            if(key.contentEquals(temp)==true)
            {

                HoaDon hd=new HoaDon();
                System.out.println("Nhap thong tin hoa don");
                hd.nhapHD();
                dshd[i]=hd;
            }
        }
        updateDSHD();
    }
    public void deleteHD() {
        Matcher check;
        String temp;
        do {
            System.out.print("Nhap ID hoa don can xoa: ");
            temp = new Scanner(System.in).nextLine();
            String c = "^HD[0-9]{2}$";
            Pattern b= Pattern.compile(c);
            check = b.matcher(temp);
        }
        while(!check.find());

        for(int i=0;i<n;i++) {
            String key= dshd[i].getIdHD();
            if(key.contentEquals(temp)) {
                for(int j=i;j<n-1;j++) {
                    dshd[j] = dshd[j+1];
                }
                n--;
                dshd = Arrays.copyOf(dshd, n);
            }
        }
        updateDSHD();
    }
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DS_TAN {
    Scanner sc = new Scanner(System.in);
    private int n;
    private TAN[] dssp;

    public DS_TAN() {
        n = 0;
        dssp = null;
    }

    public void printline() {
        System.out.println();
        for (int i = 0; i < 117; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public int demTAN() {
        int dem = 0;
        try {
            FileInputStream file = new FileInputStream("./database/DSTAN.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            try {

                while ((line = buffer.readLine()) != null) {
                    dem++;
                }
                n = dem;
            } catch (IOException ex) {
                Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }

    public void docDSTAN() {
        try {
            FileInputStream file = new FileInputStream("./database/DSTAN.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            try {

                n = demTAN();
                dssp = new TAN[n];
                int i = 0;
                while ((line = buffer.readLine()) != null) {
                    dssp[i] = new TAN();
                    dssp[i].xuly(line);
                    i++;
                }

            } catch (IOException ex) {
                Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void capNhatDSTAN() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./database/DSTAN.txt");
            for (int i = 0; i < n; i++) {
                String line = dssp[i].xylyLuu();
                try {
                    byte[] infor = line.getBytes("utf8");
                    try {
                        fos.write(infor);
                    } catch (IOException ex) {
                        Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DS_TAN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void themTAN(TAN sp) {
        dssp = Arrays.copyOf(dssp, n + 1);
        for (int i = 0; i < n + 1; i++) {
            if (i == n) {
                dssp[i] = sp;
            }
        }
        n++;
        capNhatDSTAN();
    }

    public void xoaTAN() {
        Matcher c;
        String a;
        do {
            System.out.print("Nhap ma san pham can xoa: ");
            a = sc.nextLine();
            String check = "^F[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        } while (!c.find());

        boolean checking = false;
        for (int i = 0; i < n; i++) {
            String key = dssp[i].getIdTAN();
            if (key.contentEquals(a)) {
                checking = true;
                for (int j = i; j < n - 1; j++) {
                    dssp[j] = dssp[j + 1];
                }
                n--;
                dssp = Arrays.copyOf(dssp, n);
            }
        }

        if(checking) {
            capNhatDSTAN();
        }else {
            System.out.println("Khong tim thay ma san pham !");
        }
    }

    public void suaTAN() {
        Matcher c;
        String a;
        do {
            System.out.print("Nhap ma san pham can sua: ");
            a = sc.nextLine();
            String check = "^F[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        } while (!c.find());

        boolean checking = false;
        for (int i = 0; i < n; i++) {
            String key = dssp[i].getIdTAN();
            if (key.contentEquals(a)) {
                checking = true;
                TAN sp = new TAN();
                System.out.println("Nhap thong tin san pham");
                sp.Nhap();
                dssp[i] = sp;
            }
        }

        if(checking) {
            capNhatDSTAN();
        }else {
            System.out.println("Khong tim thay ma san pham !");
        }
    }

    public void timkiemTAN() {
        Matcher c;
        String a;
        do {
            System.out.print("Nhap ma san pham can tim: ");
            a = sc.nextLine();
            String check = "^F[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        } while (!c.find());

//        boolean checking = false;
        for (int i = 0; i < n; i++) {
            String key = dssp[i].getIdTAN();
            if (key.contentEquals(a)) {
//                checking = true;
                printline();
                System.out.printf("\n| %-20s %-25s %-50s %-15s |", "Ma san pham", "Ten san pham",
                        "Chi tiet SP", "Gia");
                dssp[i].Xuat();
                printline();
                break;
            }
        }
    }

    public void xuatDSTAN() {
        printline();
        System.out.printf("| %-20s %-25s %-50s %-15s |",
                "Ma san pham", "Ten san pham", "Chi tiet SP", "Gia");
        for (int i = 0; i < n; i++) {
            dssp[i].Xuat();
        }
        printline();
    }
}

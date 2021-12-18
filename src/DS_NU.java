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

public class DS_NU {

    Scanner sc = new Scanner(System.in);
    private int n;
    private NU[] dssp;

    public DS_NU() {
        n = 0;
        dssp = null;
    }

  
  
    public int demNU() {
        int dem = 0;
        try {
            FileInputStream file = new FileInputStream("./Database/DSNU.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            try {

                while ((line = buffer.readLine()) != null) {
                    dem++;
                }
                n = dem;
            } catch (IOException ex) {
                Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }

    public void docDSNU() {
        try {
            FileInputStream file = new FileInputStream("./Database/DSNU.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            try {

                n = demNU();
                dssp = new NU[n];
                int i = 0;
                while ((line = buffer.readLine()) != null) {
                    dssp[i] = new NU();
                    dssp[i].xuly(line);
                    i++;
                }

            } catch (IOException ex) {
                Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void capNhatDSNU() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./Database/DSNU.txt");
            for (int i = 0; i < n; i++) {
                String line = dssp[i].xylyLuu();
                try {
                    byte[] infor = line.getBytes("utf8");
                    try {
                        fos.write(infor);
                    } catch (IOException ex) {
                        Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DS_NU.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void themNU(NU sp) {
        dssp = Arrays.copyOf(dssp, n + 1);
        for (int i = 0; i < n + 1; i++) {
            if (i == n) {
                dssp[i] = sp;
            }
        }
        n++;
        capNhatDSNU();
    }

    public void xoaNU() {
        Matcher c;
        String a;
        do {
            System.out.println("Nhap ma san pham can xoa: ");
            a = sc.nextLine();
            String check = "^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        } while (c.find() == false);
        for (int i = 0; i < n; i++) {
            String key = dssp[i].getIdNU();
            if (key.contentEquals(a) == true) {
                for (int j = i; j < n - 1; j++) {
                    dssp[j] = dssp[j + 1];
                }
                n--;
                dssp = Arrays.copyOf(dssp, n);
            }
        }
        capNhatDSNU();
    }

    public void suaSP() {
        Matcher c;
        String a;
        do {
            System.out.println("Nhap ma san pham can sua: ");
            a = sc.nextLine();
            String check = "^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        } while (c.find() == false);

        for (int i = 0; i < n; i++) {
            String key = dssp[i].getIdNU();
            if (key.contentEquals(a) == true) {
                NU sp = new NU();
                System.out.println("Nhap thong tin san pham");
                sp.Nhap();
                dssp[i] = sp;
            }
        }
        capNhatDSNU();
    }

    public void timkiemNU() {
        Matcher c;
        String a;
        do {
            System.out.println("Nhap ma san pham can tim: ");
            a = sc.nextLine();
            String check = "^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        } while (c.find() == false);

        for (int i = 0; i < n; i++) {
            String key = dssp[i].getIdNU();
            if (key.contentEquals(a) == true) {
                System.out.println("====================================================");
                System.out.printf("%-10s %-15s %-25s %-10s %-10s\n", "STT", "Ma san pham", "Ten san pham",
                        "Chi tiet SP", "Gia");
                dssp[i].Xuat();
                break;
            }
        }
    }

    public void xuatDSNU() {
        System.out.println("====================================================");
        System.out.printf("%-10s %-15s %-25s %-10s %-10s\n", "STT", "Ma san pham", "Ten san pham",
                "Chi tiet SP", "Gia");
        for (int i = 0; i < n; i++) {
            dssp[i].Xuat();
        }
    }


    
}

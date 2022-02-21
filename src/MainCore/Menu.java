package MainCore;

import HandleList.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public void mainMenu() {
        Matcher check;
        String selectTemp;
        int select;

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("| Quan li cua hang thuc an nhanh va nuoc uong |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Danh sach hoa don                        |");
            System.out.println("| 2. Danh sach san pham                       |");
            System.out.println("| 3. Danh sach nhan vien                      |");
            System.out.println("| 4. Danh sach khach hang                     |");
            System.out.println("| 0. Thoat chuong trinh                       |");
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
                    System.out.println("Ban da chon Danh sach hoa don !");
                    dsHoaDon();
                    break;

                case 2:
                    System.out.println("Ban da chon Danh sach san pham !");
                    dsSanPham();
                    break;

                case 3:
                    System.out.println("Ban da chon Danh sach nhan vien !");
                    dsNhanVien();
                    break;

                case 4:
                    System.out.println("Ban da chon Danh sach khach hang !");
                    dsKhachHang();
                    break;

                    case 0:
                    System.out.println("\nThoat chuong trinh");
                    break;

                default:
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    break;
            }
        } while (select != 0);
    }

    public void dsSanPham() {
        Matcher check;
        String selectTemp;
        int select;

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Danh sach san pham             |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Danh sach san pham thuc anh nhanh        |");
            System.out.println("| 2. Danh sach san pham nuoc uong             |");
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

            switch (select) {
                case 1:
                    int selectX;
                    String selectTempX;
                    do {
                        System.out.println("+---------------------------------------------+");
                        System.out.println("|       Danh sach san pham thuc an nhanh      |");
                        System.out.println("| -------------------=====--------------------|");
                        System.out.println("| 1. Them thong tin san pham                  |");
                        System.out.println("| 2. Sua thong tin san pham                   |");
                        System.out.println("| 3. Xoa thong tin san pham                   |");
                        System.out.println("| 4. Tim kiem thong tin san pham              |");
                        System.out.println("| 5. Xuat danh sach san pham                  |");
                        System.out.println("| 0. Tro ve                                   |");
                        System.out.println("+---------------------------------------------+");

                        // Regex
                        do {
                            System.out.print("Nhap vao lua chon: ");
                            selectTempX = new Scanner(System.in).nextLine();
                            String c = "^[0-9]{1}";
                            Pattern b= Pattern.compile(c);
                            check = b.matcher(selectTempX);
                        }
                        while(!check.find());
                        selectX = Integer.parseInt(selectTempX);
                        DS_TAN dstan = new DS_TAN();
                        dstan.docDSTAN();

                        switch (selectX) {
                            case 1:
                                System.out.println("\nBan da chon Them thong tin thuc an nhanh");
                                dstan.Them();
                                break;

                            case 2:
                                System.out.println("\nBan da chon Sua thong tin thuc an nhanh");
                                dstan.Sua();
                                break;

                            case 3:
                                System.out.println("\nBan da chon Xoa thong tin thuc an nhanh");
                                dstan.Xoa();
                                break;

                            case 4:
                                System.out.println("\nBan da chon Tim kiem thong tin thuc an nhanh");
                                dstan.TimKiem();
                                break;

                            case 5:
                                System.out.println("\nBan da chon Xuat ra danh sach thuc an nhanh");
                                dstan.HienThi();
                                break;

                            case 0:
                                System.out.println("\nTro ve");
                                break;

                            default:
                                System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                                break;
                        }
                    }while(selectX != 0);
                    break;

                case 2:
                    int selectY;
                    String selectTempY;
                    do {
                        System.out.println("+---------------------------------------------+");
                        System.out.println("|          Danh sach san pham nuoc uong       |");
                        System.out.println("| -------------------=====--------------------|");
                        System.out.println("| 1. Them thong tin san pham                  |");
                        System.out.println("| 2. Sua thong tin san pham                   |");
                        System.out.println("| 3. Xoa thong tin san pham                   |");
                        System.out.println("| 4. Tim kiem thong tin san pham              |");
                        System.out.println("| 5. Xuat danh sach san pham                  |");
                        System.out.println("| 0. Tro ve                                   |");
                        System.out.println("+---------------------------------------------+");

                        // Regex
                        do {
                            System.out.print("Nhap vao lua chon: ");
                            selectTempY = new Scanner(System.in).nextLine();
                            String c = "^[0-9]{1}";
                            Pattern b= Pattern.compile(c);
                            check = b.matcher(selectTempY);
                        }
                        while(!check.find());
                        selectY = Integer.parseInt(selectTempY);
                        DS_NU dsnu = new DS_NU();
                        dsnu.docDSNU();


                        switch (selectY) {
                            case 1:
                                System.out.println("\nBan da chon Them thong tin nuoc uong");
                                dsnu.Them();
                                break;

                            case 2:
                                System.out.println("\nBan da chon Sua thong tin nuoc uong");
                                dsnu.Sua();
                                break;

                            case 3:
                                System.out.println("\nBan da chon Xoa thong tin nuoc uong");
                                dsnu.Xoa();
                                break;

                            case 4:
                                System.out.println("\nBan da chon Tim kiem thong tin nuoc uong");
                                dsnu.TimKiem();
                                break;

                            case 5:
                                System.out.println("\nBan da chon Xuat ra danh sach nuoc uong");
                                dsnu.HienThi();
                                break;

                            case 0:
                                System.out.println("\nTro ve");
                                break;

                            default:
                                System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                                break;
                        }
                    }while(selectY != 0);
                    break;

                default:
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    break;
            }
        }while (select != 0);
    }

    public void dsNhanVien() {
        Matcher check;
        String selectTemp;
        int select;

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Danh sach nhan vien            |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Them thong tin nhan vien                 |");
            System.out.println("| 2. Sua thong tin nhan vien                  |");
            System.out.println("| 3. Xoa thong tin nhan vien                  |");
            System.out.println("| 4. Tim kiem thong tin nhan vien             |");
            System.out.println("| 5. Xuat thong tin nhan vien                 |");
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
            DS_NhanVien dsnv = new DS_NhanVien();
            dsnv.readDSNV();

            switch (select) {
                case 1:
                    System.out.println("\nBan da chon Them thong tin nhan vien");
                    dsnv.Them();
                    break;

                case 2:
                    System.out.println("\nBan da chon Sua thong tin nhan vien");
                    dsnv.Sua();
                    break;

                case 3:
                    System.out.println("\nBan da chon Xoa thong tin nhan vien");
                    dsnv.Xoa();
                    break;

                case 4:
                    System.out.println("\nBan da chon Tim kiem thong tin nhan vien");
                    dsnv.TimKiem();
                    break;

                case 5:
                    System.out.println("\nBan da chon Xuat ra danh sach nhan vien");
                    dsnv.HienThi();
                    break;

                case 0:
                    System.out.println("\nTro ve");
                    break;

                default:
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    break;
            }
        }while (select != 0);
    }

    public void dsKhachHang() {
        Matcher check;
        String selectTemp;
        int select;

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Danh sach khach hang           |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Them thong tin khach hang                |");
            System.out.println("| 2. Sua thong tin khach hang                 |");
            System.out.println("| 3. Xoa thong tin khach hang                 |");
            System.out.println("| 4. Tim kiem thong tin khach hang            |");
            System.out.println("| 5. Xuat thong tin khach hang                |");
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
            DS_KhachHang dskh = new DS_KhachHang();
            dskh.readDSKH();

            switch (select) {
                case 1:
                    System.out.println("\nBan da chon Them thong tin khach hang");
                    dskh.Them();
                    break;

                case 2:
                    System.out.println("\nBan da chon Sua thong tin khach hang");
                    dskh.Sua();
                    break;

                case 3:
                    System.out.println("\nBan da chon Xoa thong tin khach hang");
                    dskh.Xoa();
                    break;

                case 4:
                    System.out.println("\nBan da chon Tim kiem thong tin khach hang");
                    dskh.TimKiem();
                    break;

                case 5:
                    System.out.println("\nBan da chon Xuat ra danh sach khach hang");
                    dskh.HienThi();
                    break;

                case 0:
                    System.out.println("\nTro ve");
                    break;

                default:
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    break;
            }
        }while (select != 0);
    }
    
    public void dsHoaDon() {
        Matcher check;
        String selectTemp;
        int select;

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Danh sach hoa don              |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Them hoa don                             |");
            System.out.println("| 2. Sua thong tin hoa don                    |");
            System.out.println("| 3. Xoa thong tin hoa don                    |");
            System.out.println("| 4. Tim kiem hoa don                         |");
            System.out.println("| 5. Xuat danh sach hoa don                   |");
            System.out.println("| 6. Xem chi tiet hoa don                     |");
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
            DS_HoaDon dshd = new DS_HoaDon();
            dshd.readDSHD();

            switch (select) {
                case 1:
                    System.out.println("\nBan da chon Them hoa don");
                    dshd.Them();
                    break;

                case 2:
                    System.out.println("\nBan da chon Sua thong tin hoa don");
                    dshd.Sua();
                    break;

                case 3:
                    System.out.println("\nBan da chon Xoa thong tin hoa don");
                    dshd.Xoa();
                    break;

                case 4:
                    System.out.println("\nBan da chon Tim kiem tim kiem hoa don");
                    dshd.TimKiem();
                    break;

                case 5:
                    System.out.println("\nBan da chon Xuat ra danh sach hoa don");
                    dshd.HienThi();
                    break;

                case 6:
                    System.out.println("\nBan da chon Xem chi tiet hoa don");
                    dshd.chitietHD();
                    break;

                case 0:
                    System.out.println("\nTro ve");
                    break;

                default:
                    System.out.println("Khong co lua chon nao nhu nay !\nVui long nhap lai lua chon.");
                    break;
            }
        }while (select != 0);
    }
}


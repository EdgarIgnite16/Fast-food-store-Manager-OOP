import java.util.Scanner;

public class Menu {
    public void mainMenu() {
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
            System.out.print("Nhap vao lua chon: ");
            select = Integer.parseInt(new Scanner(System.in).nextLine());
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

    public void dsHoaDon() {

    }

    public void dsSanPham() {
        int select;
        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Danh sach san pham             |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Them thong tin san pham                  |");
            System.out.println("| 2. Sua thong tin san pham                   |");
            System.out.println("| 3. Xoa thong tin san pham                   |");
            System.out.println("| 4. Tim kiem thong tin san pham              |");
            System.out.println("| 5. Xuat thong tin san pham                  |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Nhap vao lua chon: ");
            select = Integer.parseInt(new Scanner(System.in).nextLine());


        }while (select != 0);
    }

    public void dsNhanVien() {
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
            System.out.print("Nhap vao lua chon: ");
            select = Integer.parseInt(new Scanner(System.in).nextLine());
            DS_NhanVien dsnv = new DS_NhanVien();
            dsnv.readDSNV();

            switch (select) {
                case 1:
                    System.out.println("\nBan da chon Them thong tin nhan vien");
                    dsnv.insertDSNV();
                    break;

                case 2:
                    System.out.println("\nBan da chon Sua thong tin nhan vien");

                    break;

                case 3:
                    System.out.println("\nBan da chon Xoa thong tin nhan vien");

                    break;

                case 4:
                    System.out.println("\nBan da chon Tim kiem thong tin nhan vien");
                    dsnv.searchDSNV();
                    break;

                case 5:
                    System.out.println("\nBan da chon Xuat ra danh sach nhan vien");
                    dsnv.printDSNV();
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

    }
}

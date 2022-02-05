package OverideCore;

import AbstractCore.LoaiKhachHang;
import HandleConstructor.KhachHang;

public class KHVIP extends KhachHang implements LoaiKhachHang {
    @Override
    public void LoaiKH() {
        LoaiKH = "KH VIP";
    }
}

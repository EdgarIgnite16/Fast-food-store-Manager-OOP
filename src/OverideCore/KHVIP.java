package OverideCore;

import AbstractCore.LoaiKhachHang;
import BaseConstructor.KhachHang;

public class KHVIP extends KhachHang implements LoaiKhachHang {
    @Override
    public void LoaiKH() {
        LoaiKH = "KH VIP";
    }
}

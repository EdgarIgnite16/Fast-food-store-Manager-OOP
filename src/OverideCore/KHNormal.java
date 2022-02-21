package OverideCore;

import AbstractCore.LoaiKhachHang;
import BaseConstructor.KhachHang;

public class KHNormal extends KhachHang implements LoaiKhachHang {
    @Override
    public void LoaiKH() {
        LoaiKH = "KH Normal";
    }
}

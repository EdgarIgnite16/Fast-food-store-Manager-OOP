package OverideCore;

import AbstractCore.LoaiKhachHang;
import HandleConstructor.KhachHang;

public class KHNormal extends KhachHang implements LoaiKhachHang {
    @Override
    public void LoaiKH() {
        LoaiKH = "KH Normal";
    }
}

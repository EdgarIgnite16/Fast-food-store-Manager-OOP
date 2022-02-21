package OverideCore;

import AbstractCore.LoaiNhanVien;
import BaseConstructor.NhanVien;

public class NVBanHang extends NhanVien implements LoaiNhanVien {
    @Override
    public void ChucVu() {
        ChucVu = "NV ban hang";
    }

    @Override
    public void Luong() {
        Luong = "10.000.000vnd";
    }
}

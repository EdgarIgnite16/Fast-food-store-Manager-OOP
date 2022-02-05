package OverideCore;

import AbstractCore.LoaiNhanVien;
import HandleConstructor.NhanVien;

public class NVQuanLy extends NhanVien implements LoaiNhanVien {
    @Override
    public void ChucVu() {
        ChucVu = "NV quan ly";
    }

    @Override
    public void Luong() {
        Luong = "15.000.000vnd";
    }
}

package OverideCore;

import AbstractCore.LoaiNhanVien;
import HandleConstructor.NhanVien;

public class NVGiaoHang extends NhanVien implements LoaiNhanVien {
    @Override
    public void ChucVu() {
        ChucVu = "NV giao hang";
    }

    @Override
    public void Luong() {
        Luong = "12.000.000vnd";
    }
}

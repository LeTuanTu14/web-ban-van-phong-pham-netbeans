/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dto;
import com.se.VanPhongPhamTLP.entity.SanPham;

/**
 *
 * @author TUAN TU
 */
public class CartDTO {
    private int soLuong;
    private double tongTien;
    private SanPham sanPham;

    public CartDTO() {
    }

    public CartDTO(int soLuong, double tongTien, SanPham sanPham) {
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    
    
}

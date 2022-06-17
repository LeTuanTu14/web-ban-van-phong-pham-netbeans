/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dto;

import com.se.VanPhongPhamTLP.entity.SanPham;
import java.sql.Date;
/**
 *
 * @author TUAN TU
 */
public class SanPhamDTO {
    private int maSP;
    private String tenSP;
    private String loai;
    private int soLuong;
    private String moTa;
    private double gia;
    private String spHot;
    private String spNew;
    private String image;

    public int getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getLoai() {
        return loai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public double getGia() {
        return gia;
    }

    public String getSpHot() {
        return spHot;
    }

    public String getSpNew() {
        return spNew;
    }

    public String getImage() {
        return image;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setSpHot(String spHot) {
        this.spHot = spHot;
    }

    public void setSpNew(String spNew) {
        this.spNew = spNew;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
}

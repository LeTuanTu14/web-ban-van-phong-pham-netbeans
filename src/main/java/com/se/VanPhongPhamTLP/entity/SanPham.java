/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TUAN TU
 */
@Entity
@Table(name = "SanPham")
public class SanPham {
    
    @Id
    @Column(name = "maSP")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int maSP;
    
    @Column(name = "tenSP")
    private String tenSP;
    
    @Column(name = "loai")
    private String loai;
    
    @Column(name = "soLuong")
    private int soLuong;
    
    @Column(name = "moTa")
    private String moTa;
    
    @Column(name = "gia")
    private double gia;   
    
    @Column(name = "spHot")
    private String spHot;
    
    @Column(name = "spNew")
    private String spNew;
    
    @Column(name="photo")
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    

}

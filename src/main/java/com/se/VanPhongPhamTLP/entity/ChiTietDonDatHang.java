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
@Table(name = "ChiTietDonDatHang")
public class ChiTietDonDatHang {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "idDonDH")
    private int idDonDH;
    
    @Column(name = "idSanPham")
    private int idSanPham;
    
    @Column(name = "soLuong")
    private int soLuong;
    
    @Column(name = "tongTien")
    private double tongTien;

    public int getId() {
        return id;
    }

    public int getIdDonDH() {
        return idDonDH;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdDonDH(int idDonDH) {
        this.idDonDH = idDonDH;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ChiTietDonDatHang{" + "id=" + id + ", idDonDH=" + idDonDH + ", idSanPham=" + idSanPham + ", soLuong=" + soLuong + ", tongTien=" + tongTien + '}';
    }
    
    
}

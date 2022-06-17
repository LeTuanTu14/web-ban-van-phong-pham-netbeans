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
@Table(name = "DonDatHang")
public class DonDatHang {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "userEmail")
    private String user;
    
    @Column(name = "sdt")
    private String sdt;
    
    @Column(name = "hoTen")
    private String hoTen;
    
    @Column(name = "diaChi")
    private String diaChi;
    
    @Column(name = "tongTien")
    private double tongTien;
    
    @Column(name = "soLuong")
    private int soLuong;
    
    @Column(name = "ghiChu")
    private String ghiChu;

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getSdt() {
        return sdt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public double getTongTien() {
        return tongTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    @Override
    public String toString() {
        return "DonDatHang{" + "id=" + id + ", user=" + user + ", sdt=" + sdt + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", tongTien=" + tongTien + ", soLuong=" + soLuong + '}';
    }
    
    
    
}

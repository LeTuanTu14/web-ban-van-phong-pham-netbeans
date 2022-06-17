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
@Table(name = "Loai")
public class Loai {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "tenLoai")
    private String tenLoai;
    
    @Column(name = "congDung")
    private String congDung;
        
    public int getId() {
        return id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }
    
}

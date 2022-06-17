/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dao;
import com.se.VanPhongPhamTLP.dto.CartDTO;


import java.util.HashMap;
/**
 *
 * @author TUAN TU
 */
public interface GioHangDAO {
    public HashMap<Integer, CartDTO> addGioHang(int id, HashMap<Integer, CartDTO> gioHang);
    public HashMap<Integer, CartDTO> updateGioHang(int id, int sl, HashMap<Integer, CartDTO> gioHang);
    public HashMap<Integer, CartDTO> deleteGioHang(int id, HashMap<Integer, CartDTO> gioHang);
    public int tinhTongSoLuong(HashMap<Integer, CartDTO> gioHang);
    public double tinhTongTien(HashMap<Integer, CartDTO> gioHang);
}

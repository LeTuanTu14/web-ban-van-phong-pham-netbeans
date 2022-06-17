/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.service;

import com.se.VanPhongPhamTLP.dao.GioHangDAO;
import com.se.VanPhongPhamTLP.dto.CartDTO;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author TUAN TU
 */
@Service
public class GioHangServiceImpl implements GioHangService{
    
    @Autowired
    private GioHangDAO gioHangDAO;

    @Override
    @Transactional
    public HashMap<Integer, CartDTO> addGioHang(int id, HashMap<Integer, CartDTO> gioHang) {
        return gioHangDAO.addGioHang(id, gioHang);
    }

    @Override
    @Transactional
    public HashMap<Integer, CartDTO> updateGioHang(int id, int sl, HashMap<Integer, CartDTO> gioHang) {
        return gioHangDAO.updateGioHang(id, sl, gioHang);
    }

    @Override
    @Transactional
    public HashMap<Integer, CartDTO> deleteGioHang(int id, HashMap<Integer, CartDTO> gioHang) {
        return gioHangDAO.deleteGioHang(id, gioHang);
    }

    @Override
    @Transactional
    public int tinhTongSoLuong(HashMap<Integer, CartDTO> gioHang) {
        return gioHangDAO.tinhTongSoLuong(gioHang);
    }

    @Override
    @Transactional
    public double tinhTongTien(HashMap<Integer, CartDTO> gioHang) {
        return gioHangDAO.tinhTongTien(gioHang);
    }
    
}

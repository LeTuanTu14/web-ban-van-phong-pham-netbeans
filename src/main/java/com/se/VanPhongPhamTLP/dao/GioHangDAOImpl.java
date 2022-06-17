/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dao;

import com.se.VanPhongPhamTLP.dto.CartDTO;
import com.se.VanPhongPhamTLP.entity.SanPham;
import com.se.VanPhongPhamTLP.service.SanPhamService;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TUAN TU
 */
@Repository
public class GioHangDAOImpl implements GioHangDAO{
    
    @Autowired
    private SanPhamService sanPhamService;
    
    @Transactional
    @Override
    public HashMap<Integer, CartDTO> addGioHang(int id, HashMap<Integer, CartDTO> gioHang) {
        CartDTO gioHangDTO = new CartDTO();
	SanPham sp = sanPhamService.getSanPham(id);
	if(sp != null && gioHang.containsKey(id)) {
		gioHangDTO = gioHang.get(id);
		gioHangDTO.setSoLuong(gioHangDTO.getSoLuong() + 1);
		gioHangDTO.setTongTien(gioHangDTO.getSoLuong() * gioHangDTO.getSanPham().getGia());
	}
	else {
		gioHangDTO.setSanPham(sp);
		gioHangDTO.setSoLuong(1);
		gioHangDTO.setTongTien(sp.getGia());
	}
	gioHang.put(id, gioHangDTO);
	return gioHang;
    }
    
    @Transactional
    @Override
    public HashMap<Integer, CartDTO> updateGioHang(int id, int sl, HashMap<Integer, CartDTO> gioHang) {
		if(gioHang == null) {
			return gioHang;
		}
		CartDTO gioHangDTO = new CartDTO();
		if(gioHang.containsKey(id)) {
			gioHangDTO = gioHang.get(id);
			gioHangDTO.setSoLuong(sl);
			double tongTien = sl * gioHangDTO.getSanPham().getGia();
			gioHangDTO.setTongTien(tongTien);
		}
		gioHang.put(id, gioHangDTO);
		return gioHang;
	}
    
    @Transactional
    @Override
    public HashMap<Integer, CartDTO> deleteGioHang(int id, HashMap<Integer, CartDTO> gioHang) {
		if(gioHang == null) {
			return gioHang;
		}
		if(gioHang.containsKey(id)) {
			gioHang.remove(id);
		}
		return gioHang;
	}
    
        @Transactional
        @Override
        public int tinhTongSoLuong(HashMap<Integer, CartDTO> gioHang) {
		int totalQuanty = 0;
		for(Map.Entry<Integer, CartDTO> gioHangDTO : gioHang.entrySet()) {
			totalQuanty += gioHangDTO.getValue().getSoLuong();
		}
		return totalQuanty;
	}
	
        @Transactional
        @Override
	public double tinhTongTien(HashMap<Integer, CartDTO> gioHang) {
		double totalPrice = 0;
		for(Map.Entry<Integer, CartDTO> gioHangDTO : gioHang.entrySet()) {
			totalPrice += gioHangDTO.getValue().getTongTien();
		}
		return totalPrice;
	}
}

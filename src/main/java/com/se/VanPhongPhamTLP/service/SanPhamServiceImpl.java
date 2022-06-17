/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.service;

import org.springframework.stereotype.Service;
import com.se.VanPhongPhamTLP.dao.SanPhamDAO;
import com.se.VanPhongPhamTLP.entity.SanPham;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TUAN TU
 */
@Service
public class SanPhamServiceImpl implements SanPhamService{
    @Autowired
    private SanPhamDAO sanPhamDAO;
    
    @Override
    @Transactional
    public List<SanPham> getSanPhams() {
        return sanPhamDAO.getSanPhams();
    }

    @Override
    @Transactional
    public void saveSanPham(SanPham theSP) {
        sanPhamDAO.saveSanPham(theSP);
    }

    @Override
    @Transactional
    public SanPham getSanPham(int theId) {
        return sanPhamDAO.getSanPham(theId);
    }

    @Override
    @Transactional
    public void deleteSanPham(int theId) {
        sanPhamDAO.deleteSanPham(theId);
    }

    @Override
    @Transactional
    public List<SanPham> searchSanPhams(String theSearchName) {
        return sanPhamDAO.searchSanPhams(theSearchName);
    }
    
    @Override
    @Transactional
    public List<SanPham> getSanPhamsTheoLoai(String loai) {
        return sanPhamDAO.getSanPhamsTheoLoai(loai);
    }

    @Override
    @Transactional
    public List<SanPham> getSanPhamsMoi() {
        return sanPhamDAO.getSanPhamsMoi();
    }

    @Override
    @Transactional
    public List<SanPham> getSanPhamsHot() {
        return sanPhamDAO.getSanPhamsHot();
    }
}

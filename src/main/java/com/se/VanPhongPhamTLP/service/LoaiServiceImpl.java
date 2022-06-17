/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.service;

import com.se.VanPhongPhamTLP.dao.LoaiDAO;
import com.se.VanPhongPhamTLP.entity.Loai;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author TUAN TU
 */
@Service
public class LoaiServiceImpl implements LoaiService{
    @Autowired
    private LoaiDAO loaiDAO;
    
    @Override
    @Transactional
    public List<Loai> getLoais() {
        return loaiDAO.getLoais();
    }

    @Override
    @Transactional
    public Loai getLoai(int Id) {
        return loaiDAO.getLoai(Id);
    }

    @Override
    @Transactional
    public void saveLoai(Loai loai) {
        loaiDAO.saveLoai(loai);
    }

    @Override
    @Transactional
    public void deleteLoai(int Id) {
        loaiDAO.deleteLoai(Id);
    }

    @Override
    @Transactional
    public List<Loai> searchLoais(String theSearchName) {
        return loaiDAO.searchLoais(theSearchName);
    }
    
}

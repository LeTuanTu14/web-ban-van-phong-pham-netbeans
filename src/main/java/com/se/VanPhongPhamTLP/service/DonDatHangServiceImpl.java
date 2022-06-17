/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.service;
import com.se.VanPhongPhamTLP.dao.DonDatHangDAO;
import com.se.VanPhongPhamTLP.dao.SanPhamDAO;
import com.se.VanPhongPhamTLP.dto.CartDTO;
import com.se.VanPhongPhamTLP.entity.DonDatHang;
import com.se.VanPhongPhamTLP.entity.SanPham;
import com.se.VanPhongPhamTLP.entity.ChiTietDonDatHang;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TUAN TU
 */
@Service
public class DonDatHangServiceImpl implements DonDatHangService{
    
    @Autowired
    private DonDatHangDAO donDatHangDAO;
    @Autowired
    private SanPhamDAO sanPhamDAO;

    @Override
    @Transactional
    public void addDonDatHang(DonDatHang don) {
        donDatHangDAO.addDonDatHang(don);
    }

    @Override
    @Transactional
    public void addChiTietDonDatHang(HashMap<Integer, CartDTO> gioHang, int idHD) {
        for(Map.Entry<Integer, CartDTO> gioHangDTO : gioHang.entrySet()) {
            ChiTietDonDatHang chiTietDDH= new ChiTietDonDatHang();
            chiTietDDH.setIdDonDH(idHD);
            chiTietDDH.setIdSanPham(gioHangDTO.getValue().getSanPham().getMaSP());
            chiTietDDH.setSoLuong(gioHangDTO.getValue().getSoLuong());
            chiTietDDH.setTongTien(gioHangDTO.getValue().getTongTien());
            donDatHangDAO.addChiTietDonDatHang(chiTietDDH);
            SanPham sp= sanPhamDAO.getSanPham(gioHangDTO.getValue().getSanPham().getMaSP());
            sp.setSoLuong(sp.getSoLuong()-gioHangDTO.getValue().getSoLuong());
            sanPhamDAO.saveSanPham(sp);
        }
    }

    @Override
    @Transactional
    public List<DonDatHang> getDonDatHangs() {
        return donDatHangDAO.getDonDatHangs();
    }

    @Override
    @Transactional
    public void deleteDonDatHang(int theId) {
        donDatHangDAO.deleteDonDatHang(theId);
    }

    @Override
    @Transactional
    public DonDatHang getDonDatHang(int theId) {
        return donDatHangDAO.getDonDatHang(theId);
    }

    @Override
    @Transactional
    public List<DonDatHang> searchDonDatHangs(String theSearchName) {
        return donDatHangDAO.searchDonDatHangs(theSearchName);
    }

    @Override
    @Transactional
    public List<ChiTietDonDatHang> getChiTietDonDatHangs(int id) {
        return donDatHangDAO.getChiTietDonDatHangs(id);
    }

    @Override
    @Transactional
    public void deleteChiTietDonDatHang(int theId) {
        donDatHangDAO.deleteChiTietDonDatHang(theId);
    }
    
}

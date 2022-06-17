/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.service;
import com.se.VanPhongPhamTLP.dto.CartDTO;
import com.se.VanPhongPhamTLP.entity.ChiTietDonDatHang;
import com.se.VanPhongPhamTLP.entity.DonDatHang;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TUAN TU
 */
public interface DonDatHangService {
    public void addDonDatHang(DonDatHang don);
    public void addChiTietDonDatHang(HashMap<Integer, CartDTO> gioHang, int idHD);
    public List<DonDatHang> getDonDatHangs();
    public void deleteDonDatHang(int theId);
    public DonDatHang getDonDatHang(int theId);
    public List<DonDatHang> searchDonDatHangs(String theSearchName);
    public List<ChiTietDonDatHang> getChiTietDonDatHangs(int id);
    public void deleteChiTietDonDatHang(int theId);
}

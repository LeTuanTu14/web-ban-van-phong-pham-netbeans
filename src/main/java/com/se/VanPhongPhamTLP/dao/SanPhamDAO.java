/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dao;

import com.se.VanPhongPhamTLP.entity.SanPham;
import java.util.List;

/**
 *
 * @author TUAN TU
 */
public interface SanPhamDAO {
    public List<SanPham> getSanPhams();
    public List<SanPham> getSanPhamsTheoLoai(String loai);
    public List<SanPham> getSanPhamsMoi();
    public List<SanPham> getSanPhamsHot();
    public void saveSanPham(SanPham theSP);
    public SanPham getSanPham(int theId);
    public void deleteSanPham(int theId);
    public List<SanPham> searchSanPhams(String theSearchName);
}

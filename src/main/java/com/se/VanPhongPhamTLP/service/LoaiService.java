/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.service;

import com.se.VanPhongPhamTLP.entity.Loai;
import java.util.List;

/**
 *
 * @author TUAN TU
 */
public interface LoaiService {
    public List<Loai> getLoais();
    public Loai getLoai(int Id);
    public void saveLoai(Loai loai);
    public void deleteLoai(int Id);
    public List<Loai> searchLoais(String theSearchName);
}

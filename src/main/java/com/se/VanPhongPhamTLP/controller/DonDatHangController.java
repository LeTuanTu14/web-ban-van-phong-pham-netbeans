/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.controller;

import com.se.VanPhongPhamTLP.entity.DonDatHang;
import com.se.VanPhongPhamTLP.entity.SanPham;
import com.se.VanPhongPhamTLP.entity.ChiTietDonDatHang;
import com.se.VanPhongPhamTLP.entity.User;
import com.se.VanPhongPhamTLP.service.DonDatHangService;
import com.se.VanPhongPhamTLP.service.SanPhamService;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author TUAN TU
 */
@Controller
@RequestMapping("/dondathang")
public class DonDatHangController {
    
    @Autowired
    private DonDatHangService dondathangService;
    @Autowired
    private SanPhamService sanPhamService;
    
    @GetMapping("/list")
    public String listDDH(Model theModel,HttpSession session) {
        User user= (User) session.getAttribute("taikhoan");
        if(user != null && (user.getEmail()).contains("admin@gmail.com")){
        List<DonDatHang> donDHs = dondathangService.getDonDatHangs();
        
        theModel.addAttribute("dondathangs", donDHs);
        return "list-donDHs"; 
        }
        else{
            return "redirect:/user/dangnhap";
        }
	}
    @GetMapping(value ="/delete/{id}")
    public String delete(@PathVariable int id) {
        dondathangService.deleteDonDatHang(id);
        List<ChiTietDonDatHang> ct= dondathangService.getChiTietDonDatHangs(id);
        for (ChiTietDonDatHang chiTietDonDatHang : ct) {
            dondathangService.deleteChiTietDonDatHang(chiTietDonDatHang.getId());
        }
        return "redirect:/dondathang/list";
    }
    @GetMapping(value ="/xem/{id}")
    public String xem(@PathVariable int id, Model theModel) {
        DonDatHang ddh = dondathangService.getDonDatHang(id);
        List<ChiTietDonDatHang> ct= dondathangService.getChiTietDonDatHangs(id);
        List<SanPham> sps= new ArrayList<SanPham>();
        sps.clear();
        for (ChiTietDonDatHang chiTietDonDatHang : ct) {
            SanPham s= sanPhamService.getSanPham(chiTietDonDatHang.getIdSanPham());
            s.setSoLuong(chiTietDonDatHang.getSoLuong());
            s.setGia(chiTietDonDatHang.getTongTien());
            sps.add(s);
        }
        theModel.addAttribute("sanphamddh", sps);
        theModel.addAttribute("dondathang", ddh);
        return "ChiTietDonDatHang";
    }
    
    @GetMapping("/search")
    public String searchDonDatHangs(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        List<DonDatHang> ddhs = dondathangService.searchDonDatHangs(theSearchName);
                
        theModel.addAttribute("dondathangs", ddhs);
        return "list-donDHs";        
    }
}

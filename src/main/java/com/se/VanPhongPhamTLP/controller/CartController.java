/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.se.VanPhongPhamTLP.service.SanPhamService;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import com.se.VanPhongPhamTLP.service.GioHangService;
import com.se.VanPhongPhamTLP.dto.CartDTO;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.se.VanPhongPhamTLP.entity.DonDatHang;
import com.se.VanPhongPhamTLP.entity.User;
import com.se.VanPhongPhamTLP.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.se.VanPhongPhamTLP.service.DonDatHangService;
import com.sun.java.swing.plaf.windows.resources.windows;

/**
 *
 * @author TUAN TU
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private GioHangService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private DonDatHangService donDatHangService;
    
    @RequestMapping(value ="/myCart")
    public String showGioHang(){

        return "cart";
    }
    
    @GetMapping(value ="/add/{id}")
    public String addGioHang(HttpSession session, @PathVariable int id) {

        HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
        if(cart == null) {
		cart = new HashMap<Integer, CartDTO>();
	}
	cart = cartService.addGioHang(id, cart);
	session.setAttribute("Cart", cart);
	session.setAttribute("TotalQuantyCart", cartService.tinhTongSoLuong(cart));
	session.setAttribute("TotalPriceCart", cartService.tinhTongTien(cart));
        return "redirect:/cart/myCart";
    }
    
    @GetMapping(value ="/delete/{id}")
    public String deleteGioHang(HttpSession session, @PathVariable int id) {

          HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
            if(cart == null) {
            cart = new HashMap<Integer, CartDTO>();
            }
            cart = cartService.deleteGioHang(id, cart);
            session.setAttribute("Cart", cart);
            session.setAttribute("TotalQuantyCart", cartService.tinhTongSoLuong(cart));
            session.setAttribute("TotalPriceCart", cartService.tinhTongTien(cart));
        return "redirect:/cart/myCart";
    }
    
    @PostMapping(value ="/update")
    public String updateGioHang(HttpSession session, @RequestParam("id") int id,
            @RequestParam("sl")int sl) {

          HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
          if(cart == null) {
          cart = new HashMap<Integer, CartDTO>();
          }
          cart = cartService.updateGioHang(id, sl, cart);
          session.setAttribute("Cart", cart);
          session.setAttribute("TotalQuantyCart", cartService.tinhTongSoLuong(cart));
          session.setAttribute("TotalPriceCart", cartService.tinhTongTien(cart));
        return "redirect:/cart/myCart";
    }
    
    @GetMapping("/dathang")
    public String showDatHang(Model theModel, HttpSession session) {
        // create model attribute to bind form data
        if((session.getAttribute("Cart")==null)||(session.getAttribute("TotalPriceCart").equals(0.0))){
            return "redirect:/sanphams";
        }
        DonDatHang don = new DonDatHang();
        theModel.addAttribute("dondh", don);
        User u= (User) session.getAttribute("taikhoan");
        if(u!= null){
            don.setUser(u.getEmail());
            don.setHoTen(u.getHoTen());
            don.setDiaChi(u.getDiaChi());
            return "dondathang";
        }
        return "redirect:/user/dangnhap";    
    }
    
    @PostMapping("/saveDDH")
    public String saveDonDatHang(@ModelAttribute("dondh") DonDatHang don, HttpSession session) {
        if(!(don.getSdt().length()>0)){
            session.setAttribute("errSDT", don);
            return "redirect:/cart/dathang";
        }
        if(!(don.getDiaChi().length()>0)){
            session.setAttribute("errDC", don);
            return "redirect:/cart/dathang";
        }
        HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>)session.getAttribute("Cart");
        don.setTongTien((double) session.getAttribute("TotalPriceCart"));
        don.setSoLuong((int) session.getAttribute("TotalQuantyCart"));
        donDatHangService.addDonDatHang(don);
        donDatHangService.addChiTietDonDatHang(cart, don.getId());
        session.removeAttribute("Cart");
        session.removeAttribute("TotalPriceCart");
        session.removeAttribute("TotalQuantyCart");
        session.removeAttribute("errSDT");
        session.removeAttribute("errDC");
        return "redirect:/cart/myCart";
    }
}

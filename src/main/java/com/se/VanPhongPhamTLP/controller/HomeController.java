package com.se.VanPhongPhamTLP.controller;

import com.se.VanPhongPhamTLP.entity.SanPham;
import com.se.VanPhongPhamTLP.entity.User;
import com.se.VanPhongPhamTLP.entity.Loai;
import com.se.VanPhongPhamTLP.service.LoaiService;
import com.se.VanPhongPhamTLP.service.SanPhamService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
    // need to inject our sanpham service
    private SanPhamService sanPhamService;
    @Autowired
    private LoaiService loaiService;
    
	@RequestMapping(value = {"/","/home"})
	public String home(Model theModel) {
            List<Loai> theLoais = loaiService.getLoais();
            List<SanPham> spMoi= sanPhamService.getSanPhamsMoi();
            List<SanPham> spHot= sanPhamService.getSanPhamsHot();
            // add the sanphams to the model
            theModel.addAttribute("loais", theLoais);
            theModel.addAttribute("spNews", spMoi);
            theModel.addAttribute("spHots", spHot);
		return "home";
	}
	@RequestMapping(value = "/sanphams")
	public String showSanPham(Model theModel) {
            // get sanphams from the service
            List<SanPham> theSanPhams = sanPhamService.getSanPhams();
            // add the customers to the model
            theModel.addAttribute("sanphams", theSanPhams);
		return "SanPhams";
	}
        @RequestMapping(value = { "/chitietsanpham/{id}" })
	public String Index(@PathVariable int id, Model theModel) {
            List<Loai> theLoais = loaiService.getLoais();
            SanPham sp= sanPhamService.getSanPham(id);
            theModel.addAttribute("sanpham",sp);
            theModel.addAttribute("loais", theLoais);
            return "ChiTietSanPham";
	}
        @RequestMapping(value = "/quanly")
	public String showQuanLy(HttpSession session) {
            User user= (User) session.getAttribute("taikhoan");
            if(user != null && (user.getEmail()).contains("admin@gmail.com"))
		return "admin";
            else{
                return "redirect:/home";
            }
	}
        @RequestMapping(value = "/lienhe")
	public String showLienHe(HttpSession session) {
            return "LienHe";
	}
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.se.VanPhongPhamTLP.service.SanPhamService;
import com.se.VanPhongPhamTLP.service.LoaiService;
import com.se.VanPhongPhamTLP.entity.SanPham;
import com.se.VanPhongPhamTLP.entity.Loai;
import com.se.VanPhongPhamTLP.entity.User;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 *
 * @author TUAN TU
 */
@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    private static final String UPLOAD_DIRECTOY="/resources/img";
    @Autowired
    // need to inject our sanpham service
    private SanPhamService sanPhamService;
    @Autowired
    private LoaiService loaiService;
    
    @PostMapping("/saveSanPham")
    public String saveSanPham(@ModelAttribute("sanpham") SanPham theSP, @RequestParam("photo") CommonsMultipartFile photo, HttpSession session) throws FileNotFoundException, IOException {
        
        if(theSP.getTenSP()==null||theSP.getSpNew()==null||theSP.getSpHot()==null){
            session.setAttribute("errSP", theSP);
            return "redirect:/sanpham/showFormForAdd";
        }
        ServletContext context= session.getServletContext();
        String path=context.getRealPath(UPLOAD_DIRECTOY);
        String filename= photo.getOriginalFilename();
        byte[] bytes = photo.getBytes();
        BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream(new File(path+File.separator+filename)));
                stream.write(bytes);
                stream.flush();
                stream.close();
        theSP.setImage("/resources/img/"+filename);
        sanPhamService.saveSanPham(theSP);
        session.removeAttribute("errSP");
        return "redirect:/sanpham/list";
    }
    
    @GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("maSP") int theId,
                    Model theModel) {
        // get the sanpham from our service
        SanPham theSP = sanPhamService.getSanPham(theId);
        List<Loai> loais= loaiService.getLoais();
        // set sanpham as a model attribute to pre-populate the form
        theModel.addAttribute("sanpham", theSP);
        theModel.addAttribute("loais", loais);
        // send over to our form		
        return "sanpham-form";    
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel,HttpSession session) {
        User user= (User) session.getAttribute("taikhoan");
        if(user != null && (user.getEmail()).contains("admin@gmail.com")){
        // create model attribute to bind form data
        SanPham theSP = new SanPham();
        List<Loai> loais= loaiService.getLoais();
        theModel.addAttribute("sanpham", theSP);
        theModel.addAttribute("loais", loais);
        return "sanpham-form";   
        }
        else{
            return "redirect:/user/dangnhap";
        }
    }  
    
    @GetMapping("/delete")
    public String deleteSanPham(@RequestParam("maSP") int theId) {

            // delete the sanpham
            sanPhamService.deleteSanPham(theId);

            return "redirect:/sanpham/list";
    }
    
        @GetMapping("/list")
    public String listSanPhams(Model theModel,HttpSession session) {
        User user= (User) session.getAttribute("taikhoan");
        if(user != null && (user.getEmail()).contains("admin@gmail.com")){
        // get sanphams from the service
        List<SanPham> theSanPhams = sanPhamService.getSanPhams();
        // add the customers to the model
        theModel.addAttribute("sanphams", theSanPhams);
        return "list-sanphams"; 
        }
        else{
            return "redirect:/user/dangnhap";
        }
    }
    
    @GetMapping("/search")
    public String searchSanPhams(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search sanphams from the service
        List<SanPham> sanPhams = sanPhamService.searchSanPhams(theSearchName);
                
        // add the sanphams to the model
        theModel.addAttribute("sanphams", sanPhams);
        return "list-sanphams";        
    }
    @GetMapping(value = "/sanphamsLoai")
	public String showSanPhamTheoLoai(@RequestParam("tenLoai") String loai,Model theModel) {
            // get sanphams from the service
            List<SanPham> theSanPhams = sanPhamService.getSanPhamsTheoLoai(loai);
            // add the customers to the model
            theModel.addAttribute("sanphams", theSanPhams);
		return "SanPhams";
	}
        
        @GetMapping("/timkiem")
    public String timKiemSanPhams(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search sanphams from the service
        List<SanPham> sanPhams = sanPhamService.searchSanPhams(theSearchName);
                
        // add the sanphams to the model
        theModel.addAttribute("sanphams", sanPhams);
        return "SanPhams";        
    }
}

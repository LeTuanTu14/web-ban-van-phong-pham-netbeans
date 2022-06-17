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
import com.se.VanPhongPhamTLP.service.LoaiService;
import com.se.VanPhongPhamTLP.entity.Loai;
import com.se.VanPhongPhamTLP.entity.User;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author TUAN TU
 */
@Controller
@RequestMapping("/loai")
public class LoaiController {
    
    // need to inject our loai service
    @Autowired
    private LoaiService loaiService;
    @PostMapping("/saveLoai")
    public String saveLoai(@ModelAttribute("loai") Loai loaiSP, HttpSession session) {
        // save the sanpham using our service
        if(loaiSP.getTenLoai()==null){
            session.setAttribute("errLoai", loaiSP);
            return "redirect:/loai/showFormForAdd";
        }
        loaiService.saveLoai(loaiSP);
        session.removeAttribute("errLoai");
        return "redirect:/loai/list";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id,
                    Model theModel) {
        // get the loai from our service
        Loai loaisp = loaiService.getLoai(id);	
        // set sanpham as a model attribute to pre-populate the form
        theModel.addAttribute("loai", loaisp);
        
        // send over to our form		
        return "loai-form";    
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddLoai(Model theModel,HttpSession session) {
        User user= (User) session.getAttribute("taikhoan");
        if(user != null && (user.getEmail()).contains("admin@gmail.com")){
        // create model attribute to bind form data
        Loai loaisp = new Loai();
        theModel.addAttribute("loai", loaisp);
        //theModel.addAttribute("update", false);
        return "loai-form";   
        }
        else{
            return "redirect:/user/dangnhap";
        }
    }  
    
    @GetMapping("/delete")
    public String deleteLoai(@RequestParam("loaiId") int theId) {

            // delete the sanpham
            loaiService.deleteLoai(theId);

            return "redirect:/loai/list";
    }
    
        @GetMapping("/list")
    public String listLoais(Model theModel,HttpSession session) {
        User user= (User) session.getAttribute("taikhoan");
        if(user != null && (user.getEmail()).contains("admin@gmail.com")){
        // get sanphams from the service
        List<Loai> theLoais = loaiService.getLoais();
        // add the customers to the model
        theModel.addAttribute("loais", theLoais);
        return "list-loais"; 
        }
        else{
            return "redirect:/user/dangnhap";
        }
    }
    
    @GetMapping("/search")
    public String searchLoais(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search loais from the service
        List<Loai> loais = loaiService.searchLoais(theSearchName);
                
        // add the loais to the model
        theModel.addAttribute("loais", loais);
        return "list-loais";        
    }
}

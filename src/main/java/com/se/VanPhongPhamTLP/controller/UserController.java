package com.se.VanPhongPhamTLP.controller;

import com.se.VanPhongPhamTLP.entity.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import com.se.VanPhongPhamTLP.entity.User;
import com.se.VanPhongPhamTLP.service.UserService;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
        @Autowired
        private UserService userService;
    
	@GetMapping("/dangky")
	public String dangKy(Model theModel) {
            User user= new User();
            theModel.addAttribute("user", user);
            return "dang-ky";
	}
	@PostMapping("/saveAcc")
	public String saveAcc(@ModelAttribute("user") User user) {
            userService.saveUser(user);
            return "redirect:/user/dangnhap";
	}
	
	@GetMapping("/dangnhap")
	public String dangNhap(Model theModel) {
            User user= new User();
            theModel.addAttribute("user", user);
            return "dang-nhap";
	}
        @PostMapping("/checkAcc")
        public String checkAcc(@ModelAttribute("user") User user, HttpSession session){
            List<User> us= userService.getUser(user.getEmail());
            for (User u : us) {
                if(BCrypt.checkpw(user.getPassWord(), u.getPassWord())){
                    session.removeAttribute("err");
		    session.setAttribute("taikhoan", u);
                    return "redirect:/home";
		}
            }
            if((user.getEmail()).contains("admin@gmail.com")){
                if((user.getPassWord()).contains("admin")){
                    session.removeAttribute("err");
                    session.setAttribute("taikhoan", user);
                    return "redirect:/quanly";
                }
            }
            session.setAttribute("err", user);
            return "redirect:/user/dangnhap";
        }
        @GetMapping("/dangxuat")
	public String dangXuat(HttpSession session) {
            session.removeAttribute("taikhoan");
            return "redirect:/home";
	}
        @GetMapping("/list")
	public String listTK(Model theModel,HttpSession session) {
        User user= (User) session.getAttribute("taikhoan");
        if(user != null && (user.getEmail()).contains("admin@gmail.com")){
            List<User> taiKhoans = userService.getUsers();
        // add the customers to the model
        theModel.addAttribute("taikhoans", taiKhoans);
        return "list-taikhoans"; 
        }
        else{
            return "redirect:/user/dangnhap";
        }
	}
        @GetMapping(value ="/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }
    
    @GetMapping("/search")
    public String searchUsers(@RequestParam("email") String email, Model theModel) {
        List<User> users = userService.getUser(email);
        theModel.addAttribute("taikhoans", users);
        return "list-taikhoans";        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.service;

import com.se.VanPhongPhamTLP.entity.User;
import java.util.List;

/**
 *
 * @author TUAN TU
 */
public interface UserService {
    public List<User> getUsers();
    public void saveUser(User user);
    public List<User> getUser(String email);
    public void deleteUser(int theId);
}

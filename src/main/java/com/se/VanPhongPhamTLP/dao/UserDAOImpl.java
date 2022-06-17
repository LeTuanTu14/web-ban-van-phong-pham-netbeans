/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dao;

import com.se.VanPhongPhamTLP.entity.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author TUAN TU
 */
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<User> getUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = 
            currentSession.createQuery("from User order by Email", User.class);
        // execute query and get result list
        List<User> users = theQuery.getResultList();
            return users;
    }

    @Override
    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        user.setPassWord(BCrypt.hashpw(user.getPassWord(), BCrypt.gensalt(12)));
        currentSession.saveOrUpdate(user);
    }

    @Override
    public List<User> getUser(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = 
            currentSession.createQuery("from User where Email=:email", User.class);
        theQuery.setParameter("email",email.toLowerCase());
        List<User> user = theQuery.getResultList();
        return user;
    }

    @Override
    public void deleteUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, theId);
        currentSession.delete(user);
    }

}

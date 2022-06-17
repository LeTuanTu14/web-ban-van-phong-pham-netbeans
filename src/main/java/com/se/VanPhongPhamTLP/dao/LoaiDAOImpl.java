/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dao;

import com.se.VanPhongPhamTLP.entity.Loai;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TUAN TU
 */
@Repository
public class LoaiDAOImpl implements LoaiDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<Loai> getLoais() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Loai> theQuery = 
            currentSession.createQuery("from Loai order by id", Loai.class);
        // execute query and get result list
        List<Loai> loais = theQuery.getResultList();
            return loais;
    }

    @Override
    public Loai getLoai(int Id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // now retrieve/read from database using the primary key
        Loai loai = currentSession.get(Loai.class, Id);
            return loai;
    }

    @Override
    public void saveLoai(Loai loai) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // save/update the loai ... finally
        currentSession.saveOrUpdate(loai);    }

    @Override
    public void deleteLoai(int Id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Loai tempLoai = currentSession.get(Loai.class, Id);
        currentSession.delete(tempLoai);    }

    @Override
    public List<Loai> searchLoais(String theSearchName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for tenLoai ... case insensitive
            theQuery =currentSession.createQuery("from Loai where lower(tenLoai)like :theName", Loai.class);
            theQuery.setParameter("theName", "%" + theSearchName+ "%");
        }
        else {
            // theSearchName is empty ... so just get all Loais
            theQuery =currentSession.createQuery("from Loai", Loai.class);            
        }
        
        // execute query and get result list
        List<Loai> loais = theQuery.getResultList();
                
        // return the results        
        return loais;
    }
    
}

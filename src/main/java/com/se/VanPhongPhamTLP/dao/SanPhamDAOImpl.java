/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dao;

import com.se.VanPhongPhamTLP.entity.SanPham;
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
public class SanPhamDAOImpl implements SanPhamDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<SanPham> getSanPhams() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<SanPham> theQuery = 
            currentSession.createQuery("from SanPham order by maSP", SanPham.class);
        // execute query and get result list
        List<SanPham> sanPhams = theQuery.getResultList();
            return sanPhams;
    }

    @Override
    public void saveSanPham(SanPham theSP) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // save/update the sanpham ... finally
        currentSession.saveOrUpdate(theSP);
    }

    @Override
    public SanPham getSanPham(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // now retrieve/read from database using the primary key
        SanPham sanPham = currentSession.get(SanPham.class, theId);
            return sanPham;
    }

    @Override
    public void deleteSanPham(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        SanPham tempSanPham = currentSession.get(SanPham.class, theId);
        currentSession.delete(tempSanPham);
    }

    @Override
    public List<SanPham> searchSanPhams(String theSearchName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for tenSP ... case insensitive
            theQuery =currentSession.createQuery("from SanPham where lower(tenSP) like :theName or lower(loai) like :theName", SanPham.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all sanPhams
            theQuery =currentSession.createQuery("from SanPham", SanPham.class);            
        }
        
        // execute query and get result list
        List<SanPham> sanPhams = theQuery.getResultList();
                
        // return the results        
        return sanPhams;
    }
    
    @Transactional
    @Override
    public List<SanPham> getSanPhamsTheoLoai(String loai) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<SanPham> theQuery = 
            currentSession.createQuery("from SanPham where lower(loai) like :theName", SanPham.class);
            theQuery.setParameter("theName", "%" + loai.toLowerCase() + "%");
        // execute query and get result list
        List<SanPham> sanPhams = theQuery.getResultList();
            return sanPhams;
    }
    @Transactional
    @Override
    public List<SanPham> getSanPhamsMoi() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<SanPham> theQuery = 
            currentSession.createQuery("from SanPham where lower(spNew) like :theName", SanPham.class);
            theQuery.setParameter("theName","true");
        // execute query and get result list
        List<SanPham> sanPhams = theQuery.getResultList();
            return sanPhams;
    }

    @Override
    public List<SanPham> getSanPhamsHot() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<SanPham> theQuery = 
            currentSession.createQuery("from SanPham where lower(spHot) like :theName", SanPham.class);
            theQuery.setParameter("theName","true");
        // execute query and get result list
        List<SanPham> sanPhams = theQuery.getResultList();
            return sanPhams;
    }
    
}

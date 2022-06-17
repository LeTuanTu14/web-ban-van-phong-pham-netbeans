/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.VanPhongPhamTLP.dao;

import com.se.VanPhongPhamTLP.entity.ChiTietDonDatHang;
import com.se.VanPhongPhamTLP.entity.DonDatHang;
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
public class DonDatHangDAOImpl implements DonDatHangDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<DonDatHang> getDonDatHangs() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<DonDatHang> theQuery = 
            currentSession.createQuery("from DonDatHang order by id", DonDatHang.class);
        List<DonDatHang> donDHs = theQuery.getResultList();
            return donDHs;
    }
    
    @Override
    public void addDonDatHang(DonDatHang don) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(don);
    }

    @Override
    public void addChiTietDonDatHang(ChiTietDonDatHang chiTietDDH) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(chiTietDDH);
    }

    @Override
    public void deleteDonDatHang(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        DonDatHang donDH = currentSession.get(DonDatHang.class, theId);
        currentSession.delete(donDH);
    }

    @Override
    public DonDatHang getDonDatHang(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        DonDatHang ddh = currentSession.get(DonDatHang.class, theId);
            return ddh;
    }

    @Override
    public List<DonDatHang> searchDonDatHangs(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for tenSP ... case insensitive
            theQuery =currentSession.createQuery("from DonDatHang where lower(userEmail) like :theName or lower(hoTen) like :theName", DonDatHang.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all sanPhams
            theQuery =currentSession.createQuery("from SanPham", DonDatHang.class);            
        }
        
        // execute query and get result list
        List<DonDatHang> ddhs = theQuery.getResultList();
                
        // return the results        
        return ddhs;
    }
    
    @Transactional
    @Override
    public List<ChiTietDonDatHang> getChiTietDonDatHangs(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<ChiTietDonDatHang> theQuery = 
            currentSession.createQuery("from ChiTietDonDatHang where idDonDH=:id", ChiTietDonDatHang.class);
        theQuery.setParameter("id",id);
        List<ChiTietDonDatHang> chiTDDHs = theQuery.getResultList();
            return chiTDDHs;
    }
    @Transactional
    @Override
    public void deleteChiTietDonDatHang(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        ChiTietDonDatHang chiTDDH = currentSession.get(ChiTietDonDatHang.class, theId);
        currentSession.delete(chiTDDH);
    }
    
}

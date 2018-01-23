package com.as.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.as.model.District;

@Repository
@Transactional
public class DistrictDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	    private Session getSession() {
	        return sessionFactory.getCurrentSession();
	    }
	 
	    public String savePerson(District dist) {
	        Long isSuccess = (Long)getSession().save(dist);
	        if(isSuccess >= 1){
	            return "Success";
	        }else{
	            return "Error while Saving Person";
	        }
	         
	    }
	 
	    public boolean delete(District dist) {
	        getSession().delete(dist);
	        return true;
	    }
	 
	    @SuppressWarnings("unchecked")
	    public List<District> getAllDistrict() {
	        return getSession().createQuery("from District").list();
	    }
}

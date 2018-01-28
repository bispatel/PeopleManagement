package com.as.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.as.model.District;

@Repository
@Transactional
public class DistrictDaoImpl    {
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
	 
	   
	    @SuppressWarnings("unchecked")
	    public List<District> getAllDistrict() {
	        return getSession().createQuery("from District").list();
	    }
	    
	    public District getDistrict(int distId) {
	    	District query = (District) getSession().get(District.class, distId);
	    	return query;
	    }
	    
	    public void updateDistrict(District dist){
	    	getSession().saveOrUpdate(dist);
	    }
	    
	    public void deleteDistrict(int distId){
	    	getSession().delete(distId);	   
	    	}

	 
	
}

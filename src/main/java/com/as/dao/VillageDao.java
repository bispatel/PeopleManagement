package com.as.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.as.model.Block;
import com.as.model.Village;

@Repository
@Transactional
public class VillageDao {
	@Autowired
	private SessionFactory sessionFactory1;

	private Session getSession() {
		return sessionFactory1.getCurrentSession();
	}

	public String saveVillage(Village village) {
		Integer isSuccess = (Integer) getSession().save(village);
		if (isSuccess >= 1) {
			return "Success";
		} else {
			return "Error while Saving village";
		}
	}

	@SuppressWarnings("unchecked")
	public List<Village> getAllVillage() {
		//return getSession().createQuery("from Village").list();
		
		   Criteria c = getSession().createCriteria(Village.class)
	                .createCriteria("block", Criteria.LEFT_JOIN)
	                .createCriteria("district", Criteria.LEFT_JOIN);
	            return c.list();
		
		
	}

	public Village getVillage(int villageId) {
		 Criteria c = getSession().createCriteria(Village.class)				 
					.add(Restrictions.eq("villageId",villageId))
					   .createCriteria("block", Criteria.LEFT_JOIN)
					.createCriteria("district", Criteria.LEFT_JOIN);
		  Village village = (Village) c.uniqueResult();				  
		return village;
	
	}

	public void saveOrUpdate(Village village) {
		getSession().saveOrUpdate(village);
	}

	public void deleteVillage(Village village) {
		getSession().delete(village);
	}

}

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

@Repository
@Transactional
public class BlockDao {
	@Autowired
	private SessionFactory sessionFactory1;

	private Session getSession() {
		return sessionFactory1.getCurrentSession();
	}

	public String saveBlock(Block block) {
		Integer isSuccess = (Integer) getSession().save(block);
		if (isSuccess >= 1) {
			return "Success";
		} else {
			return "Error while Saving block";
		}
	}

	@SuppressWarnings("unchecked")
	public List<Block> getAllBlock() {		
		   Criteria c = getSession().createCriteria(Block.class)
	                .createCriteria("district", Criteria.LEFT_JOIN);
	            return c.list();
		
		
	}

	public Block getBlock(int blockId) {
		  Criteria c = getSession().createCriteria(Block.class)				 
					.add(Restrictions.eq("blockId",blockId))
					.createCriteria("district", Criteria.LEFT_JOIN);
		  Block block = (Block) c.uniqueResult();				  
		return block;
	}

	public void saveOrUpdate(Block block) {
		getSession().saveOrUpdate(block);
	}

	public void deleteBlock(Block block) {
		getSession().delete(block);
	}

}

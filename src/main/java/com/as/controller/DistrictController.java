package com.as.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.as.dao.DistrictDao;
import com.as.model.District;

@Controller
public class DistrictController {
	@Autowired
	private DistrictDao districtDao;

	@RequestMapping("/districts")
	public String index(Model model) {
		List<District> districtList = districtDao.getAllDistrict();
		//Using sort method in List.
		districtList.sort((d1,d2)->d1.getDistrictName().compareToIgnoreCase(d2.getDistrictName()));	
		model.addAttribute("districtList", districtList);
		return "/districts/viewDistricts";
	}

	  @RequestMapping(value = "/distEdit/{id}")
	    public String editDistrict(@PathVariable("id") Integer distId, Model model){
	    	model.addAttribute("district", districtDao.getDistrict(distId));
	        return "/districts/editDistrict";
	    }	    
	    
	    @RequestMapping(value = "distUpdate", method = RequestMethod.POST)
	    public String save(District dist){
	    	dist.setLastModDate(new Timestamp(new Date().getTime()));
	    	dist.setLastModBy("SYSTEM");
	    	districtDao.updateDistrict(dist);
	    	return "redirect:/districts";
	    }
	    
	    @RequestMapping(value = "/distDelete/{id}", method = RequestMethod.GET)
	    public String deleteDistrict(@PathVariable("id") Integer distId, Model model) {
	    	District dist = new District();
	    	dist.setDistrictId(distId);
	    	districtDao.deleteDistrict(dist);
	        return "redirect:/districts";
	    } 
}

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

import com.as.dao.VillageDao;
import com.as.model.Village;

@Controller
public class VillageController {
	@Autowired
	private VillageDao villageDao;

	@RequestMapping("/villages")
	public String index(Model model) {
		List<Village> villageList = villageDao.getAllVillage();
		//Using sort method in List.
		villageList.sort((d1,d2)->d1.getVillageName().compareToIgnoreCase(d2.getVillageName()));	
		model.addAttribute("villageList", villageList);
		return "/villages/viewVillages";
	}

	 @RequestMapping(value = "/villageAdd")
	    public String addVillage(Model model){
	    	model.addAttribute("village", new Village());
	        return "/villages/addEditVillage";
	    }	

	  @RequestMapping(value = "/villageEdit/{id}")
	    public String editVillage(@PathVariable("id") Integer villageId, Model model){
	    	model.addAttribute("village", villageDao.getVillage(villageId));
	        return "/villages/addEditVillage";
	    }	    
	    
	    @RequestMapping(value = "villageUpdate", method = RequestMethod.POST)
	    public String save(Village village){
	    	village.setStatus("A");
	    	village.setLastModDate(new Timestamp(new Date().getTime()));
	    	village.setLastModBy("SYSTEM");
	    	villageDao.saveOrUpdate(village);
	    	return "redirect:/villages";
	    }
	    
	    @RequestMapping(value = "/villageDelete/{id}", method = RequestMethod.GET)
	    public String deleteVillage(@PathVariable("id") Integer villageId, Model model) {
	    	Village village = new Village();
	    	village.setVillageId(villageId);
	    	villageDao.deleteVillage(village);
	        return "redirect:/villages";
	    } 
}

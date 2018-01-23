package com.as.controller.district;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.as.dao.DistrictDao;
import com.as.model.District;

@Controller
public class DistrictController {
	@Autowired
	private DistrictDao districtDao;

	@RequestMapping("/districts")
	public String index(Model model) {
		// List<District> districtList = Arrays.asList(new District(1, "D1", "DName", 5,
		// 15, 25, "S1","SYSTEM"));

		List<District> districtList = districtDao.getAllDistrict();
		model.addAttribute("districtList", districtList);
		return "/districts/viewDistricts";
	}

}

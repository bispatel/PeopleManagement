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

import com.as.dao.UserDao;
import com.as.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/users")
	public String index(Model model) {
		List<User> userList = userDao.getAllUser();
		//Using sort method in List.
		userList.sort((d1,d2)->d1.getUserName().compareToIgnoreCase(d2.getUserName()));	
		model.addAttribute("userList", userList);
		return "/users/viewUsers";
	}

	 @RequestMapping(value = "/userAdd")
	    public String addUser(Model model){
	    	model.addAttribute("user", new User());
	        return "/users/addUser";
	    }	

	  @RequestMapping(value = "/userEdit/{id}")
	    public String editUser(@PathVariable("id") String userId, Model model){
	    	model.addAttribute("user", userDao.getUser(userId));
	        return "/users/editUser";
	    }	    
	    
	    @RequestMapping(value = "userUpdate", method = RequestMethod.POST)
	    public String save(User user){
	    	user.setStatus("A");
	    	user.setLastModDate(new Timestamp(new Date().getTime()));
	    	user.setLastModBy("SYSTEM");
	    	userDao.saveUser(user);
	    	return "redirect:/users";
	    }
	    
	    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.GET)
	    public String deleteUser(@PathVariable("id") String userId, Model model) {
	    	User user = new User();
	    	user.setUserId(userId);
	    	userDao.deleteUser(user);
	        return "redirect:/users";
	    } 
}

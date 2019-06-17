package com.mobi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mobi.model.User;
import com.mobi.service.UserService;
import com.mobi.util.PasswordUtils;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request ;
	
	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(
			@RequestParam String uname,
			@RequestParam String pswd) {
		List<User> users = userService.getAll();
		
		for(int i=0; i< users.size();i++) {
			
			if(uname.equalsIgnoreCase(users.get(i).getUsername())) {
			boolean passwordMatch = PasswordUtils.verifyUserPassword(pswd, users.get(i).getPassword(), users.get(i).getSalt());
	        if(passwordMatch) 
	        {
	        	System.out.println(users.get(i).getUserid());
	        	request.getSession().setAttribute("userid", users.get(i).getUserid());
	            System.out.println("Provided user password " + pswd + " is correct.");
	        }
			}
		}
		System.out.println("Provided username or password is incorrect");
		
		return "true";
		
	}

}

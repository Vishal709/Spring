package com.SpringSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringSecurity.Model.User;
import com.SpringSecurity.Service.UserDetailsServiceImpl;
import com.SpringSecurity.Service.UserService;

@Controller
public class UserController {
@Autowired
UserService userService;

	/*
	 * @RequestMapping("/")
	 * 
	 * @ResponseBody public String Home() {
	 * 
	 * }
	 */
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@RequestParam String username, @RequestParam String pass, Model model) {
		User user=userService.addUser(username, pass);
		if(user != null) {
		
		model.addAttribute("addSuccess", "User Added Successfully");
		return "addUser";
		}
		else {
			model.addAttribute("error", "something is always wrong Daya... ");
			return "addUser";
		}
		
	}
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public String addUser() {
		
		return "addUser";
	
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcomePage() {
		return "welcome";
	}
	@RequestMapping(value="/errorPage",method=RequestMethod.GET)
	public String errorPage() {
		return "errorFile";
	}
	
	 @RequestMapping(value="/login", method = RequestMethod.GET)
	    public String showLoginPage(){
	    	 return "login";
	    }

	
}

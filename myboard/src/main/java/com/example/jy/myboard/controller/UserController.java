package com.example.jy.myboard.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jy.myboard.dto.UserDto;
import com.example.jy.myboard.service.UserServiceImpl;


@Controller
public class UserController {
	
	final static Logger logger=LoggerFactory.getLogger(UserController.class); 
	
	@Autowired
	UserServiceImpl service;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping(path="register")
	public void getRegister() throws Exception{
		
	}

	@PostMapping(path="register")
	public String postRegister(UserDto user) throws Exception{
		try {
			String inputPass=user.getUserPass();
			String encodingPass=encoder.encode(inputPass);
			user.setUserPass(encodingPass);
			service.createUser(user);
			return "main";
		}catch(Exception e) {
			
			return null;
		}
	}
	
	@PostMapping(path="login")
	public String login(UserDto user,HttpServletRequest req,RedirectAttributes redi) throws Exception{
		HttpSession session = req.getSession();
		UserDto login = service.login(user);
		boolean match=false;
		if(login!=null) {match=encoder.matches(user.getUserPass(), login.getUserPass());}
		if(login!=null && match) {
			session.setAttribute("user", login);
		}else {
			session.setAttribute("user", login);
			session.setAttribute("user", null);
			redi.addFlashAttribute("msg",false);
		}
		
		return "redirect:/";
	}
	
	@GetMapping(path="logout")
	public String logout(HttpSession sesstion) throws Exception{
		sesstion.invalidate();
		return "redirect:/";
	}
	
	@GetMapping(path="updateUserView")
	public String updateUserView() throws Exception{
		return "updateUserView";
	}
	
	@PostMapping(path="updateUser")
	public String updateUser(UserDto user,HttpSession session) throws Exception{
		
		service.updateUser(user);
		session.invalidate();
		return "redirect:/";
	
	}
	
	@ResponseBody
	@PostMapping(path="checkPass")
	public boolean checkPass(UserDto user) throws Exception{
		UserDto login = service.login(user);
		String encodingPass = login.getUserPass();
		boolean check = encoder.matches(user.getUserPass(), encodingPass);
		return check;
	}
	
	@GetMapping(path="deleteUserView")
	public String deleteUserView() throws Exception{
		return "deleteUserView";
	}
	
	@PostMapping(path="deleteUser")
	public String deleteUser(UserDto user,HttpSession session) throws Exception{
		service.deleteUser(user);
		session.invalidate();
		return "redirect:/";
	}
	
	@ResponseBody
	@PostMapping(path="checkId")
	public int checkId(UserDto user) throws Exception{
		return service.checkId(user);
	}
}


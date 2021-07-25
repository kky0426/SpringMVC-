package com.example.jy.myboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jy.myboard.dto.UserDto;
import com.example.jy.myboard.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl service;
	
	@GetMapping(path="register")
	public void getRegister() throws Exception{
		
	}

	@PostMapping(path="register")
	public String postRegister(UserDto user) throws Exception{
		service.createUser(user);
		return null;
	}
	
	@PostMapping(path="login")
	public String login(UserDto user,HttpServletRequest req,RedirectAttributes redi) throws Exception{
		HttpSession session = req.getSession();
		UserDto login = service.login(user);
		
		if(login==null) {
			session.setAttribute("user", null);
			redi.addAttribute("msg",false);		
		}else {
			session.setAttribute("user", login);
		}
		
		return "redirect:/";
	}
	
	@GetMapping(path="logout")
	public String logout(HttpSession sesstion) throws Exception{
		sesstion.invalidate();
		return "redirect:/";
	}
}


package com.example.jy.myboard.controller;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jy.myboard.dao.BoardDao;
import com.example.jy.myboard.service.BoardServiceImpl;


@Controller
public class BoardController {
	
	@Autowired
	BoardServiceImpl service;
	
	@Autowired
	BoardDao dao;
	
	@GetMapping(path="/writeview")
	public String writeForm() {
		return "writeview";
	}
	
	@PostMapping(path="/write")
	public String write(@RequestParam(name="title",required=true)String title,
			@RequestParam(name="writer_name")String writerName,
			@RequestParam(name="content")String content,ModelMap modelMap) {
			try {
				service.write(title,writerName,content);
			}catch(Exception e){
				System.out.println(e);
			}
		return "redirect:/";
	}
	
	@GetMapping(path="/list")
	public String list(Model model){
		model.addAttribute("list",service.boardList());
		return "listview";
	}
	
	
}

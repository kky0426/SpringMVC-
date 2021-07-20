package com.example.jy.myboard.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jy.myboard.dao.BoardDao;
import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.PageDto;
import com.example.jy.myboard.dto.PageMaker;
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
	public String list(Model model,PageDto page) throws Exception{
		model.addAttribute("list",service.boardList(page));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(page);
		pageMaker.setTotalCount(service.count());
		model.addAttribute("pageMaker",pageMaker);
		return "listview";
	}
	
	
	@GetMapping(path="/readview")
	public String read(@RequestParam("boardId")int boardId,Model model) throws Exception{
		model.addAttribute("read",service.read(boardId));
		return "readview";
	}
	
	@PostMapping(path="/update")
	public String update(BoardDto board) throws Exception {	
		service.update(board);
		return "redirect:/list";
	}
	
	@GetMapping(path="/updateview")
	public String updateView(BoardDto board,Model model) {
		model.addAttribute("update",board);
		return "updateview";
	}

	@PostMapping(path="/delete")
	public String delete(BoardDto board) throws Exception{
		service.delete(board.getBoardId());
		return "redirect:/list";
	}
	
}

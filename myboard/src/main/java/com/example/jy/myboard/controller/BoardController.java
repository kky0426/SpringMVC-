package com.example.jy.myboard.controller;




import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jy.myboard.dao.BoardDao;
import com.example.jy.myboard.dto.BoardDto;

import com.example.jy.myboard.dto.PageMaker;
import com.example.jy.myboard.dto.ReplyDto;
import com.example.jy.myboard.dto.SearchPageDto;
import com.example.jy.myboard.service.BoardServiceImpl;
import com.example.jy.myboard.service.ReplyServiceImpl;


@Controller
public class BoardController {
	
	@Autowired
	BoardServiceImpl service;
	
	@Autowired
	ReplyServiceImpl replyService;
	
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
		return "redirect:/list";
	}
	
	@GetMapping(path="/list")
	public String list(Model model,@ModelAttribute("searchPage")SearchPageDto page) throws Exception{
		model.addAttribute("list",service.boardList(page));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(page);
		pageMaker.setTotalCount(service.count(page));
		model.addAttribute("pageMaker",pageMaker);
		return "listview";
	}
	
	
	@GetMapping(path="/readview")
	public String read(BoardDto board,@ModelAttribute("searchPage")SearchPageDto page,Model model) throws Exception{
		model.addAttribute("read",service.read(board.getBoardId()));
		model.addAttribute("searchPage",page);
		model.addAttribute("reply",replyService.getReplyList(board));
		return "readview";
	}
	
	@PostMapping(path="/update")
	public String update(BoardDto board,@ModelAttribute("searchPage")SearchPageDto page,RedirectAttributes redi) throws Exception {	
		service.update(board);
		redi.addAttribute("page",page.getPage());
		redi.addAttribute("offset",page.getOffset());
		redi.addAttribute("feild",page.getFeild());
		redi.addAttribute("keyword",page.getKeyword());
		return "redirect:/list";
	}
	
	@GetMapping(path="/updateview")
	public String updateView(BoardDto board,Model model,@ModelAttribute("searchPage")SearchPageDto page) {
		model.addAttribute("update",board);
		model.addAttribute("searchPage",page);
		return "updateview";
	}

	@PostMapping(path="/delete")
	public String delete(BoardDto board,@ModelAttribute("searchPage")SearchPageDto page,RedirectAttributes redi) throws Exception{
		service.delete(board.getBoardId());
		redi.addAttribute("page",page.getPage());
		redi.addAttribute("offset",page.getOffset());
		redi.addAttribute("feild",page.getFeild());
		redi.addAttribute("keyword",page.getKeyword());
		return "redirect:/list";
	}
	
	@PostMapping(path="/replywrite")
	public String writeReply(ReplyDto reply,SearchPageDto page,RedirectAttributes redi) throws Exception{
		replyService.addReply(reply);
		redi.addAttribute("boardId",reply.getBoardId());
		redi.addAttribute("page",page.getPage());
		redi.addAttribute("offset",page.getOffset());
		redi.addAttribute("feild",page.getFeild());
		redi.addAttribute("keyword",page.getKeyword());
		return "redirect:readview";
	}
	
}

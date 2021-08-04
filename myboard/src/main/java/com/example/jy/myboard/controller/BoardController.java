package com.example.jy.myboard.controller;




import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jy.myboard.dao.BoardDao;
import com.example.jy.myboard.dto.BoardDto;

import com.example.jy.myboard.dto.PageMaker;
import com.example.jy.myboard.dto.ReplyDto;
import com.example.jy.myboard.dto.SearchPageDto;
import com.example.jy.myboard.service.BoardService;
import com.example.jy.myboard.service.BoardServiceImpl;
import com.example.jy.myboard.service.ReplyService;
import com.example.jy.myboard.service.ReplyServiceImpl;


@Controller
public class BoardController {
	
	
	final static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	ReplyService replyService;
	
	@Autowired
	BoardService service;
	
	
	@GetMapping(path="/writeview")
	public String writeForm() {
		return "writeview";
	}
	
	@GetMapping(path="main")
	public String home(){
		return "main";
	}

	
	@PostMapping(path="/write")
	public String write(BoardDto board,MultipartHttpServletRequest request) throws Exception {
		logger.info("write");
		service.write(board,request);
		return "redirect:/list";
	}
	
	@GetMapping(path="/list")
	public String list(Model model,@ModelAttribute("searchPage")SearchPageDto page) throws Exception{
		logger.info("list");
		logger.info("page rowS={}", page.getRowS());
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
		model.addAttribute("file",service.getFileList(board.getBoardId()));
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
	
	@PostMapping(path="updateReply")
	public String updateReply(ReplyDto reply,SearchPageDto page,RedirectAttributes redi) throws Exception{
		replyService.update(reply);
		redi.addAttribute("boardId",reply.getBoardId());
		redi.addAttribute("page",page.getPage());
		redi.addAttribute("offset",page.getOffset());
		redi.addAttribute("feild",page.getFeild());
		redi.addAttribute("keyword",page.getKeyword());
		
		return "redirect:readview";
	}
	
	@GetMapping(path="updateReplyView")
	public String updateReplyView(ReplyDto reply,SearchPageDto page, Model model) throws Exception{
		model.addAttribute("searchPage",page);
		model.addAttribute("reply",replyService.getReply(reply.getReplyId()));
		return "updateReplyView";
	}
	
	
	
	@PostMapping(path="deleteReply")
	public String deleteReply(ReplyDto reply,SearchPageDto page,RedirectAttributes redi) throws Exception{
		replyService.delete(reply);
		redi.addAttribute("boardId", reply.getBoardId());
		redi.addAttribute("page", page.getPage());
		redi.addAttribute("offset", page.getOffset());
		redi.addAttribute("feild", page.getFeild());
		redi.addAttribute("keyword", page.getKeyword());
		return "redirect:readview";
	}	
	
	@GetMapping(path="deleteReplyView")
	public String deleteReplyView(ReplyDto reply,SearchPageDto page,Model model) throws Exception{
		model.addAttribute("reply",replyService.getReply(reply.getReplyId()));
		model.addAttribute("searchPage", page);
		
		return "deleteReplyView";	
	}
	
	@RequestMapping(path="fileDown")
	public void fileDown(@RequestParam Map<String,Object> map, HttpServletResponse response) throws Exception{
		Map<String,Object> resultMap = service.getFileInfo(map);
		String storedFileName = (String) resultMap.get("storedFileName");
		String orgFileName = (String) resultMap.get("orgFileName");
		
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\myboard\\file\\"+storedFileName));
		
		response.setContentLength(fileByte.length);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment; fileName=\""+URLEncoder.encode(orgFileName,"UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}

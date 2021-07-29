package com.example.jy.myboard.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.jy.myboard.dto.BoardDto;

@Component("fileUtils")
public class FileUtils {
	private static final String filePath = "C:\\myboard\\file\\";
	
	public List<Map<String,Object>> parseInsertFileInfo(BoardDto board,
			MultipartHttpServletRequest request) throws Exception{
		
		Iterator<String> iterator = request.getFileNames();
		
		MultipartFile multipartFile = null;
		String orgFileName = null;
		String storedFileName = null;
		String orgFileExtension = null;
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> listMap = null;
		int boardId = board.getBoardId();
		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = request.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				orgFileName = multipartFile.getOriginalFilename();
				orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
				storedFileName = getRandomString() + orgFileExtension;
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("boardId",boardId);
				listMap.put("orgFileName",orgFileName);
				listMap.put("storedFileName",storedFileName);
				listMap.put("fileSize",multipartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}
}

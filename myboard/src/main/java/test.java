import org.springframework.beans.factory.annotation.Autowired;

import com.example.jy.myboard.dao.BoardDao;
import com.example.jy.myboard.dto.BoardDto;

public class test {
	
	@Autowired
	BoardDao dao;
	
	public void main(String[] args) throws Exception {
		BoardDto board = new BoardDto();
		board = dao.getBoardById(1);
		System.out.println(board);	
	}
}

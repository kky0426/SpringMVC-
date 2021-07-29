import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartResolver;

import com.example.jy.myboard.config.root.ApplicationConfig;
import com.example.jy.myboard.controller.UserController;
import com.example.jy.myboard.dao.BoardDaoImpl;
import com.example.jy.myboard.dao.ReplyDaoImpl;
import com.example.jy.myboard.dao.UserDaoImpl;
import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.ReplyDto;
import com.example.jy.myboard.dto.SearchPageDto;
import com.example.jy.myboard.dto.UserDto;
import com.example.jy.myboard.service.UserServiceImpl;


@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BeanTest {
	
	
	@Autowired
	BoardDaoImpl dao;
	
	@Test
	public void beanTest() {
		BoardDto board = new BoardDto();
		board.setContent("123");
		board.setTitle("asdf");
		board.setWriterName("123123");
		dao.insertBoard(board);
		//assertNotNull(board.getBoardId());
		assertEquals(130, board.getBoardId());
	}

	
}

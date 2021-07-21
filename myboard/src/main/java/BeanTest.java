import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.jy.myboard.config.root.ApplicationConfig;
import com.example.jy.myboard.dao.BoardDaoImpl;

import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.SearchPageDto;


@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BeanTest {
	
	
	@Autowired
	BoardDaoImpl dao;
	
	@Test
	public void beanTest() {
		BoardDto board = dao.getBoardById(128);
		assertEquals(128,board.getBoardId());
	}

	
}

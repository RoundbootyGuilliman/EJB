package app.service.impl;

import app.dao.impl.NewsDAOImpl;
import app.entity.News;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class NewsServiceImplTest {
	
	@Mock
	NewsDAOImpl dao;
	
	@InjectMocks
	NewsServiceImpl testedClass;
	
	News news;
	
	@Before
	public void initTest() {
		news = new News();
		news.setAuthor("MOCK");
		news.setBrief("MOCK");
		news.setContent("MOCK");
		news.setDate(new Date());
		news.setTitle("MOCK");
		
		when(dao.getNewsById(anyInt())).thenReturn(news);
	}
	
	@Test
	public void testGetNewsById() {
		
		News result = testedClass.getNewsById(1);
		
		assertEquals(news, result);
	}
}
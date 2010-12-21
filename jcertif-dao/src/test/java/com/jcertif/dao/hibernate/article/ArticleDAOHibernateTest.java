package com.jcertif.dao.hibernate.article;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.article.Article;
import com.jcertif.dao.ArticleDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

import static org.junit.Assert.*;

/**
 * DAO Test for Article.
 * 
 * @author rossi.oddet
 * 
 */
@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class ArticleDAOHibernateTest extends AbstractDAOTestCase  {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Test
	public void testFindAll(){
		List<Article> articleList = articleDAO.findAll();
		assertEquals(1, articleList.size());
		Article article = articleList.iterator().next();
		assertEquals("My title", article.getTitle());
	}

}

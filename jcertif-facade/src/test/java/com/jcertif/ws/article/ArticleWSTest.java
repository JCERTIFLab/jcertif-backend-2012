package com.jcertif.ws.article;

import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.article.Article;
import com.jcertif.bo.article.Articles;
import com.jcertif.service.article.ArticleService;
import com.jcertif.service.article.ArticleServiceImpl;


public class ArticleWSTest {
	//articleService is used is ArticleWS, but here it's a unit test, so we should not use the DB so lets mock it
	@Mock
	private ArticleServiceImpl articleService;
	
	private ArticleWS articleWebService;
	
	@Before
    public void setUp() {
		//Let mockito create nice objet for us
        MockitoAnnotations.initMocks(this);
        articleWebService = new ArticleWS();
        articleWebService.setArticleService(articleService);
	}
	
	@Test
	public void testAddArticle()
	{
		//say the behaviour of articleService when his method save is called
		Mockito.doNothing().when(articleService).save(any(Article.class));
		Article article = articleWebService.addArticle("My Article");
		Assert.assertNotNull(article);
		Assert.assertEquals(article.getTitle(), "My Article");
	}
	
	@Test
	public void testGetAllArticles()
	{
		List<Article> articleList = new ArrayList<Article>();
		Article anArticle = new Article();
		anArticle.setTitle("Article 1");
		Article anOtherArticle = new Article();
		anOtherArticle.setTitle("Article 2");
		articleList.add(anArticle);
		articleList.add(anOtherArticle);
		Mockito.when(articleService.findAll()).thenReturn(articleList);
		Articles returnedList = articleWebService.findAllArticles();
		Assert.assertNotNull(returnedList);
		Assert.assertEquals(returnedList.getArticles().size(), 2);
		Assert.assertEquals(returnedList.getArticles(), articleList);
	}

}

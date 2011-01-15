package com.jcertif.ws.article;

import java.util.ResourceBundle;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.Test;

import com.jcertif.bo.article.Article;
import com.jcertif.bo.article.Articles;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;




public class ArticleWSIntegrationTest {

	/**
	 * Facade URL property.
	 */
	private static final String FACADE_URL_PROP = "facade.url";

	/**
	 * WEBAPP properties file name.
	 */
	private static final String WEBAPP_PROPERTIES_FILE = "jcertif-facade";
	
	
	@Test
	public void testGetAllArticles()
	{
		//say the behaviour of articleService when his method save is called
		Article article = getWebResource().path("api").path("article").path("addarticle").path("My Article")
		.accept(MediaType.APPLICATION_JSON).get(Article.class);
		Articles articles = getWebResource().path("api").path("article").path("allarticles")
		.accept(MediaType.APPLICATION_JSON).get(Articles.class);
		boolean isIn = false;
		for (Article articleIn : articles.getArticles())
		{
			if (articleIn.getTitle().equals(article.getTitle()))
			{
				isIn = true;
			}
		}
		Assert.assertTrue(isIn);
	}
	
	@Test
	public void testAddArticle()
	{
		Article article = getWebResource().path("api").path("article").path("addarticle").path("My Article")
		.accept(MediaType.APPLICATION_JSON).get(Article.class);
		Assert.assertEquals(article.getTitle(), "My Article");
	}
	
	/**
	 * @return a web resource jersey.
	 */
	private WebResource getWebResource() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		return client.resource(getBaseURI());
	}

	/**
	 * @return the base URI
	 */
	private String getBaseURI() {
		ResourceBundle bundle = ResourceBundle
				.getBundle(WEBAPP_PROPERTIES_FILE);
		return bundle.getString(FACADE_URL_PROP);
	}


}


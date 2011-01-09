package com.jcertif.ws.article;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jcertif.bo.article.Article;
import com.jcertif.services.article.ArticleService;
import com.sun.jersey.spi.inject.Inject;

/**
 * Web service Article.
 * 
 * @author rossi.oddet
 * 
 */
@Path("article")
@Service
public class ArticleWS {

	/**
	 * The Logger.
	 */
	private Logger LOGGER = LoggerFactory.getLogger(ArticleWS.class);

	/**
	 * Article service.
	 */
	@Inject
	private ArticleService articleService;

	/**
	 * @return all the titles in String with
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("allarticles")
	public List<Article> findAllArticles() {
		LOGGER.debug("Calling Web Service /api/article/allarticles");
		final List<Article> articleList = articleService.findAll();
		return articleList;
	}

	/**
	 * @param title
	 *            a title
	 * @return the success string
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("addarticle/{title}/")
	public Article addArticle(@PathParam("title") String title) {
		LOGGER.debug("Calling Web Service /api/article/addarticle/{title}/",
				title);
		Article article = new Article();
		article.setTitle(title);
		articleService.save(article);
		return article;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}

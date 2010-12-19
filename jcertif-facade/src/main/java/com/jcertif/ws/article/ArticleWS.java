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
@Path("ArticleWS")
@Service
public class ArticleWS {
	
	/**
	 * The Logger.
	 */
	private Logger LOGGER = LoggerFactory.getLogger(ArticleWS.class);

	/**
	 * Success String result for addtitle service.
	 */
	private static final String ADD_TITLE_SUCCESS_STRING = "OK";

	/**
	 * A title string separator.
	 */
	private static final String TITLE_SEPARATOR = ";";

	/**
	 * Article service.
	 */
	@Inject
	private ArticleService articleService;

	/**
	 * @return all the titles in String with
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("AllTitles")
	public String findAllTitle() {
		LOGGER.debug("Calling Web Service ArticleWS.findAllTitle()");
		final List<Article> articleList = articleService.findAll();
		final StringBuilder sb = new StringBuilder();
		for (Article article : articleList) {
			sb.append(article.getTitle());
			sb.append(TITLE_SEPARATOR);
		}
		return sb.toString();
	}

	/**
	 * @param title
	 *            a title
	 * @return the success string
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("AddTitle/{title}/")
	public String addTitle(@PathParam("title") String title) {
		LOGGER.debug("Calling Web Service ArticleWS.attTitle() with de title {}",title);
		Article article = new Article();
		article.setTitle(title);
		articleService.save(article);
		return ADD_TITLE_SUCCESS_STRING;
	}

}

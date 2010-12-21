package com.jcertif.services.article;

import java.util.List;

import com.jcertif.bo.article.Article;

/**
 * Business layer interface for Article.
 * 
 * @author rossi.oddet
 * 
 */
public interface ArticleService {

	/**
	 * @return all articles
	 */
	List<Article> findAll();

	/**
	 * Save an Article.
	 * 
	 * @param article
	 *            an article
	 */
	void save(Article article);

}

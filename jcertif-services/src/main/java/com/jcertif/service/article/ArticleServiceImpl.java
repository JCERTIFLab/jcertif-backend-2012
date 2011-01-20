package com.jcertif.service.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.article.Article;
import com.jcertif.dao.api.ArticleDAO;

/**
 * Service implementation for Article. It contains the reusable business code.
 * 
 * @author rossi.oddet
 * 
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	/**
	 * DAO Article.
	 */
	@Autowired
	private ArticleDAO articleDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Article> findAll() {
		return articleDAO.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void save(Article article) {
		articleDAO.merge(article);
	}

	/**
	 * @param articleDAO the articleDAO to set
	 */
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	

}

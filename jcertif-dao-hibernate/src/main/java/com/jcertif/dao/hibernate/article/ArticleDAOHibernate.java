package com.jcertif.dao.hibernate.article;

import org.springframework.stereotype.Repository;

import com.jcertif.bo.article.Article;
import com.jcertif.dao.article.ArticleDAO;
import com.jcertif.dao.hibernate.AbstractHibernateGenericDAO;

/**
 * DAO Hibernate Implementation for Article.
 * 
 * @author rossi.oddet
 * 
 */
@Repository
public class ArticleDAOHibernate extends
		AbstractHibernateGenericDAO<Article, Long> implements
		ArticleDAO {

}

package com.jcertif.service.article;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.article.Article;
import com.jcertif.dao.api.ArticleDAO;

/**
 * Test unitaire de la classe {@link ArticleServiceImpl}.
 * 
 * @author rossi.oddet
 * 
 */
public class ArticleServiceImplTest {

	/**
	 * Mock sur {@link ArticleDAO}.
	 */
	@Mock
	private ArticleDAO articleDAO;

	/**
	 * Classe � tester.
	 */
	private ArticleServiceImpl articleService;

	/**
	 * M�thode ex�cuter avec chaque test.
	 */
	@Before
	public void setUp() {
		// Let mockito create nice objet for us
		MockitoAnnotations.initMocks(this);
		articleService = new ArticleServiceImpl();
		articleService.setArticleDAO(articleDAO);
	}

	/**
	 * Test de la m�thode findAll.
	 */
	@Test
	public void testFindAll() {
		// initialisation de la liste de r�sultat que va retourner le dao
		List<Article> articles = new ArrayList<Article>();
		Article article1 = new Article();
		article1.setId(Long.valueOf(1));
		articles.add(article1);
		Article article2 = new Article();
		article2.setId(Long.valueOf(2));
		articles.add(article2);

		// Sp�cification du comportement du DAO. Lorsque le DAO sera appel� avec
		// la m�thode findAll(), il retournera la liste articles
		Mockito.when(articleDAO.findAll()).thenReturn(articles);

		// V�rification de la m�thode findAll
		// Le service renvoie la m�me liste que celle du DAO, on s'assure qu'il
		// n'y a pas d'autres traitements qui modifierai cette liste.
		assertEquals(articles, articleService.findAll());
	}

	/**
	 * Test de la m�thode Save().
	 */
	@Test
	public void testSave() {
		// Article que l'on d�sire sauvegarder
		Article article1 = new Article();
		article1.setTitle("titre 1");

		// Article sauv� renvoy� par le DAO
		Article article2 = new Article();
		article2.setId(Long.valueOf(1));
		article2.setTitle("titre 1");

		// Sp�cification du comportement du DAO. Lorsque le DAO sera appel� avec
		// la m�thode merge(article1), il retournera article2
		Mockito.when(articleDAO.merge(article1)).thenReturn(article2);

		// V�rification de la m�thode save
		// Le service doit bien appel� le DAO avec article 1. Si ce n'est pas le
		// cas le test sera en erreur
		articleService.save(article1);
	}

}

package com.jcertif.services.article;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.article.Article;
import com.jcertif.dao.ArticleDAO;

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
	 * Classe à tester.
	 */
	private ArticleServiceImpl articleService;

	/**
	 * Méthode exécuter avec chaque test.
	 */
	@Before
	public void setUp() {
		// Let mockito create nice objet for us
		MockitoAnnotations.initMocks(this);
		articleService = new ArticleServiceImpl();
		articleService.setArticleDAO(articleDAO);
	}

	/**
	 * Test de la méthode findAll.
	 */
	@Test
	public void testFindAll() {
		// initialisation de la liste de résultat que va retourner le dao
		List<Article> articles = new ArrayList<Article>();
		Article article1 = new Article();
		article1.setId(Long.valueOf(1));
		articles.add(article1);
		Article article2 = new Article();
		article2.setId(Long.valueOf(2));
		articles.add(article2);

		// Spécification du comportement du DAO. Lorsque le DAO sera appelé avec
		// la méthode findAll(), il retournera la liste articles
		Mockito.when(articleDAO.findAll()).thenReturn(articles);

		// Vérification de la méthode findAll
		// Le service renvoie la même liste que celle du DAO, on s'assure qu'il
		// n'y a pas d'autres traitements qui modifierai cette liste.
		assertEquals(articles, articleService.findAll());
	}

	/**
	 * Test de la méthode Save().
	 */
	@Test
	public void testSave() {
		// Article que l'on désire sauvegarder
		Article article1 = new Article();
		article1.setTitle("titre 1");

		// Article sauvé renvoyé par le DAO
		Article article2 = new Article();
		article2.setId(Long.valueOf(1));
		article2.setTitle("titre 1");

		// Spécification du comportement du DAO. Lorsque le DAO sera appelé avec
		// la méthode merge(article1), il retournera article2
		Mockito.when(articleDAO.merge(article1)).thenReturn(article2);

		// Vérification de la méthode save
		// Le service doit bien appelé le DAO avec article 1. Si ce n'est pas le
		// cas le test sera en erreur
		articleService.save(article1);
	}

}

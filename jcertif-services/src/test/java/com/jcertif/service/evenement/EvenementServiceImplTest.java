package com.jcertif.service.evenement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.Evenement;
import com.jcertif.dao.ArticleDAO;
import com.jcertif.dao.EvenementDAO;
import com.jcertif.service.article.ArticleServiceImpl;

/**
 * Test unitaire de la classe {@link ArticleServiceImpl}.
 * 
 * @author thierry.balla
 * 
 */
public class EvenementServiceImplTest {

	/**
	 * Mock sur {@link EvenementDAO}.
	 */
	@Mock
	private EvenementDAO evenementDAO;

	/**
	 * Classe � tester.
	 */
	private EvenementServiceImpl evenementService;

	/**
	 * M�thode ex�cuter avec chaque test.
	 */
	@Before
	public void setUp() {
		// Let mockito create nice objet for us
		MockitoAnnotations.initMocks(this);
		evenementService = new EvenementServiceImpl();
		evenementService.setEvenementDAO(evenementDAO);
	}

	/**
	 * Test de la m�thode findAll.
	 */
	@Test
	public void testFindAll() {
		// initialisation de la liste de r�sultat que va retourner le dao
		List<Evenement> evenements = new ArrayList<Evenement>();
		Evenement evenement1 = new Evenement();
		evenement1.setId(Long.valueOf(1));
		evenements.add(evenement1);
		Evenement evenement2 = new Evenement();
		evenement2.setId(Long.valueOf(2));
		evenements.add(evenement2);

		// Sp�cification du comportement du DAO. Lorsque le DAO sera appel� avec
		// la m�thode findAll(), il retournera la liste articles
		Mockito.when(evenementDAO.findAll()).thenReturn(evenements);

		// V�rification de la m�thode findAll
		// Le service renvoie la m�me liste que celle du DAO, on s'assure qu'il
		// n'y a pas d'autres traitements qui modifierai cette liste.
		assertEquals(evenements, evenementService.findAll());
	}

	/**
	 * Test de la m�thode Save().
	 */
	@Test
	public void testSave() {
		// Article que l'on d�sire sauvegarder
		Evenement evenement1 = new Evenement();
		evenement1.setNomEvenement("titre 1");

		// Article sauv� renvoy� par le DAO
		Evenement evenement2 = new Evenement();
		evenement2.setId(Long.valueOf(1));
		evenement2.setNomEvenement("titre 1");

		// Sp�cification du comportement du DAO. Lorsque le DAO sera appel� avec
		// la m�thode merge(article1), il retournera article2
		Mockito.when(evenementDAO.merge(evenement1)).thenReturn(evenement2);

		// V�rification de la m�thode save
		// Le service doit bien appel� le DAO avec article 1. Si ce n'est pas le
		// cas le test sera en erreur
		evenementService.save(evenement1);
	}

}

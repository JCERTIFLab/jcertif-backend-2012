package com.jcertif.service.impl.cedule;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;

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
	 * Classe e tester.
	 */
	private EvenementServiceImpl evenementService;

	/**
	 * Methode executer avec chaque test.
	 */
	@Before
	public void setUp() {
		// Let mockito create nice objet for us
		MockitoAnnotations.initMocks(this);
		evenementService = new EvenementServiceImpl();
		evenementService.setDAO(evenementDAO);
	}

	/**
	 * Test de la methode findAll.
	 */
	@Test
	public void testFindAll() {
		// initialisation de la liste de resultat que va retourner le dao
		List<Evenement> evenements = new ArrayList<Evenement>();
		Evenement evenement1 = new Evenement();
		evenement1.setId(Long.valueOf(1));
		evenements.add(evenement1);
		Evenement evenement2 = new Evenement();
		evenement2.setId(Long.valueOf(2));
		evenements.add(evenement2);

		// Specification du comportement du DAO. Lorsque le DAO sera appele avec
		// la methode findAll(), il retournera la liste articles
		Mockito.when(evenementDAO.findAll()).thenReturn(evenements);

		// Verification de la methode findAll
		// Le service renvoie la meme liste que celle du DAO, on s'assure qu'il
		// n'y a pas d'autres traitements qui modifierai cette liste.
		assertEquals(evenements, evenementService.findAll());
	}

	/**
	 * Test de la methode Save().
	 */
	@Test
	public void testSave() {
		// Article que l'on desire sauvegarder
		Evenement evenement1 = new Evenement();
		evenement1.setNomEvenement("titre 1");

		// Article sauve renvoye par le DAO
		Evenement evenement2 = new Evenement();
		evenement2.setId(Long.valueOf(1));
		evenement2.setNomEvenement("titre 1");

		// Specification du comportement du DAO. Lorsque le DAO sera appele avec
		// la methode merge(article1), il retournera article2
		Mockito.when(evenementDAO.merge(evenement1)).thenReturn(evenement2);

		// Verification de la methode save
		// Le service doit bien appele le DAO avec article 1. Si ce n'est pas le
		// cas le test sera en erreur
		evenementService.save(evenement1);
	}

}

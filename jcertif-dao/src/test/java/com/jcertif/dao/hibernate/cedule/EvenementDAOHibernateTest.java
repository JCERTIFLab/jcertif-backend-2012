package com.jcertif.dao.hibernate.cedule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.dao.api.cedule.EvenementDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

/**
 * Test de l'implementation Hibernate de l'acces aux donnees Evenement.
 * 
 * @author Douneg
 * 
 */
@ContextConfiguration(locations = {"classpath:jcertif-dao-test-beans.xml"})
public class EvenementDAOHibernateTest extends AbstractDAOTestCase {

    /**
     * DAO Evenement.
     */
    @Autowired
    private EvenementDAO evenementDAO;


    /**
     * Test de la methode getReference().
     */
    @Test
    public void testGetReference() {
        Evenement evenement1 = evenementDAO.getReference(Long.valueOf(1));
        assertEquals("Aucun detail pertinant", evenement1.getDetails());
        assertEquals("nom_evenement 1", evenement1.getNomEvenement());
        assertEquals(Long.valueOf(13), evenement1.getTypeEvenement().getId());

    }

    /**
     * Test de la methode findById().
     */
    @Test
    public void testFindById() {
        Evenement evenement1 = evenementDAO.findById((Long.valueOf(1)));
        assertEquals("Aucun detail pertinant", evenement1.getDetails());
        assertEquals("nom_evenement 1", evenement1.getNomEvenement());
        assertEquals(Long.valueOf(13), evenement1.getTypeEvenement().getId());

    }

    /**
     * Test de la methode findAll().
     */
    @Test
    public void testFindAll() {
        assertEquals(8, evenementDAO.findAll().size());
    }

    /**
     * Test de la methode findAllWithSort().
     */
    @Test
    public void testFindAllWithSort() {
        assertEquals("nom_evenement 8",
                evenementDAO.findAllWithSort("nomEvenement", false).iterator().next().getNomEvenement());
    }

    /**
     * Test de la methode persist().
     */
    @Test
    public void testPersist() {
        // Persistence
        Evenement evenement1 = new Evenement();
        evenement1.setNomEvenement("evenement 345");
        evenement1.setDetails("details 345");
        evenementDAO.persist(evenement1);

        // Verification
        Evenement evenementV = evenementDAO.findById(evenement1.getId());
        assertEquals("evenement 345", evenementV.getNomEvenement());
        assertEquals("details 345", evenementV.getDetails());

    }

    /**
     * Test de la methode merge().
     */
    @Test
    public void testMerge() {
        // Persistence
        Evenement evenement = new Evenement();
        evenement.setNomEvenement("evenement 1000");
        evenement.setDetails("details 1000");
        evenementDAO.persist(evenement);
        Evenement savedEvenement = evenementDAO.merge(evenement);

        // Verification
        Evenement evenement1 = evenementDAO.findById(savedEvenement.getId());
        assertEquals("evenement 1000", evenement1.getNomEvenement());
        assertEquals("details 1000", evenement1.getDetails());
    }

    /**
     * Test de la methode remove().
     */
    @Test
    public void testRemove() {
        Evenement entity = evenementDAO.findById(Long.valueOf(3));
        evenementDAO.remove(entity);
        assertEquals(7, evenementDAO.findAll().size());
    }
}

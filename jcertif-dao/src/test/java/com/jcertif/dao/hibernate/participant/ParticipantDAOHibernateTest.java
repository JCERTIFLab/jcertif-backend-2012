package com.jcertif.dao.hibernate.participant;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.jcertif.bo.Adresse;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.hibernate.AbstractDAOTestCase;

@ContextConfiguration(locations = { "classpath:jcertif-dao-test-beans.xml" })
public class ParticipantDAOHibernateTest extends AbstractDAOTestCase{

	@Autowired
	private ParticipantDAO participantDAO;
	
	/**
	 * Test de la méthode getReference().
	 */	
	@Test
	public void testGetReference() {
		Participant participant1 = participantDAO.getReference(1L);
		assertEquals("Oracle", participant1.getCompagnie());
		assertEquals("partenaire", participant1.getRoleparticipant().getCode());
		assertEquals("entreprise", participant1.getTypeParticipant().getCode());
		assertNull(participant1.getProfilUtilisateur());
		
		Participant participant3 = participantDAO.findById(3L);
		assertEquals("Max", participant3.getPrenom());
		assertEquals("Bonbhel", participant3.getNom());
		assertEquals("organisateur", participant3.getRoleparticipant().getCode());
		assertEquals("particulier", participant3.getTypeParticipant().getCode());
		assertEquals("Max and co", participant3.getCompagnie());
		assertNotNull(participant3.getAdresse());
		assertEquals("ligne1 1", participant3.getAdresse().getLigne1());
		assertNotNull(participant3.getProfilUtilisateur());
		assertEquals("fr", participant3.getProfilUtilisateur().getLangueCorrespondance());
		assertEquals("maxb", participant3.getProfilUtilisateur().getNomProfil());
	}
	
	/**
	 * Test de la méthode find().
	 */	
	@Test
	public void testFind() {
		Participant participant1 = participantDAO.findById(1L);
		assertEquals("Oracle", participant1.getCompagnie());
		assertEquals("partenaire", participant1.getRoleparticipant().getCode());
		assertEquals("entreprise", participant1.getTypeParticipant().getCode());
		assertNull(participant1.getProfilUtilisateur());
		
		Participant participant3 = participantDAO.findById(3L);
		assertEquals("Max", participant3.getPrenom());
		assertEquals("Bonbhel", participant3.getNom());
		assertEquals("organisateur", participant3.getRoleparticipant().getCode());
		assertEquals("Max and co", participant3.getCompagnie());
		assertNotNull(participant3.getAdresse());
		assertEquals("ligne1 1", participant3.getAdresse().getLigne1());
		assertNotNull(participant3.getProfilUtilisateur());
		assertEquals("fr", participant3.getProfilUtilisateur().getLangueCorrespondance());
		assertEquals("maxb", participant3.getProfilUtilisateur().getNomProfil());
	}
	
	/**
	 * Test de la méthode findAll().
	 */
	@Test
	public void testFindAll() {
		assertEquals(3, participantDAO.findAll().size());
	}

	/**
	 * Test de la méthode findAllWithSort().
	 */	
	@Test
	public void testFindAllWithSort() {
		assertEquals("Eric", participantDAO.findAllWithSort("prenom", true)
				.iterator().next().getPrenom());
	}

	/**
	 * Test de la méthode persist().
	 */
	@Test
	public void testPersist() {
		// Persistence
		Adresse adresse = new Adresse();
		adresse.setLigne1("ligne1 1000");
		adresse.setLigne2("ligne2 1000");
		adresse.setDetails("details 1000");

		
		Participant participant = new Participant();
		participant.setPrenom("Fred");
		participant.setNom("Close");
		participant.setAdresse(adresse);
		participant.setDetails("details 345");
		participantDAO.persist(participant);

		// Vérification
		Participant participantV = participantDAO.findById(participant.getId());
		assertEquals("Fred", participantV.getPrenom());
		assertEquals("ligne1 1000", participantV.getAdresse().getLigne1());
		
	}

	/**
	 * Test de la méthode merge().
	 */
	@Test
	public void testMerge() {
		// Persistence
		Participant participant = new Participant();
		participant.setPrenom("Fred");
		participant.setNom("Close");
		participant.setDetails("details 345");
		participantDAO.persist(participant);
		
		participant.setPrenom("Coco");
		Participant savedParticipant = participantDAO.merge(participant);

		// Vérification
		Participant participantV = participantDAO.findById(savedParticipant.getId());
		assertEquals("Coco", participantV.getPrenom());
		assertEquals("Close", participantV.getNom());
		
	}

	/**
	 * Test de la méthode remove().
	 */
	@Test
	public void testRemove() {
		Participant entity = participantDAO.findById(Long.valueOf(3L));
		participantDAO.remove(entity);
		assertEquals(2, participantDAO.findAll().size());
	}	
	
	@Test
	public void testFindByEmail(){
		List<Participant> partList = participantDAO.findByEmail("max@bon.com");
		assertEquals(1, partList.size());
		partList = participantDAO.findByEmail("rossi@bon.com");
		assertEquals(0, partList.size());
	}
        
        @Test
        public void testFindByProperty() {
            RoleParticipant rolePartenaire = new RoleParticipant(4l, "partenaire", "partenaire");
            List<Participant> partList = participantDAO.findByProperty("roleparticipant", rolePartenaire);
            assertEquals(2, partList.size());
            RoleParticipant roleSpeaker = new RoleParticipant(1l, "speaker", "speaker");
            partList = participantDAO.findByProperty("roleparticipant", roleSpeaker);
            assertEquals(0, partList.size());
        }
	
}

package com.jcertif.service.participant;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.dao.api.participant.ProfilUtilisateurDAO;

/**
 * Tests the {@link ProfilUtilisateurServiceImpl}.
 * @author Douneg
 *
 */
public class ProfilUtilisateurtServiceImplTest {
	
	private ProfilUtilisateurServiceImpl service;
	
	@Mock
	private ProfilUtilisateurDAO participantDAO;
	
	/**
	 * Setup the test.
	 * @throws Exception if things gone wrong
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new ProfilUtilisateurServiceImpl();
		service.setService(participantDAO);
	}

	/**
	 * Tests the {@link ProfilUtilisateurServiceImpl#createProfilUtilisateur(Long, String, String, String, String, String, Character, String, String, String, String, com.jcertif.bo.RoleProfilUtilisateur, com.jcertif.bo.Conference, java.util.Set)}.
	 */
	@Test
	public void testCreateProfilUtilisateur() {
		ProfilUtilisateur participant = new ProfilUtilisateur(Long.valueOf(1), "Stanyslas Matayo", "MatayoBweta@gmail.com","1QSDDRR5TGTDD", "C;/Missiers", "Francais", "AfterCool");
		Mockito.when(participantDAO.merge(participant))
		.thenReturn(participant);
	}

	/**
	 * Tests the {@link ProfilUtilisateurServiceImpl#findById(Long)}.
	 */
	@Test
	public void testFindById() {
		Long idProfilUtilisateur = Long.valueOf(1);
		List<ProfilUtilisateur> participantList = new ArrayList<ProfilUtilisateur>();
		ProfilUtilisateur participant1 = new ProfilUtilisateur(Long.valueOf(1), "Matayo", "MatayoBweta@gmail.com","1QSDDRR5TGTDD", "C;/Missiers", "Francais", "AfterCool");
		ProfilUtilisateur participant2 = new ProfilUtilisateur(Long.valueOf(2), "Chrisbel", "malonga9@gmail.com","1QSDDRR5TGTDD", "C;/Missiers", "Francais", "Architecte");
		ProfilUtilisateur participant3 = new ProfilUtilisateur(Long.valueOf(3), "Oddet", "rossi.oddet@gmail.com","1QSDDRR5TGTDD", "C;/Missiers", "Francais", "SuperCommiter");
		participantList.add(participant1);
		participantList.add(participant2);
		participantList.add(participant3);
		
		Mockito.when(participantDAO.findById(idProfilUtilisateur))
		.thenReturn(participant1);
		
	}

	/**
	 * Tests the {@link ProfilUtilisateurServiceImpl#save(ProfilUtilisateur)}.
	 */
	@Test
	public void testSave() {
		ProfilUtilisateur participant = new ProfilUtilisateur(Long.valueOf(1), "Matayo", "MatayoBweta@gmail.com","1QSDDRR5TGTDD", "C;/Missiers", "Francais", "AfterCool");
		Mockito.when(participantDAO.merge(participant))
		.thenReturn(participant);
		assertEquals(participant, service.save(participant));
	}

	/**
	 * Tests the {@link ProfilUtilisateurServiceImpl#update(ProfilUtilisateur)}.
	 */
	@Test
	public void testUpdate() {
		ProfilUtilisateur participant = new ProfilUtilisateur(Long.valueOf(1), "Matayo", "MatayoBweta@gmail.com","1QSDDRR5TGTDD", "C;/Missiers", "Francais", "AfterCool");
		Mockito.when(participantDAO.merge(participant))
		.thenReturn(participant);
	}

	/**
	 * Tests the {@link ProfilUtilisateurServiceImpl#remove(ProfilUtilisateur)}.
	 */
	@Test
	public void testRemove() {
		ProfilUtilisateur participant = new ProfilUtilisateur(Long.valueOf(1), "Matayo", "MatayoBweta@gmail.com","1QSDDRR5TGTDD", "C;/Missiers", "Francais", "AfterCool");

		service.remove(participant);
		Mockito.verify(participantDAO).remove(participant);
	}

}

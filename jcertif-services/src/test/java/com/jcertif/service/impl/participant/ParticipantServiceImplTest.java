package com.jcertif.service.impl.participant;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.service.impl.participant.ParticipantServiceImpl;

/**
 * Tests the {@link ParticipantServiceImpl}.
 * @author Bernard Adanlessossi
 *
 */
public class ParticipantServiceImplTest {
	
	private ParticipantServiceImpl service;
	
	@Mock
	private ParticipantDAO participantDAO;
	
	/**
	 * Setup the test.
	 * @throws Exception if things gone wrong
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new ParticipantServiceImpl();
		service.setDAO(participantDAO);
	}

	/**
	 * Tests the {@link ParticipantServiceImpl#createParticipant(Long, String, String, String, String, String, Character, String, String, String, String, com.jcertif.bo.RoleParticipant, com.jcertif.bo.Conference, java.util.Set)}.
	 */
	@Test
	public void testCreateParticipant() {
		Participant participant = new Participant(Long.valueOf(1), null, "Mr", "Java", "Bernard", "Adanlessossi", 'M', "adalessossi@gmail.com", null, "cv", "detail", null, null, null);
		Mockito.when(participantDAO.merge(participant))
		.thenReturn(participant);
	}

	/**
	 * Tests the {@link ParticipantServiceImpl#findById(Long)}.
	 */
	@Test
	public void testFindById() {
		Long idParticipant = Long.valueOf(1);
		List<Participant> participantList = new ArrayList<Participant>();
		Participant participant1 = new Participant(Long.valueOf(1), null, "Mr", "Java", "Bernard", "Adanlessossi", 'M', "adalessossi@gmail.com", null, "cv ben", "detail ben", null, null, null);
		Participant participant2 = new Participant(Long.valueOf(2), null, "Mr", "Vaadin", "Max", "Bonbhel", 'M', "max@gmail.com", null, "cv max", "detail max", null, null, null);
		Participant participant3 = new Participant(Long.valueOf(3), null, "Mr", "JPA", "Rossi", "Odet", 'M', "rossi@gmail.com", null, "cv rossi", "detail max", null, null, null);
		participantList.add(participant1);
		participantList.add(participant2);
		participantList.add(participant3);
		
		Mockito.when(participantDAO.findById(idParticipant))
		.thenReturn(participant1);
		
	}

	/**
	 * Tests the {@link ParticipantServiceImpl#save(Participant)}.
	 */
	@Test
	public void testSave() {
		Participant participant = new Participant(Long.valueOf(1), null, "Mr", "Java", "Bernard", "Adanlessossi", 'M', "adalessossi@gmail.com", null, "cv", "detail", null, null, null);
		Mockito.when(participantDAO.merge(participant))
		.thenReturn(participant);
		assertEquals(participant, service.save(participant));
	}

	/**
	 * Tests the {@link ParticipantServiceImpl#update(Participant)}.
	 */
	@Test
	public void testUpdate() {
		Participant participant = new Participant(Long.valueOf(1), null, "Mr", "Java, JEE, ZK", "Bernard", "Adanlessossi", 'M', "adalessossi@gmail.com", null, "cv", "detail", null, null, null);
		Mockito.when(participantDAO.merge(participant))
		.thenReturn(participant);
	}

	/**
	 * Tests the {@link ParticipantServiceImpl#remove(Participant)}.
	 */
	@Test
	public void testRemove() {
		Participant participant = new Participant(Long.valueOf(1), null, "Mr", "Java", "Bernard", "Adanlessossi", 'M', "adalessossi@gmail.com", null, "cv", "detail", null, null, null);
		
		service.remove(participant);
		Mockito.verify(participantDAO).remove(participant);
	}

}
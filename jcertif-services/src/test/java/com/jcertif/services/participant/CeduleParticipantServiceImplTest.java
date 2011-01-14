package com.jcertif.services.participant;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.CeduleParticipant;
import com.jcertif.dao.CeduleParticipantDAO;

/**
 * @author rossi.oddet
 * 
 */
public class CeduleParticipantServiceImplTest {

	/**
	 * Service à tester.
	 */
	private CeduleParticipantServiceImpl service;

	/**
	 * Mock du DAO CeduleParticipant.
	 */
	@Mock
	private CeduleParticipantDAO ceduleParticipantDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new CeduleParticipantServiceImpl();
		service.setCeduleParticipantDAO(ceduleParticipantDAO);
	}

	/**
	 * Test method for
	 * {@link com.jcertif.services.participant.CeduleParticipantServiceImpl#findByParticipant(java.lang.Long)}
	 * .
	 */
	@Test
	public void testFindByParticipant() {
		Long idParticipant = Long.valueOf(1);

		List<CeduleParticipant> ceduleList = new ArrayList<CeduleParticipant>();
		CeduleParticipant cedule1 = new CeduleParticipant();
		cedule1.setId(Long.valueOf(1));
		ceduleList.add(cedule1);
		CeduleParticipant cedule2 = new CeduleParticipant();
		cedule2.setId(Long.valueOf(2));
		ceduleList.add(cedule2);

		Mockito.when(ceduleParticipantDAO.findByParticipant(idParticipant))
				.thenReturn(ceduleList);
		assertEquals(ceduleList, service.findByParticipant(idParticipant));
	}

	/**
	 * Test method for
	 * {@link com.jcertif.services.participant.CeduleParticipantServiceImpl#saveOrUpdate(com.jcertif.bo.CeduleParticipant)}
	 * .
	 */
	@Test
	public void testSaveOrUpdate() {
		CeduleParticipant cedule2 = new CeduleParticipant();
		cedule2.setId(Long.valueOf(2));
		
		CeduleParticipant cedule3 = new CeduleParticipant();
		cedule3.setId(Long.valueOf(3));
		Mockito.when(ceduleParticipantDAO.merge(cedule2))
		.thenReturn(cedule3);
		
		assertEquals(cedule3, service.saveOrUpdate(cedule2));
		Mockito.verify(ceduleParticipantDAO).merge(cedule2);
		
	}

	/**
	 * Test method for
	 * {@link com.jcertif.services.participant.CeduleParticipantServiceImpl#remove(com.jcertif.bo.CeduleParticipant)}
	 * .
	 */
	@Test
	public void testRemove() {
		CeduleParticipant cedule3 = new CeduleParticipant();
		cedule3.setId(Long.valueOf(3));
		service.remove(cedule3);
		Mockito.verify(ceduleParticipantDAO).remove(cedule3);
	}

}

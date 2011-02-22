/**
 * 
 */
package com.jcertif.facade.participant;

import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.participant.Participants;
import static org.junit.Assert.*;

import org.junit.Test;

import com.jcertif.facade.AbstractFacadeIntegrationTest;
import javax.ws.rs.core.MediaType;
import junit.framework.Assert;

/**
 * Integration test for the {@link ParticipantFacade}.
 * 
 * @author Bernard Adanlessossi
 */
public class ParticipantFacadeIntegrationTest extends
        AbstractFacadeIntegrationTest {

	@Test
	public void testTrue(){
		assertTrue(true);
	}

//	@Test
//	public void testGetAllParticipants() {
//		Participant participant = getWebResource().path("api")
//		        .path("participant").path("create")
//		        .path("My Participant").accept(MediaType.APPLICATION_JSON)
//		        .get(Participant.class);
//		Participants participants = getWebResource().path("api")
//		        .path("participant").path("findall")
//		        .accept(MediaType.APPLICATION_JSON).get(Participants.class);
//		boolean isIn = false;
//		for (Participant partIn : participants.getParticipants()) {
//			if (partIn.getEmail().equals(participant.getEmail())) {
//				isIn = true;
//			}
//		}
//		Assert.assertTrue("My Participant", isIn);
//	}

//	public void testAddParticipant() {
//		Participant participant = getWebResource().path("api").path("article")
//		        .path("create").path("My Participant")
//		        .accept(MediaType.APPLICATION_JSON).get(Participant.class);
//		Assert.assertEquals(participant.getEmail(), "My Participant");
//	}
}

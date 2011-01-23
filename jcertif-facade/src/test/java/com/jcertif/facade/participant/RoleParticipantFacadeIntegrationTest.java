package com.jcertif.facade.participant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.facade.AbstractFacadeIntegrationTest;

/**
 * @author rossi.oddet
 * 
 */
public class RoleParticipantFacadeIntegrationTest extends
		AbstractFacadeIntegrationTest {

	@Test
	public void testCreate() {
		RoleParticipant role = new RoleParticipant(null, "code", "desc");
		RoleParticipant createdRole = getWebResource().path("api")
				.path("roleparticipant").path("create")
				.accept(MediaType.APPLICATION_JSON)
				.post(RoleParticipant.class, role);
		verifierSauvegarde(role, createdRole);
	}

	@Test
	public void testFindById() {
		RoleParticipant role = new RoleParticipant(null, "code", "desc");
		RoleParticipant createdRole = getWebResource().path("api")
				.path("roleparticipant").path("create")
				.accept(MediaType.APPLICATION_JSON)
				.post(RoleParticipant.class, role);
		verifierSauvegarde(role, createdRole);

		// TEST FINDBYID
		RoleParticipant roleById = getWebResource().path("api")
				.path("roleparticipant").path("/" + createdRole.getId())
				.accept(MediaType.APPLICATION_JSON)
				.get(RoleParticipant.class);
		// V�rification que c'est bien le profil 2 qui est r�cup�r�
		assertEquals(createdRole.getId(), roleById.getId());
		assertEquals(createdRole, roleById);
	}


	@Test
	public void testUpdate() {
		// TEST UPDATE
		// Cr�ation d'un profil 2 utilisateur dans la base de donn�es
		RoleParticipant role = new RoleParticipant(null, "code", "desc");
		RoleParticipant createdRole = getWebResource().path("api")
				.path("roleparticipant").path("create")
				.accept(MediaType.APPLICATION_JSON)
				.post(RoleParticipant.class, role);
		verifierSauvegarde(role, createdRole);
		
		createdRole.setCodeRole("code updated");
		RoleParticipant updatedRole = getWebResource().path("api")
				.path("roleparticipant").path("update")
				.accept(MediaType.APPLICATION_JSON)
				.post(RoleParticipant.class, createdRole);
		// V�rification que l'ID est le m�me
		assertEquals(createdRole.getId(), updatedRole.getId());
		// V�rification que le changement a bien eu lieu
		assertEquals("code updated", updatedRole.getCodeRole());
	}



	private void verifierSauvegarde(RoleParticipant newRole,
			RoleParticipant createdRole) {
		// Le profil cr�� ne doit pas �tre null et doit avoir son Id renseign�
		assertNotNull(createdRole);
		assertNotNull(createdRole.getId());

		// V�rification des infos
		assertEquals(newRole.getCodeRole(), createdRole.getCodeRole());
		assertEquals(newRole.getDescription(), createdRole.getDescription());
	}

}

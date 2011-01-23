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
		// Vérification que c'est bien le profil 2 qui est récupéré
		assertEquals(createdRole.getId(), roleById.getId());
		assertEquals(createdRole, roleById);
	}


	@Test
	public void testUpdate() {
		// TEST UPDATE
		// Création d'un profil 2 utilisateur dans la base de données
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
		// Vérification que l'ID est le même
		assertEquals(createdRole.getId(), updatedRole.getId());
		// Vérification que le changement a bien eu lieu
		assertEquals("code updated", updatedRole.getCodeRole());
	}



	private void verifierSauvegarde(RoleParticipant newRole,
			RoleParticipant createdRole) {
		// Le profil créé ne doit pas être null et doit avoir son Id renseigné
		assertNotNull(createdRole);
		assertNotNull(createdRole.getId());

		// Vérification des infos
		assertEquals(newRole.getCodeRole(), createdRole.getCodeRole());
		assertEquals(newRole.getDescription(), createdRole.getDescription());
	}

}

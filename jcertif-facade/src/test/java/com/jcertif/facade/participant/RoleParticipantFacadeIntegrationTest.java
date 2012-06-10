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
public class RoleParticipantFacadeIntegrationTest extends AbstractFacadeIntegrationTest {

    @Test
    public void testCreate() {
        RoleParticipant role = new RoleParticipant(null, "code", "desc");
        RoleParticipant createdRole = getWebResource().path("api").path("roleparticipant").path("create").accept(MediaType.APPLICATION_JSON).post(RoleParticipant.class, role);
        verifierSauvegarde(role, createdRole);
    }

    @Test
    public void testFindById() {
        RoleParticipant role = new RoleParticipant(null, "code", "desc");
        RoleParticipant createdRole = getWebResource().path("api").path("roleparticipant").path("create").accept(MediaType.APPLICATION_JSON).post(RoleParticipant.class, role);
        verifierSauvegarde(role, createdRole);

        // TEST FINDBYID
        RoleParticipant roleById = getWebResource().path("api").path("roleparticipant").path("/" + createdRole.getId()).accept(MediaType.APPLICATION_JSON).get(RoleParticipant.class);
        // Verification que c'est bien le profil 2 qui est recupere
        assertEquals(createdRole.getId(), roleById.getId());
        assertEquals(createdRole, roleById);
    }

    @Test
    public void testUpdate() {
        // TEST UPDATE
        // Creation d'un profil 2 utilisateur dans la base de donnees
        RoleParticipant role = new RoleParticipant(null, "code", "desc");
        RoleParticipant createdRole = getWebResource().path("api").path("roleparticipant").path("create").accept(MediaType.APPLICATION_JSON).post(RoleParticipant.class, role);
        verifierSauvegarde(role, createdRole);

        createdRole.setCode("code updated");
        RoleParticipant updatedRole = getWebResource().path("api").path("roleparticipant").path("update").accept(MediaType.APPLICATION_JSON).post(RoleParticipant.class, createdRole);
        // Verification que l'ID est le meme
        assertEquals(createdRole.getId(), updatedRole.getId());
        // Verification que le changement a bien eu lieu
        assertEquals("code updated", updatedRole.getCode());
    }

    private void verifierSauvegarde(RoleParticipant newRole,
            RoleParticipant createdRole) {
        // Le profil cree ne doit pas etre null et doit avoir son Id renseigne
        assertNotNull(createdRole);
        assertNotNull(createdRole.getId());

        // Verification des infos
        assertEquals(newRole.getCode(), createdRole.getCode());
        assertEquals(newRole.getDescription(), createdRole.getDescription());
    }
}

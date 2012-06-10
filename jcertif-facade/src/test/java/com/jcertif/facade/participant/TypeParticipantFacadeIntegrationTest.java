package com.jcertif.facade.participant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.facade.AbstractFacadeIntegrationTest;

/**
 * @author rossi.oddet
 * 
 */
public class TypeParticipantFacadeIntegrationTest extends AbstractFacadeIntegrationTest {

    @Test
    public void testCreate() {
        TypeParticipant type = new TypeParticipant("code", "desc");
        TypeParticipant createdType = getWebResource().path("api").path("typeparticipant").path("create").accept(MediaType.APPLICATION_JSON).post(TypeParticipant.class, type);
        verifierSauvegarde(type, createdType);
    }

    @Test
    public void testFindById() {
        TypeParticipant type = new TypeParticipant("code", "desc");
        TypeParticipant createdType = getWebResource().path("api").path("typeparticipant").path("create").accept(MediaType.APPLICATION_JSON).post(TypeParticipant.class, type);
        verifierSauvegarde(type, createdType);

        // TEST FINDBYID
        TypeParticipant typeById = getWebResource().path("api").path("typeparticipant").path("/" + createdType.getId()).accept(MediaType.APPLICATION_JSON).get(TypeParticipant.class);
        // Verification que c'est bien le profil 2 qui est recupere
        assertEquals(createdType.getId(), typeById.getId());
        assertEquals(createdType, typeById);
    }

    @Test
    public void testUpdate() {
        // TEST UPDATE
        // Creation d'un profil 2 utilisateur dans la base de donnees
        TypeParticipant type = new TypeParticipant("code", "desc");
        TypeParticipant createdType = getWebResource().path("api").path("typeparticipant").path("create").accept(MediaType.APPLICATION_JSON).post(TypeParticipant.class, type);
        verifierSauvegarde(type, createdType);

        createdType.setCode("code updated");
        TypeParticipant updatedType = getWebResource().path("api").path("typeparticipant").path("update").accept(MediaType.APPLICATION_JSON).post(TypeParticipant.class, createdType);
        // Verification que l'ID est le meme
        assertEquals(createdType.getId(), updatedType.getId());
        // Verification que le changement a bien eu lieu
        assertEquals("code updated", updatedType.getCode());
    }

    private void verifierSauvegarde(TypeParticipant newType,
            TypeParticipant createdType) {
        // Le profil cree ne doit pas etre null et doit avoir son Id renseigne
        assertNotNull(createdType);
        assertNotNull(createdType.getId());

        // Verification des infos
        assertEquals(newType.getCode(), createdType.getCode());
        assertEquals(newType.getDescription(), createdType.getDescription());
    }
}

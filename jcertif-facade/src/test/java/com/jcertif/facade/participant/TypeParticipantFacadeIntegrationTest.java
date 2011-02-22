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
        // Vérification que c'est bien le profil 2 qui est récupéré
        assertEquals(createdType.getId(), typeById.getId());
        assertEquals(createdType, typeById);
    }

    @Test
    public void testUpdate() {
        // TEST UPDATE
        // Création d'un profil 2 utilisateur dans la base de données
        TypeParticipant type = new TypeParticipant("code", "desc");
        TypeParticipant createdType = getWebResource().path("api").path("typeparticipant").path("create").accept(MediaType.APPLICATION_JSON).post(TypeParticipant.class, type);
        verifierSauvegarde(type, createdType);

        createdType.setCode("code updated");
        TypeParticipant updatedType = getWebResource().path("api").path("typeparticipant").path("update").accept(MediaType.APPLICATION_JSON).post(TypeParticipant.class, createdType);
        // Vérification que l'ID est le même
        assertEquals(createdType.getId(), updatedType.getId());
        // Vérification que le changement a bien eu lieu
        assertEquals("code updated", updatedType.getCode());
    }

    private void verifierSauvegarde(TypeParticipant newType,
            TypeParticipant createdType) {
        // Le profil créé ne doit pas être null et doit avoir son Id renseigné
        assertNotNull(createdType);
        assertNotNull(createdType.getId());

        // Vérification des infos
        assertEquals(newType.getCode(), createdType.getCode());
        assertEquals(newType.getDescription(), createdType.getDescription());
    }
}

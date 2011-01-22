package com.jcertif.facade.participant;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.facade.AbstractFacadeIntegrationTest;

/**
 * Integration test for {@link ProfilUtilisateurFacade}.
 * 
 * @author rossi.oddet
 * 
 */
public class ProfilUtilisateurFacadeIntegrationTest extends
		AbstractFacadeIntegrationTest {

	/**
	 * Exécution d'un scénario CRUD avec JSON.
	 */
	@Test
	public void testCRUDJSON() {
		executeCRUD(MediaType.APPLICATION_JSON);
	}

	/**
	 * Exécution d'un scénario CRUD avec XML.
	 */
	@Test
	public void testCRUDXML() {
		executeCRUD(MediaType.APPLICATION_XML);
	}

	private void executeCRUD(String type) {

		// TEST CREATE

		// Création d'un profil 1 utilisateur dans la base de données
		ProfilUtilisateur newProfil1 = getProfilUtilisateur("rossi",
				"rossi@rossi.fr", "FR", "monpass", "ma_photo");
		ProfilUtilisateur createdProfil1 = getWebResource().path("api")
				.path("profilutilisateur").path("create").accept(type)
				.post(ProfilUtilisateur.class, newProfil1);

		// Vérification de la création du profil 1
		verifierProfilSauve(newProfil1, createdProfil1);

		// Création d'un profil 2 utilisateur dans la base de données
		ProfilUtilisateur newProfil2 = getProfilUtilisateur("rossi",
				"rossi@rossi.fr", "FR", "monpass", "ma_photo");
		ProfilUtilisateur createdProfil2 = getWebResource().path("api")
				.path("profilutilisateur").path("create").accept(type)
				.post(ProfilUtilisateur.class, newProfil2);
		verifierProfilSauve(newProfil2, createdProfil2);

		// TEST FINDBYID
		// Récupération du profil 2 enregistré
		ProfilUtilisateur profilById = getWebResource().path("api")
				.path("profilutilisateur").path("/" + createdProfil2.getId())
				.accept(type).get(ProfilUtilisateur.class);
		// Vérification que c'est bien le profil 2 qui est récupéré
		assertEquals(createdProfil2.getId(), profilById.getId());
		assertEquals(createdProfil2, profilById);

		// TEST FINDALL
		List<ProfilUtilisateur> profilList = getWebResource().path("api")
				.path("profilutilisateur").path("/list").accept(type)
				.get(ProfilUtilisateurs.class).getProfilUtilisateurs();
		// vérification qu'il y a bien les 2 éléments créés
		assertTrue(profilList.contains(createdProfil1));
		assertTrue(profilList.contains(createdProfil2));

		// TEST UPDATE
		createdProfil2.setEmail("newEmail@ne.fr");
		ProfilUtilisateur createdProfil2update = getWebResource().path("api")
				.path("profilutilisateur").path("update").accept(type)
				.post(ProfilUtilisateur.class, createdProfil2);
		// Vérification que l'ID est le même
		assertEquals(createdProfil2.getId(), createdProfil2update.getId());

		// Vérification que le changement a bien eu lieu
		assertEquals(createdProfil2.getEmail(), createdProfil2update.getEmail());

		// TEST DELETE
		// Suppression du profil 2
		getWebResource().path("api").path("profilutilisateur").path("delete")
				.accept(type)
				.post(ProfilUtilisateur.class, createdProfil2update);
		// Vérification qu'il ne reste bien qu'un seul élément
		List<ProfilUtilisateur> profilListAfterDelete = getWebResource().path("api")
				.path("profilutilisateur").path("/list").accept(type)
				.get(ProfilUtilisateurs.class).getProfilUtilisateurs();
		assertEquals(profilList.size()-1, profilListAfterDelete.size());

	}

	private void verifierProfilSauve(ProfilUtilisateur newProfil,
			ProfilUtilisateur createdProfil) {
		// Le profil créé ne doit pas être null et doit avoir son Id renseigné
		assertNotNull(createdProfil);
		assertNotNull(createdProfil.getId());

		// Vérification des infos
		assertEquals(newProfil.getNomProfil(), createdProfil.getNomProfil());
		assertEquals(newProfil.getEmail(), createdProfil.getEmail());
		assertEquals(newProfil.getLangueCorrespondance(),
				createdProfil.getLangueCorrespondance());
		assertEquals(newProfil.getPassword(), createdProfil.getPassword());
		assertEquals(newProfil.getPhoto(), createdProfil.getPhoto());

	}

	private ProfilUtilisateur getProfilUtilisateur(String nom, String email,
			String langue, String password, String photo) {
		ProfilUtilisateur newProfil = new ProfilUtilisateur();
		newProfil.setNomProfil(nom);
		newProfil.setEmail(email);
		newProfil.setLangueCorrespondance(langue);
		newProfil.setPassword(password);
		newProfil.setPassword(photo);
		return newProfil;
	}
}

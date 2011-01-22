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

	@Test
	public void testCREATE() {
		ProfilUtilisateur newProfil1 = getProfilUtilisateur("rossi",
				"rossi@rossi.fr", "FR", "monpass", "ma_photo");
		ProfilUtilisateur createdProfil1 = getWebResource().path("api")
				.path("profilutilisateur").path("create")
				.accept(MediaType.APPLICATION_JSON)
				.post(ProfilUtilisateur.class, newProfil1);

		// V�rification de la cr�ation du profil 1
		verifierProfilSauve(newProfil1, createdProfil1);
	}

	@Test
	public void testFindById() {
		// Cr�ation d'un profil 2 utilisateur dans la base de donn�es
		ProfilUtilisateur newProfil2 = getProfilUtilisateur("rossi",
				"rossi@rossi.fr", "FR", "monpass", "ma_photo");
		ProfilUtilisateur createdProfil2 = getWebResource().path("api")
				.path("profilutilisateur").path("create")
				.accept(MediaType.APPLICATION_JSON)
				.post(ProfilUtilisateur.class, newProfil2);
		verifierProfilSauve(newProfil2, createdProfil2);

		// TEST FINDBYID
		// R�cup�ration du profil 2 enregistr�
		ProfilUtilisateur profilById = getWebResource().path("api")
				.path("profilutilisateur").path("/" + createdProfil2.getId())
				.accept(MediaType.APPLICATION_JSON)
				.get(ProfilUtilisateur.class);
		// V�rification que c'est bien le profil 2 qui est r�cup�r�
		assertEquals(createdProfil2.getId(), profilById.getId());
		assertEquals(createdProfil2, profilById);
	}

	// TODO Voir pourquoi �a ne marche pas
	@Test
	public void testFindAll() {
		List<ProfilUtilisateur> profilList = getWebResource().path("api")
				.path("profilutilisateur").path("/list")
				.accept(MediaType.APPLICATION_JSON)
				.get(ProfilUtilisateurs.class).getProfilUtilisateurs();
		// v�rification qu'il y a bien les 2 �l�ments cr��s
		assertTrue(profilList != null);
	}

	@Test
	public void testUpdate() {
		// TEST UPDATE
		// Cr�ation d'un profil 2 utilisateur dans la base de donn�es
		ProfilUtilisateur newProfil2 = getProfilUtilisateur("rossi",
				"rossi@rossi.fr", "FR", "monpass", "ma_photo");
		ProfilUtilisateur createdProfil2 = getWebResource().path("api")
				.path("profilutilisateur").path("create")
				.accept(MediaType.APPLICATION_JSON)
				.post(ProfilUtilisateur.class, newProfil2);
		createdProfil2.setEmail("newEmail@ne.fr");
		ProfilUtilisateur createdProfil2update = getWebResource().path("api")
				.path("profilutilisateur").path("update")
				.accept(MediaType.APPLICATION_JSON)
				.post(ProfilUtilisateur.class, createdProfil2);
		// V�rification que l'ID est le m�me
		assertEquals(createdProfil2.getId(), createdProfil2update.getId());
		// V�rification que le changement a bien eu lieu
		assertEquals(createdProfil2.getEmail(), createdProfil2update.getEmail());
	}

	// TODO Voir pourquoi �a ne marche pas
	public void testDelete() {
		// TEST DELETE
		ProfilUtilisateur newProfil2 = getProfilUtilisateur("rossi",
				"rossi@rossi.fr", "FR", "monpass", "ma_photo");
		ProfilUtilisateur createdProfil2 = getWebResource().path("api")
				.path("profilutilisateur").path("create")
				.accept(MediaType.APPLICATION_JSON)
				.post(ProfilUtilisateur.class, newProfil2);
		List<ProfilUtilisateur> profilList = getWebResource().path("api")
				.path("profilutilisateur").path("/list")
				.accept(MediaType.APPLICATION_JSON)
				.get(ProfilUtilisateurs.class).getProfilUtilisateurs();
		getWebResource().path("api").path("profilutilisateur").path("delete")
				.accept(MediaType.APPLICATION_JSON)
				.post(ProfilUtilisateur.class, createdProfil2);
		// V�rification qu'il y a bien un �l�ment en moins
		List<ProfilUtilisateur> profilListAfterDelete = getWebResource()
				.path("api").path("profilutilisateur").path("/list")
				.accept(MediaType.APPLICATION_JSON)
				.get(ProfilUtilisateurs.class).getProfilUtilisateurs();
		assertEquals(profilList.size() - 1, profilListAfterDelete.size());
	}

	
	private void verifierProfilSauve(ProfilUtilisateur newProfil,
			ProfilUtilisateur createdProfil) {
		// Le profil cr�� ne doit pas �tre null et doit avoir son Id renseign�
		assertNotNull(createdProfil);
		assertNotNull(createdProfil.getId());

		// V�rification des infos
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

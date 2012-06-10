package com.jcertif.facade.model.evenement;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.jcertif.bo.cedule.CeduleSalle;
import com.jcertif.bo.cedule.Evenement;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.MotCle;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.bo.presentation.Sujet;
import com.jcertif.bo.salle.Salle;

/**
 * Tests unitaires de la classe Event.
 * 
 * @author rossi.oddet
 */
public class EventTest {

	/**
	 * Test of constructor of class Event.
	 */
	@Test
	public void testEventConstructor() {
		Evenement evenement = getEvenement();
		Event evt = new Event(evenement);
		assertEquals(evt.getId(), evenement.getId());
		assertEquals(evt.getNom(), evenement.getNomEvenement());
		assertEquals(evt.getDateDebut(), evenement.getDateDebutPrevue());
		assertEquals(evt.getDateFin(), evenement.getDateFinPrevue());
		assertEquals(evt.getSalle(), "Salle Gide");
		assertEquals(evt.getDescription(), evenement.getPropositionPresentation().getDescription());
		assertEquals(evt.getSommaire(), evenement.getPropositionPresentation().getSommaire());
		assertEquals(evt.getSpeakersId().length(), "12,13".length());
		assertEquals(evt.getSujets(), "sujet1,sujet2,sujet3");
		assertEquals(evt.getMotCle(), evenement.getPropositionPresentation().getMotCle()
				.getMotCle());
	}

	/**
	 * @return un objet evenement exemple.
	 */
	private Evenement getEvenement() {
		Evenement evt = new Evenement();
		evt.setId(12l);
		evt.setNomEvenement("Cours sur Android");
		Calendar dateDebut = Calendar.getInstance();
		dateDebut.set(1900, 3, 13);
		evt.setDateDebutPrevue(dateDebut);

		Calendar dateFin = Calendar.getInstance();
		dateFin.set(1902, 3, 13);
		evt.setDateDebutPrevue(dateFin);

		PropositionPresentation propo = new PropositionPresentation();
		propo.setSommaire("Android Sommaire");
		propo.setDescription("Description propo");
		Set<Participant> participantList = new HashSet<Participant>();
		Participant auteur1 = new Participant();
		auteur1.setId(Long.valueOf(12));
		auteur1.setEmail("email1@jcertif.com");
		participantList.add(auteur1);
		Participant auteur2 = new Participant();
		auteur2.setId(Long.valueOf(13));
		auteur2.setEmail("email2@jcertif.com");
		participantList.add(auteur2);
		propo.setMotCle(new MotCle("code", "libelle"));
		propo.addSujet(new Sujet("sujet1", "sujet desc 1"));
		propo.addSujet(new Sujet("sujet2", "sujet desc 1"));
		propo.addSujet(new Sujet("sujet3", "sujet desc 1"));
		propo.setParticipants(participantList);
		evt.setPropositionPresentation(propo);

		Set<CeduleSalle> ceduleSalleList = new HashSet<CeduleSalle>();
		CeduleSalle cedule1 = new CeduleSalle();
		cedule1.setSalle(new Salle("Salle Gide", "Salle Gide"));
		ceduleSalleList.add(cedule1);
		evt.setCeduleSalles(ceduleSalleList);

		evt.setDetails("description");

		return evt;
	}
}

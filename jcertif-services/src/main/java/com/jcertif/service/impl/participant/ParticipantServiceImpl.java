/**
 * 
 */
package com.jcertif.service.impl.participant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.api.participant.ParticipantDAO;
import com.jcertif.dao.api.participant.ProfilUtilisateurDAO;
import com.jcertif.exception.ExistingEmailException;
import com.jcertif.service.AbstractService;
import com.jcertif.service.api.participant.ParticipantService;

/**
 * Implementation of the {@link ParticipantService}.
 * 
 * @author Bernard Adanlessossi
 * 
 */
@Service
public class ParticipantServiceImpl extends AbstractService<Participant, Long, ParticipantDAO>
		implements ParticipantService {

	@Autowired
	private ParticipantDAO participantDAO;

	@Autowired
	private ProfilUtilisateurDAO profilUtilisateurDAO;

	@Override
	public ParticipantDAO getDAO() {
		return participantDAO;
	}

	@Override
	public void setDAO(ParticipantDAO participantDAO) {
		this.participantDAO = participantDAO;
	}

	@Override
	@Transactional
	public Participant save(Participant entite) {
		List<Participant> partList = participantDAO.findByEmail(entite.getEmail());
		if (partList.size() != 0) {
			throw new ExistingEmailException();
		}

		// Setting default inscription date
		entite.setDateInscription(Calendar.getInstance());

		if (entite.getProfilUtilisateur() != null) {

			// Synchronisation de l'adresse email
			if (entite.getProfilUtilisateur().getEmail() != null) {
				entite.setEmail(entite.getProfilUtilisateur().getEmail());
			}

			// Cryptage du mot de passe en MD5
			String key = entite.getProfilUtilisateur().getPassword();
			if (key != null) {
				entite.getProfilUtilisateur().setPassword(getEncodedPassword(key));
			}

			profilUtilisateurDAO.persist(entite.getProfilUtilisateur());
		}
		return super.save(entite);

	}

	public String getEncodedPassword(String key) {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		StringBuilder hashString = new StringBuilder();
		for (int i = 0; i < hash.length; ++i) {
			hashString.append(hash[i]);
		}
		return hashString.toString();
	}

	@Override
	public Participant update(Participant entite) {
		return super.update(entite);
	}

	@Override
	public List<Participant> findByEmail(String email) {
		return participantDAO.findByEmail(email);
	}

	@Override
	public List<Participant> findAllWithProposition() {
		List<Participant> participants = participantDAO.findAll();

		if (participants != null && !participants.isEmpty()) {
			for (Participant participant : participants) {

				if (participant.getPropositionPresentations() != null
						&& !participant.getPropositionPresentations().isEmpty()) {
					participant.getPropositionPresentations().iterator().next();
				}
			}
		}
		return participants;
	}
}

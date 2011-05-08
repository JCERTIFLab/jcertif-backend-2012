package com.jcertif.presentation.wsClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jcertif.presentation.cache.UICacheManager;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.ui.util.UIConst;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * Jersey REST client generated for REST resource:ParticipantFacade
 * [/participants]<br>
 * USAGE:
 * 
 * <pre>
 *        ParticipantClient client = new ParticipantClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 * 
 * @author Douneg
 */

public class ParticipantClient extends
		AbstractJCertWebServiceClient<Participant, Long> {

	/**
	 * The unique instance.
	 */
	private ParticipantClient() {
		super("participant");
	}

	private static ParticipantClient instance;

	public static synchronized ParticipantClient getInstance() {
		if (instance == null) {
			instance = new ParticipantClient();
		}
		return instance;
	}

	@Override
	public List<Participant> findAll_JSON() throws UniformInterfaceException,
			ClientHandlerException {
		return getWebResource().path(FINDALL_SUFFIX)
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Participant>>() {
				});

	}

	@Override
	public List<Participant> findAllXML() throws UniformInterfaceException,
			ClientHandlerException {
		List<Participant> participants = UICacheManager.getInstance()
				.getParticipant();

		if (participants == null) {
			participants = getWebResource().path(FINDALL_SUFFIX)
					.accept(javax.ws.rs.core.MediaType.APPLICATION_XML)
					.get(new GenericType<List<Participant>>() {
					});
			UICacheManager.getInstance().putParticipant(participants);
		}
		return participants;
	}

	public List<Participant> getSponsors() {
		List<Participant> partnersList = new ArrayList<Participant>();
		Set<Participant> participants = new HashSet<Participant>(findAllXML());

		for (Participant participant : participants) {
			if (participant.getRoleparticipant() != null
					&& "Partenaire".equalsIgnoreCase(participant
							.getRoleparticipant().getCode())) {
				partnersList.add(participant);
			}
		}
		return partnersList;
	}

	/**
	 * Attention les sponsors qui n'ont pas de niveau sont exclus.
	 * 
	 * @return
	 */
	public List<Participant> getSponsorsSortedByNiveau() {
		Set<Participant> participants = new HashSet<Participant>(findAllXML());

		List<Participant> participantSorted = new ArrayList<Participant>();

		for (Participant participant : participants) {
			if (participant.getRoleparticipant() != null
					&& "Partenaire".equalsIgnoreCase(participant
							.getRoleparticipant().getCode())
					&& participant.getNiveauPartenariat() != null) {
				participantSorted.add(participant);
			}
		}

		Collections.sort(participantSorted, new Comparator<Participant>() {

			@Override
			public int compare(Participant o1, Participant o2) {
				// TODO Auto-generated method stub
				return o1.getNiveauPartenariat().compareTo(
						o2.getNiveauPartenariat());
			}
		});

		return participantSorted;
	}

	public List<Participant> getSpeakersValid() {
		List<Participant> presentateursList = new ArrayList<Participant>();

		Set<Participant> participants = new HashSet<Participant>(findAllXML());
		for (Participant participant : participants) {
			if (isApeaker(participant)) {
				presentateursList.add(participant);
			}
		}
		return presentateursList;
	}

	// En plus du role Presentateur, un speaker doit avoir au moins une
	// porposition de presentation approuvee en attente de complement
	private boolean isApeaker(Participant part) {
		if (part.getPropositionPresentations() != null
				&& part.getRoleparticipant() != null
				&& UIConst.ROLE_SPEAKER.equalsIgnoreCase(part
						.getRoleparticipant().getCode())) {
			for (PropositionPresentation popos : part
					.getPropositionPresentations()) {
				if ("C".equalsIgnoreCase(popos.getStatutApprobation()
						.getCodeStatut())
						|| "A".equalsIgnoreCase(popos.getStatutApprobation()
								.getCodeStatut())) {
					return true;
				}
			}
		}
		return false;
	}

	// Récupération des partenaires
	public List<Participant> getOrganizersList() {
		List<Participant> organizerList = new ArrayList<Participant>();
		Set<Participant> participants = new HashSet<Participant>(
				ParticipantClient.getInstance().findAllXML());

		for (Participant participant : participants) {
			if (participant.getRoleparticipant() != null
					&& (UIConst.ROLE_ORGANIZER.equalsIgnoreCase(participant
							.getRoleparticipant().getCode()) || UIConst.TYPE_STAFF
							.equalsIgnoreCase(participant.getTypeParticipant()
									.getCode()))) {
				organizerList.add(participant);
			}
		}
		return organizerList;
	}

	// Récupération des communautés
	public List<Participant> getCommunitiesList() {
		List<Participant> communityList = new ArrayList<Participant>();
		Set<Participant> participants = new HashSet<Participant>(
				ParticipantClient.getInstance().findAllXML());

		for (Participant participant : participants) {
			if (participant.getRoleparticipant() != null
					&& (UIConst.TYPE_COMM.equalsIgnoreCase(participant
							.getTypeParticipant().getCode()) && UIConst.TYPE_VALID
							.equalsIgnoreCase(participant.getCodeParticipant()))) {
				communityList.add(participant);
			}
		}
		return communityList;
	}

	/**
	 * Return true if this email is already used.
	 * 
	 * @param email
	 *            a email adress
	 */
	public boolean isEmailExist(String email) {
		boolean isEmailExist = false;
		List<Participant> participantList = getWebResource().path(
				"/listByEmail/" + email).get(
				new GenericType<List<Participant>>() {
				});
		isEmailExist = !participantList.isEmpty();
		return isEmailExist;
	}

	public Participant findByEmail(String email) {
		Participant participant = null;
		List<Participant> participantList = getWebResource().path(
				"/listByEmail/" + email).get(
				new GenericType<List<Participant>>() {
				});

		if (!participantList.isEmpty()) {
			participant = participantList.iterator().next();
		}
		return participant;
	}

	public void store(File file, String role, Long idParticipant, String ext)
			throws UniformInterfaceException, FileNotFoundException {
		getWebResource().path(
				"/store/" + role + "/" + idParticipant + "/" + ext).post(
				new FileInputStream(file));
	}
}

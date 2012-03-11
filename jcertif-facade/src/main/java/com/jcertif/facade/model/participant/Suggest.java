package com.jcertif.facade.model.participant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.jcertif.bo.AbstractBO;
import com.jcertif.bo.conference.Conference;
import com.jcertif.bo.participant.Participant;
import com.jcertif.bo.presentation.MotCle;
import com.jcertif.bo.presentation.PropositionPresentation;
import com.jcertif.bo.presentation.StatutApprobation;
import com.jcertif.bo.presentation.Sujet;

/**
 * Bo {@link Suggest}.
 * 
 * @author rossi.oddet
 * 
 */
@Entity
@XmlRootElement
public class Suggest extends AbstractBO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String description;
	private String summary;
	private String needs;
	private String keyword;
	private Long conferenceId;
	private String codeStatut;
	private List<Long> sujetIds;
	private List<Long> participantIds;

	public Suggest(final PropositionPresentation proposition) {
		id = proposition.getId();
		title = proposition.getTitre();
		description = proposition.getDescription();
		summary = proposition.getSommaire();
		needs = proposition.getBesoinsSpecifiques();
		if (proposition.getMotCle() != null) {
			keyword = proposition.getMotCle().getMotCle();
		}
		conferenceId = proposition.getConference().getId();

		if (proposition.getStatutApprobation() != null) {
			codeStatut = proposition.getStatutApprobation().getCodeStatut();
		}

		if (proposition.getSujets() != null) {
			sujetIds = new ArrayList<Long>();
			for (Sujet sujet : proposition.getSujets()) {
				sujetIds.add(sujet.getId());
			}
		}

		participantIds = new ArrayList<Long>();
		for (Participant participant : proposition.getParticipants()) {
			participantIds.add(participant.getId());
		}

	}

	public PropositionPresentation toProposition() {
		final PropositionPresentation proposition = new PropositionPresentation();
		proposition.setId(id);
		proposition.setTitre(title);
		proposition.setDescription(description);
		proposition.setSommaire(summary);
		proposition.setBesoinsSpecifiques(needs);
		if (keyword != null) {
			MotCle motCle = new MotCle();
			motCle.setMotCle(keyword);
			proposition.setMotCle(motCle);
		}

		if (conferenceId != null) {
			Conference conf = new Conference();
			conf.setId(conferenceId);
			proposition.setConference(conf);
		}

		if (codeStatut != null) {
			StatutApprobation statut = new StatutApprobation();
			statut.setCodeStatut(codeStatut);
			proposition.setStatutApprobation(statut);
		}

		if (sujetIds != null) {
			List<Sujet> sujets = new ArrayList<Sujet>();
			for (Long sujetId : sujetIds) {
				Sujet sujet = new Sujet();
				sujet.setId(sujetId);
				sujets.add(sujet);
			}
			proposition.setSujetsInternal(sujets);
		}

		if (participantIds != null) {
			Set<Participant> participants = new HashSet<Participant>();
			for (Long participantId : participantIds) {
				Participant participant = new Participant();
				participant.setId(participantId);
				participants.add(participant);
			}
			proposition.setParticipants(participants);

		}

		return proposition;

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the needs
	 */
	public String getNeeds() {
		return needs;
	}

	/**
	 * @param needs
	 *            the needs to set
	 */
	public void setNeeds(String needs) {
		this.needs = needs;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the conferenceId
	 */
	public Long getConferenceId() {
		return conferenceId;
	}

	/**
	 * @param conferenceId
	 *            the conferenceId to set
	 */
	public void setConferenceId(Long conferenceId) {
		this.conferenceId = conferenceId;
	}

	/**
	 * @return the codeStatut
	 */
	public String getCodeStatut() {
		return codeStatut;
	}

	/**
	 * @param codeStatut
	 *            the codeStatut to set
	 */
	public void setCodeStatut(String codeStatut) {
		this.codeStatut = codeStatut;
	}

	/**
	 * @return the sujetIds
	 */
	public List<Long> getSujetIds() {
		return sujetIds;
	}

	/**
	 * @param sujetIds
	 *            the sujetIds to set
	 */
	public void setSujetIds(List<Long> sujetIds) {
		this.sujetIds = sujetIds;
	}

	/**
	 * @return the participantIds
	 */
	public List<Long> getParticipantIds() {
		return participantIds;
	}

	/**
	 * @param participantIds
	 *            the participantIds to set
	 */
	public void setParticipantIds(List<Long> participantIds) {
		this.participantIds = participantIds;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(title).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Suggest)) {
			return false;
		}

		final Suggest other = (Suggest) obj;

		return new EqualsBuilder().append(title, other.getTitle())
				.append(description, other.getDescription()).isEquals();
	}

}

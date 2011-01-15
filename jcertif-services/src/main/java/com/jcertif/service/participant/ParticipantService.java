/**
 * 
 */
package com.jcertif.service.participant;

import java.util.List;
import java.util.Set;

import com.jcertif.bo.CeduleParticipant;
import com.jcertif.bo.Conference;
import com.jcertif.bo.Participant;
import com.jcertif.bo.RoleParticipant;

/**
 * Service Layer for the {@link Participant}.
 * @author Bernard Adanlessossi
 *
 */
public interface ParticipantService {
	
	/**
	 * Creates a new {@link Participant}.
	 * @param id the id
	 * @param dateinscription the registration date
	 * @param salutation the salutation
	 * @param specialite the speciality
	 * @param prenom the first name
	 * @param nom the last name
	 * @param sexe the sex
	 * @param email the email
	 * @param presentationsoumise the submitted paper
	 * @param cvsoumis the submitted curriculum
	 * @param details the details
	 * @param roleparticipant the role
	 * @param conference the conference
	 * @param ceduleparticipants the schedule
	 * @return the newly created {@link Participant}
	 */
	public Participant createParticipant(Long id, String dateinscription, String salutation,
			String specialite, String prenom, String nom, Character sexe,
			String email, String presentationsoumise,
			String cvsoumis, String details, RoleParticipant roleparticipant,
			Conference conference, Set<CeduleParticipant> ceduleparticipants);

	/**
	 * Find all {@link Participant}s.
	 * @return a list of all participants
	 */
	public List<Participant> findAll();
	
	/**
	 * Find a {@link Participant} by its key.
	 * @param key the key
	 * @return the participant or null if not found
	 */
	public Participant findById(Long key);
	
	/**
	 * Saves the given {@link Participant} into the database.
	 * @param participant the participant
	 * @return the saved participant if succeded
	 */
	public Participant save(Participant participant);
	
	/**
	 * Updates the {@link Participant}'s records.
	 * @param participant the participant
	 * @return the participant if succeded
	 */
	public Participant update(Participant participant);
	
	/**
	 * Removes the given {@link Participant} from the database.
	 * @param participant the participant
	 */
	public void remove(Participant participant);
}

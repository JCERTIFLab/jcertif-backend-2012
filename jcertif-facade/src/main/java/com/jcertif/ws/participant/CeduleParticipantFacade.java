package com.jcertif.ws.participant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.CeduleParticipant;
import com.jcertif.service.participant.CeduleParticipantService;
import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.inject.Inject;

/**
 * Facade pour service participant.
 * 
 * @author rossi.oddet
 * 
 */
@Path("cedule/participant")
@Service
@Autowire
public class CeduleParticipantFacade {

	/**
	 * The Logger.
	 */
	private Logger LOGGER = LoggerFactory
			.getLogger(CeduleParticipantFacade.class);

	/**
	 * Service CeduleParticipant.
	 */
	@Autowired
	private CeduleParticipantService ceduleParticipantService;

	/**
	 * @return all ceduleParticipant
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("find/all/")
	public List<CeduleParticipant> findAll() {
		LOGGER.debug("Calling Web Service /api/cedule/participant/find/all/");
		return ceduleParticipantService.findAll();
	}

	/**
	 * @return la liste des cedules d'un participant
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("find/by/participant/{idParticipant}/")
	public List<CeduleParticipant> findByParticipant(
			@PathParam("idParticipant") Long idParticipant) {
		LOGGER.debug(
				"Calling Web Service /api/cedule/participant/find/by/participant/{}/",
				idParticipant);
		return ceduleParticipantService.findByParticipant(idParticipant);
	}

	/**
	 * Sauvegarde d'une cedule participant.
	 * 
	 * @param idParticipant
	 * @param dateCedule
	 * @param details
	 * @param codeStatut
	 * @param idConference
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("create/{idParticipant}/{dateCedule}/{details}/{codeStatut}/{idEvent}")
	public CeduleParticipant saveNewCedule(
			@PathParam("idParticipant") Long idParticipant,
			@PathParam("dateCedule") String dateCedule,
			@PathParam("details") String details,
			@PathParam("codeStatut") String codeStatut,
			@PathParam("idEvent") Long idEvent) {
		LOGGER.debug(
				"Calling Web Service /api/cedule/participant/save/{}/{}/{}/{}/{}/{}",
				new Object[] { idParticipant, dateCedule, details, codeStatut,
						idEvent });
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
		Calendar ceduleCalendar = Calendar.getInstance();
		try {
			ceduleCalendar.setTime(dateFormat.parse(dateCedule));
		} catch (ParseException e) {
			LOGGER.error(
					"Impossible de parser la date avec le format dd:MM:yyy", e);
		}
		return ceduleParticipantService.createCedule(ceduleCalendar, details,
				idParticipant, idEvent, codeStatut);
	}

	/**
	 * Mise � jour d'une cedule.
	 * 
	 * @param idCedule
	 * @param idParticipant
	 * @param dateCedule
	 * @param details
	 * @param codeStatut
	 * @param idEvent
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("update/{idCedule}/{idParticipant}/{dateCedule}/{details}/{codeStatut}/{idEvent}")
	public CeduleParticipant updateCedule(@PathParam("idCedule") Long idCedule,
			@PathParam("idParticipant") Long idParticipant,
			@PathParam("dateCedule") String dateCedule,
			@PathParam("details") String details,
			@PathParam("codeStatut") String codeStatut,
			@PathParam("idEvent") Long idEvent) {
		LOGGER.debug(
				"Calling Web Service /api/cedule/participant/save/{}/{}/{}/{}/{}/{}/{}",
				new Object[] { idCedule, idParticipant, dateCedule, details,
						codeStatut, idEvent });
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
		Calendar ceduleCalendar = Calendar.getInstance();
		try {
			ceduleCalendar.setTime(dateFormat.parse(dateCedule));
		} catch (ParseException e) {
			LOGGER.error(
					"Impossible de parser la date avec le format dd:MM:yyy", e);
		}
		return ceduleParticipantService.updateCedule(idCedule, ceduleCalendar,
				details, idParticipant, idEvent, codeStatut);
	}

}

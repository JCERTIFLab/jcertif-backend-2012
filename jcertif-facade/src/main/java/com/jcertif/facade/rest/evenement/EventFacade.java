package com.jcertif.facade.rest.evenement;

import com.jcertif.bo.cedule.Evenement;
import com.jcertif.facade.Facade;
import com.jcertif.facade.model.IdList;
import com.jcertif.facade.model.evenement.Event;
import com.jcertif.service.api.cedule.EvenementService;
import com.sun.jersey.api.spring.Autowire;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Rest Service for Event.
 * @author rossi.oddet
 */
@Path("event")
@Service
@Autowire
public class EventFacade extends Facade {

    /**
     * Event service.
     */
    @Autowired
    private EvenementService eventService;

    /**
     * @return all events
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path(FINDALL_SUFFIX)
    public List<Event> findAll() {
        Set<Evenement> evenementList = new HashSet<Evenement>(eventService.findAll());

        List<Event> eventList = new ArrayList<Event>();

        for (Evenement ev : evenementList) {
            eventList.add(new Event(ev));
        }

        return eventList;
    }

    /**
     * 
     * @param idEvent
     * @param email
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/addevent/{idevent}/{email}")
    public IdList addUserToEvent(@PathParam("idevent") Long idEvent, @PathParam("email") String email) {
        return new IdList(eventService.addUserToEvent(idEvent, email));
    }
    
    /**
     * 
     * @param idEvent
     * @param email
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/removeevent/{idevent}/{email}")
    public IdList removeUserToEvent(@PathParam("idevent") Long idEvent, @PathParam("email") String email) {
        return new IdList(eventService.removeUserToEvent(idEvent, email));
    }
}

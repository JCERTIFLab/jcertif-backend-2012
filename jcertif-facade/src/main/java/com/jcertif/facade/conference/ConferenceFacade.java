package com.jcertif.facade.conference;

import com.jcertif.bo.conference.Conference;
import java.util.List;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.conference.ConferenceService;
import com.sun.jersey.api.spring.Autowire;

/**
 * Facade pour service participant.
 * 
 * @author Douneg
 * 
 */
@Path("conference")
@Service
@Autowire
public class ConferenceFacade extends AbstractFacade<ConferenceService, Conference, Long> {

    @Autowired
    private ConferenceService service;

    @Override
    public ConferenceService getService() {
        return service;
    }

    @Override
    public void setService(ConferenceService service) {
        this.service = service;
    }

    @Override
    public Conference create(Conference entity) {
        return super.create(entity);
    }

    @Override
    public Conference delete(Conference profil) {
        return super.delete(profil);
    }

    @Override
    public List<Conference> findAll() {
        return super.findAll();
    }

    @Override
    public Conference findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Conference update(Conference profil) {
        return super.update(profil);
    }
}

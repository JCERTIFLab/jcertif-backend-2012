/**
 * 
 */
package com.jcertif.facade.conference;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.conference.Faq;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.conference.FaqService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi
 *
 */
@Path("faq")
@Service
@Autowire
public class FaqFacade extends AbstractFacade<FaqService, Faq, Long> {

    @Autowired
    private FaqService service;

    @Override
    public FaqService getService() {
        return service;
    }

    @Override
    public void setService(FaqService service) {
        this.service = service;
    }

}

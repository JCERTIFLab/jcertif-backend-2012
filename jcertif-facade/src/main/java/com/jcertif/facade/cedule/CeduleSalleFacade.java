/**
 * 
 */
package com.jcertif.facade.cedule;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcertif.bo.cedule.CeduleSalle;
import com.jcertif.facade.AbstractFacade;
import com.jcertif.service.api.cedule.CeduleSalleService;
import com.sun.jersey.api.spring.Autowire;

/**
 * @author rossi.oddet
 *
 */
@Path("cedulesalle")
@Service
@Autowire
public class CeduleSalleFacade extends
AbstractFacade<CeduleSalleService, CeduleSalle, Long>{
	
	@Autowired
	private CeduleSalleService ceduleSalleService;

	@Override
	public CeduleSalleService getService() {
		return ceduleSalleService;
	}

	@Override
	public void setService(CeduleSalleService service) {
		this.ceduleSalleService = service;
	}

}

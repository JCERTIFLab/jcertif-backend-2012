package com.jcertif.facade;

/**
 * Base class for all facades.
 * 
 * @author rossi.oddet
 * 
 */
public abstract class AbstractFacade {
	
    protected final static String CREATE_SUFFIX = "/create";
    protected final static String FINDBYID_SUFFIX = "/{id}";
    protected final static String FINDALL_SUFFIX = "/list";
    protected final static String UPDATE_SUFFIX = "/update";
    protected final static String DELETE_SUFFIX = "/delete";
  
}

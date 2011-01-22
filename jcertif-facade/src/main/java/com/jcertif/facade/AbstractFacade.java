package com.jcertif.facade;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jcertif.service.GenericService;

/**
 * Base class for all facades.
 * 
 * @author rossi.oddet
 * @param <T>
 * 
 */
public abstract class AbstractFacade<S extends GenericService<T, PK, ?>, T, PK extends Serializable> {
	protected static final String CREATE_SUFFIX = "/create";
	protected static final String FINDBYID_SUFFIX = "/{id}";
	protected static final String FINDALL_SUFFIX = "/list";
	protected static final String UPDATE_SUFFIX = "/update";
	protected static final String DELETE_SUFFIX = "/delete";

	/**
	 * 
	 * @return list des entites
	 */
	public abstract S getService();

	public abstract void setService(S service);

	/**
	 * Creates a entity.
	 * 
	 * @param profil
	 *            un profil
	 * @return le profil utili
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(CREATE_SUFFIX)
	public T create(T entity) {
		return getService().save(entity);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(UPDATE_SUFFIX)
	public T update(T profil) {
		return getService().update(profil);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(DELETE_SUFFIX)
	public T delete(T profil) {
		getService().remove(profil);
		return profil;
	}

	/**
	 * @return the list of T.
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDALL_SUFFIX)
	public List<T> findAll() {
		return getService().findAll();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(FINDBYID_SUFFIX)
	public T findById(@PathParam("id") PK id) {
		return getService().findById(id);
	}

}

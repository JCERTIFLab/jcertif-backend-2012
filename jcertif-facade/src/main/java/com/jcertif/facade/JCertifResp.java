package com.jcertif.facade;

import java.util.List;
import java.util.Vector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.bo.participant.Participant;

@XmlRootElement(name = "List")
@Path("jcertifresp")
public class JCertifResp<T> {

	protected List<T> list;

	public JCertifResp() {
	}

	public JCertifResp(List<T> list) {
		this.list = list;
	}

	@XmlElement(name = "Item")
	public List<T> getList() {
		return list;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/test2")
	public JCertifResp test2() {
		List list = new Vector();
		list.add("a");
		list.add("b");
		return new JCertifResp(list);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/test1")
	public JCertifResp test1() {
		List list = new Vector();
		list.add(getPart());
		list.add(getPart());
		return new JCertifResp(list);
	}
	
	private Participant getPart(){
		Participant part = new Participant();
		part.setId(Long.valueOf(4));
		part.setEmail("jaxb@menerve.com");
		return part;
	}
}

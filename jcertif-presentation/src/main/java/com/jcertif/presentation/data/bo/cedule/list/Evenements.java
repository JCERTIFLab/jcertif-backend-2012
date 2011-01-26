package com.jcertif.presentation.data.bo.cedule.list;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.presentation.data.bo.cedule.Evenement;
/**
 * 
 * @author Badr
 *
 */
@XmlRootElement
public class Evenements {
	protected List<Evenement> events =  new ArrayList<Evenement>();
	
	public Evenements() {
	
	}
	
	public Evenements(List<Evenement> evenements) {
		this.events = evenements;
	}
	
	@XmlElement(name = "evenement")
	public List<Evenement> getEvenements() {
		return events;
	}
	
	
}

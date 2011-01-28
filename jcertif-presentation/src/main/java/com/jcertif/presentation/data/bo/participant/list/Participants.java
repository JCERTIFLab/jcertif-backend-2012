package com.jcertif.presentation.data.bo.participant.list;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.presentation.data.bo.participant.Participant;

/**
 * The collection of all {@link Participant}'s.
 * 
 * @author Bernard Adanlessossi
 *
 */
@XmlRootElement
public class Participants {

	List<Participant> participants = new ArrayList<Participant>();
	
	public Participants(){
		super();
	}
	
	public Participants(List<Participant> participants){
		this.participants = participants;
	}
	
	@XmlElement(name="participant")
	public List<Participant> getParticipants(){
		return this.participants;
	}
}

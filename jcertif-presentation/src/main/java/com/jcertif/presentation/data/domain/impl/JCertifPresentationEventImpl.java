package com.jcertif.presentation.data.domain.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.JCertifPresentationKind;
import com.jcertif.presentation.data.domain.JCertifSpeaker;

public class JCertifPresentationEventImpl implements JCertifPresentation {

	private int id;
    private Date fromTime;
    private Date toTime;
    private String code;
    private String type;
    private String title;
    private String room;
    
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public JCertifPresentationKind getKind() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPartnerSlot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Date getFromTime() {
		// TODO Auto-generated method stub
		return fromTime;
	}

	@Override
	public Date getToTime() {
		// TODO Auto-generated method stub
		return toTime;
	}

	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public String getRoom() {
		// TODO Auto-generated method stub
		return room;
	}

	@Override
	public String getRoomExtraInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public List<JCertifSpeaker> getSpeakers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSummary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExperience() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getTags() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	
	

}

package com.jcertif.presentation.util;

import com.vaadin.addon.calendar.event.BasicEvent;

public class JCertifCalendarEvent extends BasicEvent {

    private static final long serialVersionUID = 2820133201983036866L;
    
    private String room;

	private Object data;
    
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        fireEventChange();
    }
}

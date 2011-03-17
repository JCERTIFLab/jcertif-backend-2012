package com.jcertif.bo.facade;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.jcertif.bo.participant.Participant;

/**
 * Réponse JCERTIF.
 * 
 * @author rossi
 * 
 */
@XmlRootElement
@XmlSeeAlso(Participant.class)
public class JCertifResponse {
	
	private Error error;
	private Object result;
	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}
	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
	
	

}

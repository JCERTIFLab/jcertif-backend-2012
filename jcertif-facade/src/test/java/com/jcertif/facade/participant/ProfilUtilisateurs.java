package com.jcertif.facade.participant;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.bo.participant.ProfilUtilisateur;

/**
 * TODO Voir s'il faut le mettre dans BO ou pas.
 * 
 * @author rossi.oddet
 * 
 */
@XmlRootElement
public class ProfilUtilisateurs {

	protected List<ProfilUtilisateur> profils = new ArrayList<ProfilUtilisateur>();

	public ProfilUtilisateurs() {
	}

	public ProfilUtilisateurs(List<ProfilUtilisateur> profils) {
		this.profils = profils;
	}

	@XmlElement(name = "profilUtilisateur")
	public List<ProfilUtilisateur> getProfilUtilisateurs() {
		return profils;
	}

}

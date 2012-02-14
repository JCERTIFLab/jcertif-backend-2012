package com.jcertif.facade.model.participant;

import javax.xml.bind.annotation.XmlRootElement;

import com.jcertif.bo.participant.Participant;

/**
 * BO Sponsor.
 * 
 * @author rossi.oddet
 */
@XmlRootElement
public class Sponsor {

	private Long id;
	private String nom;
	private String codeType;
	private String codeRole;
	private String codeNiveauPartenariat;
	private String presentation;
	private String siteWeb;
	private Long idConference;
	private String photo;

	/**
	 * A constructor.
	 */
	public Sponsor() {
		super();
	}

	/**
	 * @param part
	 */
	public Sponsor(Participant part) {
		this.id = part.getId();
		this.nom = part.getNom();
		this.codeType = part.getTypeParticipant().getCode();
		this.codeRole = part.getRoleparticipant().getCode();
		this.codeNiveauPartenariat = part.getNiveauPartenariat().getCode();
		this.presentation = part.getDetails();
		this.siteWeb = part.getWebsite();
		if (part.getConference() != null) {
			this.idConference = part.getConference().getId();
		}
		if (part.getProfilUtilisateur() != null) {
			this.photo = part.getProfilUtilisateur().getPhoto();
		}

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * @param codeType
	 *            the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/**
	 * @return the codeRole
	 */
	public String getCodeRole() {
		return codeRole;
	}

	/**
	 * @param codeRole
	 *            the codeRole to set
	 */
	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}

	/**
	 * @return the codeNiveauPartenariat
	 */
	public String getCodeNiveauPartenariat() {
		return codeNiveauPartenariat;
	}

	/**
	 * @param codeNiveauPartenariat
	 *            the codeNiveauPartenariat to set
	 */
	public void setCodeNiveauPartenariat(String codeNiveauPartenariat) {
		this.codeNiveauPartenariat = codeNiveauPartenariat;
	}

	/**
	 * @return the presentation
	 */
	public String getPresentation() {
		return presentation;
	}

	/**
	 * @param presentation
	 *            the presentation to set
	 */
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	/**
	 * @return the siteWeb
	 */
	public String getSiteWeb() {
		return siteWeb;
	}

	/**
	 * @param siteWeb
	 *            the siteWeb to set
	 */
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the idConference
	 */
	public Long getIdConference() {
		return idConference;
	}

	/**
	 * @param idConference
	 *            the idConference to set
	 */
	public void setIdConference(Long idConference) {
		this.idConference = idConference;
	}

}

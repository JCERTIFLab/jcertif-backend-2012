package com.jcertif.bo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author Douneg
 */
@Entity
@XmlRootElement
public class Evenement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    protected String nom_evenement;
    @Column
    private Calendar date_debut_prevue;
    @Column
    private Calendar date_fin_prevue;
    @Column
    private Calendar date_debut_effective;
    @Column
    private Calendar date_fin_effective;
    @Column
    private String details;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_evenement_id")
    private TypeEvenement typeEvenement;

    /**
	 * @param id
	 * @param nom_evenement
	 * @param date_debut_prevue
	 * @param date_fin_prevue
	 * @param date_debut_effective
	 * @param date_fin_effective
	 * @param details
	 * @param typeEvenement
	 */
	public Evenement(Long id, String nom_evenement, Calendar date_debut_prevue,
			Calendar date_fin_prevue, Calendar date_debut_effective,
			Calendar date_fin_effective, String details) {
		super();
		this.id = id;
		this.nom_evenement = nom_evenement;
		this.date_debut_prevue = date_debut_prevue;
		this.date_fin_prevue = date_fin_prevue;
		this.date_debut_effective = date_debut_effective;
		this.date_fin_effective = date_fin_effective;
		this.details = details;
	}

	/**
	 * 
	 */
	public Evenement() {
		super();
	}

	/**
     * Get the value of typeEvenement
     *
     * @return the value of typeEvenement
     */
    public TypeEvenement getTypeEvenement() {
        return typeEvenement;
    }

    /**
     * Set the value of typeEvenement
     *
     * @param details new value of typeEvenement
     */
    public void setTypeEvenement(TypeEvenement typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    /**
     * Get the value of details
     *
     * @return the value of details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set the value of details
     *
     * @param details new value of details
     */
    public void setDetails(String details) {
        this.details = details;
    }
    
    /**
     * Get the value of date_fin_prevue
     *
     * @return the value of date_fin_prevue
     */
    public Calendar getDate_fin_prevue() {
        return date_fin_prevue;
    }

    /**
     * Set the value of date_fin_prevue
     *
     * @param date_fin_prevue new value of date_fin_prevue
     */
    public void setDate_fin_prevue(Calendar date_fin_prevue) {
        this.date_fin_prevue = date_fin_prevue;
    }

    /**
     * Get the value of date_debut_prevue
     *
     * @return the value of date_debut_prevue
     */
    public Calendar getDate_debut_prevue() {
        return date_debut_prevue;
    }

    /**
     * Set the value of date_debut_prevue
     *
     * @param date_debut_prevue new value of date_debut_prevue
     */
    public void setDate_debut_prevue(Calendar date_debut_prevue) {
        this.date_debut_prevue = date_debut_prevue;
    }

    /**
     * Get the value of date_fin_effective
     *
     * @return the value of date_fin_effective
     */
    public Calendar getDate_fin_effective() {
        return date_fin_effective;
    }

    /**
     * Set the value of date_fin_effective
     *
     * @param date_fin_prevue new value of date_fin_effective
     */
    public void setDate_fin_effective(Calendar date_fin_effective) {
        this.date_fin_effective = date_fin_effective;
    }

    /**
     * Get the value of date_debut_effective
     *
     * @return the value of date_debut_effective
     */
    public Calendar getDate_debut_effective() {
        return date_debut_effective;
    }

    /**
     * Set the value of date_debut_effective
     *
     * @param date_debut_prevue new value of date_debut_effective
     */
    public void setDate_debut_effective(Calendar date_debut_effective) {
        this.date_debut_effective = date_debut_effective;
    }

    /**
     * Get the value of nom_evenement
     *
     * @return the value of nom_evenement
     */
    public String getNom_evenement() {
        return nom_evenement;
    }

    /**
     * Set the value of nom_evenement
     *
     * @param nom_evenement new value of nom_evenement
     */
    public void setNom_evenement(String nom_evenement) {
        this.nom_evenement = nom_evenement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).append(this.getDetails()).append(this.getNom_evenement())
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Evenement)) {
			return false;
		}

		final Evenement other = (Evenement) obj;

		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getDetails(), other.getDetails()).append(this.getNom_evenement(), other.getNom_evenement()).isEquals();
	}



    }
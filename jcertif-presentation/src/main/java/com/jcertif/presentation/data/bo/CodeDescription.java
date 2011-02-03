package com.jcertif.presentation.data.bo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public abstract class CodeDescription extends AbstractBO {

    private static final long serialVersionUID = 1L;
    /**
     * Identifiant du statut cedule.
     */
    private Long id;
    /**
     * Code du statut cedule.
     */
    private String code;
    /**
     * Description du statut cedule.
     */
    private String description;

    /**
     * @return l'identifiant du statut cedule.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit un identifiant du statut cedule.
     *
     * @param id
     *            un identifiant
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return le code du statut cedule.
     */
    public String getCode() {
        return code;
    }

    /**
     * Définit le code de statut cedule.
     *
     * @param code
     *            un code de statut cedule
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return la description du statut cedule
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description du statut cedule.
     *
     * @param description
     *            une description du statut cedule.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getCode()).toHashCode();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CodeDescription)) {
            return false;
        }

        final CodeDescription other = (CodeDescription) obj;

        return new EqualsBuilder().append(getCode(), other.getCode()).isEquals();
    }
}

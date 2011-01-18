package com.jcertif.presentation.data.domain.impl;

import com.jcertif.presentation.data.LazyLoad;
import com.jcertif.presentation.data.LazyLoadable;
import com.jcertif.presentation.data.domain.JCertifSpeaker;

/**
 * JCertifSpeaker implementation that uses lazy loading for certain details.
 * 
 * @see com.jcertif.presentation.data.LazyLoadable
 * @see com.jcertif.presentation.data.LazyLoad
 */
public final class JCertifSpeakerImpl implements JCertifSpeaker, LazyLoadable {

    private final int id;
    private final String name;
    private final String speakerUri;

    private volatile String imageUri;
    private volatile String bio;

    public JCertifSpeakerImpl(final int id, final String name, final String speakerUri) {
        this.id = id;
        this.name = name;
        this.speakerUri = speakerUri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @LazyLoad("imageURI")
    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(final String imageUri) {
        this.imageUri = imageUri;
    }

    @LazyLoad("bio")
    public String getBio() {
        return bio;
    }

    public void setBio(final String bio) {
        this.bio = bio;
    }

    public String getLazyLoadingUri() {
        return speakerUri;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof JCertifSpeaker))
            return false;

        final JCertifSpeaker other = (JCertifSpeaker) obj;
        if (id != other.getId())
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", " + name + "]";
    }
}

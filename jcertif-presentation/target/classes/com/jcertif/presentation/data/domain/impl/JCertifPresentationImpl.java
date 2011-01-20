package com.jcertif.presentation.data.domain.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.jcertif.presentation.data.LazyLoad;
import com.jcertif.presentation.data.LazyLoadable;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.data.domain.JCertifPresentationKind;
import com.jcertif.presentation.data.domain.JCertifSpeaker;

public class JCertifPresentationImpl implements JCertifPresentation, LazyLoadable {

    private final int id;
    private final Date fromTime;
    private final Date toTime;
    private final String code;
    private final String type;
    private final JCertifPresentationKind kind;
    private final String title;
    private final List<JCertifSpeaker> speakers;
    private final String room;
    private final boolean partnerSlot;
    private final String presentationUri;

    private volatile String summary;
    private volatile String track;
    private volatile String experience;
    private volatile Set<String> tags;

    public JCertifPresentationImpl(final int id, final Date fromTime, final Date toTime, final String code,
            final String type, final JCertifPresentationKind kind, final String title, final List<JCertifSpeaker> speakers,
            final String room, final boolean partnerSlot, final String presentationUri) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.code = code;
        this.type = type;
        this.kind = kind;
        this.title = title;
        this.speakers = speakers;
        this.room = room;
        this.partnerSlot = partnerSlot;
        this.presentationUri = presentationUri;
    }

    public String getType() {
        return type;
    }

    public JCertifPresentationKind getKind() {
        return kind;
    }

    public boolean isPartnerSlot() {
        return partnerSlot;
    }

    public int getId() {
        return id;
    }

    public Date getToTime() {
        return toTime;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public String getCode() {
        return code;
    }

    public String getRoom() {
        return room;
    }

    public String getRoomExtraInfo() {
        if (kind == JCertifPresentationKind.KEYNOTE) {
            return "(Overflow in rooms 5 and 4)";
        }
        return "";
    }

    public String getTitle() {
        return title;
    }

    public List<JCertifSpeaker> getSpeakers() {
        return speakers;
    }

    public String getLazyLoadingUri() {
        return presentationUri;
    }

    @LazyLoad("summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    @LazyLoad("track")
    public String getTrack() {
        return track;
    }

    public void setTrack(final String track) {
        this.track = track;
    }

    @LazyLoad("experience")
    public String getExperience() {
        return experience;
    }

    public void setExperience(final String experience) {
        this.experience = experience;
    }

    @LazyLoad("tags/name")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(final Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((fromTime == null) ? 0 : fromTime.hashCode());
        result = prime * result + id;
        result = prime * result + ((kind == null) ? 0 : kind.hashCode());
        result = prime * result + (partnerSlot ? 1231 : 1237);
        result = prime * result + ((presentationUri == null) ? 0 : presentationUri.hashCode());
        result = prime * result + ((room == null) ? 0 : room.hashCode());
        result = prime * result + ((speakers == null) ? 0 : speakers.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((toTime == null) ? 0 : toTime.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof JCertifPresentation))
            return false;

        final JCertifPresentation other = (JCertifPresentation) obj;

        // Can't use only the id since some "presentations" (breakfast,
        // registration, etc). don't have an id (always id == 0).
        if (id != other.getId())
            return false;

        if (fromTime == null) {
            if (other.getFromTime() != null)
                return false;
        } else if (!fromTime.equals(other.getFromTime()))
            return false;

        if (code == null) {
            if (other.getCode() != null)
                return false;
        } else if (!code.equals(other.getCode()))
            return false;

        if (kind != other.getKind())
            return false;

        if (partnerSlot != other.isPartnerSlot())
            return false;

        else if (room == null) {
            if (other.getRoom() != null)
                return false;
        } else if (!room.equals(other.getRoom()))
            return false;

        if (speakers == null) {
            if (other.getSpeakers() != null)
                return false;
        } else if (!speakers.equals(other.getSpeakers()))
            return false;

        if (title == null) {
            if (other.getTitle() != null)
                return false;
        } else if (!title.equals(other.getTitle()))
            return false;

        if (toTime == null) {
            if (other.getToTime() != null)
                return false;
        } else if (!toTime.equals(other.getToTime()))
            return false;

        if (type == null) {
            if (other.getType() != null)
                return false;
        } else if (!type.equals(other.getType()))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", " + title + "]";
    }

}

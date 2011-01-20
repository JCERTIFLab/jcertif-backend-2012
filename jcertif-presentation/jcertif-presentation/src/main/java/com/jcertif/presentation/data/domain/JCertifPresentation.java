package com.jcertif.presentation.data.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface JCertifPresentation {

    String getType();

    JCertifPresentationKind getKind();

    boolean isPartnerSlot();

    int getId();

    Date getFromTime();

    Date getToTime();

    String getCode();

    String getRoom();

    String getRoomExtraInfo();

    String getTitle();

    List<JCertifSpeaker> getSpeakers();

    String getSummary();

    String getTrack();

    String getExperience();

    Set<String> getTags();
}

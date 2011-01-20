package com.jcertif.presentation.data.domain;

public enum JCertifPresentationKind {

    REGISTRATION,
    TALK,
    LUNCH,
    BREAK,
    BREAKFAST,
    COFFEE_BREAK,
    KEYNOTE;

    public boolean isSpeak() {
        return this == KEYNOTE || this == TALK;
    }
}

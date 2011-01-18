package com.jcertif.presentation.data;

public class RestApiException extends Exception {

    private static final long serialVersionUID = 6513379930446993697L;

    public RestApiException() {
        super();
    }

    public RestApiException(final String message) {
        super(message);
    }

    public RestApiException(final Throwable cause) {
        super(cause);
    }
}

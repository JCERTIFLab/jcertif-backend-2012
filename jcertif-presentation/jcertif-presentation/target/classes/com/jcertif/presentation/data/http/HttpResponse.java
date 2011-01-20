package com.jcertif.presentation.data.http;

/**
 * Simple immutable HttpResponse representation with only response code and the response body.
 */
public class HttpResponse {

    private final int responseCode;
    private final String response;

    public HttpResponse(final int responseCode, final String response) {
        this.responseCode = responseCode;
        this.response = response;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponse() {
        return response;
    }
}

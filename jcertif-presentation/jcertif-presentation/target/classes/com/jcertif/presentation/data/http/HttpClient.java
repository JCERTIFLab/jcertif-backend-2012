package com.jcertif.presentation.data.http;

import java.io.IOException;

public interface HttpClient {

    /**
     * Http Get method.
     *
     * @param urlString the URL string
     * @return the HTTP response
     * @throws IOException
     */
    HttpResponse get(String urlString) throws IOException;

    /**
     * Http Post method.
     *
     * @param urlString the URL string
     * @param postData the data to post
     * @return
     * @throws IOException
     */
    int post(String urlString, String postData) throws IOException;
}

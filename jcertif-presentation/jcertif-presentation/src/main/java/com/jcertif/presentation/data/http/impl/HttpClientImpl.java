package com.jcertif.presentation.data.http.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import com.jcertif.presentation.data.http.HttpClient;
import com.jcertif.presentation.data.http.HttpResponse;

/**
 * A very simple HttpClient implementation.
 */
public class HttpClientImpl implements HttpClient {

    private static final String USER_AGENT = "VaadinJCertifApp";
    private static final String POST_CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";

    private final Logger logger = Logger.getLogger(getClass());

    /**
     * Does an HTTP GET from the given URL and returns the response as a String.
     * 
     * @param urlString
     * @return
     * @throws IOException
     */

    public HttpResponse get(final String urlString) throws IOException {
        if (logger.isDebugEnabled()) {
            logger.debug("HTTP GET: " + urlString);
        }

        final HttpURLConnection urlConnection = openURLConnection(urlString);

        try {
            final int responseCode = urlConnection.getResponseCode();

            if (logger.isDebugEnabled()) {
                logger.debug("Response code: " + responseCode);
            }

            final BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
            try {
                final StringBuilder result = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                    line = in.readLine();
                }
                return new HttpResponse(responseCode, result.toString());
            } finally {
                in.close();
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    /**
     * Does an HTTP POST to the given URL and returns the response code.
     * 
     * @param urlString
     * @param postData
     * @return response code
     * @throws IOException
     */
    public int post(final String urlString, final String postData) throws IOException {
        if (logger.isDebugEnabled()) {
            logger.debug("HTTP POST: " + urlString);
        }

        final HttpURLConnection urlConnection = openURLConnection(urlString);
        urlConnection.setRequestProperty("Content-Type", POST_CONTENT_TYPE);
        urlConnection.setDoOutput(true);

        try {
            final OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
            try {
                writer.write(postData);
                writer.flush();

                int responseCode = urlConnection.getResponseCode();

                if (logger.isDebugEnabled()) {
                    logger.debug("Response code: " + responseCode);
                }
                return responseCode;
            } finally {
                writer.close();
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    private HttpURLConnection openURLConnection(final String urlString) throws IOException {
        final URL url = new URL(urlString);
        final HttpURLConnection urlConnection = (HttpURLConnection) url .openConnection();
        urlConnection.setRequestProperty("User-Agent", USER_AGENT);
        return urlConnection;
    }
}

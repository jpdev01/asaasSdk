package io.github.jpdev.asaassdk.http;

import io.github.jpdev.asaassdk.exception.ConnectionException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ApacheHttpClient {

    private final String accessToken;
    private final CloseableHttpClient httpclient;
    private final static String ACCESS_TOKEN_HEADER = "access_token";

    public ApacheHttpClient(String acessToken, int timeout) {
        this.accessToken = acessToken;

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .setCookieSpec(CookieSpecs.STANDARD)
                .build();

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .build();

        httpclient = httpClient;
    }

    public Response get(String url) throws ConnectionException {
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader(ACCESS_TOKEN_HEADER, accessToken);
            CloseableHttpResponse response = httpclient.execute(httpGet);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != HttpStatus.SC_OK) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }

            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            return new Response(
                    responseBody,
                    response.getStatusLine().getStatusCode()
            );
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public Response delete(String url) {
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.addHeader(ACCESS_TOKEN_HEADER, accessToken);
            CloseableHttpResponse response = httpclient.execute(httpDelete);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != HttpStatus.SC_OK) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            return new Response(
                    responseBody,
                    response.getStatusLine().getStatusCode()
            );
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public Response post(String url, String body) throws ConnectionException {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(ACCESS_TOKEN_HEADER, accessToken);

            StringEntity entity = new StringEntity(body);
            httpPost.setEntity(entity);

            CloseableHttpResponse response = httpclient.execute(httpPost);

            StatusLine status = response.getStatusLine();

            if (status.getStatusCode() != HttpStatus.SC_OK && status.getStatusCode() != HttpStatus.SC_BAD_REQUEST) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }

            return new Response(
                    EntityUtils.toString(response.getEntity()),
                    response.getStatusLine().getStatusCode()
            );
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(HttpStatus.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    public Response put(String url, String body) throws ConnectionException {
        try {
            HttpPut httpPost = new HttpPut(url);
            httpPost.addHeader(ACCESS_TOKEN_HEADER, accessToken);

            StringEntity entity = new StringEntity(body);
            httpPost.setEntity(entity);

            CloseableHttpResponse response = httpclient.execute(httpPost);

            StatusLine status = response.getStatusLine();

            if (status.getStatusCode() != HttpStatus.SC_OK && status.getStatusCode() != HttpStatus.SC_BAD_REQUEST) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }

            return new Response(
                    EntityUtils.toString(response.getEntity()),
                    response.getStatusLine().getStatusCode()
            );
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(HttpStatus.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}

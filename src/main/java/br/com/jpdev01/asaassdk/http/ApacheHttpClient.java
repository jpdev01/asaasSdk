package br.com.jpdev01.asaassdk.http;

import br.com.jpdev01.asaassdk.exception.ConnectionException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApacheHttpClient {

    private final String accessToken;
    private final CloseableHttpClient httpclient;

    public ApacheHttpClient(String acessToken) {
        this.accessToken = acessToken;
        httpclient = HttpClients.createDefault();
    }

    public Response get(String url) throws ConnectionException {
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("access_token", accessToken);
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

    public String delete(String url) throws ConnectionException {
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.addHeader("access_token", accessToken);
            CloseableHttpResponse response = httpclient.execute(httpDelete);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != HttpStatus.SC_OK) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            return responseBody;
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public Response post(String url, String body) throws ConnectionException {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("access_token", accessToken);

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
            httpPost.addHeader("access_token", accessToken);

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

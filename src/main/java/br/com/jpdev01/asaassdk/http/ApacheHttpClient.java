package br.com.jpdev01.asaassdk.http;

import br.com.jpdev01.asaassdk.exception.ConnectionException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author jpdev01
 */
public class ApacheHttpClient {

    private final String accessToken;
    private final CloseableHttpClient httpclient;

    public ApacheHttpClient(String acessToken) {
        this.accessToken = acessToken;
        httpclient = HttpClients.createDefault();
    }

    public String get(String url) throws ConnectionException {
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("access_token", accessToken);
            CloseableHttpResponse response = httpclient.execute(httpGet);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != HttpStatus.SC_OK) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }

            HttpEntity entity = response.getEntity();
            String retorno = EntityUtils.toString(entity);

            return retorno;
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
        //return null;
    }

    public String delete(String url) throws ConnectionException {
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.addHeader("access_token", accessToken);
            CloseableHttpResponse response = httpclient.execute(httpDelete);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            String retorno = EntityUtils.toString(entity);
            //System.out.println(retorno);
            return retorno;
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


            if (status.getStatusCode() != 200 && status.getStatusCode() != 400) {
                System.out.println(status.getReasonPhrase());
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }

            return new Response(
                    EntityUtils.toString(response.getEntity()),
                    response.getStatusLine().getStatusCode()
            );
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClient.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}

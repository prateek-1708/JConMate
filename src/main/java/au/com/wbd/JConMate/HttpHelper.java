package au.com.wbd.JConMate;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by prateeknayak on 10/04/2016.
 */
public class HttpHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpHelper.class);

    private HttpHelper instance = null;

    protected HttpHelper () {}

    private CloseableHttpClient httpClient = null;

    public HttpHelper getInstance() {
        if (null == instance) {
            instance = new HttpHelper();
        }
        return instance;
    }

    public HttpResponse get() throws IOException {
        HttpGet request = new HttpGet("http://localhost:14001");
        return  execute(request);
    }

    public HttpResponse put() throws IOException {
        HttpPut request = new HttpPut("http://localhost:14001");
        return  execute(request);
    }

    public HttpResponse post() throws IOException {
        HttpPut request = new HttpPut("http://localhost:14001");
        return  execute(request);
    }

    private HttpResponse execute(HttpRequestBase request) throws IOException {
        try {
            httpClient = HttpClients.createDefault();
            return httpClient.execute(request);
        } catch (IOException e) {
            LOGGER.error("Exception raised while executing http request {}", e);
            throw e;
        } finally {
            httpClient.close();
        }
    }

    public void destroy() throws IOException {
        httpClient.close();
    }


}

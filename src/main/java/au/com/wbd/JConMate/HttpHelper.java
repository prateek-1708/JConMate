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
 * HttpHelper is a singleton utility class for our EtcdClient.
 * It does all the http heavy lifting for the client
 *
 *
 * Created by prateeknayak on 10/04/2016.
 */
public class HttpHelper {

    /**
     * Logger for the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpHelper.class);

    /**
     * Instance of this
     */
    private HttpHelper instance = null;

    /**
     * protected constructor to make it singleton
     */
    protected HttpHelper () {}

    /**
     *  HttpClient that will do the rest api calls for us
     */
    private CloseableHttpClient httpClient = null;

    /**
     * Public method to get the singleton instance of the class
     * @return HttpHelper
     */
    public HttpHelper getInstance() {
        if (null == instance) {
            instance = new HttpHelper();
        }
        return instance;
    }

    /**
     * HttpGet call used to perform get request on a URL
     * @return HttpResponse response from the get call
     * @throws IOException
     */
    public HttpResponse get() throws IOException {
        HttpGet request = new HttpGet("http://localhost:14001");
        return  execute(request);
    }

    /**
     * HttpPut call used to perform put request on a URL with resources
     * @return HttpResponse response from the put call
     * @throws IOException
     */
    public HttpResponse put() throws IOException {
        HttpPut request = new HttpPut("http://localhost:14001");
        return  execute(request);
    }

    /**
     * HttpPost call used to perform post request on a URL for a resource
     * @return HttpResponse response from the post call
     * @throws IOException
     */
    public HttpResponse post() throws IOException {
        HttpPut request = new HttpPut("http://localhost:14001");
        return  execute(request);
    }

    /**
     * Execute the actual http request and return the response
     *
     * @param request http request to be executed
     * @return HttpResponse response of the request
     * @throws IOException You know things don't always go right .. shit happens.
     */
    private HttpResponse execute(HttpRequestBase request) throws IOException {
        try {
            httpClient = HttpClients.createDefault();
            return httpClient.execute(request);
        } catch (IOException e) {
            LOGGER.error("Exception raised while executing http request {}", e);
            throw e;
        } finally {
            destroy();
        }
    }

    /**
     * This is madness ... now why would you close resources.
     * @throws IOException is it closed or is it not .. hmmmmmmmm
     */
    public void destroy() throws IOException {
        httpClient.close();
    }


}

package httpclient;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResponseGenerator {
    private final static String PATH_TO_REQUEST_XML = "src/main/resources/request-numbers-to-dollars.xml";
    private final static String URI = "http://www.dataaccess.com/webservicesserver/numberconversion.wso";

    public CloseableHttpResponse getResponse() {
        File requestFile = new File(PATH_TO_REQUEST_XML);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(URI);
        post.addHeader("Content-Type", "text/xml");
        try {
            post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
        } catch (FileNotFoundException e) {
            e.getLocalizedMessage();
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return response;
    }
}

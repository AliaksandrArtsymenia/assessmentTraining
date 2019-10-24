package httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResponseTest {
    private final static String PATH_TO_REQUEST_XML = "src/main/resources/request-numbers-to-dollars.xml";
    private final static String URI = "http://www.dataaccess.com/webservicesserver/numberconversion.wso";
    private final static String PATH_TO_RESPONSE_XML = "src/main/resources/response-numbers-to-dollars.xml";

    @Test
    public void validateResponse() {
        ResponseGenerator responseGenerator = new ResponseGenerator();
        CloseableHttpResponse response = responseGenerator.getResponse(PATH_TO_REQUEST_XML, URI);
        try {
            response.getEntity().writeTo(new FileOutputStream(PATH_TO_RESPONSE_XML));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

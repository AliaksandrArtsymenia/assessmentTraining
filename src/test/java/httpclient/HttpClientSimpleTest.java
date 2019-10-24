package httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
import java.io.IOException;

public class HttpClientSimpleTest {
    private static final String TAG_NAME = "m:NumberToDollarsResponse";
    private static final String EXPECTED_CONTENT = "two dollars";
    private static final int EXPECTED_STATUS_CODE = 200;
    private static final String EXPECTED_ATTRIBUTE = "http://schemas.xmlsoap.org/soap/envelope/";
    private String xmlResponse = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soap:Body>\n" +
            "    <m:NumberToDollarsResponse xmlns:m=\"http://www.dataaccess.com/webservicesserver/\">\n" +
            "      <m:NumberToDollarsResult>two dollars</m:NumberToDollarsResult>\n" +
            "    </m:NumberToDollarsResponse>\n" +
            "  </soap:Body>\n" +
            "</soap:Envelope>";

    @Test
    public void validateXmlResponse() {
        ResponseGenerator responseGenerator = new ResponseGenerator();
        CloseableHttpResponse response = responseGenerator.getResponse();

        Document doc = ResponseUtils.getDocumentFormResponse(response);
        String actualContent = ResponseUtils.getNodesContent(doc, TAG_NAME).get(0).replaceAll("(^\\s+)|(\\s+$)", "");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusLine().getStatusCode(), EXPECTED_STATUS_CODE);
        softAssert.assertEquals(actualContent, EXPECTED_CONTENT);
        softAssert.assertEquals(ResponseUtils.getNodeContent(doc), EXPECTED_CONTENT);
        softAssert.assertEquals(ResponseUtils.getNodeAttribute(doc), EXPECTED_ATTRIBUTE);
        softAssert.assertAll();
    }

    @Test
    public void validateModel() {
        ResponseUtils responseUtils = new ResponseUtils();
        try {
            System.out.println(responseUtils.unmarshal(xmlResponse));
        } catch (JAXBException | IOException | SOAPException e) {
            e.printStackTrace();
        }
    }
}
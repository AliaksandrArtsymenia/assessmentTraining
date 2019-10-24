package httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ResponseUtils {

    public static Document getDocumentFormResponse(CloseableHttpResponse response) {
        String stringXml;
        DocumentBuilder builder;
        Document doc = null;
        try {
            stringXml = EntityUtils.toString(response.getEntity());
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(stringXml)));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static String getNodeContent(Document doc) {
        return doc.getDocumentElement().getTextContent().trim();
    }

    public static String getNodeAttribute(Document doc) {
        return doc.getDocumentElement().getAttributes().item(0).getTextContent();
    }

    public static List<String> getNodesContent(Document doc, String tagName) {
        NodeList nodeList = doc.getElementsByTagName(tagName);
        List<String> nodesContent = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            nodesContent.add(nodeList.item(i).getTextContent());
        }
        return nodesContent;
    }

    public ResponseModel unmarshal(String xml) throws JAXBException, IOException, SOAPException {
        SOAPMessage message = MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream(xml.getBytes()));
        JAXBContext context = JAXBContext.newInstance(ResponseModel.class);
        return (ResponseModel) context.createUnmarshaller().unmarshal(message.getSOAPBody().extractContentAsDocument());
    }
}

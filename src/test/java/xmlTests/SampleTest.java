package xmlTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SampleTest {
    @Test
    public void validateRootElement() {
        Document doc = getDocFromFile("src/main/resources/SOAP-response.xml");
        Element rootElement = doc.getDocumentElement();
        String rootElementTagName = rootElement.getTagName();
        String envelopNameSpace = rootElement.getAttributes().item(0).getTextContent();
        String schemeTypeName = rootElement.getSchemaTypeInfo().getTypeName();
        rootElement.setAttribute("MustUnderstand", "1");
        printElementsAttributes(rootElement);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rootElementTagName, "soap:Envelope");
        softAssert.assertEquals(envelopNameSpace, "http://schemas.xmlsoap.org/soap/envelope/");
        softAssert.assertEquals(schemeTypeName, null);
        softAssert.assertAll();
    }

    @Test
    public void validateChildNodes() {
        Document doc = getDocFromFile("src/main/resources/SOAP-response.xml");
        Element rootElement = doc.getDocumentElement();
        NodeList childNodes = rootElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            System.out.println(childNodes.item(i).getNodeName());
            System.out.println(childNodes.item(i).getNodeType());
        }
    }

    @Test
    public void validateFirstChildNode() {
        Document doc = getDocFromFile("src/main/resources/SOAP-response.xml");
        NodeList resultNodes = doc.getElementsByTagName("results");
        for (int i = 0; i < resultNodes.getLength(); i++) {
            System.out.println(resultNodes.item(i).getNodeName() + " = " + resultNodes.item(i).getTextContent());
        }
        Node childNodes = resultNodes.item(0).getFirstChild();
        System.out.println(childNodes.getNodeName() + " = " + childNodes.getTextContent());
    }

    private void printElementsAttributes(Element element) {
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.println(element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
        }
    }

    private Document getDocFromFile(String filePath) {
        File file = new File(filePath);
        Document doc = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(file);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}

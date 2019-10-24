package jaxb;

import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbTest {
    @Test
    public void validateSchema() {
        try {
            JAXBContext context =JAXBContext.newInstance(Capi.class);
            Capi model = (Capi) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/svc_xseqnctrl_capi.xml"));
            System.out.println(model.toString());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

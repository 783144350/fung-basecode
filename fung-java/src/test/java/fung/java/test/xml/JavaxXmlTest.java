package fung.java.test.xml;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;

public class JavaxXmlTest {

    @Test
    public void testXmlParser() throws IOException, XMLStreamException {
        Resource resource = new ClassPathResource("test.xml", JavaxXmlTest.class);

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(resource.getInputStream());

        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                System.out.println(reader.getName());
            } else if (type == XMLStreamConstants.CHARACTERS) {
                System.out.println(reader.getText().trim());
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                System.out.println("/" + reader.getName());
            }

        }
    }

}

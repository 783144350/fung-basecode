package fung.util.test.xmlparser;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XmlParserTest {

    @Test
    public void testXmlParserSAX() throws IOException, ParserConfigurationException, SAXException {
        Resource resource = new ClassPathResource("test.xml", XmlParserTest.class);

        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(resource.getFile(), new MyDefaultHandler());


    }

}

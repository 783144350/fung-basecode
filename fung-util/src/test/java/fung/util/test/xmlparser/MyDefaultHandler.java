package fung.util.test.xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler extends DefaultHandler {

    @Override
    public void startDocument() {
        System.out.println("MyDefaultHandler.startDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("startElement -> ");
        System.out.println("uri: " + uri);
        System.out.println("localName: " + localName);
        System.out.println("qName: " + qName);
//        System.out.println("A");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("characters: " + new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("endElement -> ");
    }

    @Override
    public void endDocument() {
        System.out.println("MyDefaultHandler.endDocument");
    }

}

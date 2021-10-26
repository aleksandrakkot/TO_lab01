package main;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

public interface DataProvider {
    byte[] getData(String url) throws IOException, ParserConfigurationException, SAXException, TransformerConfigurationException;
}

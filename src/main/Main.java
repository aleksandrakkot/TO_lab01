package main;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

public class Main {
    private static Main instance = null;
    private Collection collection;
    private DataProvider dataProvider;
    private CollectionParse collectionParse;

    private Main() throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
        collectionParse = new XMLParse();
        dataProvider = new RemoteProvider();
        collectionParse.setData(dataProvider.getData("https://www.nbp.pl/kursy/xml/lasta.xml"));
        collection = collectionParse.createList();
    }

    public Collection getCollection() {
        return collection;
    }

    public static Main getInstance() throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
        if(instance == null)
        {
            instance = new Main();
        }
        return instance;
    }
}

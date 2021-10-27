package main;

import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class XMLParse implements CollectionParse {
    private byte[] data;

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public Collection createList() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<Waluta> waluty = new ArrayList<>();
        waluty.add(new Waluta("Złoty", 1, "PLN", 1.0f));  //dodajemy do listy złotówki

        try {
            var xml = new String(data, StandardCharsets.ISO_8859_1);  //konwertujemy na standart ISO_8859_1
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xml));
            var document = builder.parse(is);
            Element rootElement = document.getDocumentElement();
            var pozycje = rootElement.getElementsByTagName("pozycja");
            for (int i = 0; i < pozycje.getLength(); i++) {
                var item = pozycje.item(i);
                var text = item.getTextContent();   //wyciągamy text
                var elements = text.split("\n\\s+");  //usuwamy tabulatory i spacje
                waluty.add(new Waluta(elements[1],
                        Integer.parseInt(elements[2]),
                        elements[3],
                        Float.parseFloat(elements[4].replace(",", ".")))); //dodajemy do waluty nową walute
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return new Collection(waluty);
    }
}

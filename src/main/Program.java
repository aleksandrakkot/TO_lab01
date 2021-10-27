package main;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
        UserInput input = new UserInput();
        input.getDataFromUser();
        var waluta1 = Main.getInstance().getCollection().getByCode(input.getCode1());
        var waluta2 = Main.getInstance().getCollection().getByCode(input.getCode2());
        if(waluta1 == null || waluta2 == null)
        {
            System.out.println("Niepoprawna nazwa waluty");
            return;
        }
        Convert converter = new Convert(waluta1, waluta2);
        System.out.println(converter.getResult(input.getWartosc()));
    }
}


package xmlxpath;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlXpath {


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse("sweets.xml");
        
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        
        //XPathExpression xpe = xpath.compile("/");
        //XPathExpression xpe = xpath.compile("/sweets/sweet/type[@id=3]");
        //XPathExpression xpe = xpath.compile("/sweets/sweet[price='1']/type");
        //String res1 = xpe.evaluate(doc);
        //System.out.println(res1);
        
        
        //XPathExpression xpe = xpath.compile("/sweets/sweet/type");
        XPathExpression xpe = xpath.compile("/sweets/sweet[translate(date,'-','')>20200714]/type");
        NodeList res2 = (NodeList) xpe.evaluate(doc, XPathConstants.NODESET);
        for(int i=0; i<res2.getLength(); i++){
            System.out.println(res2.item(i).getTextContent());
        }
  
    }
    
}

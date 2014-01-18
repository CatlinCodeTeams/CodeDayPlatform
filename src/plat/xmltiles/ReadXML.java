package plat.xmltiles;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML
{
	public ReadXML( String XmlFile )
	{
		File xmlFile = new File( XmlFile );
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			NodeList tList = doc.getElementsByTagName("tile");
			for (int n = 0; n < tList.getLength(); n++) {
				Node nNode = tList.item(n);							// The list of the nodes in the tag
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {		// Make sure it is a node
					Element eElement = (Element) nNode;				// Return the element as var eElement
					
					System.out.println("Staff id : " + eElement.getAttribute("id"));
					
				}
			}
		}
		
	    catch (Exception e) {
		e.printStackTrace();
	    }
	}
}
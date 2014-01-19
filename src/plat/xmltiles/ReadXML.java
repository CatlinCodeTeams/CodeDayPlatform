package plat.xmltiles;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import plat.blocks.Block;

// import plat.xmltiles.ReadXML;
public class ReadXML
{
	public ReadXML()
	{
		// CONSTRUCTOR
	}
	public static void Read( String XmlFile, ArrayList<Block> blockList )
	{		
		try {
			
			File xmlFile = new File( ReadXML.class.getResource( XmlFile ).toURI() );
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			NodeList tList = doc.getElementsByTagName("tile");
			for (int n = 0; n < tList.getLength(); n++) {
				Node nNode = tList.item(n);							// The list of the nodes in the tag
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {		// Make sure it is a node
					Element eElement = (Element) nNode;				// Return the element as var eElement

					int x = Integer.parseInt( eElement.getAttribute( "x" ) );
					int y = Integer.parseInt( eElement.getAttribute( "y" ) );
					int type = Integer.parseInt( eElement.getAttribute( "type" ) );
					// blockList.add(x, y, type);
					
					System.out.println("The tile type is: " + eElement.getAttribute("type"));
				}
			}
			for (int n = 0; n < blockList; )
		}
		
	    catch (Exception e) {
		e.printStackTrace();
	    }
	}
}
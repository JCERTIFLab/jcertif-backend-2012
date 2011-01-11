/**
 * 
 */
package com.jcertif.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.jcertif.bo.Participant;

/**
 * Utility class for xml files.
 * 
 * @author Bernard Adanlessossi
 *
 */
public class XMLUtil {

	public XMLUtil(){
		super();
	}
	
	private static Document getDocument(String xml) {
		try {
			// Create a builder factory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			
			return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
		} catch (SAXException e) {
			return null;
		} catch (ParserConfigurationException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	private static boolean validateParticipantXML(Document doc) {
		NodeList nodeList = null;
		
		// Check the elements and values exist
		nodeList = doc.getElementsByTagName("participant");
		if (nodeList.getLength() != 1) {
			return false;
		}

		// Check that id element exists
		nodeList = doc.getElementsByTagName("id");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that dateinscription element exists
		nodeList = doc.getElementsByTagName("dateinscription");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that salutation element exists
		nodeList = doc.getElementsByTagName("salutation");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that nom element exists
		nodeList = doc.getElementsByTagName("nom");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that sexe element exists
		nodeList = doc.getElementsByTagName("sexe");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that email element exists
		nodeList = doc.getElementsByTagName("email");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that presentationsoumise element exists
		nodeList = doc.getElementsByTagName("presentationsoumise");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that cvsoumis element exists
		nodeList = doc.getElementsByTagName("cvsoumis");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that details element exists
		nodeList = doc.getElementsByTagName("details");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that email element exists
		nodeList = doc.getElementsByTagName("roleparticipant");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that value is not null or empty
		String username = getValue((Element) doc.getElementsByTagName("roleparticipants").item(0), "codeRole");
		if (username == null || username.isEmpty()) {
			return false;
		}

		// Check that email element exists
		nodeList = doc.getElementsByTagName("conferences");
		if (nodeList.getLength() != 1) {
			return false;
		}

		// Check that value is not null or empty
		String password = getValue((Element) doc.getElementsByTagName("conferences").item(0), "nom");
		if (password == null || password.isEmpty()) {
			return false;
		}

		return true;
	}
	
	private static String getValue(Element ele, String tagName) {
		String value = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			value = el.getFirstChild().getNodeValue();
		}

		return value;
	}

	public static Participant getParticipantVOFromXML(String xml) {
		Document doc = getDocument(xml);
		if (doc != null) {
			if(validateParticipantXML(doc)) {
				// XML is valid, just get the values from the DOM
				return new Participant(Long.valueOf(getValue((Element) doc.getElementsByTagName("participant").item(0), "id")),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "dateinscription"),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "salutation"),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "prenom"),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "nom"),
						Character.valueOf(getValue((Element) doc.getElementsByTagName("participant").item(0), "sexe").charAt(0)),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "email"),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "presentationsoumise"),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "cvsoumis"),
						getValue((Element) doc.getElementsByTagName("participant").item(0), "details"));
				
				
			}
		
		}		

		return null;
	}
}

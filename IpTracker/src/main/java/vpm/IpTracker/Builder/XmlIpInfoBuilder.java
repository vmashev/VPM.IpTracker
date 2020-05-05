package vpm.IpTracker.Builder;

import vpm.IpTracker.*;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class XmlIpInfoBuilder implements IpInfoBuilder{

	@Override
	public void parse(IpInfo ipInfo, String input) throws ParserConfigurationException, SAXException, IOException {
		
		String countryCode = null;
		String countryName = null;
		String regionName = null;
		String cityName = null;
		String zipCode = null;
		Double latitude = null;
		Double longitude = null;
		String timeZone = null;
				
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(new InputSource(new StringReader(input)));
        
        document.getDocumentElement().normalize();
        
        NodeList nodeList = document.getElementsByTagName("Response");
        
		Node nNode = nodeList.item(0);

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			countryCode = eElement.getElementsByTagName(Constants.COUNTRY_CODE).item(0).getTextContent();
			countryName = eElement.getElementsByTagName(Constants.COUNTRY_NAME).item(0).getTextContent();
			regionName = eElement.getElementsByTagName(Constants.REGION_NAME).item(0).getTextContent();
			cityName = eElement.getElementsByTagName(Constants.CITY_NAME).item(0).getTextContent();
			zipCode = eElement.getElementsByTagName(Constants.ZIP_CODE).item(0).getTextContent();
			latitude = Double.valueOf(eElement.getElementsByTagName(Constants.LATITUDE).item(0).getTextContent());
			longitude = Double.valueOf(eElement.getElementsByTagName(Constants.LONGITUDE).item(0).getTextContent());
			timeZone = eElement.getElementsByTagName(Constants.TIME_ZONE).item(0).getTextContent();
			
		}
		
    	ipInfo.setCountryCode(countryCode);
		ipInfo.setCountryName(countryName);
		ipInfo.setRegionName(regionName);
		ipInfo.setCityName(cityName);
		ipInfo.setZipCode(zipCode);
		ipInfo.setLatitude(latitude);
		ipInfo.setLongitude(longitude);
		ipInfo.setTimeZone(timeZone);
	}
	
}

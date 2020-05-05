package vpm.IpTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

class TrackIpTest {

	@Test
	void testGetJson() throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
		IpInfo ipInfo = TrackIp.get("91.139.129.118", "json");
		
		assertEquals("BG", ipInfo.getCountryCode());
		assertEquals("Bulgaria", ipInfo.getCountryName());
		assertEquals("Sofia (stolitsa)", ipInfo.getRegionName());
		assertEquals("Sofia", ipInfo.getCityName());
		assertEquals("1000", ipInfo.getZipCode());
		assertEquals(42.6975, ipInfo.getLatitude());
		assertEquals(23.3242, ipInfo.getLongitude());
		assertEquals("+03:00", ipInfo.getTimeZone());	

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetXml() throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
		IpInfo ipInfo = TrackIp.get("91.139.129.118", "xml");
		
		assertEquals("BG", ipInfo.getCountryCode());
		assertEquals("Bulgaria", ipInfo.getCountryName());
		assertEquals("Sofia (stolitsa)", ipInfo.getRegionName());
		assertEquals("Sofia", ipInfo.getCityName());
		assertEquals("1000", ipInfo.getZipCode());
		assertEquals(42.6975, ipInfo.getLatitude());
		assertEquals(23.3242, ipInfo.getLongitude());
		assertEquals("+03:00", ipInfo.getTimeZone());	

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetCsv() throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
		IpInfo ipInfo = TrackIp.get("91.139.129.118", "csv");
		
		assertEquals("BG", ipInfo.getCountryCode());
		assertEquals("Bulgaria", ipInfo.getCountryName());
		assertEquals("Sofia (stolitsa)", ipInfo.getRegionName());
		assertEquals("Sofia", ipInfo.getCityName());
		assertEquals("1000", ipInfo.getZipCode());
		assertEquals(42.6975, ipInfo.getLatitude());
		assertEquals(23.3242, ipInfo.getLongitude());
		assertEquals("+03:00", ipInfo.getTimeZone());	
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

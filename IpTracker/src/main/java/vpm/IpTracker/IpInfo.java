package vpm.IpTracker;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vpm.IpTracker.Builder.CsvIpInfoBuilder;
import vpm.IpTracker.Builder.IpInfoBuilder;
import vpm.IpTracker.Builder.JsonIpInfoBuilder;
import vpm.IpTracker.Builder.XmlIpInfoBuilder;

public class IpInfo {

	private String ipAddress;
	private String countryCode;
	private String countryName;
	private String regionName;
	private String cityName;
	private String timeZone;
	private String zipCode;
	private double latitude;
	private double longitude;
	
	private IpInfoBuilder builder;
	
	public IpInfo(IpInfoBuilder builder) {
		
		this.builder = builder;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	};
	
	public void build(String input) throws ParserConfigurationException, SAXException, IOException{
		this.builder.parse(this , input);
	}
	
	public static IpInfo createIpInfo(String format) {
		IpInfo ipInfo = null;
		
		switch (format) {
		case "json":
			ipInfo = new IpInfo(new JsonIpInfoBuilder());
			break;
		case "xml":
			ipInfo = new IpInfo(new XmlIpInfoBuilder());
			break;
		case "csv":
			ipInfo = new IpInfo(new CsvIpInfoBuilder());
			break;
		}
		
		return ipInfo;
	}
}

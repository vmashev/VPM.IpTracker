package vpm.IpTracker;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TrackIp {
	
	private static IpInfo ipInfo;	
	
	public static IpInfo get(String ip, String format) throws URISyntaxException, ParserConfigurationException, SAXException, IOException {
		
		String url = String.format(Constants.IPINFO_URL, Constants.IPINFO_KEY , ip);
		if(format != "csv") {
			url += "&format=" + format;
		}
		
		ipInfo = IpInfo.createIpInfo(format);
		String result = HttpManagement.sendRequest(url);
		ipInfo.build(result);
		return ipInfo;
	}


	

	
}

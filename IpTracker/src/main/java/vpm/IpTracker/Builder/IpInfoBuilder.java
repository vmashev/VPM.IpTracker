package vpm.IpTracker.Builder;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vpm.IpTracker.IpInfo;

public interface IpInfoBuilder {
	void parse(IpInfo ipInfo, String input) throws ParserConfigurationException, SAXException, IOException;
}

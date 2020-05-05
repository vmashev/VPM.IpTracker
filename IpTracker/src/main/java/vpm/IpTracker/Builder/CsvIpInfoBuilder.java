package vpm.IpTracker.Builder;

import vpm.IpTracker.IpInfo;

public class CsvIpInfoBuilder implements IpInfoBuilder{

	
	@Override
	public void parse(IpInfo ipInfo, String input) {
		
		String[] dataLine = input.split(";"); 
		
		ipInfo.setCountryCode(dataLine[3]);
		ipInfo.setCountryName(dataLine[4]);
		ipInfo.setRegionName(dataLine[5]);
		ipInfo.setCityName(dataLine[6]);
		ipInfo.setZipCode(dataLine[7]);
		ipInfo.setLatitude(Double.valueOf(dataLine[8]));
		ipInfo.setLongitude(Double.valueOf(dataLine[9]));
		ipInfo.setTimeZone(dataLine[10]);
		
	}

}

package vpm.IpTracker.Builder;

import com.google.gson.Gson;

import vpm.IpTracker.IpInfo;

public class JsonIpInfoBuilder implements IpInfoBuilder {

	@Override
	public void parse(IpInfo ipInfo, String input) {
		
		Gson gson = new Gson();
		IpInfo tempIpInfo = gson.fromJson(input, IpInfo.class);

		ipInfo.setIpAddress(tempIpInfo.getIpAddress());
		ipInfo.setCountryCode(tempIpInfo.getCountryCode());
		ipInfo.setCountryName(tempIpInfo.getCountryName());
		ipInfo.setRegionName(tempIpInfo.getRegionName());
		ipInfo.setCityName(tempIpInfo.getCityName());
		ipInfo.setZipCode(tempIpInfo.getZipCode());
		ipInfo.setLatitude(tempIpInfo.getLatitude());
		ipInfo.setLongitude(tempIpInfo.getLongitude());
		ipInfo.setTimeZone(tempIpInfo.getTimeZone());
	
	}
}

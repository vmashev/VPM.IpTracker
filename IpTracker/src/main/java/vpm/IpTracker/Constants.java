package vpm.IpTracker;

public class Constants {

	public static final String STATUS_CODE = "statusCode";
	public static final String STATUS_MESSAGE = "statusMessage";
	public static final String IP_ADDRESS = "ipAddress";
	public static final String COUNTRY_CODE = "countryCode";
	public static final String COUNTRY_NAME = "countryName";
	public static final String REGION_NAME = "regionName";
	public static final String CITY_NAME = "cityName";
	public static final String ZIP_CODE = "zipCode";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String TIME_ZONE = "timeZone";
	
	public static final String IP_VALIDATOR = "(\\d{1,2}" + "|" + "(0|1)[0-9][0-9]" + "|" + "(2[0-4][0-9])|25[0-5])";
	
	public static final String MAP_URL = "http://m.osmtools.de/index.php?lon=%1$s&lat=%2$s&zoom=16&mlon=%1$s&mlat=%2$s&icon=4";

	public static final String IPINFO_KEY = "9d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebad06b";
	public static final String IPINFO_URL = "http://api.ipinfodb.com/v3/ip-city/?key=%s&ip=%s";
}

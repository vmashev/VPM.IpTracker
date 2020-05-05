package vpm.IpTracker;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

class HttpManagementTest {

	@Test
	void testSendRequest() throws URISyntaxException {
		String url = String.format(Constants.IPINFO_URL, Constants.IPINFO_KEY , "91.139.129.118");
		String response = HttpManagement.sendRequest(url);
		assertTrue(response != null);
		assertTrue(!response.equals(""));
	}

}

package vpm.IpTracker;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrimaryController {

	@FXML
	private TextField ip;
	@FXML
	private TextField country;
	@FXML
	private TextField region;
	@FXML 
	private TextField city;
	@FXML
	private TextField countryCode;
	@FXML
	private TextField timeZone;
	@FXML
	private TextField postCode;
	@FXML
	private TextField latitude;
	@FXML
	private TextField longitude;
	
	@FXML
	private ComboBox<String> cbOptions;
	
	ObservableList<String> formatType = FXCollections.observableArrayList("json","xml","csv");
	
	public void initialize() {
		 
		cbOptions.setItems(formatType);
		cbOptions.getSelectionModel().selectFirst();
	}
	
    @FXML
    private void findIpInfo() throws IOException, InterruptedException, ExecutionException {

    	String ipString = ip.getText();
    	String pattern = Constants.IP_VALIDATOR + "\\." + Constants.IP_VALIDATOR + "\\."+ Constants.IP_VALIDATOR + "\\." + Constants.IP_VALIDATOR;

		country.setText("");
		countryCode.setText("");
    	region.setText("");
    	timeZone.setText("");
    	city.setText("");
    	postCode.setText("");
    	latitude.setText("");
    	longitude.setText("");
    	
    	if(!ipString.matches(pattern)) {
    		ExceptionDialog.show(new IllegalArgumentException("Invalid IP address."));
    	} else {
 
			try {
				IpInfo ipInfo = TrackIp.get(ipString,cbOptions.getValue());
	    		country.setText(ipInfo.getCountryName());
	    		countryCode.setText(ipInfo.getCountryCode());
	        	region.setText(ipInfo.getRegionName());
	        	timeZone.setText(ipInfo.getTimeZone());
	        	city.setText(ipInfo.getCityName());
	        	postCode.setText(String.valueOf(ipInfo.getZipCode()));
	        	latitude.setText(String.valueOf(ipInfo.getLatitude()));
	        	longitude.setText(String.valueOf(ipInfo.getLongitude()));
			} catch (UnresolvedAddressException |  URISyntaxException | ParserConfigurationException | SAXException e) {
				ExceptionDialog.show(e);
			}
    	}
    }
    
    @FXML
    private void showOnMap() {
    	if((!longitude.getText().equals("")) && (!latitude.getText().equals(""))) {
    	
	        String url = String.format(Constants.MAP_URL, longitude.getText() , latitude.getText());
	
	        if(Desktop.isDesktopSupported()){
	            Desktop desktop = Desktop.getDesktop();
	            try {
	                desktop.browse(new URI(url));
	            } catch (IOException | URISyntaxException e) {
	            	ExceptionDialog.show(e);
	            }
	        } 
    	}
    }
    
    
    
}

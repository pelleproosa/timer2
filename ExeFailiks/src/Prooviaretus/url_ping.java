package Prooviaretus;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;



	public class url_ping {

public static void start(String url, int timeout) throws Exception {
    url = url.replaceFirst("https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.
    String x;
    Date date = new Date();
    SimpleDateFormat ft = 
    	      new SimpleDateFormat ("hh:mm:ss");

  
    x=(ft.format(date));
    try {
    	URL aadress = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)aadress.openConnection();
        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        if(200 <= responseCode && responseCode <= 399){
        	lihtneTaimer.hetkeseis="OK";}else{
        		lihtneTaimer.hetkeseis="FAIL!";
        	Date dateE = new Date();
            SimpleDateFormat sft = 
          	      new SimpleDateFormat ("hh:mm:ss");
            
        	x= x+" - "+sft.format(dateE);
        	x=x+"!!!";
        	

        }} catch (IOException exception) {
        	lihtneTaimer.hetkeseis="FAIL!";
        	Date dateE = new Date();
            SimpleDateFormat sft = 
          	      new SimpleDateFormat ("hh:mm:ss");
            
    	x= x+" - "+sft.format(dateE);
    	x=x+"!!!";
    	
    }


}





}
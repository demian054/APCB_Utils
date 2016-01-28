/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.conection;



import com.apcb.utils.utils.PropertiesReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import org.apache.log4j.Logger;

public class ConectionHttpsURL {

        private final static Logger log = Logger.getLogger(ConectionHttpsURL.class);
	private final String USER_AGENT = "Mozilla/5.0";
        private PropertiesReader prop; 

        public ConectionHttpsURL(PropertiesReader prop) {
            this.prop = prop;   
        }
        	
	// HTTP POST request
	public String sendPost(String urlParameters) throws Exception {
		String server = prop.getProperty("Server");
                int responseCode = 0;
                String responseMsg = "";
                
                if (prop.getProperty("ConectKiu",false).equalsIgnoreCase("false")){
                    log.info("Simulate Answer To Kiu " );
                    responseMsg = prop.getProperty("SimulateResponseMsg", false);
                } else {
 
                    URL obj = new URL(server);
                    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

                    con.setRequestMethod("POST");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

                    con.setDoOutput(true);

                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(urlParameters);
                    wr.flush();
                    wr.close();

                    responseCode = con.getResponseCode();

                    BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                    }
                    in.close();
                    responseMsg = response.toString();
                }
                log.info("Sending 'POST' request to URL : " + server);
		log.info("Post parameters : " + urlParameters);
		log.info("Response Code : " + responseCode);
		return responseMsg;
	}
        
        // HTTP GET request (en desuso)
	private void sendGet() throws Exception {
               
		String url = "http://www.google.com/search?q=mkyong";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		log.info("\nSending 'GET' request to URL : " + url);
		log.info("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		log.info(response.toString());

	}

}

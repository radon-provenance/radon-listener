package org.radon.listener;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class RadonApp {

    public static String scriptPath = System.getProperty("user.dir") + "/scripts";
    private static final Logger logger = LoggerFactory.getLogger(RadonApp.class);
 
    
    public static void main(String[] args) {
    	RadonParameters params = RadonParameters.getInstance();

        String mqttHost = params.getMqttHost();
        String mqttPort = params.getMqttPort();
        String radonHost = params.getRadonHost();
        String radonPort = params.getRadonPort();
        
    	System.out.println(args.length);
        
        for (int i = 0 ; i < args.length; i++) {
        	String arg = args[i];
        	if (arg.equals("-m")) {
        		params.setMqttHost(args[++i]);
        	}
        	if (arg.equals("-r")) {
        		params.setRadonHost(args[++i]);
        	}		
        }

        logger.info("Starting listener - (MQTT: " + mqttHost + ":" + mqttPort + ")");
        
        RadonMqttClient mqttClient = new RadonMqttClient();
        mqttClient.loop();
        
        
        // mqttClient.close() ???
        
        System.out.println("Ok");
    }
    



}

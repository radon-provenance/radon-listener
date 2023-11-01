package org.radon.listener;



public class RadonParameters {

    private String mqttHost;
    private String mqttPort;
    private String radonHost;
    private String radonPort;
    
	private RadonParameters() {
		this.mqttHost = "localhost";
		this.mqttPort = "1883";
		this.radonHost = "127.0.0.1";
		this.radonPort = "8000";
	}
	
	private static RadonParameters instance = new RadonParameters();
	
	
	public static RadonParameters getInstance() {
		return instance;
	}


	public String getMqttHost() {
		return this.mqttHost;
	}


	public void setMqttHost(String mqttHost) {
		this.mqttHost = mqttHost;
	}


	public String getMqttPort() {
		return this.mqttPort;
	}


	public void setMqttPort(String mqttPort) {
		this.mqttPort = mqttPort;
	}


	public String getRadonHost() {
		return this.radonHost;
	}


	public void setRadonHost(String radonHost) {
		this.radonHost = radonHost;
	}


	public String getRadonPort() {
		return this.radonPort;
	}


	public void setRadonPort(String radonPort) {
		this.radonPort = radonPort;
	}
	
	
}

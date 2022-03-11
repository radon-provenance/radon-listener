/* 
 * Copyright 2022
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.radon.listener;

import java.util.Arrays;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.json.JSONObject;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.radon.listener.facts.CreateCollection;
import org.radon.listener.facts.CreateGroup;
import org.radon.listener.facts.CreateResource;
import org.radon.listener.facts.CreateUser;
import org.radon.listener.facts.DeleteCollection;
import org.radon.listener.facts.DeleteGroup;
import org.radon.listener.facts.DeleteResource;
import org.radon.listener.facts.DeleteUser;
import org.radon.listener.facts.UpdateCollection;
import org.radon.listener.facts.UpdateGroup;
import org.radon.listener.facts.UpdateResource;
import org.radon.listener.facts.UpdateUser;

public class RadonMqttClient implements MqttCallback{

    private static Logger logger = LogManager.getLogger(RadonApp.class);
    
    private String serverURI;
    private String subscriberId;
    private KieSession kSession;
    private String scriptPath;
    

    
    public RadonMqttClient(String host, String port) {
        super();
        this.serverURI = String.format("tcp://%s:%s", host, port);
        this.subscriberId = UUID.randomUUID().toString();
        
        logger.info( "Bootstrapping the Rule Engine" );
//        KieServices ks = KieServices.Factory.get();
//        KieContainer kContainer = ks.getKieClasspathContainer();
//        this.kSession = kContainer.newKieSession();
    }

    
    @Override
    public void connectionLost(Throwable cause) {
        logger.info("Connection to MQTT broker lost!");
    }

   
	@Override
    public void messageArrived(String topic, MqttMessage message) throws Exception{
        byte[] payload = message.getPayload();
        logger.info("Received message on topic " + topic);
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        this.kSession = kContainer.newKieSession();
        
        String[] parts = topic.split("/");
        String op = parts[0];
        String obj = parts[1];
        String uuid = String.join("/", Arrays.copyOfRange(parts, 2, parts.length));
        
        JSONObject payloadJSON = new JSONObject(message.toString());
        switch (op) {
        case "create":
            switch (obj) {
            case "user":
                JSONObject postUserJSON = payloadJSON.getJSONObject("post");
                CreateUser factUser = new CreateUser(postUserJSON);
                kSession.insert(factUser);
                break;
            case "group":
                JSONObject postGroupJSON = payloadJSON.getJSONObject("post");
                CreateGroup factGroup = new CreateGroup(postGroupJSON);
                kSession.insert(factGroup);
                break;
            case "resource":
                JSONObject postRescJSON = payloadJSON.getJSONObject("post");
                CreateResource factResc = new CreateResource(postRescJSON);
                kSession.insert(factResc);
                break;
            case "collection":
                JSONObject postCollJSON = payloadJSON.getJSONObject("post");
                CreateCollection collResc = new CreateCollection(postCollJSON);
                kSession.insert(collResc);
                break;
            }
            break;
        case "update":
            switch (obj) {
            case "user":
                JSONObject preUserJSON = payloadJSON.getJSONObject("pre");
                JSONObject postUserJSON = payloadJSON.getJSONObject("post");
                UpdateUser factUser = new UpdateUser(preUserJSON, postUserJSON);
                kSession.insert(factUser);
                break;
            case "group":
                JSONObject preGroupJSON = payloadJSON.getJSONObject("pre");
                JSONObject postGroupJSON = payloadJSON.getJSONObject("post");
                UpdateGroup factGroup = new UpdateGroup(preGroupJSON, postGroupJSON);
                kSession.insert(factGroup);
                break;
            case "resource":
                JSONObject preRescJSON = payloadJSON.getJSONObject("pre");
                JSONObject postRescJSON = payloadJSON.getJSONObject("post");
                UpdateResource factResc = new UpdateResource(preRescJSON, postRescJSON);
                kSession.insert(factResc);
                break;
            case "collection":
                JSONObject preCollJSON = payloadJSON.getJSONObject("pre");
                JSONObject postCollJSON = payloadJSON.getJSONObject("post");
                UpdateCollection factColl = new UpdateCollection(preCollJSON, postCollJSON);
                kSession.insert(factColl);
                break;
            }
            break;
        case "delete":
            switch (obj) {
            case "user":
                JSONObject preUserJSON = payloadJSON.getJSONObject("pre");
                DeleteUser factUser = new DeleteUser(preUserJSON);
                kSession.insert(factUser);
                break;
            case "group":
                JSONObject preGroupJSON = payloadJSON.getJSONObject("pre");
                DeleteGroup factGroup = new DeleteGroup(preGroupJSON);
                kSession.insert(factGroup);
                break;
            case "resource":
                JSONObject preRescJSON = payloadJSON.getJSONObject("pre");
                DeleteResource factResc = new DeleteResource(preRescJSON);
                kSession.insert(factResc);
                break;
            case "collection":
                JSONObject preCollJSON = payloadJSON.getJSONObject("pre");
                DeleteCollection factColl = new DeleteCollection(preCollJSON);
                kSession.insert(factColl);
                break;
            }
            break;
        }
//        
        int fired = kSession.fireAllRules();
//        
//        
        System.out.println( "Number of Rules executed = " + fired );
//        System.out.println( "Item Category: " + item.getCategory()); 
    }


    public void loop() {
        IMqttClient subscriber;
        MqttConnectOptions options = new MqttConnectOptions();
        try {
            subscriber = new MqttClient(this.serverURI, this.subscriberId, 
                                        new MqttDefaultFilePersistence("/tmp"));
            subscriber.setCallback(this);
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            subscriber.connect(options);

            subscriber.subscribe("#");
        } catch (MqttSecurityException e1) {
            e1.printStackTrace();
            return;
        } catch (MqttException e1) {
            e1.printStackTrace();
            return;
        }
        logger.info("Connected to " + this.serverURI);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        logger.info("deliveryComplete");
    }
}

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
import java.util.List;
import java.util.UUID;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
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
//import org.json.JSONObject;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.radon.listener.facts.CreateRequestCollection;
import org.radon.listener.facts.CreateRequestGroup;
import org.radon.listener.facts.CreateRequestResource;
import org.radon.listener.facts.CreateRequestUser;
import org.radon.listener.facts.CreateSuccessCollection;
import org.radon.listener.facts.CreateSuccessGroup;
import org.radon.listener.facts.DeleteRequestCollection;
import org.radon.listener.facts.DeleteRequestGroup;
import org.radon.listener.facts.DeleteRequestResource;
import org.radon.listener.facts.DeleteRequestUser;
import org.radon.listener.facts.DeleteSuccessCollection;
import org.radon.listener.facts.DeleteSuccessGroup;
import org.radon.listener.facts.DeleteSuccessResource;
import org.radon.listener.facts.CreateSuccessUser;
import org.radon.listener.facts.DeleteFailCollection;
import org.radon.listener.facts.DeleteFailGroup;
import org.radon.listener.facts.DeleteFailResource;
import org.radon.listener.facts.DeleteFailUser;
import org.radon.listener.facts.CreateSuccessResource;
import org.radon.listener.facts.CreateFailCollection;
import org.radon.listener.facts.CreateFailGroup;
import org.radon.listener.facts.CreateFailResource;
import org.radon.listener.facts.CreateFailUser;
import org.radon.listener.facts.DeleteSuccessUser;
import org.radon.listener.facts.UpdateFailCollection;
import org.radon.listener.facts.UpdateFailGroup;
import org.radon.listener.facts.UpdateFailResource;
import org.radon.listener.facts.UpdateFailUser;
import org.radon.listener.facts.UpdateRequestCollection;
import org.radon.listener.facts.UpdateRequestGroup;
import org.radon.listener.facts.UpdateRequestResource;
import org.radon.listener.facts.UpdateRequestUser;
import org.radon.listener.facts.UpdateSuccessCollection;
import org.radon.listener.facts.UpdateSuccessGroup;
import org.radon.listener.facts.UpdateSuccessResource;
import org.radon.listener.facts.UpdateSuccessUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadonMqttClient implements MqttCallback{

    private static Logger logger = LoggerFactory.getLogger(RadonApp.class);
    
    private String serverURI;
    private String subscriberId;
    private String scriptPath;
    
    private KieScanner kScanner;
    
    private RadonUnit radonUnit;
    private RuleUnitInstance<RadonUnit> instance;
    

    
    public RadonMqttClient() {
        super();
        RadonParameters params = RadonParameters.getInstance();
        this.serverURI = String.format("tcp://%s:%s", 
        							   params.getMqttHost(), 
        							   params.getMqttPort());
        this.subscriberId = UUID.randomUUID().toString();

        logger.info("Creating RuleUnit");
        radonUnit = new RadonUnit();

        instance = RuleUnitProvider.get().createRuleUnitInstance(radonUnit);
        
       /* ks = KieServices.Factory.get();
        

        ReleaseId releaseId = ks.newReleaseId("org.radon", "listener", "1.0-SNAPSHOT");
        kContainer = ks.newKieContainer(releaseId);
        
        //this.kContainer = this.ks.getKieClasspathContainer();
        
        kScanner = ks.newKieScanner(kContainer);
        kScanner.start( 10000L );
        */


        /*KieScanner kScanner = this.ks.newKieScanner( kContainer );
        kScanner.start( 10000L );*/
        
    }


    
    public void message_create_request(String obj_type, String obj_key, 
    		JSONObject payload) { 
    	JSONObject objJSON = payload.getJSONObject("obj");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getCreateRequestUser().add(
            		new CreateRequestUser(objJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getCreateRequestGroup().add(
            		new CreateRequestGroup(objJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getCreateRequestCollection().add(
            		new CreateRequestCollection(objJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getCreateRequestResource().add(
            		new CreateRequestResource(objJSON, metaJSON));
            break;
		}
    }
    
    public void message_create_success(String obj_type, String obj_key, 
    		JSONObject payload) { 
    	JSONObject objJSON = payload.getJSONObject("obj");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getCreateSuccessUser().add(
            		new CreateSuccessUser(objJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getCreateSuccessGroup().add(
            		new CreateSuccessGroup(objJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getCreateSuccessCollection().add(
            		new CreateSuccessCollection(objJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getCreateSuccessResource().add(
            		new CreateSuccessResource(objJSON, metaJSON));
            break;
		}    	
    }
    
    public void message_create_fail(String obj_type, String obj_key, 
    		JSONObject payload) { 

    	JSONObject objJSON = payload.getJSONObject("obj");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getCreateFailUser().add(
            		new CreateFailUser(objJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getCreateFailGroup().add(
            		new CreateFailGroup(objJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getCreateFailCollection().add(
            		new CreateFailCollection(objJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getCreateFailResource().add(
            		new CreateFailResource(objJSON, metaJSON));
            break;
		}
    }

    public void message_create(String op_type, String obj_type, String obj_key, 
    		JSONObject payload) {    	
    	switch(op_type) {
    	case "request":
    		message_create_request(obj_type, obj_key, payload);
    		break;
    	case "success":
    		message_create_success(obj_type, obj_key, payload);
    		break;
    	case "fail":
    		message_create_fail(obj_type, obj_key, payload);
    		break;
    	}
    }
    
    public void message_delete_request(String obj_type, String obj_key, 
    		JSONObject payload) { 
    	JSONObject objJSON = payload.getJSONObject("obj");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getDeleteRequestUser().add(
            		new DeleteRequestUser(objJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getDeleteRequestGroup().add(
            		new DeleteRequestGroup(objJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getDeleteRequestCollection().add(
            		new DeleteRequestCollection(objJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getDeleteRequestResource().add(
            		new DeleteRequestResource(objJSON, metaJSON));
            break;
		}
    }
    
    public void message_delete_success(String obj_type, String obj_key, 
    		JSONObject payload) { 
    	JSONObject objJSON = payload.getJSONObject("obj");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getDeleteSuccessUser().add(
            		new DeleteSuccessUser(objJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getDeleteSuccessGroup().add(
            		new DeleteSuccessGroup(objJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getDeleteSuccessCollection().add(
            		new DeleteSuccessCollection(objJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getDeleteSuccessResource().add(
            		new DeleteSuccessResource(objJSON, metaJSON));
            break;
		}    	
    }
    
    public void message_delete_fail(String obj_type, String obj_key, 
    		JSONObject payload) { 

    	JSONObject objJSON = payload.getJSONObject("obj");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getDeleteFailUser().add(
            		new DeleteFailUser(objJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getDeleteFailGroup().add(
            		new DeleteFailGroup(objJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getDeleteFailCollection().add(
            		new DeleteFailCollection(objJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getDeleteFailResource().add(
            		new DeleteFailResource(objJSON, metaJSON));
            break;
		}
    }

    public void message_delete(String op_type, String obj_type, String obj_key, 
    		JSONObject payload) {    	
    	switch(op_type) {
    	case "request":
    		message_delete_request(obj_type, obj_key, payload);
    		break;
    	case "success":
    		message_delete_success(obj_type, obj_key, payload);
    		break;
    	case "fail":
    		message_delete_fail(obj_type, obj_key, payload);
    		break;
    	}
    }
    
    public void message_update_request(String obj_type, String obj_key, 
    		JSONObject payload) { 
    	JSONObject objJSON = payload.getJSONObject("obj");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getUpdateRequestUser().add(
            		new UpdateRequestUser(objJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getUpdateRequestGroup().add(
            		new UpdateRequestGroup(objJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getUpdateRequestCollection().add(
            		new UpdateRequestCollection(objJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getUpdateRequestResource().add(
            		new UpdateRequestResource(objJSON, metaJSON));
            break;
		}
    }
    
    public void message_update_success(String obj_type, String obj_key, 
    		JSONObject payload) { 
    	JSONObject objBeforeJSON = payload.getJSONObject("pre");
    	JSONObject objAfterJSON = payload.getJSONObject("post");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getUpdateSuccessUser().add(
            		new UpdateSuccessUser(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getUpdateSuccessGroup().add(
            		new UpdateSuccessGroup(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getUpdateSuccessCollection().add(
            		new UpdateSuccessCollection(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getUpdateSuccessResource().add(
            		new UpdateSuccessResource(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		}    	
    }
    
    public void message_update_fail(String obj_type, String obj_key, 
    		JSONObject payload) { 
    	JSONObject objBeforeJSON = payload.getJSONObject("before");
    	JSONObject objAfterJSON = payload.getJSONObject("after");
        JSONObject metaJSON = payload.getJSONObject("meta");
        
		switch (obj_type) {
		case "user":
            radonUnit.getUpdateFailUser().add(
            		new UpdateFailUser(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		case "group": 
            radonUnit.getUpdateFailGroup().add(
            		new UpdateFailGroup(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		case "collection": 
            radonUnit.getUpdateFailCollection().add(
            		new UpdateFailCollection(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		case "resource":
            radonUnit.getUpdateFailResource().add(
            		new UpdateFailResource(objBeforeJSON, objAfterJSON, metaJSON));
            break;
		}
    }

    public void message_update(String op_type, String obj_type, String obj_key, 
    		JSONObject payload) {    	
    	switch(op_type) {
    	case "request":
    		message_update_request(obj_type, obj_key, payload);
    		break;
    	case "success":
    		message_update_success(obj_type, obj_key, payload);
    		break;
    	case "fail":
    		message_update_fail(obj_type, obj_key, payload);
    		break;
    	}
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception{
        byte[] payload = message.getPayload();
        logger.info("Received message on topic " + topic);
        
        String[] parts = topic.split("/");
        String op_name = parts[0];
        String op_type = parts[1];
        String obj_type = parts[2];
        String obj_key = String.join("/", Arrays.copyOfRange(parts, 3, parts.length));
        
        JSONObject payloadJSON = new JSONObject(message.toString());
        
        switch (op_name) {
        case "create":
        	message_create(op_type, obj_type, obj_key, payloadJSON);
        	break;
        case "delete":
        	message_delete(op_type, obj_type, obj_key, payloadJSON);
        	break;
        case "update":
        	message_update(op_type, obj_type, obj_key, payloadJSON);
        	break;
        	
        }

        int fired = instance.fire();
        logger.info( "Number of Rules executed = " + fired);

    }
    
    @Override
    public void connectionLost(Throwable cause) {
        logger.info("Connection to MQTT broker lost!");
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
	        logger.info("Connected to " + this.serverURI);
	    } catch (MqttSecurityException e1) {
	        logger.error(e1.getMessage());
	        return;
	    } catch (MqttException e1) {
	        logger.error(e1.toString());
	        return;
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        logger.info("deliveryComplete");
    }  
}

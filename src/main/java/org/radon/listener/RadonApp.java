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

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.json.JSONObject;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.radon.listener.facts.CreateResource;
import org.radon.listener.facts.CreateUser;
import org.radon.listener.facts.DeleteResource;
import org.radon.listener.facts.UpdateResource;
import org.radon.listener.workflows.SystemCommands;
import org.radon.utils.PropertiesReader;


public class RadonApp {

    // The name of this Logger will be "org.radon.listener.RadonApp"
    private static final Logger logger = LogManager.getLogger();
    public static String scriptPath = System.getProperty("user.dir") + "/scripts";
    
    private String db_path = "test.db";
    
    public Logger getLogger( ) {
        return logger;
    }
    
    
    public void setDb_path(String db_path) {
        this.db_path = db_path;
    }


    public String getDb_path() {
        return db_path;
    }
    
    public void testDrools() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();
        
        String messageC = "{'pre':{}, "
                         + "'post':{'name':'/test2', "
                                + "'uuid': 'test', "
                                + "'url': 'none', "
                                + "'create_ts': 'today', "
                                + "'modify_ts': 'today+1', "
                                + "'metadata': {}, "
                                + "'container': '/'}}";
        
        String messageU = "{'pre':{'name':'/test', "
                                + "'uuid': 'test', "
                                + "'url': 'none', "
                                + "'create_ts': 'today', "
                                + "'modify_ts': 'today', "
                                + "'metadata': {}, "
                                + "'container': '/'}, "
                         + "'post':{'name':'/test2', "
                                + "'uuid': 'test', "
                                + "'url': 'none', "
                                + "'create_ts': 'today', "
                                + "'modify_ts': 'today+1', "
                                + "'metadata': {}, "
                                + "'container': '/'}}";
        
        String messageD = "{'pre':{'name':'/test', "
                                + "'uuid': 'test', "
                                + "'url': 'none', "
                                + "'create_ts': 'today', "
                                + "'modify_ts': 'today', "
                                + "'metadata': {}, "
                                + "'container': '/'}, "
                         + "'post':{}}";
        
        JSONObject payloadJSON;
        JSONObject preRescJSON;
        JSONObject postRescJSON;

        payloadJSON = new JSONObject(messageC);
        postRescJSON = payloadJSON.getJSONObject("post");
        CreateResource fact1 = new CreateResource(postRescJSON);
        kSession.insert(fact1);
     
        payloadJSON = new JSONObject(messageU);
        preRescJSON = payloadJSON.getJSONObject("pre");
        postRescJSON = payloadJSON.getJSONObject("post");
        UpdateResource fact2 = new UpdateResource(preRescJSON, postRescJSON);
        kSession.insert(fact2);

        payloadJSON = new JSONObject(messageD);
        postRescJSON = payloadJSON.getJSONObject("pre");
        DeleteResource fact3 = new DeleteResource(postRescJSON);
        kSession.insert(fact3);

        int fired = kSession.fireAllRules();

        System.out.println( "Number of Rules executed = " + fired );
    }
    
    
    public void testExec() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(SystemCommands.LINUX_LAUNCH_CHROME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        

    public void testExecDrools() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();
        
        String messageC = "{'pre':{}, "
                         + "'post':{'name':'userTest', "
                                + "'uuid': 'test', "
                                + "'email': 'test@radon.org', "
                                + "'active': true, "
                                + "'groups': []}}";
        
        JSONObject payloadJSON;
        JSONObject postRescJSON;
    
        payloadJSON = new JSONObject(messageC);
        postRescJSON = payloadJSON.getJSONObject("post");
        CreateUser fact1 = new CreateUser(postRescJSON);
        kSession.insert(fact1);
     
    
        int fired = kSession.fireAllRules();
    
        System.out.println( "Number of Rules executed = " + fired );
    }


    public static void main(String[] args) {
        RadonApp app = new RadonApp();
        String mqttHost = "localhost";
        String mqttPort = "1883";
        
        // Read properties from property file
        PropertiesReader reader;
        try {
            reader = new PropertiesReader("pom.properties");
            app.setDb_path(reader.getProperty("dbPath"));
            Configurator.setLevel(logger.getName(), Level.valueOf(reader.getProperty("logLevel")));
            mqttHost = reader.getProperty("mqttHost");
            mqttPort = reader.getProperty("mqttPort");
            //scriptPath = reader.getProperty("scriptPath");
        } catch (Exception e) {
            logger.error(e.toString());
        }
        logger.info("Starting listener");
        RadonMqttClient mqttClient = new RadonMqttClient(mqttHost, mqttPort);
        mqttClient.loop();
        //
    //  app.testDrools();
//       app.testExec();
       //app.testExecDrools();

    }

}

/* Copyright 2022

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

package org.radon.listener.workflows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import org.radon.listener.RadonApp;
import org.radon.listener.RadonParameters;
import org.radon.listener.model.Collection;
import org.radon.listener.model.Group;
import org.radon.listener.model.Meta;
import org.radon.listener.model.Resource;
import org.radon.listener.model.User;

public class Microservices { 

    public static String callMicroserviceRest(String msName, String inputJSON) {
        try {
        	RadonParameters params = RadonParameters.getInstance();
        	URI targetURI;
            targetURI = new URI("http://" + params.getRadonHost() + ":" + params.getRadonPort() + "/msi/" + msName);
            System.out.println("Calling " + targetURI);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(targetURI)
                    .POST(HttpRequest.BodyPublishers.ofString(inputJSON))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
            	return response.body();
            } else {
            	JSONObject payload = new JSONObject();
            	payload.put("msg", response.body());
            	payload.put("err", true);
            	return payload.toString();
            }
            
        } catch (URISyntaxException | IOException | InterruptedException  e) {
        	System.out.println("Problem with the microservice call");
          //  e.printStackTrace();
        }
        
        return "{}";
    }
    
    	
    public static String createCollection(Collection coll, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", coll.getJSON());
    	payload.put("meta", meta.getJSON());
    	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("create_collection", payload.toString())
        );
        
        if (outJSON.has("msg")) {
            String out = outJSON.getString("msg");
            return out;
        }
        
        return "";
    }
    
    	
    public static String createResource(Resource resc, Meta meta) {
    	JSONObject payload = new JSONObject();
    	payload.put("obj", resc.getJSON());
    	payload.put("meta", meta.getJSON());    	
    	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("create_resource", payload.toString())
        );
        
        if (outJSON.has("msg")) {
            String out = outJSON.getString("msg");
            return out;
        }
        
        return "";
    }
    
    	
    public static String createGroup(Group group, Meta meta) {    
    	JSONObject payload = new JSONObject();
    	payload.put("obj", group.getJSON());
    	payload.put("meta", meta.getJSON());    	
    	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("create_group", payload.toString())
        );
        
        if (outJSON.has("msg")) {
            String out = outJSON.getString("msg");
            return out;
        }
        
        return "";
    }
    
    	
    public static String createUser(User user, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", user.getJSON());
    	payload.put("meta", meta.getJSON());
    	   	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("create_user", payload.toString())
        );
        
        if (outJSON.optBoolean("err", false)) {
           return outJSON.getString("Error: " + "msg");
        }
        if (outJSON.has("msg")) {
            return outJSON.getString("msg");
        }
        
        return "Error";
    }
    
	
    public static String deleteCollection(Collection coll, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", coll.getJSON());
    	payload.put("meta", meta.getJSON()); 
		
	    JSONObject outJSON = new JSONObject(
	            callMicroserviceRest("delete_collection", payload.toString()));
	    
	    if (outJSON.has("msg")) {
	        String out = outJSON.getString("msg");
	        return out;
	    }
	    
	    return "";
	}
    
	
    public static String deleteGroup(Group group, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", group.getJSON());
    	payload.put("meta", meta.getJSON()); 
		
	    JSONObject outJSON = new JSONObject(
	            callMicroserviceRest("delete_group", payload.toString()));
	    
	    if (outJSON.has("msg")) {
	        String out = outJSON.getString("msg");
	        return out;
	    }
	    
	    return "";
	}
    
	
    public static String deleteResource(Resource resc, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", resc.getJSON());
    	payload.put("meta", meta.getJSON()); 
		
	    JSONObject outJSON = new JSONObject(
	            callMicroserviceRest("delete_resource", payload.toString()));
	    
	    if (outJSON.has("msg")) {
	        String out = outJSON.getString("msg");
	        return out;
	    }
	    
	    return "";
	}
    
	
    public static String deleteUser(User user, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", user.getJSON());
    	payload.put("meta", meta.getJSON()); 
		
	    JSONObject outJSON = new JSONObject(
	            callMicroserviceRest("delete_user", payload.toString()));
	    
	    if (outJSON.has("msg")) {
	        String out = outJSON.getString("msg");
	        return out;
	    }
	    
	    return "";
	}
    
    	
    public static String updateCollection(Collection coll, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", coll.getJSON());
    	payload.put("meta", meta.getJSON());
    	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("update_collection", payload.toString())
        );
        
        if (outJSON.has("msg")) {
            String out = outJSON.getString("msg");
            return out;
        }
        
        return "";
    }
    
    	
    public static String updateResource(Resource resc, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", resc.getJSON());
    	payload.put("meta", meta.getJSON());
    	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("update_resource", payload.toString())
        );
        
        if (outJSON.has("msg")) {
            String out = outJSON.getString("msg");
            return out;
        }
        
        return "";
    }
    
    	
    public static String updateUser(User user, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", user.getJSON());
    	payload.put("meta", meta.getJSON());
    	   	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("update_user", payload.toString())
        );
        
        if (outJSON.has("msg")) {
            String out = outJSON.getString("msg");
            return out;
        }
        
        return "";
    }
    
    	
    public static String updateGroup(Group group, Meta meta) { 
    	JSONObject payload = new JSONObject();
    	payload.put("obj", group.getJSON());
    	payload.put("meta", meta.getJSON());
    	   	
        JSONObject outJSON = new JSONObject(
        		callMicroserviceRest("update_group", payload.toString())
        );
        
        if (outJSON.has("msg")) {
            String out = outJSON.getString("msg");
            return out;
        }
        
        return "";
    }
    

    public static void execCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader stdInput = new BufferedReader(new 
             InputStreamReader(process.getInputStream()));
        
        BufferedReader stdError = new BufferedReader(new 
             InputStreamReader(process.getErrorStream()));
        
        // Read the output from the command
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        
        // Read any errors from the attempted command
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }

    public static void execScript(String script_name) throws IOException {
        SystemCommands.execCommand(RadonApp.scriptPath + "/" + script_name);
    }
}

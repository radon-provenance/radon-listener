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

package org.radon.listener.model;


import org.json.JSONObject;

public class Collection {
    
    private JSONObject coll;
       
    
    public Collection(JSONObject collJSON) {
    	this.coll = collJSON;
    }
    
    public JSONObject getJSON() {
		return this.coll;
	}


	public Boolean has_field(String fieldName) {
    	return this.coll.has(fieldName);    	
    }
    
    
    public String getUuid() {
    	if (this.has_field("uuid")) {
    		return this.coll.getString("uuid");
    	} else {
    		return "";
    	}
    }
    
    
    public String getName() {
    	if (this.has_field("name")) {
    		return this.coll.getString("name");
    	} else {
    		return "";
    	}
    }
    
    
    public String getContainer() {
    	if (this.has_field("container")) {
    		return this.coll.getString("container");
    	} else {
    		return "";
    	}
    }
    
    
    public String toString() {
        return this.coll.toString();
    }

    
}

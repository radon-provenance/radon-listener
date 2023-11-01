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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Group {
    
    private JSONObject group;
    
    
    public Group(JSONObject groupJSON) {
    	this.group = groupJSON;
    }
    
    public JSONObject getJSON() {
		return this.group;
	}
    
    
    public Boolean has_field(String fieldName) {
    	return this.group.has(fieldName);    	
    }
    
    public String getUuid() {
    	if (this.has_field("uuid")) {
    		return this.group.getString("uuid");
    	} else {
    		return "";
    	}
    }

    public String getName() {
    	if (this.has_field("name")) {
    		return this.group.getString("name");
    	} else {
    		return "";
    	}
    }

    public List<String> getMembers() {
    	List<String> members = new ArrayList<String>();
        if (this.has_field("members")) {
            JSONArray memberArray = this.group.getJSONArray("members");
            for (int i = 0 ; i < memberArray.length(); i++) {
            	members.add(memberArray.getString(i));
            }
        }
        return members;
    }
    
    public String toString() {
        return this.group.toString();
    }
    
    
}

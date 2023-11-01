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

public class User {
	
	private JSONObject user;
    
    
    public User(JSONObject userJSON) {
    	this.user = userJSON;
    }
    
    public JSONObject getJSON() {
		return this.user;
	}
    
    
    public Boolean has_field(String fieldName) {
    	return this.user.has(fieldName);    	
    }
    	
    
    public String getUuid() {
    	if (this.has_field("uuid")) {
    		return this.user.getString("uuid");
    	} else {
    		return "";
    	}
    }

    public String getLogin() {
    	if (this.has_field("login")) {
    		return this.user.getString("login");
    	} else {
    		return "";
    	}
    }

    public String getEmail() {
    	if (this.has_field("email")) {
    		return this.user.getString("email");
    	} else {
    		return "";
    	}
    }

    public String getFullName() {
    	if (this.has_field("fullname")) {
    		return this.user.getString("fullname");
    	} else {
    		return "";
    	}
    }

    public String getPassword() {
    	if (this.has_field("password")) {
    		return this.user.getString("password");
    	} else {
    		return "";
    	}
    }

    public Boolean getActive() {
    	if (this.has_field("active")) {
    		return this.user.getBoolean("active");
    	} else {
    		return true;
    	}
    }

    public Boolean getAdministrator() {
    	if (this.has_field("administrator")) {
    		return this.user.getBoolean("administrator");
    	} else {
    		return false;
    	}
    }

    public List<String> getGroups() {
    	List<String> groups = new ArrayList<String>();
        if (this.has_field("groups")) {
            JSONArray memberArray = this.user.getJSONArray("groups");
            for (int i = 0 ; i < memberArray.length(); i++) {
                groups.add(memberArray.getString(i));
            }
        }
        return groups;
    }
    
    public String toString() {
        return this.user.toString();
    }
}

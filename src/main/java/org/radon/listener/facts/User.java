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

package org.radon.listener.facts;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
    
    private String uuid;
    private String name;
    private String email;
    private Boolean active;
    private List<String> groups;
    
    
    public User(JSONObject userJSON) {
        if (userJSON.has("uuid")) {
            this.uuid = userJSON.getString("uuid");
        } else {
            this.uuid = "UnknownUUID";
        }
        if (userJSON.has("name")) {
            this.name = userJSON.getString("name");
        } else {
            this.name = "";
        }
        if (userJSON.has("email")) {
            this.email = userJSON.getString("email");
        } else {
            this.email = "";
        }
        if (userJSON.has("active")) {
            this.active = userJSON.getBoolean("active");
        } else {
            this.active = true;
        }

        if (userJSON.has("groups")) {
            this.groups = new ArrayList<String>();
            JSONArray memberArray = userJSON.getJSONArray("groups");
            for (int i = 0 ; i < memberArray.length(); i++) {
                this.groups.add(memberArray.getString(i));
            }
        }
    }
    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
}

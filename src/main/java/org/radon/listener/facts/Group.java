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

public class Group {
    
    private String uuid;
    private String name;
    private List<String> members;
    
    
    public Group(JSONObject groupJSON) {
        if (groupJSON.has("uuid")) {
            this.uuid = groupJSON.getString("uuid");
        } else {
            this.uuid = "UnknownUUID";
        }
        if (groupJSON.has("name")) {
            this.name = groupJSON.getString("name");
        } else {
            this.name = "";
        }

        if (groupJSON.has("members")) {
            this.members = new ArrayList<String>();
            JSONArray memberArray = groupJSON.getJSONArray("members");
            for (int i = 0 ; i < memberArray.length(); i++) {
                this.members.add(memberArray.getString(i));
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

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}

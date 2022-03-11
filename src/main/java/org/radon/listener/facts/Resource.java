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

import java.util.HashMap;

import org.json.JSONObject;

public class Resource {
    
    private String uuid;
    private String url;
    private String container;
    private String name;
    private String createTS;
    private String modifyTS;
    private HashMap<String, String> metadata = new HashMap<String, String>();
    
    
    public Resource(JSONObject groupJSON) {
        if (groupJSON.has("uuid")) {
            this.uuid = groupJSON.getString("uuid");
        } else {
            this.uuid = "UnknownUUID";
        }
        if (groupJSON.has("url")) {
            this.url = groupJSON.getString("url");
        } else {
            this.url = "None";
        }
        if (groupJSON.has("container")) {
            this.container = groupJSON.getString("container");
        } else {
            this.container = "/";
        }
        if (groupJSON.has("name")) {
            this.name = groupJSON.getString("name");
        } else {
            this.name = "";
        }
        if (groupJSON.has("create_ts")) {
            this.createTS = groupJSON.getString("create_ts");
        } else {
            this.createTS = "";
        }
        if (groupJSON.has("modify_ts")) {
            this.modifyTS = groupJSON.getString("modify_ts");
        } else {
            this.modifyTS = "";
        }

        if (groupJSON.has("metadata")) {
            JSONObject metadataObj = groupJSON.getJSONObject("metadata");
            metadataObj.keySet().forEach(keyStr ->
            {
                String keyValue = metadataObj.getString(keyStr);
                metadata.put(keyStr, keyValue);
            });
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getCreateTS() {
        return createTS;
    }

    public void setCreateTS(String createTS) {
        this.createTS = createTS;
    }

    public String getModifyTS() {
        return modifyTS;
    }

    public void setModifyTS(String modifyTS) {
        this.modifyTS = modifyTS;
    }

    public HashMap<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(HashMap<String, String> metadata) {
        this.metadata = metadata;
    }
    
}

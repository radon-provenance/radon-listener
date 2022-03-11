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

public class DeleteResource {
    
    private Resource resc;
    
    public DeleteResource(JSONObject rescJSON) {
        this.resc = new Resource(rescJSON);
    }
    
    public Resource getResource() {
        return resc;
    }

    public String getUuid() {
        return this.resc.getUuid();
    }

    public void setUuid(String uuid) {
        this.resc.setUuid(uuid);
    }

    public String getUrl() {
        return this.resc.getUrl();
    }
    
    public void setUrl(String url) {
        this.resc.setUrl(url);
    }

    public String getContainer() {
        return this.resc.getContainer();
    }
   
    public void setContainer(String container) {
        this.resc.setContainer(container);
    }

    public String getName() {
        return this.resc.getName();
    }

    public void setName(String name) {
        this.resc.setName(name);
    }

    public String getCreateTS() {
        return this.resc.getCreateTS();
    }

    public void setCreateTS(String createTS) {
        this.resc.setCreateTS(createTS);
    }

    public String getModifyTS() {
        return this.resc.getModifyTS();
    }

    public void setModifyTS(String modifyTS) {
        this.resc.setModifyTS(modifyTS);
    }
    
    public HashMap<String, String> getMetadata() {
        return this.resc.getMetadata();
    }
    
    public void setMetadata(HashMap<String, String> metadata) {
        this.resc.setMetadata(metadata);
    }

}

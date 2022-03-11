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

public class DeleteCollection {
    
    private Collection coll;
    
    public DeleteCollection(JSONObject collJSON) {
        this.coll = new Collection(collJSON);
    }
    
    public Collection getCollection() {
        return coll;
    }

    public String getUuid() {
        return this.coll.getUuid();
    }

    public void setUuid(String uuid) {
        this.coll.setUuid(uuid);
    }

    public String getContainer() {
        return this.coll.getContainer();
    }
   
    public void setContainer(String container) {
        this.coll.setContainer(container);
    }

    public String getName() {
        return this.coll.getName();
    }

    public void setName(String name) {
        this.coll.setName(name);
    }

    public String getCreateTS() {
        return this.coll.getCreateTS();
    }

    public void setCreateTS(String createTS) {
        this.coll.setCreateTS(createTS);
    }

    public String getModifyTS() {
        return this.coll.getModifyTS();
    }

    public void setModifyTS(String modifyTS) {
        this.coll.setModifyTS(modifyTS);
    }
    
    public HashMap<String, String> getMetadata() {
        return this.coll.getMetadata();
    }
    
    public void setMetadata(HashMap<String, String> metadata) {
        this.coll.setMetadata(metadata);
    }

}

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

public class UpdateCollection {
    
    private Collection collPre;
    private Collection collPost;

    public UpdateCollection(JSONObject collPreJSON, JSONObject collPostJSON) {
        this.collPre = new Collection(collPreJSON);
        this.collPost = new Collection(collPostJSON);
    }
    
    public Collection getCollPre() {
        return this.collPre;
    }
    
    public Collection getCollPost() {
        return this.collPost;
    }

    public String getUuidPre() {
        return this.collPre.getUuid();
    }

    public void setUuidPre(String uuid) {
        this.collPre.setUuid(uuid);
    }

    public String getUuidPost() {
        return this.collPost.getUuid();
    }

    public void setUuidPost(String uuid) {
        this.collPost.setUuid(uuid);
    }

    public String getContainerPre() {
        return this.collPre.getContainer();
    }
   
    public void setContainerPre(String container) {
        this.collPre.setContainer(container);
    }

    public String getContainerPost() {
        return this.collPost.getContainer();
    }
   
    public void setContainerPost(String container) {
        this.collPost.setContainer(container);
    }

    public String getNamePre() {
        return this.collPre.getName();
    }

    public void setNamePre(String name) {
        this.collPre.setName(name);
    }

    public String getNamePost() {
        return this.collPost.getName();
    }

    public void setNamePost(String name) {
        this.collPost.setName(name);
    }

    public String getCreateTSPre() {
        return this.collPre.getCreateTS();
    }

    public void setCreateTSPre(String createTS) {
        this.collPre.setCreateTS(createTS);
    }

    public String getCreateTSPost() {
        return this.collPost.getCreateTS();
    }

    public void setCreateTSPost(String createTS) {
        this.collPost.setCreateTS(createTS);
    }

    public String getModifiedTSPre() {
        return this.collPre.getModifyTS();
    }

    public void setModifiedTSPre(String modifyTS) {
        this.collPre.setModifyTS(modifyTS);
    }

    public String getModifiedTSPost() {
        return this.collPost.getModifyTS();
    }

    public void setModifiedTSPost(String modifyTS) {
        this.collPost.setModifyTS(modifyTS);
    }
    
    public HashMap<String, String> getMetadataPre() {
        return this.collPre.getMetadata();
    }
    
    public void setMetadataPre(HashMap<String, String> metadata) {
        this.collPre.setMetadata(metadata);
    }
    
    public HashMap<String, String> getMetadataPost() {
        return this.collPost.getMetadata();
    }
    
    public void setMetadataPost(HashMap<String, String> metadata) {
        this.collPost.setMetadata(metadata);
    }

}

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

public class UpdateResource {
    
    private Resource rescPre;
    private Resource rescPost;

    public UpdateResource(JSONObject rescPreJSON, JSONObject rescPostJSON) {
        this.rescPre = new Resource(rescPreJSON);
        this.rescPost = new Resource(rescPostJSON);
    }
    
    public Resource getRescPre() {
        return this.rescPre;
    }
    
    public Resource getRescPost() {
        return this.rescPost;
    }

    public String getUuidPre() {
        return this.rescPre.getUuid();
    }

    public void setUuidPre(String uuid) {
        this.rescPre.setUuid(uuid);
    }

    public String getUuidPost() {
        return this.rescPost.getUuid();
    }

    public void setUuidPost(String uuid) {
        this.rescPost.setUuid(uuid);
    }

    public String getUrlPre() {
        return this.rescPre.getUrl();
    }
    
    public void setUrlPre(String url) {
        this.rescPre.setUrl(url);
    }

    public String getUrlPost() {
        return this.rescPost.getUrl();
    }
    
    public void setUrlPost(String url) {
        this.rescPost.setUrl(url);
    }

    public String getContainerPre() {
        return this.rescPre.getContainer();
    }
   
    public void setContainerPre(String container) {
        this.rescPre.setContainer(container);
    }

    public String getContainerPost() {
        return this.rescPost.getContainer();
    }
   
    public void setContainerPost(String container) {
        this.rescPost.setContainer(container);
    }

    public String getNamePre() {
        return this.rescPre.getName();
    }

    public void setNamePre(String name) {
        this.rescPre.setName(name);
    }

    public String getNamePost() {
        return this.rescPost.getName();
    }

    public void setNamePost(String name) {
        this.rescPost.setName(name);
    }

    public String getCreateTSPre() {
        return this.rescPre.getCreateTS();
    }

    public void setCreateTSPre(String createTS) {
        this.rescPre.setCreateTS(createTS);
    }

    public String getCreateTSPost() {
        return this.rescPost.getCreateTS();
    }

    public void setCreateTSPost(String createTS) {
        this.rescPost.setCreateTS(createTS);
    }

    public String getModifiedTSPre() {
        return this.rescPre.getModifyTS();
    }

    public void setModifiedTSPre(String modifyTS) {
        this.rescPre.setModifyTS(modifyTS);
    }

    public String getModifiedTSPost() {
        return this.rescPost.getModifyTS();
    }

    public void setModifiedTSPost(String modifyTS) {
        this.rescPost.setModifyTS(modifyTS);
    }
    
    public HashMap<String, String> getMetadataPre() {
        return this.rescPre.getMetadata();
    }
    
    public void setMetadataPre(HashMap<String, String> metadata) {
        this.rescPre.setMetadata(metadata);
    }
    
    public HashMap<String, String> getMetadataPost() {
        return this.rescPost.getMetadata();
    }
    
    public void setMetadataPost(HashMap<String, String> metadata) {
        this.rescPost.setMetadata(metadata);
    }

}

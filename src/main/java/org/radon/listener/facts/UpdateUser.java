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

import java.util.List;
import org.json.JSONObject;

public class UpdateUser {
    

    private User userPre;
    private User userPost;
    
    
    public UpdateUser(JSONObject userPreJSON, JSONObject userPostJSON) {
        this.userPre = new User(userPreJSON);
        this.userPost = new User(userPostJSON);
    }
    
    public User getUserPre() {
        return this.userPre;
    }
    
    public User getUserPost() {
        return this.userPost;
    }

    public String getUuidPre() {
        return this.userPre.getUuid();
    }

    public String getUuidPost() {
        return this.userPost.getUuid();
    }

    public void setUuidPre(String uuid) {
        this.userPre.setUuid(uuid);
    }

    public void setUuidPost(String uuid) {
        this.userPost.setUuid(uuid);
    }

    public String getNamePre() {
        return this.userPre.getName();
    }

    public String getNamePost() {
        return this.userPost.getName();
    }

    public void setNamePre(String name) {
        this.userPre.setName(name);
    }

    public void setNamePost(String name) {
        this.userPost.setName(name);
    }

    public String getEmailPre() {
        return this.userPre.getEmail();
    }

    public String getEmailPost() {
        return this.userPost.getEmail();
    }

    public void setEmailPre(String email) {
        this.userPre.setEmail(email);
    }

    public void setEmailPost(String email) {
        this.userPost.setEmail(email);
    }

    public Boolean getActivePre() {
        return this.userPre.getActive();
    }

    public Boolean getActivePost() {
        return this.userPost.getActive();
    }

    public void setActivePre(Boolean active) {
        this.userPre.setActive(active);
    }

    public void setActivePost(Boolean active) {
        this.userPost.setActive(active);
    }

    public List<String> getGroupsPre() {
        return this.userPre.getGroups();
    }

    public List<String> getGroupsPost() {
        return this.userPost.getGroups();
    }

    public void setGroupsPre(List<String> groups) {
        this.userPre.setGroups(groups);
    }

    public void setGroupsPost(List<String> groups) {
        this.userPost.setGroups(groups);
    }
}

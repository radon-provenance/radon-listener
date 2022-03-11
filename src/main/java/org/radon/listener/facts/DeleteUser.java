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

public class DeleteUser {
    
    private User user;
    
    public DeleteUser(JSONObject userJSON) {
        this.user = new User(userJSON);
    }
    
    public User getUser() {
        return user;
    }

    public String getUuid() {
        return this.user.getUuid();
    }

    public void setUuid(String uuid) {
        this.user.setUuid(uuid);
    }

    public String getName() {
        return this.user.getName();
    }

    public void setName(String name) {
        this.user.setName(name);
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public void setEmail(String email) {
        this.user.setEmail(email);
    }

    public Boolean getActive() {
        return this.user.getActive();
    }

    public void setActive(Boolean active) {
        this.user.setActive(active);
    }

    public List<String> getGroups() {
        return this.user.getGroups();
    }

    public void setGroups(List<String> groups) {
        this.user.setGroups(groups);
    }
}

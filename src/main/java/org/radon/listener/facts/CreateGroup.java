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

public class CreateGroup {
    
    private Group group;
    
    public CreateGroup(JSONObject groupJSON) {
        this.group = new Group(groupJSON);
    }
    
    public Group getGroup() {
        return group;
    }

    public String getUuid() {
        return this.group.getUuid();
    }

    public void setUuid(String uuid) {
        this.group.setUuid(uuid);
    }

    public String getName() {
        return this.group.getName();
    }

    public void setName(String name) {
        this.group.setName(name);
    }

    public List<String> getMembers() {
        return this.group.getMembers();
    }

    public void setMembers(List<String> groups) {
        this.group.setMembers(groups);
    }
}

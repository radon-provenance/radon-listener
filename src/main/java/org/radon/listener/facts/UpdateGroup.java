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

public class UpdateGroup {
    

    private Group groupPre;
    private Group groupPost;
    
    
    public UpdateGroup(JSONObject groupPreJSON, JSONObject groupPostJSON) {
        this.groupPre = new Group(groupPreJSON);
        this.groupPost = new Group(groupPostJSON);
    }
    
    public Group getGroupPre() {
        return groupPre;
    }
    
    public Group getGroupPost() {
        return groupPost;
    }

    public String getUuidPre() {
        return this.groupPre.getUuid();
    }

    public String getUuidPost() {
        return this.groupPost.getUuid();
    }

    public void setUuidPre(String uuid) {
        this.groupPre.setUuid(uuid);
    }

    public void setUuidPost(String uuid) {
        this.groupPost.setUuid(uuid);
    }

    public String getNamePre() {
        return this.groupPre.getName();
    }

    public String getNamePost() {
        return this.groupPost.getName();
    }

    public void setNamePre(String name) {
        this.groupPre.setName(name);
    }

    public void setNamePost(String name) {
        this.groupPost.setName(name);
    }

    public List<String> getMembersPre() {
        return this.groupPre.getMembers();
    }

    public List<String> getMembersPost() {
        return this.groupPost.getMembers();
    }

    public void setMembersPre(List<String> members) {
        this.groupPre.setMembers(members);
    }

    public void setMembersPost(List<String> members) {
        this.groupPost.setMembers(members);
    }
}

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

import org.json.JSONObject;
import org.radon.listener.model.Group;
import org.radon.listener.model.Meta;

public class DeleteFailGroup {
    
    private Group group;
    private Meta meta;
    
    public DeleteFailGroup(JSONObject groupJSON, JSONObject metaJSON) {
        this.group = new Group(groupJSON);
        this.meta = new Meta(metaJSON);
    }
    
    public Group getGroup() {
        return group;
    }

    public Meta getMeta() {
        return meta;
    }

}

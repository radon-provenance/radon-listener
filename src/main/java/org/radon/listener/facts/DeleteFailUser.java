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
import org.radon.listener.model.User;
import org.radon.listener.model.Meta;

public class DeleteFailUser {
    
    private User user;
    private Meta meta;
    
    
    public DeleteFailUser(JSONObject userJSON, JSONObject metaJSON) {
        this.user = new User(userJSON);
        this.meta = new Meta(metaJSON);     
    }
    
    public User getUser() {
        return user;
    }

    public Meta getMeta() {
        return meta;
    }



}

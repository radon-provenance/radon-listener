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
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either exBeforess or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.radon.listener.facts;

import org.json.JSONObject;
import org.radon.listener.model.User;
import org.radon.listener.model.Meta;

public class UpdateFailUser {
    

    private User userBefore;
    private User userAfter;
    private Meta meta;
    
    
    public UpdateFailUser(JSONObject userBeforeJSON, JSONObject userAfterJSON, JSONObject metaJSON) {
        this.userBefore = new User(userBeforeJSON);
        this.userAfter = new User(userAfterJSON);
        this.meta = new Meta(metaJSON);     
    }
    
    public User getUserBefore() {
        return userBefore;
    }
    
    public User getUserAfter() {
        return userAfter;
    }

    public Meta getMeta() {
        return meta;
    }
    
}

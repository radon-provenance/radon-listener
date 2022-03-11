/* Copyright 2022

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

package org.radon.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    
    private Properties properties;
    
    public PropertiesReader(String propertyPath) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(propertyPath);
        this.properties = new Properties();
        this.properties.load(is);
    }
    
    public String getProperty(String name) {
        return this.properties.getProperty(name);
    }

}

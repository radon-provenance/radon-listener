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

package org.radon.listener.workflows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.radon.listener.RadonApp;

public class SystemCommands { 
    
    public static final String LINUX_LAUNCH_CHROME = "google-chrome";


    public static void execCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader stdInput = new BufferedReader(new 
             InputStreamReader(process.getInputStream()));
        
        BufferedReader stdError = new BufferedReader(new 
             InputStreamReader(process.getErrorStream()));
        
        // Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        
        // Read any errors from the attempted command
        System.out.println("Here is the standard error of the command:\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }

    public static void execScript(String script_name) throws IOException {
        SystemCommands.execCommand(RadonApp.scriptPath + "/" + script_name);
    }
}

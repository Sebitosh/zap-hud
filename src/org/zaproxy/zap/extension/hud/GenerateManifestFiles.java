/*
 * Zed Attack Proxy (ZAP) and its related class files.
 * 
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package org.zaproxy.zap.extension.hud;

import java.io.File;
import java.util.Arrays;

/**
 * An easy way to generate the 'files' section of the manifest.
 * Just run it and then paste the output into the right part of ZapZddOn.xml
 */
public class GenerateManifestFiles {

    public GenerateManifestFiles() {
    }
    
    private static void printFiles(File dir, String path) {
        File [] files = dir.listFiles();
        Arrays.sort(files);
        for (File f : files) {
            if (f.isDirectory()) {
                printFiles(f, path + f.getName() + "/");
            } else {
                System.out.println("\t\t<file>" + path + f.getName() + "</file>");
            }
        }
    }

    public static void main(String[] args) {
        printFiles(new File("src/org/zaproxy/zap/extension/hud/files/"), "");
    }

}
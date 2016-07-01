package hoanghh.yaml.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;



public class ConfigUtils {
    
    public static Map<String, String> readYamlConfig(final File path) {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                try {
                    String el[] = line.replaceAll("\\s+", "").split(":");
                    String key = el[0];
                    String value = el[1];
                    
                    map.put(key, value);
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return map;
    } // end method readYamlConfig
    
    public static Map<String, String> readJsonConfig(final File f) {
        try {
            Map<String, String> map = new ObjectMapper().readValue(f, HashMap.class);
            
            return map;
        } catch (IOException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
            return new HashMap<>();
        }
        
    }
}

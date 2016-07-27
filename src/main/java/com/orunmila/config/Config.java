package com.orunmila.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Perfect<perfect@kudi.ai>
 *         Created on 7/27/16.
 */
public class Config {
    private static Config instance;
    private Map<String, String> configs;

    public static Config getInstance() {
        if(instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private Config() {
        try {
            loadConfigsIntoMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadConfigsIntoMap() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        configs = new HashMap<String, String>();

        // convert JSON string to Map
        configs = mapper.readValue(new File("./configuration.json"), new TypeReference<Map<String, String>>(){});
    }

    public String getValue(String key) {
        return configs.get(key);
    }

    public static String get(String key) {
        return getInstance().getValue(key);
    }
}

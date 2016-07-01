package vn.com.datasection.config;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigParser {
    public static Config parse(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Config config = null;
        try {
            config = mapper.readValue(json, Config.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } // end try

        return config;
    } // end method

    public static Config parse(File json) {
        ObjectMapper mapper = new ObjectMapper();
        Config config = null;
        try {
            config = mapper.readValue(json, Config.class);
        } catch (JsonParseException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } // end try

        return config;
    } // end method

} // end class

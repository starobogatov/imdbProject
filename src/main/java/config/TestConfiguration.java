package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfiguration {

    private static final String CONFIG_FILE = "application.properties";

    public static Properties loadConfiguration() {
        Properties properties = new Properties();
        try (InputStream is = getResourceAsStream(CONFIG_FILE)) {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration from file: " + CONFIG_FILE, e);
        }
        return properties;
    }


    private static InputStream getResourceAsStream(String fileName) {
        InputStream resourceStream = ClassLoader.getSystemResourceAsStream(fileName);
        if (resourceStream == null) {
            throw new RuntimeException("Configuration file not found: " + fileName);
        }
        return resourceStream;
    }
}

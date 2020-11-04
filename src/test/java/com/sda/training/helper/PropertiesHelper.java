package com.sda.training.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private static final Properties PROPERTIES;

    static {
        PROPERTIES = getPropertiesFile();
    }

    public static Properties getProperties() {
        return PROPERTIES;
    }

    public static String getBrowserName() {
        return System.getProperty("browserName", getProperties().getProperty("browserName"));
    }

    private static Properties getPropertiesFile() {
        try (final FileInputStream fis = new FileInputStream("selenium.properties")) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}

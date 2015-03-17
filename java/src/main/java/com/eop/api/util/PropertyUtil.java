/**
 * 
 */
package com.eop.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Ravi K
 */
public class PropertyUtil {
    
    public static String API_SANDBOX_URL = "API_SANDBOX_URL";
    public static String API_PROD_URL = "API_PROD_URL";
    public static String API_CERT_PASSWORD = "API_CERT_PASSWORD";
    public static String API_PROD_CLIENT_ID = "API_PROD_CLIENT_ID";
    public static String API_SANDBOX_CLIENT_ID = "API_SANDBOX_CLIENT_ID";
    public static String API_PROD_ENABLE = "API_PROD_ENABLE";
    public static String API_CERT_KEY_ALIAS = "API_CERT_KEY_ALIAS";
    public static String API_CERT_KEY_FILE_NAME = "API_CERT_KEY_FILE_NAME";
    
    private Properties prop = new Properties();

    private PropertyUtil(){}
    
    public static PropertyUtil getInstance() {
        PropertyUtil propertyUtil = new PropertyUtil();
        propertyUtil.loadProperties();
        
        return propertyUtil;
    }
    
    public String getProperty(String name) {
        return (String) prop.get(name);
    }
    
    public Boolean getBooleanProperty(String name) {
         String object = (String) prop.get(name);
         
         if (object == null) return false;
         if (object.equalsIgnoreCase("true")) return true;
         
         return false;
    }

    private void loadProperties() {

        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream == null) {
            System.out.println("property file '" + propFileName + "' not found in the classpath");
        }

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

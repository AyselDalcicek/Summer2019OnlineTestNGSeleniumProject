package com.Bitrix.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties configFile;

    static {        // will be executed only ones / since we do not load the file again and again

        try{
            FileInputStream fileInputStream = new FileInputStream("configuration.properties_Bitrix"); // provides access to file

            configFile = new Properties();       //initialize properties object

            configFile.load(fileInputStream);  // load configuration.properties file

            fileInputStream.close();

        } catch (IOException e) {  // --> we did not write FileNotFoundException  because IOException is parent exception

            System.out.println("Failed to load properties file!");
            e.printStackTrace();   // just print error
            e.printStackTrace();  // just print error information not anything else
        }
    }
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }
}

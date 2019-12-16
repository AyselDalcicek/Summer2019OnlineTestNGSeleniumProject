package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//if  private static Properties configFile; will be public
// ConfigurationReader.configFile.getProperty("browser") direct access

// we declare it as private so we do not need to call "configFile"
// ConfigurationReader.getProperty("browser")

public class ConfigurationReader {   // This class that loads Configuration.properties and returns values based on key name

    //this class will be responsible for loading properties file and will provide access
    //to values based on key names
    //we use Properties class to load custom .properties files

    private static Properties configFile;  // It is reference variable
                                            // This class stands for log in custom .properties file an read it

    static {   // whenever somebody is using this class static block will be executed only ones
                // since we do not load the file again and again we use static block
        try {
            //provides access to file
            //try/catch block stands for handling exceptions
            //if exception occurs, code inside a catch block will be executed
            //any class that is related to InputOutput produce checked exceptions
            //without handling checked exception, you cannot run a code
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
                        // This class that allows us to connect with any class any file get the information from the file

            //initialize properties object
            configFile = new Properties();  // we need to initialize the properties file

            //load configuration.properties file
            configFile.load(fileInputStream);  // this load method produce another checked exceptions.

            //close input stream
            fileInputStream.close();

        } catch (IOException e) {  // --> we did not write FileNotFoundException  because IOException is parent exception
                                        // if we write IOException we do not need to add multiple catch blocks.
                                        // FileNotFoundException is child of IOException
                                        // We can also write Throwable but it is not clear what is going on
            System.out.println("Failed to load properties file!");
            e.printStackTrace();  // just print error information not anything else
        }
    }
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }
}

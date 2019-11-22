package PetStoreAPITest.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvConfig {

    private static String fs = File.separator;
    private static Properties config = new Properties();

    public static void loadData(){
        String configPath = String.format("%ssrc%smain%sresources%stestconfigs%sconfig.properties", fs, fs, fs, fs, fs);
        String sysPath = System.getProperty("user.dir");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(sysPath+configPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String keyName){
        if(config.isEmpty()) loadData();
        return config.getProperty(keyName);
    }


}

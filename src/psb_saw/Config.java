/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psb_saw;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author ASUS
 */
public class Config {
    private Properties properties;
    private String host;
    private String username;
    private String password;
    private String database;
    
    public Config(){
        File file = new File ("Config//Settingan.properties");
        try {
            InputStream in = new FileInputStream(file);
            properties = new Properties();
            properties.load(in);
            host = properties.getProperty("host");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            database = properties.getProperty("database");
        } catch (Exception e) {
            System.out.println("Gagal membaca file konfigurasi");
        }
        
    }
    public String getDatabase(){
        return database;
    }
    public String getHost(){
        return host;
    }
    public String getPassword(){
        return password;
    }
    public Properties getProperties(){
        return properties;
    }
    public String getUsername(){
        return username;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psb_saw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class Koneksi {
    private Connection c = null;
    public Statement st= null;
    public ResultSet rs = null;
    private Config config;
    private String url;
    private String user;
    private String pass;
    public int hasil;
    
    public Koneksi(){
        config = new Config();
        url="jdbc:mysql://"+config.getHost()+"/"+config.getDatabase();
        user= config.getUsername();
        pass= config.getPassword();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan koneksi database");
        }
    } 
    
    public void query (String q){
        try {
            c= DriverManager.getConnection(url, user, pass);
            this.st= c.createStatement();
            this.hasil = st.executeUpdate(q);
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan :"+e);
        }
    }
    
    public void select (String q){
        try {
            c= DriverManager.getConnection(url, user, pass);
            this.st= c.createStatement();
            this.rs= st.executeQuery(q);
        } catch (SQLException e) {
            System.out.println("Kesalahan Pengambilan data :"+e);
        }
    } 
}
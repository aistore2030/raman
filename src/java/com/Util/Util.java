/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author sakshamapp123
 */
public class Util extends HttpServlet {

    //static final String PASSWORD = "paI9!@#$%ykdpRsmHl";
    public static Connection getConnection(String db) throws Exception {

        //   Class.forName("com.mysql.jdbc.Driver");
        //  String strConnectionURL = "jdbc:mysql://localhost:3306/ramanapp?user=ramanapp&password=zaI4!@#$%dkdkTsmHw";
        // String strConnectionURL = "jdbc:mysql://localhost:3306/ramanapp?useUnicode=yes&characterEncoding=UTF-8&user=ramanapp&password=1234";
        // Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        // Connection con = DriverManager.getConnection("jdbc:sqlserver://184.168.47.21;databaseName=ph20979541854_", db, "Raman@1987");
//Connection con = DriverManager.getConnection("jdbc:sqlserver://184.168.47.21;databaseName=ph20979541854_",db, "Raman@1987");
        Connection con = null;
     

        
       
            String password = db + "@968f2@#$ab629c74!@#!@";
System.out.println("ph20875305531_"+db+ "databasename");
            String pw = md5(password);
          
            con = DriverManager.getConnection("jdbc:sqlserver://43.255.152.21;databaseName=ph20875305531_"+db, db, pw);

            
       

        return con;

    }    public static Connection getConnectionS() throws Exception {

        //   Class.forName("com.mysql.jdbc.Driver");
        //  String strConnectionURL = "jdbc:mysql://localhost:3306/ramanapp?user=ramanapp&password=zaI4!@#$%dkdkTsmHw";
        // String strConnectionURL = "jdbc:mysql://localhost:3306/ramanapp?useUnicode=yes&characterEncoding=UTF-8&user=ramanapp&password=1234";
        // Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        // Connection con = DriverManager.getConnection("jdbc:sqlserver://184.168.47.21;databaseName=ph20979541854_", db, "Raman@1987");
//Connection con = DriverManager.getConnection("jdbc:sqlserver://184.168.47.21;databaseName=ph20979541854_",db, "Raman@1987");
        Connection con = null;
     

        
       
           /// String password = db + "@968f2@#$ab629c74!@#!@";
//System.out.println("ph20875305531_"+db+ "databasename");
           // String pw = md5(password);
          
            con = DriverManager.getConnection("jdbc:sqlserver://43.255.152.21;databaseName=ph20875305531_brcmaster", "brcmaster","8c20856bdfc8f2c77436a49fc74ac678");

            
       

        return con;

    }

    public static String md5(String password) throws NoSuchAlgorithmException {
        System.out.println("md5md5md5");

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());
        String pass = sb.toString();
         System.out.println("password  password" + sb.toString());
        return pass;
    }
}

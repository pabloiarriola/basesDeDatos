/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author aa-ol
 */
public class HRIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       String password;
       String userName;
       SQLcomands impl = new implementCommands();
       
       userName = "postgres";
       password = "0000";
       impl.Connect(userName, password);
       impl.DATABASELOGIN("HRIS", userName, password);
      
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import mcgambat.com.business.MessageForm;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class DBConnection {

    private static Connection con = null;
    
    private DBConnection(){};
    
    public static Connection getInstance(){
       
        if(con == null){
            try {
                makeConnection();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mis_gambat_db","root","");
            } catch (Exception ex) {
                new MessageForm("Error",ex.toString(),"error.png");
            }
            
        }
        
        return con;
    }
    
    private static void makeConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
    }
}



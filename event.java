/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class event {
Statement st;
    void addevent(String name, String event, String date, String place, String dis, String uni) {
         //To change body of generated methods, choose Tools | Templates.
         connectToDb();
        String query= "INSERT INTO ind_events(companyname,event,date,place,discription,university)VALUES('"+name+"','"+event+"','"+date+"','"+place+"','"+dis+"','"+uni+"')";
    try {
        st.executeUpdate(query);
    } catch (SQLException ex) {
        Logger.getLogger(event.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }

    private void connectToDb() {
         //To change body of generated methods, choose Tools | Templates.
         String driver="com.mysql.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/j2ee";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            
             
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(event.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}

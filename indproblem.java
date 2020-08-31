/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
class indproblem {
Statement st;
    void addproblem(String name, String pro, String date) {
       connectToDb();
        String query= "INSERT INTO ind_problems(companyname,problem,date)VALUES('"+name+"','"+pro+"','"+date+"')";
    
    try {
        st.executeUpdate(query);
        //To change body of generated methods, choose Tools | Templates.
    } catch (SQLException ex) {
        Logger.getLogger(indproblem.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void connectToDb() {
        String driver="com.mysql.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/j2ee";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            
             
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(indproblem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(indproblem.class.getName()).log(Level.SEVERE, null, ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
}

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
class uniinvite {
Statement st;
    void addinvite(String name, String iname, String dis) {
        connectToDb();
        String query="INSERT INTO special_invi(uniname,indname,invitation)VALUES('"+name+"','"+iname+"','"+dis+"')";
    try {
        st.executeUpdate(query);
    } catch (SQLException ex) {
        Logger.getLogger(uniinvite.class.getName()).log(Level.SEVERE, null, ex);
    }//To change body of generated methods, choose Tools | Templates.
    }

    private void connectToDb() {
       String driver="com.mysql.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/j2ee";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            
             
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(uniinvite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(uniinvite.class.getName()).log(Level.SEVERE, null, ex);
        } //To change body of generated methods, choose Tools | Templates.
    }
    
}

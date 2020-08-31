/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class regservlet extends HttpServlet {
public regservlet() {
 }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet regservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet regservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    PrintWriter out = response.getWriter();
      try
{

 Class.forName("com.mysql.jdbc.Driver"); //load driver
 
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root",""); //create connection
 
 if(request.getParameter("btn_register")!=null) //check register button click event not null
 {

  String firstname,lastname,email,password;
  
  firstname=request.getParameter("txt_firstname"); //txt_firstname
  lastname=request.getParameter("txt_lastname"); //txt_lastname
  email=request.getParameter("txt_email"); //txt_email
  password=request.getParameter("txt_password"); //txt_password
  
  PreparedStatement pstmt=null; //create statement
  
  pstmt=con.prepareStatement("insert into login(uniname,rejno,email,pasword) values(?,?,?,?)"); //sql insert query
  pstmt.setString(1,firstname);
  pstmt.setString(2,lastname);
  pstmt.setString(3,email);
  pstmt.setString(4,password);
  
  pstmt.executeUpdate(); //execute query
     response.sendRedirect("register.jsp");
  request.setAttribute("successMsg","Register Successfully...! Please login"); //register success messeage

  con.close(); //close connection

 }

}
catch(Exception e)
{
  out.println(e);
}

    
    }
      @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


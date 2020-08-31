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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class loginservlat extends HttpServlet {

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
            out.println("<title>Servlet loginservlat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginservlat at " + request.getContextPath() + "</h1>");
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
    if("POST".equalsIgnoreCase(request.getMethod()))
    {
        if(request.getParameter("login")!=null)
        {
            if(request.getParameter("login").equals("Login"))
            {
                String email = request.getParameter("emailLogin");
                String password = request.getParameter("passLogin");
                
                Connection con = null;
                PreparedStatement ps;
                ResultSet rs;
                String query;
                
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                try
                {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/j2ee","root","");
                    query = "Select * from login where email=? and pasword=?";
                    ps = con.prepareStatement(query);
                    ps.setString(1,email);
                    ps.setString(2,password);
                    rs = ps.executeQuery();
                    
                    if(rs.next())
                    {
                        //Login successful!
                        //Creating Session...
                        HttpSession session = request.getSession();
                        session.setAttribute("emailLogin", email);
                        response.sendRedirect("university.jsp"+email);
                    }
                    else
                    {
                        out.println("Invalid Email id or Password!!! Please ");
                        out.println("<a href=\"university login.jsp\"> Try Again </a>");
                        
                    }
                    
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }
               
           }
        }
        else if (request.getParameter("registerLogin")!=null)
        {
            if(request.getParameter("registerLogin").equals("I'm New User"))
            {
                response.sendRedirect("register.jsp");
            }
        }
            
    }  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

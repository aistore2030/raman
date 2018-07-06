/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sakshamapp123
 */
public class Util extends HttpServlet {

    static final String URL = "jdbc:mysql://localhost:3306/";

    static final String DATABASE_NAME = "ramanapp";
    static final String USERNAME = "ramanapp";
    ///static final String PASSWORD="1234";

    static final String PASSWORD = "zaI4!@#$%dkdkTsmHw";
    //static final String PASSWORD = "paI9!@#$%ykdpRsmHl";

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        //  String strConnectionURL = "jdbc:mysql://localhost:3306/ramanapp?user=ramanapp&password=zaI4!@#$%dkdkTsmHw";
        // String strConnectionURL = "jdbc:mysql://localhost:3306/ramanapp?useUnicode=yes&characterEncoding=UTF-8&user=ramanapp&password=1234";
        Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);

        // Connection con=DriverManager.getConnection(strConnectionURL); 
        return con;

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
            out.println("<title>Servlet Util</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Util at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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

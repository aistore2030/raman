/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author newuser
 */
public class Column_Name extends HttpServlet {

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
          response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Connection con = Util.getConnection();
            Statement st = con.createStatement();

            String username = request.getParameter("username");

            String q = "select * from register where id=1";

            System.out.println(q);
            ResultSet rs = st.executeQuery(q);

           
            ArrayList<Column_Name> a;
            a = new ArrayList<>();
            while (rs.next()) {

                Column_Name a1 = new Column_Name();
                //    a1.balance = rs.getString(1);
                a1.c0 = rs.getString(1);
                a1.c1 = rs.getString(2);
                a1.c2 = rs.getString(3);
                a1.c3 = rs.getString(4);
                a1.c4 = rs.getString(5);
                a1.c5 = rs.getString(6);
                a1.c6 = rs.getString(7);
                a1.c7 = rs.getString(8);
                a1.c8 = rs.getString(9);
                a1.c9 = rs.getString(10);
                a1.c10 = rs.getString(11);
                a1.c11 = rs.getString(12);
                
                
                
                  a.add(a1);
            }
 Gson gson = new GsonBuilder().create();
                String jsonArray = gson.toJson(a);
                //out.println(messages); 
                out.write(jsonArray);
            //out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Name\": \""+name+"\",\"mobile\":\""+mobile+"\"}");
        } catch (Exception e) {
            out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\"  }");
            e.printStackTrace();
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

    private String c0;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String c5;
    private String c6;
    private String c7;
    private String c8;
    private String c9;
    private String c10;
    private String c11;

}

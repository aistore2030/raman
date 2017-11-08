/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemAPI;

import com.Util.Util;
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
public class Detail extends HttpServlet {

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

            String q = "select * from reg where username='" + username + "' and id=1";

            System.out.println(q);
            ResultSet rs1 = st.executeQuery(q);

            while (rs1.next()) {

                String id1 = rs1.getString("id1");
            }

            String query = "select * from reg where username='" + username + "' ";

            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            ArrayList<Detail> a;
            a = new ArrayList<>();
            while (rs.next()) {

                Detail a1 = new Detail();
                //    a1.balance = rs.getString(1);
                a1.name = rs.getString(2);
                a.add(a1);
            }

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
    public String name;
}

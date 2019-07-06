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
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saksham
 */
public class Customer extends HttpServlet {

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
        Connection con = null;
        Statement st1 = null;
                Statement st = null;
        PrintWriter out = response.getWriter();
       

        try {
           
           
            String db = request.getParameter("dbname");
            
            System.out.println(db + "dbbbbbbbbbbbbbbb");
          
            ResultSet rs;
             ResultSet rs1;
            con = Util.getConnectionS();
            st = con.createStatement();
             st1 = con.createStatement();
           
            String query2 = "SELECT  * FROM customermaster where db_pin='"+db+"'";
            rs = st.executeQuery(query2);

            System.out.println(66);
            if (rs.next()) {
                out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"name\": \"" + rs.getString("name") + "\",\"email\": \"" + rs.getString("email") + "\",\"support\": \"" + rs.getString("support") + "\",\"address\": \"" + rs.getString("address")+ "\",\"purches_date\": \"" + rs.getString("purches_date") + "\",\"expiry_date\": \"" + rs.getString("expiry_date") + "\"}");
            } else {
                out.println("{\"Error\": \"True\" ,\"Message\": \"username or password mismatches\"  }");
               
            }


        } catch (Exception e) {
            out.println(e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
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

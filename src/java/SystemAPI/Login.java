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
 * @author sakshamapp123
 */
public class Login extends HttpServlet {

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
        Statement st = null;
        String c1 = request.getParameter("username");
        String c2 = request.getParameter("password");
        // String id = request.getParameter("txid");
        ResultSet rs;

        //String query = "select  sum(cr)- sum(dr as s from register r , transactions t where r.username=t.username and r.username='"+username+"' and password='"+password+"'  ";
        String query = "select *  from  register    where   c1='" + c1 + "' and  c2='" + c2 + "'    ";

        System.out.println(query);
        PrintWriter out = response.getWriter();
        try {
            // PrintWriter out=response.getWriter(); 

            con = Util.getConnection();
            st = con.createStatement();

            rs = st.executeQuery(query);

            if (rs.next()) {
                System.out.println(61);
                out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Roll\": \""+rs.getString("c13")+"\"  ,\"Name\": \""+rs.getString("c1")+"\",\"Email\": \""+rs.getString("c1")+"\",\"Mobile\": \""+rs.getString("c3")+"\",\"Avtar\": \"http://papafast.com:8080/MobiTop/ay/images/1.png\"}");

            } else {
                out.println("{\"Error\": \"True\" ,\"Message\": \"Failed\"  }");
                //  out.print("Username and Password are Invalid!!");
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

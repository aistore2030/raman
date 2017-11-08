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
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sakshamapp123
 */
public class Profile extends HttpServlet {

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
        try{
         Connection con = Util.getConnection();
            Statement st = con.createStatement();
           String id = request.getParameter("c0");
            String name = request.getParameter("c1");
            String email = request.getParameter("c2");
            String mobile = request.getParameter("c3");
             String username = request.getParameter("c4");

            String query = "update register set name='" + name + "'  , mobile='" + mobile + "'    where id'" + id + "'  ";

            System.out.println(query);
            int i = st.executeUpdate(query);

            if (i > 0) {
                request.setAttribute("msg", "Your Details updated Successfully!!");
               
               
                 out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Name\": \""+name+"\",\"mobile\":\""+mobile+"\"}");
          
            } else {
                request.setAttribute("msg", "Your Details  are Invalid!!");
                 out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  ,\"Name\": \""+name+"\",\"mobile\":\""+mobile+"\"}");
               
            }

           

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

}

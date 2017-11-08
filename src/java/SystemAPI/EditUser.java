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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sakshamapp123
 */
public class EditUser extends HttpServlet {

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
           
           String id = request.getParameter("c0").trim();

            String c3 = request.getParameter("c3").trim();
            
            String c4 = request.getParameter("c4").trim();
            
             String c5 = request.getParameter("c5").trim();
String c6 = request.getParameter("c6").trim();
String c7 = request.getParameter("c7").trim();
String c8 = request.getParameter("c8").trim();
String c9 = request.getParameter("c9").trim();
String c10 = request.getParameter("c10").trim();
String c11 = request.getParameter("c11").trim();
String c12 = request.getParameter("c12").trim();
String c13 = request.getParameter("c13").trim();
//String c14 = request.getParameter("c14").trim();


//String c5 = request.getParameter("c5");



            String query = "update register set c3='" + c3 + "'  , c4='" + c4 + "', c5='" + c5 + "', c6='" + c6 + "', c7='" + c7 + "', c8='" + c8 + "', c9='" + c9 + "', c10='" + c10 + "', c11='" + c11 + "', c12='" + c12 + "', c13='" + c13 + "' where id=" + id + "  ";

            System.out.println(query);
            int i = st.executeUpdate(query);

            if (i > 0) {
                request.setAttribute("msg", "Your Details updated Successfully!!");
               
               
                 out.println("{\"Error\": \"False\" ,\"Message\": \"Success\"  }");
          
            } else {
                request.setAttribute("msg", "Your Details  are Invalid!!");
                 out.println("{\"Error\": \"False\" ,\"Message\": \"Success\" }");
               
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

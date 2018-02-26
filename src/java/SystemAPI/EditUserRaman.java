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
 * @author newuser
 */
public class EditUserRaman extends HttpServlet {

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
         System.out.println("EditUserRaman");
         response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");       
        PrintWriter out = response.getWriter();
        try{
         Connection con = Util.getConnection();
            Statement st = con.createStatement();
          // String a[]=new String[50];
             String a=request.getParameter("a").trim();
               //      a= request.getParameterValues("a");
String b[]=new String[50];
   System.out.println(a);
             String id = request.getParameter("id").trim();
             String ab = request.getParameter("ab");
              String st1 = request.getParameter("st");
int j=0;
            int count = Integer.parseInt(request.getParameter("count").trim());
               System.out.println(count);
            String c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;
            for(int i=0;i<50;i++){
               if(i<count){
                   j=i+3;
                   b[i]=request.getParameter("c"+j);
               }
               else{
                   b[i]=null;
               }
                System.out.println(b[i]);
            }
            
            String query = "update register set c3='" + b[0] + "'  , c4='" + b[1] + "', c5='" + b[2] + "', c6='" + b[3] + "'"
                    + ", c7='" + b[4] + "', c8='" + b[5] + "', c9='" + b[6] + "', c10='" + b[7] + "', c11='" + b[8] + "',"
                    + " c12='" + b[9] + "', c13='" + b[10] + "', c14='" + b[11] + "', c15='" + b[12] + "', c16='" + b[13] + "', c"
                    + "17='" + b[14] + "', c18='" + b[15] + "', c19='" + b[16] + "', c20='" + b[17] + "', c21='" + b[18] + "', c22='" + b[19] + "', c"
                    + "23='" + b[20] + "', c24='" + b[21] + "', c25='" + b[22] + "', c26='" + b[23] + "', c27='" + b[24] + "', c28='" + b[25] + "', c29"
                    + "='" + b[26] + "', c30='" + b[27] + "', c31='" + b[28] + "', c32='" + b[29] + "', c33='" + b[30] + "',status='"+st1+"'"
                    + " where id=" + id + "  ";

            System.out.println(query);
            int i = st.executeUpdate(query);

            if (i > 0) {
                request.setAttribute("msg", "Your Details updated Successfully!!");
               
               
                 out.println("{\"Error\": \"False\" ,\"Message\": \"success\" ,\"status\": \"success\"  }");
          
            } else {
                request.setAttribute("msg", "Your Details  are Invalid!!");
                 out.println("{\"Error\": \"False\" ,\"Message\": \"Failed\" }");
               
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

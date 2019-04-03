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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saksham
 */
public class GetidDetails extends HttpServlet {

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
        System.out.println("GetidDetails");
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
  
        try {
        String db=request.getParameter("dbname");
        String c1 = request.getParameter("username");
       String c2 = request.getParameter("password");
            Connection con = Util.getConnection(db);
            Statement st = con.createStatement();

            String b[] = new String[50];
        
            String id = request.getParameter("id").trim();
            System.out.println(id + "id");
       
           
          
            System.out.println("st1st1st1st1st1st1st1st1");
            int j = 0;
            int count = Integer.parseInt(request.getParameter("count").trim());

            System.out.println(id + count + "4355555555555555555555553");
            ////////////////////////////////
             String query = "select top 1 *  from  register    where   c1='" + c1 + "' and  c2='" + c2 + "' and id='"+id+"'";

            System.out.println(query);
            ResultSet rs3 = st.executeQuery(query);
            String[] carray = new String[60];
            int column_count = 0;
            while (rs3.next()) {
                column_count =count; //Integer.parseInt(rs3.getString("column_count").trim());
                System.out.println(column_count);
                System.out.println("ccccccccccccccc");
                for (int i = 0; i < column_count + 4; i++) {
                    System.out.println("forrrrrrr");
                    if (i == 0) {
                        carray[i] = "id";
                        System.out.println("iffffffffff");
                    } else {
                        System.out.println("elseeeeeee");
                        carray[i] = rs3.getString(i + 5);

                    }
                    //System.out.println(carray[i]);
                    carray[50] = rs3.getString("column_count");
                    carray[51] = rs3.getString("document");
                    System.out.println("2222222222222");
                }
            }

            String message = "Hello,"
                    + "You have upload following data in the system"
                    + "<table>";
            System.out.println("33333333333333");
            //////////////////////////////////////////
            // System.out.println(count);
            String c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30;

            for (int i = 0; i < 50; i++) {
                System.out.println(count+"count");
                if (i < count) {
                    j = i + 3;
                    System.out.println(j + "5555555555555");
                   // b[i] = new String(request.getParameter("c" + j).getBytes("UTF-8"), "UTF-8");
                    System.out.println(j+"jjjj");
//System.out.println(request.getParameter("c" + j)+"c[value]");
                   
                      System.out.println(i+"i"+b[i]+"=c"+j+"tttttttttttttttt");
                   // int ccount = Integer.parseInt(carray[50]);
            message = message + "<tr><td>" + carray[i] + "</td></tr>";
                    //if ((i >= 2) && (i <= (ccount + 2))) {
                    
                       
                    //}

                } else {
                    System.out.println("9999999999999");
                    b[i] = null;
                }
                //  System.out.println(b[i]);
            }
            //    log.info(new String(data.toString().getBytes("UTF-8"), "UTF-8"));

            message = message + "</table>";

 
            message = message;
           out.println(message);
            System.out.println(query);
      

        } catch (Exception e) {
            System.out.println(e.getMessage());
            out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\" ,\"status\": \"Failed\"  }");
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
    private String a0;
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
    private String c54;
    private String c11;
    private String c12;
    private String c13;
    private String c14;
    private String c15;
    private String c16;
    private String c17, c20, c18, c19, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c50, c51;
    private String c52, c53, c35, c36, c37;
}

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
import java.util.Arrays;
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
   response.setContentType("application/txt");
     //   response.setHeader("Expires", "0");
     //   response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
      //  response.setHeader("Pragma", "public");
 // response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String db = request.getParameter("dbname");
            String c1 = request.getParameter("username");
            String c2 = request.getParameter("password");
            Connection con = Util.getConnection(db);
            Statement st = con.createStatement();

            String b[] = new String[50];

            String id = request.getParameter("id").trim();
            System.out.println(id + "id");
            String st1 = "";
            st1 = request.getParameter("st");
            System.out.println(st1 + "st1");
            System.out.println(st1 + "st1st1st1st1st1st1st1st1");
            int j = 0;
            int count = Integer.parseInt(request.getParameter("count").trim());

            System.out.println(id + st1 + count + "4355555555555555555555553");
            ////////////////////////////////
            // String query = "select top 1 * from register  ";

            String query = "select top 1 * from register  ";

            System.out.println(query);
            ResultSet rs31 = st.executeQuery(query);
            String[] carray = new String[60];
            int column_count = 0;
            while (rs31.next()) {
                column_count = count;//Integer.parseInt(rs31.getString("column_count").trim());
                System.out.println(column_count);
                for (int i = 3; i < column_count + 4; i++) {

                    if (i == 3) {
                        carray[i] = "id";
                    } else {
                        carray[i] = rs31.getString(i + 1);

                    }
                 //   out.println(carray[i]);
                    System.out.println(carray[i]);
                    carray[50] = rs31.getString("column_count");
                    carray[51] = rs31.getString("document");

                }
            }
            String query1 = "select top 1 *  from  register    where   c1='" + c1 + "' and  c2='" + c2 + "' and id='" + id + "'";

            System.out.println(query1);
            ResultSet rs41 = st.executeQuery(query1);
            String[] darray = new String[60];

            while (rs41.next()) {
                for (int i = 3; i < column_count + 4; i++) {

                    if (i == 3) {
                        darray[i] = "number";
                    } else {
                        darray[i] = rs41.getString(i + 1);

                    }
                //    out.println(darray[i]);
                    System.out.println(darray[i]);
                    darray[50] = rs41.getString("column_count");
                    darray[51] = rs41.getString("document");
                }
            }

            
            
            
            
                 for (int i = 2; i < column_count + 4; i++) {

                      out.println(carray[i]+','+darray[i]);
                      
                   
                }
                 
                 
                 
            String carrayCombine = Arrays.toString(carray);

//System.out.println(carrayCombine);
            String darrayCombine = Arrays.toString(darray);
            //System.out.println(carrayCombine);
            //System.out.println(carrayCombine + "#" + darrayCombine);
//out.println(carrayCombine + "#" + darrayCombine);
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

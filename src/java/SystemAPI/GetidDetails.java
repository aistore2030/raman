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
import java.sql.SQLException;
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
        System.out.println("EditUserNew");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
  
        try {
        String db=request.getParameter("dbname");
            Connection con = Util.getConnection(db);
            Statement st = con.createStatement();
            String allc=GetAllColumn(con, st);
            String b[] = new String[50];
        
            String id = request.getParameter("id").trim();
            System.out.println(id + "id");
         String st1="";
             st1 = request.getParameter("st");
            System.out.println(st1 + "st1");
            System.out.println(st1 + "st1st1st1st1st1st1st1st1");
           
            String query = "select  * from register  where id='"+id+"'";

            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            String[] carray = new String[60];
            int column_count = 0;
             GetidDetails a1 = new GetidDetails();
            while (rs.next()) {
              

                a1.c0 = rs.getString(1);
                //  a1.c1 = carray[1] + " : " + rs.getString(2);
                a1.c1 = rs.getString(3);
                System.out.println("a1.c1"+a1.c1);
                a1.c2 = rs.getString(4);
                a1.c3 = rs.getString(5);
                a1.c4 = rs.getString(6);
                a1.c5 = rs.getString(7);
                a1.c6 = rs.getString(8);
                a1.c7 = rs.getString(9);
                a1.c8 = rs.getString(10);
                a1.c9 = rs.getString(11);
                a1.c10 = rs.getString(12);
                a1.c11 = rs.getString(13);
                a1.c12 = rs.getString(14);
                a1.c13 = rs.getString(15);
                a1.c14 = rs.getString(16);
                a1.c15 = rs.getString(17);
                a1.c16 = rs.getString(18);
                a1.c17 = rs.getString(19);
                a1.c18 = rs.getString(20);
                a1.c19 = rs.getString(21);
                a1.c20 = rs.getString(22);
                a1.c21 = rs.getString(23);
                a1.c22 = rs.getString(24);

                a1.c23 = rs.getString(25);
                a1.c24 = rs.getString(26);
                a1.c25 = rs.getString(27);
                a1.c26 = rs.getString(28);
                a1.c27 = rs.getString(29);
                a1.c28 = rs.getString(30);
                a1.c29 = rs.getString(31);

                a1.c30 = rs.getString(32);
                a1.c31 = rs.getString(33);


                  a1.c32 = rs.getString(34);
                a1.c33 = rs.getString(35);
                a1.c34 = rs.getString(36);
                   a1.c35 = rs.getString(37);
                      a1.c36 = rs.getString(38);
                        a1.c37 = rs.getString(39);
           
             
    
                a1.c50 = carray[50];
                a1.c51 = rs.getString("document");
                a1.c53 = rs.getString("status");
                
                System.out.println("a1.c53"+a1.c53);
                a1.c54 = rs.getString("updated_on");
                a1.c52 =allc;// GetAllColumn(con, st);
            } 
Gson gson = new GsonBuilder().create();
            String jsonArray = gson.toJson(a1);
            //out.println(messages); 
            out.write(jsonArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            out.println("{\"Error\": \"True\" ,\"Message\": \"Request Failed\" ,\"status\": \"Failed\"  }");
            e.printStackTrace();
        }

    }
 public String GetAllColumn(Connection con, Statement st) throws SQLException {

        String query = "select top 1 * from register  ";

        System.out.println(query);
        ResultSet rs31 = st.executeQuery(query);
        String[] carray = new String[60];
        int column_count = 0;
        while (rs31.next()) {
            column_count = Integer.parseInt(rs31.getString("column_count").trim());
            System.out.println(column_count);
            for (int i = 0; i < column_count + 4; i++) {

                if (i == 0) {
                    carray[i] = "id";
                } else {
                    carray[i] = rs31.getString(i + 1);
                }
                //System.out.println(carray[i]);
                carray[50] = rs31.getString("column_count");
                carray[51] = rs31.getString("document");

            }
        }
        String query1 = "select * from register where id=2 ";

        System.out.println(query1);
        ResultSet rs41 = st.executeQuery(query1);
        String[] darray = new String[60];

        while (rs41.next()) {
            for (int i = 0; i < column_count + 4; i++) {

                if (i == 0) {
                    darray[i] = "number";
                } else {
                    darray[i] = rs41.getString(i + 1);
                }
                //   System.out.println(darray[i]);
                darray[50] = rs41.getString("column_count");
                darray[51] = rs41.getString("document");
            }
        }

        String carrayCombine = Arrays.toString(carray);

        String darrayCombine = Arrays.toString(darray);

        return carrayCombine + "#" + darrayCombine;

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
    private String c52, c53,c35,c36,c37;
}
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sakshamapp123
 */
public class AllUsers extends HttpServlet {

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

        try {
            PrintWriter out = response.getWriter();
            con = Util.getConnection();
            st = con.createStatement();
            //////////////////////////////// get column name start 
            String query = "select * from register limit 1 ";

            System.out.println(query);
            ResultSet rs1 = st.executeQuery(query);
            String[] carray = new String[500];
            int column_count = 0;
            while (rs1.next()) {
                column_count = Integer.parseInt(rs1.getString("column_count").trim());
                System.out.println(column_count);
                for (int i = 0; i < column_count + 4; i++) {

                    if (i == 0) {
                        carray[i] = "id";
                    } else {
                        carray[i] = rs1.getString(i + 1);
                    }
                    //System.out.println(carray[i]);
                    carray[50] = rs1.getString("column_count");
                    carray[51] = rs1.getString("document");

                }
            }
            String roll = "";
            String username = request.getParameter("username");
            System.out.print(username);
           
            String q = "select * from register where c1='" + username + "'";
            System.out.print(q);
            ResultSet rs2 = st.executeQuery(q);
            while (rs2.next()) {
                roll = rs2.getString("roll");
            }
            System.out.println(roll);
          
            
            query = "select * from register where id in (" + roll + ")  ";
            System.out.print(query);
            ArrayList rData = new ArrayList();
            System.out.print(query);
            String[][] rp = new String[50][15];//3 row and 3 column             
            System.out.print(57);
            int i = 0;
            //  out.println(query);
            ResultSet rs = st.executeQuery(query);
            System.out.print(61);
            ArrayList<AllUsers> a = new ArrayList<>();
            while (rs.next()) {

                AllUsers a1 = new AllUsers();

                a1.c0 = rs.getString(1);
                //  a1.c1 = carray[1] + " : " + rs.getString(2);
                a1.c1 = rs.getString(3);
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

                a1.c50 = carray[50];
                a1.c51 = rs.getString("document");
 //a1.c52 = GetAllColumn(  con, st );
 a1.c52 = GetAllColumn( );
                a.add(a1);
            }
            Gson gson = new GsonBuilder().create();
            String jsonArray = gson.toJson(a);
            //out.println(messages); 
            out.write(jsonArray);
        } catch (Exception e) {
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

    
    public String GetAllColumn() throws SQLException
    {
          Connection con1 = null;
        Statement st1 = null;
        try {
            con1 = Util.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(AllUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
            st1 = con1.createStatement();
           String query = "select * from register limit 1 ";

            System.out.println(query);
            ResultSet rs3 = st1.executeQuery(query);
            String[] carray = new String[60];
            int column_count = 0;
            while (rs3.next()) {
                column_count = Integer.parseInt(rs3.getString("column_count").trim());
                System.out.println(column_count);
                for (int i = 0; i < column_count + 4; i++) {

                    if (i == 0) {
                        carray[i] = "id";
                    } else {
                        carray[i] = rs3.getString(i + 1);
                    }
                    //System.out.println(carray[i]);
                    carray[50] = rs3.getString("column_count");
                    carray[51] = rs3.getString("document");

                }
            }
            String query1 = "select * from register where id=2 ";

            System.out.println(query1);
            ResultSet rs4 = st1.executeQuery(query1);
            String[] darray = new String[60];

            while (rs4.next()) {
                for (int i = 0; i < column_count + 4; i++) {

                    if (i == 0) {
                        darray[i] = "number";
                    } else {
                        darray[i] = rs4.getString(i + 1);
                    }
                    //   System.out.println(darray[i]);
                    darray[50] = rs4.getString("column_count");
                    darray[51] = rs4.getString("document");
                }
            } 
 
            String carrayCombine = Arrays.toString(carray);

            String darrayCombine = Arrays.toString(darray);

             return carrayCombine + "#" + darrayCombine;
            
    }
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

    private String c11;
    private String c12;
    private String c13;
    private String c14;
    private String c15;
    private String c16;
    private String c17, c20, c18, c19, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c50, c51;
 private String c52;
}

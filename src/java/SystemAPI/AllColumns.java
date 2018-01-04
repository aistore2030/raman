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
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author panel2
 */
public class AllColumns extends HttpServlet {

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
            ResultSet rs = st.executeQuery(query);
            String[] carray = new String[500];
 int column_count =0;
            while (rs.next()) {
                 column_count = Integer.parseInt(rs.getString("column_count").trim());
                System.out.println(column_count);
                for (int i = 0; i < column_count + 4; i++) {

                    if (i == 0) {
                        carray[i] = "id";
                    } else {
                        carray[i] = rs.getString(i + 1);
                    }
                    //System.out.println(carray[i]);
                    carray[50] = rs.getString("column_count");
                     carray[51] = rs.getString("document");
                    
                }
            }
            String query1 = "select * from register where id=2 ";

            System.out.println(query1);
            ResultSet rs11 = st.executeQuery(query1);
            String[] darray = new String[500];

            while (rs11.next()) {
                for (int i = 0; i < column_count + 4; i++) {

                    if (i == 0) {
                        darray[i] = "number";
                    } else {
                        darray[i] = rs11.getString(i + 1);
                    }
                 //   System.out.println(darray[i]);
                    darray[50] = rs11.getString("column_count");
                      darray[51] = rs11.getString("document");
                }
            }
            String roll = null;
            /////////////////////// get coulumn name end
            //   String query = "";
           
           
            ArrayList rData = new ArrayList();
            System.out.print(query);
            String[][] rp = new String[50][15];//3 row and 3 column             
            System.out.print(57);
            int i = 0;
            //  out.println(query);
         
            System.out.print(61);
            ArrayList<AllColumns> a = new ArrayList<>();
         

                AllColumns a1 = new AllColumns();

                a1.c0 = carray[0]+ " :"+darray[0];
                //  a1.c1 = carray[1] + " : " + rs.getString(2);
                a1.c1 = carray[2] + " :" + darray[2];
                a1.c2 = carray[3] + " :" + darray[3];
                a1.c3 = carray[4] + " :" + darray[4];
                a1.c4 = carray[5] + " :" + darray[5];
                a1.c5 = carray[6] + " :" + darray[6];
                a1.c6 = carray[7] + " :" + darray[7];
                a1.c7 = carray[8]  + " :" + darray[8];
                a1.c8 = carray[9]  + " :" + darray[9];
                a1.c9 = carray[10] + " :" + darray[10];
                a1.c10 = carray[11]  + " :" + darray[11];
                a1.c11 = carray[12] + " :" + darray[12];
                a1.c12 = carray[13] + " :" + darray[13];
                a1.c13 = carray[14] + " :" + darray[14];
                a1.c14 = carray[15]+ " :" + darray[15];
                a1.c15 = carray[16]  + " :" + darray[16];
                a1.c16 = carray[17]  + " :" + darray[17];
                a1.c17 = carray[18] + " :" + darray[18];
                a1.c18 = carray[19] + " :" + darray[19];
                a1.c19 = carray[20]  + " :" + darray[20];
                a1.c20 = carray[21]  + " :" + darray[21];
                a1.c21 = carray[22] + " :" + darray[22];
                a1.c22 = carray[23]  + " :" + darray[23];

                a1.c23 = carray[24]  + " :" + darray[24];
                a1.c24 = carray[25] + " :" + darray[25];
                a1.c25 = carray[26] + " :" + darray[26];
                a1.c26 = carray[27]  + " :" + darray[27];
                a1.c27 = carray[28]  + " :" + darray[28];
                a1.c28 = carray[29]  + " :" + darray[29];
                a1.c29 = carray[30]  + " :" + darray[30];

                a1.c30 = carray[31] + " :" + darray[31];
                a1.c31 = carray[32]  + " :" + darray[32];

                a1.c50 = carray[50];
                a1.c51 = carray[51] + " :" + darray[51];

                a.add(a1);
            
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
    private String c17, c20, c18, c19,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33,c34,c50,c51;
}

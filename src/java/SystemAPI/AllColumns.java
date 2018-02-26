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
import java.util.Arrays;
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
            String[] carray = new String[60];
            int column_count = 0;
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
            String[] darray = new String[60];

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

            String[] testArray = {"Apple", "Banana", "Carrots"};

            String carrayCombine = Arrays.toString(carray);

            String darrayCombine = Arrays.toString(darray);

            a1.a0 = carrayCombine + "$" + darrayCombine;

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
    String a0;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;
    private String a10;

    private String a11;
    private String a12;
    private String a13;
    private String a14;
    private String a15;
    private String a16;
    private String a17, a20, a18, a19, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a50, a51;
}
